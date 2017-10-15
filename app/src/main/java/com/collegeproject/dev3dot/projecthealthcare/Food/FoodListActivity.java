package com.collegeproject.dev3dot.projecthealthcare.Food;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.collegeproject.dev3dot.projecthealthcare.Adapter.CustomAdapter;
import com.collegeproject.dev3dot.projecthealthcare.R;
import com.collegeproject.dev3dot.projecthealthcare.RowItem;

import java.util.ArrayList;
import java.util.List;



public class FoodListActivity extends AppCompatActivity {

    ListView listViewTV;
    TypedArray pictures;
    String[] nameTV;
    String[] detailsTV;

    List<RowItem> rowItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_list_view);

        rowItems = new ArrayList<RowItem>();
        pictures = getResources().obtainTypedArray(R.array.foodPictures);
        nameTV = getResources().getStringArray(R.array.foodName);
        detailsTV = getResources().getStringArray(R.array.foodDetails);

        for (int i = 0; i < nameTV.length; i++) {
            RowItem item = new RowItem(nameTV[i], pictures.getResourceId(i, -1));
            rowItems.add(item);
        }

        listViewTV = (ListView) findViewById(R.id.fiveContent_listView);

        CustomAdapter adapter = new CustomAdapter(this, rowItems);
        listViewTV.setAdapter(adapter);

        listViewTV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(FoodListActivity.this, FoodDetails.class);


                intent.putExtra("image", pictures.getResourceId(i, -1));
                intent.putExtra("name", nameTV[i]);
                intent.putExtra("details", detailsTV[i]);
                startActivity(intent);
            }
        });
    }
}

