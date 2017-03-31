package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;

import com.tooleap.sdk.Tooleap;
import com.tooleap.sdk.TooleapPopOutMiniApp;

import java.util.Date;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        popoutMiniApp();
        setContentView(R.layout.main);

        /*
        ((Button)findViewById(R.id.popout)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				popoutMiniApp();
			}
		});
        
        ((Button)findViewById(R.id.remove)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				removeAllMiniApps();
			}
		}); */

        
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        popoutMiniApp();
    }

    private void popoutMiniApp() {
    	TooleapPopOutMiniApp miniApp = new TooleapPopOutMiniApp(MyActivity.this, MyTooleapActivity.class);
        miniApp.contentTitle = "Easy App Search";
        miniApp.contentText = "Find your App";
        miniApp.bubbleBackgroundColor =  0xFF3498DB;
        //miniApp.
        miniApp.setIcon(this,R.drawable.search);
        miniApp.notificationText = "Welcome to Easy Find App, Tap to search...";
        miniApp.notificationBadgeNumber = 1;
        miniApp.when = new Date();
        Tooleap.getInstance(MyActivity.this).addMiniApp(miniApp);
    }
    /*
    private void removeAllMiniApps() {
    	Tooleap.getInstance(MyActivity.this).removeAllMiniApps();
    } */
}
