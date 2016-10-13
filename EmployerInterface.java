//OGUNSANYA TOLUWANI DAMILOLA 2015080192
//THE MOBILE BANK
//ICS4u prd 5

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class EmployerInterface extends JFrame
{

    private String answer = " ";
    private int length, lengthT;
    private JPanel panel1, panel2, panel3, panel4;
    private JTextField searchField;
    private JLabel search;
    private JButton searchButton, viewEmployees, hire, viewReport, back, exit, delete;
    private String employees = "Employees.txt";
    private String[] employeeList = new String [50];
    private String list = "";
    private JTextArea text;
    private start z;
    private String test = " ";
    private double[] [] finances;
    private double tDeposits = 0;
    private double tWithdrawals = 0;
    private String report;
    String users[] = {"mike", "cindy", "rover"};
    String results[];
    int s = 0;



    public EmployerInterface ()
    {

	buildInterface ();
	setEmployees ();
	arrange ();

	finances ();

	setTitle ("THE MOBILE BANK");
	setDefaultCloseOperation (EXIT_ON_CLOSE);
	setSize (500, 700);
	getContentPane ().setLayout (new BorderLayout ());

	text = new JTextArea (20, 15);
	text.setEditable (false);

	panel4 = new JPanel ();
	panel4.setBackground (Color.LIGHT_GRAY);

	getContentPane ().setBackground (Color.LIGHT_GRAY);

	panel4.add (delete);
	panel4.add (back);
	panel4.add (exit);

	getContentPane ().add (panel1, BorderLayout.NORTH);
	getContentPane ().add (panel2, BorderLayout.CENTER);
	getContentPane ().add (text, BorderLayout.EAST);
	getContentPane ().add (panel4, BorderLayout.SOUTH);


	setVisible (true);


    }


    public void buildInterface ()
    {
	panel1 = new JPanel ();
	panel1.setLayout (new BorderLayout ());
	panel1.setBackground (Color.LIGHT_GRAY);

	panel2 = new JPanel ();
	panel2.setLayout (new BorderLayout ());
	panel2.setBackground (Color.LIGHT_GRAY);

	panel3 = new JPanel ();
	panel3.setLayout (new BorderLayout ());
	panel3.setBackground (Color.LIGHT_GRAY);

	searchButton = new JButton ("SEARCH");
	searchButton.addActionListener (new buttonListener ());
	searchButton.setBackground (Color.CYAN);
	searchButton.setForeground (Color.BLACK);


	searchField = new JTextField (20);

	search = new JLabel ("SEARCH EMPLOYEES");

	viewEmployees = new JButton ("VIEW EMPLOYEES");
	viewEmployees.addActionListener (new buttonListener ());
	viewEmployees.setBackground (Color.CYAN);
	viewEmployees.setForeground (Color.BLACK);

	back = new JButton ("BACK");
	back.addActionListener (new buttonListener ());
	back.setBackground (Color.CYAN);
	back.setForeground (Color.BLACK);

	exit = new JButton ("EXIT");
	exit.addActionListener (new buttonListener ());
	exit.setBackground (Color.CYAN);
	exit.setForeground (Color.BLACK);


	delete = new JButton ("DELETE EMPLOYEE");
	delete.addActionListener (new buttonListener ());
	delete.setBackground (Color.CYAN);
	delete.setForeground (Color.BLACK);



	hire = new JButton ("HIRE EMPLOYEES");
	hire.addActionListener (new buttonListener ());
	hire.setBackground (Color.CYAN);
	hire.setForeground (Color.BLACK);


	viewReport = new JButton ("VIEW FINANCIAL REPORT");
	viewReport.addActionListener (new buttonListener ());
	viewReport.setBackground (Color.CYAN);
	viewReport.setForeground (Color.BLACK);


	panel1.add (search, BorderLayout.NORTH);
	panel1.add (searchField, BorderLayout.CENTER);
	panel1.add (searchButton, BorderLayout.SOUTH);

	panel2.add (viewEmployees, BorderLayout.NORTH);
	panel2.add (hire, BorderLayout.CENTER);
	panel2.add (viewReport, BorderLayout.SOUTH);


    }


    public void setEmployees ()
    {
	try
	{
	    BufferedReader infile = new BufferedReader (new FileReader (employees));

	    String str = infile.readLine ();
	    length = Integer.parseInt (str);

	    for (int x = 0 ; x < length ; x++)
	    {
		employeeList [x] = infile.readLine ();
	    }

	}
	catch (IOException e)
	{
	    JOptionPane.showMessageDialog (null, "FILE NOT FOUND");

	}
    }


    public void write ()
    {
	try
	{
	    PrintWriter infile = new PrintWriter (new FileWriter ("Employees.txt"));

	    infile.println (length);

	    for (int v = 0 ; v < length ; v++)
	    {

		infile.println (employeeList [v]);

	    }
	    infile.close ();
	}

	catch (IOException e)
	{
	    JOptionPane.showMessageDialog (null, "FILE NOT FOUND");
	}

    }


    public void finances ()
    {
	try
	{
	    BufferedReader infile = new BufferedReader (new FileReader ("info.txt"));

	    String str = infile.readLine ();
	    lengthT = Integer.parseInt (str);
	    finances = new double [lengthT] [2];

	    for (int v = 0 ; v < lengthT ; v++)
	    {
		for (int c = 0 ; c < 4 ; c++)
		{
		    str = infile.readLine ();
		}

		for (int c = 0 ; c < 2 ; c++)
		{
		    str = infile.readLine ();
		    finances [v] [c] = Double.parseDouble (str);
		}

		str = infile.readLine ();

	    }

	    int n = 0;

	    while (n == 0)
	    {
		for (int m = 0 ; m < finances.length ; m++)
		{
		    tDeposits += finances [m] [n];
		}
		n++;
	    }

	    while (n == 1)
	    {
		for (int m = 0 ; m < finances.length ; m++)
		{
		    tWithdrawals += finances [m] [n];
		}
		n++;
	    }
	}

	catch (IOException e)
	{
	    JOptionPane.showMessageDialog (null, "FILE NOT FOUND");
	}

    }


    public void arrange ()
    {
	String old, now;
	for (int x = 0 ; x < length - 1 ; x++)
	{
	    for (int y = x + 1 ; y < length ; y++)
	    {
		if (employeeList [x].compareTo (employeeList [y]) > 0)
		{
		    old = employeeList [x];
		    now = employeeList [y];

		    employeeList [x] = now;
		    employeeList [y] = old;
		}
	    }
	}
    }



    public void searchMethod ()
    {
	for (int row = 0 ; row < length ; row++)
	{
	    if (test.equalsIgnoreCase (employeeList [row]))
	    {
		answer = "\n" + employeeList [row];
	    }
	}
	text.setText (answer);
    }


    public void singleSearch ()
    {
	int valu = 0;
	int count = 0;
	int i = 0;
	String word = searchField.getText ();
	int siz;
	String wordCap = word.toUpperCase ();
	String wordLow = word.toLowerCase ();

	char val, valT;

	results = new String [length];

	/** for (int row = 0 ; row < length ; row++)
	 {

	     System.out.println (employeeList [row]);
	 }
	 */
	siz = word.length ();

	for (int index = 0 ; index < length ; index++)
	{
	    count = 0;
	    for (int y = 0 ; y < siz ; y++)
	    {
		if (y < employeeList [index].length ())
		{
		    val = employeeList [index].charAt (y);

		    if (word.charAt (y) == val || wordCap.charAt (y) == val)
		    {
			count++;
		    }
		}
	    }

	    if (count == siz)
	    {
		results [i] = employeeList [index];
		i++;
	    }
	}

	answer = " ";
	for (int row = 0 ; row < i ; row++)
	{
	    if (results [row] != null)
	    {
		answer = answer + "\n" + (valu + 1) + ". " + results [row];
		valu++;
	    }

	}

	if (answer.equals (" "))
	    JOptionPane.showMessageDialog (null, "NOT FOUND");
    }




    /** for (int row = 0 ; row < length ; row++)
     {
	 if (results[row] != null)
	 System.out.println ("\n" + results [row]);
     }*/




    public void report ()
    {
	report = "FINANCIAL REPORT\n----------------------------"
	    + "\nCUSTOMER DEPOSITS: $ " + tDeposits + "\nCUSTOMER WITHDRAWALS: $ " + tWithdrawals;
    }


    public void getEmployees ()
    {
	int valu = 0;
	for (int x = 0 ; x < length ; x++)
	{
	    list = list + "\n" + (valu + 1) + ". " + employeeList [x];
	    valu++;
	}
    }


    public void hire ()
    {
	String input;

	input = JOptionPane.showInputDialog ("ENTER EMPLOYEE NAME: ");


	if (input != null)
	{
	    employeeList [length] = input;
	    length++;
	}


	arrange ();
	write ();
    }


    public void editList (int input)
    {
	for (int i = input ; i < length ; i++)
	{
	    employeeList [i] = employeeList [i + 1];

	}


	write ();
	view ();
    }


    public void view ()
    {
	list = " ";
	getEmployees ();
	text.setText (null);
	text.setText (list);

    }


    public class buttonListener implements ActionListener
    {
	public void actionPerformed (ActionEvent e)
	{
	    if (e.getSource () == viewEmployees)
	    {
		view ();
	    }

	    if (e.getSource () == back)
	    {
		setVisible (false);
		z = new start ();
	    }

	    if (e.getSource () == exit)
	    {
		System.exit (0);
	    }

	    if (e.getSource () == searchButton)
	    {
		// test = searchField.getText();
		//searchMethod();
		singleSearch ();
		text.setText (answer);

	    }

	    if (e.getSource () == viewReport)
	    {

		report ();
		text.setText (report);
	    }

	    if (e.getSource () == hire)
	    {
		hire ();
		write ();
		view ();

	    }


	    if (e.getSource () == delete)
	    {
		String input;
		int index;

		input = JOptionPane.showInputDialog ("ENTER EMPLOYEE NUMBER");

		try
		{
		    if (input != null)
		    {
			index = Integer.parseInt (input) - 1;

			employeeList [index] = null;

			length--;

			editList (index);
		    }
		}

		catch (NumberFormatException b)
		{
		    JOptionPane.showMessageDialog (null, "PLEASE ENTER A NUMBER\nBETWEEN 1 AND " + length);
		}
	    }
	}
    }
}
