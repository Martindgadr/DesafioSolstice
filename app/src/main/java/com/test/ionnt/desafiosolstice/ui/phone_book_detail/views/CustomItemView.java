package com.test.ionnt.desafiosolstice.ui.phone_book_detail.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.test.ionnt.desafiosolstice.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by martindegirolamo on 29/12/2017.
 */

public class CustomItemView extends ConstraintLayout {
    @BindView(R.id.titleText) TextView titleText;
    @BindView(R.id.descriptionText) TextView descriptionText;
    @BindView(R.id.typeText) TextView typeText;

    public CustomItemView(Context context) {
        super(context);
        init(null);
    }

    public CustomItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs) {
        View view = inflate(getContext(), R.layout.item_detail_custom_view, this);
        ButterKnife.bind(this, view);

        if (attrs != null) {
            TypedArray attributes = getContext()
                    .obtainStyledAttributes(attrs, R.styleable.CustomItemView);

            String titleText = attributes.getString(R.styleable.CustomItemView_titleText);
            String descrText = attributes.getString(R.styleable.CustomItemView_descriptionText);
            String typeText  = attributes.getString(R.styleable.CustomItemView_typeText);

            this.titleText.setText(titleText);
            this.descriptionText.setText(descrText);
            this.typeText.setText(typeText);
            attributes.recycle();
        }
    }

    public void setTitleText(TextView titleText) {
        this.titleText = titleText;
    }

    public void setDescriptionText(TextView descriptionText) {
        this.descriptionText = descriptionText;
    }

    public void setTypeText(TextView typeText) {
        this.typeText = typeText;
    }
}
