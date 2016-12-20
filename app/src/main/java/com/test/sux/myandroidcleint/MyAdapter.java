package com.test.sux.myandroidcleint;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.List;
import java.util.Vector;

import static android.R.id.list;

/**
 * Created by Sux on 2016/12/8.
 */

public class MyAdapter extends BaseAdapter {
    private List<String> Msgs;
    private LayoutInflater li;
    private viewHolder holder;
    private Context context;
    //private TextView tv;
    public MyAdapter(List<String> Msgs){
        this.Msgs = Msgs;

    }



    @Override
    public int getCount() {
        return this.Msgs.size() ;
    }

    @Override
    public Object getItem(int position) {
        return Msgs.get(position).toString();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            if(li==null){
                Context context = parent.getContext();
                li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            if (convertView == null) {
                convertView = li.inflate(R.layout.list_item, parent, false);
                holder =new viewHolder();
                holder.textView = (TextView) convertView.findViewById(R.id.textView);
            }else{
                holder.textView= (TextView) convertView.getTag();
            }
        String text = (String) getItem(position);
           if(holder.textView != null) {
               holder.textView.setText(text);
           }

        return convertView;
    }
    public List<String> getMsgs(){
        return this.Msgs;
    }
    public void setMsg(List<String> Msgs ){
        this.Msgs = Msgs;
    }


}
