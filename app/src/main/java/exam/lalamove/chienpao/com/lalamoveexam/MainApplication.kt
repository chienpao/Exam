package exam.lalamove.chienpao.com.lalamoveexam

import android.app.Application
import timber.log.Timber

class MainApplication : Application() {

    lateinit var mainModule: MainModule
    lateinit var mainComponent: MainComponent

    override fun onCreate() {
        super.onCreate()
        initInjections()
        Timber.plant(Timber.DebugTree())
    }

    private fun initInjections() {
        mainModule = MainModule(this)
        mainComponent = DaggerMainComponent.builder()
                .mainModule(mainModule)
                .build().apply {
                    inject(this@MainApplication)
                }
    }
}