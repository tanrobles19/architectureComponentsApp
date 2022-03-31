package com.example.architecture.test.persistence.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo val name: String,
    @ColumnInfo val description: String

){
    constructor(name: String, description: String):
            this(null, name, description)
}
