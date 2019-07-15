package com.dawanse.ieltsforall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dawanse.ieltsforall.db.Task;
import com.dawanse.ieltsforall.db.TaskDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ReadingTask extends AppCompatActivity {

    private TextView header;
    private TextView pretitle;
    private TextView title;
    private TextView passage;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_task);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        header = findViewById(R.id.readingtask_header);
        pretitle = findViewById(R.id.readingtask_title_desc);
        title = findViewById(R.id.readingtask_title);
        passage = findViewById(R.id.readingtask_passage);

        final String incomingIntent = getIntent().getStringExtra("reading_taskID");

        //for room database
        final TaskDatabase taskDatabase = TaskDatabase.getInstance(this);
        /*new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                taskDatabase.taskDao().getTaskList();
                return null;
            }
        }.execute();*/


        /*titleDesc.setText(new Task().getPreTitle());
        taskTitle.setText(new Task().getTitle());
        taskPassage.setText(new Task().getPassage());*/

        databaseReference.child("reading").child(incomingIntent)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            String headerText = dataSnapshot.child("header").getValue().toString();
                            String pretitleText = dataSnapshot.child("pretitle").getValue().toString();
                            String titleText = dataSnapshot.child("title").getValue().toString();
                            String passageText = dataSnapshot.child("passage").getValue().toString();

                            header.setText(headerText);
                            pretitle.setText(pretitleText);
                            title.setText(titleText);
                            passage.setText(passageText);


                        } else {
                            Toast.makeText(ReadingTask.this, "Couldn't find a node to connect", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

    }
}
