//# COMP 4521    #  TO, Kai Yuen 20410782 kytoac@connect.ust.hk
//# COMP 4521    #  WONG, Lap Wong 20602036 lwwongaf@connect.ust.hk

package com.example.sportsfacilitiesfinderhk.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportsfacilitiesfinderhk.R;
import com.example.sportsfacilitiesfinderhk.ui.facilitiesdetails.FacilitiesDetailsActivity;
import com.example.sportsfacilitiesfinderhk.ui.facilitieslist.FacilitiesListActivity;
import com.example.sportsfacilitiesfinderhk.utilities.DataManager;

import java.util.ArrayList;

public class SportsTypeRecViewAdapter extends RecyclerView.Adapter<SportsTypeRecViewAdapter.ViewHolder> {
    Context context;
    String[] sports;

    public SportsTypeRecViewAdapter(Context context, String[] sports) {
        this.context = context;
        this.sports = sports;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.sports_type_button, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: start activity
                Intent intent = new Intent(context, FacilitiesListActivity.class);
                intent.putExtra("sportsType", sports[position]);
                intent.putExtra("isBookmarkPage", false);
                context.startActivity(intent);
            }
        });
        holder.titleTextView.setText(sports[position]);
        holder.icon.setImageResource(DataManager.getIconID()[position]);
    }

    @Override
    public int getItemCount() {
        return sports.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ConstraintLayout parentLayout;
        TextView titleTextView;
        ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.sports_type_button_layout);
            titleTextView = itemView.findViewById(R.id.sport_title_tv);
            icon = itemView.findViewById(R.id.sports_type_button_banner);
        }
    }
}
