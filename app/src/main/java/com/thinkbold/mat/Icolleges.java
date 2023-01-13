package com.thinkbold.mat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Icolleges extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_icolleges);
    }

    public void collegeButtons(View view) {
        switch (view.getId()){
            case R.id.aboutviewC:
                Intent intentabout = new Intent(Icolleges.this, About.class);
                startActivity(intentabout);
                break;
            case R.id.messageViewC:
                Intent intentmessage = new Intent(Icolleges.this, GeneralContact.class);
                startActivity(intentmessage);
                break;
            case R.id.matTengeru:
                Intent intentTengeru = new Intent(Icolleges.this, TengeruWeb.class);
                startActivity(intentTengeru);
                break;
            case R.id.matIgurusi:
                Intent intentIgurusi = new Intent(Icolleges.this, IgurusiWeb.class);
                startActivity(intentIgurusi);
                break;
            case R.id.matIlonga:
                Intent intentIlonga = new Intent(Icolleges.this, IlongaWeb.class);
                startActivity(intentIlonga);
                break;
            case R.id.matInyara:
                Intent intentInyara = new Intent(Icolleges.this, InyaraWeb.class);
                startActivity(intentInyara);
                break;
            case R.id.matKatrin:
                Intent intentKatrin = new Intent(this, KatrinWeb.class);
                startActivity(intentKatrin);
                break;
            case R.id.matKatc:
                Intent intentKatc = new Intent(this, KatcWeb.class);
                startActivity(intentKatc);
                break;
            case R.id.matMaruku:
                Intent intentMaruku = new Intent(this, MarukuWeb.class);
                startActivity(intentMaruku);
                break;
            case R.id.matMlingano:
                Intent intentMlingano = new Intent(this, MlinganoWeb.class);
                startActivity(intentMlingano);
                break;
            case R.id.matMtwara:
                Intent intentMtwara = new Intent(this, MtwaraWeb.class);
                startActivity(intentMtwara);
                break;
            case R.id.matMubondo:
                Intent intentMubondo = new Intent(this, MubondoWeb.class);
                startActivity(intentMubondo);
                break;
            case R.id.matNSI:
                Intent intentNsi = new Intent(this, NSIweb.class);
                startActivity(intentNsi);
                break;
            case R.id.matTumbi:
                Intent intentTumbi = new Intent(this, TumbiWeb.class);
                startActivity(intentTumbi);
                break;
            case R.id.matUkiriguru:
                Intent intentUki = new Intent(this, UkiriguruWeb.class);
                startActivity(intentUki);
                break;
            case R.id.matUyole:
                Intent intentUyole = new Intent(this, UyoleWeb.class);
                startActivity(intentUyole);
                break;
            case R.id.homesC:
                Intent intentHome = new Intent(Icolleges.this, HomeActivity.class);
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