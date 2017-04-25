package localhost.ass_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // call the quiz activity
    public void takeQuiz(View view){
        Intent intent = new Intent(this,Questionnaire.class);
        startActivity(intent);
    }
}
