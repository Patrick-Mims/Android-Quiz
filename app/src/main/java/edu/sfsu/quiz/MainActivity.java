package edu.sfsu.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import edu.sfsu.quiz.models.Question;

public class MainActivity extends AppCompatActivity {
    private int index = 0;
    private Button nextButton;
    private TextView questionTextView;
    private Question[] questions = new Question[] {
            new Question(R.string.question_africa, false),
            new Question(R.string.question_asia, true),
            new Question(R.string.question_australia, false),
            new Question(R.string.question_china, true),
            new Question(R.string.question_europe, false),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get a reference to the question_text_view
        int question = questions[index].getId();

        questionTextView = (TextView) findViewById(R.id.question_text_view);
        questionTextView.setText(question);

        Button true_button = (Button) findViewById(R.id.true_btn);
        Button false_button = (Button) findViewById(R.id.false_btn);

        true_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), R.string.correct_answer, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL,0, 0);
                toast.show();
            }
        });

        false_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(MainActivity.this, R.string.wrong_answer, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL,0, 0);
                toast.show();
            }
        });

        nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = (index + 1) % questions.length;
                nextQuestion();
            }
        });
        nextQuestion();
    }

    public void nextQuestion() {
        int question = questions[index].getId();
        questionTextView.setText(question);
    }
}