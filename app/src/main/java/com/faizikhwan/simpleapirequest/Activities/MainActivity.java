package com.faizikhwan.simpleapirequest.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.faizikhwan.simpleapirequest.Models.WaktuSolat;
import com.faizikhwan.simpleapirequest.R;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private TextView zoneTV, dateTV, locationsTV, imsakTV, subuhTV, syurukTV, zohorTV, asarTV,
            maghribTV, isyakTV;
    private ProgressBar progressCircular;
    RequestQueue mQueue;

    String url = "https://api.azanpro.com/times/today.json?zone=sgr01&format=12-hour";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
        mQueue = Volley.newRequestQueue(this);
        fetchPrayerTime();
    }

    private void initComponent() {
        zoneTV = findViewById(R.id.zoneTV);
        dateTV = findViewById(R.id.dateTV);
        locationsTV = findViewById(R.id.locationsTV);
        imsakTV = findViewById(R.id.imsakTV);
        subuhTV = findViewById(R.id.subuhTV);
        syurukTV = findViewById(R.id.syurukTV);
        zohorTV = findViewById(R.id.zohorTV);
        asarTV = findViewById(R.id.asarTV);
        maghribTV = findViewById(R.id.maghribTV);
        isyakTV = findViewById(R.id.isyakTV);
        progressCircular = findViewById(R.id.progress_circular);
    }

    private void fetchPrayerTime() {
        progressCircular.setVisibility(View.VISIBLE);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "response: " + response.toString());
                Gson gson = new Gson();
                WaktuSolat obj = gson.fromJson(response.toString(), WaktuSolat.class);
                progressCircular.setVisibility(View.GONE);
                displayPrayerTime(obj);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "error: " + error.getLocalizedMessage());
                progressCircular.setVisibility(View.GONE);
                displayAlertDialog("Error", error.getLocalizedMessage());
            }
        });

        mQueue.add(request);
    }

    private void displayAlertDialog(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void displayPrayerTime(WaktuSolat obj) {
        zoneTV.setText(obj.getZone());
        dateTV.setText(obj.getPrayerTimes().getDate());
        locationsTV.setText(String.join(", ", obj.getLocations()));
        imsakTV.setText(obj.getPrayerTimes().getImsak());
        subuhTV.setText(obj.getPrayerTimes().getSubuh());
        syurukTV.setText(obj.getPrayerTimes().getSyuruk());
        zohorTV.setText(obj.getPrayerTimes().getZohor());
        asarTV.setText(obj.getPrayerTimes().getAsar());
        maghribTV.setText(obj.getPrayerTimes().getMaghrib());
        isyakTV.setText(obj.getPrayerTimes().getIsyak());
    }
}
