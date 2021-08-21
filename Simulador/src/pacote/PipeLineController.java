package pacote;

import java.awt.Color;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class PipeLineController {

	private JLabel[][] instructions;
	private JLabel[] strings;
	private List<AssemblyOp> assemblys;
	private String[] signs = {"IF", "RF", "EX", "MEM", "WB"};
	
	public PipeLineController(List<AssemblyOp> assemblys, JLabel[][] instructions, JLabel[] strings) {
		
		this.assemblys = assemblys;
		this.instructions = instructions;
		this.strings = strings;
	}
	
	public void execute() {
		
		setBlank();
		
		int lineLength = assemblys.size();
		
		for (int i = 0; i < lineLength && i < instructions.length; i++) {
			
			if (assemblys.get(i).getOp().equalsIgnoreCase("lw")) {
				
				checkForBubbles(i, lineLength);
			}
			
			int signsCounter = 0;
			
			if (i > 0 && !assemblys.get(i - 1).getBubbles().isEmpty() && assemblys.get(i - 1).getBubbles().contains(0)) {
				assemblys.get(i).addBubble(0);
			}
			
			for (int j = 0; j < instructions[i].length && signsCounter < signs.length; j++) {
				
				if (!assemblys.get(i).getBubbles().contains(j)) {
					instructions[i][j].setText(signs[signsCounter]);
					instructions[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
					signsCounter++;
				}
			}
			
			strings[i].setText(assemblys.get(i).getAssembly());
		}
	}
	
	public void checkForBubbles (int i, int lineLength) {
		
		int value = assemblys.get(i).getValue1();
		for (int j = i; j <= i + 1 && j < instructions.length && j < lineLength; j++) {
			
			AssemblyOp op = assemblys.get(j);
			
			if ((op.getOp().equalsIgnoreCase("add") || op.getOp().equalsIgnoreCase("sub")) && (op.getValue2() == value || op.getValue3() == value)) {
				
				setBubbles(i, j);
			}
		}
	}
	
	public void setBubbles(int sourceBubbleIndex, int opIndex) {
		
		int offSet = (5 - sourceBubbleIndex) - 3;
		for (int i = opIndex; i < assemblys.size() && offSet >= 0; i++, offSet--) {
			
			assemblys.get(i).addBubble(offSet);
		}
	}
	
	public void setBlank() {
		
		for (int i = 0; i < instructions.length; i++) {
			strings[i].setText(null);
			
			for (int j = 0; j < instructions[i].length; j++) {
				
				instructions[i][j].setText(null);
				instructions[i][j].setBorder(null);
			}
		}
	}
}
