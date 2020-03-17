package com.parking.parkInvoice.vehicle;

import java.util.Objects;

public class Vehicle {

	public VehicleType vehicleType;
	public EnergyType  energyType;
	public long ratioCost;
	
	public Vehicle(VehicleType vehicleType, EnergyType energyType, long ratioCost) {
		this.vehicleType = vehicleType;
		this.energyType = energyType;
		this.ratioCost = ratioCost;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public EnergyType getEnergyType() {
		return energyType;
	}

	public void setEnergyType(EnergyType energyType) {
		this.energyType = energyType;
	}

	public long getRatioCost() {
		return ratioCost;
	}

	public void setRatioCost(long ratioCost) {
		this.ratioCost = ratioCost;
	}

	@Override
	public int hashCode() {
		return Objects.hash(energyType, ratioCost, vehicleType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Vehicle))
			return false;
		Vehicle other = (Vehicle) obj;
		return energyType == other.energyType && ratioCost == other.ratioCost && vehicleType == other.vehicleType;
	}

	@Override
	public String toString() {
		return  vehicleType + " "  + energyType ;
	}

}
