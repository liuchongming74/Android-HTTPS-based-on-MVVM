package com.liuchongming.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;

import com.liuchongming.utils.RecyclerViewAdapter;
import com.liuchongming.myapplication.databinding.ActivityRecyclerViewBinding;
import com.liuchongming.utils.DividerItemDecoration;
import com.liuchongming.viewModel.ListViewModel;

public class RecyclerViewActivity extends AppCompatActivity {
    private ActivityRecyclerViewBinding binding;
    private ListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);
        viewModel = new ListViewModel(this);
        binding.setViewModel(viewModel);
        binding.toolbar.setTitle("RecyclerView");
        setSupportActionBar(binding.toolbar);
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerViewAdapter recycleAdapter = viewModel.adapter;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);//设置为垂直布局，这也是默认的
        binding.recyclerView.setLayoutManager(layoutManager); //设置布局管理器
        binding.recyclerView.setAdapter(recycleAdapter); //设置Adapter
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());//设置增加或删除条目的动画
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));
    }
}
