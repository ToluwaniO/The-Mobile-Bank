//OGUNSANYA TOLUWANI DAMILOLA
//ICS4U
//THE MOBILE BANK
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class BonanzaPage extends JFrame
{
    private JTextArea field;
    private JButton spin, back;
    private JLabel promo;
    private JPanel panel, panel2;
    private int fileSize;
    private String[] [] customers;
    private double[] balance;
    int rand;
    int user;
    Bonanza w;

    public BonanzaPage (int a)
    {
	user = a;
	start ();
    }


    public void start ()
    {

	info ();
	setBalance ();

	setSize (300, 400);
	setDefaultCloseOperation (EXIT_ON_CLOSE);
	panel = new JPanel ();
	panel.setLayout (new BorderLayout ());

	panel2 = new JPanel ();

	ImageIcon image = new ImageIcon ("money.jpg");
	promo = new JLabel (image);

	spin = new JButton ("SPIN");
	spin.addActionListener (new buttonListener ());
	spin.setBackground(Color.CYAN);

	back = new JButton ("BACK");
	back.addActionListener (new buttonListener ());
	back.setBackground(Color.CYAN);

	field = new JTextArea (20, 5);
	field.setEditable (false);

	panel2.add (spin);
	panel2.add (back);

	panel.add (spin, BorderLayout.NORTH);
	panel.add (promo, BorderLayout.CENTER);
	panel.add (field, BorderLayout.EAST);
	panel.add (panel2, BorderLayout.SOUTH);

	getContentPane ().add (panel);

	userInfo ();

	setVisible (true);
    }


    public void userInfo ()
    {
	String account = " ";
	for (int d = 0 ; d < customers [user].length ; d++)
	{
	    if (d == 3)
	    {

	    }
	    else if (d == 4 || d == 5)
	    {
		account += "$ " + customers [user] [d] + "\n";
	    }

	    else
		account += customers [user] [d] + "\n";
	}

	field.setText (account);
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


    public void getBalance (double amount)
    {
	double newVal = 0;

	balance [user] += amount;

	newVal = amount + Double.parseDouble (customers [user] [4]);

	customers [user] [4] = String.valueOf (newVal);

	write ();

	userInfo ();

    }


    public void generateNum ()
    {
	rand = (int) (Math.random () * 10) + 1;
    }


    public void write ()
    {

	try
	{
	    PrintWriter infile = new PrintWriter (new FileWriter ("info.txt"));

	    infile.println (fileSize);
	    for (int x = 0 ; x < fileSize ; x++)
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


    public void prize ()
    {
	double amount = 0;
	if (rand > 3 && rand < 6)
	{
	    amount = 2000;
	    JOptionPane.showMessageDialog (null, "YOU'VE WON $ " + amount);
	}


	else
	{
	    JOptionPane.showMessageDialog (null, "TRY AGAIN LATER");
	}

	getBalance (amount);
    }


    private class buttonListener implements ActionListener
    {
	public void actionPerformed (ActionEvent e)
	{
	    if (e.getSource () == spin)
	    {
		generateNum ();
		prize ();
	    }

	    if (e.getSource () == back)
	    {
		setVisible (false);
		w = new Bonanza ();
	    }
	}
    }
}
