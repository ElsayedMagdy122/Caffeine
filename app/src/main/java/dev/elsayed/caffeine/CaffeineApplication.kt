package dev.elsayed.caffeine

import android.app.Application
import dev.elsayed.caffeine.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class CaffeineApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CaffeineApplication)
            modules(appModule)
       }
    }
}
