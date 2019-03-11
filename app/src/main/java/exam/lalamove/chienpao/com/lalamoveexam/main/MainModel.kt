package exam.lalamove.chienpao.com.lalamoveexam.main

import android.content.Context
import exam.lalamove.chienpao.com.lalamoveexam.api.ApiService
import exam.lalamove.chienpao.com.lalamoveexam.api.data.Deliver
import exam.lalamove.chienpao.com.lalamoveexam.di.PerActivity
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject


@PerActivity
class MainModel @Inject constructor(private val context: Context,
                                    private val apiService: ApiService) {

    fun getApiService(offset: Int, limit: Int): Single<Response<ArrayList<Deliver>>> {
        return apiService.getDeliveries(offset, limit)
    }
}
