package com.example.roma.patientapp.dagger;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.roma.patientapp.data.DataRepository;
import com.example.roma.patientapp.data.DataRepositoryImpl;
import com.example.roma.patientapp.data.local.DatabaseManager;
import com.example.roma.patientapp.data.local.LocalRepository;
import com.example.roma.patientapp.data.local.LocalRepositoryImpl;
import com.example.roma.patientapp.data.local.PreferencesManager;
import com.example.roma.patientapp.data.remote.GzipRequestInterceptor;
import com.example.roma.patientapp.data.remote.RemoteRepository;
import com.example.roma.patientapp.data.remote.RemoteRepositoryImpl;
import com.example.roma.patientapp.data.remote.ServiceGenerator;
import com.example.roma.patientapp.utils.constants.NetworkConstants;
import com.example.roma.patientapp.utils.constants.PrefrenceConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    public Context getContext() {
        return this.application;
    }

    @Provides
    public CompositeDisposable getCompositDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    public DataRepository getDataRepository(RemoteRepository remoteRepository, LocalRepository localRepository) {
        return new DataRepositoryImpl(remoteRepository, localRepository);
    }

    @Provides
    public RemoteRepository getRemoteRepository(ServiceGenerator serviceGenerator) {
        return new RemoteRepositoryImpl(serviceGenerator);
    }

    @Provides
    public LocalRepository getLocalRepository(PreferencesManager preferencesManager, DatabaseManager databaseManager) {
        return new LocalRepositoryImpl(preferencesManager, databaseManager);
    }

    @Provides
    public ServiceGenerator getSeviceGenerator(Retrofit retrofit) {
        return new ServiceGenerator(retrofit);
    }

    @Provides
    public PreferencesManager getPreferencesManager(SharedPreferences sharedPreferences) {
        return new PreferencesManager(sharedPreferences);
    }

    @Provides
    public DatabaseManager getDataManger() {
        return new DatabaseManager();
    }

    @Singleton
    @Provides
    public SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(PrefrenceConstants.SHARED_PREFRENCE_FILE, Context.MODE_PRIVATE);
    }

    @Singleton
    @Provides
    public Retrofit getRetrofit() {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpBuilder.addInterceptor(interceptor);
        return new Retrofit.Builder()
                .baseUrl(NetworkConstants.BASE_URL)
                .client(okHttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory((RxJava2CallAdapterFactory.create()))
                .build();
    }
}
