package com.dawanse.ieltsforall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class DashboardActivity extends AppCompatActivity {
    private RelativeLayout _sevenTutorialBtn, _resourcesBtn, _counselingBtn;
    private LinearLayout _readingBtn, _writingBtn, _listeningBtn, _speakingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        _sevenTutorialBtn = findViewById(R.id.dashboard_tutorial_rl);
        _resourcesBtn = findViewById(R.id.dashboard_resources);
        _counselingBtn = findViewById(R.id.dashboard_counseling);
        _readingBtn = findViewById(R.id.dashboard_reading);
        _writingBtn = findViewById(R.id.dashboard_writing);
        _listeningBtn = findViewById(R.id.dashboard_listening);
        _speakingBtn = findViewById(R.id.dashboard_speaking);

        _sevenTutorialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                sevenTutorial();
            }
        });

        _resourcesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                resourcesIELTS();
            }
        });

        _counselingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                counselingIELTS();
            }
        });

        _readingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingIELTS();
            }
        });

        _writingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                writingIELTS();
            }
        });

        _speakingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                speakingIELTS();
            }
        });

        _listeningBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                listeningIELTS();
            }
        });

    }

    private void sevenTutorial() {
        //
    }

    private void resourcesIELTS() {
        //
    }

    private void counselingIELTS() {
        //
    }

    private void readingIELTS() {
        //
        Intent speakingIntent = new Intent(getApplicationContext(), ReadingIELTS.class);
        speakingIntent.putExtra("destination", "reading");
        startActivity(speakingIntent);
    }

    private void writingIELTS() {
        //
    }

    private void speakingIELTS() {
        //
        Intent speakingIntent = new Intent(getApplicationContext(), ReadingIELTS.class);
        speakingIntent.putExtra("destination", "speaking");
        startActivity(speakingIntent);
    }

    private void listeningIELTS() {
        //
    }
}
