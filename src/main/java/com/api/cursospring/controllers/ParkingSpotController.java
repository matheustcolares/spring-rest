package com.api.cursospring.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.cursospring.models.ParkingSpotModel;
import com.api.cursospring.services.ParkingSpotService;

import dtos.ParkingSpotDTO;

@RestController
@CrossOrigin(origins ="*", maxAge = 3600)
@RequestMapping("/curso-spring")
public class ParkingSpotController {
	
	final ParkingSpotService parkingSpotService;

	public ParkingSpotController(ParkingSpotService parkingSpotService) {
		super();
		this.parkingSpotService = parkingSpotService;
	}

@PostMapping
public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDTO parkingSpotDTO){
	if(parkingSpotService.existsByLicensePlatecCar(parkingSpotDTO.getLicensePlateCar())) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Placa do carro ja esta sendo usada");
	}
	if(parkingSpotService.existsByParkingSpotNumber(parkingSpotDTO.getParkingSpotNumber())) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Vaga ja esta sendo usada");
	}
	if(parkingSpotService.existsByApartment(parkingSpotDTO.getApartment(),parkingSpotDTO.getBlock())) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Este apartamento ja tem vaga");
	}
	var parkingSpotModel = new ParkingSpotModel();
	BeanUtils.copyProperties(parkingSpotDTO, parkingSpotModel);
	parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
	return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));


}
@GetMapping
public ResponseEntity<List<ParkingSpotModel>> getAllParkingSpots(){
	return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll());
}

}