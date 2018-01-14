package com.swishsoftwaresolutions.json;

import android.app.ProgressDialog;
import android.icu.util.Output;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;

public class Json_example extends AppCompatActivity {

//    String json_object = "{\"student_record\": [{\"Name\" : \"Vaishnavi\",\"Rollnumber\": 25,\"Phonenumber\": \"9886899189\"},{\"Name\" : \"Bharath\",\"Rollnumber\": 26,\"Phonenumber\":\"8105292020\"}]}";
//    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_example);
        new Asynctask().execute();
//        button = (Button)findViewById(R.id.click);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                try {
//                    Log.e("JsonString",json_object);
//
//                    JSONObject jsonObject = new JSONObject(json_object);
//                    JSONArray jsonArray = jsonObject.getJSONArray("student_record");
//
//                    for (int i=0;i<jsonArray.length();i++){
//                        JSONObject obj = jsonArray.getJSONObject(i);
//
//                        String name = obj.getString("Name").toString();
//                        int id = obj.getInt("Rollnumber");
//                        String phone = obj.getString("Phonenumber").toString();
//
//                        Log.e("Name",name);
//                        Log.e("Roll number",""+id);
//                        Log.e("Phone number",phone);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }
        class Asynctask extends AsyncTask {
            ProgressDialog progressDialog;
            private static final String URI = "http://serviceapi.skholingua.com/open-feeds/simple_json.php";
             @Override
             protected void onPreExecute() {
                 super.onPreExecute();
                 progressDialog = new ProgressDialog(Json_example.this);
                 progressDialog.setMessage("Getting Data");
                 progressDialog.show();
             }

             @Override
            protected Object doInBackground(Object[] objects) {
                 String data = HTTPUrlConnection.getData(URI);
                 JSONObject jsonObject =null;
                try {
//                    Log.e("JsonString",json_object);
                    Log.e("In try block","");
                    jsonObject = new JSONObject(data);
                    String name = jsonObject.get("name").toString();
                    String version = jsonObject.get("version").toString();
                    Log.e("Name:",name);
                    Log.e("Version:",version);

                } catch (JSONException e) {
                    Log.e("In catch block","");
                    e.printStackTrace();
                }
                return null;
            }

             @Override
             protected void onPostExecute(Object o) {
                 super.onPostExecute(o);
                progressDialog.dismiss();
             }
         }
    }

