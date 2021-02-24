package edu.temple.imageassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

public class ImageActivity extends AppCompatActivity {

    ListView listView;
    ImageView imageView;
    Spinner spinner;
    int[] dogImagesArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        imageView = findViewById(R.id.imageView2);
        spinner =findViewById(R.id.spinner);

        String [] dogsArray = new String[]{"Blacklab","Bulldog","Bullmastiff","Rottweiler"};
        dogImagesArray = new int[]{R.drawable.blacklab, R.drawable.bulldog, R.drawable.bullmastiff, R.drawable.rottweiler};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dogsArray);


        listView.setAdapter(adapter);
        spinner.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showPicture(position);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                showPicture(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
        private void showPicture(int position){
            imageView.setImageResource(dogImagesArray[position]);
        }
}