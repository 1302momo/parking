package com.parking.parkInvoice.vehicle;
/**
 * The Vehicle factory is used to generate different type of vehicle
 * And to generate the corresponding ratio.
 */
public class VehicleFactory {
		
		public static Vehicle getVehicle(EnergyType typeEnergy, VehicleType vehicleType){
		
			switch (vehicleType) {

			case CAR:
				
				if(typeEnergy.equals(EnergyType.PETROL)) {
					return new Vehicle(VehicleType.CAR, EnergyType.PETROL, generateCostHour(vehicleType));
				}

				break;

			case MOTO_BIKE:
				
				if(typeEnergy.equals(EnergyType.PETROL)) {
					return new Vehicle(VehicleType.MOTO_BIKE, EnergyType.PETROL, generateCostHour(vehicleType));
				}

				break;

			default:
				System.out.println("Warring no vehicle, check the Energy or the Vehicle type");

			}
			return null;
		}
	
	public static long generateCostHour (VehicleType vehicleType) {
		
		if(vehicleType.equals(VehicleType.CAR)) {
			return 2;
			
		} else if (vehicleType.equals(VehicleType.MOTO_BIKE)){
			return 1;
			
		}else {
			return 0;
		}
		
	}
}
