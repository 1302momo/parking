package com.parking.parkInvoice.services;

import java.time.temporal.ChronoUnit;

import com.parking.parkInvoice.models.ParkTicket;
import com.parking.parkInvoice.models.Receipt;
import com.parking.parkInvoice.vehicle.Vehicle;

/**
 * This class is used to calculate the cost and the time 
 * spent inside the park then generate, the invoice.
 */

public class ParkingMeterService {
	
	/**
	 * This method is used to calculate the tariff.
	 * @param ticket 
	 * @return the tariff corresponding to the time spent
	 */

	public long calcTariffs(ParkTicket ticket) {
		
		return ticket.getVehicle().ratioCost * calculateTime(ticket);
		
	}

	/**
	 * This method is used to calculate the tariff.
	 * @param ticket 
	 * @return the time spent by car or bike in the park
	 */
	public long calculateTime(ParkTicket ticket) {

		double timeSpent = Math.ceil((double) ticket.getParkTime().until(ticket.getCollectTime(), ChronoUnit.MINUTES)/60);
		
		return (long)timeSpent;
	}

	/**
	 * This method is used to calculate the tariff.
	 * @param ticket 
	 * @return the invoice wich include the type of vehicle, the tariff
	 * and the time spent inside the park
	 */
	public Receipt getReceipt(ParkTicket ticket) {

		Vehicle vehicle = ticket.getVehicle();
		Long timeSpent = calculateTime(ticket);
		Long tariff = calcTariffs(ticket);

		return new Receipt(vehicle, timeSpent, tariff);

	}

}
