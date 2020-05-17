package com.razerinsure.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.razerinsure.Client.Client;
import com.razerinsure.MainActivity;
import com.razerinsure.data.Contact;
import com.razerinsure.ui.MyPoliciesActivity;
import com.razerinsure.ui.checkout.CheckoutActivity;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import db.test.razerinsure.R;


public class HomeFragment extends Fragment {

    Client client = new Client();

    public static final String TO_PAYMENT_ACTIVITY_TITLE = "payment_activity_title";
    public static final String TO_INSURANCE_PLAN_FRAGMENT = "insurance_plan_fragment";
    private TextView welcomeBackMessage;
    private HomeViewModel homeViewModel;
    private ViewGroup endowmentPlansCard;
    private ImageView endowmentPlansIcon;
    private TextView endowmentPlansTitle;

    private ViewGroup carInsuranceCard;
    private ImageView carInsuranceIcon;
    private TextView carInsuranceTitle;

    private ViewGroup travelInsuranceCard;
    private ImageView travelInsuranceIcon;
    private TextView travelInsuranceTitle;

    private ViewGroup moreOptionsCard;
    private ImageView moreOptionsIcon;
    private TextView moreOptionsTitle;

    private TextView travelPlans;
    private ViewGroup policyPlans;

    private RecyclerView contactList;
    private ContactAdapter contactAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        bindViews(root);
        policyPlans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MyPoliciesActivity.class));
            }
        });

        //Connecting to server to retrieve user details from MAMBU server
        Thread temp1 = new Thread(new Runnable() {
            @Override
            public void run() {
                getClientInfoFromMAMBUServer();
            }
        });
        temp1.start();
        try {
            temp1.join();
            welcomeBackMessage.setText("Welcome back, " + client.getFirstName() + "!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final Bundle bundle = new Bundle();
        setCards();

        //Each insurance selection should bring you to details on click/press
        endowmentPlansCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString(TO_INSURANCE_PLAN_FRAGMENT, getResources().getString(R.string.endowment_plans_title));
                ((MainActivity) getActivity()).getNavController().navigate(R.id.navigation_insurance_plan, bundle);
            }
        });
        carInsuranceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString(TO_INSURANCE_PLAN_FRAGMENT, getResources().getString(R.string.car_insurance_title));
                ((MainActivity) getActivity()).getNavController().navigate(R.id.navigation_insurance_plan, bundle);
            }
        });
        travelInsuranceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString(TO_INSURANCE_PLAN_FRAGMENT, getResources().getString(R.string.travel_insurance_title));
                ((MainActivity) getActivity()).getNavController().navigate(R.id.navigation_insurance_plan, bundle);
            }
        });
        contactAdapter = new ContactAdapter(getContext());
        contactList.setAdapter(contactAdapter);
        final ArrayList<Contact> temp = new ArrayList<>();
        temp.add(new Contact("https://vignette.wikia.nocookie.net/villains/images/8/84/Koishi_Komeji.png/revision/latest?cb=20130208194054", "Test"));
        temp.add(new Contact("https://vignette.wikia.nocookie.net/villains/images/8/84/Koishi_Komeji.png/revision/latest?cb=20130208194054", "Test"));
        temp.add(new Contact("https://vignette.wikia.nocookie.net/villains/images/8/84/Koishi_Komeji.png/revision/latest?cb=20130208194054", "Test"));
        contactAdapter.setContactList(temp);
        //homeViewModel.getContactList().observe(getViewLifecycleOwner(), new Observer<ArrayList<Contact>>() {
        //   @Override
        //    public void onChanged(ArrayList<Contact> contactList) {
        //        contactAdapter.setContactList(contactList);
        //    }
        //});
        return root;
    }

    private void setCards() {
        Glide.with(getContext()).load(R.mipmap.ic_endowment_plan_icon_foreground).into(endowmentPlansIcon);
        endowmentPlansTitle.setText(R.string.endowment_plans_title);

        Glide.with(getContext()).load(R.mipmap.ic_car_insurance_icon_foreground).into(carInsuranceIcon);
        carInsuranceTitle.setText(R.string.car_insurance_title);

        Glide.with(getContext()).load(R.mipmap.ic_travel_insurance_icon_foreground).into(travelInsuranceIcon);
        travelInsuranceTitle.setText(R.string.travel_insurance_title);

        Glide.with(getContext()).load(R.mipmap.overflow_menu_icon_foreground).into(moreOptionsIcon);
        moreOptionsTitle.setText(R.string.more_options_title);
    }

    private void bindViews(View root) {
        welcomeBackMessage = root.findViewById(R.id.welcome_back);
        policyPlans = root.findViewById(R.id.my_policies_list);

        endowmentPlansCard = root.findViewById(R.id.insurance_first);
        endowmentPlansIcon = endowmentPlansCard.findViewById(R.id.insurance_plan_picture);
        endowmentPlansTitle = endowmentPlansCard.findViewById(R.id.insurance_plan_title);

        carInsuranceCard = root.findViewById(R.id.insurance_second);
        carInsuranceIcon = carInsuranceCard.findViewById(R.id.insurance_plan_picture);
        carInsuranceTitle = carInsuranceCard.findViewById(R.id.insurance_plan_title);

        travelInsuranceCard = root.findViewById(R.id.insurance_third);
        travelInsuranceIcon = travelInsuranceCard.findViewById(R.id.insurance_plan_picture);
        travelInsuranceTitle = travelInsuranceCard.findViewById(R.id.insurance_plan_title);

        moreOptionsCard = root.findViewById(R.id.insurance_fourth);
        moreOptionsIcon = moreOptionsCard.findViewById(R.id.insurance_plan_picture);
        moreOptionsTitle = moreOptionsCard.findViewById(R.id.insurance_plan_title);

        contactList = root.findViewById(R.id.contact_list);

    }

    public String getClientInfoFromMAMBUServer() {
        try {
            String basicAuth = "Basic " + new String(Base64.encode("Team78:pass8A6E1BC7B".getBytes(), Base64.DEFAULT));
            URL url = new URL("https://razerhackathon.sandbox.mambu.com/api/clients/129913059");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            conn.setRequestProperty("Authorization", basicAuth);
            conn.setRequestProperty("Accept", "application/json");

            conn.setDoInput(true);
            conn.connect();
            JSONObject jsonParam = new JSONObject();
            String test = "";

            Scanner sc = new Scanner(conn.getInputStream());
            while (sc.hasNext())
                test += sc.nextLine();

            //BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
            //os.writeBytes(URLEncoder.encode(jsonParam.toString(), "UTF-8"));
            client = new Gson().fromJson(test, Client.class);
            sc.close();

            Log.e("STATUS", String.valueOf(conn.getResponseCode()));
            Log.e("MSG", conn.getResponseMessage());

            conn.disconnect();
        } catch (Exception e) {
            Log.e("Errors", "" + e);
        }

        return client.getFirstName();

    }

}
