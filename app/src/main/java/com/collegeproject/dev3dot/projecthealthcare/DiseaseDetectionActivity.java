package com.collegeproject.dev3dot.projecthealthcare;

import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;

import java.util.Locale;

public class DiseaseDetectionActivity extends AppCompatActivity {

    final String msg1 = "We suspect you are suffering in ";
    final String msg2 = " Contact your physician as soon as possible. Early precaution can reduce your suffering";
    final String dsflu = "Influenza.";
    final String dschi = "chikungunya.";
    final String dsden = "Dengu.";
    final String dspox = "Chiken Pox.";
    final String dstyp = "Typhoid.";
    final String dsdia = "Diarrhea.";
    final String dsmig = "Migrain.";

    TextToSpeech txttospch;

    //for Influenza

    String flu1 = "Fever over 100.4 F";
    String flu2 = "Sore throat";
    String flu3 = "Nasal congestion";

    //for Chikuntunya

    String chi1 = "fever sometimes as high as 104°F";
    String chi2 = "joint pain";
    String chi3 = "swelling around the joints";

    //for dengu

    String den1 = "sudden,high fever up to 106 degrees Fahrenheit";
    String den2 = "severe headache";
    String den3 = "swollen lymph glands";

    //for Chiken Pox

    String pox1 = "Loss of appetite, tiredness and feeling sick";
    String pox2 = "Spots or a rash";
    String pox3 = "Muscle aches";

    //for Typhoid

    String typ1 = "Fever that starts low and increases daily, possibly reaching as high as 104.9 F";
    String typ2 = "Diarrhea or constipation";
    String typ3 = "Abdominal pain";

    //for Diarrhea

    String dia1 = "Bloating in belly";
    String dia2 = "Watery stools";
//    String dia3 = "Nasal congestion";

    //for Migrain

    String mig1 = "Pain on one side or both side on head";
    String mig2 = "blurred vision";
    String mig3 = "nausea and vomiting";

    String[] textlayout1 = {"fever sometimes as high as 104°F", "sudden,high fever up to 106 degrees Fahrenheit",
            "Fever over 100.4 F", "Loss of appetite, tiredness and feeling sick",
            "Fever that starts low and increases daily, possibly reaching as high as 104.9 F "
            , "Bloating in belly", "Pain on one side or both side on head"};

    String[] version = {"CupcCake", "Donut", "Eclair", "Froyo", "Gingerbread", "HoneyComb", "Ice Cream sandwitch",
            "JellyBean", "Kitkat", "Lollipop", "Marshmallow", "Nougat"};

    String[] symptomps1 = {"Headache", "confussion", "Gagging", "Loss of Vision", "cramps",
            "cought",};


    String[] textlayout2 = {"blurred vision", "Watery stools", "Diarrhea or constipation", "Spots or a rash",
            "Sore throat", "severe headache", "joint pain"};
    //
//
    String[] textlayout3 = {"swelling around the joints", "swollen lymph glands",
            "Nasal congestion", "Muscle aches", "Abdominal pain", "nausea and vomiting"};


    TextInputLayout forsymp1Tlayout;
    TextInputLayout forsymp2Tlayout;
    TextInputLayout forsymp3Tlayout;

    AutoCompleteTextView forsymp1Auto;
    AutoCompleteTextView forsymp2Auto;
    AutoCompleteTextView forsymp3Auto;

    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_disease_detection);

        //textinput

        forsymp1Tlayout = (TextInputLayout) findViewById(R.id.symp_1_tlayout);
        forsymp2Tlayout = (TextInputLayout) findViewById(R.id.symp_2_tlayout);
        forsymp3Tlayout = (TextInputLayout) findViewById(R.id.symp_3_tlayout);

        //auto complete text view

        forsymp1Auto = (AutoCompleteTextView) findViewById(R.id.symp_1_auto);
        forsymp2Auto = (AutoCompleteTextView) findViewById(R.id.symp_2_auto);
        forsymp3Auto = (AutoCompleteTextView) findViewById(R.id.symp_3_auto);

        submit = (Button) findViewById(R.id.submit_disease_button);

//        String  getrecAuto1;
//        String  getrecAuto2;
//        String  getrecAuto3;


//array adapter for auto1

        ArrayAdapter<String> adapterSymptom1 = new ArrayAdapter<String>(DiseaseDetectionActivity.this,
                android.R.layout.select_dialog_item, textlayout1);
        forsymp1Auto.setThreshold(1);
        forsymp1Auto.setAdapter(adapterSymptom1);
        forsymp1Auto.setTextColor(Color.BLUE);
//array adapter for auto2

        ArrayAdapter<String> adapterSymptom2 = new ArrayAdapter<String>(DiseaseDetectionActivity.this,
                android.R.layout.select_dialog_item, textlayout2);

        forsymp2Auto.setThreshold(1);
        forsymp2Auto.setAdapter(adapterSymptom2);
        forsymp2Auto.setTextColor(Color.GRAY);

//array adapter for auto3
        ArrayAdapter<String> adapterSymptom3 = new ArrayAdapter<String>(DiseaseDetectionActivity.this,
                android.R.layout.select_dialog_item, textlayout3);

        forsymp3Auto.setThreshold(1);
        forsymp3Auto.setAdapter(adapterSymptom3);
        forsymp3Auto.setTextColor(Color.GRAY);

        txttospch = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status != TextToSpeech.ERROR) {
                    txttospch.setLanguage(Locale.ENGLISH);
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int lenauto1 = forsymp1Auto.getText().toString().trim().length();
                int lenauto2 = forsymp2Auto.getText().toString().trim().length();
                int lenauto3 = forsymp3Auto.getText().toString().trim().length();

                String autorec1 = forsymp1Auto.getText().toString();
                String autorec2 = forsymp2Auto.getText().toString();
                String autorec3 = forsymp3Auto.getText().toString();


                if (lenauto1 == 0 || lenauto2 == 0 || lenauto3 == 0) {
                    if (lenauto1 == 0) {
                        forsymp1Tlayout.setError("This field needs to be filled");
                    }

                    if (lenauto2 == 0) {
                        forsymp2Tlayout.setError("This field needs to be filled");
                    }
                    if (lenauto3 == 0) {
                        forsymp3Tlayout.setError("This field needs to be filled");
                    }

                } else {


                    //for flu
                    if ((autorec1.equals(flu1)) && (autorec2.equals(flu2)) ||
                            (autorec1.equals(flu1)) && (autorec3.equals(flu3)) ||
                            (autorec2.equals(flu2)) && (autorec3.equals(flu3)) ||
                            (autorec1.equals(flu1)) && (autorec2.equals(flu2)) && (autorec3.equals(flu3))) {

                        MaterialStyledDialog diaflu = new MaterialStyledDialog.Builder(DiseaseDetectionActivity.this)
                                .setHeaderDrawable(R.drawable.flu)
                                .setTitle(dsflu).setDescription(msg1 + " " + dsflu + msg2)
                                .setPositiveText("ok")
                                .show();
                        txttospch.speak(msg1 + " " + dsflu + " " + msg2, TextToSpeech.QUEUE_FLUSH, null);
                        //Toast.makeText(DiseaseDetectionActivity.this,
                        //"We Suspect You are Suffering Influenja",Toast.LENGTH_LONG).show();
                    }

                    //for migrain

                    else if ((autorec1.equals(mig1)) && (autorec2.equals(mig2)) ||
                            (autorec1.equals(mig1)) && (autorec3.equals(mig3)) ||
                            (autorec2.equals(mig2)) && (autorec3.equals(mig3)) ||
                            (autorec1.equals(mig1)) && (autorec2.equals(mig2)) && (autorec3.equals(mig3))) {
                        MaterialStyledDialog diamig = new MaterialStyledDialog.Builder(DiseaseDetectionActivity.this)
                                .setHeaderDrawable(R.drawable.migrain)
                                .setTitle(dsmig).setDescription(msg1 + " " + dsmig + ". " + msg2)
                                .setPositiveText("ok")
                                .show();
                        txttospch.speak(msg1 + " " + dsmig + " " + msg2, TextToSpeech.QUEUE_FLUSH, null);
//                        Toast.makeText(DiseaseDetectionActivity.this,
//                                "We Suspect You are Suffering Influenja",Toast.LENGTH_LONG).show();
                    }

                    //for diarrhea

                    else if ((autorec1.equals(dia1)) && (autorec2.equals(dia2)) ||
                            (autorec1.equals(dia1)) && (autorec3.equals(mig3)) ||
                            (autorec2.equals(dia2)) && (autorec3.equals(mig3)) ||
                            (autorec1.equals(dia1)) && (autorec2.equals(dia2)) && (autorec3.equals(mig3))) {
                        MaterialStyledDialog diaDia = new MaterialStyledDialog.Builder(DiseaseDetectionActivity.this)
                                .setHeaderDrawable(R.drawable.diarrhea)
                                .setTitle(dsdia).setDescription(msg1 + " " + dsdia + ". " + msg2)
                                .setPositiveText("ok")
                                .show();
                        txttospch.speak(msg1 + " " + dsdia + " " + msg2, TextToSpeech.QUEUE_FLUSH, null);
//                        Toast.makeText(DiseaseDetectionActivity.this,
//                                "We Suspect You are Suffering Influenja",Toast.LENGTH_LONG).show();
                    }

                    //for Typhoid

                    else if ((autorec1.equals(typ1)) && (autorec2.equals(typ2)) ||
                            (autorec1.equals(typ1)) && (autorec3.equals(typ3)) ||
                            (autorec2.equals(typ2)) && (autorec3.equals(typ3)) ||
                            (autorec1.equals(typ1)) && (autorec2.equals(typ2)) && (autorec3.equals(typ3))) {

                        MaterialStyledDialog diatyp = new MaterialStyledDialog.Builder(DiseaseDetectionActivity.this)
                                .setHeaderDrawable(R.drawable.typhoid)
                                .setTitle(dstyp).setDescription(msg1 + " " + dstyp + ". " + msg2)
                                .setPositiveText("ok")
                                .show();
                        txttospch.speak(msg1 + " " + dstyp + " " + msg2, TextToSpeech.QUEUE_FLUSH, null);
//                        Toast.makeText(DiseaseDetectionActivity.this,
//                                "We Suspect You are Suffering Influenja",Toast.LENGTH_LONG).show();
                    }

                    //chiken Pox

                    else if ((autorec1.equals(pox1)) && (autorec2.equals(pox2)) ||
                            (autorec1.equals(pox1)) && (autorec3.equals(pox3)) ||
                            (autorec2.equals(pox2)) && (autorec3.equals(pox3)) ||
                            (autorec1.equals(pox1)) && (autorec2.equals(pox2)) && (autorec3.equals(pox3))) {
                        MaterialStyledDialog diaflu = new MaterialStyledDialog.Builder(DiseaseDetectionActivity.this)
                                .setHeaderDrawable(R.drawable.chikenpox)
                                .setTitle(dspox).setDescription(msg1 + " " + dspox + ". " + msg2)
                                .setPositiveText("ok")
                                .show();
                        txttospch.speak(msg1 + " " + dspox + " " + msg2, TextToSpeech.QUEUE_FLUSH, null);
//                        Toast.makeText(DiseaseDetectionActivity.this,
//                                "We Suspect You are Suffering Influenja",Toast.LENGTH_LONG).show();
                    }

                    //for dengu

                    else if ((autorec1.equals(den1)) && (autorec2.equals(den2)) ||
                            (autorec1.equals(den1)) && (autorec3.equals(den3)) ||
                            (autorec2.equals(den2)) && (autorec3.equals(den3)) ||
                            (autorec1.equals(den1)) && (autorec2.equals(den2)) && (autorec3.equals(den3))) {

                        MaterialStyledDialog diaden = new MaterialStyledDialog.Builder(DiseaseDetectionActivity.this)
                                .setHeaderDrawable(R.drawable.dengu)
                                .setTitle(dsden).setDescription(msg1 + " " + dsden + ". " + msg2)
                                .setPositiveText("ok")
                                .show();
                        txttospch.speak(msg1 + " " + dsden + " " + msg2, TextToSpeech.QUEUE_FLUSH, null);
//                        Toast.makeText(DiseaseDetectionActivity.this,
//                                "We Suspect You are Suffering Influenja",Toast.LENGTH_LONG).show();
                    }

                    //for chikungunya

                    else if ((autorec1.equals(chi1)) && (autorec2.equals(chi2)) ||
                            (autorec1.equals(chi1)) && (autorec3.equals(chi3)) ||
                            (autorec2.equals(chi2)) && (autorec3.equals(chi3)) ||
                            (autorec1.equals(chi1)) && (autorec2.equals(chi2)) && (autorec3.equals(chi3))) {

                        MaterialStyledDialog diachi = new MaterialStyledDialog.Builder(DiseaseDetectionActivity.this)
                                .setHeaderDrawable(R.drawable.chikunguniya)
                                .setTitle(dschi).setDescription(msg1 + " " + dschi + ". " + msg2)
                                .setPositiveText("ok")
                                .show();
                        txttospch.speak(msg1 + " " + dschi + " " + msg2, TextToSpeech.QUEUE_FLUSH, null);
//                        Toast.makeText(DiseaseDetectionActivity.this,
//                                "We Suspect You are Suffering Influenja",Toast.LENGTH_LONG).show();
                    }

                    //for no match

                    else {
                        MaterialStyledDialog nofound = new MaterialStyledDialog.Builder(DiseaseDetectionActivity.this)
                                .setHeaderDrawable(R.drawable.nothingfound)
                                .setTitle("Opps!!!").setDescription("oops")
                                .setPositiveText("ok")
                                .show();
                        txttospch.speak("oops", TextToSpeech.QUEUE_FLUSH, null);


                    }


                    forsymp1Tlayout.setError(null);
                    forsymp2Tlayout.setError(null);
                    forsymp3Tlayout.setError(null);
                    forsymp1Tlayout.clearFocus();


                }

            }
        });


    }

    public void onPause() {
        if (txttospch != null) {
            txttospch.stop();
            txttospch.shutdown();
        }
        super.onPause();
    }


}

