package TotalFire;

import java.util.ArrayList;

public class ToPlot {
	
	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> LL = new ArrayList<>();
		for (int i=0; i < 25; i++){
			for (int j=0; j < 25; j++){
			System.out.print(i + ", ");
			ArrayList<Integer> toAdd = new ArrayList<>();
			toAdd.add(i);
			toAdd.add(j);
			LL.add(toAdd);
		}
		}
		System.out.println(", ");
		for (int i=0; i < 25; i++){
			for (int j=0; j < 25; j++){
			System.out.print(j + ", ");
		}
		}
		System.out.println(", ");
		
		ArrayList<ArrayList<Integer>> LLP = new ArrayList<>();
		for (int i=0; i <TotalFire.ZoneInterestX.length; i++){
			ArrayList<Integer> newL = new ArrayList<>();
			newL.add(TotalFire.ZoneInterestX[i]);
			newL.add(TotalFire.ZoneInterestY[i]);
			LLP.add(newL);
			}
		
		ArrayList<ArrayList<Integer>> LLS = new ArrayList<>();
	for (int i=0; i <TotalFire.ZoneSafeX.length; i++){
			ArrayList<Integer> newL = new ArrayList<>();
			newL.add(TotalFire.ZoneSafeX[i]);
			newL.add(TotalFire.ZoneSafeY[i]);	
			LLS.add(newL);
		}
		
		for (int i=0; i < LL.size(); i++){
			if (LLP.contains(LL.get(i))){
			System.out.print(2 + ", ");
		}else{
			System.out.print(0 + ", ");
		}
		}
		System.out.println(" ");
		
		for (int i=0; i < LL.size(); i++){
			if (LLS.contains(LL.get(i))){
			System.out.print(2 + ", ");
		}else{
			System.out.print(0 + ", ");
		}
		}
		
		
		
	}

}
