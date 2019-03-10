package exam.lalamove.chienpao.com.lalamoveexam.main

import android.content.Context
import exam.lalamove.chienpao.com.lalamoveexam.api.LalamoveApiService
import exam.lalamove.chienpao.com.lalamoveexam.api.data.Deliver
import exam.lalamove.chienpao.com.lalamoveexam.di.PerActivity
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject


@PerActivity
class MainModel @Inject constructor(private val context: Context,
                                    private val lalamoveApiService: LalamoveApiService) {

    fun getLalamoveApiService(offset: Int, limit: Int): Single<Response<ArrayList<Deliver>>> {
        return lalamoveApiService.getDeliveries(offset, limit)
    }
}
