package com.liuchongming.myapplication;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.liuchongming.beans.UserBean;
import com.liuchongming.myapplication.databinding.ActivityRegResultBinding;
import com.liuchongming.viewModel.ResultViewModel;

public class RegResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegResultBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_reg_result);
        ImagePipelineFactory.initialize(this);
        binding.setViewModel(new ResultViewModel(this, (UserBean) getIntent().getSerializableExtra("user")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
