package com.example.mvvmdemo.viewModels;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmdemo.model.NicePlaces;
import com.example.mvvmdemo.repositories.NicePlaceRepositry;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivityModel extends ViewModel {
    private MutableLiveData<List<NicePlaces>> mNicePlaces;
    private NicePlaceRepositry nicePlaceRepositry;
    private MutableLiveData<Boolean> isUpdating=new MutableLiveData<>();
    public void init()
    {
      if(mNicePlaces!=null)
      {
          return;
      }
      nicePlaceRepositry=NicePlaceRepositry.getInstance();
      mNicePlaces=nicePlaceRepositry.getNicePlaces();
    }
    public void addNewValue(final NicePlaces nicePlaces)
    {
        isUpdating.setValue(true);
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Handler handler=new Handler(Looper.getMainLooper());
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                //background Stuff
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                @Override
                public void run() {
                  //on post execute stuff
                    List<NicePlaces> currentNicePlaces=mNicePlaces.getValue();
                    currentNicePlaces.add(nicePlaces);
                    mNicePlaces.postValue(currentNicePlaces);
                    isUpdating.postValue(false);
                }
            });
            }
        });
    }

    public LiveData<Boolean> getLoading()
    {
        return isUpdating;
    }

    public LiveData<List<NicePlaces>> getNicePlaces()
    {
        return mNicePlaces;
    }
}
