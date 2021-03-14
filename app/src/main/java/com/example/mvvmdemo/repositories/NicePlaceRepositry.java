package com.example.mvvmdemo.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmdemo.model.NicePlaces;

import java.util.ArrayList;
import java.util.List;

public class NicePlaceRepositry {
    private static NicePlaceRepositry instance;
    private ArrayList<NicePlaces> dataSet=new ArrayList<>();
    /*
    Singelton pattern
     */
    public static NicePlaceRepositry getInstance()
    {
        if(instance==null)
        {
            instance = new NicePlaceRepositry();
        }
        return instance;
    }
    public MutableLiveData<List<NicePlaces>> getNicePlaces()
    {
       setNicePlaces();
       MutableLiveData<List<NicePlaces>> data=new MutableLiveData<>();
       data.setValue(dataSet);
       return data;
    }
    private void setNicePlaces()
    {
        dataSet.add(
                new NicePlaces("https://i.redd.it/0h2gm1ix6p501.jpg",
                        "Havasu Falls")
        );
        dataSet.add(
                new NicePlaces("https://i.redd.it/tpsnoz5bzo501.jpg",
                        "Trondheim")
        );
        dataSet.add(
                new NicePlaces("https://i.redd.it/qn7f9oqu7o501.jpg",
                        "Portugal")
        );
        dataSet.add(
                new NicePlaces("https://i.redd.it/j6myfqglup501.jpg",
                        "Rocky Mountain National Park")
        );
        dataSet.add(
                new NicePlaces("https://i.redd.it/0h2gm1ix6p501.jpg",
                        "Havasu Falls")
        );
        dataSet.add(
                new NicePlaces("https://i.redd.it/k98uzl68eh501.jpg",
                        "Mahahual")
        );
        dataSet.add(
                new NicePlaces("https://i.redd.it/qn7f9oqu7o501.jpg",
                        "Frozen Lake")
        );
        dataSet.add(
                new NicePlaces("https://i.redd.it/obx4zydshg601.jpg",
                        "Austrailia")
        );
    }
}
