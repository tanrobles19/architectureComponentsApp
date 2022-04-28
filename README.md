# architectureComponentsApp

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

based on this codelab

https://developer.android.google.cn/codelabs/basic-android-kotlin-training-affirmations-app#0

ViewModel and LiveData


API

TheMovieDB API
https://www.themoviedb.org/
Documentation
https://developers.themoviedb.org/3/getting-started/introduction

Clave de la API (v3 auth) = e23ece4da67144877ca7da9d18c13b37

Get Now Playing 
https://api.themoviedb.org/3/movie/now_playing?api_key=e23ece4da67144877ca7da9d18c13b37&language=en-US&page=1