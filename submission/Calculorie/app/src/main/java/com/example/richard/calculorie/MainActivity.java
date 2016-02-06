package com.example.richard.calculorie;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ImageView;
import android.text.TextWatcher;
import android.text.Editable;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {
    EditText numberRead;
    TextView pushValue;
    TextView sitValue;
    TextView jumpValue;
    TextView jogValue;
    TextView sqValue;
    TextView llValue;
    TextView plankValue;
    TextView pullValue;
    TextView cycleValue;
    TextView walkValue;
    TextView swimValue;
    TextView stairValue;
    TextView calories;
    Spinner unit;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        unit = (Spinner) findViewById(R.id.spinner);
        calories = (TextView) findViewById(R.id.cal);
        numberRead = (EditText) findViewById(R.id.numberinput);
        pushValue = (TextView) findViewById(R.id.push);
        sitValue = (TextView) findViewById(R.id.sit);
        jumpValue = (TextView) findViewById(R.id.jump);
        jogValue = (TextView) findViewById(R.id.jog);
        sqValue = (TextView) findViewById(R.id.sq);
        llValue = (TextView) findViewById(R.id.ll);
        plankValue = (TextView) findViewById(R.id.plank);
        pullValue = (TextView) findViewById(R.id.pull);
        cycleValue = (TextView) findViewById(R.id.cycle);
        walkValue = (TextView) findViewById(R.id.walk);
        swimValue = (TextView) findViewById(R.id.swim);
        stairValue = (TextView) findViewById(R.id.stair);

        ImageView pushIcon = (ImageView) findViewById(R.id.pushPic);
        pushIcon.setImageResource(R.drawable.pushup);
        ImageView sitIcon = (ImageView) findViewById(R.id.sitPic);
        sitIcon.setImageResource(R.drawable.situp);
        ImageView jumpIcon = (ImageView) findViewById(R.id.jumpPic);
        jumpIcon.setImageResource(R.drawable.jump);
        ImageView jogIcon = (ImageView) findViewById(R.id.jogPic);
        jogIcon.setImageResource(R.drawable.jog);
        ImageView sqIcon = (ImageView) findViewById(R.id.sqPic);
        sqIcon.setImageResource(R.drawable.sq);
        ImageView llIcon = (ImageView) findViewById(R.id.llPic);
        llIcon.setImageResource(R.drawable.ll);
        ImageView plankIcon = (ImageView) findViewById(R.id.plankPic);
        plankIcon.setImageResource(R.drawable.plank);
        ImageView pullIcon = (ImageView) findViewById(R.id.pullPic);
        pullIcon.setImageResource(R.drawable.pull);
        ImageView cycleIcon = (ImageView) findViewById(R.id.cyclePic);
        cycleIcon.setImageResource(R.drawable.cycle);
        ImageView walkIcon = (ImageView) findViewById(R.id.walkPic);
        walkIcon.setImageResource(R.drawable.walk);
        ImageView swimIcon = (ImageView) findViewById(R.id.swimPic);
        swimIcon.setImageResource(R.drawable.swim);
        ImageView stairIcon = (ImageView) findViewById(R.id.stairPic);
        stairIcon.setImageResource(R.drawable.stair);

        numberRead.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                calculateValues();
            }
        });

        unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                calculateValues();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public boolean calculateValues() {
        String numberValue = numberRead.getText().toString();
        double trueValue = -1;
        int number;
        if (numberValue.length() == 0) {
            number = 0;
        } else {
            number = Integer.parseInt(numberValue);
        }
        String units = unit.getSelectedItem().toString();
        switch (units) {
            case "Push-ups":
                trueValue = (number / 350.0 * 100.0);
                break;
            case "Sit-ups":
                trueValue = (number / 200.0 * 100.0);
                break;
            case "Jumping jacks (mins)":
                trueValue = (number / 10.0 * 100.0);
                break;
            case "Jogging (mins)":
                trueValue = (number / 12.0 * 100.0);
                break;
            case "Squats":
                trueValue = (number / 225.0 * 100.0);
                break;
            case "Leg-lifts (mins)":
                trueValue = (number / 25.0 * 100.0);
                break;
            case "Planks (mins)":
                trueValue = (number / 25.0 * 100.0);
                break;
            case "Pullups":
                trueValue = (number / 100.0 * 100.0);
                break;
            case "Cycling (mins)":
                trueValue = (number / 12.0 * 100.0);
                break;
            case "Walking (mins)":
                trueValue = (number / 20.0 * 100.0);
                break;
            case "Swimming (mins)":
                trueValue = (number / 13.0 * 100.0);
                break;
            case "Stairclimbing (mins)":
                trueValue = (number / 15.0 * 100.0);
                break;
            case "Calories":
                trueValue = (double) number;
                break;
        }
        if (trueValue == -1) {
            return false;
        }

        numberRead = (EditText) findViewById(R.id.numberinput);
        pushValue.setText(Integer.toString((int) Math.round(trueValue / 100.0 * 350.0)));
        sitValue.setText(Integer.toString((int) Math.round(trueValue / 100.0 * 200.0)));
        jumpValue.setText(Integer.toString((int) Math.round(trueValue / 100.0 * 10.0)) + " mins");
        jogValue.setText(Integer.toString((int) Math.round(trueValue / 100.0 * 12.0)) + " mins");
        sqValue.setText(Integer.toString((int) Math.round(trueValue / 100.0 * 225.0)));
        llValue.setText(Integer.toString((int) Math.round(trueValue / 100.0 * 25.0)) + " mins");
        plankValue.setText(Integer.toString((int) Math.round(trueValue / 100.0 * 25.0)) + " mins");
        pullValue.setText(Integer.toString((int) Math.round(trueValue / 100.0 * 100.0)));
        cycleValue.setText(Integer.toString((int) Math.round(trueValue / 100.0 * 12.0)) + " mins");
        walkValue.setText(Integer.toString((int) Math.round(trueValue / 100.0 * 20.0)) + " mins");
        swimValue.setText(Integer.toString((int) Math.round(trueValue / 100.0 * 13.0)) + " mins");
        stairValue.setText(Integer.toString((int) Math.round(trueValue / 100.0 * 15.0)) + " mins");
        calories.setText(Integer.toString((int) Math.round(trueValue)));
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.richard.calculorie/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.richard.calculorie/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
