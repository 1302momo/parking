package com.parking.parkInvoice.models;

import java.util.Objects;

import com.parking.parkInvoice.vehicle.Vehicle;
import com.parking.parkInvoice.vehicle.VehicleType;
/**
 * The Receipt is used to store the type of vehicle, the time spent and the tariff.
 */

public class Receipt {
	
	private Vehicle vehicle;
	private long timeSpent;
	private long tariff;
	
	public Receipt(Vehicle vehicle, long timeSpent, long tariff) {
		this.vehicle = vehicle;
		this.timeSpent = timeSpent;
		this.tariff = tariff;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public long getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(long timeSpent) {
		this.timeSpent = timeSpent;
	}

	public long getTariff() {
		return tariff;
	}

	public void setTariff(long tariff) {
		this.tariff = tariff;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tariff, timeSpent, vehicle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Receipt))
			return false;
		Receipt other = (Receipt) obj;
		return tariff == other.tariff && timeSpent == other.timeSpent && Objects.equals(vehicle, other.vehicle);
	}

	@Override
	public String toString() {
		return "Vehicle : " + vehicle + "\nDuration : " + timeSpent + "\nTariff : "+ tariff;
	}
	
	
	
}
