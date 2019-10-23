package com.t3h.lazada.Models.Objectclass;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LoadMoreScroll extends RecyclerView.OnScrollListener {
    int itemAnDauTien = 0;
    int TongItem = 0;
    int ItemLoadTruoc = 10;
    private ILoadMore iLoadMore;
    private RecyclerView.LayoutManager manager;
    public LoadMoreScroll(RecyclerView.LayoutManager manager,ILoadMore iLoadMore){
        this.manager = manager;
        this.iLoadMore = iLoadMore;
    }
    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        TongItem = manager.getItemCount();
        if (manager instanceof LinearLayoutManager){
            itemAnDauTien = ((LinearLayoutManager) manager).findFirstVisibleItemPosition();
        }else if (manager instanceof GridLayoutManager){
            itemAnDauTien = ((GridLayoutManager) manager).findFirstVisibleItemPosition();
        }
        if (TongItem <= (itemAnDauTien + ItemLoadTruoc)){
            iLoadMore.LoadMore(TongItem);
        }
    }

    @Override
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
    }
}
