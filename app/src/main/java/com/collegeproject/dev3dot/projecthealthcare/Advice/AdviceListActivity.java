package com.collegeproject.dev3dot.projecthealthcare.Advice;

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



public class AdviceListActivity extends AppCompatActivity {
    ListView listViewTV;
    TypedArray advPictures;
    String[] advNameTV;
    String[] advDetailsTV;

    List<RowItem> rowItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_list_view);

        rowItems = new ArrayList<>();
        advPictures = getResources().obtainTypedArray(R.array.advicePictures);
        advNameTV = getResources().getStringArray(R.array.adviceName);
        advDetailsTV = getResources().getStringArray(R.array.adviceDetails);

        listViewTV = (ListView) findViewById(R.id.fiveContent_listView);

        for (int i = 0; i < advNameTV.length; i++) {
            RowItem item = new RowItem(advNameTV[i], advPictures.getResourceId(i, -1));
            rowItems.add(item);
        }
        CustomAdapter adapter = new CustomAdapter(AdviceListActivity.this, rowItems);
        listViewTV.setAdapter(adapter);

        listViewTV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(AdviceListActivity.this, AdviceDetails.class);


                intent.putExtra("image", advPictures.getResourceId(i, -1));
                intent.putExtra("name", advNameTV[i]);
                intent.putExtra("details", advDetailsTV[i]);
                startActivity(intent);
            }
        });
    }
}

