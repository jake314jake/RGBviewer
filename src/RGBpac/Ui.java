package RGBpac;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HexFormat;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Ui implements ChangeListener {

	private JFrame frame;
	private JSlider REDslider,GREENslider,BLUEslider;
	private JLabel RGBScreenLabel;
	private JPanel HEXpanel;
	private JTextField HEXtextField;
	private JTextField REDtextField,GREENtextField,BLUEtextField;
	private final int  MAX_RGB=255,MIN_RGB=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ui window = new Ui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ui() {
		initialize();
		int R=REDslider.getValue();int G=GREENslider.getValue();int B=BLUEslider.getValue();
		setHexText(R,G,B);
		setRGBText(R,G,B);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 535, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("RGBviewer");
		JPanel RGBScreenpanel = new JPanel();
		RGBScreenpanel.setBounds(45, 48, 192, 218);
		frame.getContentPane().add(RGBScreenpanel);
		RGBScreenpanel.setLayout(null);
		
		
		
		JPanel RGBValuepanel = new JPanel();
		RGBValuepanel.setBounds(264, 48, 220, 256);
		frame.getContentPane().add(RGBValuepanel);
		RGBValuepanel.setLayout(null);
		
		 GREENslider = new JSlider(MIN_RGB, MAX_RGB, (int)(Math.random() * MAX_RGB));
		GREENslider.setBounds(10, 122, 200, 38);
		RGBValuepanel.add(GREENslider);
		GREENslider.setPaintTrack(true);
		GREENslider.setPaintTicks(true);
		GREENslider.setPaintLabels(true);
		GREENslider.setMajorTickSpacing(50);
		GREENslider.setMinorTickSpacing(1);
		GREENslider.setName("GREENslider");
		JLabel GREENLabel = new JLabel("GREEN");
		GREENLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GREENLabel.setBounds(10, 97, 65, 14);
		RGBValuepanel.add(GREENLabel);
		GREENslider.addChangeListener(this);
		 REDslider = new JSlider(MIN_RGB, MAX_RGB, (int)(Math.random() * MAX_RGB));
		REDslider.setPaintTrack(true);
		REDslider.setPaintTicks(true);
		REDslider.setPaintLabels(true);
		REDslider.setMinorTickSpacing(1);
		REDslider.setMajorTickSpacing(50);
		REDslider.setBounds(10, 36, 200, 38);
		REDslider.setName("REDslider");
		RGBValuepanel.add(REDslider);
		REDslider.addChangeListener(this);
		JLabel REDLabel = new JLabel("RED");
		REDLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		REDLabel.setBounds(10, 11, 65, 14);
		RGBValuepanel.add(REDLabel);
		
	    BLUEslider = new JSlider(MIN_RGB, MAX_RGB, (int)(Math.random() * MAX_RGB));
		BLUEslider.setPaintTrack(true);
		BLUEslider.setPaintTicks(true);
		BLUEslider.setPaintLabels(true);
		BLUEslider.setMinorTickSpacing(1);
		BLUEslider.setMajorTickSpacing(50);
		BLUEslider.setBounds(10, 196, 200, 38);
		BLUEslider.setName("BLUEslider");
		RGBValuepanel.add(BLUEslider);
		BLUEslider.addChangeListener(this);
		JLabel BLUELabel = new JLabel("BLUE");
		BLUELabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		BLUELabel.setBounds(10, 171, 65, 14);
		RGBValuepanel.add(BLUELabel);
		
		RGBScreenLabel = new JLabel("");
		RGBScreenLabel.setOpaque(true);
		RGBScreenLabel.setBackground(new Color(REDslider.getValue(),GREENslider.getValue(),BLUEslider.getValue()));
		RGBScreenLabel.setBounds(10, 11, 172, 196);
		RGBScreenpanel.add(RGBScreenLabel);
		
		HEXpanel = new JPanel();
		HEXpanel.setBounds(45, 287, 209, 61);
		frame.getContentPane().add(HEXpanel);
		HEXpanel.setLayout(null);
		
		HEXtextField = new JTextField();
		HEXtextField.setFont(new Font("Tahoma", Font.BOLD, 16));
		HEXtextField.setHorizontalAlignment(SwingConstants.CENTER);
		HEXtextField.setBounds(76, 17, 123, 25);
		HEXpanel.add(HEXtextField);
		HEXtextField.setColumns(10);
		
		JLabel HEXLabel = new JLabel("HEX");
		HEXLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		HEXLabel.setBounds(10, 17, 54, 14);
		HEXpanel.add(HEXLabel);
		
		JPanel RGBpanel = new JPanel();
		RGBpanel.setLayout(null);
		RGBpanel.setBounds(264, 315, 220, 61);
		frame.getContentPane().add(RGBpanel);
		
		JLabel RGBLabel = new JLabel("RGB");
		RGBLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		RGBLabel.setBounds(10, 17, 54, 14);
		RGBpanel.add(RGBLabel);
		
		REDtextField = new JTextField();
		REDtextField.setHorizontalAlignment(SwingConstants.CENTER);
		REDtextField.setBounds(68, 16, 39, 20);
		RGBpanel.add(REDtextField);
		REDtextField.setColumns(3);
		
		GREENtextField = new JTextField();
		GREENtextField.setHorizontalAlignment(SwingConstants.CENTER);
		GREENtextField.setColumns(3);
		GREENtextField.setBounds(117, 16, 39, 20);
		RGBpanel.add(GREENtextField);
		
		BLUEtextField = new JTextField();
		BLUEtextField.setHorizontalAlignment(SwingConstants.CENTER);
		BLUEtextField.setColumns(3);
		BLUEtextField.setBounds(171, 16, 39, 20);
		RGBpanel.add(BLUEtextField);
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		 Object source = e.getSource();
		 if(source  instanceof JSlider) {
			 {
	int R=REDslider.getValue();int G=GREENslider.getValue();int B=BLUEslider.getValue();
		RGBScreenLabel.setBackground(new Color(R,G,B));
		setHexText(R,G,B);
		setRGBText(R,G,B);
		 }}
		 }
	String HexValue(int R,int G,int B) {
		String hexValue="";
		
		    hexValue+="0x";
			hexValue +=(R < 10 ? "0" : "")+Integer.toHexString(R);
			hexValue +=(G < 10 ? "0" : "")+Integer.toHexString(G);
			hexValue +=(B < 10 ? "0" : "")+Integer.toHexString(B);
		return hexValue;
	}
	void setHexText(int R,int G,int B) {
		HEXtextField.setText(HexValue(R,G,B));
	}
	void setRGBText(int R,int G,int B) {
		REDtextField.setText(Integer.toString(R));
		GREENtextField.setText(Integer.toString(G));
		BLUEtextField.setText(Integer.toString(B));
	}
}
