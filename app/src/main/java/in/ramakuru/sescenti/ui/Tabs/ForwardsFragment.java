package in.ramakuru.sescenti.ui.Tabs;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import in.ramakuru.sescenti.ObjectClasses.Konnekt;
import in.ramakuru.sescenti.R;
import in.ramakuru.sescenti.ObjectClasses.User;
import in.ramakuru.sescenti.adapters.forwardRecyclerAdapter;

public class ForwardsFragment extends Fragment implements forwardRecyclerAdapter.OnUserListener {

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mUserRef = mRootRef.child("users");
    ArrayList<User> userList = new ArrayList<User>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View rootView = inflater.inflate(R.layout.fragment_forwards, container, false);
        mUserRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                User testUser = dataSnapshot.getValue(User.class);
                boolean checker = false;
                for (int p = 0; p < userList.size(); p++) {
                    if (userList.get(p).email == testUser.email) {
                        checker = true;
                    }
                }
                if (checker == false) {
                    userList.add(testUser);
                }
                checker = false;
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        recyclerView = (RecyclerView) rootView.findViewById(R.id.forwardsRecyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new forwardRecyclerAdapter(userList, this);
        recyclerView.setAdapter(mAdapter);
        return rootView;
    }

    @Override
    public void onUserClick(int position) {
        Log.d("OnUserClick", "Item clicked number " + userList.get(position));
        Map<String, Konnekt> konnektMap = new HashMap<>();
        User currentUser = null;
        for (User u : userList) {
            if (FirebaseAuth.getInstance().getCurrentUser().getEmail() == u.email) {
                currentUser = u;
            }
        }
        Konnekt newKonnekt = new Konnekt(userList.get(position), currentUser, 0);
        konnektMap.put(FirebaseAuth.getInstance().getCurrentUser().getUid(), newKonnekt);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("konnekts").push();
        ref.setValue(konnektMap);
//        userList.get(position);
//        System.out.println("Item clicked number " + position);
    }


//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        super.onCreateView(inflater, container, savedInstanceState);
//        View rootView = inflater.inflate(R.layout.fragment_forwards, container,false);
//        System.out.println("Forward Opened");
//
//        return rootView;
//    }

}
