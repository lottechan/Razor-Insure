package com.razerinsure.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.razerinsure.data.Contact;

import java.util.ArrayList;

public class HomeViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Contact>> contactList = null;

    public HomeViewModel(@NonNull Application application) {
        super(application);

    }


    public LiveData<ArrayList<Contact>> getContactList() {
        contactList = new MutableLiveData<>();
        loadContactList();
        return contactList;
    }

    private void loadContactList() {
        final ArrayList<Contact> temp = new ArrayList<>();
        (new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO: 15/5/2020 Retrieve contactlist async
                temp.add(new Contact("https://vignette.wikia.nocookie.net/villains/images/8/84/Koishi_Komeji.png/revision/latest?cb=20130208194054", "Test"));
                temp.add(new Contact("https://vignette.wikia.nocookie.net/villains/images/8/84/Koishi_Komeji.png/revision/latest?cb=20130208194054", "Test"));
                temp.add(new Contact("https://vignette.wikia.nocookie.net/villains/images/8/84/Koishi_Komeji.png/revision/latest?cb=20130208194054", "Test"));
                temp.add(new Contact("https://vignette.wikia.nocookie.net/villains/images/8/84/Koishi_Komeji.png/revision/latest?cb=20130208194054", "Test"));
            }
        })).start();
        contactList.setValue(temp);
    }
}