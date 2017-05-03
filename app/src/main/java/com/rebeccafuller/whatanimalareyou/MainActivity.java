package com.rebeccafuller.whatanimalareyou;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView question1;
    private TextView question2;
    private TextView question3;
    private TextView question4;
    private TextView question5;
    private TextView question6;
    private TextView question7;
    private TextView question8;

    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;

    private Button button1;
    private Button button2;

    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
    private String answer6;
    private String answer7;
    private String answer8;

    private String animal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question1 = (TextView) findViewById(R.id.textView);
        question2 = (TextView) findViewById(R.id.textView2);
        question3 = (TextView) findViewById(R.id.textView3);
        question4 = (TextView) findViewById(R.id.textView4);
        question5 = (TextView) findViewById(R.id.textView5);
        question6 = (TextView) findViewById(R.id.textView6);
        question7 = (TextView) findViewById(R.id.textView7);
        question8 = (TextView) findViewById(R.id.textView8);

        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);

        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button2.setClickable(false);

        setSpinners();

        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer1 = spinner1.getSelectedItem().toString();
                answer2 = spinner2.getSelectedItem().toString();
                answer3 = spinner3.getSelectedItem().toString();
                answer4 = spinner4.getSelectedItem().toString();
                setSpinners();
                question1.setVisibility(View.INVISIBLE);
                question2.setVisibility(View.INVISIBLE);
                question3.setVisibility(View.INVISIBLE);
                question4.setVisibility(View.INVISIBLE);

                question5.setVisibility(View.VISIBLE);
                question6.setVisibility(View.VISIBLE);
                question7.setVisibility(View.VISIBLE);
                question8.setVisibility(View.VISIBLE);

                button1.setVisibility(View.INVISIBLE);
                button1.setClickable(false);
                button2.setVisibility(View.VISIBLE);
                button2.setClickable(true);
            }
        };
        button1.setOnClickListener(listener1);

        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer5 = spinner1.getSelectedItem().toString();
                answer6 = spinner2.getSelectedItem().toString();
                answer7 = spinner3.getSelectedItem().toString();
                answer8 = spinner4.getSelectedItem().toString();
                String[] answers = {answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8};
                Quiz quiz = new Quiz(answers);
                animal = quiz.getAnimal();
                if (animal == null) {
                    animal = "dolphin";
                }

                Bundle bundle = new Bundle();
                bundle.putString("animal", animal);
                intent(bundle);
            }
        };
        button2.setOnClickListener(listener2);

    }

    private void setSpinners() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinnerArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
        spinner4.setAdapter(adapter);
    }

    private void intent(Bundle bundle) {
        Intent intent = new Intent(this, FinalActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
