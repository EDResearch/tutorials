package com.example.choi.memo_homework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;



public class lv_adapter extends BaseAdapter {

    private Context context;
    private List<data> items;

    public lv_adapter(Context context, List<data> items){
        this.context=context;
        this.items=items;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.in_list, null);

        TextView textView = (TextView)view.findViewById(R.id.It);
        textView.setText(""+items.get(position).getText().toString());

        return view;

    }
}
