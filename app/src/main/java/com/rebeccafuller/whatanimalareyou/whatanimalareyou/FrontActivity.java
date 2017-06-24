package com.rebeccafuller.whatanimalareyou;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class FrontActivity extends AppCompatActivity {
    //App ID: ca-app-pub-4512522850424643~6442999216

    AdView ad;
    EditText nameET;
    Button goButton;

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        ad = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        ad.loadAd(adRequest);

        nameET = (EditText) findViewById(R.id.editText);
        goButton = (Button) findViewById(R.id.firstButton);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameET.getText().toString();
                if (name == "" || name == null) {
                    name = "Friend";
                }
                intent(name);
            }
        };
        goButton.setOnClickListener(listener);
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

    public void intent(String name) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}
