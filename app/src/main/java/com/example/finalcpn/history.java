package com.example.finalcpn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

//public class history extends AppCompatActivity {
//    private FirebaseAuth mAuth;
//
//    private RecyclerView mRecyclerView;
//    private ImagePredictionAdapte mAdapter;
//    private List<ImagePrediction> mImagePredictionList;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_history);
//
//        mAuth = FirebaseAuth.getInstance();
//
//        mRecyclerView = findViewById(R.id.recycler_view);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mImagePredictionList = new ArrayList<>();
//        mAdapter = new ImagePredictionAdapte(this, mImagePredictionList);
//        mRecyclerView.setAdapter(mAdapter);
//
//        String userId = mAuth.getCurrentUser().getUid();
//        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users").child(userId);
//        userRef.child("images").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                mImagePredictionList.clear();
//                for (DataSnapshot imageSnapshot : snapshot.getChildren()) {
//                    ImagePrediction imagePrediction = imageSnapshot.getValue(ImagePrediction.class);
//                    mImagePredictionList.add(imagePrediction);
//                }
//                mAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                // Handle any errors that occur during the database operation
//            }
//        });
//    }
//}
//
//
//
//




public class history extends AppCompatActivity {
    private  FirebaseAuth mAuth;


    private RecyclerView mRecyclerView;
    private PredictionAdapter mAdapter;
    private List<predictionModel> mPredictionModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        mAuth = FirebaseAuth.getInstance();
getSupportActionBar().hide();
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mPredictionModelList = new ArrayList<>();
        mAdapter = new PredictionAdapter(this, mPredictionModelList);
        mRecyclerView.setAdapter(mAdapter);

        String userId = mAuth.getCurrentUser().getUid();
        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users").child(userId);
        userRef.child("images").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mPredictionModelList.clear();
                for (DataSnapshot imageSnapshot : snapshot.getChildren()) {
                    predictionModel predictionModel = imageSnapshot.getValue(predictionModel.class);
                    mPredictionModelList.add(predictionModel);
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle any errors that occur during the database operation
            }
        });
    }



 }




