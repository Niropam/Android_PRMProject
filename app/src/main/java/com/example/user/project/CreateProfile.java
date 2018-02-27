package com.example.user.project;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Calendar;

public class CreateProfile extends AppCompatActivity {

    EditText name,father,mother,address,nationality,iD,location;
    Button button1,bdate;
    RadioButton male,female,others;
    DatePickerDialog datePickerDialog;
    public int bDay, bMonth, bYear;
    TextView birthDate;
    Calendar c1;
    int x,y,z;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        name = (EditText) findViewById(R.id.name);
        father = (EditText) findViewById(R.id.fname);
        mother = (EditText) findViewById(R.id.mname);
        address=(EditText) findViewById(R.id.address);
        nationality=(EditText) findViewById(R.id.nationality);
        iD=(EditText) findViewById(R.id.nationalId);
        location=(EditText) findViewById(R.id.currentLocation);

        male=(RadioButton) findViewById(R.id.male);
        female=(RadioButton) findViewById(R.id.female);
        others=(RadioButton) findViewById(R.id.other);

        bdate = (Button) findViewById(R.id.datePick);
        birthDate = (TextView) findViewById(R.id.birthdayView1);

        bdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c1 = Calendar.getInstance();
                bYear = c1.get(Calendar.YEAR);
                bMonth = c1.get(Calendar.MONTH);
                bDay = c1.get(Calendar.DAY_OF_MONTH);

                // date picker dialog
                datePickerDialog = new DatePickerDialog(CreateProfile.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        birthDate.setText(dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                        x=dayOfMonth;y=(monthOfYear+1);z=year;
                        c1.set(year, monthOfYear, dayOfMonth);
                    }
                }, bYear, bMonth, bDay);
                datePickerDialog.show();
            }
        });

    }


    public void submit(View view) {
       String gender = null;
        if(male.isChecked()){
            gender="Male";
        }
        if(female.isChecked()){
            gender="Female";
        }
        if(others.isChecked()){
            gender="Others";
        }

        String genderPick=gender;
        String nameText = name.getText().toString();
        String fatherText = father.getText().toString();
        String motherText = mother.getText().toString();
        String addressText = address.getText().toString();
        String nationalityText = nationality.getText().toString();
        String nationalID = iD.getText().toString();
        String locationText=location.getText().toString();
        String dateString=(x+"/"+y+"/"+z);
        Bundle bundle = new Bundle();
        bundle.putString("Name", nameText);
        bundle.putString("Father", fatherText);
        bundle.putString("Mother", motherText);
        bundle.putString("Bdate",dateString);
        bundle.putString("Gender",genderPick);
        bundle.putString("Address", addressText);
        bundle.putString("Nationality", nationalityText);
        bundle.putString("NationalID", nationalID);
        bundle.putString("Location",locationText);

        Intent intent = new Intent(CreateProfile.this, ViewProfile.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
