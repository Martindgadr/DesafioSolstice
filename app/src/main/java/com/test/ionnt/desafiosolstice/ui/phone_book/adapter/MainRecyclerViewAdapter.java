package com.test.ionnt.desafiosolstice.ui.phone_book.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.test.ionnt.desafiosolstice.R;
import com.test.ionnt.desafiosolstice.database.PhoneBook;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Martin De Girolamo on 17/12/2017.
 */

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder>{
    private LayoutInflater layoutInflater;
    private List<PhoneBook> phoneBookList;
    private Context context;

    public MainRecyclerViewAdapter(Context context, LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
        this.context = context;

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.contactImage) ImageView contactImage;
        @BindView(R.id.contactName) TextView contactName;
        @BindView(R.id.starImage) ImageView favoriteImage;
        @BindView(R.id.deacriptionText) TextView descriptionText;

        ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PhoneBook phoneBookContact = phoneBookList.get(position);

        holder.contactName.setText(phoneBookContact.getName());

        Picasso.with(context)
                .load(phoneBookContact.getSmallImageURL())
                .placeholder(R.drawable.ic_placeholder_no_photo)
                .into(holder.contactImage);

        if (phoneBookContact.getIsFavorite()){
            holder.favoriteImage.setVisibility(View.VISIBLE);
        } else {
            holder.favoriteImage.setVisibility(View.INVISIBLE);
        }

        holder.descriptionText.setText(phoneBookContact.getCompanyName());

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.card_view_item_phone_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return (phoneBookList != null) ? phoneBookList.size() : 0;
    }

    public void addContactList(List<PhoneBook> phoneBookList) {
        this.phoneBookList = phoneBookList;
        notifyDataSetChanged();
    }
}
