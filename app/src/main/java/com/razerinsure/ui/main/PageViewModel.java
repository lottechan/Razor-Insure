package com.razerinsure.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import com.razerinsure.data.Contact;

public class PageViewModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private LiveData<ArrayList<Contact>> cardList = Transformations.map(mIndex, new Function<Integer, ArrayList<Contact>>() {
        @Override
        public ArrayList<Contact> apply(Integer input) {
            ArrayList<Contact> temp = new ArrayList<>();

            // TODO: 15/5/2020 Retrieve list of cards from MAMBU async
            switch (input) {
                case 1:
                    return temp;
                case 2:
                    return temp;
                default:
                    return temp;
            }
        }
    });

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<ArrayList<Contact>> getCardList() {
        return cardList;
    }

}