package com.example.roma.patientapp.presentation.home.search_doctor;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.roma.patientapp.R;
import com.example.roma.patientapp.data.model.search_doctor.Doctor;

import java.util.ArrayList;

/**
 * Created by Romisaa on 6/17/2018.
 */

public class SearchDoctorAdapter extends RecyclerView.Adapter<SearchDoctorAdapter.SearchDoctorViewHolder> {

    private ArrayList<Doctor> doctors;
    private int itemNum;
    private OnItemClickListener listener;

    public SearchDoctorAdapter(ArrayList<Doctor> doctors, OnItemClickListener listener) {
        this.doctors = doctors;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SearchDoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.doc_row, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(doctors.get(itemNum));
            }
        });
        return new SearchDoctorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchDoctorViewHolder holder, int position) {
        Doctor doctor = doctors.get(position);
        holder.name.setText(doctor.getLastName());
        holder.speciality.setText(doctor.getSpeciality());
        holder.date.setText("date");
        itemNum = position;
    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }

    public void updateData(ArrayList<Doctor> items) {
        doctors.clear();
        doctors.addAll(items);
        notifyDataSetChanged();
    }

    class SearchDoctorViewHolder extends RecyclerView.ViewHolder {
        private ImageView photo;
        private TextView name;
        private TextView speciality;
        private TextView date;

        public SearchDoctorViewHolder(View view) {
            super(view);
            photo = (ImageView) view.findViewById(R.id.photo_iv);
            name = (TextView) view.findViewById(R.id.name_tv);
            speciality = (TextView) view.findViewById(R.id.speciality_tv);
            date = (TextView) view.findViewById(R.id.date_tv);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Doctor doctor);
    }
}


