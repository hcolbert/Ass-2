package localhost.ass_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class QuestionnaireActivity extends AppCompatActivity {

    public DbHelper stmDB;
    public int sectionNumber = 1;
    public int questionNumber = 1;
    public TextView vt_question;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        stmDB = new DbHelper(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);
        vt_question = (TextView) findViewById(R.id.questionView);
        setQuestionText(stmDB.getQuestion(sectionNumber, questionNumber));
    }

    public void setQuestionText(String s)
    {
        vt_question.setText(s);
    }

    public void onClickNext(View v)
    {
        if(questionNumber < stmDB.getQuestionSectionSize(sectionNumber)){
            questionNumber++;
            setQuestionText(stmDB.getQuestion(sectionNumber, questionNumber));
        }
        else{
            if(sectionNumber < 3){
                sectionNumber++;
                questionNumber = 1;
                setQuestionText(stmDB.getQuestion(sectionNumber, questionNumber));
            }

        }
    }
}
