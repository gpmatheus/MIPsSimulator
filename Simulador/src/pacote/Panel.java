package pacote;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Panel extends JPanel {
	
	private InstructionController inController;
	private int referenceX = 625;
	private int referenceY = 70;
	private int[] x = {referenceX, referenceX, referenceX + 200, referenceX + 200, referenceX, referenceX, referenceX + 50};
	private int[] y = {referenceY + 75, referenceY, referenceY + 75, referenceY + 125, referenceY + 200, referenceY + 125, referenceY + 100};
	private int referenceX1 = 255;
	private int referenceY1 = 180;
	private int referenceX2 = 575;
	private int referenceY2 = 200;
	private int referenceX3 = 1100;
	private int referenceY3 = 130;
	
	private String op;
	
	public Panel(InstructionController inController) {
		this.inController = inController;
	}
	
	public void drawInstructionRec(Graphics2D g2d) {
		
		g2d.drawRect(25, 100, 150, 200);
		g2d.drawString("Instruction", 110, 275);
	}
	
	public void drawRegBankRec(Graphics2D g2d) {
		
		g2d.drawRect(300, 60, 200, 250);
		g2d.drawString("Register 1", 310, 110);
		g2d.drawString("Register 2", 310, 160);
		g2d.drawString("Write register", 310, 210);
		g2d.drawString("Write data", 310, 260);
		g2d.drawString("Read Register 1", 405, 110);
		g2d.drawString("Read Register 2", 405, 220);
	}
	
	public void drawUla(Graphics g2d) {
		
		g2d.drawPolygon(x, y, 7);
		g2d.drawString("Result", 780, 170);
	}
	
	public void drawMemController(Graphics2D g2d) {
		
		g2d.drawRect(900, 110, 175, 250);
		g2d.drawString("Address", 910, 170);
		g2d.drawString("Write data", 910, 310);
		g2d.drawString("Read data", 1010, 140);
	}
	
	public void drawOvalSign(Graphics2D g2d) {
		
		g2d.drawOval(350, 360, 70, 100);
		g2d.drawString("Sign", 375, 410);
	}
	
	public void drawAluSign(Graphics2D g2d) {
		
		g2d.drawOval(625, 360, 70, 100);
		g2d.drawString("ALU", 650, 410);
		if (op != null) {
			if (op.equals("add")) {
				g2d.drawString("+", 650, 470);
			}
			if (op.equals("sub")) {
				g2d.drawString("-", 650, 470);
			}
		}
		g2d.drawString("ALUOp", 675, 470);
	}
	
	public void drawControllers(Graphics2D g2d) {
		
		g2d.drawArc(referenceX1, referenceY1, 20, 20, 0, 180);
		g2d.drawArc(referenceX1, referenceY1 + 40, 20, 20, 180, 180);
		g2d.drawLine(referenceX1, referenceY1 + 10, referenceX1, referenceY1 + 40 + 10);
		g2d.drawLine(referenceX1 + 20, referenceY1 + 10, referenceX1 + 20, referenceY1 + 40 + 10);
		
		g2d.drawArc(referenceX2, referenceY2, 20, 20, 0, 180);
		g2d.drawArc(referenceX2, referenceY2 + 40, 20, 20, 180, 180);
		g2d.drawLine(referenceX2, referenceY2 + 10, referenceX2, referenceY2 + 40 + 10);
		g2d.drawLine(referenceX2 + 20, referenceY2 + 10, referenceX2 + 20, referenceY2 + 40 + 10);
		
		g2d.drawArc(referenceX3, referenceY3, 20, 20, 0, 180);
		g2d.drawArc(referenceX3, referenceY3 + 40, 20, 20, 180, 180);
		g2d.drawLine(referenceX3, referenceY3 + 10, referenceX3, referenceY3 + 40 + 10);
		g2d.drawLine(referenceX3 + 20, referenceY3 + 10, referenceX3 + 20, referenceY3 + 40 + 10);
	}
	
	public void drawSigns(Graphics2D g2d) {
		
		g2d.drawLine(400, 60, 400, 30);
		if (op != null && !op.equals("sw")) {
			g2d.setPaint(Color.green);
		}
		g2d.fillOval(395, 20, 10, 10);
		g2d.setPaint(Color.black);
		g2d.drawString("regWrite", 395, 10);
		
		g2d.drawLine(1000, 110, 1000, 80);
		if (op != null && op.equals("sw")) {
			g2d.setPaint(Color.green);
		}
		g2d.fillOval(995, 70, 10, 10);
		g2d.setPaint(Color.black);
		g2d.drawString("memWrite", 995, 60); 
		
		
		g2d.drawLine(1000, 360, 1000, 390);
		g2d.drawLine(referenceX3 + 10, referenceY3 + 20 + 40, referenceX3 + 10, referenceY3 + 20 + 40 + 30);
		if (op != null && op.equals("lw")) {
			g2d.setPaint(Color.green);
		}
		g2d.fillOval(referenceX3 + 5, referenceY3 + 20 + 40 + 30, 10, 10);
		g2d.fillOval(995, 390, 10, 10);
		
		g2d.setPaint(Color.black);
		g2d.drawString("memToReg", referenceX3, referenceY3 + 120);
		g2d.drawString("memRead", 995, 415);
		
		g2d.drawLine(referenceX1 + 10, referenceY1 + 20 + 40, referenceX1 + 10, referenceY1 + 20 + 40 + 30);
		if (op != null && (op.equals("add") || op.equals("sub"))) {
			g2d.setPaint(Color.green);
		}
		g2d.fillOval(referenceX1 + 5, referenceY1 + 20 + 40 + 30, 10, 10);
		g2d.setPaint(Color.black);
		g2d.drawString("regDst", referenceX1 - 20, referenceY1 + 120);
		
		
		g2d.drawLine(referenceX2 + 10, referenceY2 + 20 + 40, referenceX2 + 10, referenceY2 + 20 + 40 + 30);
		if (op != null && (op.equals("li") || op.equals("lw") || op.equals("sw"))) {
			g2d.setPaint(Color.green);
		}
		g2d.fillOval(referenceX2 + 5, referenceY2 + 20 + 40 + 30, 10, 10);
		g2d.setPaint(Color.black);
		g2d.drawString("aluSrc", referenceX2 - 20, referenceY2 + 120);
		
	}

	public void paint(Graphics g) {
		
		op = inController.getOp();
		
		Graphics2D g2d = (Graphics2D) g;
		
		drawInstructionRec(g2d);
		
		drawRegBankRec(g2d);
		
		drawUla(g2d);
		
		drawMemController(g2d);
		
		drawOvalSign(g2d);
		
		drawAluSign(g2d);
		
		drawControllers(g2d);
		
		drawSigns(g2d);
		
		//lines begin here
		
		if (op != null && (op.equalsIgnoreCase("li") || op.equalsIgnoreCase("lw") || op.equalsIgnoreCase("sw") 
				|| op.equalsIgnoreCase("add") || op.equalsIgnoreCase("sub") || op.equalsIgnoreCase("mov"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(175, 160, 200, 160);
		g2d.setPaint(Color.black);
		
		if (op != null && (op.equalsIgnoreCase("li") || op.equalsIgnoreCase("lw") || op.equalsIgnoreCase("sw") || op.equalsIgnoreCase("mov"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(200, 160, 225, 160);
		g2d.setPaint(Color.black);
		
		if (op != null && op.equalsIgnoreCase("sw")) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(225, 160, 300, 160);
		g2d.setPaint(Color.black);
		
		
		if (op != null && (op.equalsIgnoreCase("lw") || op.equalsIgnoreCase("li") || op.equalsIgnoreCase("mov"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(225, 160, 225, 195);
		g2d.drawLine(225, 195, referenceX1, 195);
		g2d.setPaint(Color.black);
		
		
		if (op != null && !op.equalsIgnoreCase("li")) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(200, 160, 200, 110);
		g2d.drawLine(200, 110, 300, 110);
		g2d.setPaint(Color.black);
		
		
		if (op != null && !op.equalsIgnoreCase("mov")) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(200, 160, 200, 225);
		g2d.setPaint(Color.black);
		
		
		if (op != null && (op.equalsIgnoreCase("add") || op.equalsIgnoreCase("sub"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(200,  225, referenceX1, 225);
		g2d.setPaint(Color.black);
		
		if (op != null && !op.equalsIgnoreCase("sw")) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(referenceX1 + 20, 210, 300, 210);
		g2d.setPaint(Color.black);
		
		if (op != null && (op.equalsIgnoreCase("sw") || op.equalsIgnoreCase("lw") || op.equalsIgnoreCase("li"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(200, 220, 200, 410);
		g2d.drawLine(200, 410, 350, 410);
		g2d.drawLine(420, 410, 550, 410);
		g2d.drawLine(550, 410, 550, 245);
		g2d.drawLine(550, 245, referenceX2, 245);
		g2d.setPaint(Color.black);
		
		if (op != null && (op.equalsIgnoreCase("sw") ||op.equalsIgnoreCase("add") || op.equalsIgnoreCase("sub"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(500, 220, 530, 220);
		g2d.setPaint(Color.black);
		
		if (op != null && !op.equalsIgnoreCase("mov")) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(referenceX2 + 20, 230, referenceX, 230);
		g2d.setPaint(Color.black);
		
		if (op != null && (!op.equalsIgnoreCase("li") && !op.equalsIgnoreCase("sw"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(500, 110, referenceX, 110);
		g2d.setPaint(Color.black);
		
		if (op != null) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(referenceX + 200, 170, referenceX + 230, 170);
		g2d.setPaint(Color.black);
		
		if (op != null && (op.equalsIgnoreCase("sw") || op.equalsIgnoreCase("lw"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(referenceX + 230, 170, 900, 170);
		g2d.setPaint(Color.black);
		
		if (op != null && (op.equalsIgnoreCase("add") || op.equalsIgnoreCase("sub"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(530, 220, referenceX2, 220);
		g2d.setPaint(Color.black);
		
		if (op != null && op.equalsIgnoreCase("sw")) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(530, 220, 530, 310);
		g2d.drawLine(530, 310, 900, 310);
		g2d.setPaint(Color.black);
		
		if (op != null && op.equalsIgnoreCase("lw")) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(1075, 140, referenceX3, 140);
		g2d.setPaint(Color.black);
		
		if (op != null && (!op.equalsIgnoreCase("lw") && !op.equalsIgnoreCase("sw"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(referenceX + 230, 170, referenceX + 230, 380);
		g2d.drawLine(referenceX + 230, 380, 1090, 380);
		g2d.drawLine(1090, 380, 1090, 180);
		g2d.drawLine(1090, 180, referenceX3, 180);
		g2d.setPaint(Color.black);
		
		if (op != null && !op.equalsIgnoreCase("sw")) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(referenceX3 + 20, 160, referenceX3 + 20 + 20, 160);
		g2d.drawLine(referenceX3 + 40, 160, referenceX3 + 40, 490);
		g2d.drawLine(referenceX3 + 40, 490, 280, 490);
		g2d.drawLine(280, 490, 280, 260);
		g2d.drawLine(280, 260, 300, 260);
		g2d.setPaint(Color.black);
		
		if (op != null && (op.equalsIgnoreCase("add") || op.equalsIgnoreCase("sub"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(695, 410, 720, 410);
		g2d.drawLine(720, 410, 720, 235);
		g2d.setPaint(Color.black);
		
	}
	
}
