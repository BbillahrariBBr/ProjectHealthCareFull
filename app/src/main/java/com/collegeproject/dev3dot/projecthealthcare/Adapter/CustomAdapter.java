package com.collegeproject.dev3dot.projecthealthcare.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.collegeproject.dev3dot.projecthealthcare.R;
import com.collegeproject.dev3dot.projecthealthcare.RowItem;

import java.util.List;



public class CustomAdapter extends BaseAdapter {
    Context context;
    List<RowItem> rowItems;

    public CustomAdapter(Context context, List<RowItem> rowItems) {
        this.context = context;
        this.rowItems = rowItems;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {
            view = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();

            holder.imageView = (ImageView) view.findViewById(R.id.imageView);
            holder.textView = (TextView) view.findViewById(R.id.textViewHeader);

            RowItem rowPosition = rowItems.get(i);

            holder.imageView.setImageResource(rowPosition.getPictureID());
            holder.textView.setText(rowPosition.getTreatmentName());

        }

        return view;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}

