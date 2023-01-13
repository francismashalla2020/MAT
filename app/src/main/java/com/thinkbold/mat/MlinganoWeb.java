package com.thinkbold.mat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MlinganoWeb extends AppCompatActivity {
    WebView webView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mlingano_web);

        webView = findViewById(R.id.mlinganoWeb);
        progressBar = findViewById(R.id.progressBar);

        webView.setWebViewClient(new MlinganoWeb.WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl("https://ibold.africa/matisite2/igurusi");
    }

    public class WebViewClient extends android.webkit.WebViewClient{

        public void onPageStarted (WebView view, String url, Bitmap favicon){
            super.onPageStarted(view, url, favicon);
        }
        public boolean shouldOverideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return  true;
        }

        public void onPageFinished(WebView view, String url){
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);

        }
    }
    public void onBackPressed(){
        if (webView.canGoBack()){
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
    public void mlinganoButton(View view) {
        switch (view.getId()){
            case R.id.aboutview:
                Intent aboutActivity = new Intent(this, About.class);
                startActivity(aboutActivity);
                break;
            case R.id.messageView:
                Intent messageActivity = new Intent(this, GeneralContact.class);
                startActivity(messageActivity);
                break;
            case R.id.homes:
                Intent intentHome = new Intent(this, Icolleges.class);
                startActivity(intentHome);
                break;
            case R.id.calls:
                Intent callIntent = new Intent(Intent.ACTION_CALL); //use ACTION_CALL class
                callIntent.setData(Uri.parse("tel:+255262321407"));    //this is the phone number calling
                //check permission
                //If the device is running Android 6.0 (API level 23) and the app's targetSdkVersion is 23 or higher,
                //the system asks the user to grant approval.
                if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    //request permission from user if the app hasn't got the required permission
                    ActivityCompat.requestPermissions(this,
                            new String[]{android.Manifest.permission.CALL_PHONE},   //request specific permission from user
                            10);
                    return;
                }else {     //have got permission
                    try{
                        startActivity(callIntent);  //call activity and make phone call
                    }
                    catch (android.content.ActivityNotFoundException ex){
                        Toast.makeText(this.getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.emails:
                String []email = {"ps@kilimo.go.tz"};
                Intent sendEmail = new Intent(Intent.ACTION_SEND);
                sendEmail.setType("rfc/822");
                sendEmail.putExtra(Intent.EXTRA_EMAIL, email);
                startActivity(Intent.createChooser(sendEmail, "Send Email to PS Kilimo"));
                break;
            case R.id.shareBtn:
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