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
		
		int index;
		
		int lineLength = assemblys.size();
		
		int deslocamento;
		
		for (int i = 0; i < lineLength && i < instructions.length; i++) {
			
			strings[i].setText(assemblys.get(i).getAssembly());
			
			index = 3;
			
			if (assemblys.get(i).getOp().equals("lw")) {
				if (assemblys.size() - 1 > i) {
					
					for (int n = 1; n <= 3 && n < assemblys.size(); n++) {
						if (assemblys.get(i + n).getOp().equals("add") || assemblys.get(i + n).getOp().equals("sub")) {
							if (assemblys.get(i).getValue1() == assemblys.get(i + n).getValue2() || assemblys.get(i).getValue1() == assemblys.get(i + n).getValue3()) {
								index -= n;
								assemblys.get(i + n).setBublle(true, index);
							}
						} else if (assemblys.get(i + n).getOp().equals("lw") || assemblys.get(i + n).getOp().equals("sw")) {
							if (assemblys.get(i).getValue1() == assemblys.get(i + n).getValue3()) {
								index -= n;
								assemblys.get(i + n).setBublle(true, index);
							}
						} else if (assemblys.get(i + n).getOp().equals("mov")){
							if (assemblys.get(i).getValue1() == assemblys.get(i + n).getValue2()) {
								index -= n;
								assemblys.get(i + n).setBublle(true, index);
							}
						}
					}
				}
			}
			
			deslocamento = 0;
			
			for (int j = 0; j < instructions[i].length && j < signs.length; j++) {
				
				if(assemblys.get(i).hasABubble() && assemblys.get(i).getIndex() == j){
					deslocamento++;
					
					index = assemblys.get(i).getIndex() - 1;
					for (int n = i + 1; n < assemblys.size() && index >= 0; n++) {
						assemblys.get(n).setBublle(true, index);
						index--;
					}
				} else if (i > 0 && assemblys.get(i - 1).hasABubble() && assemblys.get(i - 1).getIndex() == 0) {
					
					assemblys.get(i).setBublle(true, 0);
				} else {
					instructions[i][j].setText(signs[j - deslocamento]);
					instructions[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
				}
			}
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
