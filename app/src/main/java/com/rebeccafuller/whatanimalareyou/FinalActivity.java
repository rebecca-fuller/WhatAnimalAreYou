package com.rebeccafuller.whatanimalareyou;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FinalActivity extends AppCompatActivity {
    private EditText animalSound;
    private ImageView animalImage;
    private TextView animalSoundText;
    private Button retryButton;
    private Button soundButton;

    private String animal;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

       Intent intent = getIntent();
        animal = intent.getStringExtra("animal");

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

        animalSound = (EditText) findViewById(R.id.editText);
        animalImage = (ImageView) findViewById(R.id.animalImageView);
        animalSoundText = (TextView) findViewById(R.id.textView10);
        retryButton = (Button) findViewById(R.id.button3);
        soundButton = (Button) findViewById(R.id.button4);

        animalImage.setImageResource(image);

        Toast.makeText(this, "Your animal is " + animal, Toast.LENGTH_SHORT).show();

        View.OnClickListener sound = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sound = String.valueOf(animalSound.getText());
                if (sound == null) {
                    Toast.makeText(FinalActivity.this, "Please enter a sound first.", Toast.LENGTH_SHORT).show();
                } else {
                    animalSoundText.setText(sound);
                    animalSoundText.setVisibility(View.VISIBLE);
                }
            }
        };
        soundButton.setOnClickListener(sound);

        final View.OnClickListener retry = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retryIntent();
            }
        };
        retryButton.setOnClickListener(retry);
    }

    private void retryIntent() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
