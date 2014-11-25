package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.provider.MediaStore;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Environment;
import android.widget.Button;
import android.content.ActivityNotFoundException;
import java.io.File;
import android.content.pm.ResolveInfo;
import android.content.ComponentName;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.List;

import java.io.FileNotFoundException;
import java.io.InputStream;

//Stephanie Wooten
//Michelle Fiesta - SharedPreferences functionality 11/23
//Alice Rhee - Picture functionality 11/24

public class SetMyInitProfileActivity extends Activity {

    private Uri mImageCaptureUri;
    private ImageView mImageView;
    private TextView editPictureTextView;

    private static final int PICK_FROM_CAMERA = 1;
    private static final int CROP_FROM_CAMERA = 2;
    private static final int PICK_FROM_FILE = 3;

    //private final int SELECT_PHOTO = 1;
    //private ImageView imageView;

    //Full name, title, company, location EditText
    EditText edit_full_name;
    EditText edit_current_title;
    EditText edit_current_company;
    EditText edit_current_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_init_profile_settings);

        //Full name, title, company, location input text
        edit_full_name = (EditText) findViewById(R.id.edit_full_name);
        edit_current_title = (EditText) findViewById(R.id.edit_current_title);
        edit_current_company = (EditText) findViewById(R.id.edit_current_company);
        edit_current_location = (EditText) findViewById(R.id.edit_current_location);

        final String [] items			= new String [] {"Take from camera", "Select from gallery"};
        ArrayAdapter<String> adapter	= new ArrayAdapter<String> (this, android.R.layout.select_dialog_item,items);
        AlertDialog.Builder builder		= new AlertDialog.Builder(this);

        builder.setTitle("Select Image");
        builder.setAdapter( adapter, new DialogInterface.OnClickListener() {
            public void onClick( DialogInterface dialog, int item ) { //pick from camera
                if (item == 0) {
                    Intent intent 	 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    mImageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),
                            "tmp_avatar_" + String.valueOf(System.currentTimeMillis()) + ".jpg"));

                    intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);

                    try {
                        intent.putExtra("return-data", true);

                        startActivityForResult(intent, PICK_FROM_CAMERA);
                    } catch (ActivityNotFoundException e) {
                        e.printStackTrace();
                    }
                } else { //pick from file
                    Intent intent = new Intent();

                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);

                    startActivityForResult(Intent.createChooser(intent, "Complete action using"), PICK_FROM_FILE);
                }
            }
        } );

        final AlertDialog dialog = builder.create();

        editPictureTextView = (TextView) findViewById(R.id.edit_picture);
        mImageView		= (ImageView) findViewById(R.id.default_picture);

        editPictureTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) return;

        switch (requestCode) {
            case PICK_FROM_CAMERA:
                doCrop();

                break;

            case PICK_FROM_FILE:
                mImageCaptureUri = data.getData();

                doCrop();

                break;

            case CROP_FROM_CAMERA:
                Bundle extras = data.getExtras();

                if (extras != null) {
                    Bitmap photo = extras.getParcelable("data");

                    mImageView.setImageBitmap(photo);
                }

                File f = new File(mImageCaptureUri.getPath());

                if (f.exists()) f.delete();

                break;

        }
    }

    private void doCrop() {
        final ArrayList<CropOption> cropOptions = new ArrayList<CropOption>();

        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setType("image/*");

        List<ResolveInfo> list = getPackageManager().queryIntentActivities( intent, 0 );

        int size = list.size();

        if (size == 0) {
            Toast.makeText(this, "Can not find image crop app", Toast.LENGTH_SHORT).show();

            return;
        } else {
            intent.setData(mImageCaptureUri);

            intent.putExtra("outputX", 200);
            intent.putExtra("outputY", 200);
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("scale", true);
            intent.putExtra("return-data", true);

            if (size == 1) {
                Intent i 		= new Intent(intent);
                ResolveInfo res	= list.get(0);

                i.setComponent( new ComponentName(res.activityInfo.packageName, res.activityInfo.name));

                startActivityForResult(i, CROP_FROM_CAMERA);
            } else {
                for (ResolveInfo res : list) {
                    final CropOption co = new CropOption();

                    co.title 	= getPackageManager().getApplicationLabel(res.activityInfo.applicationInfo);
                    co.icon		= getPackageManager().getApplicationIcon(res.activityInfo.applicationInfo);
                    co.appIntent= new Intent(intent);

                    co.appIntent.setComponent( new ComponentName(res.activityInfo.packageName, res.activityInfo.name));

                    cropOptions.add(co);
                }

                CropOptionAdapter adapter = new CropOptionAdapter(getApplicationContext(), cropOptions);

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Choose Crop App");
                builder.setAdapter( adapter, new DialogInterface.OnClickListener() {
                    public void onClick( DialogInterface dialog, int item ) {
                        startActivityForResult(cropOptions.get(item).appIntent, CROP_FROM_CAMERA);
                    }
                });

                builder.setOnCancelListener( new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel( DialogInterface dialog ) {

                        if (mImageCaptureUri != null ) {
                            getContentResolver().delete(mImageCaptureUri, null, null );
                            mImageCaptureUri = null;
                        }
                    }
                } );

                AlertDialog alert = builder.create();

                alert.show();
            }
        }
    }



    public class CropOption {
        public CharSequence title;
        public Drawable icon;
        public Intent appIntent;
    }

        //imageView = (ImageView)findViewById(R.id.default_picture);

        //TextView EditPicture = (TextView) findViewById(R.id.edit_picture);
        //EditPicture.setOnClickListener(new View.OnClickListener() {

        //    @Override
        //    public void onClick(View view) {
        //        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        //        photoPickerIntent.setType("image/*");
        //        startActivityForResult(photoPickerIntent, SELECT_PHOTO);
        //    }
        //})
    //}

    //@Override
    //protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
    //    super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

    //    switch(requestCode) {
    //        case SELECT_PHOTO:
    //            if(resultCode == RESULT_OK){
    //                try {
    //                    final Uri imageUri = imageReturnedIntent.getData();
    //                    final InputStream imageStream = getContentResolver().openInputStream(imageUri);
    //                   final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
    //                    imageView.setImageBitmap(selectedImage);
    //               } catch (FileNotFoundException e) {
    //                    e.printStackTrace();
    //                    Toast.makeText(getApplicationContext(), "Image capture failed",
    //                            Toast.LENGTH_SHORT).show();
    //                }

    //            }
    //    }

    //}

    public void MyInitProfileNext(View view) {
        //Putting SharedPreferences for full name, title, company, and location
        SharedPreferences sharedPreferences=getSharedPreferences("ProfActData", Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("fullname", edit_full_name.getText().toString());
        editor.putString("title", edit_current_title.getText().toString());
        editor.putString("company", edit_current_company.getText().toString());
        editor.putString("location", edit_current_location.getText().toString());

        //Committing SharedPreferences
        editor.apply();

        Intent MyInitProfileNext = new Intent(this, ChooseSkillsActivity.class);
        startActivity(MyInitProfileNext);

        /**
         * Finishes the activity, destroys it, takes user to ChooseSkillsActivity to continue
         * filling out profile
         */

    }

}