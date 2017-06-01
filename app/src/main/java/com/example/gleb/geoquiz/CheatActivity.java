package com.example.gleb.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    public static final String EXTRA_ANWER_IS_TRUE = "com.example.gleb.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "com.example.gleb.geoquiz.answer_shown";
    private boolean mAnswerIsTrue;
    private Button mShowAnswerButton;
    private TextView mAnswerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANWER_IS_TRUE,false);
        mAnswerTextView = (TextView)findViewById(R.id.answer_text_view);
        mShowAnswerButton = (Button)findViewById(R.id.show_answer_button);
        mShowAnswerButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                }
                else{
                    mAnswerTextView.setText(R.string.false_button);
                }

                setAnswerShownResult(true);
            }
        });
    }

    public static Intent newIntent (Context packageContext, boolean answerIsTrue) {
        Intent i = new Intent(packageContext,CheatActivity.class);
        i.putExtra(EXTRA_ANWER_IS_TRUE,answerIsTrue);
        return i;
    }

    private void setAnswerShownResult (boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK,data);
    }

    public  static boolean wasAnswerShown (Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN,false);
    }
}
