package com.blooot.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by roger on 4/18/2016.
 */
public class CheatActivity extends Activity {

    public static final String EXTRA_ANSWER_IS_TRUE = "com.blooot.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "com.bloot.geoquiz.answer_shown";


    private static final String KEY_ANSWER_SHOWN = "answer_shown";


    private boolean mAnswerIsTrue;
    private boolean mAnswerShown;

    private TextView mAnswerTextView;
    private Button mShowAnswerButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        if (savedInstanceState != null) {
            mAnswerShown = savedInstanceState.getBoolean(KEY_ANSWER_SHOWN);
        }else{
            mAnswerShown = false;
        }


        setAnswerShownResult();

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView)findViewById(R.id.answer_text_view);
        mShowAnswerButton = (Button)findViewById(R.id.show_answer_button);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAnswerShown = true;
                if (mAnswerIsTrue){
                    mAnswerTextView.setText(R.string.true_button);
                }else{
                    mAnswerTextView.setText(R.string.false_button);
                }
                setAnswerShownResult();
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putBoolean(KEY_ANSWER_SHOWN, mAnswerShown);
    }

    private void setAnswerShownResult(){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, mAnswerShown);
        setResult(RESULT_OK, data);
    }

}
