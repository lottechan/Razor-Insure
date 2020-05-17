package com.razerinsure.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.razerinsure.PaymentActivity;
import db.test.razerinsure.R;

import com.razerinsure.ui.checkout.CheckoutActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static String TO_CHECKOUT_ACTIVITY_TITLE = "checkout_activity_title";

    private PageViewModel pageViewModel;
    private PaymentActivity paymentActivity;
    private RecyclerView recyclerView;
    private Button payNowButton;
    private TextView addCard;
    int index = 1;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
        paymentActivity = (PaymentActivity) getActivity();
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_credit_card, container, false);
        if(index == 1) {
            Glide.with(this).load(R.mipmap.razer_pay_foreground).into( (ImageView)root.findViewById(R.id.credit_card_picture));
        } else {
            Glide.with(this).load(R.mipmap.razer_gold_foreground).into( (ImageView)root.findViewById(R.id.credit_card_picture));
        }
        payNowButton = root.findViewById(R.id.pay_now_button);
        final Intent temp = new Intent(getActivity(), CheckoutActivity.class);
        payNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp.putExtra(TO_CHECKOUT_ACTIVITY_TITLE, paymentActivity.getInsuranceTitle());
                startActivity(temp);
            }
        });


        return root;
    }
}