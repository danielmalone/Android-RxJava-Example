package com.finepointmobile.androidrxjavaapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.widget.TextView
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val firstName = findViewById(R.id.first_name) as TextView

        val daniel = User("Daniel", "Malone", 24)

        firstName.text = "$daniel.firstName"
        var asdf: String = "testing here"
        asdf = "$asdf asdf"
        firstName.text = asdf

        Observable.just("Daniel Malone")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Observer)
    }

    internal var Observer: Observer<String> = object : Observer<String> {
        override fun onSubscribe(@NonNull d: Disposable) {

        }

        override fun onNext(@NonNull s: String) {
            Log.d(TAG, "onNext: " + s)
        }

        override fun onError(@NonNull e: Throwable) {

        }

        override fun onComplete() {

        }
    }

    companion object {

        private val TAG = "MainActivity"
    }
}
