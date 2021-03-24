package com.eduardogeiselperes.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eduardogeiselperes.roomdatabase.model.Vehicle

@Dao
interface VehicleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addVehicle(vehicle: Vehicle)

    @Query("SELECT * FROM vehicle_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Vehicle>>

}