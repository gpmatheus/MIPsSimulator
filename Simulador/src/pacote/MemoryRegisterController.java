package pacote;

import java.awt.Color;
import javax.swing.JLabel;

public class MemoryRegisterController {
	private JLabel[] registers;
	private JLabel[] memory;
	
	public MemoryRegisterController(JLabel[] registers, JLabel[] memory) {
		
		this.registers = registers;
		this.memory = memory;
	}
	
	public void executeAssembly(AssemblyOp assembly) throws Exception {
		
		for (int i = 0; i < registers.length; i++) {
			
			registers[i].setBackground(Color.black);
		}
		
		for (int j = 0; j < memory.length; j++) {
			
			memory[j].setBackground(Color.black);
		}
		
		if (assembly == null) {
			return;
		}
		
		switch (assembly.getOp()) {
			case "li":
				executeLi(assembly);
				break;
			case "lw":
				executeLw(assembly);
				break;
			case "sw":
				executeSw(assembly);
				break;
			case "add":
				executeAdd(assembly);
				break;
			case "sub":
				executeSub(assembly);
				break;
			case "mov":
				executeMov(assembly);
				break;
			default:
				return;
		}
	}
	
	private void executeLi(AssemblyOp assembly){
		
		registers[assembly.getValue1()].setText(assembly.getValue2() + "");
		registers[assembly.getValue1()].setBackground(Color.white);
	}
	
	private void executeLw(AssemblyOp assembly) throws Exception {
		
		String text = registers[assembly.getValue3()].getText();
		
		if (text.equalsIgnoreCase("null")) {
			throw new Exception();
		}
		
		int content = Integer.parseInt(text);
		
		int memoryIndex = content + assembly.getValue2();
		
		if (memoryIndex > 40 - 1) {
			throw new Exception();
		}
		
		registers[assembly.getValue1()].setText(memory[memoryIndex].getText());
		registers[assembly.getValue1()].setBackground(Color.white);
		memory[memoryIndex].setBackground(Color.white);
	}
	
	private void executeSw(AssemblyOp assembly) throws Exception {
		
		String text = registers[assembly.getValue1()].getText();
		
		if (text.equalsIgnoreCase("null")) {
			throw new Exception();
		}
		
		int content = Integer.parseInt(text);
		
		String indexText = registers[assembly.getValue3()].getText();
		
		if (indexText.equalsIgnoreCase("null")) {
			throw new Exception();
		}
		
		int index = Integer.parseInt(indexText) + assembly.getValue2();
		
		memory[index].setText(content + "");
		registers[assembly.getValue1()].setBackground(Color.white);
		memory[index].setBackground(Color.white);
	}
	
	private void executeAdd(AssemblyOp assembly) throws Exception {
		
		String text1 = registers[assembly.getValue2()].getText();
		String text2 = registers[assembly.getValue3()].getText();
		
		if (text1.equalsIgnoreCase("null") || text2.equalsIgnoreCase("null")) {
			throw new Exception();
		}
		
		int content1 = Integer.parseInt(text1);
		int content2 = Integer.parseInt(text2);
		
		int sum = content1 + content2;
		
		registers[assembly.getValue1()].setText(sum + "");
		registers[assembly.getValue1()].setBackground(Color.white);
		registers[assembly.getValue2()].setBackground(Color.white);
		registers[assembly.getValue3()].setBackground(Color.white);
	}
	
	private void executeSub(AssemblyOp assembly) throws Exception {
		
		String text1 = registers[assembly.getValue2()].getText();
		String text2 = registers[assembly.getValue3()].getText();
		
		if (text1.equalsIgnoreCase("null") || text2.equalsIgnoreCase("null")) {
			throw new Exception();
		}
		
		int content1 = Integer.parseInt(text1);
		int content2 = Integer.parseInt(text2);
		
		int sub = content1 - content2;
		
		registers[assembly.getValue1()].setText(sub + "");
		registers[assembly.getValue1()].setBackground(Color.white);
		registers[assembly.getValue2()].setBackground(Color.white);
		registers[assembly.getValue3()].setBackground(Color.white);
	}
	
	private void executeMov(AssemblyOp assembly) {
		
		registers[assembly.getValue1()].setText(registers[assembly.getValue2()].getText());
		registers[assembly.getValue1()].setBackground(Color.white);
		registers[assembly.getValue2()].setBackground(Color.white);
	}
}
