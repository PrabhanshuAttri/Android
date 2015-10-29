package com.prabhanshu.intentmessage;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class TargetActivity extends AppCompatActivity {
    String from;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        from = "From: ";
        message = "Message: ";


        Intent intent = getIntent();
        JSONObject paramObj;
        try {
            paramObj = new JSONObject(intent.getStringExtra(MainActivity.EXTRA_MESSAGE));
            from += paramObj.getString("from");
            message += paramObj.getString("message");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        TextView fromView = (TextView) findViewById(R.id.textFrom);
        fromView.setText(from);
        TextView messageView = (TextView) findViewById(R.id.textMessage);
        messageView.setText(message);
    }

}
