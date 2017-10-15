package com.collegeproject.dev3dot.projecthealthcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.collegeproject.dev3dot.projecthealthcare.PrimaryTreatment.PrimaryTreatmentListActivity;

//import com.collegeproject.dev3dot.projecthealthcare;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    // add Button
    private Button btnDiseaseDitection;
    private Button btnEmergencyContact;
    private Button btnFoodPlan;
    private Button btnPregnancyCare;
    private Button btnPrimaryTreatment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        btnDiseaseDitection = (Button) findViewById(R.id.button_disease_ditection);
        btnPregnancyCare = (Button) findViewById(R.id.button_pregnancy_care);
        btnEmergencyContact = (Button) findViewById(R.id.button_emergency_contacts);
        btnFoodPlan = (Button) findViewById(R.id.button_food_plan);
        btnPrimaryTreatment = (Button) findViewById(R.id.button_primary_treatment);


        btnDiseaseDitection.setOnClickListener(this);
        btnPregnancyCare.setOnClickListener(this);
        btnEmergencyContact.setOnClickListener(this);
        btnFoodPlan.setOnClickListener(this);
        btnPrimaryTreatment.setOnClickListener(this);
        // new PreferenceManager(this).clearPreference();
//        finish();
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_disease_ditection) {
            Intent disesIntent = new Intent(MainActivity.this, DiseaseDetectionActivity.class);
            startActivity(disesIntent);

        }
        if (view.getId() == R.id.button_primary_treatment) {
            Intent pIntent = new Intent(MainActivity.this, PrimaryTreatmentListActivity.class);
            startActivity(pIntent);
        }
        if (view.getId() == R.id.button_food_plan) {
            Intent foodIntent = new Intent(MainActivity.this, FoodPlanActivity.class);
            startActivity(foodIntent);

        }
        if (view.getId() == R.id.button_pregnancy_care) {
            Intent pregnancyIntent = new Intent(MainActivity.this, MixedlActivity.class);
            startActivity(pregnancyIntent);

        }
        if (view.getId() == R.id.button_emergency_contacts) {
            Intent econtactIntent = new Intent(MainActivity.this, EmergencyContactActivity.class);
            startActivity(econtactIntent);

        }
    }
}
