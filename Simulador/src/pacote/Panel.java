package pacote;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Panel extends JPanel {
	
	private InstructionController inController;
	private int n = 7;
	private int referenceX = 625;
	private int referenceY = 160;
	private int[] x = {referenceX, referenceX, referenceX + 200, referenceX + 200, referenceX, referenceX, referenceX + 50};
	private int[] y = {referenceY + 75, referenceY, referenceY + 75, referenceY + 125, referenceY + 200, referenceY + 125, referenceY + 100};
	private int referenceX1 = 255;
	private int referenceY1 = 270;
	private int referenceX2 = 575;
	private int referenceY2 = 290;
	private int referenceX3 = 1100;
	private int referenceY3 = 220;
	
	private String op;
	
	public Panel(InstructionController inController) {
		this.inController = inController;
	}

	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawRect(25, 175, 150, 200);
		g2d.drawString("Instruction", 110, 275);
		
		g2d.drawRect(300, 150, 200, 250);
		g2d.drawString("Register 1", 310, 200);
		g2d.drawString("Register 2", 310, 250);
		g2d.drawString("Write register", 310, 300);
		g2d.drawString("Write data", 310, 350);
		g2d.drawString("Read Register 1", 405, 200);
		g2d.drawString("Read Register 2", 405, 310);
		g2d.drawLine(400, 150, 400, 120);
		
		
		if (inController.getRegWrite()) {
			g2d.setPaint(Color.green);
		}
		g2d.fillOval(395, 110, 10, 10);
		g2d.setPaint(Color.black);
		g2d.drawString("regWrite", 395, 100);
		
		g2d.drawPolygon(x, y, n);
		g2d.drawString("Result", 780, 260);
		
		g2d.drawRect(900, 200, 175, 250);
		g2d.drawString("Address", 910, 260);
		g2d.drawString("Write data", 910, 400);
		g2d.drawString("Read data", 1010, 230);
		g2d.drawLine(1000, 200, 1000, 170);
		
		if (inController.getMemWrite()) {
			g2d.setPaint(Color.green);
		}
		g2d.fillOval(995, 160, 10, 10);
		g2d.setPaint(Color.black);
		g2d.drawString("memWrite", 995, 150);
		
		g2d.drawLine(1000, 450, 1000, 480);
		
		if (inController.getMemRead()) {
			g2d.setPaint(Color.green);
		}
		g2d.fillOval(995, 480, 10, 10);
		g2d.setPaint(Color.black);
		g2d.drawString("memRead", 995, 505);
		
		g2d.drawOval(350, 450, 70, 100);
		g2d.drawString("Sign", 375, 500);
		
		g2d.drawOval(625, 450, 70, 100);
		g2d.drawString("ALU", 650, 500);
		
		if (inController.getAluOp() != null) {
			g2d.drawString(inController.getAluOp(), 650, 560);
		}
		g2d.drawString("ALUOp", 675, 560);
		
		g2d.drawArc(referenceX1, referenceY1, 20, 20, 0, 180);
		g2d.drawArc(referenceX1, referenceY1 + 40, 20, 20, 180, 180);
		g2d.drawLine(referenceX1, referenceY1 + 10, referenceX1, referenceY1 + 40 + 10);
		g2d.drawLine(referenceX1 + 20, referenceY1 + 10, referenceX1 + 20, referenceY1 + 40 + 10);
		g2d.drawLine(referenceX1 + 10, referenceY1 + 20 + 40, referenceX1 + 10, referenceY1 + 20 + 40 + 30);
		
		if (inController.getRegDst()) {
			g2d.setPaint(Color.green);
		}
		g2d.fillOval(referenceX1 + 5, referenceY1 + 20 + 40 + 30, 10, 10);
		g2d.setPaint(Color.black);
		g2d.drawString("regDst", referenceX1 - 20, referenceY1 + 120);
		
		g2d.drawArc(referenceX2, referenceY2, 20, 20, 0, 180);
		g2d.drawArc(referenceX2, referenceY2 + 40, 20, 20, 180, 180);
		g2d.drawLine(referenceX2, referenceY2 + 10, referenceX2, referenceY2 + 40 + 10);
		g2d.drawLine(referenceX2 + 20, referenceY2 + 10, referenceX2 + 20, referenceY2 + 40 + 10);
		g2d.drawLine(referenceX2 + 10, referenceY2 + 20 + 40, referenceX2 + 10, referenceY2 + 20 + 40 + 30);
		
		if (inController.getAluSrc()) {
			g2d.setPaint(Color.green);
		}
		g2d.fillOval(referenceX2 + 5, referenceY2 + 20 + 40 + 30, 10, 10);
		g2d.setPaint(Color.black);
		g2d.drawString("aluSrc", referenceX2 - 20, referenceY2 + 120);
		
		g2d.drawArc(referenceX3, referenceY3, 20, 20, 0, 180);
		g2d.drawArc(referenceX3, referenceY3 + 40, 20, 20, 180, 180);
		g2d.drawLine(referenceX3, referenceY3 + 10, referenceX3, referenceY3 + 40 + 10);
		g2d.drawLine(referenceX3 + 20, referenceY3 + 10, referenceX3 + 20, referenceY3 + 40 + 10);
		g2d.drawLine(referenceX3 + 10, referenceY3 + 20 + 40, referenceX3 + 10, referenceY3 + 20 + 40 + 30);
		
		if (inController.getMemToReg()) {
			g2d.setPaint(Color.green);
		}
		g2d.fillOval(referenceX3 + 5, referenceY3 + 20 + 40 + 30, 10, 10);
		g2d.setPaint(Color.black);
		g2d.drawString("memToReg", referenceX3, referenceY3 + 120);
		//lines begin here
		
		
		op = inController.getOp();
		
		if (op != null && (op.equalsIgnoreCase("li") || op.equalsIgnoreCase("lw") || op.equalsIgnoreCase("sw") 
				|| op.equalsIgnoreCase("add") || op.equalsIgnoreCase("sub") || op.equalsIgnoreCase("mov"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(175, 250, 200, 250); //------------
		g2d.setPaint(Color.black);
		
		if (op != null && (op.equalsIgnoreCase("li") || op.equalsIgnoreCase("lw") || op.equalsIgnoreCase("sw") || op.equalsIgnoreCase("mov"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(200, 250, 225, 250); //-----------
		g2d.setPaint(Color.black);
		
		if (op != null && op.equalsIgnoreCase("sw")) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(225, 250, 300, 250); //-------------
		g2d.setPaint(Color.black);
		
		
		if (op != null && (op.equalsIgnoreCase("lw") || op.equalsIgnoreCase("li") || op.equalsIgnoreCase("mov"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(225, 250, 225, 285); //-------------
		g2d.drawLine(225, 285, referenceX1, 285); //----------------
		g2d.setPaint(Color.black);
		
		
		if (op != null && !op.equalsIgnoreCase("li")) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(200, 250, 200, 200); //----------
		g2d.drawLine(200, 200, 300, 200); //------------
		g2d.setPaint(Color.black);
		
		
		if (op != null && !op.equalsIgnoreCase("mov")) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(200, 250, 200, 315); //---------------
		g2d.setPaint(Color.black);
		
		
		if (op != null && (op.equalsIgnoreCase("add") || op.equalsIgnoreCase("sub"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(200,  315, referenceX1, 315); //-----------------
		g2d.setPaint(Color.black);
		
		if (op != null && !op.equalsIgnoreCase("sw")) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(referenceX1 + 20, 300, 300, 300); // ---------------
		g2d.setPaint(Color.black);
		
		if (op != null && (op.equalsIgnoreCase("sw") || op.equalsIgnoreCase("lw") || op.equalsIgnoreCase("li"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(200, 315, 200, 500); // --------------
		g2d.drawLine(200, 500, 350, 500); // --------------
		g2d.drawLine(420, 500, 550, 500); // ---------------
		g2d.drawLine(550, 500, 550, 335); // --------------
		g2d.drawLine(550, 335, referenceX2, 335); // ----------------
		g2d.setPaint(Color.black);
		
		if (op != null && (op.equalsIgnoreCase("sw") ||op.equalsIgnoreCase("add") || op.equalsIgnoreCase("sub"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(500, 310, 530, 310); // -----------------
		g2d.setPaint(Color.black);
		
		if (op != null && !op.equalsIgnoreCase("mov")) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(referenceX2 + 20, 320, referenceX, 320); // ------------------
		g2d.setPaint(Color.black);
		
		if (op != null && (!op.equalsIgnoreCase("li") && !op.equalsIgnoreCase("sw"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(500, 200, referenceX, 200); // -----------------
		g2d.setPaint(Color.black);
		
		if (op != null) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(referenceX + 200, 260, referenceX + 230, 260); // ---------------
		g2d.setPaint(Color.black);
		
		if (op != null && (op.equalsIgnoreCase("sw") || op.equalsIgnoreCase("lw"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(referenceX + 230, 260, 900, 260); // ----------------
		g2d.setPaint(Color.black);
		
		if (op != null && (op.equalsIgnoreCase("add") || op.equalsIgnoreCase("sub"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(530, 310, referenceX2, 310); // ----------------------
		g2d.setPaint(Color.black);
		
		if (op != null && op.equalsIgnoreCase("sw")) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(530, 310, 530, 400); // --------------
		g2d.drawLine(530, 400, 900, 400); // ---------------
		g2d.setPaint(Color.black);
		
		if (op != null && op.equalsIgnoreCase("lw")) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(1075, 230, referenceX3, 230); // ----------------
		g2d.setPaint(Color.black);
		
		if (op != null && (!op.equalsIgnoreCase("lw") && !op.equalsIgnoreCase("sw"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(referenceX + 230, 260, referenceX + 230, 470); // ----------------
		g2d.drawLine(referenceX + 230, 470, 1090, 470); // ------------------
		g2d.drawLine(1090, 470, 1090, 270); // ------------------
		g2d.drawLine(1090, 270, referenceX3, 270); // -----------------
		g2d.setPaint(Color.black);
		
		if (op != null && !op.equalsIgnoreCase("sw")) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(referenceX3 + 20, 250, referenceX3 + 20 + 20, 250); // -------------------
		g2d.drawLine(referenceX3 + 40, 250, referenceX3 + 40, 580); // -----------------
		g2d.drawLine(referenceX3 + 40, 580, 280, 580); // --------------------
		g2d.drawLine(280, 580, 280, 350); // -----------------------
		g2d.drawLine(280, 350, 300, 350); // ------------------------
		g2d.setPaint(Color.black);
		
		if (op != null && (op.equalsIgnoreCase("add") || op.equalsIgnoreCase("sub"))) {
			g2d.setPaint(Color.red);
		}
		g2d.drawLine(695, 500, 720, 500); // ------------------
		g2d.drawLine(720, 500, 720, 325); // ------------------
		g2d.setPaint(Color.black);
		
		
	}
}
