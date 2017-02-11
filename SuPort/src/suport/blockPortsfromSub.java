package suport;
import java.lang.ProcessBuilder.Redirect;

/**
 * 
 * This class has a bash script that calls Iptables to block ports from a subnet
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
public class blockPortsfromSub implements Runnable
{
	//Retrieve user input
	String ethNum1= iptables.blockEth1.getText();
	String ethNum2= iptables.blockEth2.getText();
	String ipNum= iptables.blockIP1.getText();
	String ipNum2= iptables.blockIP2.getText();
	String portNum1= iptables.blockPorts1.getText();
	String portNum2= iptables.blockPorts2.getText();

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


String[] command0= 
{
"/bin/sh",
"-c",
"iptables -I FORWARD -i " +ethNum1+ " -o " + ethNum2+ " -s " + ipNum + " -p udp --sport " + portNum1 + " -d " +  ipNum2 + " --dport " + portNum2 + " -j REJECT"

};

String[] command1= 
{
"/bin/sh",
"-c",
"iptables -I FORWARD -i " +ethNum2+ " -o " + ethNum1+ " -s " + ipNum2 + " -p udp --sport " + portNum2 + " -d " +  ipNum + " --dport " + portNum1 + " -j REJECT"				

};

try
{
	//Start Processbuilder
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
	
					
}
catch (Exception e) 
{

}
iptables.textArea.setText("Port Closed Between Subnets Rule Applied");

} 
}
