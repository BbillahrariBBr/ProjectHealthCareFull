package com.collegeproject.dev3dot.projecthealthcare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;



public class AmbulanceEmergency extends AppCompatActivity {

    ListView ambulanceListView;
    String[] ambulanceName;
    String[] ambulancePlace;
    String[] ambulanceNumber;

    List<EmergencyRowItem> ambuRowItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_emergency_listview);


        ambuRowItems = new ArrayList<EmergencyRowItem>();
        ambulanceName = getResources().getStringArray(R.array.ambulanceName);
        ambulancePlace = getResources().getStringArray(R.array.ambulancePlace);
        ambulanceNumber = getResources().getStringArray(R.array.ambulancePhNumber);

        for (int i = 0; i < ambulanceName.length; i++) {
            EmergencyRowItem item = new EmergencyRowItem(ambulanceName[i], ambulancePlace[i], ambulanceNumber[i]);
            ambuRowItems.add(item);
        }

        ambulanceListView = (ListView) findViewById(R.id.emergencyListView);
        CustomAdapterEmergency ambulanceAdapter = new CustomAdapterEmergency(this, ambuRowItems);
        ambulanceListView.setAdapter(ambulanceAdapter);

    }
}
