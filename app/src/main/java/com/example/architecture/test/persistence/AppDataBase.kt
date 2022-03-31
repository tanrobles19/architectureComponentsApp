package com.example.architecture.test.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.architecture.test.persistence.dao.MovieDao
import com.example.architecture.test.persistence.entity.Movie

@Database(entities = [Movie::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object{

        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {

            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {

                    instance = Room.databaseBuilder(
                     context.applicationContext,
                        AppDataBase::class.java,
                        "database"
                    ).createFromAsset("moviesDatabase.db")
                        .build()

                    INSTANCE = instance

                }

                return instance

            }// end synchronized

        }// end getInstance

    }// end companion object

}