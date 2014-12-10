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
public class ChooseSkillsTutorialDialog extends Dialog {




    private String name;

    EditText etName;

    public ChooseSkillsTutorialDialog(Context context, String name
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
        textDialogTitle.setText("Your Skills");
        TextView textDialogMessage = (TextView) findViewById(R.id.dialog_message);
        textDialogMessage.setText("Are you a master entrepreneur? Do you have a knack for microbrewing? Add those skills here!");
        Button buttonOK = (Button) findViewById(R.id.button_dialog);
        buttonOK.setOnClickListener(new OKListener());



    }

    private class OKListener implements android.view.View.OnClickListener {
        @Override
        public void onClick(View v) {
            ChooseSkillsTutorialDialog.this.dismiss();
        }
    }
}