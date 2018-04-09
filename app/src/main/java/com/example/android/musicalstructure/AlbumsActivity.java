package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

public class AlbumsActivity extends AppCompatActivity {

    /**
     * Copyright for "no_album_art" by CmdRobot
     * https://cmdrobot.deviantart.com/art/No-album-art-no-cover-placeholder-picture-458050685
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        //create the list of activity_albums if not already done
        if (SongCollection.albumList == null)
            SongCollection.createAlbumList();

        //use list of activity_albums to fill GridView
        GridView gridView = findViewById(R.id.album_grid);
        AlbumAdapter itemsAdapter = new AlbumAdapter(this, SongCollection.albumList);
        gridView.setAdapter(itemsAdapter);


        //Set onClickListener for menu bar items

        // Find the View that shows the song list
        TextView songs = findViewById(R.id.menu_song_list);
        // Set a click listener on that View
        songs.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the activity_songs category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link SongsActivity}
                Intent songsIntent = new Intent(AlbumsActivity.this, SongsActivity.class);
                // Start the new activity
                startActivity(songsIntent);
            }
        });

        //If a song was already selected, also allow to switch to the Now Playing activity
//        if (SongCollection.nowPlaying != null){
//            TextView nowPlaying = findViewById(R.id.menu_playing);
//            nowPlaying.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View view) {
//                    Intent playingIntent = new Intent(MainActivity.this, NowPlayingActivity.class);
//                    startActivity(playingIntent);
//                }
//            });
//        }



    }
}
