package com.github.alvin_nt.tutorial2_intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.github.alvin_nt.tutorial2_intents.R;

/**
 * Created by Alvin Natawiguna on 2/7/2015.
 */
public class ResultActivity extends Activity {
    
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_result);
        
        Bundle extras = getIntent().getExtras();
        String value = extras.getString("sampleText");
        
        TextView view = (TextView) findViewById(R.id.displayIntentExtra);
        
        if(value != null)
            view.setText(value);
    }
    
    @Override
    public void finish() {
        Intent intent = new Intent();
        
        EditText edit = (EditText) findViewById(R.id.returnValue);
        String data = edit.getText().toString();
        
        intent.putExtra("returnText", data);
        setResult(RESULT_OK, intent);
        
        super.finish();
    }
}
