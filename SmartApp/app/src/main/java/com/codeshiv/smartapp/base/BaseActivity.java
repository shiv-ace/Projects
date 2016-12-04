package com.codeshiv.smartapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.codeshiv.smartapp.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void initNormalActionBar(String titleText) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(false);
            actionBar.setCustomView(R.layout.action_bar_strip);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_back);
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM
                    | ActionBar.DISPLAY_HOME_AS_UP);
            View view = actionBar.getCustomView();
            if (view != null) {
                TextView actionBarTextView = (TextView) view.findViewById(R.id.action_bar_title_text);
                actionBarTextView.setText(titleText);
            }
        }
    }


    protected void initNormalActionBar(int titleResourceId) {
        initNormalActionBar(getString(titleResourceId));
    }
}
