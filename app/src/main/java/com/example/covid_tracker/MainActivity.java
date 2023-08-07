package com.example.covid_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarException;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ModalClass modalClass;
    AdapterClass adapterClass;
    public static List<ModalClass> list= new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        fetchData();
    }
    public void fetchData()
    {
        String url="https://data.covid19india.org/state_district_wise.json";
        StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
              try{
                  JSONObject jsonObject= new JSONObject(response);
                  JSONObject jsonObject1= jsonObject.getJSONObject("Uttar Pradesh");
                  JSONObject jsonObject2= jsonObject1.getJSONObject("districtData");
                  JSONObject jsonObject3= jsonObject2.getJSONObject("Prayagraj");

                  String active= jsonObject3.getString("active");
                  String confirm= jsonObject3.getString("confirmed");
                  String recover= jsonObject3.getString("recovered");

                  modalClass= new ModalClass(active,recover,confirm,"Prayagraj","Uttar Pradesh");
                  list.add(modalClass);

                  jsonObject3=jsonObject2.getJSONObject("Lucknow");
                  active=jsonObject3.getString("active");
                  confirm=jsonObject3.getString("confirmed");
                  recover=jsonObject3.getString("recovered");
                  modalClass = new ModalClass(active,recover,confirm,"Lucknow","Uttar Pradesh");
                  list.add(modalClass);

                  jsonObject3=jsonObject2.getJSONObject("Jhansi");
                  active=jsonObject3.getString("active");
                  confirm=jsonObject3.getString("confirmed");
                  recover=jsonObject3.getString("recovered");
                  modalClass = new ModalClass(active,recover,confirm,"Jhansi","Uttar Pradesh");
                  list.add(modalClass);
                  jsonObject3=jsonObject2.getJSONObject("Firozabad");
                  active=jsonObject3.getString("active");
                  confirm=jsonObject3.getString("confirmed");
                  recover=jsonObject3.getString("recovered");
                  modalClass = new ModalClass(active,recover,confirm,"Firozabad","Uttar Pradesh");
                  list.add(modalClass);
                  adapterClass= new AdapterClass(MainActivity.this,list);
                  listView.setAdapter(adapterClass);
                  adapterClass.notifyDataSetChanged();

              }catch (JSONException e) {
                  throw new RuntimeException(e);
              }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Here and error"+ error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}