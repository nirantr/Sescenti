package in.ramakuru.sescenti.pages;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import in.ramakuru.sescenti.R;
import in.ramakuru.sescenti.searches.SearchKonnekt;
import in.ramakuru.sescenti.ui.Tabs.SectionsPagerAdapter;

public class SuperActivity extends AppCompatActivity {
FirebaseAuth mAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        final ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewPager.getCurrentItem() == 1){
                    Intent intent = new Intent(getApplicationContext(), SearchKonnekt.class);
                    startActivity(intent);
                    finish();
                }
                Snackbar.make(view, "Replace with your own action : "+viewPager.getCurrentItem(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}