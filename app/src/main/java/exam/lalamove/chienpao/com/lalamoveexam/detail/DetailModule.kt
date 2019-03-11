package exam.lalamove.chienpao.com.lalamoveexam.detail

import dagger.Module
import dagger.Provides
import exam.lalamove.chienpao.com.lalamoveexam.di.PerActivity
import exam.lalamove.chienpao.com.lalamoveexam.main.adapter.DeliveryAdapter

@Module
class DetailModule(private val activity: DetailActivity) {

    @PerActivity
    @Provides
    fun provideDetailActivity() = activity
}