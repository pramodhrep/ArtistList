package com.falcondevelopers.artistlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etArtistName;
    Button btAddArtist;
    Spinner spinnerGenres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etArtistName = (EditText) findViewById(R.id.etArtistName);
        btAddArtist = (Button) findViewById(R.id.btAddArtist);
        spinnerGenres = (Spinner) findViewById(R.id.spinnerGenres);

        btAddArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addArtist();
            }
        });
    }

    private void addArtist(){
         String artistName = etArtistName.getText().toString().trim();
         String genre = spinnerGenres.getSelectedItem().toString();

         if(!TextUtils.isEmpty(artistName)){

         }else{
             Toast.makeText(this, "Please enter artist name",Toast.LENGTH_SHORT).show();
         }
    }
}
