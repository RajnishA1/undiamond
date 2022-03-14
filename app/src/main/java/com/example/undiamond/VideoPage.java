package com.example.undiamond;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class VideoPage extends AppCompatActivity {
YouTubePlayerView youTubePlayerView;
    @Override
    public void onDestroy() {
        super.onDestroy();
        youTubePlayerView.release();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_page);
        youTubePlayerView = findViewById(R.id.youtube_player_view);


    }
}