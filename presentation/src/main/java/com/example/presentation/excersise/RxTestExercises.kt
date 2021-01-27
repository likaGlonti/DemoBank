package com.example.presentation.excersise

import android.util.Log.d
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.internal.operators.observable.ObservableCreate
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject
import io.reactivex.subjects.Subject

class RxTestExercises {
    fun sub() {
        val subj: PublishSubject<Int> = PublishSubject.create()
        subj.onNext(1)
        subj.subscribe { onnext ->
            d("next", onnext.toString())
        }.dispose()
        subj.onNext(2)
        subj.onNext(3)
        subj.onNext(4)
    }

    var observable: Observable<Int> = ObservableCreate<Int> {
        it.onNext(10)
        it.onNext(20)
        it.onComplete()
    }
    var observer: Observer<Int> = object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            d("disposed", "disposed")
            d.dispose()
        }

        override fun onNext(t: Int) {
            d("next", "onNext $t")
        }

        override fun onError(e: Throwable) {
        }

        override fun onComplete() {
            d("complete", "onComplete")
        }
    }

    val values = ReplaySubject.create<Int>()
    fun subscribe() {
        val subscription1 = values.subscribe({ v ->
            d("first:", v.toString())
        },
            { t ->
                d("first:", t.toString())

            }, {
                d("first:", "completed")
            })
        values.onNext(0)
        values.onNext(1)
        values.onComplete()
        values.onNext(2)
    }
}