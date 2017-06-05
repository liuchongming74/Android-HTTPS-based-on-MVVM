package com.liuchongming.utils;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.liuchongming.beans.Contributor;
import com.liuchongming.viewHolder.ItemHolder;
import com.liuchongming.myapplication.BR;
import com.liuchongming.myapplication.R;
import com.liuchongming.myapplication.databinding.UserListItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuchongming on 2016/11/28.
 * Project Name: MyApplication
 * Package Mame: com.liuchongming.beans
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<ItemHolder> {
    private List<Contributor> list = new ArrayList<>();
    private final static String TAG = "RXJAVA LEARNING";

    public RecyclerViewAdapter(List<Contributor> data) {
        this.list = data;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        UserListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.user_list_item, parent, false);
        return new ItemHolder(binding);
    }

    //填充onCreateViewHolder方法返回的holder中的控件
    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.getBinding().setVariable(BR.contributor, list.get(position));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
