package tomasoluSimulation;

import java.util.PriorityQueue;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;
import javax.security.auth.x500.X500Principal;
public class instructionQ {
	Queue<instruction> instructions = new LinkedList<instruction> (); 
	public instructionQ(String filename) throws Exception {
	Vector<String> v=readFile( filename);
	System.out.println(v);
	for(int i=0;i<v.size();i++) {
	String[]ins=parse(v.get(i));
	System.out.println(ins.length);
	instruction inst=new instruction();
	inst.setType(ins[0]);
	inst.setRs(ins[2]);
	if(ins.length==4) {
	inst.setRx(ins[3]);
	inst.setRd(ins[1]);}
	else {
		inst.setRd(ins[1]);
	}
	instructions.add(inst);
	
	}
		
	}
	public static Vector<String>readFile(String filename) {
		Vector<String> v = new Vector<String>();
		String s = "";
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				v.add(line);
				s += line;
				s += "\n";
				
			}System.out.println(v.get(1));
			//System.out.println(s);
			return v;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error occured while trying to readfile, are you sure file exists?");
			e.printStackTrace();
		}
		return null;
	}
	public String[] parse(String v) throws Exception {
	return	 v.split("\\s+");

	}
	public  boolean isEmpty() {
		return(instructions.isEmpty());
	}
	public instruction remove() {
		return instructions.remove();
	}
	public instruction peek() {
		return instructions.peek();
	}

 public static void main (String[]args) throws Exception {
	
	//parse( readFile("/Users/macbookair/eclipse-workspace/tomasoluSimulation/src/test.txt").get(0));
 }
 }
