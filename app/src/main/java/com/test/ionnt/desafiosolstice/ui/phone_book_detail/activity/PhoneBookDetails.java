package com.test.ionnt.desafiosolstice.ui.phone_book_detail.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.test.ionnt.desafiosolstice.R;
import com.test.ionnt.desafiosolstice.database.PhoneBook;
import com.test.ionnt.desafiosolstice.ui.phone_book_detail.views.CustomItemView;
import com.test.ionnt.desafiosolstice.utils.Constants;
import com.test.ionnt.desafiosolstice.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Martin De Girolamo on 17/12/2017.
 */

public class PhoneBookDetails extends AppCompatActivity {
    @BindView(R.id.contactName) TextView contactName;
    @BindView(R.id.contactImage) ImageView contactImage;
    @BindView(R.id.companyName) TextView companyName;
    @BindView(R.id.homePhoneCIV) CustomItemView homePhone;
    @BindView(R.id.mobilePhoneCIV) CustomItemView mobilePhone;
    @BindView(R.id.workPhoneCIV) CustomItemView workPhone;
    @BindView(R.id.addressCIV) CustomItemView address;
    @BindView(R.id.birthdayCIV) CustomItemView birthday;
    @BindView(R.id.emailCIV) CustomItemView email;

    private PhoneBook phoneBook;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_details_data);

        ButterKnife.bind(this);
        Intent intent = getIntent();
        if (intent != null) {
            phoneBook = (PhoneBook) intent.getSerializableExtra(Constants.PHONEBOOK_REF);
        }

        if (phoneBook != null) {
            completeFields();
        }

        setToolBar();
    }

    private void setToolBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_favorite);

        if (phoneBook.getIsFavorite()){
            menuItem.setIcon(R.drawable.ic_favorite_true_yellow);
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_favorite) {
            markAsFavorite(item);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void completeFields() {
        contactName.setText(phoneBook.getName());
        companyName.setText(phoneBook.getCompanyName());
        setContactImage();
        setHomePhone();
        setMobilePhone();
        setWorkPhone();
        setAddress();
        setBirthday();
        setEmail();
    }

    private void setContactImage() {
        Picasso.with(this)
                .load(phoneBook.getLargeImageURL())
                .placeholder(R.drawable.ic_placeholder_no_photo)
                .into(contactImage);
    }

    private void setHomePhone() {
        if (phoneBook != null && phoneBook.getPhone().getHome() != null &&
                !phoneBook.getPhone().getHome().isEmpty()){
            homePhone.setTitleText(getString(R.string.phoneText));
            homePhone.setDescriptionText(Utils.addparenthesisToPhone(phoneBook.getPhone().getHome()));
            homePhone.setTypeText(getString(R.string.homeText));
        } else {
            homePhone.setVisibility(View.GONE);
        }
    }

    private void setMobilePhone() {
        if (phoneBook != null && phoneBook.getPhone().getMobile() != null &&
                !phoneBook.getPhone().getMobile().isEmpty()){
            mobilePhone.setTitleText(getString(R.string.phoneText));
            mobilePhone.setDescriptionText(Utils.addparenthesisToPhone(phoneBook.getPhone().getMobile()));
            mobilePhone.setTypeText(getString(R.string.mobileText));
        } else {
            mobilePhone.setVisibility(View.GONE);
        }
    }

    private void setWorkPhone() {
        if (phoneBook != null && phoneBook.getPhone().getWork() != null &&
                !phoneBook.getPhone().getWork().isEmpty()){
            workPhone.setTitleText(getString(R.string.phoneText));
            workPhone.setDescriptionText(Utils.addparenthesisToPhone(phoneBook.getPhone().getWork()));
            workPhone.setTypeText(getString(R.string.workText));
        } else {
            workPhone.setVisibility(View.GONE);
        }
    }

    private void setAddress(){
        if (phoneBook != null && !phoneBook.getAddress().toString().isEmpty()){
            address.setTitleText(getString(R.string.addressText));
            address.setDescriptionText(getString(R.string.addressToSet, phoneBook.getAddress().getStreet(),
                    phoneBook.getAddress().getCity(),phoneBook.getAddress().getState(),
                    phoneBook.getAddress().getZipCode(), phoneBook.getAddress().getCountry()));
        } else {
            address.setVisibility(View.GONE);
        }
    }

    private void setBirthday(){
        if (phoneBook != null && phoneBook.getBirthdate() != null &&
                !phoneBook.getBirthdate().isEmpty()){
            birthday.setTitleText(getString(R.string.birthdayText));
            try {
                birthday.setDescriptionText(Utils.dayDateToStr(phoneBook.getBirthdate()));
            } catch (Exception e){
                Toast.makeText(this, "Error Getting Date", Toast.LENGTH_SHORT).show();
            }

        } else {
            birthday.setVisibility(View.GONE);
        }
    }

    private void setEmail(){
        if (phoneBook != null && phoneBook.getEmailAddress() != null &&
                !phoneBook.getEmailAddress().isEmpty()){
            email.setTitleText(getString(R.string.emailText));
            email.setDescriptionText(phoneBook.getEmailAddress());
        } else {
            email.setVisibility(View.GONE);
        }
    }

    private void markAsFavorite(MenuItem item) {
        if (phoneBook.getIsFavorite()) {
            phoneBook.setIsFavorite(false);
            item.setIcon(R.drawable.ic_favorite_false_yellow);
        } else {
            phoneBook.setIsFavorite(true);
            item.setIcon(R.drawable.ic_favorite_true_yellow);
        }
    }

    @Override
    public void onBackPressed() {
        Intent dataIntent = new Intent();
        dataIntent.putExtra(Constants.PHONEBOOK_REF, phoneBook);
        setResult(RESULT_OK, dataIntent);
        finish();
        super.onBackPressed();
    }
}
