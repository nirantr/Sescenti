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

public class forwardRecyclerAdapter extends RecyclerView.Adapter<forwardRecyclerAdapter.MyViewHolder> {
    ArrayList<User> userList;
    private OnUserListener mOnUserListener;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView konnektName2;
        OnUserListener onUserListener;
        public MyViewHolder(View view, OnUserListener onUserListener) {
            super(view);
//            konnektName = (TextView) view.findViewById(R.id.konnektName);
            konnektName2 = (TextView) view.findViewById(R.id.forwardsListItemName);
            this.onUserListener = onUserListener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onUserListener.onUserClick(getAdapterPosition());
        }
    }

    public forwardRecyclerAdapter(
//            ArrayList<String> list,
            ArrayList<User> userList,
            OnUserListener onUserListener
    ) {
//        this.list = list;
        this.userList = userList;
        this.mOnUserListener = onUserListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_user_list, viewGroup, false);

        return new MyViewHolder(itemView, mOnUserListener);
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

    public interface OnUserListener{
        void onUserClick(int position);
    }

}

