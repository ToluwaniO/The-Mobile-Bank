//OGUNSANYA TOLUWANI DAMILOLA 2015080192
//THE MOBILE BANK
//ICS4U prd 5

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CustomerAccount extends JFrame
{

    int x = 0;
    int y = 0;
    String input;
    int wFileSize, dFileSize;

    private JLabel withdraw, deposit, balance, transaction;
    private JButton signOut, delete, edit;
    private JComboBox options;
    private JTextField wd, dp, bal;
    private JPanel panel1, panel2, panel3, panel5;
    int idNo;
    private final String data = "C:\\Users\\Awesome-Tbee\\Documents\\NetBeansProjects"
	+ "\\The Mobile Bank\\src\\the\\mobile\\bank\\CustomerNames.txt";
    private JPanel profilePanel;
    private JLabel name, acctNo, pic, gender;
    ImageIcon image;
    private String[] dataArray = new String [6];
    private String[] [] cusFiles = new String [3] [3];
    private double[] withdrawals = new double [50];
    private double[] deposits = new double [50];
    private double tDeposit = 0;
    private double tWithdrawn = 0;
    Customer a;
    String[] [] customers;
    int d, fileSize;

    public CustomerAccount ()
    {
	d = 0;
    }


    public CustomerAccount (int size, int c, String[] [] b)
    {
	customers = b;
	d = c;
	fileSize = size;
    }


    public CustomerAccount (String idN)
    {
	idNo = Integer.parseInt (idN);

	setTitle ("THE MOBILE BANK");
	setSize (700, 700);
	setDefaultCloseOperation (EXIT_ON_CLOSE);

	getContentPane ().setLayout (new BorderLayout ());

	buildInterface ();
	profile ();



	getContentPane ().add (profilePanel, BorderLayout.NORTH);
	getContentPane ().add (panel3, BorderLayout.CENTER);
	getContentPane ().add (bal, BorderLayout.SOUTH);

	getContentPane().setBackground (Color.WHITE);


	pack ();
	setVisible (true);
    }


    public void start ()
    {
	setTitle ("THE MOBILE BANK");
	setSize (700, 700);
	setDefaultCloseOperation (EXIT_ON_CLOSE);

	getContentPane ().setLayout (new BorderLayout ());

	buildInterface ();


	profile ();

	panel5 = new JPanel ();
	signOut = new JButton ("SIGN OUT");
	signOut.addActionListener (new buttonListener ());
	signOut.setBackground (Color.CYAN);


	delete = new JButton ("DELETE ACCOUNT");
	delete.addActionListener (new buttonListener ());
	delete.setBackground (Color.CYAN);


	edit = new JButton ("EDIT PROFILE");
	edit.addActionListener (new buttonListener ());
	edit.setBackground (Color.CYAN);


	panel5.add (signOut);
	panel5.add (delete);
	panel5.add (edit);

	panel5.setBackground (Color.WHITE);

	getContentPane ().add (profilePanel, BorderLayout.NORTH);
	getContentPane ().add (panel3, BorderLayout.CENTER);
	getContentPane ().add (bal, BorderLayout.SOUTH);
	getContentPane ().add (panel5, BorderLayout.EAST);

	setVisible (true);
    }


    public void profile ()
    {
	profilePanel = new JPanel ();

	name = new JLabel ("NAME: " + dataArray [0]);
	acctNo = new JLabel ("ACCOUNT NO: " + dataArray [1]);
	gender = new JLabel ("GENDER: " + dataArray [2]);

	image = new ImageIcon (dataArray [3]);
	pic = new JLabel (null, image, SwingConstants.RIGHT);

	profilePanel.setLayout (new BorderLayout ());

	profilePanel.add (name, BorderLayout.NORTH);
	profilePanel.add (acctNo, BorderLayout.SOUTH);
	profilePanel.add (pic, BorderLayout.EAST);
	profilePanel.add (gender, BorderLayout.CENTER);

	profilePanel.setBackground (Color.WHITE);


    }


    public void buildInterface ()
    {
	String[] opt = {"DEPOSIT", "WITHDRAW", "TRANSFER"};

	withdraw = new JLabel ("WITHDRAWN:");
	deposit = new JLabel ("DEPOSIT:");
	transaction = new JLabel ("MAKE TRANSACTION:");
	balance = new JLabel ("BALANCE:");

	wd = new JTextField (25);
	wd.setText ("$" + dataArray [5]);
	wd.setEditable (false);

	dp = new JTextField (25);
	dp.setText ("$" + dataArray [4]);
	dp.setEditable (false);

	bal = new JTextField (25);
	bal.setText ("$" + String.valueOf (tDeposit - tWithdrawn));
	bal.setEditable (false);

	options = new JComboBox (opt);
	options.setBackground (Color.WHITE);

	options.addActionListener (new comboBoxListener ());

	panel1 = new JPanel ();
	panel2 = new JPanel ();
	panel3 = new JPanel ();

	panel1.setLayout (new BorderLayout ());
	panel2.setLayout (new BorderLayout ());
	panel3.setLayout (new BorderLayout ());

	panel1.add (withdraw, BorderLayout.NORTH);
	panel1.add (wd, BorderLayout.CENTER);
	panel1.add (deposit, BorderLayout.SOUTH);
	panel2.add (dp, BorderLayout.NORTH);
	panel2.add (transaction, BorderLayout.CENTER);
	panel2.add (options, BorderLayout.SOUTH);
	panel3.add (panel1, BorderLayout.NORTH);
	panel3.add (panel2, BorderLayout.CENTER);
	panel3.add (balance, BorderLayout.SOUTH);

	panel1.setBackground (Color.WHITE);
	panel2.setBackground (Color.WHITE);
	panel3.setBackground (Color.WHITE);



    }


    public void setName (String name)
    {
	dataArray [0] = name;
    }


    public void setAcctNo (String act)
    {
	dataArray [1] = act;
    }


    public void setGender (String gen)
    {
	dataArray [2] = gen;
    }


    public void setProfilePic (String path)
    {
	dataArray [3] = path;
    }


    public void deposit (String dp)
    {
	dataArray [4] = dp;
	tDeposit = Double.parseDouble (dataArray [4]);
    }


    public void deposit (double dp)
    {
	tDeposit += dp;
	dataArray [4] = String.valueOf (tDeposit);
	customers [d] [4] = dataArray [4];
    }


    public void withdraw (String wd)
    {
	dataArray [5] = wd;
	tWithdrawn = Double.parseDouble (dataArray [5]);
    }


    public void withdraw (double wd)
    {

	tWithdrawn += wd;
	dataArray [5] = String.valueOf (tWithdrawn);
	customers [d] [5] = dataArray [5];
    }


    public void deposits ()
    {

	try
	{
	    BufferedReader infile = new BufferedReader (new FileReader (cusFiles [idNo] [1]));

	    String str = infile.readLine ();
	    dFileSize = Integer.parseInt (str);

	    for (y = 0 ; y < (dFileSize) ; y++)
	    {
		str = infile.readLine ();
		deposits [y] = Double.parseDouble (str);
	    }

	    for (y = 0 ; y < deposits.length ; y++)
	    {
		tDeposit += deposits [y];
	    }

	    infile.close ();
	}
	catch (IOException e)
	{
	    JOptionPane.showMessageDialog (null, "FILE NOT FOUND");
	}
    }



    public void tDeposits ()
    {

	dp.setText ("$" + String.valueOf (tDeposit));
	dp.setEditable (false);
    }


    public void tWithdrawals ()
    {

	wd.setText ("$" + String.valueOf (tWithdrawn));
	wd.setEditable (false);
    }


    public void setBalance ()
    {
	bal.setText ("$" + String.valueOf (tDeposit - tWithdrawn));
	bal.setEditable (false);
    }


    public void transfer (double amount)
    {
	String[] [] names;
	String display, input;
	int nom = 0;
	int siz, index;
	double total, initial;
	display = " ";



	for (int x = 0 ; x < fileSize ; x++)
	{
	    display = display + "\n" + nom + "." + customers [x] [0];
	    nom++;
	}

	input = JOptionPane.showInputDialog (null, display + "\nchoose a number.");
	index = Integer.parseInt (input);

	initial = Double.parseDouble (customers [index] [4]);

	total = amount + initial;

	customers [index] [4] = String.valueOf (total);

	write ();
    }


    public void write ()
    {

	try
	{
	    PrintWriter infile = new PrintWriter (new FileWriter ("info.txt"));

	    infile.println (fileSize);
	    for (x = 0 ; x < fileSize ; x++)
	    {
		if (customers [x] != null)
		{
		    for (int y = 0 ; y < customers [x].length ; y++)
		    {
			infile.println (customers [x] [y]);
		    }
		    infile.println ();
		}
	    }
	    infile.close ();
	}
	catch (IOException e)
	{
	    JOptionPane.showMessageDialog (null, "FILE NOT FOUND");
	}
    }


    public int getFileSize ()
    {
	return fileSize;
    }


    public void write (int d)
    {

	try
	{
	    PrintWriter infile = new PrintWriter (new FileWriter ("info.txt"));

	    infile.println (fileSize);
	    for (x = 0 ; x < fileSize ; x++)
	    {
		if (x != d)
		{
		    for (int y = 0 ; y < customers [x].length ; y++)
		    {
			infile.println (customers [x] [y]);
		    }
		    infile.println ();
		}
	    }
	    infile.close ();
	}
	catch (IOException e)
	{
	    JOptionPane.showMessageDialog (null, "FILE NOT FOUND");
	}
    }


    private class comboBoxListener implements ActionListener
    {
	public void actionPerformed (ActionEvent e)
	{
	    String selection = (String) options.getSelectedItem ();

	    if (selection.equals ("DEPOSIT"))
	    {
		input = JOptionPane.showInputDialog ("ENTER AMOUNT YOU WISH "
			+ "TO DEPOSIT");

		try
		{
		    if (input == null)
		    {
			JOptionPane.showMessageDialog (null, "EMPTY STRING");
		    }

		    else
		    {
			deposit (Double.parseDouble (input));
			tDeposits ();
			setBalance ();
			write ();
		    }
		}

		catch (NumberFormatException d)
		{
		    JOptionPane.showMessageDialog (null, "INVALID VALUE!");

		}
	    }

	    else if (selection.equals ("WITHDRAW"))
	    {

		input = JOptionPane.showInputDialog ("ENTER AMOUNT YOU WISH "
			+ "TO WITHDRAW");

		try
		{
		    if (input == null)
		    {
			JOptionPane.showMessageDialog (null, "EMPTY STRING");
		    }
		    if (input != null)
		    {
			withdraw (Double.parseDouble (input));
			tWithdrawals ();
			setBalance ();
			write ();
		    }
		}

		catch (NumberFormatException d)
		{
		    JOptionPane.showMessageDialog (null, "INVALID VALUE!");
		}

	    }

	    else if (selection.equals ("TRANSFER"))
	    {

		input = JOptionPane.showInputDialog ("ENTER AMOUNT YOU WISH "
			+ "TO TRANSFER");
		try
		{
		    if (input == null)
		    {
			JOptionPane.showMessageDialog (null, "EMPTY STRING");
		    }
		    else
		    {
			withdraw (Double.parseDouble (input));
			tWithdrawals ();
			setBalance ();
			write ();
			transfer (Double.parseDouble (input));
		    }
		}

		catch (NumberFormatException d)
		{
		    JOptionPane.showMessageDialog (null, "INVALID VALUE!");
		}

	    }
	}
    }


    public void editName ()
    {
	String input;

	try
	{
	    input = JOptionPane.showInputDialog ("ENTER NAME\nPRESS CANCEL FOR ANOTHER OPTION");

	    if (input != null)
	    {
		customers [d] [0] = input;
		name.setText ("NAME: " + input);
	    }
	}
	catch (NullPointerException e)
	{
	    JOptionPane.showMessageDialog (null, "EMPTY STRING");
	}
    }


    public void editGender ()
    {
	String input;

	try
	{
	    input = JOptionPane.showInputDialog ("ENTER GENDER\nPRESS CANCEL FOR ANOTHER OPTION");

	    if (input != null)
	    {
		customers [d] [2] = input;
		gender.setText ("GENDER: " + input);
	    }

	}
	catch (NullPointerException e)
	{
	    JOptionPane.showMessageDialog (null, "EMPTY STRING");
	}
    }


    private class buttonListener implements ActionListener
    {
	public void actionPerformed (ActionEvent e)
	{
	    if (e.getSource () == signOut)
	    {
		setVisible (false);
		a = new Customer ();
	    }

	    if (e.getSource () == edit)
	    {
		editName ();
		editGender ();

		write ();
	    }

	    if (e.getSource () == delete)
	    {
		setVisible (false);


		fileSize--;

		for (int n = d ; n < fileSize ; n++)
		{
		    customers [n] = customers [n + 1];
		}

		write ();

		JOptionPane.showMessageDialog (null, "YOUR ACCOUNT HAS BEEN DELETED!");
		a = new Customer ();
	    }
	}
    }
}





