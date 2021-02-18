

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

class test11 implements ActionListener {
	JFrame frame = new JFrame("Calculator");
	JTextField text = new JTextField("");
	JButton button0 = new JButton("0");
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	JButton button4 = new JButton("4");
	JButton button5 = new JButton("5");
	JButton button6 = new JButton("6");
	JButton button7 = new JButton("7");
	JButton button8 = new JButton("8");
	JButton button9 = new JButton("9");
	JButton button10 = new JButton("+");
	JButton button11 = new JButton("-");
	JButton button12 = new JButton("*");
	JButton button13 = new JButton("/");
	JButton button14 = new JButton("c");
	JButton button15 = new JButton("=");

	test11() {
		frame.setSize(900, 500);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.add(button0);
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
		frame.add(button5);
		frame.add(button6);
		frame.add(button7);
		frame.add(button8);
		frame.add(button9);
		frame.add(button10);
		frame.add(button11);
		frame.add(button12);
		frame.add(button13);
		frame.add(button14);
		frame.add(button15);
		frame.add(text);
		text.setEditable(false);
		text.setHorizontalAlignment(JTextField.RIGHT);
		text.setBounds(200, 60, 430, 40);
		button0.setBounds(310, 290, 100, 50);
		button1.setBounds(200, 230, 100, 50);
		button2.setBounds(310, 230, 100, 50);
		button3.setBounds(420, 230, 100, 50);
		button4.setBounds(200, 170, 100, 50);
		button5.setBounds(310, 170, 100, 50);
		button6.setBounds(420, 170, 100, 50);
		button7.setBounds(200, 110, 100, 50);
		button8.setBounds(310, 110, 100, 50);
		button9.setBounds(420, 110, 100, 50);
		button10.setBounds(530, 110, 100, 50);
		button11.setBounds(530, 170, 100, 50);
		button12.setBounds(530, 230, 100, 50);
		button13.setBounds(530, 290, 100, 50);
		button14.setBounds(200, 290, 100, 50);
		button15.setBounds(420, 290, 100, 50);
		button0.addActionListener(this);
		button0.setActionCommand("b0");
		button1.addActionListener(this);
		button1.setActionCommand("b1");
		button2.addActionListener(this);
		button2.setActionCommand("b2");
		button3.addActionListener(this);
		button3.setActionCommand("b3");
		button4.addActionListener(this);
		button4.setActionCommand("b4");
		button5.addActionListener(this);
		button5.setActionCommand("b5");
		button6.addActionListener(this);
		button6.setActionCommand("b6");
		button7.addActionListener(this);
		button7.setActionCommand("b7");
		button8.addActionListener(this);
		button8.setActionCommand("b8");
		button9.addActionListener(this);
		button9.setActionCommand("b9");
		button10.addActionListener(this);
		button10.setActionCommand("b10");
		button11.addActionListener(this);
		button11.setActionCommand("b11");
		button12.addActionListener(this);
		button12.setActionCommand("b12");
		button13.addActionListener(this);
		button13.setActionCommand("b13");
		button14.addActionListener(this);
		button14.setActionCommand("b14");
		button15.addActionListener(this);
		button15.setActionCommand("b15");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s == "b0") {
			String n = text.getText() + "0";
			text.setText(n);
		} else if (s == "b1") {
			String n = text.getText() + "1";
			text.setText(n);
		} else if (s == "b2") {
			String n = text.getText() + "2";
			text.setText(n);
		} else if (s == "b3") {
			String n = text.getText() + "3";
			text.setText(n);
		} else if (s == "b4") {
			String n = text.getText() + "4";
			text.setText(n);
		} else if (s == "b5") {
			String n = text.getText() + "5";
			text.setText(n);
		} else if (s == "b6") {
			String n = text.getText() + "6";
			text.setText(n);
		} else if (s == "b7") {
			String n = text.getText() + "7";
			text.setText(n);
		} else if (s == "b8") {
			String n = text.getText() + "8";
			text.setText(n);
		} else if (s == "b9") {
			String n = text.getText() + "9";
			text.setText(n);
		} else if (s == "b10") {
			String n = text.getText() + "+";
			text.setText(n);
		} else if (s == "b11") {
			String n = text.getText() + "-";
			text.setText(n);
		} else if (s == "b12") {
			String n = text.getText() + "*";
			text.setText(n);
		} else if (s == "b13") {
			String n = text.getText() + "/";
			text.setText(n);
		} else if (s == "b14") {
			text.setText("");
		} else if (s == "b15") {
			text.setText(calculation(text.getText()));
		}
	}

	String calculation(String s) {
		char[] c = s.toCharArray();
		String o1 = "";
		String o2 = "";
		String o3 = "";
		for (int i = 0; i < c.length; i++) {
			if (c[i] >= 0 && c[i] <= 9) {
				if (o3 == "") {
					o1 = o1 + c[i];
				} else {
					o2 = o2 + c[i];
				}
			} else if (c[i] == '+' || c[i] == '-' || c[i] == '*' || c[i] == '/') {
				o3 = o3 + c[i];
			}
		}
		if (o3 == "+") {
			double r = Double.parseDouble(o1) + Double.parseDouble(o2);
			String r1 = String.valueOf(r);
			return o1 + o2 + o3 + "=" + r1;
		} else if (o3 == "-") {
			double r = Double.parseDouble(o1) - Double.parseDouble(o2);
			String r1 = String.valueOf(r);
			return o1 + o2 + o3 + "=" + r1;
		} else if (o3 == "*") {
			double r = Double.parseDouble(o1) * Double.parseDouble(o2);
			String r1 = String.valueOf(r);
			return o1 + o2 + o3 + "=" + r1;
		} else {
			double r = Double.parseDouble(o1) / Double.parseDouble(o2);
			String r1 = String.valueOf(r);
			return o1 + o2 + o3 + "=" + r1;
		}
	}

	public static void main(String[] args) {
		test11 w = new test11();
	}
}
