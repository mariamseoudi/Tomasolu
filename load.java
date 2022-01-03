package tomasoluSimulation;

public class load {
	String name;
	int cycle;
	boolean busy;
	int address;
	
	public load(String name) {
		this.name=name;
		busy=false;
		cycle=0;
	}
	public void execute() {
		cycle=cycle+1;
	}
	
	public void writeBack(int latency) {
		if(cycle==latency) {
			//register=memory[address];
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCycle() {
		return cycle;
	}
	public void setCycle(int cycle) {
		this.cycle = cycle;
	}
	public boolean isBusy() {
		return busy;
	}
	public void setBusy(boolean busy) {
		this.busy = busy;
	}
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
}
