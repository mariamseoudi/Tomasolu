package tomasoluSimulation;

public class RegFile {
	Reg []file =new Reg[32];
	public RegFile() {
		for(int i=0;i<32;i++) {
			String name = "F"+i;
			file[i]= new Reg(name);
		}
	}
	public Reg getReg(String name) {
		int index = Integer.parseInt(name.substring(1));
		return file[index];
	}
	public void setReg(Reg r) {
		int index = Integer.parseInt(r.getName().substring(1));
		file[index]=r;
	}
	public void readFromTheBus(String tag,Double value) {
		
		for(int i=0;i<file.length;i++) {
			file[i].willGrab(tag, value);
		}
	}
	
}
