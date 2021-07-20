package com.example.covid_19tracker;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class vaccineAdapter extends RecyclerView.Adapter<vaccineAdapter.ViewHolder> {

    List<Vaccine> list;
    Context context;

    public vaccineAdapter(List<Vaccine> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.CenterName.setText(list.get(position).getCenter());
        holder.VaccineName.setText(list.get(position).getVaccine());
        holder.AvailableDoses.setText(list.get(position).getAvailable());

        holder.layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,Detail.class);
                i.putExtra("centerName",list.get(position).getCenter());
                i.putExtra("VaccineName",list.get(position).getVaccine());
                i.putExtra("AvailableDoses",list.get(position).getAvailable());
                i.putExtra("Address",list.get(position).getAddress());
                i.putExtra("State_name",list.get(position).getState_name());
                i.putExtra("District_name",list.get(position).getDistrict_name());
                i.putExtra("Block_name",list.get(position).getBlock_name());
                i.putExtra("From",list.get(position).getFrom());
                i.putExtra("To",list.get(position).getTo());
                i.putExtra("date1",list.get(position).getDate1());
                i.putExtra("Available_capacity_dose1",list.get(position).getAvailable_capacity_dose1());
                i.putExtra("Available_capacity_dose2",list.get(position).getAvailable_capacity_dose2());
                i.putExtra("Fee",list.get(position).getFee());
                i.putExtra("Min_age_limit",list.get(position).getMin_age_limit());
                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView CenterName,VaccineName,AvailableDoses;
        LinearLayout layout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            CenterName=itemView.findViewById(R.id.center);
            VaccineName=itemView.findViewById(R.id.vaccineName);
            AvailableDoses=itemView.findViewById(R.id.availableDoses);
            layout1=itemView.findViewById(R.id.layout1);
        }
    }
}
