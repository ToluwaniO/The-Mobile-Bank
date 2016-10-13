//OGUNSANYA TOLUWANI DAMILOLA 2015080192
//THE MOBILE BANK
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class start extends JFrame
{

    private JButton next, close;
    private JPanel mainPanel, welcomePanel, infoPanel, userPanel;
    private JLabel info;
    private JRadioButton customer, employer, employee;
    ButtonGroup bg;
    Customer page1;
    Employer page2;
    Bonanza page3;
    EmployerInterface page4;
    static String[] passwords = new String [3];

    public start ()
    {
	setTitle ("THE MOBILE BANK");
	setSize (700, 350);
	getContentPane ().setLayout (new BorderLayout ());

	setDefaultCloseOperation (EXIT_ON_CLOSE);

	welcomePage ();
	info ();
	userType ();

	mainPanel = new JPanel ();
	mainPanel.add (infoPanel, BorderLayout.SOUTH);
	mainPanel.add (userPanel, BorderLayout.NORTH);
	mainPanel.add (welcomePanel, BorderLayout.CENTER);

	getContentPane ().add (mainPanel);

	mainPanel.setBackground (Color.WHITE);


	setVisible (true);
    }


    public void welcomePage ()
    {
	welcomePanel = new JPanel ();

	next = new JButton ("Next");
	next.setBackground (Color.CYAN);

	close = new JButton ("Exit");
	close.setBackground (Color.CYAN);


	next.addActionListener (new buttonListener ());
	close.addActionListener (new buttonListener ());

	welcomePanel.setBackground (Color.WHITE);

	welcomePanel.add (next);
	welcomePanel.add (close);
	welcomePanel.setBackground (Color.WHITE);

    }


    /**
     *
     */


    private class buttonListener implements ActionListener
    {
	public void actionPerformed (ActionEvent e)
	{
	    if (e.getSource () == next && customer.isSelected ())
	    {
		page1 = new Customer ();
		setVisible (false);

	    }

	    if (e.getSource () == next && employer.isSelected ())
	    {
		page4 = new EmployerInterface ();
		setVisible (false);
	    }

	    if (e.getSource () == next && employee.isSelected ())
	    {
		page3 = new Bonanza ();
		setVisible (false);
	    }

	    if (e.getSource () == close)
		System.exit (0);
	}
    }


    public void info ()
    {
	infoPanel = new JPanel ();

	info = new JLabel ("WELCOME TO THE MOBILE BANK.");

	infoPanel.add (info);
	infoPanel.setBackground (Color.WHITE);
    }


    public void userType ()
    {
	userPanel = new JPanel ();
	customer = new JRadioButton ("CUSTOMER", true);
	employer = new JRadioButton ("ADMIN");
	employee = new JRadioButton ("BONANZA");

	bg = new ButtonGroup ();

	bg.add (customer);
	bg.add (employer);
	bg.add (employee);

	userPanel.add (customer);
	userPanel.add (employer);
	userPanel.add (employee);
	
	userPanel.setBackground(Color.CYAN);

	getContentPane ().setBackground (Color.WHITE);

    }
}
