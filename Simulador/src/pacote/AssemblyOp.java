package pacote;

public class AssemblyOp {

	private String op = null;
	private int value1;
	private int value2;
	private int value3;
	private String assembly = null;
	private boolean hasBubble = false;
	private int bubbleIndex = 0;
	
	public void setBublle(boolean b, int value) {
		hasBubble = b;
		bubbleIndex = value;
	}
	
	public boolean hasABubble() {
		return hasBubble;
	}
	
	public int getIndex() {
		return bubbleIndex;
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
