package exam.lalamove.chienpao.com.lalamoveexam.api

import exam.lalamove.chienpao.com.lalamoveexam.api.data.Deliver
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    /**
     * Get deliveries from server
     *
     */
    @GET("/deliveries")
    fun getDeliveries(@Query("offset") offset: Int,
                @Query("limit") limit: Int): Single<Response<ArrayList<Deliver>>>
}
