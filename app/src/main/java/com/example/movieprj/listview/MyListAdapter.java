package com.example.movieprj.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movieprj.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MyListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInFlater;
    private ArrayList<HashMap<String, String>> list;
//    ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();

    public MyListAdapter (Context context, ArrayList<HashMap<String, String>> data) {
        this.mContext = context;
        list = data;
        mLayoutInFlater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        public ImageView imageView;
        public TextView tvMovieName, tvOnScreenTime, tvDescription;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mLayoutInFlater.inflate(R.layout.layout_list_item, null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.iv);
            holder.tvMovieName = convertView.findViewById(R.id.tv_movieName);
            holder.tvOnScreenTime = convertView.findViewById(R.id.tv_movieOnscreenTime);
            holder.tvDescription = convertView.findViewById(R.id.tv_movieDescription);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvMovieName.setText(list.get(position).get("tv_movieName"));
        holder.tvOnScreenTime.setText(list.get(position).get("tv_movieOnscreenTime"));
        holder.tvDescription.setText(list.get(position).get("tv_movieDescription"));
//        holder.imageView.setImageResource(list.get(position).get("iv"));
        Glide.with(mContext).load(list.get(position).get("iv")).into(holder.imageView);
        return convertView;
    }
}
