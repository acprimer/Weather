package cn.edu.buaa.yaodh.weather;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.baoyz.widget.PullRefreshLayout;
import com.thinkland.sdk.android.DataCallBack;
import com.thinkland.sdk.android.JuheData;
import com.thinkland.sdk.android.Parameters;

import org.json.JSONException;
import org.json.JSONObject;

import cn.edu.buaa.yaodh.weather.entity.Weather;

public class MainActivity extends Activity {
    private Context mContext;
    private PullRefreshLayout refreshLayout;
    private TextView tvCity;
    private LinearLayout layoutHours;
    private LinearLayout layoutDays;
    private LinearLayout layoutDetail;
    private LinearLayout[] nextHourLayouts;
    private LinearLayout[] nextDayLayouts;
    private LinearLayout[] detailLayouts;
    private Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

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

        getData();
    }

    private void getData() {
        Parameters params = new Parameters();
        params.add("ip", Constant.JUHE_IP);
        params.add("dtype", "json");
        params.add("cityname", Constant.DEFAULT_CITY);
        JuheData.executeWithAPI(Constant.WEATHER_ID, Constant.WEATHER_URL, JuheData.GET, params, new DataCallBack() {
            @Override
            public void resultLoaded(int err, String reason, String result) {
                if (err == 0) {
                    Log.d("weather", result);
                    try {
                        JSONObject obj = new JSONObject(result);
                        Log.d("weather", obj.getJSONObject("result").getJSONObject("today").toString());
                        weather = JSON.parseObject(obj.getJSONObject("result").getJSONObject("today").toString(), Weather.class);
                        updateViews();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(mContext, reason, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void initViews() {
        tvCity = (TextView) findViewById(R.id.tv_city);
        layoutHours = (LinearLayout) findViewById(R.id.layout_next_fiftenn_hour);
        layoutDays = (LinearLayout) findViewById(R.id.layout_next_three_day);
        layoutDetail = (LinearLayout) findViewById(R.id.layout_weather_detail);
        LayoutInflater inflater = LayoutInflater.from(mContext);
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

    private void updateViews() {
        tvCity.setText(weather.getCity());
        ((TextView) detailLayouts[4].findViewById(R.id.tv_content)).setText(weather.getDressingIndex());
    }
}
