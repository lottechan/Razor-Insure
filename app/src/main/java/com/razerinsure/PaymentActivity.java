package com.razerinsure;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.razerinsure.ui.home.HomeFragment;
import com.razerinsure.ui.main.SectionsPagerAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;

import db.test.razerinsure.R;

public class PaymentActivity extends AppCompatActivity {
    private String insuranceTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setLogo(R.mipmap.logo_razer);
        getSupportActionBar().setTitle(R.string.app_name);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        insuranceTitle = getIntent().getStringExtra(HomeFragment.TO_PAYMENT_ACTIVITY_TITLE);


        ActionBar actionBar = getSupportActionBar();
        // actionBar.setTitle(insuranceTitle);
//        actionBar.setDisplayHomeAsUpEnabled(true);
        tabs.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public String getInsuranceTitle() {
        return insuranceTitle;
    }
}