package exam.lalamove.chienpao.com.lalamoveexam.detail

import android.content.Context
import exam.lalamove.chienpao.com.lalamoveexam.R
import exam.lalamove.chienpao.com.lalamoveexam.di.PerActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

@PerActivity
class DetailPresenter @Inject constructor(private val context: Context,
                                          private val view: DetailActivity,
                                          private val model: DetailModel) {
}
