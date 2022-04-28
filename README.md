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