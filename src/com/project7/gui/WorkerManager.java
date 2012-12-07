package com.project7.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.project7.impl.EmployeesManager;

public class WorkerManager {

	private JFrame frame;
	private JTextField txtEmployeeID;
	public JTextField txtParam1;
	public JTextField txtParam2;
	public JLabel lblParam1;
	public JLabel lblParam2;
	EmployeesManager empMan = new EmployeesManager();
	public int payCode = 3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkerManager window = new WorkerManager();
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
	public WorkerManager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setTitle("Employee Management");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// creating Position Btns
		JPanel typeOfEmployee = new JPanel();
		typeOfEmployee.setBounds(36, 11, 373, 118);
		typeOfEmployee.setBorder(new TitledBorder(null, "Type of employee",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(typeOfEmployee);

		JRadioButton rdbtnComissionWorker = new JRadioButton("Comission Worker");
		rdbtnComissionWorker.setActionCommand("comissionWorker");
		rdbtnComissionWorker.setSelected(true);
		typeOfEmployee.add(rdbtnComissionWorker);

		JRadioButton rdbtnPieceWorker = new JRadioButton("Piece Worker");
		rdbtnPieceWorker.setActionCommand("pieceWorker");
		typeOfEmployee.add(rdbtnPieceWorker);

		JRadioButton rdbtnManager = new JRadioButton("Manager");
		rdbtnManager.setActionCommand("manager");
		typeOfEmployee.add(rdbtnManager);

		JRadioButton rdbtnHourlyWorker = new JRadioButton("Hourly Worker");
		rdbtnHourlyWorker.setActionCommand("hourlyWorker");
		typeOfEmployee.add(rdbtnHourlyWorker);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnHourlyWorker);
		group.add(rdbtnManager);
		group.add(rdbtnPieceWorker);
		group.add(rdbtnComissionWorker);
		
		EmployeeSelector radioBtnAction = new EmployeeSelector();
		rdbtnManager.addActionListener(radioBtnAction);
		rdbtnHourlyWorker.addActionListener(radioBtnAction);
		rdbtnComissionWorker.addActionListener(radioBtnAction);
		rdbtnPieceWorker.addActionListener(radioBtnAction);

		JPanel employeeInfo = new JPanel();
		employeeInfo.setBounds(36, 140, 400, 93);
		frame.getContentPane().add(employeeInfo);
		employeeInfo.setLayout(null);

		txtEmployeeID = new JTextField();
		txtEmployeeID.setBounds(140, 0, 150, 20);
		employeeInfo.add(txtEmployeeID);
		txtEmployeeID.setColumns(10);

		txtParam1 = new JTextField();
		txtParam1.setBounds(140, 31, 150, 20);
		employeeInfo.add(txtParam1);
		txtParam1.setColumns(10);

		txtParam2 = new JTextField();
		txtParam2.setBounds(140, 62, 150, 20);
		employeeInfo.add(txtParam2);
		txtParam2.setVisible(false);
		txtParam2.setColumns(10);

		JLabel lblEmplyeeId = new JLabel("Employee ID");
		lblEmplyeeId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmplyeeId.setBounds(32, 1, 100, 17);
		employeeInfo.add(lblEmplyeeId);

		lblParam1 = new JLabel("Weekly Sales");
		lblParam1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblParam1.setBounds(32, 32, 100, 17);
		employeeInfo.add(lblParam1);
		
		lblParam2 = new JLabel("");
		lblParam2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblParam2.setBounds(32, 63, 100, 17);
		lblParam2.setVisible(false);
		employeeInfo.add(lblParam2);

		JPanel buttons = new JPanel();
		buttons.setBounds(58, 244, 335, 107);
		frame.getContentPane().add(buttons);

		JButton btnAdd = new JButton("Add Employee");
		btnAdd.setActionCommand("add");
		buttons.add(btnAdd);

		JButton btnWrite = new JButton("Write Report to File");
		btnWrite.setActionCommand("write");
		buttons.add(btnWrite);

		JButton btnDisplay = new JButton("Display Summary Pay Report");
		btnDisplay.setActionCommand("display");
		buttons.add(btnDisplay);

		JButton btnRead = new JButton("Read From File");
		btnRead.setActionCommand("read");
		buttons.add(btnRead);

		JButton btnExit = new JButton("Exit");
		btnExit.setActionCommand("exit");
		buttons.add(btnExit);

		ButtonListener buttonAction = new ButtonListener();
		btnAdd.addActionListener(buttonAction);
		btnDisplay.addActionListener(buttonAction);
		btnWrite.addActionListener(buttonAction);
		btnRead.addActionListener(buttonAction);
		btnExit.addActionListener(buttonAction);
	}
	
	private class EmployeeSelector implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "manager" : {
				payCode = 1;
				lblParam1.setText("Salary");
				if(lblParam2.isVisible()||txtParam2.isVisible()) {
					lblParam2.setVisible(false);
					txtParam2.setVisible(false);
				}
				break;
			}
			case "hourlyWorker" : {
				payCode = 2;
				lblParam1.setText("Payrate");
				lblParam2.setText("Hours Worked");
				if(!lblParam2.isVisible()||!txtParam2.isVisible()) {
					lblParam2.setVisible(true);
					txtParam2.setVisible(true);
				}
				break;
			}
			case "comissionWorker" : {
				payCode = 3;
				lblParam1.setText("Weekly Sales");
				if(lblParam2.isVisible()||txtParam2.isVisible()) {
					lblParam2.setVisible(false);
					txtParam2.setVisible(false);
				}
				break;
			}
			case "pieceWorker" : {
				payCode = 4;
				lblParam1.setText("Piece Rate");
				lblParam2.setText("# Pieces");
				if(!lblParam2.isVisible()||!txtParam2.isVisible()) {
					lblParam2.setVisible(true);
					txtParam2.setVisible(true);
				}
				break;
			}
			}
			
		}
		
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			switch (e.getActionCommand()) {
			case "add": {
				if (payCode == 1 || payCode == 3){
					txtParam2.setText("0");
					empMan.addEmployee(payCode, Double.parseDouble(txtParam1.getText()), 
							Integer.parseInt(txtParam2.getText()), Integer.parseInt(txtEmployeeID.getText()));
				}
				else if(payCode == 2 || payCode == 4){
					empMan.addEmployee(payCode, Double.parseDouble(txtParam1.getText()), 
							Integer.parseInt(txtParam2.getText()), Integer.parseInt(txtEmployeeID.getText()));
				}
				break;
			}
			case "display":
				display();
				break;
			case "write":
				writeToFile();
				break;
			case "read":
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setAcceptAllFileFilterUsed(false);
				if (chooser.showOpenDialog(chooser) == JFileChooser.APPROVE_OPTION) {
				} else {
					System.out.println("No Selection ");
				}
				readFile(chooser.getCurrentDirectory(),
						chooser.getSelectedFile());
				break;
			case "exit":
				frame.dispose();
				break;
			}
		}

		public void display() {
			// This here should read from the ArrayList...
			StringBuffer sb = new StringBuffer();
			sb.append("WEEKLY PAY REPORT FOR WIDGET COMPANY\n\n");
			sb.append("EMPLOYEE\t\t\t WEEKLY PAY\n");
			/*for (int i = 0; i < 5; i++) {
				sb.append("\t" + i + "\t\t\t\t\t 200\n");// Here this should be
															// calculated based
															// on the type
															// worker
			}
			sb.append("\nTotal payroll: $3,517.50");
			sb.append("\nTotal number of Managers paid:\t 1");
			sb.append("\nTotal number of Hourly Workers paid:\t 2");
			sb.append("\nTotal number of Commission Workers paid:\t 1");
			sb.append("\nTotal number of Piece Workers paid:\t 1");
			JOptionPane.showMessageDialog(null, sb, "Message",
					JOptionPane.INFORMATION_MESSAGE);*/
		}

		public void readFile(File directory, File selectedFile) {
			// This here should write to the ArrayList();
			BufferedReader br = null;
			String firstParam;
			String secondParam;
			String thirdParam;
			try {
				br = new BufferedReader(new FileReader(selectedFile));
				String line = null;
				while ((line = br.readLine()) != null) {
					String[] values = line.split(" ");
					if (values.length > 1) {
						firstParam = values[0];
						secondParam = values[1];
						thirdParam = values[2];
						if (firstParam.equals("4") || firstParam.equals("2")) {
						} else if (firstParam.equals("1")){
							empMan.addEmployee(1, Double.parseDouble(secondParam),
									0, Integer.parseInt(thirdParam));
						} else {
							empMan.addEmployee(2, Double.parseDouble(secondParam),
									0, Integer.parseInt(thirdParam));
						}
					}
					
				}
				empMan.getNumManager();
			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				try {
					if (br != null)
						br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}

		public void writeToFile() {
			// This here should write to the file and read from the ArrayList...
			try {
				// Create file
				FileWriter fstream = new FileWriter("Weekly Report.txt");
				BufferedWriter out = new BufferedWriter(fstream);
				out.write("WEEKLY PAY REPORT FOR WIDGET COMPANY\n\n");
				out.write("EMPLOYEE\t\t\t WEEKLY PAY\n");
				// for or foreach loop for the ArrayList
				/*for (int i = 0; i < 5; i++) {
					out.write("\t" + i + "\t\t\t\t\t 200\n");
				}
				out.write("\nTotal payroll: $3,517.50");
				out.write("\nTotal number of Managers paid:\t 1");
				out.write("\nTotal number of Hourly Workers paid:\t 2");
				out.write("\nTotal number of Commission Workers paid:\t 1");
				out.write("\nTotal number of Piece Workers paid:\t 1");*/

				// Close the output stream
				out.close();
			} catch (Exception e) {// Catch exception if any
				System.err.println("Error: " + e.getMessage());
			}
		}
	}

}
