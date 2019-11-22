package com.astar.rgblighting.screen;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.astar.rgblighting.R;
import com.astar.rgblighting.screen.device_list.DeviceListActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private static final long TIMETO = 1000;

    private ImageView splashImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen_activity);

        splashImage = findViewById(R.id.splashImage);

    }

    @Override
    protected void onStart() {
        super.onStart();

        splashImage.setBackgroundResource(R.drawable.splash_anim);
        AnimationDrawable animationDrawable = (AnimationDrawable) splashImage.getBackground();
        animationDrawable.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                DeviceListActivity.start(SplashScreenActivity.this);
                finish();
            }
        }, TIMETO);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.start_item:
                DeviceListActivity.start(this);
                break;
            case R.id.color_item:
                ColorActivity.start(this);
                break;
        }
        return true;
    }
}
