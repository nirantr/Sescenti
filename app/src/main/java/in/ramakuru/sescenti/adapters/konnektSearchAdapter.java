package in.ramakuru.sescenti.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import in.ramakuru.sescenti.ObjectClasses.User;
import in.ramakuru.sescenti.R;

public class konnektSearchAdapter extends RecyclerView.Adapter<konnektSearchAdapter.MyViewHolder> implements Filterable {
    private ArrayList<User> userList;
    private ArrayList<User> userListFull;

    public class MyViewHolder extends RecyclerView.ViewHolder  {
        public TextView forwardsListItemName;
        public TextView forwardsListItemEmail;

        public MyViewHolder(View view) {
            super(view);
            forwardsListItemName = view.findViewById(R.id.forwardsListItemName);
            forwardsListItemEmail = view.findViewById(R.id.forwardsListItemEmail);
        }
    }

    public konnektSearchAdapter(ArrayList<User> userList) {
        this.userList = userList;
        userListFull = new  ArrayList<User>(userList);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_search_konnekt_item, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        User currentUser = userList.get(i);
//        myViewHolder.konnektName.setText(list.get(i));
        myViewHolder.forwardsListItemName.setText(currentUser.firstName);

        myViewHolder.forwardsListItemEmail.setText(currentUser.email);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    @Override
    public Filter getFilter() {
        return userFilter;
    }

    private Filter userFilter = new Filter() {
        @org.jetbrains.annotations.NotNull
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
           ArrayList<User> filteredList = new ArrayList<User>();
           if(constraint == null || constraint.length()==0){
               filteredList.addAll(userListFull);
           }else{
               String filterPattern = constraint.toString().toLowerCase().trim();
                for(User item : userListFull){
                    if(item.firstName.toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
           }
           FilterResults results = new FilterResults();
           results.values = filteredList;
        return  results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            userList.clear();
            userList.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };

}

