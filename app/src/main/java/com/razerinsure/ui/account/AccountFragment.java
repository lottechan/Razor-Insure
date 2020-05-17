package com.razerinsure.ui.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;

import db.test.razerinsure.R;

public class AccountFragment extends Fragment {

    private AccountViewModel accountViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        accountViewModel =
                ViewModelProviders.of(this).get(AccountViewModel.class);
        View root = inflater.inflate(R.layout.fragment_rewards_overview, container, false);
        Glide.with(this).load(R.mipmap.ic_luggage_icon_foreground).into((ImageView) root.findViewById(R.id.my_badges_group_view).findViewById(R.id.reward_badge_1).findViewById(R.id.reward_badge_picture));
        Glide.with(this).load(R.mipmap.doctor_foreground).into((ImageView) root.findViewById(R.id.my_badges_group_view).findViewById(R.id.reward_badge_2).findViewById(R.id.reward_badge_picture));
        Glide.with(this).load(R.mipmap.ic_travel_insurance_icon_foreground).into((ImageView) root.findViewById(R.id.my_badges_group_view).findViewById(R.id.reward_badge_3).findViewById(R.id.reward_badge_picture));
        ((TextView) root.findViewById(R.id.my_badges_group_view).findViewById(R.id.reward_badge_1).findViewById(R.id.reward_badge_name)).setText("Baggage");
        ((TextView) root.findViewById(R.id.my_badges_group_view).findViewById(R.id.reward_badge_2).findViewById(R.id.reward_badge_name)).setText("Health");
        ((TextView) root.findViewById(R.id.my_badges_group_view).findViewById(R.id.reward_badge_3).findViewById(R.id.reward_badge_name)).setText("Travel");
        Glide.with(this).load(R.mipmap.ic_luggage_icon_foreground).into((ImageView) root.findViewById(R.id.voucher_list_group_view).findViewById(R.id.voucher_view_1).findViewById(R.id.voucher_picture));
        Glide.with(this).load(R.mipmap.doctor_foreground).into((ImageView) root.findViewById(R.id.voucher_list_group_view).findViewById(R.id.voucher_view_2).findViewById(R.id.voucher_picture));
        Glide.with(this).load(R.mipmap.ic_travel_insurance_icon_foreground).into((ImageView)root.findViewById(R.id.voucher_list_group_view).findViewById(R.id.voucher_view_3).findViewById(R.id.voucher_picture));
        ((TextView) root.findViewById(R.id.voucher_list_group_view).findViewById(R.id.voucher_view_1).findViewById(R.id.voucher_name)).setText("Baggage");
        ((TextView) root.findViewById(R.id.voucher_list_group_view).findViewById(R.id.voucher_view_2).findViewById(R.id.voucher_name)).setText("Health");
        ((TextView) root.findViewById(R.id.voucher_list_group_view).findViewById(R.id.voucher_view_3).findViewById(R.id.voucher_name)).setText("Travel");
        return root;
    }
}