package net.skillup.devicemaster;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // �{�^���ɃN���b�N�C�x���g�����蓖��
        View button1 = findViewById(R.id.button2);
        button1.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void onClick(View v) {
    	switch (v.getId()) {
    	case R.id.button2:
    	// ���M�{�^���������ꂽ
    		Intent i = new Intent(this, SecondActivity.class);
    		startActivity(i);
    		break;
    	}
    }
}
