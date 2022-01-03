package tomasoluSimulation;

import java.io.IOException;
import java.util.Hashtable;

public class tomasolu {
	int mulLatency;
	int addLatency;
	int stLatency;
	int ldLatency;
	static RegFile regs;
	static adderResStation adders;
	static multiplierResStation multipliers;
	static StoreBuffer stores;
	static loadBuffer loads;
	
	static instructionQ q;
	public tomasolu(int mul,int add,int ld,int st) throws Exception {
		this.mulLatency=mul;
		this.addLatency=add;
		this.stLatency=st;
		this.ldLatency=ld;
		regs=new RegFile();
		adders=new adderResStation(add);
		multipliers=new multiplierResStation( mulLatency);
		stores=new StoreBuffer();
		loads=new loadBuffer();
 q=new instructionQ("/Users/macbookair/eclipse-workspace/tomasoluSimulation/src/test.txt");
 this.process();

	}
	public static void process() {
	int i=0;
			while(i<9) {
				if(q.isEmpty()) {
					System.out.print("cycle:"+i);
					
					Hashtable<String, Double> h=adders.publishOntheBus();
					Hashtable<String, Double> hm=multipliers.publishOntheBus();
					adders.execute();
					multipliers.execute();
					
					 h.forEach((key, value)
		                       -> 
					adders.readFromtheBus(key, value));
					 h.forEach((key, value)
		                       -> 
					multipliers.readFromtheBus(key, value));
					 hm.forEach((key, value)
		                       -> 
					multipliers.readFromtheBus(key, value));
					 hm.forEach((key, value)
		                       -> 
					adders.readFromtheBus(key, value));
					 h.forEach((key, value)
		                       -> 
					regs.readFromTheBus(key, value));
					 hm.forEach((key, value)
		                       -> 
					regs.readFromTheBus(key, value));
		
				System.out.println(regs.getReg("f7").getContents());
				i=i+1;
				
				}
				else {
System.out.print("cycle:"+i);
					
					Hashtable<String, Double> h=adders.publishOntheBus();
					Hashtable<String, Double> hm=multipliers.publishOntheBus();
					adders.execute();
					multipliers.execute();
					
					 h.forEach((key, value)
		                       -> 
					adders.readFromtheBus(key, value));
					 h.forEach((key, value)
		                       -> 
					multipliers.readFromtheBus(key, value));
					 hm.forEach((key, value)
		                       -> 
					multipliers.readFromtheBus(key, value));
					 hm.forEach((key, value)
		                       -> 
					adders.readFromtheBus(key, value));
					 h.forEach((key, value)
		                       -> 
					regs.readFromTheBus(key, value));
					 hm.forEach((key, value)
		                       -> 
					regs.readFromTheBus(key, value));
				instruction k=new instruction();
			boolean space=	checkSpace(q.peek());
			if (space==true) {
			k=	q.remove();
			k.issue(regs, adders);
			k.issue(regs, multipliers);
			System.out.println(regs.getReg("f2").getContents());
			i=i+1;
			}}
			
			
		
	}
	
	
	}
	public static boolean checkSpace(instruction ins) {
	switch(ins.type) {
	case"ADD.D":
		if(adders.hasSpace()) {
			return true;
		}
	break;
	case "SUB.D":
		if(adders.hasSpace()) {
			return true;
		}
	break;
	case"MUL.D":
		if(multipliers.hasSpace()) {
			return true;
		}
		
	break;
		
	case"DIV.D":
		if(multipliers.hasSpace()) {
			return true;
		}
		break;
//	case"L.D":
//		if(loads.hasSpace()) {
//			return true;
//		}
//	break;
//		
//	case"S.D":
//		if(stores.hasSpace()) {
//			return true;
//		}
//	break;
	
	}
	return false;
	
	}
	 public static void main (String[]args) throws Exception {
			tomasolu t=new tomasolu(3,2,1,1);
			//parse( readFile("/Users/macbookair/eclipse-workspace/tomasoluSimulation/src/test.txt").get(0));
		 }
}
