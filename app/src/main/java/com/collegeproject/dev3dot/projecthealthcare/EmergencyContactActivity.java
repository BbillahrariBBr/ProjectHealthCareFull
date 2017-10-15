package com.collegeproject.dev3dot.projecthealthcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class EmergencyContactActivity extends AppCompatActivity {
    Button button_ambulance;
    Button button_hospital;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_emergency_contact);
        button_ambulance = (Button) findViewById(R.id.button_ambulance);
        button_hospital = (Button) findViewById(R.id.button_hospital);

//        button_ambulance.setOnClickListener(EmergencyContactActivity.this);
//        button_hospital.setOnClickListener(EmergencyContactActivity.this);
    }

//    @Override
//    public void onClick(View view) {
//
//        if (view.getId() == R.id.button_ambulance) {
//            Intent intent = new Intent(EmergencyContactActivity.this, AmbulanceEmergency.class);
//            startActivity(intent);
//
//        } else if (view.getId() == R.id.button_hospital) {
//            Intent intent = new Intent(EmergencyContactActivity.this, HospitalEmergency.class);
//            startActivity(intent);
//        }
//
    //}

    public void OnButtonClickListenerEmergency(View view) {

        if (view.getId() == R.id.button_ambulance) {
            Intent ambulanceIntent = new Intent(EmergencyContactActivity.this, AmbulanceEmergency.class);
            startActivity(ambulanceIntent);

        }
        if (view.getId() == R.id.button_hospital) {
            Intent hospitalIntent = new Intent(EmergencyContactActivity.this, HospitalEmergency.class);
            startActivity(hospitalIntent);

        }

    }


}

