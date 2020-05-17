package com.razerinsure.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.razerinsure.ClaimProcessActivity;

import db.test.razerinsure.R;

public class MyPoliciesActivity extends AppCompatActivity {

    ViewGroup my_policy_1;
    ViewGroup my_policy_2;
    ViewGroup my_policy_3;
    ViewGroup my_past_policy_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_policies);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setLogo(R.mipmap.logo_razer);
        getSupportActionBar().setTitle(R.string.app_name);
        my_policy_1 = findViewById(R.id.my_policy_card_1);
        my_policy_2 = findViewById(R.id.my_policy_card_2);
        my_policy_3 = findViewById(R.id.my_policy_card_3);
        my_past_policy_1 = findViewById(R.id.my_past_policy_card);

        my_policy_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyPoliciesActivity.this, ClaimProcessActivity.class));
            }
        });
        my_policy_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyPoliciesActivity.this, ClaimProcessActivity.class));
            }
        });
        ((TextView) my_policy_2.findViewById(R.id.my_policy_header)).setText("FWD Premium");
        ((TextView) my_policy_2.findViewById(R.id.my_policy_description)).setText("Indonesia: 13th-18th Nov 2020");
        ((TextView) my_policy_2.findViewById(R.id.my_policy_description2)).setText("Policy No: 35421DC");

        ((TextView) my_policy_3.findViewById(R.id.my_policy_header)).setText("Endowmment Plan");
        ((TextView) my_policy_3.findViewById(R.id.my_policy_description)).setText("0% Risk");
        ((TextView) my_policy_3.findViewById(R.id.my_policy_description2)).setText("4% Returns");
        Glide.with(this).load(R.mipmap.saving_pig_foreground).fitCenter().into((ImageView) my_policy_3.findViewById(R.id.dinosaur_picture));

        ((TextView) my_past_policy_1.findViewById(R.id.my_policy_header)).setText("4 Travel Plans");
        ((TextView) my_past_policy_1.findViewById(R.id.my_policy_description)).setText("");
        ((TextView) my_past_policy_1.findViewById(R.id.my_policy_description2)).setText("Past Policies");
        ((ImageView) my_past_policy_1.findViewById(R.id.dinosaur_picture)).setBackground(null);

        my_policy_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyPoliciesActivity.this, ClaimProcessActivity.class));
            }
        });

    }
}
