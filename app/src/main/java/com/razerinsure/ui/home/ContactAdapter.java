package com.razerinsure.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.razerinsure.data.Contact;

import java.util.ArrayList;

import db.test.razerinsure.R;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private Context context;
    private ArrayList<Contact> contactList;
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ContactViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        switch (position) {
            case 0:
                Glide.with(context).load(R.mipmap.contact_icon_1_foreground).into(holder.contactIcon);
                break;
            case 1:
                Glide.with(context).load(R.mipmap.contact_icon_2_foreground).into(holder.contactIcon);
                break;
            default:
                Glide.with(context).load(R.mipmap.contact_icon_1_foreground).into(holder.contactIcon);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public ContactAdapter(Context context) {
        this.context = context;
    }

    public void setContactList(ArrayList<Contact> contactList) {
        this.contactList = contactList;
        notifyDataSetChanged();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        protected ImageView contactIcon;
        protected TextView contactName;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            contactIcon = itemView.findViewById(R.id.contact_icon);

        }
    }
}
