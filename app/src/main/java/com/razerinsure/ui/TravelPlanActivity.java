package com.razerinsure.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.razerinsure.MainActivity;
import com.razerinsure.ui.checkout.CheckoutActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import db.test.razerinsure.R;

public class TravelPlanActivity extends AppCompatActivity {

    private Button selectTravelPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_plans);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setLogo(R.mipmap.logo_razer);
        getSupportActionBar().setTitle(R.string.app_name);
        selectTravelPlan = findViewById(R.id.travel_plan_selection_button);

        selectTravelPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TravelPlanActivity.this, CheckoutActivity.class));
            }
        });
    }

}
