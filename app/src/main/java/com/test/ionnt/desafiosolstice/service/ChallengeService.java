package com.test.ionnt.desafiosolstice.service;

import com.test.ionnt.desafiosolstice.database.PhoneBook;
import com.test.ionnt.desafiosolstice.utils.Constants;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Martin De Girolamo on 17/12/2017.
 */

public interface ChallengeService {
    @GET(Constants.API_CALL)
    Observable<List<PhoneBook>> getCompletePhonebook();

    @GET(Constants.API_CALL)
    Observable<PhoneBook> getSinglePhonebook();
}
