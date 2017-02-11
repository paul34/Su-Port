package suport;
import java.lang.ProcessBuilder.Redirect;

/**
 * 
 * This class has a bash script that calls Iptables to opens ports to/from a subnet
 * @param ProcessBuilder Starts the bash script
 * @param ethNum which is a value inputted by an end user to decide which network card to deploy the Iptable rule
 * @param ethNum2 which is a value inputted by an end user to decide which network card to deploy the Iptable rule
 * @param ipNum which is a value inputted by an end user to decide which IP to deploy the Iptable rule
 * @param ipNum2 which is a value inputted by an end user to decide which IP to deploy the Iptable rule
 * @param portNum which is a value inputted by an end user to decide which port to deploy the Iptable rule
 * @param portNum which is a value inputted by an end user to decide which port to deploy the Iptable rule
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class openPortsfromSub implements Runnable
{
	//Retrieve user input
	String ethNum1= iptables.allowEth1.getText();
	String ethNum2= iptables.allowEth2.getText();
	String ipNum= iptables.allowIP1.getText();
	String ipNum2= iptables.allowIP2.getText();
	String portNum1= iptables.allowPorts1.getText();
	String portNum2= iptables.allowPorts2.getText();

//Start thread
public void run()
{
//Create scripts
String[] command= 
{
"/bin/sh",
"-c",
"echo '1' > /proc/sys/net/ipv4/ip_forward"

};
	
String[] command2= 
{
"/bin/sh",
"-c",
"iptables -P FORWARD DROP"

};

String[] command0= 
{
"/bin/sh",
"-c",
"iptables -I FORWARD -i " +ethNum1+ " -o " + ethNum2+ " -s " + ipNum + " -p tcp --sport " + portNum1 + " -d " +  ipNum2 + " --dport " + portNum2 + " -j ACCEPT"

};

String[] command1= 
{
"/bin/sh",
"-c",
"iptables -I FORWARD -i " +ethNum2+ " -o " + ethNum1+ " -s " + ipNum2 + " -p tcp --sport " + portNum2 + " -d " +  ipNum + " --dport " + portNum1 + " -j ACCEPT"				

};

try
{
	//Start Processbuilders
	ProcessBuilder pb = new ProcessBuilder(command);
	pb.redirectOutput(Redirect.INHERIT);
	pb.redirectError(Redirect.INHERIT);
	pb.redirectErrorStream();
	Process pro = pb.start();
	pro.waitFor();
	
	ProcessBuilder pb0 = new ProcessBuilder(command0);
	pb0.redirectOutput(Redirect.INHERIT);
	pb0.redirectError(Redirect.INHERIT);
	pb0.redirectErrorStream();
	Process pro0 = pb0.start();
	pro0.waitFor();
	
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
					
}
catch (Exception e) 
{
}
iptables.textArea.setText("Port Opened on Subnets");
} 
}
