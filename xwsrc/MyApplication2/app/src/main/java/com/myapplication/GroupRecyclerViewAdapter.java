package com.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Juphoon on 2018/8/22.
 */

public class GroupRecyclerViewAdapter extends RecyclerView.Adapter<GroupRecyclerViewAdapter.MyViewHolder>{

    private List<String> datas;
    private LayoutInflater inflater;
    public GroupRecyclerViewAdapter(Context context,List<String> datas){
        inflater=LayoutInflater.from(context);
        this.datas=datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View itemView=inflater.inflate(R.layout.msg_item,null);
        final MyViewHolder holder = new MyViewHolder(itemView);
        holder.groupView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Toast.makeText(view.getContext(),"yes",Toast.LENGTH_SHORT).show();
            }
        });
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addData(String content) {
        datas.add(content);
        notifyItemInserted(datas.size()-1);
    }

    public void removeData(int position) {
        datas.remove(position);
        notifyItemRemoved(position);
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {
        View groupView;
       private TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            groupView = itemView;
            textView = (TextView) itemView.findViewById(R.id.msg_item);
        }
    }
}
