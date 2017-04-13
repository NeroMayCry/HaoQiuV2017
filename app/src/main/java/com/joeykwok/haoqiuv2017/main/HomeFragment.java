package com.joeykwok.haoqiuv2017.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.blankj.utilcode.utils.LogUtils;
import com.google.gson.Gson;
import com.joeykwok.haoqiuv2017.R;
import com.joeykwok.haoqiuv2017.commons.GlobalConsts;
import com.joeykwok.haoqiuv2017.entity.NewsListBean;
import com.joeykwok.haoqiuv2017.news.NewsActivity;
import com.joeykwok.haoqiuv2017.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private Banner mBanner;
    private ListView newsListView;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initListView(view);
        getNewsInBanner();
        getNewsList();
        return view;
    }

    private void initListView(View view) {
        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.listheader_banner, null);
        mBanner = (Banner) headerView.findViewById(R.id.main_banner);
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        newsListView = (ListView) view.findViewById(R.id.main_list);
        newsListView.addHeaderView(headerView);
    }

    private void getNewsInBanner() {
        String url = GlobalConsts.BASEURL + "/newsinban";
        OkHttpUtils.get()
                .url(url)
                .tag(this)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        LogUtils.e("Joey", "error:" + e.getMessage());
                        Toast.makeText(getActivity(), "网络请求失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        LogUtils.i("Joey", response);
                        Gson mGson = new Gson();
                        NewsListBean newsListBean = mGson.fromJson(response, NewsListBean.class);
                        if (newsListBean.getCode().equals("00")) {
                            List<NewsListBean.DataBean> newsDataList = newsListBean.getData();
                            final List<String> imgUrls = new ArrayList<String>();
                            final List<String> titles = new ArrayList<String>();

                            for (int i = 0; i < newsDataList.size(); i++) {
                                imgUrls.add(newsDataList.get(i).getPic());
                                titles.add(newsDataList.get(i).getTitle());
                            }

                            mBanner.setImages(imgUrls);
                            mBanner.setBannerAnimation(Transformer.Default);
                            mBanner.setBannerTitles(titles);
                            mBanner.isAutoPlay(true);
                            mBanner.setDelayTime(4000);
                            mBanner.setIndicatorGravity(BannerConfig.RIGHT);
                            mBanner.setOnBannerClickListener(new OnBannerClickListener() {
                                @Override
                                public void OnBannerClick(int position) {
//                                    Toast.makeText(MainActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getActivity(), NewsActivity.class);
                                    intent.putExtra("title", titles.get(position - 1));
                                    startActivity(intent);
                                }
                            });
                        } else {
                            Toast.makeText(getActivity(), newsListBean.getMsg(), Toast.LENGTH_SHORT).show();
                        }
                        mBanner.start();
                    }
                });
    }

    private void getNewsList() {
        String url = GlobalConsts.BASEURL + "/getnewslist?page=0";
        OkHttpUtils.get()
                .url(url)
                .tag(this)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        LogUtils.e("Joey", "error:" + e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Gson mGson = new Gson();
                        NewsListBean newsListBean = mGson.fromJson(response, NewsListBean.class);
                        final List<NewsListBean.DataBean> newsDataList = newsListBean.getData();
                        NewsListAdapter adapter = new NewsListAdapter(newsDataList, getActivity());
                        newsListView.setAdapter(adapter);
                        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Intent intent = new Intent(getActivity(), NewsActivity.class);
                                intent.putExtra("title", newsDataList.get(i - 1).getTitle());
                                startActivity(intent);
                            }
                        });
                    }
                });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        OkHttpUtils.getInstance().cancelTag(this);
    }
}
