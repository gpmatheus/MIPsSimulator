
package pacote;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JLabel;

public class InstructionController {
	
	private List<AssemblyOp> assemblys = new ArrayList<>();
	private AssemblyOp currentAssembly = null;
	private MemoryRegisterController memCon;
	private PipeLineController pipeController;
	
	private String op;
	
	public InstructionController(JLabel[] registers, JLabel[] memory, JLabel[][] instructions, JLabel[] strings) {
		memCon = new MemoryRegisterController(registers, memory);
		pipeController = new PipeLineController(assemblys, instructions, strings);
	}
	
	public String getAssemblyOp() {
		if (currentAssembly == null) {
			return null;
		}
		
		return currentAssembly.getOp();
	}
	
	public void clearAssemblys() {
		assemblys.clear();
		pipeController.execute();
	}
	
	public void execute() {
		
		try {
			if (!assemblys.isEmpty()) {
				currentAssembly = assemblys.get(0);
				memCon.executeAssembly(assemblys.remove(0));
				pipeController.execute();
			}
		} catch (Exception e) {
			System.out.println("Deu erro");
		}
	}
	
	public void compile(String assembly) throws Exception {
		
		String[] ins = assembly.split("\\s+");
		
		if (ins.length != 2) {
			throw new Exception();
		}
		
		op = ins[0];
		
		switch (op) {
			case "li":
				treatLi(ins, assembly);
				break;
			case "lw":
			case "sw":
				treatWordOp(ins, assembly);
				break;
			case "add":
			case "sub":
				treatMathOp(ins, assembly);
				break;
			case "mov":
				treatMovOp(ins, assembly);
				break;
			default:
				throw new Exception();
		}
		
		pipeController.execute();
		
	}
	
	private void treatLi(String[] ins, String assembly) throws Exception {
		
		int[] array = new int[2];
		
		String[] values = ins[1].split(",");
		if (values.length != 2) {
			throw new Exception();
		}
		
		values[0] = values[0].replace("$", "");
		
		array[0] = Integer.parseInt(values[0]);
		array[1] = Integer.parseInt(values[1]);
		
		AssemblyOp assemblyOp = new AssemblyOp();
		
		assemblyOp.setOp(op);
		assemblyOp.setValue1(array[0]);
		assemblyOp.setValue2(array[1]);
		assemblyOp.setAssembly(assembly);
		
		assemblys.add(assemblyOp);
	}
	
	private void treatMovOp(String[] ins, String assembly) throws Exception {
		
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
		
		AssemblyOp assemblyOp = new AssemblyOp();
		
		assemblyOp.setOp(op);
		assemblyOp.setValue1(array[0]);
		assemblyOp.setValue2(array[1]);
		assemblyOp.setAssembly(assembly);
		
		assemblys.add(assemblyOp);
	}
	
	private void treatWordOp(String[] ins, String assembly) throws Exception {
		
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
		
		AssemblyOp assemblyOp = new AssemblyOp();
		
		assemblyOp.setOp(op);
		assemblyOp.setValue1(array[0]);
		assemblyOp.setValue2(array[1]);
		assemblyOp.setValue3(array[2]);
		assemblyOp.setAssembly(assembly);
		
		assemblys.add(assemblyOp);
	}
	
	private void treatMathOp(String[] ins, String assembly) throws Exception {
		
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
		
		AssemblyOp assemblyOp = new AssemblyOp();
		
		assemblyOp.setOp(op);
		assemblyOp.setValue1(array[0]);
		assemblyOp.setValue2(array[1]);
		assemblyOp.setValue3(array[2]);
		assemblyOp.setAssembly(assembly);
		
		assemblys.add(assemblyOp);
	}
	
}
