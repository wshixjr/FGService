package pl.bialorucki.foregroundservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mStartService;
    private Button mStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartService = (Button)findViewById(R.id.button_start_service);
        mStopService = (Button)findViewById(R.id.button_stop_service);

        mStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(MainActivity.this,ForegroundService.class);
                startIntent.setAction(ForegroundService.START_ACTION);
                startService(startIntent);
            }
        });

        mStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stopIntent = new Intent(MainActivity.this, ForegroundService.class);
                stopIntent.setAction(ForegroundService.STOP_ACTION);
                stopService(stopIntent);
            }
        });
    }
}
