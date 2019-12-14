package com.example.dormswappersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;

public class CentralBuildings extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_buildings);

        listView = (ListView)findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        new Connection().execute();
    }

    class Connection extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... params) {
            String result = "";
            String host = "http://10.0.2.2/dorms.php";
            try {
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(host));
                HttpResponse response = client.execute(request);
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                StringBuffer stringBuffer = new StringBuffer("");
                String line = "";
                while ((line = reader.readLine()) != null) {
                    stringBuffer.append(line);
                    break;
                }
                reader.close();
                result = stringBuffer.toString();
            }
            catch (Exception e){
                return new String("There exception" + e.getMessage());
            }
            return result;
        }
        @Override
        protected void onPostExecute(String result){
            try {
                JSONObject jsonResult = new JSONObject(result);
                int success = jsonResult.getInt("success");
                if (success == 1) {
                    JSONArray dorms = jsonResult.getJSONArray("buildings_data");
                    //Toast.makeText(getApplicationContext(), car.getString("name"), Toast.LENGTH_SHORT).show();
                    for (int i = 0; i<dorms.length();i++) {
                        JSONObject dorm = dorms.getJSONObject(i);
                        int id = dorm.getInt("id");
                        String location = dorm.getString("location");
                        String address = dorm.getString("address");
                        String roomtype = dorm.getString("roomtype");
                        String email = dorm.getString("email");
                        String line =  "Building: " + address + "\n" + "Number of Occupants: " + roomtype + "\n" +  "Email: " + email;
                        if (location.equals("central") || location.equals("Central")){
                            adapter.add(line);
                        }
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "There is no dorm yet!", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }
    }
}

