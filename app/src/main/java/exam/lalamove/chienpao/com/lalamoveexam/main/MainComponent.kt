package exam.lalamove.chienpao.com.lalamoveexam.main

import dagger.Component
import exam.lalamove.chienpao.com.lalamoveexam.AppComponent
import exam.lalamove.chienpao.com.lalamoveexam.di.PerActivity

@PerActivity
@Component(modules = [(MainModule::class)],
        dependencies = [(AppComponent::class)])
interface MainComponent {
    fun inject(activity: MainActivity)
}
