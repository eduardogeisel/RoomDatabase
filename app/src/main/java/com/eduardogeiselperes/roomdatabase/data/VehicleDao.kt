package com.eduardogeiselperes.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.eduardogeiselperes.roomdatabase.model.Vehicle

@Dao
interface VehicleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addVehicle(vehicle: Vehicle)

    @Update
    suspend fun updateVehicle(vehicle: Vehicle)

    @Query("SELECT * FROM vehicle_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Vehicle>>

}