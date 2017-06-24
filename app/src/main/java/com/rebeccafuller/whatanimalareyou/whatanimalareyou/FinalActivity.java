package com.rebeccafuller.whatanimalareyou;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class FinalActivity extends AppCompatActivity {

    TextView conText, nameText;
    private ImageView animalImage;

    private String animal, name;
    private int image = (R.drawable.dolphin);

    AdView ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        ad = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        ad.loadAd(adRequest);

        conText = (TextView) findViewById(R.id.conTextView);
        nameText = (TextView) findViewById(R.id.nameTextView);

        Intent intent = getIntent();
        animal = intent.getStringExtra("animal");
        name = intent.getStringExtra("name");

        if (animal.equals("dolphin")) {
            image = R.drawable.dolphin;
        } else if (animal.equals("elephant")) {
            image = (R.drawable.elephant);
        } else if (animal.equals("monkey")) {
            image = (R.drawable.monkey);
        } else if (animal.equals("red panda")) {
            image = (R.drawable.redpanda);
        } else if (animal.equals("seagull")) {
            image = (R.drawable.seagull);
        } else if (animal.equals("snake")) {
            image = (R.drawable.snake);
        } else if (animal.equals("spider")) {
            image = (R.drawable.spider);
        } else if (animal.equals("tiger")) {
            image = (R.drawable.tiger);
        } else if (animal.equals("turtle")) {
            image = (R.drawable.turtle);
        } else if (animal.equals("whale")) {
            image = (R.drawable.whale);
        }


        animalImage = (ImageView) findViewById(R.id.animalImageView);

        animalImage.setImageResource(image);
        conText.setText("Congratulations " + name + "!");
        nameText.setText("You are an " + animal);
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
}
