//OGUNSANYA TOLUWANI DAMILOLA
//ICS4U
//THE MOBILE BANK
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Bonanza extends JFrame
{
    private JComboBox list;
    private JLabel info;
    private JPanel cust;
    private JButton back, exit;
    private String[] names;
    private String[] [] customers;
    private double[] balance;
    private int rand;
    private String[] response = new String [2];
    int fileSize;
    String selection;
    start z;
    BonanzaPage r;
    private JPanel panel;

    public Bonanza ()
    {
	setTitle ("THE MOBILE BANK");

	setSize (500, 500);

	setDefaultCloseOperation (EXIT_ON_CLOSE);

	info ();
	setComboBox ();
	setBalance ();

	getContentPane ().setLayout (new BorderLayout ());

	panel = new JPanel ();
	panel.setBackground (Color.WHITE);

	back = new JButton ("BACK");
	back.addActionListener (new buttonListener ());

	exit = new JButton ("EXIT");
	exit.addActionListener (new buttonListener ());

	list.setBackground (Color.WHITE);
	exit.setBackground (Color.CYAN);
	back.setBackground (Color.CYAN);

	panel.setLayout(new FlowLayout());
	panel.add (back);
	panel.add (exit);

	getContentPane ().add (list, BorderLayout.NORTH);
	getContentPane ().add (panel, BorderLayout.SOUTH);

	getContentPane ().setBackground (Color.WHITE);


	setVisible (true);

    }


    public void setComboBox ()
    {
	String[] sorted = new String [fileSize];
	names = new String [fileSize];

	for (int i = 0 ; i < fileSize ; i++)
	{
	    names [i] = customers [i] [0];
	}

	sorted = sort (names);

	list = new JComboBox (sorted);
	list.addActionListener (new comboBoxListener ());


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

	    customers = new String [fileSize] [6];
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

	    }
	    infile.close ();
	}

	catch (IOException e)
	{

	    JOptionPane.showMessageDialog (null, "FILE NOT FOUND");
	}

    }


    public void setBalance ()
    {
	balance = new double [fileSize];

	for (int x = 0 ; x < fileSize ; x++)
	{
	    balance [x] = Double.parseDouble (customers [x] [4]) -
		Double.parseDouble (customers [x] [5]);
	}

    }


    public void generateNum ()
    {
	Random number = new Random ();

	rand = (int) Math.random () * 100;
    }


    private class buttonListener implements ActionListener
    {
	public void actionPerformed (ActionEvent e)
	{
	    if (e.getSource () == back)
	    {
		setVisible (false);
		z = new start ();

	    }

	    if (e.getSource () == exit)
	    {
		System.exit (0);

	    }
	}
    }


    private class comboBoxListener implements ActionListener
    {
	public void actionPerformed (ActionEvent e)
	{
	    selection = (String) list.getSelectedItem ();

	    if (selection.equals (names [0]))
	    {
		setVisible (false);
		r = new BonanzaPage (0);

	    }

	    else if (selection.equals (names [1]))
	    {
		setVisible (false);

		r = new BonanzaPage (1);
	    }

	    else if (selection.equals (names [2]))
	    {
		setVisible (false);

		r = new BonanzaPage (2);
	    }

	    else if (selection.equals (names [3]))
	    {
		setVisible (false);

		r = new BonanzaPage (3);
	    }

	    else if (selection.equals (names [4]))
	    {
		setVisible (false);

		r = new BonanzaPage (4);
	    }

	    else if (selection.equals (names [5]))
	    {
		setVisible (false);

		r = new BonanzaPage (5);
	    }

	    else if (selection.equals (names [6]))
	    {
		setVisible (false);

		r = new BonanzaPage (5);
	    }

	    else if (selection.equals (names [7]))
	    {
		setVisible (false);

		r = new BonanzaPage (7);
	    }

	    else if (selection.equals (names [8]))
	    {
		setVisible (false);

		r = new BonanzaPage (8);
	    }

	    else if (selection.equals (names [9]))
	    {
		setVisible (false);

		r = new BonanzaPage (9);
	    }

	    else if (selection.equals (names [10]))
	    {
		setVisible (false);

		r = new BonanzaPage (10);
	    }
	    else if (selection.equals (names [11]))
	    {
		setVisible (false);

		r = new BonanzaPage (11);
	    }

	    else if (selection.equals (names [12]))
	    {
		setVisible (false);

		r = new BonanzaPage (12);
	    }

	    else if (selection.equals (names [13]))
	    {
		setVisible (false);

		r = new BonanzaPage (13);
	    }

	    else if (selection.equals (names [14]))
	    {
		setVisible (false);

		r = new BonanzaPage (14);
	    }
	}
    }
}
