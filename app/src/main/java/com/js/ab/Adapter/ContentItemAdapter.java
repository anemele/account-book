package com.js.ab.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.js.ab.Bean.ContentItemBean;
import com.js.ab.R;

import java.util.List;

public class ContentItemAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater mLayoutInflater;
    List<ContentItemBean> mData;

    public ContentItemAdapter(Context context, List<ContentItemBean> mData) {
        this.mContext = context;
        this.mData = mData;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.content_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ContentItemBean bean = mData.get(position);
        holder.itemName.setText(bean.getName());
        holder.itemAccount.setText(bean.getAccount());

        return convertView;
    }

    static class ViewHolder {
        TextView itemName, itemAccount;

        public ViewHolder(View view) {
            itemName = view.findViewById(R.id.main_content_item_name);
            itemAccount = view.findViewById(R.id.main_content_item_account);
        }
    }
}
