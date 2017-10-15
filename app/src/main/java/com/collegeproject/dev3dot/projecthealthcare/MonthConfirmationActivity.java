package com.collegeproject.dev3dot.projecthealthcare;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MonthConfirmationActivity extends AppCompatActivity {

    EditText monthConfirm;
    Button submitMonth;
    TextInputLayout textInputLayoutMonth;
    int intedTxtVal;
    int maxMonth =9;
    int loopcount=0;
    ArrayList<String> dates = new ArrayList<String>();



    private TextSwitcher switcher;
    private Button btnPrvs;
    private  Button btnnxt;
    private int mPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_month_confirmation);

        monthConfirm = (EditText)findViewById(R.id.editTextMonthConfirmation);
        submitMonth = (Button)findViewById(R.id.buttonSubmitMonth);
        textInputLayoutMonth = (TextInputLayout)findViewById(R.id.textInputLayoutMonth);



        btnnxt = (Button)findViewById(R.id.buttonnxt);
        btnPrvs = (Button)findViewById(R.id.buttonprv);
        switcher = (TextSwitcher)findViewById(R.id.textSwitcher);

        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                TextView textView = new TextView(getApplicationContext());
                textView.setTextSize(34);
                return textView;
            }
        });

//        btnnxt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (mPosition<Text.length-1){
//                    mPosition= mPosition+1;
//                    switcher.setText(Text[mPosition]);
//
//                }
//            }
//        });
//
//        btnPrvs.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (mPosition>0){
//                    mPosition = mPosition-1;
//                    switcher.setText(Text[mPosition]);
//                }
//            }
//        });


    }
//    public void getCurrentDate(View view) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(calendar.DATE,30);
//        SimpleDateFormat mdformat = new SimpleDateFormat("dd / MM / yyyy ");
//        String strDate = "Current Date : " + mdformat.format(calendar.getTime());
//        display(strDate);
//    }
//
//    private void display(String num) {
//        TextView textView = (TextView) findViewById(R.id.current_date_view);
//        textView.setText(num);
//    }


    public void SubmitOnClickMonth(View view) {
        //Intent intent = new Intent(MonthConfirmationActivity.this,ReceiveDataTestActivity.class);
        //edTxtval = monthConfirm.getText().toString();
        intedTxtVal = Integer.parseInt(monthConfirm.getText().toString());


        if(intedTxtVal<1 || intedTxtVal>9){
            textInputLayoutMonth.setError("Month must be getter than 0 and less than 10");
        }
        else{
            textInputLayoutMonth.setError(null);
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat mdformat = new SimpleDateFormat("dd / MM / yyyy ");

            for (;intedTxtVal<maxMonth;intedTxtVal++){
                calendar.add(calendar.DATE,30);
                dates.add(mdformat.format(calendar.getTime()));
                loopcount++;

            }


            Toast.makeText(MonthConfirmationActivity.this,"Show Vaccine Date Click Next Button",Toast.LENGTH_LONG).show();
            loopcount=0;
            btnnxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mPosition<dates.size()-1){
                        mPosition= mPosition+1;
                        switcher.setText(dates.get(mPosition));

                    }

                }
            });

            btnPrvs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mPosition>0){
                        mPosition = mPosition-1;
                        switcher.setText(dates.get(mPosition));
                    }
                }
            });

            intedTxtVal = Integer.parseInt(monthConfirm.getText().toString());
            switcher.setText("");
            monthConfirm.setText("");

        }



    }




//    public void OnClickbutnpre(View view) {
//
//        if (mPosition>0){
//                    mPosition = mPosition-1;
//                    switcher.setText(dates.get(mPosition));
//                }
//                //switcher.setText("");
//    }
//
//    public void OnClickbutnnxt(View view) {
//        if (mPosition<dates.size()-1){
//                    mPosition= mPosition+1;
//                    switcher.setText(dates.get(mPosition));
//
//                }
//                //switcher.setText("");
//    }


}
