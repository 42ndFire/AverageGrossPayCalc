/*Patrick Cole
 * 10/18/18
 * Average Gross Pay Calculator
 */
package GrossPayCalculator.views;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GrossPayCalculator.common.CalculateGrossPay;

import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import java.awt.Color;

public class GrossPayCalculatorGUI extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3460723580562392399L;
	private JPanel ctpMain;
	private JButton btnCalculate;
	private JButton btnReset;
	private JButton btnExit;
	private JButton btnFunButton;
	private JLabel lblHourlyPay;
	private JLabel lblHoursWorked;
	private JLabel lblStateTax;
	private JLabel lblPaymentSchedule;
	private JLabel lblGrossPay;
	private JLabel lblNetPay;
	private JLabel lblGrossPayValue;
	private JLabel lblNetPayValue;
	private JTextField txtHoursWorked;
	private JTextField txtStateTax;
	private JTextField txtHourlyWage;
	private JRadioButton radWeekly;
	private JRadioButton radBiweekly;
	private JRadioButton radTriweekly;
	private JRadioButton radMonthly;
	private CalculateGrossPay grossPay;
	DecimalFormat f = new DecimalFormat("##.00");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					GrossPayCalculatorGUI frame = new GrossPayCalculatorGUI();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public GrossPayCalculatorGUI() 
	{
		setBackground(new Color(240, 240, 240));
		grossPay = new CalculateGrossPay();
		initComponents();
		createEvents();
	}
	//This method contains all the code for creating and initializing components
	private void initComponents() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 350);
		ctpMain = new JPanel();
		ctpMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ctpMain);
		lblHourlyPay = new JLabel("Hourly Wage:");
		txtHourlyWage = new JTextField();
		txtHourlyWage.setColumns(10);
		
		btnCalculate = new JButton("Calculate!");
		
		lblHoursWorked = new JLabel("Weekly Hours:");
		
		txtHoursWorked = new JTextField();
		txtHoursWorked.setColumns(10);
		
		lblStateTax = new JLabel("State Tax:");
		
		txtStateTax = new JTextField();
		txtStateTax.setColumns(10);
		
		lblPaymentSchedule = new JLabel("Payment Schedule:");
		
		radWeekly = new JRadioButton("Weekly");
		radWeekly.setSelected(true);
		
		radBiweekly = new JRadioButton("Bi-weekly");
		
		radTriweekly = new JRadioButton("Tri-weekly");
		
		radMonthly = new JRadioButton("Monthly");
		
		ButtonGroup payScheduleGroup = new ButtonGroup();
		payScheduleGroup.add(radWeekly);
		payScheduleGroup.add(radBiweekly);
		payScheduleGroup.add(radTriweekly);
		payScheduleGroup.add(radMonthly);
		
		JSeparator separator = new JSeparator();
		
		lblGrossPay = new JLabel("Gross pay:");
		
		lblNetPay = new JLabel("Net pay:");
		
		lblGrossPayValue = new JLabel("");
		
		lblNetPayValue = new JLabel("");
		
		btnReset = new JButton("Reset");
		
		btnExit = new JButton("Exit");
		
		btnFunButton = new JButton("Fun Button");
		GroupLayout gl_ctpMain = new GroupLayout(ctpMain);
		gl_ctpMain.setHorizontalGroup(
			gl_ctpMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ctpMain.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_ctpMain.createSequentialGroup()
									.addGroup(gl_ctpMain.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblStateTax)
										.addComponent(lblHoursWorked)
										.addComponent(lblHourlyPay))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
										.addComponent(txtHourlyWage, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
										.addComponent(txtStateTax, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
										.addComponent(txtHoursWorked, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)))
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_ctpMain.createSequentialGroup()
									.addGap(10)
									.addComponent(radWeekly)
									.addGap(18)
									.addComponent(radBiweekly)
									.addGap(18)
									.addComponent(radTriweekly)
									.addGap(18)
									.addComponent(radMonthly))))
						.addComponent(lblPaymentSchedule)
						.addGroup(gl_ctpMain.createSequentialGroup()
							.addComponent(btnCalculate, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnExit)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnFunButton))
						.addGroup(gl_ctpMain.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_ctpMain.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNetPay)
								.addComponent(lblGrossPay))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNetPayValue)
								.addComponent(lblGrossPayValue))))
					.addContainerGap())
		);
		gl_ctpMain.setVerticalGroup(
			gl_ctpMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHourlyPay)
						.addComponent(txtHourlyWage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHoursWorked)
						.addComponent(txtHoursWorked, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtStateTax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStateTax))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPaymentSchedule)
					.addGap(8)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(radWeekly)
						.addComponent(radBiweekly)
						.addComponent(radTriweekly)
						.addComponent(radMonthly))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblGrossPayValue)
						.addComponent(lblGrossPay))
					.addGap(32)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNetPay)
						.addComponent(lblNetPayValue))
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCalculate)
						.addComponent(btnReset, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExit)
						.addComponent(btnFunButton))
					.addContainerGap())
		);
		ctpMain.setLayout(gl_ctpMain);
		setTitle("Average Gross Pay Calculator");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GrossPayCalculatorGUI.class.getResource("/GrossPayCalculator/resources/dollarIcon_24.png")));
	}

	//This method contains all the code for creating events
	private void createEvents() 
	{
		btnCalculate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				grossPay.setHourlyWage(grossPay.validInput(txtHourlyWage.getText()));
				grossPay.setNumHours(grossPay.validInput(txtHoursWorked.getText()));
				grossPay.setStateTax(grossPay.validInput(txtStateTax.getText()));
				if(grossPay.getHourlyWage() == 0) 
				{
					JOptionPane.showMessageDialog(null, "You entered an invalid amount for hourly wage.");
				}
				else if(grossPay.getNumHours() == 0)
				{
					JOptionPane.showMessageDialog(null, "You entered an invalid amount for weekly hours.");
				}
				else if(grossPay.getStateTax() == 0)
				{
					JOptionPane.showMessageDialog(null, "You entered an invalid amount for state tax. (Please enter as a decimal, not percent)");
				}
				else if(grossPay.getPaySchedule() == null)
				{
					JOptionPane.showMessageDialog(null, "Please select one of the given payment plans.");
				}
				else
				{
					lblGrossPayValue.setEnabled(true);
					lblGrossPayValue.setText("Your average gross pay for one year is: $" + f.format((grossPay.calcPay()[0])));
					lblNetPayValue.setEnabled(true);
					lblNetPayValue.setText("Your average net pay for one year is: $" + f.format((grossPay.calcPay()[1])));
				}
			}
		});
		
		btnReset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				txtHourlyWage.setText("");
				txtHoursWorked.setText("");
				txtStateTax.setText("");
				radWeekly.setSelected(true);
				lblGrossPayValue.setText("");
				lblNetPayValue.setText("");
				ctpMain.setBackground(new Color(240, 240, 240));
				txtHourlyWage.setBackground(new Color(255, 255, 255));
				txtHoursWorked.setBackground(new Color(255, 255, 255));
				txtStateTax.setBackground(new Color(255, 255, 255));
				radWeekly.setBackground(new Color(240, 240, 240));
				radBiweekly.setBackground(new Color(240, 240, 240));
				radTriweekly.setBackground(new Color(240, 240, 240));
				radMonthly.setBackground(new Color(240, 240, 240));
				btnCalculate.setForeground(new Color(0,0,0));
				btnReset.setForeground(new Color(0,0,0));
				btnExit.setForeground(new Color(0,0,0));
				btnFunButton.setForeground(new Color(0,0,0));
			}
		});
		
		btnExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource() == btnExit) 
				{
					System.exit(0);
				}
			}

		});
		
		btnFunButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ctpMain.setBackground(new Color(0, 255, 0));
				txtHourlyWage.setBackground(new Color(255, 255, 0));
				txtHoursWorked.setBackground(new Color(255, 255, 0));
				txtStateTax.setBackground(new Color(255, 255, 0));
				radWeekly.setBackground(new Color(0, 255, 255));
				radBiweekly.setBackground(new Color(0, 255, 255));
				radTriweekly.setBackground(new Color(0, 255, 255));
				radMonthly.setBackground(new Color(0, 255, 255));
				btnCalculate.setForeground(new Color(200,0,255));
				btnReset.setForeground(new Color(200,0,255));
				btnExit.setForeground(new Color(200,0,255));
				btnFunButton.setForeground(new Color(200,0,255));
			}
		});
		
		radWeekly.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				grossPay.setPaySchedule("1");
			}
		});
		
		radBiweekly.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				grossPay.setPaySchedule("2");
			}
		});
		
		radTriweekly.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				grossPay.setPaySchedule("3");
			}
		});
		
		radMonthly.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				grossPay.setPaySchedule("4");
			}
		});
	}
}
