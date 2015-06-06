package com.paul.debashis.notificationpingservice;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private Intent mServiceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Creates an explicit Intent to start the service that constructs and
        // issues the notification.
        mServiceIntent = new Intent(getApplicationContext(), PingService.class);
    }

    /*
   * Gets the values the user entered and adds them to the intent that will be
   * used to launch the IntentService that runs the timer and issues the
   * notification.
   */
    public void onPingClick(View v) {
        int seconds;

        // Gets the reminder text the user entered.
        EditText msgText = (EditText) findViewById(R.id.edit_reminder);
        String message = msgText.getText().toString();

        mServiceIntent.putExtra(CommonConstants.EXTRA_MESSAGE, message);
        mServiceIntent.setAction(CommonConstants.ACTION_PING);
        Toast.makeText(this, R.string.timer_start, Toast.LENGTH_SHORT).show();

        // The number of seconds the timer should run.
        EditText editText = (EditText)findViewById(R.id.edit_seconds);
        String input = editText.getText().toString();

        if(input == null || input.trim().equals("")){
            // If user didn't enter a value, sets to default.
            seconds = R.string.seconds_default;
        } else {
            seconds = Integer.parseInt(input);
        }
        int milliseconds = (seconds * 1000);
        mServiceIntent.putExtra(CommonConstants.EXTRA_TIMER, milliseconds);
        // Launches IntentService "PingService" to set timer.
        startService(mServiceIntent);
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
}
