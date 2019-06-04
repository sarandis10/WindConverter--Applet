import java.applet.Applet;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
<applet code="WindConverter" width=800 height=600;>
</applet>
*/
public class WindConverter extends Applet {

	JLabel windSpeed, outLabel;
	JLabel from;
	JLabel to;
	JTextField textField;
	JButton button;
	String[] temps, temps2;
	JList list, list2;
	int tempIndex,tempIndex2;

	static double converter(int iput, String first, String second) {
		if (first.equals("m/s") && second.equals("km/h")) {
			return iput * 3.6;
		} else if (first.equals("m/s") && second.equals("Knots")) {
			return iput * 1.94;
		} else if (first.equals("km/h") && second.equals("Knots")) {
			return iput * 0.5399;
		} else if (first.equals("km/h") && second.equals("m/s")) {
			return iput / 3.6;
		} else if (first.equals("Knots") && second.equals("m/s")) {
			return iput / 1.9;
		} else {
			return iput * 1.852;
		} // else

	}// converter

	public void init() {
		windSpeed = new JLabel("Wind Speed: ");
		outLabel = new JLabel("");
		from = new JLabel("From");
		to = new JLabel("To");
		textField = new JTextField(5);
		button = new JButton("Convert");
		temps = new String[] { "m/s", "km/h", "Knots" };
		list = new JList(temps);
		temps2 = new String[] { "m/s", "km/h", "Knots" };
		list2 = new JList(temps);
		setLayout(new GridLayout(4, 2));

		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				tempIndex = list.getSelectedIndex();
			} // value changed
		}); // listener
		

		list2.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				tempIndex2 = list2.getSelectedIndex();
			} // value changed
		}); // listener

//////////////////////ACTION LISTENER//////////////////////////////////////////////////////////////////	
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int temp = (int) Double.parseDouble(textField.getText());
				String scale = temps[tempIndex];
				String bale=temps2[tempIndex2];
				outLabel.setText(Double.toString(converter(temp, scale,bale)));
			} // action performed
		}); // ActionListener
		
		
		
		add(windSpeed);
		add(textField);
		add(from);
		add(to);
		add(list);
		add(list2);
		add(button);
		add(outLabel);
		setVisible(true);
		setSize(300, 300);
	}// design

} // close Class
