package suport;
import java.lang.ProcessBuilder.Redirect;

/**
 * 
 * This class has a bash script that calls Iptables to allow pings in to the home computer
 * @param ProcessBuilder Starts the bash script
 * @command command is a string that contains the bash script which goes in to the processbuilder
 * 
 */
public class allowPingsIn implements Runnable
{
//Start thread
public void run()
{
//Create scripts
String[] command= 
{
"/bin/sh",
"-c",
"iptables -A INPUT -p icmp --icmp-type echo-request -j ACCEPT"

};

String[] command2= 
{
"/bin/sh",
"-c",
"iptables -A OUTPUT -p icmp --icmp-type echo-reply -j ACCEPT"

};

try
{
	//Start Process builder
	ProcessBuilder pb2 = new ProcessBuilder(command);
	pb2.redirectOutput(Redirect.INHERIT);
	pb2.redirectError(Redirect.INHERIT);
	pb2.redirectErrorStream();
	Process pro = pb2.start();
	pro.waitFor();
	
	ProcessBuilder pb = new ProcessBuilder(command2);
	pb.redirectOutput(Redirect.INHERIT);
	pb.redirectError(Redirect.INHERIT);
	pb.redirectErrorStream();
	Process pro2 = pb.start();
	pro2.waitFor();
	
		
}
catch (Exception e) 
{

}
iptables.textArea.setText("Allow Pings In Rule Applied");

} 
}
