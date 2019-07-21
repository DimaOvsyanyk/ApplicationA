package com.dimaoprog.appa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.dimaoprog.appa.databinding.ActivityMainBinding;
import com.dimaoprog.appa.entities.ImageLink;
import com.dimaoprog.appa.utils.IOptionMenuListener;
import com.dimaoprog.appa.utils.ISendBroadcastListener;
import com.dimaoprog.appa.utils.ISetHistoryFragmentListener;
import com.dimaoprog.appa.utils.PagerAdapter;

import static com.dimaoprog.appa.utils.Constants.COLUMN_ID;
import static com.dimaoprog.appa.utils.Constants.COLUMN_OPEN_TIME;
import static com.dimaoprog.appa.utils.Constants.COLUMN_STATUS;
import static com.dimaoprog.appa.utils.Constants.COLUMN_URL;
import static com.dimaoprog.appa.utils.Constants.OPEN_START;
import static com.dimaoprog.appa.utils.Constants.URL_PICKED;

public class MainActivity extends AppCompatActivity implements ISendBroadcastListener, ISetHistoryFragmentListener {

    private IOptionMenuListener optionMenuListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        getSupportActionBar().hide();
        binding.pager.setAdapter(new PagerAdapter(getSupportFragmentManager(), this, this));
        binding.pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    getSupportActionBar().hide();
                } else {
                    getSupportActionBar().show();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void sendBroadcast(String url) {
        Intent intent = new Intent(URL_PICKED);
        intent.putExtra(COLUMN_URL, url);
        intent.putExtra(OPEN_START, System.currentTimeMillis());
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }

    @Override
    public void sendBroadcast(ImageLink imageLink) {
        Intent intent = new Intent(URL_PICKED);
        intent.putExtra(COLUMN_ID, imageLink.getId());
        intent.putExtra(COLUMN_URL, imageLink.getUrl());
        intent.putExtra(COLUMN_STATUS, imageLink.getStatus());
        intent.putExtra(COLUMN_OPEN_TIME, imageLink.getOpenTime());
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private boolean newFirst = true;
    private boolean ascending = true;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort_date:
                optionMenuListener.sortByDate(newFirst);
                newFirst = !newFirst;
                break;
            case R.id.sort_status:
                optionMenuListener.sortByStatus(ascending);
                ascending = !ascending;
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setHistoryFragmentListener(IOptionMenuListener optionMenuListener) {
        this.optionMenuListener = optionMenuListener;
    }
}
