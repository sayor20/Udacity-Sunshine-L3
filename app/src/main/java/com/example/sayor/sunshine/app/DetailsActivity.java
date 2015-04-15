package com.example.sayor.sunshine.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DetailsActivity extends ActionBarActivity {

    ShareActionProvider sap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_details2);
        Intent intent=getIntent();
        TextView t1=(TextView)findViewById(R.id.tv1);
        t1.setText(intent.getStringExtra("data"));
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_details, menu);

        sap = (ShareActionProvider) MenuItemCompat.getActionProvider(menu.findItem(R.id.share));
        Intent inte=getDefaultShareIntent();
        sap.setShareIntent(inte);
        return true;
    }

    public Intent getDefaultShareIntent(){
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, "SUBJECT");
        i.putExtra(Intent.EXTRA_TEXT,"Extra Text");
        return i;
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

        return super.onOptionsItemSelected(item);
    }
}
