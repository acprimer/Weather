package cn.edu.buaa.yaodh.weather;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;


public class MainActivity extends Activity {
    private PullRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        refreshLayout = (PullRefreshLayout) findViewById(R.id.refresh);
//        refreshLayout.setRefreshStyle(PullRefreshLayout.STYLE_MATERIAL);
//        refreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                refreshLayout.setRefreshing(true);
//                Toast.makeText(getApplicationContext(), "ttt", Toast.LENGTH_SHORT).show();
//            }
//        });
//        refreshLayout.setRefreshing(false);
    }
}
