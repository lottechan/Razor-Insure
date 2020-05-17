package com.razerinsure.ui.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import db.test.razerinsure.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InsurancePlanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsurancePlanFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String INSURANCE_TITLE_KEY = "insurance_title_key";

    private String insuranceTitle;
    private RecyclerView explanationCardList;
    public InsurancePlanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param insuranceTitle Parameter 1.
     * @return A new instance of fragment InsurancePlan.
     */
    public static InsurancePlanFragment newInstance(String insuranceTitle) {
        InsurancePlanFragment fragment = new InsurancePlanFragment();
        Bundle args = new Bundle();
        args.putString(INSURANCE_TITLE_KEY, insuranceTitle);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            insuranceTitle = getArguments().getString(INSURANCE_TITLE_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_insurance_plan, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(getArguments().getString(HomeFragment.TO_INSURANCE_PLAN_FRAGMENT));
        bindViews(root);
        return root;
    }

    private void bindViews(View root) {
        explanationCardList = root.findViewById(R.id.explanation_card_list);
        explanationCardList.setAdapter(new ExplanationCardAdapter(getContext()));
    }
}
