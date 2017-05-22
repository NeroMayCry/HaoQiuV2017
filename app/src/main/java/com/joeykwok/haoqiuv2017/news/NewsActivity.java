package com.joeykwok.haoqiuv2017.news;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.utils.LogUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.joeykwok.haoqiuv2017.R;
import com.joeykwok.haoqiuv2017.commons.GlobalConsts;
import com.joeykwok.haoqiuv2017.entity.NewsBean;
import com.joeykwok.haoqiuv2017.utils.CommonUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.MediaType;

public class NewsActivity extends AppCompatActivity {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private ImageView newsImg;
    private TextView tvTitle;
    private TextView tvSource;
    private TextView tvDate;
    private TextView tvTime;
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        LogUtils.i("Joey", title);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.news_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.close);
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setDisplayShowTitleEnabled(false);
//        }
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.news_coltoolbar);
//        collapsingToolbar.setTitle(title);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
//        newsImg = (ImageView) findViewById(R.id.news_img);
        newsImg = (ImageView) findViewById(R.id.news_backdrop);
        tvTitle = (TextView) findViewById(R.id.news_title);
        tvSource = (TextView) findViewById(R.id.news_source);
        tvTime = (TextView) findViewById(R.id.news_time);
        tvDate = (TextView) findViewById(R.id.news_date);
        tvContent = (TextView) findViewById(R.id.news_content);

        getNewsDetail(title);

    }

    private void getNewsDetail(String title) {
        String url = GlobalConsts.BASEURL + "/getnewsdetail";
        JSONObject json = new JSONObject();
        try {
            json.put("title", title);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        OkHttpUtils.postString()
                .url(url)
                .content(String.valueOf(json))
                .mediaType(JSON)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(NewsActivity.this, "网络请求失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        LogUtils.i("Joey", response);
                        Gson mGson = new Gson();
                        NewsBean newsBean = mGson.fromJson(response, NewsBean.class);
                        NewsBean.DataBean data = newsBean.getData();
                        String imgUrl = data.getImg_url();
                        if (imgUrl.startsWith("/")) {
                            String url = "http:" + imgUrl;
                            Glide.with(NewsActivity.this).load(url).into(newsImg);
                        } else {
                            String url = imgUrl;
                            Glide.with(NewsActivity.this).load(url).into(newsImg);
                        }
                        tvTitle.setText(data.getTitle());
                        tvSource.setText(data.getSource());
                        String date = CommonUtils.getDate(data.getTime());
                        String time = CommonUtils.getTime(data.getTime());
                        tvDate.setText(date);
                        tvTime.setText(time);
                        LogUtils.i("Joey", date + time);
//                        tvTime.setText(data.getTime());
                        tvContent.setText(data.getContent());
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
