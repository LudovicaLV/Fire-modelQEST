package TotalFire;

import CreateModel.WriteAllModelQEST;
import ParserProg5Fire.ModelFire;

public class TotalFire {
	
	public static int initialDimX = 10;   	
	public static int initialDimY = 10;
		
	//parameters
	public static double fD = 1.0;
	public static double p_D = 1.0;
	public static double fBH = 1.0;
	public static double p_BH = 1.0;
	public static double fBT = 1.0;
	public static double p_BT = 0.7;
	public static double fBL = 1.0;
	public static double p_BL = 0.2;
	public static double fBP = 1.0;
	public static double p_BP = 1.0;
	public static double fBPA = 1.0;
	public static double p_BPA = 0.2;
	
	public static double cH = 1.0;
	public static double pH = 1.0;
	public static double cT = 1.0;
	public static double pT = 1.0;
	
	public static double ac = 1.0;
	public static double pc = 1.0;
	
	public static double ex = 1.0;
	
	public static int rangeFire = 1;
	public static int rangeFireD = 1;
	public static int rangeControl = 2;
	public static int rangeControlH = 2;
	public static int rangeControlT = 2;
	
	public static int DangerLine = 12;
	
	public static int[] ZoneInterestX = {5,5,6,6,20,20,21,21};
	public static int[] ZoneInterestY = {20,21,20,21,5,6,5,6};
	
	public static int[] ZoneSafeX = {5,5,6,6,20,20,21,21};
	public static int[] ZoneSafeY = {5,6,5,6,20,21,20,21};
	
	//public static int choice = 1;
	//1: just grass, same density
	//2: just bushes, same density
	//3: just grass, different density
	//4: just bushes, different density
	//5: grass and bushes
	
	public static int initialAmount = 1;
	public static int initialAmountT = 1;
	
	public static int numberOfRuns = 1;
	public static int simulationTime = 20;
	
	//cost analysis
	public static String[] ListAction = {};
	public static double[] ListCost = {};
	
	public static void main(String[] args) throws Exception {
	
     	//WriteAllModelQEST.PrintAll();
		ModelFire.main(null);
     	

	}

}

