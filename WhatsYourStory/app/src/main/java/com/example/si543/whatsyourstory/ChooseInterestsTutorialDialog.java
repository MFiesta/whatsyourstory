package com.example.si543.whatsyourstory;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by chiahuihsieh on 12/8/14.
 */
public class ChooseInterestsTutorialDialog extends Dialog {




    private String name;

    EditText etName;

    public ChooseInterestsTutorialDialog(Context context, String name
    ) {
        super(context);
        this.name = name;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //dialog content - Layout, Title, Message, Button
        setContentView(R.layout.dialog_layout);
        TextView textDialogTitle = (TextView) findViewById(R.id.dialog_title);
        textDialogTitle.setText("Your Interests");
        TextView textDialogMessage = (TextView) findViewById(R.id.dialog_message);
        textDialogMessage.setText("What kind of stories are you interested in hearing about? Stories about pursuing specific career path? Living the foodie life? Select some interests here!");
        Button buttonOK = (Button) findViewById(R.id.button_dialog);
        buttonOK.setOnClickListener(new OKListener());



    }

    private class OKListener implements android.view.View.OnClickListener {
        @Override
        public void onClick(View v) {
            ChooseInterestsTutorialDialog.this.dismiss();
        }
    }
}