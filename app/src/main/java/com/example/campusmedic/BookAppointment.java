package com.example.campusmedic;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BookAppointment extends Fragment {

    EditText editName, editAge, editStatement, editTextDate, editTextTime;
    Button submitBtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    FirebaseAuth auth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_appointment, container, false);

        auth = FirebaseAuth.getInstance();

        editName = view.findViewById(R.id.studentName);
        editAge = view.findViewById(R.id.age);
        editStatement = view.findViewById(R.id.statement);
        editTextDate = view.findViewById(R.id.editTextDate);
        editTextTime = view.findViewById(R.id.editTextTime);
        submitBtn = view.findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        return view;
    }

    public void saveData() {
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Appointments");

        String name = editName.getText().toString();
        String statement = editStatement.getText().toString();
        String date = editTextDate.getText().toString();
        String time = editTextTime.getText().toString();
        int age = Integer.parseInt(editAge.getText().toString());
        String userId = auth.getCurrentUser().getUid();

        Dataclass helperClass = new Dataclass(userId, name, age, statement, date, time);

        reference.child(userId).setValue(helperClass);

        editName.setText("");
        editAge.setText("");
        editStatement.setText("");
        editTextDate.setText("");
        editTextTime.setText("");

        Toast.makeText(getContext(), "Appointment booked successfully!", Toast.LENGTH_SHORT).show();
    }
}
