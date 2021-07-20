package com.example.covid_19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    TextView centername,address,address1,timings,availability,vaccine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        centername=findViewById(R.id.centername);
        address=findViewById(R.id.address);
        address1=findViewById(R.id.address1);
        timings=findViewById(R.id.timings);
        availability=findViewById(R.id.availability);
        vaccine=findViewById(R.id.vaccine);

        String centerName =getIntent().getStringExtra("centerName");
        String VaccineName =getIntent().getStringExtra("VaccineName");
        String AvailableDoses =getIntent().getStringExtra("AvailableDoses");
        String Address =getIntent().getStringExtra("Address");
        String State_name =getIntent().getStringExtra("State_name");
        String District_name =getIntent().getStringExtra("District_name");
        String Block_name =getIntent().getStringExtra("Block_name");
        String From =getIntent().getStringExtra("From");
        String To =getIntent().getStringExtra("To");
        String date1 =getIntent().getStringExtra("date1");
        String Available_capacity_dose1 =getIntent().getStringExtra("Available_capacity_dose1");
        String Available_capacity_dose2 =getIntent().getStringExtra("Available_capacity_dose2");
        String Fee =getIntent().getStringExtra("Fee");
        String Min_age_limit =getIntent().getStringExtra("Min_age_limit");

        centername.setText(centerName);
        address.setText(Address);
        address1.setText(Block_name+" "+District_name+" "+State_name);
        timings.setText(From+" - "+To);
        availability.setText("Dose1 : "+Available_capacity_dose1+"  Dose2 : "+Available_capacity_dose2+"  Total : "+AvailableDoses);
        vaccine.setText(VaccineName);



    }
}