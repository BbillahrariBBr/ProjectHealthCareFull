package com.collegeproject.dev3dot.projecthealthcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.collegeproject.dev3dot.projecthealthcare.Advice.AdviceListActivity;
import com.collegeproject.dev3dot.projecthealthcare.Exercise.ExerciseListActivity;
import com.collegeproject.dev3dot.projecthealthcare.Food.FoodListActivity;
import com.collegeproject.dev3dot.projecthealthcare.Labour.LabourListActivity;

public class MixedlActivity extends AppCompatActivity implements View.OnClickListener {

    Button appoinmentdate;
    Button menstrualdate;
    Button dudtae;
    Button pregGuide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_mixedl);

        appoinmentdate = (Button)findViewById(R.id.button_appointdate);
        menstrualdate = (Button)findViewById( R.id.button_mesntrual);
        dudtae = (Button)findViewById(R.id.button_duedate);

        pregGuide = (Button)findViewById(R.id.button_pregnancy_guide);

        appoinmentdate.setOnClickListener(this);
        menstrualdate.setOnClickListener(this);
        dudtae.setOnClickListener(this);
        pregGuide.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_appointdate) {
            Intent intent = new Intent(MixedlActivity.this, MonthConfirmationActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.button_duedate) {
            Intent intent = new Intent(MixedlActivity.this, Duedate.class);
            startActivity(intent);
        }

        else if (view.getId() == R.id.button_mesntrual) {

            Intent intent = new Intent(MixedlActivity.this, PreferenceActivity.class);
            startActivity(intent);
        }

        else if (view.getId() == R.id.button_pregnancy_guide) {
        Intent intent = new Intent(MixedlActivity.this, PregnancyCareActivity.class);
        startActivity(intent);
    }

    }
}
