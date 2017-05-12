package localhost.ass_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public DbHelper stmDB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // instantiate the database
        stmDB = new DbHelper(this);
        // use only to insert new or changed data - requires database version to be incremented
//        stmDB.insertData();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("DBTest - section 1 size", " " + stmDB.getQuestionSectionSize(1));
        Log.d("DBTest - section 2 size", " " + stmDB.getQuestionSectionSize(2));
        Log.d("DBTest - section 3 size", " " + stmDB.getQuestionSectionSize(3));
        Log.d("DBTest - table size ", String.valueOf(stmDB.getTableSize()));
    }

    // call the add task activity
    public void addTask(View view)
    {
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivity(intent);
    }

    // call the manage tasks activity
    public void manageTasks(View view)
    {
        Intent intent = new Intent(this,ManageTasksActivity.class);
        startActivity(intent);
    }

    // call the quiz activity
    public void takeQuiz(View view)
    {
        Intent intent = new Intent(this,QuestionnaireInfoActivity.class);
        startActivity(intent);
    }
}
