package com.parking.parkInvoice.factory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.parking.parkInvoice.vehicle.EnergyType;
import com.parking.parkInvoice.vehicle.Vehicle;
import com.parking.parkInvoice.vehicle.VehicleFactory;
import com.parking.parkInvoice.vehicle.VehicleType;

import junit.framework.TestCase;

@ExtendWith(MockitoExtension.class)			

public class VehicleFactoryTest extends TestCase {
		
	@Test
	 public void should_return_the_vehicle_TypeCAR_when_getVehicle_called () {
		
		Vehicle vehicle = new Vehicle(VehicleType.CAR, EnergyType.PETROL, (long)2);
	
		assertEquals(vehicle, VehicleFactory.getVehicle(EnergyType.PETROL, VehicleType.CAR));
	 }
	
	@Test
	 public void should_return_the_vehicle_TypeMoTO_when_getVehicle_called () {
		
		Vehicle vehicle = new Vehicle(VehicleType.MOTO_BIKE, EnergyType.PETROL, (long)1);
	
		assertEquals(vehicle, VehicleFactory.getVehicle(EnergyType.PETROL, VehicleType.MOTO_BIKE));
	 }
	
	@Test
	 public void should_return_the_CarCost_when_the_CarType_called() {
		
		assertEquals(2, VehicleFactory.generateCostHour(VehicleType.CAR));
	 }
	 
	@Test
	 public void should_return_the_MotoCost_when_the_MotoType_called() {
		
		assertEquals(1, VehicleFactory.generateCostHour(VehicleType.MOTO_BIKE));
	 }
}
