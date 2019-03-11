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

    fun getDeliveries(offset: Int, limit: Int) {
        model.getApiService(offset, limit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    Timber.d("Get deliveries success")
                    if (response.isSuccessful) {
                        view.updateDeliveries(response.body())
                        view.showMessageOnSnackBar(context.getString(R.string.get_deliveries_success_msg))

                        if (response.body()?.size == 0) {
                            view.showMessageOnSnackBar(context.getString(R.string.get_deliveries_empty))
                        }
                    }
                }, { throwable ->
                    Timber.e("Get deliveries failed ${throwable.message}")
                    view.showMessageOnSnackBar(context.getString(R.string.get_deliveries_error_msg))
                })
    }
}
