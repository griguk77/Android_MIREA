package com.mycompany.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import android.net.Uri;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";
    static final String API = "API";
    static int SDK = 30;

    VideoView videoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoPlayer = findViewById(R.id.videoPlayer);
        Uri myVideoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.gf);
        videoPlayer.setVideoURI(myVideoUri);
        if (savedInstanceState != null) {
            SDK = savedInstanceState.getInt(API);
        } else {
            SDK = 30;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(API, Build.VERSION.SDK_INT);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void play(View view) {
        videoPlayer.start();
    }

    public void pause(View view) {
        videoPlayer.pause();
    }

    public void stop(View view) {
        videoPlayer.stopPlayback();
        videoPlayer.resume();
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!videoPlayer.isPlaying()) {
            play(videoPlayer);
        }
    }

    @Override
    public void onRestart() {
        super.onRestart();
        play(videoPlayer);
    }

    @Override
    public void onPause() {
        super.onPause();
        pause(videoPlayer);
    }

    @Override
    public void onStop() {
        super.onStop();
        stop(videoPlayer);
    }

    @Override
    public void onResume() {
        super.onResume();
        play(videoPlayer);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                openSearch();
                return true;
            case R.id.action_settings:
                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void openSettings() {

    }

    private void openSearch() {

    }
}