package com.dawanse.ieltsforall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.dawanse.ieltsforall.db.Task;
import com.dawanse.ieltsforall.db.TaskDatabase;

public class ReadingIELTS extends AppCompatActivity {

    private RelativeLayout readingTask11Btn,readingTask12Btn, readingTask13Btn, readingTask21Btn, readingTask22Btn, readingTask23Btn;
    private RelativeLayout readingTask31Btn, readingTask32Btn, readingTask33Btn, readingTask41Btn, readingTask42Btn, readingTask43Btn;
    private RelativeLayout readingTask51Btn, readingTask52Btn, readingTask53Btn, readingTask61Btn, readingTask62Btn, readingTask63Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_ielts);

        String comingFrom = getIntent().getStringExtra("destination");
        if (comingFrom.equals("reading")) {
            readingAction();
        } else if (comingFrom.equals("speaking")) {
            speakingAction();

        }


    }

    private void readingTask(String taskID) {
        Intent readingIntent = new Intent(getApplicationContext(), ReadingTask.class);
        readingIntent.putExtra("reading_taskID", taskID);
        startActivity(readingIntent);
    }

    private void addData() {
        final TaskDatabase taskDatabase = TaskDatabase.getInstance(this);
        final Task task = new Task(getString(R.string.reading_task1_header), getString(R.string.reading_task1_pretitle),
                getString(R.string.reading_task1_title), getString(R.string.reading_task1_passage));

//        taskDatabase.taskDao().insertTask(task);
        /*new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                taskDatabase.taskDao().insertTask(task);
                return null;
            }
        }.execute();*/
        new DatabaseAsync().execute();

    }

    private class DatabaseAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //Perform pre-adding operation here.
        }

        @Override
        protected Void doInBackground(Void... voids) {

            final Task task = new Task("task11", getString(R.string.reading_task1_header), getString(R.string.reading_task1_pretitle),
                    getString(R.string.reading_task1_title), getString(R.string.reading_task1_passage));
            final TaskDatabase taskDatabase = TaskDatabase.getInstance(getApplicationContext());

            //Now access all the methods defined in DaoAccess with sampleDatabase object
            taskDatabase.taskDao().insertTask(task);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            //To after addition operation here.
        }
    }


    //Reading UI
    private void readingAction() {
        readingUI();

        readingTask11Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task11");
            }
        });

        readingTask12Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task12");
            }
        });

        readingTask13Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task13");
            }
        });

        readingTask21Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task21");
            }
        });

        readingTask22Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task22");
            }
        });

        readingTask23Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task23");
            }
        });

        readingTask31Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task31");
            }
        });

        readingTask32Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task32");
            }
        });

        readingTask33Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task33");
            }
        });

        readingTask41Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task41");
            }
        });

        readingTask42Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task42");
            }
        });

        readingTask43Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task43");
            }
        });

        readingTask51Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task51");
            }
        });

        readingTask52Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task52");
            }
        });

        readingTask53Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task53");
            }
        });

        readingTask61Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task61");
            }
        });

        readingTask62Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task62");
            }
        });

        readingTask63Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task63");
            }
        });
    }

    private void speakingAction() {
        speakingUI();

        readingTask11Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task11");
            }
        });

        readingTask12Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task12");
            }
        });

        readingTask13Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task13");
            }
        });

        readingTask21Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task21");
            }
        });

        readingTask22Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task22");
            }
        });

        readingTask23Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task23");
            }
        });

        readingTask31Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task31");
            }
        });

        readingTask32Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task32");
            }
        });

        readingTask33Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task33");
            }
        });

        readingTask41Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task41");
            }
        });

        readingTask42Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task42");
            }
        });

        readingTask43Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                readingTask("task43");
            }
        });
    }

    private void readingUI() {

        findViewById(R.id.reading_task_five).setVisibility(View.VISIBLE);
        findViewById(R.id.reading_task_six).setVisibility(View.VISIBLE);

        readingTask11Btn = findViewById(R.id.reading_task11);
        readingTask12Btn = findViewById(R.id.reading_task12);
        readingTask13Btn = findViewById(R.id.reading_task13);
        readingTask21Btn = findViewById(R.id.reading_task21);
        readingTask22Btn = findViewById(R.id.reading_task22);
        readingTask23Btn = findViewById(R.id.reading_task23);
        readingTask31Btn = findViewById(R.id.reading_task31);
        readingTask32Btn = findViewById(R.id.reading_task32);
        readingTask33Btn = findViewById(R.id.reading_task33);
        readingTask41Btn = findViewById(R.id.reading_task41);
        readingTask42Btn = findViewById(R.id.reading_task42);
        readingTask43Btn = findViewById(R.id.reading_task43);
        readingTask51Btn = findViewById(R.id.reading_task51);
        readingTask52Btn = findViewById(R.id.reading_task52);
        readingTask53Btn = findViewById(R.id.reading_task53);
        readingTask61Btn = findViewById(R.id.reading_task61);
        readingTask62Btn = findViewById(R.id.reading_task62);
        readingTask63Btn = findViewById(R.id.reading_task63);
    }

    private void speakingUI() {
        readingTask11Btn = findViewById(R.id.reading_task11);
        readingTask12Btn = findViewById(R.id.reading_task12);
        readingTask13Btn = findViewById(R.id.reading_task13);
        readingTask21Btn = findViewById(R.id.reading_task21);
        readingTask22Btn = findViewById(R.id.reading_task22);
        readingTask23Btn = findViewById(R.id.reading_task23);
        readingTask31Btn = findViewById(R.id.reading_task31);
        readingTask32Btn = findViewById(R.id.reading_task32);
        readingTask33Btn = findViewById(R.id.reading_task33);
        readingTask41Btn = findViewById(R.id.reading_task41);
        readingTask42Btn = findViewById(R.id.reading_task42);
        readingTask43Btn = findViewById(R.id.reading_task43);

        findViewById(R.id.reading_task_five).setVisibility(View.GONE);
        findViewById(R.id.reading_task_six).setVisibility(View.GONE);
    }
}
