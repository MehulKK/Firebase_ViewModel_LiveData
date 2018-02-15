package com.kabaria.firebase;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by kabariya on 2/15/2018.
 */

public class HotStockViewModel extends ViewModel {

    private static final DatabaseReference HOT_STOCK_REF =
            FirebaseDatabase.getInstance().getReference("/Hello");

    private final FirebaseQueryLiveData firebaseQueryLiveData = new FirebaseQueryLiveData(HOT_STOCK_REF);

    public LiveData<DataSnapshot> getDataSnapshotLiveData(){
        return firebaseQueryLiveData;
    }

}
