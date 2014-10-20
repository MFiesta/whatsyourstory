package com.example.si543.whatsyourstory;
//Stephanie Wooten

        import android.app.Activity;
        import android.app.ActionBar;
        import android.app.Fragment;
        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.ViewGroup;
        import android.os.Build;

public class MessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
    }
    //public void Messaging(View, view) {
        //insert intent code for launching sms application
        //code below is based on solutions from Stack Overflow but are untested
    //    Intent msgIntent = new Intent(Intent.ACTION_VIEW);
    //    msgIntent.setData(Uri.parse("sms:"));
    //    startActivity(msgIntent);
    //}
}



