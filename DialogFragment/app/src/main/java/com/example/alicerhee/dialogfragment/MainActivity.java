package com.example.alicerhee.dialogfragment;

/**
 * Created by alicerhee on 11/11/14.
 */

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

        Button dfragbutton = (Button) findViewById(R.id.dfragbutton);
        Button alertdfragbutton = (Button) findViewById(R.id.alertdfragbutton);
        FragmentManager fm = getSupportFragmentManager();

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // Get the view from activity_main.xml
            setContentView(R.layout.activity_main);

            // Locate the button in activity_main.xml

            // Capture button clicks
            dfragbutton.setOnClickListener(new OnClickListener() {
                public void onClick(View arg0) {
                    DFragment dFragment = new DFragment();
                    // Show DialogFragment
                    dFragment.show(fm, "Dialog Fragment");
                }
            });

            // Capture button clicks
            alertdfragbutton.setOnClickListener(new OnClickListener() {
                public void onClick(View arg0) {
                    AlertDFragment alertdFragment = new AlertDFragment();
                    // Show Alert DialogFragment
                    alertdFragment.show(fm, "Alert Dialog Fragment");
                }
            });
        }
    }

