package com.rebeccafuller.whatanimalareyou;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner1, spinner2, spinner3, spinner4, spinner5, spinner6, spinner7, spinner8;

    private Button backButton, forwardButton;

    private ConstraintLayout layout1, layout2;

    private String answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8;

    private String animal, name;
    int page;

    AdView ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");

        ad = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        ad.loadAd(adRequest);

        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5 = (Spinner) findViewById(R.id.spinner5);
        spinner6 = (Spinner) findViewById(R.id.spinner6);
        spinner7 = (Spinner) findViewById(R.id.spinner7);
        spinner8 = (Spinner) findViewById(R.id.spinner8);

        backButton = (Button) findViewById(R.id.button);
        forwardButton = (Button) findViewById(R.id.button2);
        forwardButton.setClickable(false);

        layout1 = (ConstraintLayout) findViewById(R.id.layout1);
        layout2 = (ConstraintLayout) findViewById(R.id.layout2);

        layout2.setVisibility(View.INVISIBLE);
        setSpinners();
        page = 1;

        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (page == 1) {
                    page++;

                    answer1 = spinner1.getSelectedItem().toString();
                    answer2 = spinner2.getSelectedItem().toString();
                    answer3 = spinner3.getSelectedItem().toString();
                    answer4 = spinner4.getSelectedItem().toString();

                    layout1.setVisibility(View.INVISIBLE);
                    layout2.setVisibility(View.VISIBLE);
                    backButton.setVisibility(View.VISIBLE);
                } else if (page == 2) {
                    answer5 = spinner5.getSelectedItem().toString();
                    answer6 = spinner6.getSelectedItem().toString();
                    answer7 = spinner7.getSelectedItem().toString();
                    answer8 = spinner8.getSelectedItem().toString();

                    String[] answers = {answer1, answer2, answer3, answer4, answer5, answer5, answer6, answer7, answer8, answer8};

                    Quiz quiz = new Quiz(answers);
                    animal = quiz.getAnimal();
                    intent(animal, name);
                }
            }
        };
        forwardButton.setOnClickListener(listener1);

        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout2.setVisibility(View.INVISIBLE);
                layout1.setVisibility(View.VISIBLE);
                backButton.setVisibility(View.INVISIBLE);
            }
        };
        backButton.setOnClickListener(listener2);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.retryItem:
                retryIntent();
                break;
            case R.id.aboutItem:
                showDialog();
                break;
            default:
                break;
        }

        return true;
    }

    public void showDialog() {
        AboutFragmentDialog myDiag = new AboutFragmentDialog();
        myDiag.show(getFragmentManager(), "Diag");
    }

    private void retryIntent() {
        Intent intent = new Intent(this, FrontActivity.class);
        startActivity(intent);
    }

    private void setSpinners() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinnerArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
        spinner4.setAdapter(adapter);
        spinner5.setAdapter(adapter);
        spinner6.setAdapter(adapter);
        spinner7.setAdapter(adapter);
        spinner8.setAdapter(adapter);
    }

    private void intent(String animal, String name) {
        Intent intent = new Intent(this, FinalActivity.class);
        intent.putExtra("animal", animal);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}
