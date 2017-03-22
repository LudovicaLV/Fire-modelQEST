package CreateModel;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import ParserProg5Fire.ModelFire;


public class WriteAllModelQEST {	
	static String Model;
    
	public static void PrintAll(){	
		
    Model = "/Users/ludovicaluisavissat/workspacejSSTL/Fire-modelQEST/src/ModelPoints2";
 		  		
    PrintWriter writer_model = null;
	try {
		writer_model = new PrintWriter(Model+".mela", "UTF-8");		
	} catch (FileNotFoundException | UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

writer_model.println("#Space: TwoD(" + TotalFire.TotalFire.initialDimX + "," + TotalFire.TotalFire.initialDimY + ")\n" +
			"#Parameters");	

   writer_model.println("fD" +  "= " + TotalFire.TotalFire.fD + ";");
   writer_model.println("pD" + "= " + TotalFire.TotalFire.p_D + ";");
   writer_model.println("fBH" +  "= " + TotalFire.TotalFire.fBH + ";");
   writer_model.println("pBH" + "= " + TotalFire.TotalFire.p_BH + ";");
   writer_model.println("fBT" +  "= " + TotalFire.TotalFire.fBT + ";");
   writer_model.println("pBT" + "= " + TotalFire.TotalFire.p_BT + ";");
   writer_model.println("fBL" +  "= " + TotalFire.TotalFire.fBL + ";");
   writer_model.println("pBL" + "= " + TotalFire.TotalFire.p_BL + ";");

   writer_model.println("fBP" +  "= " + TotalFire.TotalFire.fBP + ";");
   writer_model.println("pBP" + "= " + TotalFire.TotalFire.p_BP + ";");
   writer_model.println("fBPA" +  "= " + TotalFire.TotalFire.fBPA + ";");
   writer_model.println("pBPA" + "= " + TotalFire.TotalFire.p_BPA + ";");

   writer_model.println("cH" +  "= " + TotalFire.TotalFire.cH + ";");
   writer_model.println("pH" + "= " + TotalFire.TotalFire.pH + ";");
   writer_model.println("cT" +  "= " + TotalFire.TotalFire.cT + ";");
   writer_model.println("pT" + "= " + TotalFire.TotalFire.pT + ";");
   
   writer_model.println("ac" +  "= " + TotalFire.TotalFire.ac + ";");
   writer_model.println("pc" + "= " + TotalFire.TotalFire.pc + ";");
   
   writer_model.println("ex" +  "= " + TotalFire.TotalFire.ex + ";");
   
   writer_model.println(" ");
   
writer_model.println("#Agents");
//this part is for D(l)
writer_model.println("D(l) := ->{N(" + TotalFire.TotalFire.rangeFireD + ")}(fireD, fD).D(l);");		
//this part is for B(l) 
writer_model.println("B(l) := ->{N(" + TotalFire.TotalFire.rangeFire + ")}(fireBH,fBH).B(l) + ->{N(" + TotalFire.TotalFire.rangeFire + ")}(fireBT,fBT).B(l) + ->{N(" + TotalFire.TotalFire.rangeFire + ")}(fireBL,fBL).B(l) +  ->{N(" + TotalFire.TotalFire.rangeControl + ")}(actControl,ac).B(l) + ->{N(" + TotalFire.TotalFire.rangeFire + ")}(fireBP,fBP).B(l) + ->{N(" + TotalFire.TotalFire.rangeFire + ")}(fireBPA,fBPA).B(l) + (ext, ex).EX(l);");
//this part is for EX(l) 
writer_model.println("EX(l) := ;");
//this part is for S(l) 
writer_model.println("S(l) := ;");
//this part is for H(l) 
writer_model.println("H(l) := <-(fireD,pD).B(l) +  <-(fireBH,pBH).B(l) +  <-(controlH,pH).L(l);");
//this part is for T(l) 
writer_model.println("T(l) := <-(fireBT,pBT).B(l) + <-(controlT,pT).L(l);");
//this part is for L(l) 
writer_model.println("L(l) := <-(fireBL,pBL).B(l);");
//this part is for P(l) 
writer_model.println("P(l) := <-(actControl,pc).PA(l) + <-(fireBP,pBP).B(l);");
//this part is for PA(l) 
writer_model.println("PA(l) := ->{N(" + TotalFire.TotalFire.rangeControlH  +")}(controlH,cH).PA(l) + ->{N(" + TotalFire.TotalFire.rangeControlT  +")}(controlT,cT).PA(l) + <-(fireBPA,pBPA).B(l);");


//Initial Conditions:
    writer_model.println(" ");
	writer_model.println("#Initial conditions");	
	
	ArrayList<ArrayList<Integer>> listLoc = new ArrayList<>();
	for (int i=0; i <TotalFire.TotalFire.initialDimX; i++){
		for (int j=0; j <TotalFire.TotalFire.initialDimY; j++){
			ArrayList<Integer> newL = new ArrayList<>();
			newL.add(i);
			newL.add(j);
			listLoc.add(newL);
			}
		}
	
	//Danger agents
	for (int i=0; i <TotalFire.TotalFire.initialDimX; i++){
		writer_model.print("D(" + i + "," + TotalFire.TotalFire.DangerLine + ")[" + TotalFire.TotalFire.initialAmount + "]||");
		ArrayList<Integer> newL = new ArrayList<>();
		newL.add(i);
		newL.add(TotalFire.TotalFire.DangerLine);
		int remove = listLoc.indexOf(newL);
		listLoc.remove(remove);
	}	
	
	//High risk agents up
	int line_up = TotalFire.TotalFire.DangerLine + 1;	
	for (int i=0; i <TotalFire.TotalFire.initialDimX; i++){
		writer_model.print("H(" + i + "," + line_up + ")[" + TotalFire.TotalFire.initialAmount + "]||");
		ArrayList<Integer> newL = new ArrayList<>();
		newL.add(i);
		newL.add(line_up);
		int remove = listLoc.indexOf(newL);
		listLoc.remove(remove);
	}
	
	//High risk agents down
	int line_down = TotalFire.TotalFire.DangerLine - 1;	
	for (int i=0; i <TotalFire.TotalFire.initialDimX; i++){
		writer_model.print("H(" + i + "," + line_down + ")[" + TotalFire.TotalFire.initialAmount + "]||");
		ArrayList<Integer> newL = new ArrayList<>();
		newL.add(i);
		newL.add(line_down);
		int remove = listLoc.indexOf(newL);
		listLoc.remove(remove);
	}
	
	//interest zone
	for (int i=0; i <TotalFire.TotalFire.ZoneInterestX.length; i++){
			ArrayList<Integer> newL = new ArrayList<>();
			newL.add(TotalFire.TotalFire.ZoneInterestX[i]);
			newL.add(TotalFire.TotalFire.ZoneInterestY[i]);
			writer_model.print("P(" + TotalFire.TotalFire.ZoneInterestX[i] + "," + TotalFire.TotalFire.ZoneInterestY[i] + ")[" + TotalFire.TotalFire.initialAmount + "]||");
			int remove = listLoc.indexOf(newL);
			listLoc.remove(remove);	
			}
		
		
	//safety zone
	for (int i=0; i <TotalFire.TotalFire.ZoneSafeX.length; i++){
			ArrayList<Integer> newL = new ArrayList<>();
			newL.add(TotalFire.TotalFire.ZoneSafeX[i]);
			newL.add(TotalFire.TotalFire.ZoneSafeY[i]);
			writer_model.print("S(" + TotalFire.TotalFire.ZoneSafeX[i] + "," + TotalFire.TotalFire.ZoneSafeY[i] + ")[" + TotalFire.TotalFire.initialAmount + "]||");
			int remove = listLoc.indexOf(newL);
			listLoc.remove(remove);					
		}
	
	int lastList = listLoc.size() - 1;
	for (int i=0; i < lastList; i++){
		writer_model.print("T(" + listLoc.get(i).get(0) + "," + listLoc.get(i).get(1) + ")[" + TotalFire.TotalFire.initialAmount + "]||");		
	}
	
	writer_model.print("T(" + listLoc.get(lastList).get(0) + "," + listLoc.get(lastList).get(1) + ")[" + TotalFire.TotalFire.initialAmount + "]");		
	writer_model.println(" ");

writer_model.close();
}



	  //used in SimulatorFire
    public static String Log (){	
    	String log = "/Users/ludovicaluisavissat/workspacejSSTL/Fire-modelQEST/src/Output/Log/Output" +  ModelFire._SIMULATION_ID;
    	return log;
    }

    //used in SimulatorFire
    public static String Meta (){	
    	String meta = "/Users/ludovicaluisavissat/workspacejSSTL/Fire-modelQEST/src/Output/Meta/Output" +  ModelFire._SIMULATION_ID;
    	return meta;
    }


    //used in SimulatorFire
    public static String Data (){	
    	String data = "/Users/ludovicaluisavissat/workspacejSSTL/Fire-modelQEST/src/Output/Data/Output" +  ModelFire._SIMULATION_ID;
        return data;
    }
    
    //used in SimulatorFire
    public static String Cost (){	
    	String data = "/Users/ludovicaluisavissat/workspacejSSTL/Fire-modelQEST/src/Output/Cost/Output" +  ModelFire._SIMULATION_ID;
        return data;
    }
    }
