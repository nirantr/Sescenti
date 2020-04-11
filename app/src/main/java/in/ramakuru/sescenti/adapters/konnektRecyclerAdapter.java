package in.ramakuru.sescenti.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import in.ramakuru.sescenti.ObjectClasses.User;
import in.ramakuru.sescenti.R;

public class konnektRecyclerAdapter extends RecyclerView.Adapter<konnektRecyclerAdapter.MyViewHolder>

{
    ArrayList<User> userList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView konnektName2;

        public MyViewHolder(View view) {
            super(view);
            konnektName2 = (TextView) view.findViewById(R.id.forwardsListItemName);
        }
    }

    public konnektRecyclerAdapter(ArrayList<User> userList) {
        this.userList = userList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_user_list, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
//        myViewHolder.konnektName.setText(list.get(i));
        myViewHolder.konnektName2.setText(userList.get(i).firstName + " : " + userList.get(i).email);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}

