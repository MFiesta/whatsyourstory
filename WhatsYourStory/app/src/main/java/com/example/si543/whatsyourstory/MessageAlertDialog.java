package com.example.si543.whatsyourstory;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Stephanie Wooten on 12/8/14.
 */
public class MessageAlertDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //creates MessageAlert box warning that user is going to leave the app for SMS messaging
        builder.setTitle(("Send Message"));
        builder.setMessage("This will take you outside of this app to your phone's texting feature. Is that okay?");
        //allows user to hit "Cancel" which will take them back to the OtherUserProfile
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

            }
        });
        //user says it's okay to go to SMS messaging - takes them to SMS messaging
        builder.setPositiveButton(R.string.send_message, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

                //calls sms messaging on phone
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.putExtra("address", "555-555-5555");
                sendIntent.setType("vnd.android-dir/mms-sms");
                startActivity(sendIntent);

            }
        });
        Dialog dialog=builder.create();

        return dialog;
    }
}
