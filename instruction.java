package tomasoluSimulation;

public class instruction {
	String rs;
	String rx;
	String rd;
	String type;

	public instruction () {
	super();
	}
	public void issue(RegFile regs,adderResStation x) {//we call it only if there is space in res station so we call it after checking the type and making sure ther is space
		String tag="";
		if(type.equals("ADD.D")) {
			adder a =new adder("");
			x.add(a);
			a.setAdd(true);
			tag=a.getName();
			
			if(regs.getReg(rs).getQj().equals("0")) {
				a.setV1(regs.getReg(rs).getContents());
			}
			else {
				a.setQ1(regs.getReg(rs).getQj());
			}
			if(regs.getReg(rx).getQj().equals("0")) {
				a.setV2(regs.getReg(rx).getContents());
				
			}
			else {
				a.setQ2(regs.getReg(rx).getQj());
			}
			
		}
		else if(type.equals("SUB.D")) {
			adder a =new adder("");
			x.add(a);
			a.setAdd(false);
			tag=a.getName();
			
			if(regs.getReg(rs).getQj()=="0") {
				a.setV1(regs.getReg(rs).getContents());
			}
			else {
				a.setQ1(regs.getReg(rs).getQj());
			}
			if(regs.getReg(rx).getQj()==null) {
				a.setV2(regs.getReg(rx).getContents());
			}
			else {
				a.setQ2(regs.getReg(rx).getQj());
			}
			
		
		
			
		}
		
		
		Reg r=regs.getReg(rd);
		r.setQj(tag);
//System.out.println("heyyy"+r.name+a.getName());
	}
	public void issue(RegFile regs,multiplierResStation x) {//we call it only if there is space in res station so we call it after checking the type and making sure ther is space
		String tag="";
		if(type.equals("MUL.D")) {
			multiplier a =new multiplier("");
			x.add(a);
			a.setMul(true);
			tag=a.getName();
			
			if(regs.getReg(rs).getQj().equals("0")) {
				a.setV1(regs.getReg(rs).getContents());
			}
			else {
				a.setQ1(regs.getReg(rs).getQj());
			}
			if(regs.getReg(rx).getQj().equals("0")) {
				a.setV2(regs.getReg(rx).getContents());
				
			}
			else {
				a.setQ2(regs.getReg(rx).getQj());
			}
			
		}
		else if(type.equals("DIV.D")) {
			multiplier a =new multiplier("");
			x.add(a);
			a.setMul(false);
			tag=a.getName();
			
			if(regs.getReg(rs).getQj()=="0") {
				a.setV1(regs.getReg(rs).getContents());
			}
			else {
				a.setQ1(regs.getReg(rs).getQj());
			}
			if(regs.getReg(rx).getQj()==null) {
				a.setV2(regs.getReg(rx).getContents());
			}
			else {
				a.setQ2(regs.getReg(rx).getQj());
			}
			
		
		
			
		}
		
		
		Reg r=regs.getReg(rd);
		r.setQj(tag);
//System.out.println("heyyy"+r.name+a.getName());
	}


	public String getRs() {
		return rs;
	}

	public void setRs(String rs) {
		this.rs = rs;
	}

	public String getRx() {
		return rx;
	}

	public void setRx(String rx) {
		this.rx = rx;
	}

	public String getRd() {
		return rd;
	}

	public void setRd(String rd) {
		this.rd = rd;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
