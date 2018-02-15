package com.kabaria.firebase;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HashMap<String, Object> map = new HashMap<>();
        map.put("Mehul", "Kabaria");

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference childReference = databaseReference.child("Hello");
        childReference.setValue(map);
        HotStockViewModel hotStockViewModel = ViewModelProviders.of(this).get(HotStockViewModel.class);

        LiveData<DataSnapshot> liveData = hotStockViewModel.getDataSnapshotLiveData();

        liveData.observe(this, new Observer<DataSnapshot>() {
            @Override
            public void onChanged(@Nullable DataSnapshot dataSnapshot) {
                if(dataSnapshot != null) {
                    ((TextView) findViewById(R.id.textView)).setText(dataSnapshot.child("Mehul").getValue(String.class));
                }
            }
        });
    }
}
