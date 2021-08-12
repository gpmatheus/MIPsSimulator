package pacote;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame extends JFrame{

	private InstructionController inController;
	private Panel pan;
	private JLabel[] registers = new JLabel[8];
	private JLabel[] memory = new JLabel[40];
	private JTextField tField;
	
	public Frame() {
		
		this.setTitle("Simulador Mips");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout(3, 3));
		
		addTopPanel();
		addMemoryPanel();
		addCentralPanel();
		
		this.setVisible(true);
	}
	
	private void addTopPanel() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		panel.setPreferredSize(new Dimension(100, 50));
		panel.setBackground(new Color(100, 100, 100));
		this.add(panel, BorderLayout.NORTH);
		
		addText(panel);
		addAddButton(panel);
		addRunButton(panel);
	}
	
	private void addText(JPanel p) {
		
		tField = new JTextField();
		tField.setPreferredSize(new Dimension(300, 25));
		p.add(tField);
	}
	
	private void addAddButton(JPanel panel) {
		
		JButton button = new JButton();
		button.setText("Adicionar");
		button.setPreferredSize(new Dimension(100, 25));
		button.addActionListener(e -> addAssembly());
		
		panel.add(button);
	}
	
	private void addRunButton(JPanel panel) {
		
		JButton button = new JButton();
		button.setText("Executar");
		button.setPreferredSize(new Dimension(100, 25));
		button.addActionListener(e -> executeCode());
		
		panel.add(button);
	}
	
	private void addAssembly() {
		inController.addAssembly(tField.getText());
	}
	
	private void executeCode() {
		
		try {
			inController.compile();
			repaint();
		} catch (Exception e) {
			System.out.println("Deu erro");
		}
	}
	
	private void addMemoryPanel() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(new Dimension(150, 100));
		panel.setBackground(new Color(100, 100, 100));
		addMemory(panel);
		
		this.add(panel, BorderLayout.EAST);
	}
	
	private void addMemory(JPanel panel) {
		
		Random random = new Random();
		
		for (int i = 0; i < memory.length; i++) {
			memory[i] = new JLabel();
			memory[i].setPreferredSize(new Dimension(70, 25));
			memory[i].setBackground(new Color(0, 0, 0));
			memory[i].setOpaque(true);
			memory[i].setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
			memory[i].setForeground(new Color(0, 255, 0));
			memory[i].setHorizontalAlignment(JLabel.CENTER);
			
			if (random.nextInt(2) < 1) {
				memory[i].setText(random.nextInt(100) + "");
			} else {
				memory[i].setText("null");
			}
			panel.add(memory[i]);
		}
	}
	
	private void addCentralPanel() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.CENTER);
		addRegisterPanel(panel);
		addDrawing(panel);
		addPipeLine(panel);
	}
	
	private void addPipeLine(JPanel p) {
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.setPreferredSize(new Dimension(300, 300));
		panel.setBackground(new Color(100, 100, 100));
		
		JPanel panelForDraw = new JPanel();
		panelForDraw.setPreferredSize(new Dimension(600, 280));
		panel.add(panelForDraw);
		
		p.add(panel, BorderLayout.SOUTH);
	}
	
	private void addDrawing(JPanel p) {
		
		inController = new InstructionController(registers, memory);
		pan = new Panel(inController);
		
		p.add(pan, BorderLayout.CENTER);
	}
	
	private void addRegisterPanel(JPanel p) {
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(50, 50));
		panel.setBackground(new Color(100, 100, 255));
		addRegisters(panel);
		
		p.add(panel, BorderLayout.NORTH);
	}
	
	private void addRegisters(JPanel panel) {
		
		for (int i = 0; i < registers.length; i++) {
			
			registers[i] = new JLabel();
			registers[i].setPreferredSize(new Dimension(80, 25));
			registers[i].setBackground(new Color(0, 0, 0));
			registers[i].setOpaque(true);
			registers[i].setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
			registers[i].setForeground(new Color(0, 255, 0));
			registers[i].setHorizontalAlignment(JLabel.CENTER);
			registers[i].setText("null");
			panel.add(registers[i]);
		}
	}
}
