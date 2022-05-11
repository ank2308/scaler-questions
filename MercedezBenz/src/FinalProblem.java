
public class FinalProblem {
	
	public int findMaxDistance (int [] fuelCapacity, int [] Mileage, int n, int K) {
		
		int tempDistance = 0;		
		int maxDistance = findDistance(fuelCapacity, Mileage, n);
		for (int i = 0; i < Mileage.length-1; i++) {
			int tempFuelCapacity = Math.max(fuelCapacity[i], fuelCapacity[i+1]);
			tempFuelCapacity = tempFuelCapacity - K;
			int tempMileage = Math.min(Mileage[i], Mileage[i+1]);
			fuelCapacity[i] = fuelCapacity[i+1] = tempFuelCapacity;
			Mileage[i] = Mileage[i+1] = tempMileage;
			tempDistance = findDistance(fuelCapacity, Mileage, n);
			maxDistance = Math.max(tempDistance, maxDistance);
		}
		return maxDistance;
	}
	
	private int findDistance (int [] fuelCapacity, int [] Mileage, int n) {
		int distance = 0;
		for (int i = 0; i < n; i++) {
			distance = distance + (fuelCapacity[i] * Mileage[i]);
		}
		return distance;
	}
 
}
