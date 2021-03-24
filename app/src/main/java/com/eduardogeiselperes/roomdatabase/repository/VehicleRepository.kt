package com.eduardogeiselperes.roomdatabase.repository

import androidx.lifecycle.LiveData
import com.eduardogeiselperes.roomdatabase.data.VehicleDao
import com.eduardogeiselperes.roomdatabase.model.Vehicle

class VehicleRepository(private val vehicleDao: VehicleDao) {

    val readAllData: LiveData<List<Vehicle>> = vehicleDao.readAllData()

    suspend fun addVehicle(vehicle: Vehicle){
        vehicleDao.addVehicle(vehicle)
    }

    suspend fun updateVehicle(vehicle: Vehicle) {
        vehicleDao.updateVehicle(vehicle)
    }

    suspend fun deleteVehicle(vehicle: Vehicle){
        vehicleDao.deleteVehicle(vehicle)
    }

    suspend fun deleteAllVehicles(){
        vehicleDao.deleteAllVehicles()
    }
}