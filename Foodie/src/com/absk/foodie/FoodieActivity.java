package com.absk.foodie;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;
import android.widget.Toast;

public class FoodieActivity extends Activity{
    
	Intent I;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //SharedPreferences prefs = getSharedPreferences("Preferences",0);
        
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String u = prefs.getString("uname", "");
        if(u==""){
        	I = new Intent(this, Preferences.class);
        	startActivity(I); 	
        }
        TextView t = (TextView)findViewById(R.id.textarea);
        
        t.append("--> " + u + " <--");
        
        LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        LocationListener mlocListener = new MyLocationListener();


        mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
        mlocManager.requestLocationUpdates( LocationManager.NETWORK_PROVIDER, 0, 0, mlocListener);
    }
    
    

    public class MyLocationListener implements LocationListener{

    	@Override

    	public void onLocationChanged(Location loc)

    	{

    	loc.getLatitude();

    	loc.getLongitude();

    	String Text = "My current location is: " +

    	"Latitud = " + loc.getLatitude() +

    	"Longitud = " + loc.getLongitude();


    	Toast.makeText( getApplicationContext(),Text,Toast.LENGTH_SHORT).show();

    	}


    	@Override

    	public void onProviderDisabled(String provider)

    	{

    	Toast.makeText( getApplicationContext(),"Gps Disabled",	Toast.LENGTH_SHORT ).show();

    	}


    	@Override

    	public void onProviderEnabled(String provider)

    	{

    	Toast.makeText( getApplicationContext(),"Gps Enabled",Toast.LENGTH_SHORT).show();

    	}


    	@Override

    	public void onStatusChanged(String provider, int status, Bundle extras)

    	{


    	}
    	
    }

    
}