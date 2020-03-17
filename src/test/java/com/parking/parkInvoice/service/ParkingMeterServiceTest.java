package com.parking.parkInvoice.service;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.parking.parkInvoice.models.ParkTicket;
import com.parking.parkInvoice.models.Receipt;
import com.parking.parkInvoice.services.ParkingMeterService;
import com.parking.parkInvoice.vehicle.EnergyType;
import com.parking.parkInvoice.vehicle.VehicleFactory;
import com.parking.parkInvoice.vehicle.VehicleType;

import junit.framework.TestCase;

@ExtendWith(MockitoExtension.class)			

public class ParkingMeterServiceTest extends TestCase {	
	
	ParkingMeterService parkingMeterService = Mockito.mock(ParkingMeterService.class) ; 
	
 	@Before
 
	public void setUp() {

	MockitoAnnotations.initMocks(this);

	}
	
	@Test
	 public void should_return_the_tariff_4_when_calcTariffs_called () {

		LocalDateTime parked = LocalDateTime.of(2020,01,20,1,30);
    	LocalDateTime collected  = LocalDateTime.of(2020,01,20,2,30);
    	
		ParkTicket parkTicket = new ParkTicket(parked,collected,VehicleFactory.getVehicle(EnergyType.PETROL, VehicleType.CAR));
		
		Mockito.when(parkingMeterService.calculateTime(parkTicket)).thenReturn((long)2);
		Mockito.when(parkingMeterService.calcTariffs(parkTicket)).thenCallRealMethod();

		assertEquals(4,parkingMeterService.calcTariffs(parkTicket));
	 }
	
	
	@Test
	 public void should_return_the_tariff_2_when_calcTariffs_called () {

		LocalDateTime parked = LocalDateTime.of(2020,01,20,1,30);
    	LocalDateTime collected  = LocalDateTime.of(2020,01,20,2,30);
    	
		ParkTicket parkTicket = new ParkTicket(parked,collected,VehicleFactory.getVehicle(EnergyType.PETROL, VehicleType.MOTO_BIKE));
		
		Mockito.when(parkingMeterService.calculateTime(parkTicket)).thenReturn((long)2);
		Mockito.when(parkingMeterService.calcTariffs(parkTicket)).thenCallRealMethod();

		assertEquals(2,parkingMeterService.calcTariffs(parkTicket));
	 }
	 
	@Test
	 public void should_return_timeSpent_aHour_when_calculateTime_called () {

		LocalDateTime parked = LocalDateTime.of(2020,01,20,1,30);
	    LocalDateTime collected  = LocalDateTime.of(2020,01,20,2,30);
	    	
		ParkTicket parkTicket = new ParkTicket(parked,collected,VehicleFactory.getVehicle(EnergyType.PETROL, VehicleType.CAR));
		Mockito.when(parkingMeterService.calculateTime(parkTicket)).thenCallRealMethod();
		
		assertEquals(1,parkingMeterService.calculateTime(parkTicket));
	 }
	 
	@Test
	 public void should_return_timeSpent_twoDays_when_calculateTime_called () {

		LocalDateTime parked = LocalDateTime.of(2020,01,20,1,30);
	    LocalDateTime collected  = LocalDateTime.of(2020,01,21,1,30);
	    	
		ParkTicket parkTicket = new ParkTicket(parked,collected,VehicleFactory.getVehicle(EnergyType.PETROL, VehicleType.CAR));
		Mockito.when(parkingMeterService.calculateTime(parkTicket)).thenCallRealMethod();
		
		assertEquals(24,parkingMeterService.calculateTime(parkTicket));
	 }
	
	@Test
	 public void should_return_receipt_when_getReceipt_called () {
		
		LocalDateTime parked = LocalDateTime.of(2020,01,20,1,30);
		LocalDateTime collected  = LocalDateTime.of(2020,01,20,2,30);
		    	
		ParkTicket parkTicket = new ParkTicket(parked,collected,VehicleFactory.getVehicle(EnergyType.PETROL, VehicleType.CAR));
		
		Mockito.when(parkingMeterService.calcTariffs(parkTicket)).thenReturn((long)4);
		Mockito.when(parkingMeterService.calculateTime(parkTicket)).thenReturn((long)2);
		Mockito.when(parkingMeterService.getReceipt(parkTicket)).thenCallRealMethod();

		Receipt receipt = new Receipt(VehicleFactory.getVehicle(EnergyType.PETROL, VehicleType.CAR),2,4);
		    
		assertEquals(receipt,parkingMeterService.getReceipt(parkTicket));
	 }
	
	@Test
	 public void should_return_receipt_for_24h_when_getReceipt_called () {
		
		LocalDateTime parked = LocalDateTime.of(2020,01,20,1,30);
		LocalDateTime collected  = LocalDateTime.of(2020,01,20,2,30);
		    	
		ParkTicket parkTicket = new ParkTicket(parked,collected,VehicleFactory.getVehicle(EnergyType.PETROL, VehicleType.CAR));
		
		Mockito.when(parkingMeterService.calcTariffs(parkTicket)).thenReturn((long)48);
		Mockito.when(parkingMeterService.calculateTime(parkTicket)).thenReturn((long)24);
		Mockito.when(parkingMeterService.getReceipt(parkTicket)).thenCallRealMethod();

		Receipt receipt = new Receipt(VehicleFactory.getVehicle(EnergyType.PETROL, VehicleType.CAR),24,48);
		    
		assertEquals(receipt,parkingMeterService.getReceipt(parkTicket));
	 }

}
