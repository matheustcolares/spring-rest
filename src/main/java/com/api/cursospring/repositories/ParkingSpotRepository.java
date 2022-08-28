package com.api.cursospring.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.cursospring.models.ParkingSpotModel;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {
	
	boolean existsByLicenencePlateCar(String licensePlateCar);
	boolean existsByParkingSpotNumber(String parkingSpotNumber);
	boolean existsByApartmentAndBlock(String apartment, String block);
	

}
