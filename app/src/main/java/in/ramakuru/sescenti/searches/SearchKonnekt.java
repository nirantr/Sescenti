package in.ramakuru.sescenti.searches;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import java.util.ArrayList;

import in.ramakuru.sescenti.ObjectClasses.User;
import in.ramakuru.sescenti.R;
import in.ramakuru.sescenti.adapters.konnektSearchAdapter;

public class SearchKonnekt extends AppCompatActivity {
    private konnektSearchAdapter mAdapter;
    private ArrayList<User> userList= new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_konnekt);

        fillExampleList();
        recyclerView = findViewById(R.id.search_konnekt_recycler);
        recyclerView.setHasFixedSize(true);
        aLayoutManager = new LinearLayoutManager(this);
        mAdapter = new konnektSearchAdapter(userList);

        recyclerView.setLayoutManager(aLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager aLayoutManager;





    private void fillExampleList() {
        userList.add(new User("Nirant","nirantr@gmail.com"));
        userList.add(new User("Anushtha","nirantr@gmail.com"));
        userList.add(new User("Pranav","nirantr@gmail.com"));
        userList.add(new User("Kalyan","nirantr@gmail.com"));
        userList.add(new User("Praneeth","nirantr@gmail.com"));
        userList.add(new User("Saumya","nirantr@gmail.com"));
        userList.add(new User("Nishita","nirantr@gmail.com"));
        userList.add(new User("Apoorva","nirantr@gmail.com"));
        userList.add(new User("Ankita","nirantr@gmail.com"));
        userList.add(new User("Nikhil","nirantr@gmail.com"));
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_konnekt,menu);

        MenuItem searchUser = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) searchUser.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
              mAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}
