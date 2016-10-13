//OGUNSANYA TOLUWANI DAMILOLA 2015080192
//ICS4U-S2 Prd5
//THE MOBILE BANK
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class signUpClass extends JFrame
{

    private JTextField fName, lName, balance;
    private JLabel name, sName, bal;
    private JPanel panelI, panelII, panelIII, panelIV, panelV, panelVI;
    private JButton enter, back;
    String[] [] customers = new String [50] [6];
    int fileSize;
    Customer r;

    public signUpClass ()
    {
	info ();
	setTitle ("THE MOBILE BANK");
	setSize (1500, 300);

	setDefaultCloseOperation (EXIT_ON_CLOSE);
	getContentPane ().setLayout (new BorderLayout ());

	buildInterface ();

	getContentPane ().add (panelV, BorderLayout.NORTH);
	getContentPane ().add (enter, BorderLayout.SOUTH);
	getContentPane ().setBackground (Color.WHITE);

	setVisible (true);

    }


    public void buildInterface ()
    {
	panelI = new JPanel ();
	panelII = new JPanel ();
	panelIII = new JPanel ();
	panelIV = new JPanel ();
	panelV = new JPanel ();
	panelVI = new JPanel ();

	enter = new JButton ("ENTER");
	enter.addActionListener (new buttonListener ());
	enter.setBackground (Color.CYAN);

	back = new JButton ("BACK");
	back.addActionListener (new buttonListener ());
	back.setBackground (Color.CYAN);

	panelI.setLayout (new FlowLayout ());
	panelII.setLayout (new FlowLayout ());
	panelIII.setLayout (new FlowLayout ());
	panelIV.setLayout (new FlowLayout ());
	panelV.setLayout (new FlowLayout ());
	panelVI.setLayout (new BorderLayout ());

	panelI.setBackground (Color.WHITE);
	panelII.setBackground (Color.WHITE);
	panelIII.setBackground (Color.WHITE);
	panelIV.setBackground (Color.WHITE);
	panelV.setBackground (Color.WHITE);

	name = new JLabel ("ENTER FIRST NAME: ");
	fName = new JTextField (10);

	sName = new JLabel ("ENTER LAST NAME: ");
	lName = new JTextField (10);

	bal = new JLabel ("ENTER BALANCE: ");
	balance = new JTextField (10);

	panelI.add (name);
	panelI.add (fName);
	panelI.add (sName);

	panelII.add (lName);

	panelIV.add (bal);
	panelIV.add (balance);
	panelIV.add (back);

	panelV.add (panelI);
	panelV.add (panelII);
	panelV.add (panelIII);
	panelV.add (panelIV);

    }


    public void create ()
    {
	String str = fName.getText () + " " + lName.getText ();
	customers [fileSize] [0] = str;
	customers [fileSize] [1] = "102632929";
	customers [fileSize] [2] = "male";
	customers [fileSize] [3] = "C:\\Users\\Awesome-Tbee\\Documents\\docs\\mike.png";
	customers [fileSize] [4] = balance.getText ();
	customers [fileSize] [5] = "0";
	fileSize++;
	write ();

    }


    public void write ()
    {

	try
	{
	    int x;
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
		else
		{
		    fileSize--;
		    break;
		}

	    }
	    infile.close ();
	}
	catch (IOException e)
	{
	    JOptionPane.showMessageDialog (null, "FILE NOT FOUND");
	}
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

	    }
	    infile.close ();
	}

	catch (IOException e)
	{

	    JOptionPane.showMessageDialog (null, "FILE NOT FOUND");
	}

    }


    private class buttonListener implements ActionListener
    {
	public void actionPerformed (ActionEvent e)
	{
	    double bal;
	    if (e.getSource () == enter)
	    {
		if (fName.getText () != null && lName.getText () != null)
		{
		    try
		    {
			bal = Double.parseDouble (balance.getText ());
			create ();
			r = new Customer ();
			setVisible (false);
		    }
		    catch (NumberFormatException v)
		    {
			JOptionPane.showMessageDialog (null, "INVALID " +
				"BALANCE.");
		    }
		}

	    }

	    if (e.getSource () == back)
	    {
		setVisible (false);
		r = new Customer ();
	    }
	}
    }
}
