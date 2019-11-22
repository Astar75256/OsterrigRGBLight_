package com.astar.rgblighting.screen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.astar.rgblighting.R;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, ColorActivity.class);
        context.startActivity(starter);
    }
}
