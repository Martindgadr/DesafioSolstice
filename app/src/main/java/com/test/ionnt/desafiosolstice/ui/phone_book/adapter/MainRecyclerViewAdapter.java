package com.test.ionnt.desafiosolstice.ui.phone_book.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.ionnt.desafiosolstice.R;
import com.test.ionnt.desafiosolstice.database.PhoneBook;
import com.test.ionnt.desafiosolstice.ui.phone_book.adapter.callback.Callback;

import java.util.List;

/**
 * Created by Martin De Girolamo on 17/12/2017.
 */

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private LayoutInflater layoutInflater;
    private List<Object> items;
    private Context context;
    private Callback callback;

    private static final int CONTACT_VIEW_ITEM = 1;
    private static final int CONTACT_VIEW_TITLE = 0;

    public MainRecyclerViewAdapter(Context context, LayoutInflater layoutInflater,
                                   Callback callback) {
        this.layoutInflater = layoutInflater;
        this.context = context;
        this.callback = callback;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case CONTACT_VIEW_TITLE:
                View viewTitle = layoutInflater.inflate(R.layout.card_view_item_title, parent,
                        false);
                return new TitleViewHolder(viewTitle);
            case CONTACT_VIEW_ITEM:
                View viewItem = layoutInflater.inflate(R.layout.card_view_item_phone_contact, parent,
                        false);
                return new ContactViewHolder(viewItem, context, callback);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Object item = items.get(position);

        if (holder instanceof TitleViewHolder) {
            ((TitleViewHolder) holder).bindTitle(item.toString());
        }

        if (holder instanceof ContactViewHolder) {
            ((ContactViewHolder) holder).bindContact((PhoneBook) item);
        }
    }

    @Override
    public int getItemCount() {
        return (items != null) ? items.size() : 0;
    }

    public void addContactList(List<Object> items) {
        if (this.items != null && !this.items.isEmpty()) {
            this.items.clear();
        }
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return (items.get(position) instanceof String) ? CONTACT_VIEW_TITLE : CONTACT_VIEW_ITEM;
    }
}
