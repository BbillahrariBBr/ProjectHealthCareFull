package com.collegeproject.dev3dot.projecthealthcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FoodPlanActivity extends AppCompatActivity {

    RadioButton rMale;
    RadioButton rFemale;
    RadioButton rChild;
    RadioButton rBaby;

    Button btnNext;
    RadioGroup rGroupFoodPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_food_plan);

        rMale = (RadioButton) findViewById(R.id.radioMale);
        rFemale = (RadioButton) findViewById(R.id.radioFemale);
        rChild = (RadioButton) findViewById(R.id.radiochild);
        rBaby = (RadioButton) findViewById(R.id.radioBaby);

        btnNext = (Button) findViewById(R.id.buttonNext);
        rGroupFoodPlan = (RadioGroup) findViewById(R.id.radioGroupFoodPlan);

        rGroupFoodPlan.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes final int i) {
                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (rMale.isChecked()) {
                            Intent mintent = new Intent(FoodPlanActivity.this, MaleActivity.class);
                            startActivity(mintent);
                        }

                        if (rFemale.isChecked()) {
                            Intent fintent = new Intent(FoodPlanActivity.this, FemaleActivity.class);
                            startActivity(fintent);
                        }

                        if (rChild.isChecked()) {
                            Intent cintent = new Intent(FoodPlanActivity.this, ChildActivity.class);
                            startActivity(cintent);
                        }

                        if (rBaby.isChecked()) {
                            Intent bintent = new Intent(FoodPlanActivity.this, BabyActivity.class);
                            startActivity(bintent);
                        }
                    }
                });

            }
        });
    }
}
