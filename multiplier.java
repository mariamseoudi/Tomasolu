package tomasoluSimulation;

public class multiplier {
String name;
int cycle;
double v1 ;
double v2;
double value;
String q1;
String q2;
boolean busy;
boolean mul; //if true it is an add operation, else it is a subtract operation
public multiplier(String name) {
	this.name=name;
	q1="nothing";
	q2="nothing";
	cycle=0;
}

public boolean willGrab(String tag,Double value2) {
	if(q1!="0"&&q1.equals(tag)) {
		
		v1=value2;
		q1="0";
		if(q2!="0"&&q2.equals(tag)) {
			v2=value2;
			q2="0";
			return true;
			
		}
		return true;
		
	}
	if(q2!="0"&&q2.equals(tag)) {
		v2=value2;
		q2="0";
		return true;}
	
	return false;
}

public void execute( int latency) {
	if( canExecute()&&cycle<=latency) {
	if (mul==true) {
		cycle=cycle+1;
		value= v1*v2;
	}
	else {
	cycle=cycle+1;
	value= v1/v2;
	}
	System.out.println(this.name+" is executing");}
}
public boolean canExecute() {
	if(q1.equals("0")&&q2.equals("0")) {
		return true;
	}
	return false;
}
public boolean canWriteBack(int latency) {
	if(cycle==latency) {
		
		return true;
	}
	return false;
}
public Double publish(int latency) {
	if(canWriteBack( latency)) {	
		System.out.println(this.name+" is publishing"+value);
		this.setBusy(false);
		return value;
	
	}
	return null;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getV1() {
	return v1;
}
public void setV1(double d) {
	this.v1 = d;
	this.q1="0";
}
public double getV2() {
	return v2;
}
public void setV2(double d) {
	this.v2 = d;
	this.q2="0";
}
public Object getQ1() {
	return q1;
}
public void setQ1(String q1) {
	this.q1 = q1;
}
public Object getQ2() {
	return q2;
}
public void setQ2(String q2) {
	this.q2 = q2;
	
}
public boolean isBusy() {
	return busy;
}
public void setBusy(boolean busy) {
	this.busy = busy;
}
public boolean isMul() {
	return mul;
}
public void setMul(boolean add) {
	this.mul = mul;
}


}


