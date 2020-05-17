package com.razerinsure.ui.checkout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.razerinsure.PaymentActivity;

import org.w3c.dom.Text;

import db.test.razerinsure.R;

public class CheckoutActivity extends AppCompatActivity {
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_checkout);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setLogo(R.mipmap.logo_razer);
        getSupportActionBar().setTitle(R.string.app_name);
        TextView txtScroll = (TextView) findViewById(R.id.terms_and_conditions);
        txtScroll.setMovementMethod(new ScrollingMovementMethod());
        Button payNow = findViewById(R.id.checkoutButton);
        payNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckoutActivity.this, PaymentActivity.class));
            }
        });
        Glide.with(this).load(R.mipmap.ic_luggage_icon_foreground).into((ImageView) findViewById(R.id.coverage_option_group_view).findViewById(R.id.coverage_option_1).findViewById(R.id.coverage_option_picture));
        Glide.with(this).load(R.mipmap.doctor_foreground).into((ImageView) findViewById(R.id.coverage_option_group_view).findViewById(R.id.coverage_option_2).findViewById(R.id.coverage_option_picture));
        Glide.with(this).load(R.mipmap.ic_travel_insurance_icon_foreground).into((ImageView) findViewById(R.id.coverage_option_group_view).findViewById(R.id.coverage_option_3).findViewById(R.id.coverage_option_picture));
        ((TextView) findViewById(R.id.coverage_option_group_view).findViewById(R.id.coverage_option_1).findViewById(R.id.coverage_option_text)).setText("Baggage");
        ((TextView) findViewById(R.id.coverage_option_group_view).findViewById(R.id.coverage_option_2).findViewById(R.id.coverage_option_text)).setText("Health");
        ((TextView) findViewById(R.id.coverage_option_group_view).findViewById(R.id.coverage_option_3).findViewById(R.id.coverage_option_text)).setText("Travel");
    }
}
