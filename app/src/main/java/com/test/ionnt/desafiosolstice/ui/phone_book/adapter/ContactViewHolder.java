package com.test.ionnt.desafiosolstice.ui.phone_book.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.test.ionnt.desafiosolstice.R;
import com.test.ionnt.desafiosolstice.database.PhoneBook;
import com.test.ionnt.desafiosolstice.ui.phone_book.adapter.callback.Callback;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by martindegirolamo on 28/12/2017.
 */

public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(R.id.contactImage) ImageView contactImage;
    @BindView(R.id.contactName) TextView contactName;
    @BindView(R.id.starImage) ImageView favoriteImage;
    @BindView(R.id.descriptionText) TextView descriptionText;

    private Context context;
    private PhoneBook phoneBookContact;
    private Callback callback;

    public ContactViewHolder(View itemView, Context context, Callback callback) {
        super(itemView);
        this.context = context;
        this.callback = callback;
        itemView.setOnClickListener(this);
        ButterKnife.bind(this, itemView);
    }

    public void bindContact(PhoneBook phoneBookContact) {
        this.phoneBookContact = phoneBookContact;

        contactName.setText(phoneBookContact.getName());

        Picasso.with(context)
                .load(phoneBookContact.getSmallImageURL())
                .placeholder(R.drawable.ic_placeholder_no_photo)
                .into(contactImage);

        if (phoneBookContact.getIsFavorite()){
            favoriteImage.setVisibility(View.VISIBLE);
        } else {
            favoriteImage.setVisibility(View.INVISIBLE);
        }

        descriptionText.setText(phoneBookContact.getCompanyName());
    }

    @Override
    public void onClick(View view) {
        if (callback != null) {
            callback.onItemClicked(phoneBookContact);
        }
    }
}

