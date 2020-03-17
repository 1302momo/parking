package com.parking.parkInvoice.application;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.xml.parsers.FactoryConfigurationError;

import com.parking.parkInvoice.models.ParkTicket;
import com.parking.parkInvoice.models.Receipt;
import com.parking.parkInvoice.services.ParkingMeterService;
import com.parking.parkInvoice.vehicle.EnergyType;
import com.parking.parkInvoice.vehicle.Vehicle;
import com.parking.parkInvoice.vehicle.VehicleFactory;
import com.parking.parkInvoice.vehicle.VehicleType;

/**
 * This is the Park meter application
 @author Boukayou Mohammad
 @version 1.0
 */

public class ParkMeter 
{
    public static void main( String[] args )
    {
    	LocalDateTime parked = LocalDateTime.of(2020,01,20,1,30);
    	LocalDateTime collected  = LocalDateTime.of(2020,01,20,2,30);
    	
    	ParkTicket parkTicket = new ParkTicket(parked,collected,VehicleFactory.getVehicle(EnergyType.PETROL, VehicleType.CAR));
    	ParkingMeterService parkingMeterService = new ParkingMeterService();
    	
    	Receipt receipt =  parkingMeterService.getReceipt(parkTicket);
    	System.out.println(receipt);
      
    }
}
