package net.skillup.devicemaster;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SecondActivity extends Activity 
	implements OnClickListener, LocationListener {

	private LocationManager manager = null;
	private TextView latitude;
	private TextView longitude;
	private TextView altitude;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        
        View button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);

        // GPS�T�[�r�X�擾�p
        latitude = (TextView)findViewById(R.id.textLatitude);
        longitude = (TextView)findViewById(R.id.textLongitude);
        altitude = (TextView)findViewById(R.id.textAltitude);
        manager = (LocationManager)getSystemService(LOCATION_SERVICE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public void onPause() {
    	super.onPause();
    	if (manager != null) {
    		manager.removeUpdates(this);
    	}
    }
    
    @Override
    public void onResume() {
    	super.onResume();
        String provider;
        final Criteria criteria = new Criteria();
		criteria.setBearingRequired(false);	// ���ʕs�v
		criteria.setSpeedRequired(false);	// ���x�s�v
		criteria.setAltitudeRequired(false);	// ���x�s�v
        provider = manager.getBestProvider(new Criteria(), true);
        if (provider == null) {
        	latitude.setText("�ʒu���擾�s��");
        }
    	manager.requestLocationUpdates(provider, 3000, 0, this);
    	Location location = manager.getLastKnownLocation(provider);
    	if (location != null) { onLocationChanged(location); }
    }
    
    @Override
    public void onLocationChanged(Location location) {
    	if (location == null) {
        	latitude.setText("�ʒu���擾�s��");
    	} else {
        	String str = "�ܓx�F" + location.getLatitude();
        	latitude.setText(str);
        	str = "�o�x�F" + location.getLongitude();
        	longitude.setText(str);
        	str = "���x�F" + location.getAltitude();
        	altitude.setText(str);
    	}
    }

    @Override
    public void onProviderDisabled(String provider) {}

    @Override
    public void onProviderEnabled(String provider) {}

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {}

    public void onClick(View v) {
    	switch (v.getId()) {
    	case R.id.button2:
    		finish();
    		break;
    	}
    }
    
}
