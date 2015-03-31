package cn.edu.buaa.yaodh.weather;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baoyz.widget.PullRefreshLayout;


public class MainActivity extends Activity {
    private PullRefreshLayout refreshLayout;
    private LinearLayout layoutHours;
    private LinearLayout layoutDays;
    private LinearLayout layoutDetail;
    private LinearLayout[] nextHourLayouts;
    private LinearLayout[] nextDayLayouts;
    private LinearLayout[] detailLayouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        refreshLayout = (PullRefreshLayout) findViewById(R.id.refresh);
        refreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_MATERIAL);
        refreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(true);
            }
        });
        refreshLayout.setRefreshing(false);
        initViews();
    }

    public void initViews() {
        layoutHours = (LinearLayout) findViewById(R.id.layout_next_fiftenn_hour);
        layoutDays = (LinearLayout) findViewById(R.id.layout_next_three_day);
        layoutDetail = (LinearLayout) findViewById(R.id.layout_weather_detail);
        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        nextHourLayouts = new LinearLayout[5];
        for (int i = 0; i < 5; i++) {
            nextHourLayouts[i] = (LinearLayout) inflater.inflate(R.layout.layout_next_hour, layoutHours, false);
            layoutHours.addView(nextHourLayouts[i]);
        }
        nextDayLayouts = new LinearLayout[4];
        for (int i = 0; i < 4; i++) {
            nextDayLayouts[i] = (LinearLayout) inflater.inflate(R.layout.layout_next_day, layoutDays, false);
            layoutDays.addView(nextDayLayouts[i]);
        }
        String[] detailTitles = getResources().getStringArray(R.array.detail_title);
        detailLayouts = new LinearLayout[5];
        for (int i = 0; i < 5; i++) {
            detailLayouts[i] = (LinearLayout) inflater.inflate(R.layout.layout_weather_detail, layoutDetail, false);
            layoutDetail.addView(detailLayouts[i]);
            ((TextView) detailLayouts[i].findViewById(R.id.tv_desc)).setText(detailTitles[i]);
        }
    }
}
