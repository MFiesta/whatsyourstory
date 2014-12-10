package com.example.si543.whatsyourstory;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by chiahuihsieh on 12/7/14.
 */
public class SetMyInitTutorialDialog extends Dialog {




    private String name;

    EditText etName;

    public SetMyInitTutorialDialog(Context context, String name
    ) {
        super(context);
        this.name = name;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //dialog content - Layout, Title, Message, Button
        setContentView(R.layout.dialog_tutorial_layout);
        TextView textDialogTitle = (TextView) findViewById(R.id.dialog_title);
        textDialogTitle.setText("About You");
        TextView textDialogMessage = (TextView) findViewById(R.id.dialog_message);
        textDialogMessage.setText("We’ll use the information you share on these next few pages to match you with people you may be interested in connecting with--and to people who may want to connect with you!");
        Button buttonOK = (Button) findViewById(R.id.button_dialog);
        buttonOK.setOnClickListener(new OKListener());
    }

    private class OKListener implements android.view.View.OnClickListener {
        @Override
        public void onClick(View v) {
            SetMyInitTutorialDialog.this.dismiss();
        }
    }
}
