package com.example.androidfirebasetutorial.holders;


import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.androidfirebasetutorial.R;


public class CardHolder extends RecyclerView.ViewHolder {

    public TextView title;


    public TextView desc;

    public ImageButton moreButton;


    public ImageButton deleteButton;

    public CardHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.main_card_title);
        desc = itemView.findViewById(R.id.main_card_desc);
    }
}