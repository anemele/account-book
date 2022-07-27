package com.js.ab.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.js.ab.Bean.TreeItemBean;
import com.js.ab.R;

import java.util.List;

public class TreeItemAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    List<TreeItemBean> mData;

    public TreeItemAdapter(Context context, List<TreeItemBean> mData) {
        this.context = context;
        this.mData = mData;
        layoutInflater = LayoutInflater.from(context);
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
            convertView = layoutInflater.inflate(R.layout.tree_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        TreeItemBean bean = mData.get(position);
        holder.tvName.setText(bean.getName());

        return convertView;
    }

    static class ViewHolder {
        TextView tvName;

        public ViewHolder(View view) {
            tvName = view.findViewById(R.id.main_tree_item_name);
        }
    }
}
