package com.example.androidfirebasetutorial.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.example.androidfirebasetutorial.R;
import com.example.androidfirebasetutorial.holders.CardHolder;
import com.example.androidfirebasetutorial.models.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CardAdapter extends RecyclerView.Adapter<CardHolder> {

    private final List<UserModel> mUsers;

    public CardAdapter(ArrayList users) {
        mUsers = users;
    }

    @Override
    public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CardHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_card_view, parent, false));
    }

    @Override
    public void onBindViewHolder(CardHolder holder, int position) {
        holder.title.setText(String.format(Locale.getDefault(), "%s, %d - %s",
                mUsers.get(position).getName(),
                mUsers.get(position).getGrade(),
                mUsers.get(position).getCourse()
        ));
        holder.desc.setText(mUsers.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mUsers != null ? mUsers.size() : 0;
    }

    private void insertItem(UserModel user) {
        mUsers.add(user);
        notifyItemInserted(getItemCount());
    }

    public void updateList(UserModel user) {
        insertItem(user);
    }

    public void clearList() {
        mUsers.clear();
        notifyDataSetChanged();
    }
}