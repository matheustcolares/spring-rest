package com.api.cursospring.services;

import org.springframework.stereotype.Service;

import com.api.cursospring.models.ParkingSpotModel;
import com.api.cursospring.repositories.ParkingSpotRepository;

import antlr.collections.List;

@Service
public class ParkingSpotService {
	
	final ParkingSpotRepository parkingSpotRepository;
	
	public ParkingSpotService (ParkingSpotRepository parkingSpotRepository) {
		this.parkingSpotRepository = parkingSpotRepository;
	}

	public Object save(ParkingSpotModel parkingSpotModel) {
		
		return parkingSpotRepository.save(parkingSpotModel);
	}

	public boolean existsByLicensePlatecCar(String licensePlateCar) {
		
		return parkingSpotRepository.existsByLicenencePlateCar(licensePlateCar);
	}

	public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
		
		return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
	}

	public boolean existsByApartment(String apartment, String block) {
		
		return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
	}

	public List<ParkingSpotModel> findAll() {
		
		return parkingSpotRepository.findAll();
	}

}
