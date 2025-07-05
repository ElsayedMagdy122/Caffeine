package dev.elsayed.caffeine

import android.app.Application

class CaffeineApplication : Application() {
    override fun onCreate() {
        super.onCreate()
//        startKoin {
//            androidContext(this@CaffeineApplication)
//            modules(appModule)
//        }
    }
}
//val appModule = module {
//    viewModelOf(::CustomizationCoffeeViewModel)
//}