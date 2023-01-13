package com.thinkbold.mat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class CollegeWebsites extends AppCompatActivity {

    ListView listColleges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_websites);
    }

    public void collegeButtons(View view) {
        switch (view.getId()){
            case R.id.aboutviewC:
                Intent intentabout = new Intent(CollegeWebsites.this, About.class);
                startActivity(intentabout);
                break;
            case R.id.messageViewC:
                Intent intentmessage = new Intent(CollegeWebsites.this, GeneralContact.class);
                startActivity(intentmessage);
                break;
            case R.id.homesC:
                Intent intentHome = new Intent(CollegeWebsites.this, HomeActivity.class);
                startActivity(intentHome);
                break;
            case R.id.shareBtnC:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/*");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Get latest information of MATI via https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName());
                startActivity(Intent.createChooser(shareIntent, "Share Using"));
                break;
            default:
        }
    }
}