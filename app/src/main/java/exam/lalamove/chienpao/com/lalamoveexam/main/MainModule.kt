package exam.lalamove.chienpao.com.lalamoveexam.main

import dagger.Module
import dagger.Provides
import exam.lalamove.chienpao.com.lalamoveexam.di.PerActivity
import exam.lalamove.chienpao.com.lalamoveexam.main.adapter.DeliveryAdapter

@Module
class MainModule(private val activity: MainActivity) {

    @PerActivity
    @Provides
    fun provideMainActivity() = activity

    @PerActivity
    @Provides
    fun provideAdapterCallback(): DeliveryAdapter.Callback = activity
}