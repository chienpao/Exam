package exam.lalamove.chienpao.com.lalamoveexam.detail

import dagger.Component
import exam.lalamove.chienpao.com.lalamoveexam.AppComponent
import exam.lalamove.chienpao.com.lalamoveexam.di.PerActivity

@PerActivity
@Component(modules = [(DetailModule::class)],
        dependencies = [(AppComponent::class)])
interface DetailComponent {
    fun inject(activity: DetailActivity)
}
