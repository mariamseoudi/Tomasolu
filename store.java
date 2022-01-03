package tomasoluSimulation;



	public class store {
		String name;
		int cycle;
		boolean busy;
		int address;
		double v1;
		String q1;
		
		public store(String name) {
			this.name = name;
			cycle=0;
			q1=null;
			busy=false;
		}
		public void execute() {
			cycle=cycle+1;
		}
		public boolean willGrab(String tag, double value) {
			if (q1.equals(tag)) {
				v1 = value;
				q1 = null;
				return true;

			}

			return false;
		}
		public boolean canExecute() {
			if (q1 == null) {
				return true;
			}
			return false;
		}
		public boolean canWriteBack(int latency) {
			if (cycle == latency) {
				return true;
			}
			return false;
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
		public double getV1() {
			return v1;
		}
		public void setV1(double v1) {
			this.v1 = v1;
		}
		public String getQ1() {
			return q1;
		}
		public void setQ1(String q1) {
			this.q1 = q1;
		}

	}


