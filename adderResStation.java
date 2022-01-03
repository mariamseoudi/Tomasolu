package tomasoluSimulation;

import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;

public class adderResStation {
int latency;
adder a1=new adder("A1");
adder a2=new adder("A2");
adder a3=new adder("A3");

Queue<Object> buffer = new PriorityQueue<Object> (); 
public  adderResStation(int latency) {
	this.latency=latency;
}
public adder add(adder a) {

	
	
if(!a1.isBusy()) {
		a1=a;
		a.setName("A1");
		a.setBusy(true);
		return a;
	}
	else if(!a2.isBusy()) {
		a2=a;
		a.setName("A2");
		a.setBusy(true);
		return a;
	}
	else if(!a3.isBusy()) {
		a3=a;
		a.setName("A3");
		a.setBusy(true);
		return a;
	}
	
	return null;
}
//public void addToBuffer(String a) {} takes from instruction queue and add to buffer
	


public boolean hasSpace() {
	if(!a1.isBusy()) {
		return true;
		
	}
	else if(!a2.isBusy()) {
		return true;
	}
	else if(!a3.isBusy()) {
		return true;
		
	}
	return false;
}
public void emptyStation(adder a) {
	if (a.equals(a1)) {
		a1.setBusy(false);
	}
	if (a.equals(a2)) {
		a2.setBusy(false);
	}
	if (a.equals(a3)) {
		a3.setBusy(false);
	}
}
public Vector <adder>readFromtheBus(String tag,Double value) {
	Vector<adder>a=new Vector<adder>();
	if(a1.willGrab(tag, value)) {
		a.add(a1);
		System.out.println("a1"+"grabbed");
		
	}
	if(a2.willGrab(tag, value)) {
		a.add(a2);
		System.out.println("a2"+"grabbed");
		
	}
	if(a3.willGrab(tag, value)) {
		a.add(a3);
		System.out.println("a3"+"grabbed");
		
	}return a;
}

public void execute() {
	a1.execute(latency);

	a2.execute(latency);
	a3.execute(latency);
}
public Hashtable <String,Double>publishOntheBus() {
	Hashtable <String,Double>a=new Hashtable <String,Double>();
	if(a1.publish(latency)!=null) {
		a.put(a1.name,a1.publish(latency));
		
	}
	if(a2.publish(latency)!=null) {
		a.put(a2.name,a2.publish(latency));
		
	}
	if(a3.publish(latency)!=null) {
		a.put(a3.name,a3.publish(latency));
		
	}return a;
}


}
