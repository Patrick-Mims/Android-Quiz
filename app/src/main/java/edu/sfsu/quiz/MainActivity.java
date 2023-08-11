package edu.sfsu.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}