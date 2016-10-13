//OGUNSANYA TOLUWANI DAMILOLA
//THE MOBILE BANK
//ICS4U
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Customer extends JFrame
{


    CustomerAccount[] users;
    private JComboBox list;
    private JButton back, exit, signUp;
    String[] [] customers = new String [50] [6];
    private int i = 0;
    private String[] passes = new String [7];
    private JPanel panel;
    String selection;
    signUpClass c;
    int customerSize = 0;
    String[] names;
    int a = 0;
    private start g;
    int fileSize;

    public Customer (int x)
    {
	info ();
    }


    public Customer ()
    {
	info ();

	users = new CustomerAccount [10];

	getContentPane ().setLayout (new BorderLayout ());
	getContentPane ().setBackground (Color.WHITE);

	setComboBox ();

	back = new JButton ("BACK");
	back.addActionListener (new buttonListener ());
	back.setBackground (Color.CYAN);


	exit = new JButton ("EXIT");
	exit.addActionListener (new buttonListener ());
	exit.setBackground (Color.CYAN);


	signUp = new JButton ("SIGN UP");
	signUp.addActionListener (new buttonListener ());
	signUp.setBackground (Color.CYAN);


	panel = new JPanel ();
	panel.setBackground (Color.WHITE);


	panel.add (back);
	panel.add (exit);
	panel.add (signUp);

	setTitle ("THE MOBILE BANK");
	setSize (300, 300);
	setDefaultCloseOperation (EXIT_ON_CLOSE);

	getContentPane ().add (list, BorderLayout.CENTER);
	getContentPane ().add (panel, BorderLayout.SOUTH);

	setVisible (true);


    }


    public void setComboBox ()
    {
	String[] sorted;
	names = new String [customerSize];

	for (int i = 0 ; i < customerSize ; i++)
	{
	    names [i] = customers [i] [0];
	}

	sorted = sort (names);

	list = new JComboBox (sorted);
	list.addActionListener (new comboBoxListener ());
	list.setBackground (Color.WHITE);


    }


    public void setProfile ()
    {
	users [i] = new CustomerAccount (customerSize, a, customers);
	users [i].setName (customers [a] [0]);
	users [i].setGender (customers [a] [2]);
	users [i].setAcctNo (customers [a] [1]);
	users [i].setProfilePic (customers [a] [3]);
	users [i].deposit (customers [a] [4]);
	users [i].withdraw (customers [a] [5]);
	users [i].start ();
    }


    public String[] sort (String[] nam)
    {
	String[] sorted = new String [fileSize];
	String old, now;

	for (int x = 0 ; x < fileSize ; x++)
	{
	    sorted [x] = nam [x];
	}


	for (int x = 0 ; x < fileSize - 1 ; x++)
	{
	    for (int y = x + 1 ; y < fileSize ; y++)
	    {
		if (sorted [x].compareTo (sorted [y]) > 0)
		{
		    old = sorted [x];
		    now = sorted [y];

		    sorted [x] = now;
		    sorted [y] = old;
		}
	    }
	}

	return sorted;

    }


    public void info ()
    {
	String name, acctNo, gender, photo, str;
	double deposits, withdrawals;


	try
	{
	    BufferedReader infile;
	    infile = new BufferedReader (new FileReader ("info.txt"));

	    str = infile.readLine ();
	    fileSize = Integer.parseInt (str);

	    for (int b = 0 ; b < fileSize ; b++)
	    {
		for (int col = 0 ; col < 7 ; col++)
		{
		    if (col == 6)
		    {
			str = infile.readLine ();
		    }
		    else
			customers [b] [col] = infile.readLine ();
		}
		customerSize++;
	    }
	    infile.close ();
	}

	catch (IOException e)
	{

	    JOptionPane.showMessageDialog (null, "FILE NOT FOUND");
	}

    }


    public String[] [] getNames ()
    {
	return customers;
    }


    public int getFileSize ()
    {
	return fileSize;
    }


    public void getTransfer (int index, double amount)
    {
	double initial = Double.parseDouble (customers [index] [4]);
	double total;

	total = amount + initial;

	customers [index] [4] = String.valueOf (total);


    }


    private class comboBoxListener implements ActionListener
    {
	public void actionPerformed (ActionEvent e)
	{
	    selection = (String) list.getSelectedItem ();

	    if (selection != null)
	    {
		setVisible (false);
		if (selection.equals (names [0]))
		{
		    if (names [0] != null)
		    {
			a = 0;
			setProfile ();
			i++;
		    }
		}

		else if (selection.equals (names [1]))
		{
		    if (names [1] != null)
		    {
			a = 1;
			setProfile ();
			i++;
		    }
		}

		else if (selection.equals (names [2]))
		{
		    if (names [2] != null)
		    {
			a = 2;
			setProfile ();
			i++;
		    }
		}

		else if (selection.equals (names [3]))
		{
		    if (names [0] != null)
		    {
			a = 3;
			setProfile ();
			i++;
		    }
		}

		else if (selection.equals (names [4]))
		{
		    if (names [4] != null)
		    {
			a = 4;
			setProfile ();
			i++;
		    }

		}

		else if (selection.equals (names [5]))
		{
		    if (names [5] != null)
		    {
			a = 5;
			setProfile ();
			i++;
		    }

		}

		else if (selection.equals (names [6]))
		{
		    if (names [6] != null)
		    {
			a = 6;
			setProfile ();
			i++;
		    }

		}

		else if (selection.equals (names [7]))
		{
		    if (names [7] != null)
		    {
			a = 7;
			setProfile ();
			i++;
		    }

		}

		else if (selection.equals (names [8]))
		{
		    if (selection != null)
		    {
			a = 8;
			setProfile ();
			i++;
		    }

		}

		else if (selection.equals (names [9]))
		{
		    if (names [9] != null)
		    {
			a = 9;
			setProfile ();
			i++;
		    }

		}
		else if (selection.equals (names [10]))
		{
		    if (names [10] != null)
		    {
			a = 10;
			setProfile ();
			i++;
		    }

		}
	    }

	    else
	    {
		JOptionPane.showMessageDialog (null, "INVALID SELECTION");
	    }
	}
    }


    private class buttonListener implements ActionListener
    {
	public void actionPerformed (ActionEvent e)
	{
	    if (e.getSource () == back)
	    {
		setVisible (false);
		g = new start ();
	    }

	    if (e.getSource () == exit)
	    {
		System.exit (0);
	    }

	    if (e.getSource () == signUp)
	    {
		setVisible (false);
		c = new signUpClass ();
	    }
	}
    }




}
