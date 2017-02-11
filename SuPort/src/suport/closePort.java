package suport;
import java.awt.Dimension;
import java.lang.ProcessBuilder.Redirect;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * 
 * This class creates a bash script for Iptables which closes a selected port
 * @param ProcessBuilder Starts the bash script
 * @param port this is the port selected by the end user to close
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class closePort implements Runnable
{
	//Retrieve user data
	String port= iptables.blockPort.getText();
//Start thread
public void run()
{
	//Start pop up
	JDialog dialog = new JDialog();
	JLabel label = new JLabel("Closing Port..");
	label.setPreferredSize(new Dimension(200, 105)); 
	dialog.setLocationRelativeTo(null);
	dialog.setTitle("Please Wait...");
	dialog.add(label);
	dialog.pack();
	dialog.setVisible(true);
//Create script
String[] command1= 
{
"/bin/sh",
"-c",				
"iptables -A INPUT -p tcp --dport " +port+ " -m state --state NEW,ESTABLISHED -j DROP"
	};

try
{
	//Start Processbuilder
	ProcessBuilder pb1 = new ProcessBuilder(command1);
	pb1.redirectOutput(Redirect.INHERIT);
	pb1.redirectError(Redirect.INHERIT);
	pb1.redirectErrorStream();
	Process pro1 = pb1.start();
	pro1.waitFor();

}
catch (Exception e) 
{

}
iptables.textArea.setText("Port Closed Rule Applied");

}
}