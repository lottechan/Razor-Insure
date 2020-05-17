package com.razerinsure;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.razerinsure.ui.TravelPlanActivity;
import com.razerinsure.ui.checkout.CheckoutActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import db.test.razerinsure.R;

public class ClaimProcessActivity extends AppCompatActivity {

    private ViewGroup claimIcon1;
    private ViewGroup claimIcon2;
    private ViewGroup claimIcon3;
    private ViewGroup claimIcon4;

    private ImageView claimIconImage1;
    private ImageView claimIconImage2;
    private ImageView claimIconImage3;
    private ImageView claimIconImage4;

    private TextView claimText1;
    private TextView claimText2;
    private TextView claimText3;
    private TextView claimText4;

    private Button claimButton1;
    private Button claimButton2;
    private Button claimButton3;
    private Button claimButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claim_process);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setLogo(R.mipmap.logo_razer);
        getSupportActionBar().setTitle(R.string.app_name);
        claimIcon1 = findViewById(R.id.icon_with_select_button_1);
        claimText1 = claimIcon1.findViewById(R.id.picture_name);
        claimIconImage1 = claimIcon1.findViewById(R.id.icon_with_select_button_text_picture);
        claimButton1 = findViewById(R.id.icon_button);

        claimIcon2 = findViewById(R.id.icon_with_select_button_2);
        claimText2 = claimIcon2.findViewById(R.id.picture_name);
        claimIconImage2 = claimIcon2.findViewById(R.id.icon_with_select_button_text_picture);
        claimButton2 = findViewById(R.id.icon_button);

        claimIcon3 = findViewById(R.id.icon_with_select_button_3);
        claimText3 = claimIcon3.findViewById(R.id.picture_name);
        claimIconImage3 = claimIcon3.findViewById(R.id.icon_with_select_button_text_picture);
        claimButton3 = findViewById(R.id.icon_button);

        claimIcon4 = findViewById(R.id.icon_with_select_button_4);
        claimText4 = claimIcon4.findViewById(R.id.picture_name);
        claimIconImage4 = claimIcon4.findViewById(R.id.icon_with_select_button_text_picture);
        claimButton4 = findViewById(R.id.icon_button);

        Glide.with(claimIcon1.getContext()).load(R.mipmap.ic_medical_icon_foreground).into(claimIconImage1);
        claimText1.setText("Medical Expenses");

        Glide.with(claimIcon2.getContext()).load(R.mipmap.ic_car_insurance_icon_foreground).into(claimIconImage2);
        claimText2.setText("Loss/Damage to Property");

        Glide.with(claimIcon3.getContext()).load(R.mipmap.ic_luggage_icon).into(claimIconImage3);
        claimText3.setText("Delayed Baggage");

        Glide.with(claimIcon4.getContext()).load(R.mipmap.ic_travel_insurance_icon).into(claimIconImage4);
        claimText4.setText("Cancelled Trip");
        /*
        claimButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClaimProcessActivity.this, CheckoutActivity.class));
            }
        });

        claimButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClaimProcessActivity.this, CheckoutActivity.class));
            }
        });

        claimButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClaimProcessActivity.this, CheckoutActivity.class));
            }
        });

        claimButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ClaimProcessActivity.this, CheckoutActivity.class));
            }
        });

         */
    }
}
