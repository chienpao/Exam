package exam.lalamove.chienpao.com.lalamoveexam.main

import android.content.Context
import exam.lalamove.chienpao.com.lalamoveexam.R
import exam.lalamove.chienpao.com.lalamoveexam.di.PerActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@PerActivity
class MainPresenter @Inject constructor(private val context: Context,
                                        private val view: MainActivity,
                                        private val model: MainModel) {
    private var mainDisposable: Disposable? = null

    fun getDeliveries(offset: Int, limit: Int) {
        model.getLalamoveApiService(offset, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    Timber.d("Get deliveries success")
                    if (response.isSuccessful) {
                        view.updateDeliveries(response.body())
                    }
                }, { throwable ->
                    Timber.e("Get deliveries failed ${throwable.message}")
                    view.showErrorMessageOnSnackBar(context.getString(R.string.get_deloveries_error_msg))
                })
    }
}
