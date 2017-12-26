package com.test.ionnt.desafiosolstice.ui.phone_book.activity;

import android.app.ProgressDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.test.ionnt.desafiosolstice.R;
import com.test.ionnt.desafiosolstice.database.PhoneBook;
import com.test.ionnt.desafiosolstice.ui.phone_book.adapter.MainReciclerViewAdapter;
import com.test.ionnt.desafiosolstice.ui.phone_book.viewmodel.MainActivityViewModel;
import com.test.ionnt.desafiosolstice.utils.sort.SortByFavourite;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.phoneBookRecyclerView) RecyclerView recyclerView;

    private MainActivityViewModel viewModel;
    private MainReciclerViewAdapter adapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        adapter = new MainReciclerViewAdapter(this, this.getLayoutInflater());
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        progressDialog = new ProgressDialog(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        viewModel.callPhoneBookService();
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.getShowErrorMessage().observe(this, this::serviceErrorMessage);
        viewModel.getShowHideLoadingImage().observe(this, this::showHideProgressDialog);
        viewModel.getShowPhoneBook().observe(this, this::showPhonebookList);
    }

    private void showHideProgressDialog(Boolean hasToShow) {
        if (hasToShow){
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        } else {
            progressDialog.hide();
        }
    }

    private void showPhonebookList(List<PhoneBook> phoneBookList) {
        if (phoneBookList != null) {
            sortPhonebookList(phoneBookList);
            adapter.addContactList(phoneBookList);
        }
    }

    private void sortPhonebookList(List<PhoneBook> phoneBookList) {
        if (!phoneBookList.isEmpty()){
            Collections.sort(phoneBookList, new SortByFavourite());
//            Collections.sort(phoneBookList, new SortByName());
        }
    }

    private void serviceErrorMessage(Boolean serviceHasError) {
        if (serviceHasError){
            Snackbar.make(recyclerView, "Error", Snackbar.LENGTH_LONG);
        }
    }

}
