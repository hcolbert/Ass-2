package localhost.ass_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;

public class Questionnaire extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);
        //String testString = stmDB.getQuestion(1,1);
        //Log.d("DBTest", testString);
    }

    public void goToQuizSection1(View view){
        Intent intent = new Intent(this, quiz_section_1.class);
        startActivity(intent);
    }

}
