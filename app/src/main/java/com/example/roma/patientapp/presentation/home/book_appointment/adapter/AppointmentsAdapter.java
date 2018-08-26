package com.example.roma.patientapp.presentation.home.book_appointment.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.roma.patientapp.R;
import com.example.roma.patientapp.data.model.doctor_details.DoctorAppointment;
import com.example.roma.patientapp.presentation.home.book_appointment.AppointmentBookedActivity;
import com.example.roma.patientapp.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Romisaa on 6/26/2018.
 */
public class AppointmentsAdapter extends RecyclerView.Adapter<AppointmentsAdapter.AppointmentViewHolder> {

    private List<DoctorAppointment> appointments;
    private AppointmentBookedActivity.OnItemClickListener listener;

    public AppointmentsAdapter(List<DoctorAppointment> appointments) {
        this.appointments = appointments;
    }

    @NonNull
    @Override
    public AppointmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.appointment_booking_row, parent, false);
        return new AppointmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentViewHolder holder, int position) {
        holder.bind(appointments.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return appointments.size();
    }

    class AppointmentViewHolder extends RecyclerView.ViewHolder {

        private TextView day, from, to;

        public AppointmentViewHolder(View view) {
            super(view);
            day = view.findViewById(R.id.day_tv);
            from = view.findViewById(R.id.from_tv);
            to = view.findViewById(R.id.to_tv);
        }

        private void bind(final DoctorAppointment appointment, final AppointmentBookedActivity.OnItemClickListener listener) {
            day.setText(DateUtils.convertDayNumToString(appointment.getDay()));
            from.setText(DateUtils.getFormatedTime(appointment.getFromHour()));
            to.setText(DateUtils.getFormatedTime(appointment.getToHour()));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(appointment);
                }
            });
        }
    }

    public void updateData(ArrayList<DoctorAppointment> doctorAppointments) {
        this.appointments = doctorAppointments;
        notifyDataSetChanged();
    }
}
