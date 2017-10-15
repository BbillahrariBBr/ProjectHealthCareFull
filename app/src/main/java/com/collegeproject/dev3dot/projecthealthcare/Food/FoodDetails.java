package com.collegeproject.dev3dot.projecthealthcare.Food;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.collegeproject.dev3dot.projecthealthcare.R;


public class FoodDetails extends AppCompatActivity {

    ImageView imageView;
    TextView foodHeader;
    TextView foodDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.all_content_details);

        imageView = (ImageView) findViewById(R.id.allImageView);
        foodHeader = (TextView) findViewById(R.id.allHeader);
        foodDetails = (TextView) findViewById(R.id.allDetails);

        final Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            imageView.setImageResource(bundle.getInt("image"));
            foodHeader.setText(bundle.getString("name"));
            foodDetails.setText(bundle.getString("details"));
        }
    }

}

