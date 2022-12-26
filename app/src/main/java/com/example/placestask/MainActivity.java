package com.example.placestask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   // ArrayList<String> places = new ArrayList<>();
    ArrayList<Place> places = new ArrayList<Place>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listview1 = findViewById(R.id.listview1);
        /*
        // Adding places :
        places.add("Pyramids of Giza");
        places.add("Egyptian Museum");
        places.add("Abu Simbel");
        places.add("Philae Temple");
         */
        places.add(new Place("Pyramids" , R.drawable.pyramids));
        places.add(new Place("Egyptian Museum" , R.drawable.egymuseusm));
        places.add(new Place("Abu Simbel" , R.drawable.abusimbel));
        places.add(new Place("Philae Temple" , R.drawable.philae));

        /*
        // Creating Adapter :
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,places);
        listview1.setAdapter(adapter);
        */
        PlacesAdapter adapter = new PlacesAdapter(this,R.layout.placeicon,places);
        listview1.setAdapter(adapter);

        //Clicking actions :
        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Intent choice = new Intent(MainActivity.this,PyramidsActivity.class);
                    startActivity(choice);
                }
                else if (i == 1){
                    Intent choice = new Intent(MainActivity.this,MuseumActivity.class);
                    startActivity(choice);
                }
                else if (i == 2){
                    Intent choice = new Intent(MainActivity.this,SimbelActivity.class);
                    startActivity(choice);
                }
                else if (i == 3){
                    Intent choice = new Intent(MainActivity.this,PhilaeActivity.class);
                    startActivity(choice);
                }
            }
        });
    }
}