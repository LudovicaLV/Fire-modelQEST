package Model;

import java.util.Arrays;

public class Cost {
	
	
	public static double Update(double cost, String nameToCheck){
		if (Arrays.asList(TotalFire.TotalFire.ListAction).contains(nameToCheck)){
			int positionAction = Arrays.asList(TotalFire.TotalFire.ListAction).indexOf(nameToCheck);
			double costToAdd = TotalFire.TotalFire.ListCost[positionAction];
		    double costUp = cost + costToAdd;
		    return costUp;
		}else{
		return cost;
	}
	}

}
