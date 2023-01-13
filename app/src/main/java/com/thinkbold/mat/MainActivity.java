package com.thinkbold.mat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // making it a full screen activity
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        displaySplash();
    }

    public void displaySplash() {
        Thread mythread = new Thread() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    // the amount of time splash screen should display
                    int displaytime = 5000;
                    int waittime = 0;
                    // count down the display time in the range specified
                    // e.g. 100 miliseconds
                    while (waittime < displaytime) {
                        sleep(100);
                        waittime = waittime + 100;
                    }

                    super.run();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                // after the splash screen loads its will automatically open
                // the class specified on the intent
                finally {
                    Intent a = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(a);
                    // add the statement finish(); to destroy the activity when
                    // the next class loads
                    finish();
                }
            }
        };
        mythread.start();
    }
}