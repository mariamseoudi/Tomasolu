package tomasoluSimulation;

import java.util.PriorityQueue;
import java.util.Queue;

public class loadBuffer {
	int latency;
	load l1 = new load("L1");
	load l2 = new load("L2");
	load l3 = new load("L3");
	load l4 = new load("L4");
	load l5 = new load("L5");
	
	Queue<Object> buffer = new PriorityQueue<Object> (); 
	public loadBuffer() {
		super();
	}
	public boolean hasSpace() {
		if(!l1.isBusy()||!l2.isBusy()||!l3.isBusy()||!l4.isBusy()||!l5.isBusy()) {
			return true;
		}
		return false;
	}
	public void add(load l) {
		if(!l1.isBusy()) {
			l1=l;
			l.setName("L1");
			
		}
		else if(!l2.isBusy()) {
			l2=l;
			l.setName("L2");
			
		}
		else if(!l3.isBusy()) {
			l3=l;
			l.setName("L3");
			
		}
		else if(!l4.isBusy()) {
			l4=l;
			l.setName("L4");
			
		}
		else if(!l5.isBusy()) {
			l5=l;
			l.setName("L5");
			
		}
		
		
	}
	public void remove(load l) {
		String lname = l.name;
		if (lname=="L1") {
			l1= new load("L1");
		}
		else if (lname=="L2") {
			l2= new load("L2");
		}
		else if (lname=="L3") {
			l3= new load("L3");
		}
		else if (lname=="L4") {
			l4= new load("L4");
		}
		else if (lname=="L5") {
			l5= new load("L5");
		}
		
	}
}
