# architectureComponentsApp

The app was built using Android Jetpack libraries that follow best practices recommended by the Android team.

The app is based on Navigation Component, following the principle of Single Activity apps, 
the framework allows to work with multiple fragments(destinations), 
maybe one of the remarkables advantages is avoiding to handle the Fragment transitions manually.

## Jetpack Navigation Component

Navigation Component + SafeArgs to attach data between destinations.

## Coroutines and Retrofit

The MovieDB Rest API

okhttp3

## Persistence Layer

Kotlin Serialization

Room

## UI design

Data Binding

ConstraintLayouts

ViewModels

## Demo ScreenShots

![This is an image](https://github.com/tanrobles19/architectureComponentsApp/blob/dev/screenshots_demo/home.png) 
![This is an image](https://github.com/tanrobles19/architectureComponentsApp/blob/dev/screenshots_demo/movie_list.png)

Room Dependecies

def roomVersion = "2.4.2"

implementation("androidx.room:room-runtime:$roomVersion")
annotationProcessor("androidx.room:room-compiler:$roomVersion")
// To use Kotlin annotation processing tool (kapt)
kapt("androidx.room:room-compiler:$roomVersion")

Room Official documentation

https://developer.android.com/training/data-storage/room

We need to add kapt plugin
    id 'kotlin-kapt'


View Binding

Enable view binding in the module gradle, buildFeatures, viewBinding = true

RecyclerView Implementation

Using DataBinding with the RecyclerView (remove calls to findViewById()). Create a Binding Adapter.

based on this codelab

https://developer.android.google.cn/codelabs/basic-android-kotlin-training-affirmations-app#0

ViewModel and LiveData


## API

TheMovieDB API
https://www.themoviedb.org/
Documentation
https://developers.themoviedb.org/3/getting-started/introduction

Clave de la API (v3 auth) = XXXXX

Get Now Playing 
https://api.themoviedb.org/3/movie/now_playing?api_key=e23ece4da67144877ca7da9d18c13b37&language=en-US&page=1

Movie Image

Sample: Sonic 2

backdrop_path
https://image.tmdb.org/t/p/w500/egoyMDLqCxzjnSrWOz50uLlJWmD.jpg