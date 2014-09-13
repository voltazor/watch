package com.yalantis.watch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MobileMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_main);

        findViewById(R.id.open_recycler_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MobileMainActivity.this, RecyclerViewActivity.class));
            }
        });

        findViewById(R.id.open_volume_control).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MobileMainActivity.this, VolumeControlActivity.class));
            }
        });

    }

}
