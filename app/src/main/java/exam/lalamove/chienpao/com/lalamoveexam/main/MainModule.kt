package exam.lalamove.chienpao.com.lalamoveexam.main

import dagger.Module
import dagger.Provides
import exam.lalamove.chienpao.com.lalamoveexam.di.PerActivity

@Module
class MainModule(private val activity: MainActivity) {

    @PerActivity
    @Provides
    fun provideMainActivity() = activity

}