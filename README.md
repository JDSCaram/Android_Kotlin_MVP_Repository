# kotlin_mvp_dagger_repository

This Android Kotlin project using an classic architecture MVP with repository pattern, DI (Dagger2), Retrofit and Room.


I am providing the Repository with all necessary dependencies 



```java
@Singleton
@Component(modules = {
        ApplicationModule.class,
        RetrofitModule.class,
        RoomModule.class,
        SharedPrefsModule.class,
        RepositoryModule.class})
public interface ApplicationComponent {
    void inject(Context contextApplication);

    Repository provideRepository();
}

```


## Repository.

![Alt text](https://github.com/JDSCaram/Android_Kotlin_MVP_Repository/blob/master/images/pattern_repository.png "Repository")

```java

//Acesso Local (Database):
repository.beginLocal()
                .getDatabase().cityWeatherDao().insertCityWeather(entity);
                
//Acesso Local (Prefs):
repository.beginLocal()
                .getPrefs();
                
//Acesso Remote (WebService)
mRepository.beginRemote().getRetrofit().create(API.class)


```


## Project Contains.
Room Persistence Library:  https://developer.android.com/topic/libraries/architecture/room.html <br />
Retrofit: http://square.github.io/retrofit/ <br />
MVP: https://medium.com/android-dev-br/desmistificando-o-mvc-e-mvp-no-android-abe927d01df7 <br />
RxAndroid : https://github.com/ReactiveX/RxAndroid  <br />
Butter Knife : http://jakewharton.github.io/butterknife/ <br />
Dagger 2 : https://google.github.io/dagger/

