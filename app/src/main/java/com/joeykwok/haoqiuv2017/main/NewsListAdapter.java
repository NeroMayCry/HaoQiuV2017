package com.joeykwok.haoqiuv2017.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.joeykwok.haoqiuv2017.R;
import com.joeykwok.haoqiuv2017.entity.NewsListBean;

import java.util.List;

/**
 * Created by gjwlg on 2017/1/9.
 */

public class NewsListAdapter extends BaseAdapter {
    private List<NewsListBean.DataBean> mList;
    private Context context;
    private LayoutInflater inflater;

    public NewsListAdapter(List<NewsListBean.DataBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.item_news_list, null);
            holder = new ViewHolder();
            holder.imgNews = (ImageView) view.findViewById(R.id.news_img);
            holder.tvTitle = (TextView) view.findViewById(R.id.news_title);
            holder.tvSource = (TextView) view.findViewById(R.id.news_source);
//            holder.tvTime = (TextView) view.findViewById(R.id.news_time);
            view.setTag(holder);
        }
        holder = (ViewHolder) view.getTag();
        NewsListBean.DataBean data = mList.get(i);
        holder.tvTitle.setText(data.getTitle());
        holder.tvSource.setText(data.getSource());
        Glide.with(context).load(data.getPic()).into(holder.imgNews);
//        holder.tvTime.setText(data.getTime());
        return view;
    }

    class ViewHolder {
        ImageView imgNews;
        TextView tvTitle;
        TextView tvSource;
        TextView tvTime;
    }


}
