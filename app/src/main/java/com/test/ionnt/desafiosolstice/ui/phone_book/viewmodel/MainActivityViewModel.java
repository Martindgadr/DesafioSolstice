package com.test.ionnt.desafiosolstice.ui.phone_book.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.test.ionnt.desafiosolstice.database.PhoneBook;
import com.test.ionnt.desafiosolstice.service.ChallengeService;
import com.test.ionnt.desafiosolstice.utils.Constants;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Martin De Girolamo on 17/12/2017.
 */

public class MainActivityViewModel extends ViewModel {
    private Retrofit retrofit;
    private CompositeDisposable compositeDisposable;
    private MutableLiveData<Boolean> showErrorMessage;
    private MutableLiveData<Boolean> showHideLoadingImage;
    private MutableLiveData<List<PhoneBook>> showPhoneBook;

    public MainActivityViewModel() {
        super();

        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.API_MAIN_URL)
                .build();

        compositeDisposable = new CompositeDisposable();
        showErrorMessage = new MutableLiveData<>();
        showHideLoadingImage = new MutableLiveData<>();
        showPhoneBook = new MutableLiveData<>();
    }

    public void callPhoneBookService(){
        ChallengeService service = retrofit.create(ChallengeService.class);

        compositeDisposable.add(service.getCompletePhonebook()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse,this::handleError));

        showHideLoadingImage.setValue(true);
    }

    private void handleResponse(List<PhoneBook> phoneBookList) {
        // Send all data to Adapter.
        setShowPhoneBook(phoneBookList);
        showHideLoadingImage.setValue(false);
    }

    private void handleError(Throwable error) {
        // show error on screen.
        showErrorMessage.setValue(true);
        showHideLoadingImage.setValue(false);
    }

    public MutableLiveData<Boolean> getShowErrorMessage() {
        return showErrorMessage;
    }

    public MutableLiveData<List<PhoneBook>> getShowPhoneBook() {
        return showPhoneBook;
    }

    private void setShowPhoneBook(List<PhoneBook> showPhoneBook) {
        this.showPhoneBook.setValue(showPhoneBook);
    }

    public MutableLiveData<Boolean> getShowHideLoadingImage() {
        return showHideLoadingImage;
    }

    public void setShowHideLoadingImage(Boolean showHideStatus) {
        this.showHideLoadingImage.setValue(showHideStatus);
    }
}
