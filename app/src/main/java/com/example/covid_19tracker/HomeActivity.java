package com.example.covid_19tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {

    EditText pincode;
    TextView date;
    Button availability;
    RecyclerView recyclerView;
    ArrayList<Vaccine> list;
    vaccineAdapter vaccineAdapter;
    Calendar c;
    DatePickerDialog d;
    TimePickerDialog t;

    LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        pincode=findViewById(R.id.pincode);
        date=findViewById(R.id.date);
        availability=findViewById(R.id.availability);
        recyclerView=findViewById(R.id.recycler);

        list=new ArrayList<>();
        vaccineAdapter=new vaccineAdapter(list,this);

        linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(vaccineAdapter);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=Calendar.getInstance();
                int day=c.get(Calendar.DAY_OF_MONTH);
                int m=c.get(Calendar.MONTH);
                int y=c.get(Calendar.YEAR);

                d=new DatePickerDialog(HomeActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month=month+1;
                        date.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                },y,m,day);
                d.show();

            }
        });

        availability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                String Pincode=pincode.getText().toString();
                String Date=date.getText().toString();

                list.clear();

                String url="https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode="+Pincode+"&date="+Date;
                StringRequest stringRequest = new StringRequest(Request.Method.GET,url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {

                                    JSONObject jsonObject = new JSONObject(response);

                                    JSONArray jsonArray=jsonObject.getJSONArray("sessions");
                                    int length=jsonArray.length();

                                    for (int i=0;i<length;i++){
                                        JSONObject jsonObject1=jsonArray.getJSONObject(i);
                                        String Name=jsonObject1.getString("name");
                                        String Vaccine=jsonObject1.getString("vaccine");
                                        String Available=jsonObject1.getString("available_capacity");
                                        String Address=jsonObject1.getString("address");
                                        String State_name=jsonObject1.getString("state_name");
                                        String District_name=jsonObject1.getString("district_name");
                                        String Block_name=jsonObject1.getString("block_name");
                                        String From=jsonObject1.getString("from");
                                        String To=jsonObject1.getString("to");
                                        String date1=jsonObject1.getString("date");
                                        String Available_capacity_dose1=jsonObject1.getString("available_capacity_dose1");
                                        String Available_capacity_dose2=jsonObject1.getString("available_capacity_dose2");
                                        String Fee=jsonObject1.getString("fee");
                                        String Min_age_limit=jsonObject1.getString("min_age_limit");

                                        //JSONObject jsonObject2=jsonObject1.getJSONArray("media").getJSONObject(0);
                                        //JSONObject jsonObject2=jsonArray1.getJSONObject(0);
                                        //JSONObject jsonObject3=jsonObject2.getJSONArray("media-metadata").getJSONObject(0);
                                        //JSONObject jsonObject3=jsonArray2.getJSONObject(0);
                                        //String urltoimage=jsonObject3.getString("url");


                                        Vaccine vaccine=new Vaccine(Name,Vaccine,Available,Address,State_name,District_name,Block_name,From,To,date1,Available_capacity_dose1,Available_capacity_dose2,Fee,Min_age_limit);
                                        list.add(vaccine);
                                    }
                                    vaccineAdapter.notifyDataSetChanged();


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(HomeActivity.this,"Invalid Data entered !!", Toast.LENGTH_SHORT).show();
                    }

                });



                RequestQueue requestQueue = Volley.newRequestQueue(HomeActivity.this);
                requestQueue.add(stringRequest);

            }
        });
    }
}