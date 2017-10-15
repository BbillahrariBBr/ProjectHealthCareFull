package com.collegeproject.dev3dot.projecthealthcare.Exercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.collegeproject.dev3dot.projecthealthcare.R;



public class ExerciseDetails extends AppCompatActivity {


    ImageView imageView;
    TextView exerciseHeader;
    TextView exerciseDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.all_content_details);

        imageView = (ImageView) findViewById(R.id.allImageView);
        exerciseHeader = (TextView) findViewById(R.id.allHeader);
        exerciseDetails = (TextView) findViewById(R.id.allDetails);

        final Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            imageView.setImageResource(bundle.getInt("image"));
            exerciseHeader.setText(bundle.getString("name"));
            exerciseDetails.setText(bundle.getString("details"));
        }
    }
}
