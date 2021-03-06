//# COMP 4521    #  TO, Kai Yuen 20410782 kytoac@connect.ust.hk
//# COMP 4521    #  WONG, Lap Wong 20602036 lwwongaf@connect.ust.hk

package com.example.sportsfacilitiesfinderhk.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportsfacilitiesfinderhk.R;
import com.example.sportsfacilitiesfinderhk.models.SportFacility;
import com.example.sportsfacilitiesfinderhk.ui.facilitiesdetails.FacilitiesDetailsActivity;

import java.util.List;

public class FacilitiesListAdapter extends RecyclerView.Adapter<FacilitiesListAdapter.ViewHolder> {
    Context context;
    List<SportFacility> sportFacilities;
    Boolean isBookmarkPage;

    public FacilitiesListAdapter(Context context, List<SportFacility> sportFacilities, Boolean isBookmarkPage) {
        this.context = context;
        this.sportFacilities = sportFacilities;
        this.isBookmarkPage = isBookmarkPage;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.facilities_list_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FacilitiesDetailsActivity.class);
                intent.putExtra("index", position);
                intent.putExtra("isBookmarkPage", isBookmarkPage);
                context.startActivity(intent);
            }
        });
        SportFacility currSportFac = sportFacilities.get(position);
        String name = isBookmarkPage ? currSportFac.getName()+"("+currSportFac.getType()+")" : currSportFac.getName();
        holder.titleTextView.setText(name);
    }

    @Override
    public int getItemCount() {
        return sportFacilities.size();
    }

    public void setSportFacilities(List<SportFacility> list) {
        this.sportFacilities = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ConstraintLayout parentLayout;
        TextView titleTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.facilities_list_item_layout);
            titleTextView = itemView.findViewById(R.id.facilities_list_item_name);
        }
    }
}
