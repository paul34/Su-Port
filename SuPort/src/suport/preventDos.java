package suport;
import java.awt.Dimension;
import java.lang.ProcessBuilder.Redirect;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * 
 * This class has a bash script that calls Iptables to prevent a DOS attack
 * @param ProcessBuilder Starts the bash script
 * @param limit which is a value inputted by an end user to decide the limit of connections
 * @param burst which is a value inputted by an end user to decide at what is the limit before action is taken
 * @param port which is a value inputted by an end user to decide which port to deploy the Iptable rule
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class preventDos implements Runnable
{
	//Retrieve user data
	String port= iptables.port.getText();
	String limit= iptables.Limit.getText();
	String burst= iptables.Burst.getText();
//Start thread
public void run()
{
	JDialog dialog = new JDialog();
	JLabel label = new JLabel("Preventing DOS..");
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
"iptables -A INPUT -p tcp --dport " +port + " -m limit --limit "+limit+"/minute --limit-burst "+burst+" -j ACCEPT"

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
iptables.textArea.setText("Denial of service Rule Implemented");
}
}