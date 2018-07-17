# kotlin_mvp_dagger_repository

This Android Kotlin project using an classic architecture MVP with repository pattern, DI (Dagger2), Retrofit and Room.


I am providing the Repository with all necessary dependencies 

```kotlin
@Singleton
@Component(modules = [
    ApplicationModule::class,
    RepositoryModule::class,
    RetrofitModule::class,
    SharedPrefsModule::class,
    RoomModule::class])
interface ApplicationComponent : AndroidInjector<SampleApplication> {
    fun inject(applicationContext: Context)
    fun provideRepository(): Repository
}

```


## Repository.

![Alt text](https://github.com/JDSCaram/Android_Kotlin_MVP_Repository/blob/master/images/pattern_repository.png "Repository")


Samples:
```kotlin

//Acesso Local (Database):
mRepository.local()?.getDatabase()?.breedDao()?.insertBreeds(entities)
                
//Acesso Local (Prefs):
repository.local()?
                .getPrefs();
                
//Acesso Remote (WebService)
mRepository.remote()?.getRetrofit()?.create(API::class.java)


```


## Project Contains.
Room Persistence Library:  https://developer.android.com/topic/libraries/architecture/room.html <br />
Retrofit: http://square.github.io/retrofit/ <br />
MVP: https://medium.com/android-dev-br/desmistificando-o-mvc-e-mvp-no-android-abe927d01df7 <br />
RxAndroid : https://github.com/ReactiveX/RxAndroid  <br />
Butter Knife : http://jakewharton.github.io/butterknife/ <br />
Dagger 2 : https://google.github.io/dagger/

