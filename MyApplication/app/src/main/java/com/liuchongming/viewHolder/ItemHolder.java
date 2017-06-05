package com.liuchongming.viewHolder;

import android.support.v7.widget.RecyclerView;

import com.liuchongming.myapplication.databinding.UserListItemBinding;

/**
 * Created by liuchongming on 2016/11/29.
 * Project Name: MyApplication
 * Package Mame: com.liuchongming.beans
 */

public class ItemHolder extends RecyclerView.ViewHolder {
    private UserListItemBinding binding;

    public ItemHolder(UserListItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        binding.executePendingBindings();
    }

    public UserListItemBinding getBinding() {
        return binding;
    }
}