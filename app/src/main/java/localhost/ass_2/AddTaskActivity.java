package localhost.ass_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class AddTaskActivity extends AppCompatActivity
{
    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
    }

    // cancel the current task entry
    public void addTask(View view)
    {
        //scrape all of the data

        Log.d("", "TASK HAS BEEN ADDED");
        Log.d("","test");
    }

    // add the new task to the database
    public void cancelTask(View view)
    {
        Log.d("", "TASK HAS BEEN CANCELLED");
    }
}
