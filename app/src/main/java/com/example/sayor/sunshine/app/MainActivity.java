package com.example.sayor.sunshine.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    ShareActionProvider sap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ForecastFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            Intent i=new Intent(this,SettingsActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.showonmap) {

            SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
            String loc=pref.getString("loc","");

            Intent i=new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("geo:0,0?q="+loc));
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
