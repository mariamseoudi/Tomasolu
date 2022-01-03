package tomasoluSimulation;

public class Reg {
	String name;
	String Qj="0";
	double contents=3;
	
	public Reg(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQj() {
		return Qj;
	}

	public void setQj(String qj) {
		Qj = qj;
	}

	public double getContents() {
		return contents;
	}

	public void setContents(double contents) {
		this.contents = contents;
	}
	public boolean willGrab(String tag,Double value2) {
	
		if(Qj!="0"&&Qj.equals(tag)) {
			
			contents=value2;
			Qj="0";
			
				return true;
				
			}
			return false;
			
		}
}