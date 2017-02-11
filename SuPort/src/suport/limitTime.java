package suport;
import java.awt.Dimension;
import java.lang.ProcessBuilder.Redirect;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * 
 * This class has a bash script that calls Iptables to limit time on connections
 * @param ProcessBuilder Starts the bash script
 * @param port which is a value inputted by an end user to decide which port to deploy the Iptable rule
 * @param amount which is a value inputted by an end user to decide how much time the connection stays alive
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class limitTime implements Runnable
{
	//Retrieve user data
	String port= iptables.limitTimePort.getText();
	String amount= iptables.limitTimeAmount.getText();
//Start thread
public void run()
{
	JDialog dialog = new JDialog();
	JLabel label = new JLabel("Limiting Time..");
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
"iptables -A OUTPUT -p tcp --dport " + port + " -m state --state RELATED,ESTABLISHED -m limit --limit " +amount+"/minute -j DROP"
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
iptables.textArea.setText("Time Limit Rule Applied");
}
}