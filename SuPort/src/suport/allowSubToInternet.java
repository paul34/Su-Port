package suport;
import java.lang.ProcessBuilder.Redirect;

/**
 * 
 * This class has a bash script that calls Iptables to allow a subnet to the internet
 * @param ProcessBuilder Starts the bash script
 * @param ethNum which is a value inputted by an end user to decide which network card to deploy the Iptable rule
 * @param ethNum2 which is a value inputted by an end user to decide which network card to deploy the Iptable rule
 * @param ipNum which is a value inputted by an end user to decide which IP to deploy the Iptable rule
 * @param ipNum2 which is a value inputted by an end user to decide which IP to deploy the Iptable rule
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class allowSubToInternet implements Runnable
{
	//Retrieve data from users
	String ethNum= iptables.allowSubEth1.getText();
	String ethNum2= iptables.allowSubEth2.getText();
	String ipNum= iptables.allowSubIP1.getText();
	String ipNum2= iptables.allowSubIP2.getText();

//Start thread
public void run()
{
//Create commands
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
"iptables -A FORWARD -i "+ethNum+" -o " +ethNum2+" -j ACCEPT"

};

String[] command2= 
{
"/bin/sh",
"-c",
"iptables -t nat -A POSTROUTING -s " + ipNum + " -o " + ethNum2 + " -j SNAT --to-source " + ipNum2
		
	};

String[] command3= 
{
"/bin/sh",
"-c",
"iptables -t nat -A POSTROUTING -o " + ethNum2 + " -j MASQUERADE"
	
};
//Start process builder
	try
	{

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
		
		ProcessBuilder pb3 = new ProcessBuilder(command3);
		pb3.redirectOutput(Redirect.INHERIT);
		pb3.redirectError(Redirect.INHERIT);
		pb3.redirectErrorStream();
		Process pro3 = pb3.start();
		pro3.waitFor();
		
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
	iptables.textArea.setText("Allow Subnet to Internet Rule Applied");

} 
}//end class
