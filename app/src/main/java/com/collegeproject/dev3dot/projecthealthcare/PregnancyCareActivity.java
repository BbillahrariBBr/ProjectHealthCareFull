package com.collegeproject.dev3dot.projecthealthcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.collegeproject.dev3dot.projecthealthcare.Advice.AdviceListActivity;
import com.collegeproject.dev3dot.projecthealthcare.Exercise.ExerciseListActivity;
import com.collegeproject.dev3dot.projecthealthcare.Food.FoodListActivity;
import com.collegeproject.dev3dot.projecthealthcare.Labour.LabourListActivity;

public class PregnancyCareActivity extends AppCompatActivity implements View.OnClickListener {

    //Button primaryTreatmentBtn;
    Button foodBtn;
    Button exerciseBtn;
    Button labourBtn;
    Button adviceBtn;
   // Button appointmetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_pregnancy_care);

        foodBtn = (Button) findViewById(R.id.food_btn);
        exerciseBtn = (Button) findViewById(R.id.exercise_btn);
        labourBtn = (Button) findViewById(R.id.labour_btn);
        adviceBtn = (Button) findViewById(R.id.advice_btn);
        //appointmetBtn = (Button) findViewById(R.id.button_appointment);


        //primaryTreatmentBtn.setOnClickListener(this);
        foodBtn.setOnClickListener(this);
        exerciseBtn.setOnClickListener(this);
        labourBtn.setOnClickListener(this);
        adviceBtn.setOnClickListener(this);
        //appointmetBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {


        if (view.getId() == R.id.food_btn) {
            Intent intent = new Intent(PregnancyCareActivity.this, FoodListActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.exercise_btn) {
            Intent intent = new Intent(PregnancyCareActivity.this, ExerciseListActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.labour_btn) {
            Intent intent = new Intent(PregnancyCareActivity.this, LabourListActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.advice_btn) {
            Intent intent = new Intent(PregnancyCareActivity.this, AdviceListActivity.class);
            startActivity(intent);
        } //else if (view.getId() == R.id.button_appointment) {

            //Intent intent = new Intent(PregnancyCareActivity.this,MixedlActivity.class);
            ////startActivity(intent);
//            Intent intent = new Intent(PregnancyCareActivity.this, PreferenceActivity.class);
//            startActivity(intent);
        //}

    }
}
