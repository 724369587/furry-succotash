package com.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Juphoon on 2018/8/22.
 */

public class GroupAdpter extends ArrayAdapter {
    private final int resourceId;

    public GroupAdpter(Context context, int textViewResourceId, List<GroupItem> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GroupItem Group = (GroupItem) getItem(position); // 获取当前项的GroupItem实例
        View view;
        ViewHolder viewHolder;
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.GroupImage = (ImageView) view.findViewById(R.id.group_image);
            viewHolder.GroupName = (TextView) view.findViewById(R.id.group_name);
            view.setTag(viewHolder);//储存NAME和Image

        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();//获取
        }//如果convertView为NULL,则使用LayoutInflater去加载布局，如果不为NULL则直接对convertView进行重用
        view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
        ImageView fruitImage = (ImageView) view.findViewById(R.id.group_image);//获取该布局内的图片视图
        TextView fruitName = (TextView) view.findViewById(R.id.group_name);//获取该布局内的文本视图
        fruitImage.setImageResource(Group.getImageId());//为图片视图设置图片资源
        fruitName.setText(Group.getName());//为文本视图设置文本内容
        return view;
    }

    class ViewHolder  {
        ImageView GroupImage;
        TextView GroupName;
    }
}

