package pacote;

import java.util.List;
import java.util.ArrayList;

public class AssemblyOp {

	private String op = null;
	private int value1;
	private int value2;
	private int value3;
	private String assembly = null;
	private List<Integer> bubbles = new ArrayList<>();
	
	public List<Integer> getBubbles() {
		return bubbles;
	}
	
	public void addBubble(int bubble) {
		bubbles.add(bubble);
	}
	
	public void setAssembly(String assembly) {
		this.assembly = assembly;
	}
	
	public String getAssembly() {
		return assembly;
	}
	
	public void setOp(String op) {
		this.op = op;
	}
	
	public void setValue1(int value1) {
		this.value1 = value1;
	}
	
	public void setValue2(int value2) {
		this.value2 = value2;
	}
	
	public void setValue3(int value3) {
		this.value3 = value3;
	}
	
	public String getOp() {
		return op;
	}
	
	public int getValue1() {
		return value1;
	}
	
	public int getValue2() {
		return value2;
	}
	
	public int getValue3() {
		return value3;
	}
}
