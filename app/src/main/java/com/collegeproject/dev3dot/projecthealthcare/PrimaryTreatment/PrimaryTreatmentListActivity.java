package com.collegeproject.dev3dot.projecthealthcare.PrimaryTreatment;

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



public class PrimaryTreatmentListActivity extends AppCompatActivity {

    ListView listViewTV;
    TypedArray pictures;
    String[] nameTV;
    String[] definationtv;
    String[] causesTV;
    String[] symptomsTV;
    String[] toDoTV;
    List<RowItem> rowItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_list_view);

        rowItems = new ArrayList<RowItem>();
        pictures = getResources().obtainTypedArray(R.array.primaryTreatmentPictures);
        nameTV = getResources().getStringArray(R.array.treatmentName);
        definationtv = getResources().getStringArray(R.array.primaryTreatmentDefination);
        causesTV = getResources().getStringArray(R.array.primaryTreatmentCauses);
        symptomsTV = getResources().getStringArray(R.array.primaryTreatmentSymptoms);
        toDoTV = getResources().getStringArray(R.array.primaryTreatmentToDo);


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

                Intent intent = new Intent(PrimaryTreatmentListActivity.this, PrimaryTreatmentActivity.class);


                intent.putExtra("image", pictures.getResourceId(i, -1));
                intent.putExtra("TreatmentName", nameTV[i]);
                intent.putExtra("TreatmentDefination", definationtv[i]);
                intent.putExtra("TreatmentCauses", causesTV[i]);
                intent.putExtra("TreatmentSymptoms", symptomsTV[i]);
                intent.putExtra("TreatmentToDo", toDoTV[i]);

                startActivity(intent);

            }
        });
    }
}

