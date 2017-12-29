package com.test.ionnt.desafiosolstice.ui.phone_book.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.test.ionnt.desafiosolstice.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by martindegirolamo on 28/12/2017.
 */

public class TitleViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.titleText) TextView titleText;

    public TitleViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindTitle(String title){
        titleText.setText(title);
    }
}
