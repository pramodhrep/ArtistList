package com.falcondevelopers.artistlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText etArtistName;
    Button btAddArtist;
    Spinner spinnerGenres;

    DatabaseReference dbArtists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbArtists = FirebaseDatabase.getInstance().getReference("artists");

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

             String id = dbArtists.push().getKey();

             Artist artist = new Artist(id, artistName, genre);

             dbArtists.child(id).setValue(artist);

             Toast.makeText(this,"Artist added!!!",Toast.LENGTH_SHORT).show();

         }else{
             Toast.makeText(this, "Please enter artist name",Toast.LENGTH_SHORT).show();
         }
    }
}
