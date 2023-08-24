package com.example.campusmedic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import java.util.Calendar;

public class EventSignUp extends Fragment {

    private static final long ALARM_DELAY = 5000; // Alarm set for 3 minutes from now

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event_sign_up, container, false);

        Button addEventButton = rootView.findViewById(R.id.set_alarm);
        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAlarm();
            }
        });

        return rootView;
    }

    private void createAlarm() {

        long alarmTime = System.currentTimeMillis() + ALARM_DELAY;

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(alarmTime);

        Toast.makeText(requireContext(), "Successfully Signed-Up for Events", Toast.LENGTH_SHORT).show();
        startAlarm(c);
    }

    private  void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) requireContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getContext(), AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getContext(), 1, intent, 0);

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
    }

}
