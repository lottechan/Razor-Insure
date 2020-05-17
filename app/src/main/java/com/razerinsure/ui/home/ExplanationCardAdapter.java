package com.razerinsure.ui.home;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.razerinsure.MainActivity;
import com.razerinsure.ui.TravelPlanActivity;

import db.test.razerinsure.R;

public class ExplanationCardAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private Context context;
    @NonNull
    @Override
    public ContactAdapter.ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactAdapter.ContactViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_card, parent, false));
    }

    //This view holder is for the explaination cards for each insurance
    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ContactViewHolder holder, int position) {
        holder.itemView.setBackground(null);
        switch (position) {
            case 0:
                Glide.with(context).load(R.mipmap.explanation_card_1_foreground).into(holder.contactIcon);
                break;
            case 1:
                Glide.with(context).load(R.mipmap.explanation_card_2_foreground).into(holder.contactIcon);
                break;
            case 2:
                Glide.with(context).load(R.mipmap.explanation_card_3_foreground).into(holder.contactIcon);
                break;
            case 3:
                Glide.with(context).load(R.mipmap.explanation_card_4_foreground).into(holder.contactIcon);
                holder.contactIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        context.startActivity(new Intent(context, TravelPlanActivity.class));
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public ExplanationCardAdapter(Context context) {
        this.context = context;
    }
}
