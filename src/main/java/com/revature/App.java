package com.revature;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import com.revature.soap.AircraftPublisher;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class App extends javax.swing.JFrame {

	private static final long serialVersionUID = -6769450683104970026L;
	private JPanel contentPane;
	private static App frame;
	JLabel soapLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		AircraftPublisher.publish();
		/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		});*/
	}

	/**
	 * Create the frame.
	 */
	public App() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton databaseButton = new JButton("Edit Database");
		databaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				DatabaseUI ui = new DatabaseUI();
				ui.setVisible(true);
			}
		});
		databaseButton.setBounds(144, 26, 156, 39);
		contentPane.add(databaseButton);

		final JToggleButton tglbtnSoap = new JToggleButton("Start SOAP SVC");
		tglbtnSoap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JToggleButton tBtn = (JToggleButton) e.getSource();
				if (tBtn.isSelected()) {
					soapLabel.setVisible(true);
					tglbtnSoap.setText("SOAP SVC Running");
					AircraftPublisher.publish();
				} else {
					soapLabel.setVisible(false);
					tglbtnSoap.setText("Start SOAP SVC");
					AircraftPublisher.stopPublisher();
				}
			}
		});
		tglbtnSoap.setBounds(144, 95, 156, 39);
		contentPane.add(tglbtnSoap);

		soapLabel = new JLabel("http://localhost:8080/aircraft");
		soapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		soapLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		soapLabel.setBounds(125, 145, 208, 22);
		contentPane.add(soapLabel);
	}
}
