import android.app.Application
import com.dict.demo.AndroidNewsApp
import com.dict.demo.di.*
import com.dict.demo.ui.home.HomeActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class,
    ViewModelFactoryModule::class, NetworkModule::class, RepositoryModule::class,
    ViewModelModule::class, HomeActivityModule::class])

interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: AndroidNewsApp)
}