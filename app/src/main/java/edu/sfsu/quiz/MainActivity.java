package edu.sfsu.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.internal.TextDrawableHelper;

import java.util.ArrayList;
import java.util.List;

import edu.sfsu.quiz.models.Question;

public class MainActivity extends AppCompatActivity {
    private int index = 0;
    private TextView questionTextView;
    public List<Question> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item = new ArrayList<>();

        item.add(index, new Question(R.string.question_africa, false, R.drawable.baseline_filter_5_24));
        item.add(index, new Question(R.string.question_asia, true, R.drawable.baseline_filter_4_24));
        item.add(index, new Question(R.string.question_australia, false, R.drawable.baseline_filter_3_24));
        item.add(index, new Question(R.string.question_china, true, R.drawable.baseline_filter_2_24));
        item.add(index, new Question(R.string.question_europe, false, R.drawable.baseline_filter_1_24));

        int question = item.get(index).getId();

        questionTextView = (TextView) findViewById(R.id.question_text_view);
        questionTextView.setText(question);

        Button true_button = (Button) findViewById(R.id.true_btn);
        Button false_button = (Button) findViewById(R.id.false_btn);

        true_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        false_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        Button nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                ImageView imageView = (ImageView) findViewById(R.id.img);
                index = (index + 1) % item.size();
                imageView.setImageDrawable(getResources().getDrawable(item.get(index).getIcon()));

                nextQuestion();
            }
        });
        nextQuestion();
    }

    public void nextQuestion() {
        int question = item.get(index).getId();
        questionTextView.setText(question);
    }

    public void checkAnswer(boolean userPressedTrue) {

        boolean answerIsTrue = item.get(index).isTrue();

        int messageId = 0;

        if(userPressedTrue == answerIsTrue) {
            messageId = R.string.correct_answer;
        } else {
            messageId = R.string.wrong_answer;
        }

        Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show();
    }
}