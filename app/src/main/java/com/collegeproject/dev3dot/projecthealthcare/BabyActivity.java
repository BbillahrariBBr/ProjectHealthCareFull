package com.collegeproject.dev3dot.projecthealthcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class BabyActivity extends AppCompatActivity {

    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;
    RadioGroup rGroup;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_baby);

        radio1 = (RadioButton) findViewById(R.id.radioFivemonth);
        radio2 = (RadioButton) findViewById(R.id.radioSixMonth);
        radio3 = (RadioButton) findViewById(R.id.radioOneYear);
        rGroup = (RadioGroup) findViewById(R.id.radioGroupBaby);
        next = (Button) findViewById(R.id.buttonNext);
        final Intent m5intent = new Intent(BabyActivity.this, FoodPlanActivity.class);

        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (radio1.isChecked()) {

                            AlertDialog.Builder malertDialogBuilder = new AlertDialog.Builder(BabyActivity.this);
                            View m5monthsView = getLayoutInflater().inflate(R.layout.baby_5months_dialog, null);
                            final Button btnsubmit = (Button) m5monthsView.findViewById(R.id.button);

                            malertDialogBuilder.setView(m5monthsView);
                            final AlertDialog loginDialog = malertDialogBuilder.create();
                            loginDialog.show();
                            //loginDialog.dismiss()

                            btnsubmit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    loginDialog.dismiss();
                                    //startActivity(m5intent);

                                }
                            });

                        }

                        if (radio2.isChecked()) {

                            AlertDialog.Builder malertDialogBuilder = new AlertDialog.Builder(BabyActivity.this);
                            View m6monthsView = getLayoutInflater().inflate(R.layout.baby_6to12_dialog, null);
                            final Button btnsubmit = (Button) m6monthsView.findViewById(R.id.button);

                            malertDialogBuilder.setView(m6monthsView);
                            final AlertDialog loadingdialog2 = malertDialogBuilder.create();
                            loadingdialog2.show();
                            //loginDialog.dismiss()

                            btnsubmit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    loadingdialog2.dismiss();
                                    //startActivity(m5intent);

                                }
                            });

                        }

                        if (radio3.isChecked()) {
                            AlertDialog.Builder malertDialogBuilder = new AlertDialog.Builder(BabyActivity.this);
                            View m1YearView = getLayoutInflater().inflate(R.layout.baby_1to3_dialog, null);
                            final Button btnsubmit = (Button) m1YearView.findViewById(R.id.button);

                            malertDialogBuilder.setView(m1YearView);
                            final AlertDialog loadingdialog3 = malertDialogBuilder.create();
                            loadingdialog3.show();
                            //loginDialog.dismiss()

                            btnsubmit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    loadingdialog3.dismiss();
                                    //startActivity(m5intent);

                                }
                            });
                            ;
                        }


                    }
                });

            }
        });
    }
}
