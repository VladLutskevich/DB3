package com.example.db3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;


public class Main2Activity extends AppCompatActivity {
    Button button;
    Button button4;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    EditText editText7;
    RequestQueue queue;
    String url;
    JsonObjectRequest request;
    JSONObject json;
    String strId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        button = (Button) findViewById(R.id.button);
        button4 = (Button) findViewById(R.id.button4);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);
        editText5 = (EditText)findViewById(R.id.editText5);
        editText6 = (EditText)findViewById(R.id.editText6);
        editText7 = (EditText)findViewById(R.id.editText7);

        Intent intent = getIntent();
        String str1 = intent.getStringExtra("str1");

        url = "http://46.101.205.23:4444/test_db/" + str1 + "/";
        queue = Volley.newRequestQueue(this);
        request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject s) {

                Iterator<String> iter = s.keys();
                while (iter.hasNext()) {
                String key = iter.next();

                editText2.setText(key);
                Object value = null;
                try {
                    value = s.get(key);
                } catch (JSONException e) {
                }
                editText3.setText(value.toString());
            }}

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                editText2.setText("That didn't work!");
            }

        });
        queue.add(request);
    }}