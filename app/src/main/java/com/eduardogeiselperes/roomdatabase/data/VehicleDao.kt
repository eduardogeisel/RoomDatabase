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

    @Delete
    suspend fun deleteVehicle(vehicle: Vehicle)

    @Query("DELETE FROM vehicle_table")
    suspend fun deleteAllVehicles()

    @Query("SELECT * FROM vehicle_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Vehicle>>

}