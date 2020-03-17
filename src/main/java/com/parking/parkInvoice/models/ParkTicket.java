package com.parking.parkInvoice.models;

import java.time.LocalDateTime;
import java.util.Objects;

import com.parking.parkInvoice.vehicle.Vehicle;

/**
 * The Park ticket is used to store the type of vehicle, park time and the collect time.
 */

public class ParkTicket {
	
	private LocalDateTime parkTime;
	
	private LocalDateTime collectTime;
	
	private Vehicle vehicle;

	public ParkTicket(LocalDateTime parkTime, LocalDateTime collectTime, Vehicle vehicle) {
		this.parkTime = parkTime;
		this.collectTime = collectTime;
		this.vehicle = vehicle;
	}

	public LocalDateTime getParkTime() {
		return parkTime;
	}

	public void setParkTime(LocalDateTime parkTime) {
		this.parkTime = parkTime;
	}

	public LocalDateTime getCollectTime() {
		return collectTime;
	}

	public void setCollectTime(LocalDateTime collectTime) {
		this.collectTime = collectTime;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public int hashCode() {
		return Objects.hash(collectTime, parkTime, vehicle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ParkTicket))
			return false;
		ParkTicket other = (ParkTicket) obj;
		return Objects.equals(collectTime, other.collectTime) && Objects.equals(parkTime, other.parkTime)
				&& Objects.equals(vehicle, other.vehicle);
	}

	@Override
	public String toString() {
		return "ParkTicket [parkTime=" + parkTime + ", collectTime=" + collectTime + ", vehicle=" + vehicle + "]";
	}
			
}
