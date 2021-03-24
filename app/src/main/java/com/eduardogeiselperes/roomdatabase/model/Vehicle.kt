package com.eduardogeiselperes.roomdatabase.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "vehicle_table")
data class Vehicle(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val make: String,
    val model: String,
    val year: Int
): Parcelable