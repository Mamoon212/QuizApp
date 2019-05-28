package com.mo2a.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Button falseButton;
    private Button trueButton;
    private Button nextButton;
    private TextView questionText;
    private CardView infoCard;
    private TextView infoText;
    private Question[] questionBank = new Question[]{
            new Question(R.string.q_ants, R.string.q_info_ants, true),
            new Question(R.string.q_oxford, R.string.q_info_oxford, true),
            new Question(R.string.q_soccer, R.string.q_info_soccer, false),
            new Question(R.string.q_rushmore, R.string.q_info_rushmore, false),
            new Question(R.string.q_hydra, R.string.q_info_hydra, true),
            new Question(R.string.q_submarine, R.string.q_info_submarine, true),
            new Question(R.string.q_morocco, R.string.q_info_morocco, false),
            new Question(R.string.q_haydn, R.string.q_info_haydn, true),
            new Question(R.string.q_inferno, R.string.q_info_inferno, true),
            new Question(R.string.q_russian, R.string.q_info_russian, true)
    };
    private int currentQ = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        falseButton = findViewById(R.id.button_false);
        trueButton = findViewById(R.id.button_true);
        nextButton = findViewById(R.id.button_next);
        questionText = findViewById(R.id.question_text_view);
        infoCard = findViewById(R.id.info_card);
        infoText = findViewById(R.id.info_text);

        showNextQuestion();

        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_false:
                checkAnswer(false);
                Log.d(TAG, "onClick: " + currentQ);
                break;
            case R.id.button_true:
                checkAnswer(true);
                Log.d(TAG, "onClick: " + currentQ);
                break;
            case R.id.button_next:
                showNextQuestion();
                infoCard.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }

    private void showNextQuestion() {
        if (currentQ < questionBank.length - 1) {
            currentQ++;
            questionText.setText(questionBank[currentQ].getAnswerId());
        } else {
            currentQ = -1;
            showNextQuestion();
        }
    }

    private void checkAnswer(boolean choseCorrect) {
        boolean answerIsTrue = questionBank[currentQ].isAnswerTrue();
        int toastMessageId;

        if (choseCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer;
        } else {
            toastMessageId = R.string.wrong_answer;
        }

        infoText.setText(questionBank[currentQ].getInfoId());
        infoCard.setVisibility(View.VISIBLE);
        Toast.makeText(MainActivity.this, toastMessageId, Toast.LENGTH_SHORT).show();
    }
}
