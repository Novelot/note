下拉刷新库的使用(com.handmark.pulltorefresh.library)
1. mRefreshView.onRefreshComplete();//必须在UI线程中执行
=====================================================================
package com.novelot.tong;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class AudioFragment extends Fragment implements AbsListView.OnItemClickListener {
    private PullToRefreshListView mRefreshView;
    private ListView mListView;
    private BaseAdapter mAdapter;
    private List<String> mData = new ArrayList<String>();

    public AudioFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int i = 0; i < 5; i++) {
            mData.add(String.format("%d.<color>花火", i + 1));
        }
        mAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, mData);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_audio, container, false);
        mRefreshView = (PullToRefreshListView) view.findViewById(android.R.id.list);
        View vEmpty = view.findViewById(android.R.id.empty);
        mRefreshView.setEmptyView(vEmpty);
        mListView = mRefreshView.getRefreshableView();
        TextView footView = new TextView(getActivity());
        AbsListView.LayoutParams params = new android.widget.AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, android.widget.AbsListView.LayoutParams.WRAP_CONTENT);
        footView.setLayoutParams(params);
        footView.setGravity(Gravity.CENTER);
        footView.setText("加载更多多");
        mListView.addFooterView(footView);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
        //
        mRefreshView.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        //设置上拉下拉事件
        mRefreshView.setOnRefreshListener(
                new PullToRefreshBase.OnRefreshListener2<ListView>() {
                    @Override
                    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
//                        mRefreshView.onRefreshComplete();

                    }

                    @Override
                    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                int size = mData.size();
                                for (int i = size; i < size + 5; i++) {
                                    mData.add(String.format("%d.花火", i + 1));
                                }
                                mAdapter.notifyDataSetChanged();
                                mListView.setSelection(mAdapter.getCount() - 1);//滚动到底部
                                mRefreshView.onRefreshComplete();//必须在UI线程中执行
                            }
                        });


                    }
                }
        );

        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(), mData.get(position - 1), Toast.LENGTH_SHORT).show();
    }


}
