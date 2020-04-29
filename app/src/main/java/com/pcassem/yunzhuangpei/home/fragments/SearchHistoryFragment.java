package com.pcassem.yunzhuangpei.home.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pcassem.yunzhuangpei.R;
import com.pcassem.yunzhuangpei.home.adapter.SearchResultListAdapter;
import com.pcassem.yunzhuangpei.training.activities.CourseDetailsActivity;
import com.pcassem.yunzhuangpei.view.RecycleViewDivider;

import java.util.ArrayList;

public class SearchHistoryFragment extends Fragment implements SearchResultListAdapter.OnItemClickListener {

    private RecyclerView mRecyclerView;
    private SearchResultListAdapter mTrainingListAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_history, container, false);
        initView(view);

        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        mTrainingListAdapter = new SearchResultListAdapter(getData());

        // 设置布局管理器
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // 设置adapter
        mRecyclerView.setAdapter(mTrainingListAdapter);
        mTrainingListAdapter.setmOnItemClickListener(this);

        return view;
    }

    private void initView(View view){
        mRecyclerView = (RecyclerView) view.findViewById(R.id.training_recycler_view);
    }

    private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        String temp = " item";
        for (int i = 0; i < 10; i++) {
            data.add(i + temp);
        }
        return data;
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(getActivity(), CourseDetailsActivity.class);
        startActivity(intent);
    }
}
