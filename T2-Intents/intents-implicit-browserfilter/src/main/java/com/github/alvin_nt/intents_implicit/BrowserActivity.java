package com.github.alvin_nt.intents_implicit;

import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import java.net.URL;


public class BrowserActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // allow network access in the UI thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        
        setContentView(R.layout.activity_browser);
        
        Intent intent = getIntent();
        WebView web = (WebView) findViewById(R.id.webView);
        
        String action = intent.getAction();
        if(!action.equals(Intent.ACTION_VIEW)) {
            throw new RuntimeException("Should not happen");
        }
        
        // get the data
        Uri data = intent.getData();
        if(data != null) {
            URL url;
            try {
                url = new URL(data.getScheme(), data.getHost(), data.getPath());
                web.loadUrl(url.toString());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_browser, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
