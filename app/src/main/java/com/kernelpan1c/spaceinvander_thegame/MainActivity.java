package com.kernelpan1c.spaceinvander_thegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean isMute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        findViewById(R.id.play_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(MainActivity.this, game_activity.class ) );
            }
        });

        TextView highscoreText = findViewById(R.id.high_score_label);

        SharedPreferences sharedPreferences = getSharedPreferences( "game", MODE_PRIVATE);
        highscoreText.setText("Highscore: " + sharedPreferences.getInt("highscore", 0));

        isMute = sharedPreferences.getBoolean( "isMute", false);

        ImageView volume_control = findViewById(R.id.volume_control);

        if ( isMute )
            volume_control.setImageResource( R.drawable.ic_baseline_volume_off_24 );
        else
            volume_control.setImageResource( R.drawable.ic_baseline_volume_up_24 );

        volume_control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isMute = !isMute;
                if ( isMute )
                    volume_control.setImageResource( R.drawable.ic_baseline_volume_off_24 );
                else
                    volume_control.setImageResource( R.drawable.ic_baseline_volume_up_24 );

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean( "isMute", isMute);
                editor.apply();

            }
        });
    }
}