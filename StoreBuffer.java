package tomasoluSimulation;

import java.util.PriorityQueue;
import java.util.Queue;

public class StoreBuffer {
	int latency;
	store s1 = new store("S1");
	store s2 = new store("S2");
	store s3 = new store("S3");
	store s4 = new store("S4");
	store s5 = new store("S5");
	Queue<Object> buffer = new PriorityQueue<Object> (); 
	public StoreBuffer() {
		super();
	}
	public boolean hasSpace() {
		if(!s1.isBusy()||!s2.isBusy()||!s3.isBusy()||!s4.isBusy()||!s5.isBusy()) {
			return true;
		}
		return false;
	}
	public void add(store s) {

		if(!s1.isBusy()) {
			s1=s;
			s.setName("S1");
			
		}
		else if(!s2.isBusy()) {
			s2=s;
			s.setName("S2");
			
		}
		else if(!s3.isBusy()) {
			s3=s;
			s.setName("S3");
			
		}
		else if(!s4.isBusy()) {
			s4=s;
			s.setName("S4");
			
		}
		else if(!s5.isBusy()) {
			s5=s;
			s.setName("S5");
			
		}
		
		
	}
	public void remove(store s) {
		String sname = s.name;
		if (sname=="S1") {
			s1= new store("S1");
		}
		else if (sname=="S2") {
			s2= new store("S2");
		}
		else if (sname=="S3") {
			s3= new store("S3");
		}
		else if (sname=="S4") {
			s4= new store("S4");
		}
		else if (sname=="S5") {
			s5= new store("S5");
		}
		
	}
}
