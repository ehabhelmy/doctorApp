package com.example.roma.patientapp.presentation.home.appointments.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.roma.patientapp.R;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.AppointmentRequestDetailModel;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.Request;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Romisaa on 6/29/2018.
 */
public class AppointmentsAdapter extends RecyclerView.Adapter<AppointmentsAdapter.AppointmentViewHolder> {

    private ArrayList<Request> list;
    private OnAppointmentAction onAppointmentAction;

    public void setOnAppointmentAction(OnAppointmentAction onAppointmentAction) {
        this.onAppointmentAction = onAppointmentAction;
    }

    public AppointmentsAdapter() {
        this.list = new ArrayList<>();
    }

    public interface OnAppointmentAction {
        void onRequestApproved(String id);
        void onRequestRejected(String id);
        void onRequestFinished(String id);
    }

    @NonNull
    @Override
    public AppointmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.appointment_request_details_row, parent, false);

        return new AppointmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updateData(ArrayList<Request> data) {
        list.clear();
        if (data != null) {
            list.addAll(data);
        }
        notifyDataSetChanged();
    }

    class AppointmentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.photo_iv)
        ImageView photo;
        @BindView(R.id.name_tv)
        TextView name;
        @BindView(R.id.time_tv)
        TextView time;
        @BindView(R.id.approve)
        TextView approve;
        @BindView(R.id.reject)
        TextView reject;
        @BindView(R.id.finish)
        TextView finish;

        public AppointmentViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }

        public void bind(final Request model) {
            name.setText(model.getPatientName());
            time.setText("");
            approve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onAppointmentAction.onRequestApproved(model.getClientId());
                }
            });
            reject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onAppointmentAction.onRequestRejected(model.getClientId());
                }
            });
            finish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onAppointmentAction.onRequestFinished(model.getClientId());
                }
            });
        }
    }
}
