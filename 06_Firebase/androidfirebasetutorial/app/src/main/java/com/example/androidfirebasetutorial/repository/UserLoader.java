package com.example.androidfirebasetutorial.repository;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.schedulers.Schedulers;


public class UserLoader {

    public static Observable<Object> fetch() {
        return Observable
                .range(1, 1)
                .zipWith(Observable.interval(200, TimeUnit.MILLISECONDS),
                        (Func2<Integer, Long, Object>) (integer, aLong) -> UserFactory.makeUser())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

    }
}