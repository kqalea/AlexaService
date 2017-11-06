package com.ecs.alexaservice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,AlexaService.class);
        startService(intent);

        final Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = getApplicationContext();
                Intent intent = new Intent(mContext, AlexaService.class);
                intent.putExtra("COMMAND", 1);
                startService(intent);
            }
        });
        final Button joke = findViewById(R.id.joke);
        joke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = getApplicationContext();
                Intent intent = new Intent(mContext, AlexaService.class);
                intent.putExtra("COMMAND", 2);
                startService(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        Context mContext = getApplicationContext();
        Intent intent = new Intent(mContext, AlexaService.class);
        intent.putExtra("COMMAND", 0);
        super.onDestroy();

    }

}
