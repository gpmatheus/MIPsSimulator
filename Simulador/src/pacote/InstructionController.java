
package pacote;

import java.awt.Color;

import javax.swing.JLabel;

public class InstructionController {
	
	private JLabel[] registers;
	private JLabel[] memory;
	private String op;
	
	public String getOp() {
		return op;
	}
	
	public InstructionController(JLabel[] registers, JLabel[] memory) {
		this.registers = registers;
		this.memory = memory;
	}
	
	public void compile(String assembly) throws Exception {
		
		if (assembly == null || assembly.isEmpty()) {
			return;
		}
		
		for (int i = 0; i < registers.length; i++) {
			
			registers[i].setBackground(Color.black);
		}
		
		for (int j = 0; j < memory.length; j++) {
			
			memory[j].setBackground(Color.black);
		}
		
		String[] ins = assembly.split("\\s+");
		
		if (ins.length != 2) {
			throw new Exception();
		}
		
		op = ins[0];
		
		if (ins[0].equalsIgnoreCase("li")) {
			treatLi(ins);
		} else if (ins[0].equalsIgnoreCase("lw")) {
			treatLw(ins);
		} else if (ins[0].equalsIgnoreCase("sw")) {
			treatSw(ins);
		} else if (ins[0].equalsIgnoreCase("add")) {
			treatAdd(ins);
		} else if (ins[0].equalsIgnoreCase("sub")) {
			treatSub(ins);
		} else if (ins[0].equalsIgnoreCase("mov")) {
			treatMovOp(ins);
		} else {
			throw new Exception();
		}
		
	}
	
	private void treatLi(String[] ins) throws Exception {
		
		int[] array = new int[2];
		
		String[] values = ins[1].split(",");
		if (values.length != 2) {
			throw new Exception();
		}
		
		values[0] = values[0].replace("$", "");
		
		array[0] = Integer.parseInt(values[0]);
		array[1] = Integer.parseInt(values[1]);
		
		registers[array[0]].setText(array[1] + "");
		registers[array[0]].setBackground(Color.white);
	}
	
	private void treatLw(String[] ins) throws Exception {
		
		int[] array = treatWordOp(ins);
		
		String text = registers[array[2]].getText();
		
		if (text.equalsIgnoreCase("null")) {
			throw new Exception();
		}
		
		int content = Integer.parseInt(text);
		
		int memoryIndex = content + array[1];
		
		if (memoryIndex > 40 - 1) {
			throw new Exception();
		}
		
		registers[array[0]].setText(memory[memoryIndex].getText());
		registers[array[0]].setBackground(Color.white);
		memory[memoryIndex].setBackground(Color.white);
	}
	
	private void treatSw(String[] ins) throws Exception {
		
		int[] array = treatWordOp(ins);
		
		String text = registers[array[0]].getText();
		
		if (text.equalsIgnoreCase("null")) {
			throw new Exception();
		}
		
		int content = Integer.parseInt(text);
		
		String indexText = registers[array[2]].getText();
		
		if (indexText.equalsIgnoreCase("null")) {
			throw new Exception();
		}
		
		int index = Integer.parseInt(indexText) + array[1];
		
		memory[index].setText(content + "");
		registers[array[0]].setBackground(Color.white);
		memory[index].setBackground(Color.white);
	}
	
	private void treatAdd(String[] ins) throws Exception {
		
		int[] array = treatMathOp(ins);
		
		String text1 = registers[array[1]].getText();
		String text2 = registers[array[2]].getText();
		
		if (text1.equalsIgnoreCase("null") || text2.equalsIgnoreCase("null")) {
			throw new Exception();
		}
		
		int content1 = Integer.parseInt(text1);
		int content2 = Integer.parseInt(text2);
		
		int sum = content1 + content2;
		
		registers[array[0]].setText(sum + "");
		registers[array[0]].setBackground(Color.white);
		registers[array[1]].setBackground(Color.white);
		registers[array[2]].setBackground(Color.white);
	}
	
	private void treatSub(String[] ins) throws Exception {
		
		int[] array = treatMathOp(ins);
		
		String text1 = registers[array[1]].getText();
		String text2 = registers[array[2]].getText();
		
		if (text1.equalsIgnoreCase("null") || text2.equalsIgnoreCase("null")) {
			throw new Exception();
		}
		
		int content1 = Integer.parseInt(text1);
		int content2 = Integer.parseInt(text2);
		
		int sub = content1 - content2;
		
		registers[array[0]].setText(sub + "");
		registers[array[0]].setBackground(Color.white);
		registers[array[1]].setBackground(Color.white);
		registers[array[2]].setBackground(Color.white);
	}
	
	private void treatMovOp(String[] ins) throws Exception {
		
		int[] array = new int[2];
		
		String[] values = ins[1].split(",");
		if (values.length != 2) {
			throw new Exception();
		}
		
		values[0] = values[0].replace("$", "");
		values[1] = values[1].replace("$", "");
		
		try {
			array[0] = Integer.parseInt(values[0]);
			array[1] = Integer.parseInt(values[1]);
		} catch (Exception e) {
			throw new Exception();
		}
		
		if (array[0] == array[1]) {
			throw new Exception();
		}
		
		registers[array[0]].setText(registers[array[1]].getText());
		registers[array[0]].setBackground(Color.white);
		registers[array[1]].setBackground(Color.white);
	}
	
	private int[] treatWordOp(String[] ins) throws Exception {
		
		int[] array = new int[3];
		
		String[] values = ins[1].split(",");
		if (values.length != 2) {
			throw new Exception();
		}
		
		values[0] = values[0].replace("$", "");
		
		values[1] = values[1].replace("(", "");
		values[1] = values[1].replace(")", "");
		
		String[] subValues = values[1].split("\\$");
		
		try {
			array[0] = Integer.parseInt(values[0]);
			array[1] = Integer.parseInt(subValues[0]);
			array[2] = Integer.parseInt(subValues[1]);
		} catch (Exception e) {
			throw new Exception();
		}
		
		if (array[0] == array[2]) {
			throw new Exception();
		}
		
		return array;

	}
	
	private int[] treatMathOp(String[] ins) throws Exception {
		
		int[] array = new int[3];
		
		String[] values = ins[1].split(",");
		if (values.length != 3) {
			throw new Exception();
		}
		
		values[0] = values[0].replace("$", "");
		values[1] = values[1].replace("$", "");
		values[2] = values[2].replace("$", "");
		
		try {
			array[0] = Integer.parseInt(values[0]);
			array[1] = Integer.parseInt(values[1]);
			array[2] = Integer.parseInt(values[2]);
		} catch (Exception e) {
			throw new Exception();
		}
		
		if (array[1] == array[2]) {
			throw new Exception();
		}
		
		return array;
	}
	
}
