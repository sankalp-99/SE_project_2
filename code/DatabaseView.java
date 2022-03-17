/* AddPartyView.java
 *
 *  Version:
 * 		 $Id$
 * 
 *  Revisions:
 * 		$Log: AddPartyView.java,v $
 * 		Revision 1.7  2003/02/20 02:05:53  ???
 * 		Fixed addPatron so that duplicates won't be created.
 * 		
 * 		Revision 1.6  2003/02/09 20:52:46  ???
 * 		Added comments.
 * 		
 * 		Revision 1.5  2003/02/02 17:42:09  ???
 * 		Made updates to migrate to observer model.
 * 		
 * 		Revision 1.4  2003/02/02 16:29:52  ???
 * 		Added ControlDeskEvent and ControlDeskObserver. Updated Queue to allow access to Vector so that contents could be viewed without destroying. Implemented observer model for most of ControlDesk.
 * 		
 * 
 */

/**
 * Class for GUI components need to add a party
 *
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import java.util.*;


/**
 * Constructor for GUI used to Add Parties to the waiting party queue.
 *  
 */

public class DatabaseView implements ActionListener, ListSelectionListener {

	

	private JFrame win;
	private JButton maxScore;
	private JButton minScore;
	private JButton averageScore;
	private JButton topPlayer;
	private JButton finished;

	
    private JPanel ansPanel;
    private JLabel clsLabel;

	

	public DatabaseView() {

		
		

		win = new JFrame("Database");
		win.getContentPane().setLayout(new BorderLayout());
		((JPanel) win.getContentPane()).setOpaque(false);

		JPanel colPanel = new JPanel();
		colPanel.setLayout(new GridLayout(1, 3));

		// Party Panel
	    ansPanel= new JPanel();
		ansPanel.setLayout(new FlowLayout());
		ansPanel.setBorder(new TitledBorder("Your Results"));
		clsLabel = new JLabel();

	
		
		
		

		// Bowler Database
		

		// Button Panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5, 1));



		// code repeition
		maxScore = makeButton(buttonPanel,"Maximum Score");
		minScore= makeButton(buttonPanel,"Minimum Score");
		averageScore= makeButton(buttonPanel,"Average Score");
		topPlayer= makeButton(buttonPanel,"Top player");
		finished=makeButton(buttonPanel,"finished");

		// Clean up main panel
		colPanel.add(ansPanel);
		
		colPanel.add(buttonPanel);

		win.getContentPane().add("Center", colPanel);

		win.pack();

		// Center Window on Screen
		Dimension screenSize = (Toolkit.getDefaultToolkit()).getScreenSize();
		win.setLocation(
			((screenSize.width) / 2) - ((win.getSize().width) / 2),
			((screenSize.height) / 2) - ((win.getSize().height) / 2));
		win.show();

	}
	
	public JButton makeButton(JPanel panel,String str)
	{
		JPanel buttonPanel=new JPanel();
		JButton button=new JButton(str);
		buttonPanel.setLayout(new FlowLayout());
		button.addActionListener(this);
		buttonPanel.add(button);
		panel.add(buttonPanel);
		
		return button;
	}
          

	private void printMaxScore() 
	{
		try{
		Database db=new Database();
		String res=db.maxScore();
		
       
        clsLabel.setText(res);
        ansPanel.add(clsLabel);
        win.setVisible(true);
		}
		catch(Exception e)
		{
            
		}
         

	}


	private void printMinScore() 
	{
		try{
		Database db=new Database();
		String res=db.minScore();
		
        clsLabel.setText(res);
        ansPanel.add(clsLabel);
        win.setVisible(true);
		}
		catch(Exception e)
		{

		}
         

	}

	private void printAverageScore() 
	{
		try{
		Database db=new Database();
		double res=db.averageScore();
		
        clsLabel.setText(res+"");
        ansPanel.add(clsLabel);
        win.setVisible(true);
		}
		catch(Exception e)
		{

		}
         

	}


	private void printTopPlayer() 
	{
		try{
		Database db=new Database();
		String res=db.topPlayer();
		
        clsLabel.setText(res);
        ansPanel.add(clsLabel);
        win.setVisible(true);
		}
		catch(Exception e)
		{

		}
         

	}

	


	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(maxScore)) {
			printMaxScore();
			
		}
		if (e.getSource().equals(minScore)) {
			printMinScore();
			
		}
		if (e.getSource().equals(averageScore)) {
			printAverageScore();
			
		}
		if (e.getSource().equals(topPlayer)) {
             printTopPlayer();
		
		}

		if (e.getSource().equals(finished)) {
			
			win.hide();
		}

	}


/**
 * Handler for List actions
 * @param e the ListActionEvent that triggered the handler
 */

	public void valueChanged(ListSelectionEvent e) {
	
	}





}
