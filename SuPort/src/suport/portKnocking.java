package suport;
import java.awt.Dimension;
import java.lang.ProcessBuilder.Redirect;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * 
 * This class has a bash script that calls Iptables to block ports from a subnet
 * @param ProcessBuilder Starts the bash script
 * @param accessPort which is a value inputted by an end user to decide which port will be accessed
 * @param port1 which is a value inputted by an end user to decide which port has to be tried first to access the end port
 * @param port2 which is a value inputted by an end user to decide which port has to be tried the second time to access the end port
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class portKnocking implements Runnable
{
	//Retrieve user data
	String port1= iptables.portKnock1.getText();
	String port2= iptables.portKnock2.getText();
	String accessPort= iptables.accessPort.getText();
//Start thread
public void run()
{
	JDialog dialog = new JDialog();
	JLabel label = new JLabel("Port Knocking..");
	label.setPreferredSize(new Dimension(200, 105)); 
	dialog.setLocationRelativeTo(null);
	dialog.setTitle("Please Wait...");
	dialog.add(label);
	dialog.pack();
	dialog.setVisible(true);
//Create scripts
String[] command1= 
{
"/bin/sh",
"-c",				
"iptables -A INPUT -m state --state NEW -m tcp -p tcp --dport " + port1 + " -m recent --set --name knocked"

};
String[] command2= 
{
"/bin/sh",
"-c",				
"iptables -A INPUT -m state --state NEW -m tcp -p tcp --dport " + port2 + " -m recent --set --name knocked"

};

String[] command3= 
{
"/bin/sh",
"-c",				
"iptables -A INPUT -m state --state NEW -m tcp -p tcp --dport " + accessPort + " -m recent --rcheck --name knocked --seconds 999999 -j ACCEPT"

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
	
	ProcessBuilder pb2 = new ProcessBuilder(command2);
	pb2.redirectOutput(Redirect.INHERIT);
	pb2.redirectError(Redirect.INHERIT);
	pb2.redirectErrorStream();
	Process pro2 = pb2.start();
	pro2.waitFor();
	
	ProcessBuilder pb3 = new ProcessBuilder(command3);
	pb3.redirectOutput(Redirect.INHERIT);
	pb3.redirectError(Redirect.INHERIT);
	pb3.redirectErrorStream();
	Process pro3 = pb3.start();
	pro3.waitFor();
	
}
catch (Exception e) 
{
}
iptables.textArea.setText("Port Knocking Rule Applied");
}
}