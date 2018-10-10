package cyberbot.geoquiz;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class geo extends Activity
   {
    private Button mTrueB;
    private Button mFalseB;
    private Button mNextB;
    private TextView mbutton;
    private True[] mqbank=new True[]
            {

                    new True(R.string.delhi, true),
                    new True(R.string.Dehradun, true),
                    new True(R.string.DIT, true),

            };
    private int mCurrentIndex = 0;
    //private Button mtrueques;

    public void updateQuestion() {
        int question = mqbank[mCurrentIndex].getmQuestion();
        mbutton.setText(question);}
        private void checkAnswer ( boolean userPressedTrue){
            boolean answerIsTrue = mqbank[mCurrentIndex].ismTrueQuestion();

            int messageResId = 0;

            if (userPressedTrue == answerIsTrue) {
                messageResId = R.string.correct;
            } else {
                messageResId = R.string.False;
            }
            Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                    .show();
        }
        @Override
        protected void onCreate (Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.geoact);



        mbutton = (TextView) findViewById(R.id.questions);
        //int question = mqbank[mCurrentIndex].getQuestion();
        // mbutton.setText(question);
        mFalseB = (Button) findViewById(R.id.FalseB);
        mTrueB = (Button) findViewById(R.id.TrueB);
        mTrueB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast t = Toast.makeText(geo.this, R.string.correct, Toast.LENGTH_SHORT);
                //t.show();
                //t.LENGTH_SHORT).show();
                checkAnswer(true);
            }
        });
//        mFalseB = (Button) findViewById(R.id.FalseB);
        mFalseB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(geo.this, R.string.False, Toast.LENGTH_SHORT).show();
                //t.LENGTH_SHORT).show();
                checkAnswer(false);
            }


        });
        mNextB = (Button) findViewById(R.id.NextB);
        mNextB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCurrentIndex = (mCurrentIndex + 1) % mqbank.length;
                //int question = mqbank[mCurrentIndex].getQuestion();
                // mbutton.setText(question);
                updateQuestion();


            }
        });
        updateQuestion();


    }

}
