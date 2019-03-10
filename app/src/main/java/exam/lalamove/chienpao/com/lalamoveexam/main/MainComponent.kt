package exam.lalamove.chienpao.com.lalamoveexam.main

import dagger.Component
import exam.lalamove.chienpao.com.lalamoveexam.AppComponent
import exam.lalamove.chienpao.com.lalamoveexam.di.PerActivity

@PerActivity
@Component(modules = arrayOf(MainModule::class)
        , dependencies = arrayOf(AppComponent::class))
interface MainComponent {
    fun inject(activity: MainActivity)
}
