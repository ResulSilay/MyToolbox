package com.my.toolbox.application.basic;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

public class MyToolboxApplication extends Application {

    public static MyToolboxApplication myToolboxApplication = null;

    /**
     * Observer edilebilen bir değişken.
     * Uygulama içerisindeki farklı paket alanlarını tutan bir değişken.
     * Örn: YemekSepeti/Banabi - Getir/Yemek/Su/Çarşı vb...
     */
    public MutableLiveData<String> isAppType = new MutableLiveData<>();

    /**
     * Application (state management) tek bir kere üretilmesi.
     * Application classı'na Singleton pattern uygulanıyor.
     *
     * @return MyToolboxApplication instance.
     */
    public static synchronized MyToolboxApplication getInstance() {
        MyToolboxApplication _myToolboxApplication;
        synchronized (MyToolboxApplication.class) {
            _myToolboxApplication = myToolboxApplication;
        }

        return _myToolboxApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        myToolboxApplication = this;

        isAppType.postValue("General");

        /*
          ProcessLifecycleOwner: Tüm uygulama süreci için yaşam döngüsü sağlayan sınıf.
          Bu sınıfa AppLifecycleListener ekleyerek tüm observerları eventler hakkında bilgilendirdik.
         */
        AppLifecycleListener appLifecycleListener = new AppLifecycleListener();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(appLifecycleListener);

        // Uygulama etkinlik etkinlik yaşam döngüsü başlatıldı.
        AppLifecycleCallbacks appLifecycleCallbacks = new AppLifecycleCallbacks();
        this.registerActivityLifecycleCallbacks(appLifecycleCallbacks);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    /**
     * Uygulama yaşam döndügüsü eventlerini application üzerinden yakalıyoruz.
     * Java'da final anahtar kelimesi aşağıda yer alan yapılar için kullanılabilir:
     * Final sınıf değişkenleri: Final olan bir sınıf değişkenine sadece bir kere değer ataması yapilabilir
     * ve bu atama sadece sınıf konstrüktöründe gerçekleşebilir.
     * Final sınıflar: Final olan bir sınıf genişletilerek bir alt sınıf oluşturulamaz
     */
    public static class AppLifecycleListener implements LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        public void onAppCreated() {

        }

        /**
         * Uygulama öne plana alındı.
         * Token yenileme.
         * Logic kontroller vb. işlemler yapılabilir.
         */
        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onAppForeground() {

        }

        /**
         * Uygulama arkaplana taşındı.
         */
        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onAppBackground() {

        }
    }


    /**
     * Uygulama üzerindeki tüm activity callbacklerini yakalıyoruz.
     * Etkinlik yaşam döngüsünü izlememize olanak sağlamaktadır.
     */
    public static final class AppLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

        @Override
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(@NonNull Activity activity) {

        }

        @Override
        public void onActivityResumed(@NonNull Activity activity) {

        }

        @Override
        public void onActivityPaused(@NonNull Activity activity) {

        }

        @Override
        public void onActivityStopped(@NonNull Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(@NonNull Activity activity) {

        }
    }


    /**
     * Static bir değişkene veri setleme ve veri çekme.
     */

    private static String meData = null;

    public void setMe(String value){
        meData = value;
    }

    public String getMe(){
        return meData;
    }


}
