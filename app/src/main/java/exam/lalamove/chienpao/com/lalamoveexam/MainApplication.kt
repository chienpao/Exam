package exam.lalamove.chienpao.com.lalamoveexam

import android.app.Application
import timber.log.Timber

class MainApplication : Application() {

    lateinit var appModule: AppModule
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initInjections()
        Timber.plant(Timber.DebugTree())
    }

    private fun initInjections() {
        appModule = AppModule(this)
        appComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build().apply {
                    inject(this@MainApplication)
                }
    }
}