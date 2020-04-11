package in.ramakuru.sescenti.pages;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import in.ramakuru.sescenti.ObjectClasses.User;
import in.ramakuru.sescenti.R;


public class MainActivity extends AppCompatActivity {  //a constant for detecting the login intent result

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    String checkID = null;
    boolean isUserAlready = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mAuth.getCurrentUser() != null) {
                    ValueEventListener valueEventListener = new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            checkID = dataSnapshot.child("users").getValue().toString();
                            if(checkID == mAuth.getUid()){
                                isUserAlready = true;
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    };
                    if(checkID == null || isUserAlready == false){
                        Map<String, User> userMap = new HashMap<>();
                        User newUser = new User(null,0,0,mAuth.getCurrentUser().getDisplayName(),mAuth.getUid(),null,mAuth.getCurrentUser().getEmail());
//                        FirebaseDatabase.getInstance().getReference().child("users").setValue(newUser);
                        userMap.put(mAuth.getCurrentUser().getUid(),newUser);
                        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("users").child(mAuth.getUid());
                        ref.setValue(newUser);

                    }
                    Toast.makeText(getBaseContext(),"Welcome "+mAuth.getCurrentUser().getDisplayName(),Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), SuperActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(getBaseContext(),"Please Sign In",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                    startActivity(intent);
                    finish();

                }

            }
        },500);
    }
}