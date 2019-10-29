package com.cold.module2.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cold.module2.R;
import com.cold.module2.R2;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by baoyz on 2014/6/29.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    // 数据集
    private List<String> mDataset;

    public MyAdapter(List<String> dataset) {
        super();
        mDataset = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // 创建一个View，简单起见直接使用系统提供的布局，就是一个TextView
        View view = View.inflate(viewGroup.getContext(), R.layout.item_recyclerview, null);
        // 创建一个ViewHolder
        ViewHolder holder = new ViewHolder(view);
        System.out.println("-----------------------> onCreateViewHolder");
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        // 绑定数据到ViewHolder上
        viewHolder.mTextView.setText(mDataset.get(i));
        System.out.println("-----------------------> onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public List<String> getmDataset() {
        return mDataset;
    }

    public void setmDataset(List<String> mDataset) {
        this.mDataset = mDataset;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R2.id.tv_item)
        public TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
