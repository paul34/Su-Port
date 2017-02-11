package suport;
import java.lang.ProcessBuilder.Redirect;

/**
 * 
 * This class has a bash script that calls Iptables to allow port forwarding on to the home computer
 * @param ProcessBuilder Starts the bash script
 * @param ethNum which is a value inputted by an end user to decide which network card to deploy the Iptable rule
 * @param portNum which is a value inputted by an end user to decide which port to deploy the Iptable rule
 * @param ipNum which is a value inputted by an end user to decide which IP to deploy the Iptable rule
 * @param portNum2 which is a value inputted by an end user to decide which port to deploy the Iptable rule
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class allowPortForwarding implements Runnable
{
	//Retrieve user data
	String ipNum= iptables.portforwardtf.getText();
	String portNum1 = iptables.port1tf.getText();
	String portNum2 = iptables.port2tf.getText();
	String ethNum = iptables.portEth.getText();

public void run()
{
//Create scripts
String[] command1= 
{
"/bin/sh",
"-c",
"iptables -t nat -A PREROUTING -p tcp -d " + ipNum + " --dport " + portNum2 + " -j DNAT --to " + ipNum+":"+portNum1
};

String[] command2= 
{
"/bin/sh",
"-c",
"iptables -A INPUT -i " +ethNum+" -p tcp --dport "+portNum2+" -m state --state NEW,ESTABLISHED -j ACCEPT"
};

String[] command3= 
{
"/bin/sh",
"-c",
"iptables -A OUTPUT -o " +ethNum+" -p tcp --sport "+portNum2+" -m state --state ESTABLISHED -j ACCEPT"
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
iptables.textArea.setText("Allow Port Forwarding Rule Applied");

}
}