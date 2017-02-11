package suport;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * 
 * This class has creates a Jframe with a populated dropdown box which an end user clicks on to decide if they
 * want to delete it or not. Once the option has been chosen a Joptionpane pops up to make sure it is the rule 
 * the end user would like to delete
 * @param jcombopenPorts allows the end user to make choice
 * 
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
public class deleteOneRule implements ActionListener, ItemListener 
{
	//Create Jframe with drop down box
	static JFrame frame = new JFrame("Deleting One Rule");
	static JPanel panel = new JPanel();
	static JComboBox jcombopenPorts= new JComboBox();
	static String[] lineArray;
	static String [] tryer;
	ArrayList<String> strings = new ArrayList<String>();
//constructor
public deleteOneRule()
{

  frame.setVisible(true);
  frame.setSize(500,200);
  jcombopenPorts.setBackground(Color.GRAY);		
  jcombopenPorts.setSelectedItem(-1);
  jcombopenPorts.addItemListener(this);
  jcombopenPorts.setEnabled(true);
  
  frame.add(panel); 

  panel.setLayout(new GridLayout(3, 0));	
}
{
	//Read from file
	BufferedReader br2 = null;
	try 
	{
		br2 = new BufferedReader(new FileReader("allRules"));
	} 
	catch (FileNotFoundException e1) 
	{
		e1.printStackTrace();
	}
	try 
	{
	  String line = null;
	  while (( line = br2.readLine()) != null)
	  {
	    strings.add(line);
	  }
	}

	catch (FileNotFoundException e)
	{
	    System.err.println("Error, file " + "allRules" + " didn't exist.");
	} 
	catch (IOException e) 
	{
		e.printStackTrace();
	}
	finally
	{
	    try
	    {
			br2.close();
		} 
	    catch (IOException e) 
	    {
			e.printStackTrace();
		}
	}
	//Repaint GUI so it doesn't add twice
	panel.removeAll(); 
	panel.updateUI();	
	lineArray = strings.toArray(new String[]{});
	jcombopenPorts = new JComboBox(lineArray);
	panel.add(jcombopenPorts, BorderLayout.CENTER);

}
public void itemStateChanged(ItemEvent e) 
{
	if (e.getStateChange() == ItemEvent.SELECTED) 
	{
		//retrieve item selected and create Joptionpane are you sure
	tryer = ((String) jcombopenPorts.getSelectedItem()).split("  ");
	System.out.println(tryer[0]);
	String message = "Is this the Rule you want to Delete?" + tryer[0];
	String title = "Deleting A Rule";
	int reply = JOptionPane.showConfirmDialog(null, message, title , JOptionPane.YES_NO_OPTION);
	if (reply == JOptionPane.YES_OPTION)
	{
	(new Thread(new deleteTheOneRule())).start();
	} 
}
	}
public void actionPerformed (ActionEvent e) 
{     
          
  }
}