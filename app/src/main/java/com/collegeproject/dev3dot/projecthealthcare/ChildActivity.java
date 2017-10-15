package com.collegeproject.dev3dot.projecthealthcare;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ChildActivity extends AppCompatActivity {
    RadioButton radio1;
    RadioButton radio2;
    RadioGroup rGroup;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_child);

        radio1 = (RadioButton) findViewById(R.id.radioFiveYears);
        radio2 = (RadioButton) findViewById(R.id.radioTweleveYears);
        //radio3 = (RadioButton)findViewById(R.id.radioOneYear);
        rGroup = (RadioGroup) findViewById(R.id.radioGroupChild);
        next = (Button) findViewById(R.id.buttonNext);
        // final Intent m5intent = new Intent(BabyActivity.this,FoodPlanActivity.class);

        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (radio1.isChecked()) {

                            AlertDialog.Builder malertDialogBuilder = new AlertDialog.Builder(ChildActivity.this);
                            View mView = getLayoutInflater().inflate(R.layout.child_5to12_dialog, null);
                            final Button btnsubmit = (Button) mView.findViewById(R.id.button);

                            malertDialogBuilder.setView(mView);
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

                            AlertDialog.Builder malertDialogBuilder = new AlertDialog.Builder(ChildActivity.this);
                            View mView2 = getLayoutInflater().inflate(R.layout.child_12to18_dialog, null);
                            final Button btnsubmit = (Button) mView2.findViewById(R.id.button);

                            malertDialogBuilder.setView(mView2);
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


                    }
                });
            }
        });
    }
}
