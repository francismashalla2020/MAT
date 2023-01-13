package com.thinkbold.mat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);
    }

    public void homeButtons(View view){
        switch (view.getId()){
            case R.id.aboutview:
                Intent aboutActivity = new Intent(HomeActivity.this, About.class);
                startActivity(aboutActivity);
                break;
            case R.id.messageView:
                Intent messageActivity = new Intent(HomeActivity.this, GeneralContact.class);
                startActivity(messageActivity);
                break;
            case R.id.buttonMATCoreWebsite:
                Intent matCoreWebsite = new Intent(HomeActivity.this, MatWebsite.class);
                startActivity(matCoreWebsite);
            case R.id.buttonMATmis:
                Intent matMiSWebsite = new Intent(HomeActivity.this, MatMis.class);
                startActivity(matMiSWebsite);
                break;
            case R.id.buttonMATWebsite:
                Intent matCollegeWebsite = new Intent(HomeActivity.this, Icolleges.class);
                startActivity(matCollegeWebsite);
                break;
            default:
        }

    }
}