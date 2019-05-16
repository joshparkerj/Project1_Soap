package com.revature;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import com.revature.domain.AircraftTableModel;
import com.revature.domain.FormValidation;
import com.revature.domain.Manufacturer;
import com.revature.domain.ManufacturerTableModel;
import com.revature.service.AircraftDAO;
import com.revature.service.ManufacturerDAO;

import javax.swing.JTable;
import java.awt.Font;
import java.awt.Window;
import java.util.Collections;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.ListSelectionModel;
import com.revature.domain.Aircraft;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import java.awt.ComponentOrientation;

public class DatabaseUI extends javax.swing.JFrame {

	private static final long serialVersionUID = -4032249384334439850L;
	private static JPanel contentPane;
	private static AircraftTableModel tableModel1 = new AircraftTableModel();;
	private static ManufacturerTableModel tableModel2 =  new ManufacturerTableModel();
	private static List<Aircraft> modelList1;
	private static List<Manufacturer> modelList2;
	private static Integer selectedRow = -1;
	private static JTable table;
	private static JTextField textBox1;
	private static JTextField textBox3;
	private static JTextField textBox5;
	private static JTextField textBox7;
	private static JTextField textBox9;
	private static JTextField textBox11;
	private static JTextField textBox13;
	private static JTextField textBox15;
	private static JTextField textBox17;
	private static JTextField textBox19;
	private static JTextField textBox21;
	private static JTextField textBox23;
	private static JTextField textBox2;
	private static JTextField textBox4;
	private static JTextField textBox6;
	private static JTextField textBox8;
	private static JTextField textBox10;
	private static JTextField textBox12;
	private static JTextField textBox14;
	private static JTextField textBox16;
	private static JTextField textBox18;
	private static JTextField textBox20;
	private static JTextField textBox22;
	private static JTextField textBox24;
	private static JLabel label1;
	private static JLabel label2;
	private static JLabel label3;
	private static JLabel label4;
	private static JLabel label5;
	private static JLabel label6;
	private static JLabel label7;
	private static JLabel label8;
	private static JLabel label9;
	private static JLabel label10;
	private static JLabel label11;
	private static JLabel label12;
	private static JLabel label13;
	private static JLabel label14;
	private static JLabel label15;
	private static JLabel label16;
	private static JLabel label17;
	private static JLabel label18;
	private static JLabel label19;
	private static JLabel label20;
	private static JLabel label21;
	private static JLabel label22;
	private static JLabel label23;
	private static JLabel label24;
	JButton table1Button;
	JButton table2Button;
	JButton table3Button;
	JButton table4Button;
	FormValidation validation;
	private static Integer currentTable = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabaseUI ui = new DatabaseUI();
					ui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DatabaseUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 806);
		contentPane = new JPanel();
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gridBagLayout = new GridBagLayout();

		gridBagLayout.columnWidths = new int[] { 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 0 };
		gridBagLayout.rowHeights = new int[] { 23, 226, 0, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 53,
				0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };

		contentPane.setLayout(gridBagLayout);

		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
			}
		});
		exitButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_exitButton = new GridBagConstraints();
		gbc_exitButton.anchor = GridBagConstraints.NORTHEAST;
		gbc_exitButton.insets = new Insets(0, 0, 5, 0);
		gbc_exitButton.gridx = 11;
		gbc_exitButton.gridy = 0;
		contentPane.add(exitButton, gbc_exitButton);

		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setGridColor(Color.BLACK);
		table.setMinimumSize(new Dimension(30, 25));
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 12;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		table.setFillsViewportHeight(true);

		table1Button = new JButton("TableNotImplemented");
		table1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initTable1();
				reset();
			}
		});
		GridBagConstraints gbc_table1Button = new GridBagConstraints();
		gbc_table1Button.gridwidth = 3;
		gbc_table1Button.insets = new Insets(0, 0, 5, 5);
		gbc_table1Button.gridx = 0;
		gbc_table1Button.gridy = 2;
		contentPane.add(table1Button, gbc_table1Button);

		table2Button = new JButton("TableNotImplemented");
		table2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initTable2();
				reset();
			}
		});
		GridBagConstraints gbc_table2Button = new GridBagConstraints();
		gbc_table2Button.gridwidth = 3;
		gbc_table2Button.insets = new Insets(0, 0, 5, 5);
		gbc_table2Button.gridx = 3;
		gbc_table2Button.gridy = 2;
		contentPane.add(table2Button, gbc_table2Button);

		table3Button = new JButton("TableNotImplemented");
		table3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initTable3();
				reset();
			}
		});
		GridBagConstraints gbc_table3Button = new GridBagConstraints();
		gbc_table3Button.gridwidth = 3;
		gbc_table3Button.insets = new Insets(0, 0, 5, 5);
		gbc_table3Button.gridx = 6;
		gbc_table3Button.gridy = 2;
		contentPane.add(table3Button, gbc_table3Button);

		table4Button = new JButton("TableNotImplemented");
		table4Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initTable3();
				reset();
			}
		});
		GridBagConstraints gbc_table4Button = new GridBagConstraints();
		gbc_table4Button.gridwidth = 3;
		gbc_table4Button.insets = new Insets(0, 0, 5, 0);
		gbc_table4Button.gridx = 9;
		gbc_table4Button.gridy = 2;
		contentPane.add(table4Button, gbc_table4Button);

		label1 = new JLabel("New label");
		label1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.anchor = GridBagConstraints.EAST;
		gbc_label1.gridwidth = 3;
		gbc_label1.insets = new Insets(0, 0, 5, 5);
		gbc_label1.gridx = 0;
		gbc_label1.gridy = 4;
		contentPane.add(label1, gbc_label1);

		textBox1 = new JTextField();
		GridBagConstraints gbc_textBox1 = new GridBagConstraints();
		gbc_textBox1.gridwidth = 3;
		gbc_textBox1.insets = new Insets(0, 0, 5, 5);
		gbc_textBox1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox1.gridx = 3;
		gbc_textBox1.gridy = 4;
		contentPane.add(textBox1, gbc_textBox1);
		textBox1.setColumns(10);

		label2 = new JLabel("New label");
		label2.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label2 = new GridBagConstraints();
		gbc_label2.anchor = GridBagConstraints.EAST;
		gbc_label2.gridwidth = 3;
		gbc_label2.insets = new Insets(0, 0, 5, 5);
		gbc_label2.gridx = 6;
		gbc_label2.gridy = 4;
		contentPane.add(label2, gbc_label2);

		textBox2 = new JTextField();
		GridBagConstraints gbc_textBox2 = new GridBagConstraints();
		gbc_textBox2.gridwidth = 3;
		gbc_textBox2.insets = new Insets(0, 0, 5, 5);
		gbc_textBox2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox2.gridx = 9;
		gbc_textBox2.gridy = 4;
		contentPane.add(textBox2, gbc_textBox2);
		textBox2.setColumns(10);

		label3 = new JLabel("New label");
		label3.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label3 = new GridBagConstraints();
		gbc_label3.anchor = GridBagConstraints.EAST;
		gbc_label3.gridwidth = 3;
		gbc_label3.insets = new Insets(0, 0, 5, 5);
		gbc_label3.gridx = 0;
		gbc_label3.gridy = 5;
		contentPane.add(label3, gbc_label3);

		textBox3 = new JTextField();
		GridBagConstraints gbc_textBox3 = new GridBagConstraints();
		gbc_textBox3.gridwidth = 3;
		gbc_textBox3.insets = new Insets(0, 0, 5, 5);
		gbc_textBox3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox3.gridx = 3;
		gbc_textBox3.gridy = 5;
		contentPane.add(textBox3, gbc_textBox3);
		textBox3.setColumns(10);

		label4 = new JLabel("New label");
		label4.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label4 = new GridBagConstraints();
		gbc_label4.anchor = GridBagConstraints.EAST;
		gbc_label4.gridwidth = 3;
		gbc_label4.insets = new Insets(0, 0, 5, 5);
		gbc_label4.gridx = 6;
		gbc_label4.gridy = 5;
		contentPane.add(label4, gbc_label4);

		textBox4 = new JTextField();
		GridBagConstraints gbc_textBox4 = new GridBagConstraints();
		gbc_textBox4.gridwidth = 3;
		gbc_textBox4.insets = new Insets(0, 0, 5, 5);
		gbc_textBox4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox4.gridx = 9;
		gbc_textBox4.gridy = 5;
		contentPane.add(textBox4, gbc_textBox4);
		textBox4.setColumns(10);

		label5 = new JLabel("New label");
		label5.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label5 = new GridBagConstraints();
		gbc_label5.anchor = GridBagConstraints.EAST;
		gbc_label5.gridwidth = 3;
		gbc_label5.insets = new Insets(0, 0, 5, 5);
		gbc_label5.gridx = 0;
		gbc_label5.gridy = 6;
		contentPane.add(label5, gbc_label5);

		textBox5 = new JTextField();
		GridBagConstraints gbc_textBox5 = new GridBagConstraints();
		gbc_textBox5.gridwidth = 3;
		gbc_textBox5.insets = new Insets(0, 0, 5, 5);
		gbc_textBox5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox5.gridx = 3;
		gbc_textBox5.gridy = 6;
		contentPane.add(textBox5, gbc_textBox5);
		textBox5.setColumns(10);

		label6 = new JLabel("New label");
		label6.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label6 = new GridBagConstraints();
		gbc_label6.anchor = GridBagConstraints.EAST;
		gbc_label6.gridwidth = 3;
		gbc_label6.insets = new Insets(0, 0, 5, 5);
		gbc_label6.gridx = 6;
		gbc_label6.gridy = 6;
		contentPane.add(label6, gbc_label6);

		textBox6 = new JTextField();
		GridBagConstraints gbc_textBox6 = new GridBagConstraints();
		gbc_textBox6.gridwidth = 3;
		gbc_textBox6.insets = new Insets(0, 0, 5, 5);
		gbc_textBox6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox6.gridx = 9;
		gbc_textBox6.gridy = 6;
		contentPane.add(textBox6, gbc_textBox6);
		textBox6.setColumns(10);

		label7 = new JLabel("New label");
		label7.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label7 = new GridBagConstraints();
		gbc_label7.anchor = GridBagConstraints.EAST;
		gbc_label7.gridwidth = 3;
		gbc_label7.insets = new Insets(0, 0, 5, 5);
		gbc_label7.gridx = 0;
		gbc_label7.gridy = 7;
		contentPane.add(label7, gbc_label7);

		textBox7 = new JTextField();
		GridBagConstraints gbc_textBox7 = new GridBagConstraints();
		gbc_textBox7.gridwidth = 3;
		gbc_textBox7.insets = new Insets(0, 0, 5, 5);
		gbc_textBox7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox7.gridx = 3;
		gbc_textBox7.gridy = 7;
		contentPane.add(textBox7, gbc_textBox7);
		textBox7.setColumns(10);

		label8 = new JLabel("New label");
		label8.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label8 = new GridBagConstraints();
		gbc_label8.anchor = GridBagConstraints.EAST;
		gbc_label8.gridwidth = 3;
		gbc_label8.insets = new Insets(0, 0, 5, 5);
		gbc_label8.gridx = 6;
		gbc_label8.gridy = 7;
		contentPane.add(label8, gbc_label8);

		textBox8 = new JTextField();
		GridBagConstraints gbc_textBox8 = new GridBagConstraints();
		gbc_textBox8.gridwidth = 3;
		gbc_textBox8.insets = new Insets(0, 0, 5, 5);
		gbc_textBox8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox8.gridx = 9;
		gbc_textBox8.gridy = 7;
		contentPane.add(textBox8, gbc_textBox8);
		textBox8.setColumns(10);

		label9 = new JLabel("New label");
		label9.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label9 = new GridBagConstraints();
		gbc_label9.anchor = GridBagConstraints.EAST;
		gbc_label9.gridwidth = 3;
		gbc_label9.insets = new Insets(0, 0, 5, 5);
		gbc_label9.gridx = 0;
		gbc_label9.gridy = 8;
		contentPane.add(label9, gbc_label9);

		textBox9 = new JTextField();
		GridBagConstraints gbc_textBox9 = new GridBagConstraints();
		gbc_textBox9.gridwidth = 3;
		gbc_textBox9.insets = new Insets(0, 0, 5, 5);
		gbc_textBox9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox9.gridx = 3;
		gbc_textBox9.gridy = 8;
		contentPane.add(textBox9, gbc_textBox9);
		textBox9.setColumns(10);

		label10 = new JLabel("New label");
		label10.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label10 = new GridBagConstraints();
		gbc_label10.anchor = GridBagConstraints.EAST;
		gbc_label10.gridwidth = 3;
		gbc_label10.insets = new Insets(0, 0, 5, 5);
		gbc_label10.gridx = 6;
		gbc_label10.gridy = 8;
		contentPane.add(label10, gbc_label10);

		textBox10 = new JTextField();
		GridBagConstraints gbc_textBox10 = new GridBagConstraints();
		gbc_textBox10.gridwidth = 3;
		gbc_textBox10.insets = new Insets(0, 0, 5, 5);
		gbc_textBox10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox10.gridx = 9;
		gbc_textBox10.gridy = 8;
		contentPane.add(textBox10, gbc_textBox10);
		textBox10.setColumns(10);

		label11 = new JLabel("New label");
		label11.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label11 = new GridBagConstraints();
		gbc_label11.anchor = GridBagConstraints.EAST;
		gbc_label11.gridwidth = 3;
		gbc_label11.insets = new Insets(0, 0, 5, 5);
		gbc_label11.gridx = 0;
		gbc_label11.gridy = 9;
		contentPane.add(label11, gbc_label11);

		textBox11 = new JTextField();
		GridBagConstraints gbc_textBox11 = new GridBagConstraints();
		gbc_textBox11.gridwidth = 3;
		gbc_textBox11.insets = new Insets(0, 0, 5, 5);
		gbc_textBox11.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox11.gridx = 3;
		gbc_textBox11.gridy = 9;
		contentPane.add(textBox11, gbc_textBox11);
		textBox11.setColumns(10);

		label12 = new JLabel("New label");
		label12.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label12 = new GridBagConstraints();
		gbc_label12.anchor = GridBagConstraints.EAST;
		gbc_label12.gridwidth = 3;
		gbc_label12.insets = new Insets(0, 0, 5, 5);
		gbc_label12.gridx = 6;
		gbc_label12.gridy = 9;
		contentPane.add(label12, gbc_label12);

		textBox12 = new JTextField();
		GridBagConstraints gbc_textBox12 = new GridBagConstraints();
		gbc_textBox12.gridwidth = 3;
		gbc_textBox12.insets = new Insets(0, 0, 5, 5);
		gbc_textBox12.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox12.gridx = 9;
		gbc_textBox12.gridy = 9;
		contentPane.add(textBox12, gbc_textBox12);
		textBox12.setColumns(10);

		label13 = new JLabel("New label");
		label13.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label13 = new GridBagConstraints();
		gbc_label13.anchor = GridBagConstraints.EAST;
		gbc_label13.gridwidth = 3;
		gbc_label13.insets = new Insets(0, 0, 5, 5);
		gbc_label13.gridx = 0;
		gbc_label13.gridy = 10;
		contentPane.add(label13, gbc_label13);

		textBox13 = new JTextField();
		GridBagConstraints gbc_textBox13 = new GridBagConstraints();
		gbc_textBox13.gridwidth = 3;
		gbc_textBox13.insets = new Insets(0, 0, 5, 5);
		gbc_textBox13.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox13.gridx = 3;
		gbc_textBox13.gridy = 10;
		contentPane.add(textBox13, gbc_textBox13);
		textBox13.setColumns(10);

		label14 = new JLabel("New label");
		label14.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label14 = new GridBagConstraints();
		gbc_label14.anchor = GridBagConstraints.EAST;
		gbc_label14.gridwidth = 3;
		gbc_label14.insets = new Insets(0, 0, 5, 5);
		gbc_label14.gridx = 6;
		gbc_label14.gridy = 10;
		contentPane.add(label14, gbc_label14);

		textBox14 = new JTextField();
		GridBagConstraints gbc_textBox14 = new GridBagConstraints();
		gbc_textBox14.gridwidth = 3;
		gbc_textBox14.insets = new Insets(0, 0, 5, 5);
		gbc_textBox14.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox14.gridx = 9;
		gbc_textBox14.gridy = 10;
		contentPane.add(textBox14, gbc_textBox14);
		textBox14.setColumns(10);

		label15 = new JLabel("New label");
		label15.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label15 = new GridBagConstraints();
		gbc_label15.anchor = GridBagConstraints.EAST;
		gbc_label15.gridwidth = 3;
		gbc_label15.insets = new Insets(0, 0, 5, 5);
		gbc_label15.gridx = 0;
		gbc_label15.gridy = 11;
		contentPane.add(label15, gbc_label15);

		textBox15 = new JTextField();
		GridBagConstraints gbc_textBox15 = new GridBagConstraints();
		gbc_textBox15.gridwidth = 3;
		gbc_textBox15.insets = new Insets(0, 0, 5, 5);
		gbc_textBox15.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox15.gridx = 3;
		gbc_textBox15.gridy = 11;
		contentPane.add(textBox15, gbc_textBox15);
		textBox15.setColumns(10);

		label16 = new JLabel("New label");
		label16.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label16 = new GridBagConstraints();
		gbc_label16.anchor = GridBagConstraints.EAST;
		gbc_label16.gridwidth = 3;
		gbc_label16.insets = new Insets(0, 0, 5, 5);
		gbc_label16.gridx = 6;
		gbc_label16.gridy = 11;
		contentPane.add(label16, gbc_label16);

		textBox16 = new JTextField();
		GridBagConstraints gbc_textBox16 = new GridBagConstraints();
		gbc_textBox16.gridwidth = 3;
		gbc_textBox16.insets = new Insets(0, 0, 5, 5);
		gbc_textBox16.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox16.gridx = 9;
		gbc_textBox16.gridy = 11;
		contentPane.add(textBox16, gbc_textBox16);
		textBox16.setColumns(10);

		label17 = new JLabel("New label");
		label17.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label17 = new GridBagConstraints();
		gbc_label17.anchor = GridBagConstraints.EAST;
		gbc_label17.gridwidth = 3;
		gbc_label17.insets = new Insets(0, 0, 5, 5);
		gbc_label17.gridx = 0;
		gbc_label17.gridy = 12;
		contentPane.add(label17, gbc_label17);

		textBox17 = new JTextField();
		GridBagConstraints gbc_textBox17 = new GridBagConstraints();
		gbc_textBox17.gridwidth = 3;
		gbc_textBox17.insets = new Insets(0, 0, 5, 5);
		gbc_textBox17.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox17.gridx = 3;
		gbc_textBox17.gridy = 12;
		contentPane.add(textBox17, gbc_textBox17);
		textBox17.setColumns(10);

		label18 = new JLabel("New label");
		label18.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label18 = new GridBagConstraints();
		gbc_label18.anchor = GridBagConstraints.EAST;
		gbc_label18.gridwidth = 3;
		gbc_label18.insets = new Insets(0, 0, 5, 5);
		gbc_label18.gridx = 6;
		gbc_label18.gridy = 12;
		contentPane.add(label18, gbc_label18);

		textBox18 = new JTextField();
		GridBagConstraints gbc_textBox18 = new GridBagConstraints();
		gbc_textBox18.gridwidth = 3;
		gbc_textBox18.insets = new Insets(0, 0, 5, 5);
		gbc_textBox18.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox18.gridx = 9;
		gbc_textBox18.gridy = 12;
		contentPane.add(textBox18, gbc_textBox18);
		textBox18.setColumns(10);

		label19 = new JLabel("New label");
		label19.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label19 = new GridBagConstraints();
		gbc_label19.anchor = GridBagConstraints.EAST;
		gbc_label19.gridwidth = 3;
		gbc_label19.insets = new Insets(0, 0, 5, 5);
		gbc_label19.gridx = 0;
		gbc_label19.gridy = 13;
		contentPane.add(label19, gbc_label19);

		textBox19 = new JTextField();
		GridBagConstraints gbc_textBox19 = new GridBagConstraints();
		gbc_textBox19.gridwidth = 3;
		gbc_textBox19.insets = new Insets(0, 0, 5, 5);
		gbc_textBox19.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox19.gridx = 3;
		gbc_textBox19.gridy = 13;
		contentPane.add(textBox19, gbc_textBox19);
		textBox19.setColumns(10);

		label20 = new JLabel("New label");
		label20.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label20 = new GridBagConstraints();
		gbc_label20.anchor = GridBagConstraints.EAST;
		gbc_label20.gridwidth = 3;
		gbc_label20.insets = new Insets(0, 0, 5, 5);
		gbc_label20.gridx = 6;
		gbc_label20.gridy = 13;
		contentPane.add(label20, gbc_label20);

		textBox20 = new JTextField();
		GridBagConstraints gbc_textBox20 = new GridBagConstraints();
		gbc_textBox20.gridwidth = 3;
		gbc_textBox20.insets = new Insets(0, 0, 5, 5);
		gbc_textBox20.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox20.gridx = 9;
		gbc_textBox20.gridy = 13;
		contentPane.add(textBox20, gbc_textBox20);
		textBox20.setColumns(10);

		label21 = new JLabel("New label");
		label21.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label21 = new GridBagConstraints();
		gbc_label21.anchor = GridBagConstraints.EAST;
		gbc_label21.gridwidth = 3;
		gbc_label21.insets = new Insets(0, 0, 5, 5);
		gbc_label21.gridx = 0;
		gbc_label21.gridy = 14;
		contentPane.add(label21, gbc_label21);

		textBox21 = new JTextField();
		GridBagConstraints gbc_textBox21 = new GridBagConstraints();
		gbc_textBox21.gridwidth = 3;
		gbc_textBox21.insets = new Insets(0, 0, 5, 5);
		gbc_textBox21.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox21.gridx = 3;
		gbc_textBox21.gridy = 14;
		contentPane.add(textBox21, gbc_textBox21);
		textBox21.setColumns(10);

		label22 = new JLabel("New label");
		label22.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label22 = new GridBagConstraints();
		gbc_label22.anchor = GridBagConstraints.EAST;
		gbc_label22.gridwidth = 3;
		gbc_label22.insets = new Insets(0, 0, 5, 5);
		gbc_label22.gridx = 6;
		gbc_label22.gridy = 14;
		contentPane.add(label22, gbc_label22);

		textBox22 = new JTextField();
		GridBagConstraints gbc_textBox22 = new GridBagConstraints();
		gbc_textBox22.gridwidth = 3;
		gbc_textBox22.insets = new Insets(0, 0, 5, 5);
		gbc_textBox22.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox22.gridx = 9;
		gbc_textBox22.gridy = 14;
		contentPane.add(textBox22, gbc_textBox22);
		textBox22.setColumns(10);

		label23 = new JLabel("New label");
		label23.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label23 = new GridBagConstraints();
		gbc_label23.anchor = GridBagConstraints.EAST;
		gbc_label23.gridwidth = 3;
		gbc_label23.insets = new Insets(0, 0, 5, 5);
		gbc_label23.gridx = 0;
		gbc_label23.gridy = 15;
		contentPane.add(label23, gbc_label23);

		textBox23 = new JTextField();
		GridBagConstraints gbc_textBox23 = new GridBagConstraints();
		gbc_textBox23.gridwidth = 3;
		gbc_textBox23.insets = new Insets(0, 0, 5, 5);
		gbc_textBox23.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox23.gridx = 3;
		gbc_textBox23.gridy = 15;
		contentPane.add(textBox23, gbc_textBox23);
		textBox23.setColumns(10);

		label24 = new JLabel("New label");
		label24.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_label24 = new GridBagConstraints();
		gbc_label24.anchor = GridBagConstraints.EAST;
		gbc_label24.gridwidth = 3;
		gbc_label24.insets = new Insets(0, 0, 5, 5);
		gbc_label24.gridx = 6;
		gbc_label24.gridy = 15;
		contentPane.add(label24, gbc_label24);

		textBox24 = new JTextField();
		GridBagConstraints gbc_textBox24 = new GridBagConstraints();
		gbc_textBox24.gridwidth = 3;
		gbc_textBox24.insets = new Insets(0, 0, 5, 5);
		gbc_textBox24.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBox24.gridx = 9;
		gbc_textBox24.gridy = 15;
		contentPane.add(textBox24, gbc_textBox24);
		textBox24.setColumns(10);

		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (currentTable) {
				case 1:
						deleteEntryTable1();
					break;
				case 2:
						deleteEntryTable2();
					break;
				case 3:
						deleteEntryTable3();
					break;
				case 4:
						deleteEntryTable4();
					break;
				}
			}
		});
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_deleteButton = new GridBagConstraints();
		gbc_deleteButton.gridwidth = 4;
		gbc_deleteButton.insets = new Insets(0, 0, 0, 5);
		gbc_deleteButton.gridx = 0;
		gbc_deleteButton.gridy = 17;
		contentPane.add(deleteButton, gbc_deleteButton);

		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (currentTable) {
				case 1:
					if (selectedRow < 0)
						return;
					if (validateEntryTable1())
						updateEntryTable1();
					break;
				case 2:
					if (selectedRow < 0)
						return;
					if (validateEntryTable2())
						updateEntryTable2();
					break;
				case 3:
					if (selectedRow < 0)
						return;
					if (validateEntryTable3())
						updateEntryTable3();
					break;
				case 4:
					if (selectedRow < 0)
						return;
					if (validateEntryTable4())
						updateEntryTable4();
					break;
				default:
					if (validateEntryTable1())
						updateEntryTable1();
					break;
				}
			}
		});
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_updateButton = new GridBagConstraints();
		gbc_updateButton.gridwidth = 4;
		gbc_updateButton.insets = new Insets(0, 0, 0, 5);
		gbc_updateButton.gridx = 4;
		gbc_updateButton.gridy = 17;
		contentPane.add(updateButton, gbc_updateButton);

		JButton createButton = new JButton("Create");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (currentTable) {
				case 1:
					if (validateEntryTable1())
						createEntryTable1();
					break;
				case 2:
					if (validateEntryTable2())
						createEntryTable2();
					break;
				case 3:
					if (validateEntryTable3())
						createEntryTable3();
					break;
				case 4:
					if (validateEntryTable4())
						createEntryTable4();
					break;
				default:
					if (validateEntryTable1())
						createEntryTable1();
					break;
				}
			}
		});
		createButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_createButton = new GridBagConstraints();
		gbc_createButton.gridwidth = 4;
		gbc_createButton.gridx = 8;
		gbc_createButton.gridy = 17;
		contentPane.add(createButton, gbc_createButton);
		switch (currentTable) {
		case 1:
			initTable1();
			break;
		case 2:
			initTable2();
			break;
		case 3:
			initTable3();
			break;
		case 4:
			initTable4();
			break;
		default:
			initTable1();
			break;
		}
		init();
	}

	protected void deleteEntryTable4() {
		// TODO Auto-generated method stub
		
	}

	protected void deleteEntryTable3() {
		// TODO Auto-generated method stub
		
	}

	protected void deleteEntryTable2() {
		if (selectedRow < 0)
			return;
		Manufacturer manufacturer = modelList2.get(selectedRow);
		ManufacturerDAO dao = ManufacturerDAO.getDAO();
		dao.deleteManufacturer(manufacturer);
		JOptionPane.showMessageDialog(this, "Manufacturer Deleted From Database", "Success", JOptionPane.INFORMATION_MESSAGE);
		modelList2.remove(manufacturer);
		tableModel2.fireTableDataChanged();
		reset();
	}

	protected void deleteEntryTable1() {
		if (selectedRow < 0)
			return;
		Aircraft aircraft = modelList1.get(selectedRow);
		AircraftDAO dao = AircraftDAO.getDAO();
		dao.deleteAircraft(aircraft);
		JOptionPane.showMessageDialog(this, "Aircraft Deleted From Database", "Success", JOptionPane.INFORMATION_MESSAGE);
		modelList1.remove(aircraft);
		tableModel1.fireTableDataChanged();
		reset();
	}

	protected void updateEntryTable4() {
		// TODO Auto-generated method stub
		
	}

	protected void updateEntryTable3() {
		// TODO Auto-generated method stub
		
	}

	protected void updateEntryTable2() {
		Manufacturer manufacturer = modelList2.get(selectedRow);
		manufacturer.setCompanyName(textBox1.getText());
		manufacturer.setAddress(textBox2.getText());
		manufacturer.setCity(textBox3.getText());
		manufacturer.setState(textBox4.getText());
		manufacturer.setZipcode(textBox5.getText());
		manufacturer.setPhone(textBox6.getText());
		manufacturer.setEmail(textBox7.getText());
		ManufacturerDAO dao = ManufacturerDAO.getDAO();
		manufacturer = dao.updateManufacturer(manufacturer);
		JOptionPane.showMessageDialog(this, "Manufacturer Update in Database", "Success", JOptionPane.INFORMATION_MESSAGE);
		tableModel1.fireTableDataChanged();
		reset();
	}

	protected void updateEntryTable1() {
		Aircraft aircraft = modelList1.get(selectedRow);
		aircraft.setManufacturer(textBox1.getText());
		aircraft.setAircraftName(textBox2.getText());
		aircraft.setAircraftType(textBox3.getText());
		aircraft.setRangeNM(Integer.valueOf(textBox4.getText()));
		aircraft.setMaxCruiseSpeedKtas(Integer.valueOf(textBox5.getText()));
		aircraft.setUsefulLoad(Integer.valueOf(textBox6.getText()));
		aircraft.setNumPassengers(Integer.valueOf(textBox7.getText()));
		aircraft.setEnginePower(textBox8.getText());
		aircraft.setEngineManufacturer(textBox9.getText());
		aircraft.setEngineModel(textBox10.getText());
		aircraft.setNumEngines(Integer.valueOf(textBox11.getText()));
		aircraft.setLengthM(Double.valueOf(textBox12.getText()));
		aircraft.setHeightM(Double.valueOf(textBox13.getText()));
		aircraft.setWingSpanM(Double.valueOf(textBox14.getText()));
		aircraft.setServiceCeilingFt(Integer.valueOf(textBox15.getText()));
		AircraftDAO dao = AircraftDAO.getDAO();
		aircraft = dao.updateAircraft(aircraft);
		JOptionPane.showMessageDialog(this, "Aircraft Update in Database", "Success", JOptionPane.INFORMATION_MESSAGE);
		tableModel1.fireTableDataChanged();
		reset();
	}

	protected void createEntryTable4() {
		// TODO Auto-generated method stub
		
	}

	protected boolean validateEntryTable4() {
		// TODO Auto-generated method stub
		return false;
	}

	protected boolean validateEntryTable3() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void createEntryTable3() {
		// TODO Auto-generated method stub
		
	}

	protected void createEntryTable2() {
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setCompanyName(textBox1.getText());
		manufacturer.setAddress(textBox2.getText());
		manufacturer.setCity(textBox3.getText());
		manufacturer.setState(textBox4.getText());
		manufacturer.setZipcode(textBox5.getText());
		manufacturer.setPhone(textBox6.getText());
		manufacturer.setEmail(textBox7.getText());
		ManufacturerDAO dao = ManufacturerDAO.getDAO();
		Manufacturer temp = dao.getManufacturer(textBox1.getText());
		if (temp.getCompanyName() != null) {
			JOptionPane.showMessageDialog(this, "Manufacturer Already Exists in Database", "error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		manufacturer = dao.addManufacturer(manufacturer);
		modelList2.add(manufacturer);
		Collections.sort(modelList2);
		JOptionPane.showMessageDialog(this, "Manufacturer Added to Database", "Success", JOptionPane.INFORMATION_MESSAGE);
		tableModel2.fireTableDataChanged();
		reset();		
	}

	protected boolean validateEntryTable2() {
		boolean valid = true;
		if (textBox1.getText().length() > 30 || !FormValidation.validateLettersOnly(textBox1.getText(), false)) {
			JOptionPane.showMessageDialog(this, "Manufacturer Field Invalid", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (textBox2.getText().length() > 40) {
			JOptionPane.showMessageDialog(this, "Address Field Invalid", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (textBox3.getText().length() > 30 || !FormValidation.validateCity(textBox3.getText())) {
			JOptionPane.showMessageDialog(this, "City Field Invalid", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (textBox4.getText().length() > 2 || !FormValidation.validateState(textBox4.getText())) {
			JOptionPane.showMessageDialog(this, "State Field Invalid. Use 2 Letter State Abreviation", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (textBox5.getText().length() > 10 || !FormValidation.validateZip(textBox5.getText())) {
			JOptionPane.showMessageDialog(this, "ZipCode Field Invalid", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		String phone = textBox6.getText();
		phone = FormValidation.modifyPhone(phone);
		textBox6.setText(phone);
		if (textBox6.getText().length() > 12 || !FormValidation.validatePhone(textBox6.getText())) {
			JOptionPane.showMessageDialog(this, "Phone Field Invalid", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (textBox7.getText().length() > 30 || !FormValidation.validateEmail(textBox7.getText())) {
			JOptionPane.showMessageDialog(this, "Email Field Invalid", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		return valid;
	}

	protected void createEntryTable1() {
		Aircraft aircraft = new Aircraft();
		aircraft.setManufacturer(textBox1.getText());
		aircraft.setAircraftName(textBox2.getText());
		aircraft.setAircraftType(textBox3.getText());
		aircraft.setRangeNM(Integer.valueOf(textBox4.getText()));
		aircraft.setMaxCruiseSpeedKtas(Integer.valueOf(textBox5.getText()));
		aircraft.setUsefulLoad(Integer.valueOf(textBox6.getText()));
		aircraft.setNumPassengers(Integer.valueOf(textBox7.getText()));
		aircraft.setEnginePower(textBox8.getText());
		aircraft.setEngineManufacturer(textBox9.getText());
		aircraft.setEngineModel(textBox10.getText());
		aircraft.setNumEngines(Integer.valueOf(textBox11.getText()));
		aircraft.setLengthM(Double.valueOf(textBox12.getText()));
		aircraft.setHeightM(Double.valueOf(textBox13.getText()));
		aircraft.setWingSpanM(Double.valueOf(textBox14.getText()));
		aircraft.setServiceCeilingFt(Integer.valueOf(textBox15.getText()));
		AircraftDAO dao = AircraftDAO.getDAO();
		Aircraft temp = dao.getAircraft(textBox1.getText(), textBox2.getText());
		if (temp.getId() != null) {
			JOptionPane.showMessageDialog(this, "Aircraft Already Exists in Database", "error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		aircraft = dao.addAircraft(aircraft);
		modelList1.add(aircraft);
		Collections.sort(modelList1);
		JOptionPane.showMessageDialog(this, "Aircraft Added to Database", "Success", JOptionPane.INFORMATION_MESSAGE);
		tableModel1.fireTableDataChanged();
		reset();
	}

	protected boolean validateEntryTable1() {
		boolean valid = true;
		if (textBox1.getText().length() > 30 || !FormValidation.validateLettersOnly(textBox1.getText(), false)) {
			JOptionPane.showMessageDialog(this, "Manufacturer Field Invalid", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (textBox2.getText().length() > 30) {
			JOptionPane.showMessageDialog(this, "Aircraft Model Field Invalid", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (!textBox3.getText().contentEquals("Piston") && !textBox3.getText().contentEquals("TurboProp") &&
				!textBox3.getText().contentEquals("TurboFan")) {
			JOptionPane.showMessageDialog(this, "Please enter: Piston, TurboProp, or TurboFan", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (textBox4.getText().length() > 4 || !FormValidation.validateNumbersOnly(textBox4.getText(), false)) {
			JOptionPane.showMessageDialog(this, "Integer Value Invalid for NM", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (textBox5.getText().length() > 4 || !FormValidation.validateNumbersOnly(textBox5.getText(), false)) {
			JOptionPane.showMessageDialog(this, "Integer Value Invalid for Cruise Speed", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (textBox6.getText().length() > 6 || !FormValidation.validateNumbersOnly(textBox6.getText(), false)) {
			JOptionPane.showMessageDialog(this, "Integer Value Invalid for Load", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (textBox7.getText().length() > 3 || !FormValidation.validateNumbersOnly(textBox7.getText(), false)) {
			JOptionPane.showMessageDialog(this, "Integer Value Invalid for Number of Passengers", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (textBox8.getText().length() > 10 || !FormValidation.validateLettersAndNumbersOnly(textBox8.getText(), false)) {
			JOptionPane.showMessageDialog(this, "Engine Power Field Invalid", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (textBox9.getText().length() > 30) {
			JOptionPane.showMessageDialog(this, "Engine Manufacturer Field Invalid", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (textBox10.getText().length() > 25) {
			JOptionPane.showMessageDialog(this, "Engine Model Field Invalid", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (textBox11.getText().length() > 1 || !FormValidation.validateNumbersOnly(textBox11.getText(), false)) {
			JOptionPane.showMessageDialog(this, "Invalid Number of Engines", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (textBox12.getText().length() > 10 || !FormValidation.validateMathValue(textBox12.getText(), false)) {
			JOptionPane.showMessageDialog(this, "Invalid Decimal Value for Length", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (textBox13.getText().length() > 10 || !FormValidation.validateMathValue(textBox13.getText(), false)) {
			JOptionPane.showMessageDialog(this, "Invalid Decimal Value for Height", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (textBox14.getText().length() > 10 || !FormValidation.validateMathValue(textBox14.getText(), false)) {
			JOptionPane.showMessageDialog(this, "Invalid Decimal Value for WingSpan", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		if (textBox15.getText().length() > 5 || !FormValidation.validateNumbersOnly(textBox15.getText(), false)) {
			JOptionPane.showMessageDialog(this, "Integer Value Invalid", "error", JOptionPane.ERROR_MESSAGE);
			valid = false;
		}
		return valid;
	}

	private void init() {
		table.setRowHeight(24);
		table1Button.setText("Aircraft");
		table2Button.setText("Manufacturer");
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = table.rowAtPoint(evt.getPoint());
				if (row >= 0) {
					selectedRow = row;
					switch (currentTable) {
					case 1:
						handleTable1Clicked(row);
						break;
					case 2:
						handleTable2Clicked(row);
						break;
					case 3:
						handleTable3Clicked(row);
						break;
					case 4:
						handleTable4Clicked(row);
						break;
					}
				}
			}
		});
		AircraftDAO dao1 = AircraftDAO.getDAO();
		dao1.setup();
		ManufacturerDAO dao2 = ManufacturerDAO.getDAO();
		dao2.setup();
		validation = new FormValidation();
	}

	protected void handleTable4Clicked(int row) {
		// TODO Auto-generated method stub

	}

	protected void handleTable3Clicked(int row) {
		// TODO Auto-generated method stub

	}

	protected void handleTable2Clicked(int row) {
		Manufacturer manufacturer = modelList2.get(row);
		textBox1.setText(manufacturer.getCompanyName());
		textBox2.setText(manufacturer.getAddress());
		textBox3.setText(manufacturer.getCity());
		textBox4.setText(manufacturer.getState());
		textBox5.setText(manufacturer.getZipcode());
		textBox6.setText(manufacturer.getPhone());
		textBox7.setText(manufacturer.getEmail());

	}

	protected void handleTable1Clicked(int row) {
		Aircraft aircraft = modelList1.get(row);
		textBox1.setText(aircraft.getManufacturer());
		textBox2.setText(aircraft.getAircraftName());
		textBox3.setText(aircraft.getAircraftType());
		textBox4.setText(aircraft.getRangeNM().toString());
		textBox5.setText(aircraft.getMaxCruiseSpeedKtas().toString());
		textBox6.setText(aircraft.getUsefulLoad().toString());
		textBox7.setText(aircraft.getNumPassengers().toString());
		textBox8.setText(aircraft.getEnginePower());
		textBox9.setText(aircraft.getEngineManufacturer());
		textBox10.setText(aircraft.getEngineModel());
		textBox11.setText(aircraft.getNumEngines().toString());
		textBox12.setText(aircraft.getLengthM().toString());
		textBox13.setText(aircraft.getHeightM().toString());
		textBox14.setText(aircraft.getWingSpanM().toString());
		textBox15.setText(aircraft.getServiceCeilingFt().toString());
	}

	private static void initTable1() {
		currentTable = 1;
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setModel(tableModel1);
		table.getColumnModel().getColumn(0).setCellRenderer(renderer);
		table.getColumnModel().getColumn(1).setCellRenderer(renderer);
		table.getColumnModel().getColumn(2).setCellRenderer(renderer);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 24));
		AircraftDAO dao = AircraftDAO.getDAO();
		modelList1 = dao.getAll();
		Collections.sort(modelList1);
		tableModel1.setAircraftList(modelList1);
		reset();
		tableModel1.fireTableDataChanged();
		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		label4.setVisible(true);
		label5.setVisible(true);
		label6.setVisible(true);
		label7.setVisible(true);
		label8.setVisible(true);
		label9.setVisible(true);
		label10.setVisible(true);
		label11.setVisible(true);
		label12.setVisible(true);
		label13.setVisible(true);
		label14.setVisible(true);
		label15.setVisible(true);
		label16.setVisible(false);
		label17.setVisible(false);
		label18.setVisible(false);
		label19.setVisible(false);
		label20.setVisible(false);
		label21.setVisible(false);
		label22.setVisible(false);
		label23.setVisible(false);
		label24.setVisible(false);
		textBox1.setVisible(true);
		textBox2.setVisible(true);
		textBox3.setVisible(true);
		textBox4.setVisible(true);
		textBox5.setVisible(true);
		textBox6.setVisible(true);
		textBox7.setVisible(true);
		textBox8.setVisible(true);
		textBox9.setVisible(true);
		textBox10.setVisible(true);
		textBox11.setVisible(true);
		textBox12.setVisible(true);
		textBox13.setVisible(true);
		textBox14.setVisible(true);
		textBox15.setVisible(true);
		textBox16.setVisible(false);
		textBox17.setVisible(false);
		textBox18.setVisible(false);
		textBox19.setVisible(false);
		textBox20.setVisible(false);
		textBox21.setVisible(false);
		textBox22.setVisible(false);
		textBox23.setVisible(false);
		textBox24.setVisible(false);
		label1.setText("Aircraft Manufacturer ");
		label2.setText("Aircraft Model ");
		label3.setText("Aircraft Type ");
		label4.setText("Range in NM ");
		label5.setText("Max Cruise Speed KTAS ");
		label6.setText("Useful Load in LBS ");
		label7.setText("Number of Passengers ");
		label8.setText("Engine Power Rating ");
		label9.setText("Engine Manufacturer ");
		label10.setText("Engine Model ");
		label11.setText("Number of Engines ");
		label12.setText("Length in Meters ");
		label13.setText("Height in Meters");
		label14.setText("WingSpan in Meters ");
		label15.setText("Aircraft Service Ceiling in FT ");
	}

	private void initTable2() {
		currentTable = 2;
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setModel(tableModel2);
		table.getColumnModel().getColumn(0).setCellRenderer(renderer);
		table.getColumnModel().getColumn(1).setCellRenderer(renderer);
		table.getColumnModel().getColumn(2).setCellRenderer(renderer);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 24));
		ManufacturerDAO dao = ManufacturerDAO.getDAO();
		modelList2 = dao.getAll();
		Collections.sort(modelList2);
		tableModel2.setManufacturerList(modelList2);
		reset();
		tableModel2.fireTableDataChanged();
		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		label4.setVisible(true);
		label5.setVisible(true);
		label6.setVisible(true);
		label7.setVisible(true);
		label8.setVisible(false);
		label9.setVisible(false);
		label10.setVisible(false);
		label11.setVisible(false);
		label12.setVisible(false);
		label13.setVisible(false);
		label14.setVisible(false);
		label15.setVisible(false);
		label16.setVisible(false);
		label17.setVisible(false);
		label18.setVisible(false);
		label19.setVisible(false);
		label20.setVisible(false);
		label21.setVisible(false);
		label22.setVisible(false);
		label23.setVisible(false);
		label24.setVisible(false);
		textBox1.setVisible(true);
		textBox2.setVisible(true);
		textBox3.setVisible(true);
		textBox4.setVisible(true);
		textBox5.setVisible(true);
		textBox6.setVisible(true);
		textBox7.setVisible(true);
		textBox8.setVisible(false);
		textBox9.setVisible(false);
		textBox10.setVisible(false);
		textBox11.setVisible(false);
		textBox12.setVisible(false);
		textBox13.setVisible(false);
		textBox14.setVisible(false);
		textBox15.setVisible(false);
		textBox16.setVisible(false);
		textBox17.setVisible(false);
		textBox18.setVisible(false);
		textBox19.setVisible(false);
		textBox20.setVisible(false);
		textBox21.setVisible(false);
		textBox22.setVisible(false);
		textBox23.setVisible(false);
		textBox24.setVisible(false);
		label1.setText("Manufacturer ");
		label2.setText("Address ");
		label3.setText("City ");
		label4.setText("State ");
		label5.setText("ZipCode ");
		label6.setText("Phone Number ");
		label7.setText("Email Address ");
	}

	private void initTable3() {
		/*
		 * currentTable = 3; 
		 */
	}

	private void initTable4() {
		/*
		 * currentTable = 4; 
		 */
	}

	private static void reset() {
		selectedRow = -1;
		textBox1.setText("");
		textBox2.setText("");
		textBox3.setText("");
		textBox4.setText("");
		textBox5.setText("");
		textBox6.setText("");
		textBox7.setText("");
		textBox8.setText("");
		textBox9.setText("");
		textBox10.setText("");
		textBox11.setText("");
		textBox12.setText("");
		textBox13.setText("");
		textBox14.setText("");
		textBox15.setText("");
		textBox16.setText("");
		textBox17.setText("");
		textBox18.setText("");
		textBox19.setText("");
		textBox20.setText("");
		textBox21.setText("");
		textBox22.setText("");
		textBox23.setText("");
		textBox24.setText("");
	}
}
