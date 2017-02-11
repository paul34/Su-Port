package suport;
import java.awt.Dimension;
import java.lang.ProcessBuilder.Redirect;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 * 
 * This class has a bash script that calls Iptables to use a load balancing function
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
public class loadBalancing implements Runnable
{
	//Retrieve user data
	String ethNum = iptables.balancetf.getText();
	String portNum = iptables.balancePorttf.getText();
	String ip1Num = iptables.balanceIp1tf.getText();
	String ip2Num = iptables.balanceIp2tf.getText();
	String ip3Num = iptables.balanceIp3tf.getText();

//Start thread
public void run()
{
JDialog dialog = new JDialog();
JLabel label = new JLabel("Load Balancing");
label.setPreferredSize(new Dimension(200, 105)); 
dialog.setLocationRelativeTo(null);
dialog.setTitle("Please Wait...");
dialog.add(label);
dialog.pack();
dialog.setVisible(true);

//Create scripts
String[] command= 
{
"/bin/sh",
"-c",
"iptables -A PREROUTING -i " + ethNum + " -p tcp --dport " + portNum + " -m state --state NEW -m nth --counter 0 --every 3 --packet 0 -j DNAT --to-destination " + ip1Num+":"+portNum
};

String[] command2= 
{
"/bin/sh",
"-c",
"iptables -A PREROUTING -i " + ethNum + " -p tcp --dport " + portNum + " -m state --state NEW -m nth --counter 0 --every 3 --packet 1 -j DNAT --to-destination " + ip2Num+":"+portNum 
};

String[] command3= 
{
"/bin/sh",
"-c",
"iptables -A PREROUTING -i " + ethNum + " -p tcp --dport " + portNum + " -m state --state NEW -m nth --counter 0 --every 3 --packet 2 -j DNAT --to-destination " + ip3Num+":"+portNum 
};

try
{
	//Start Processbuilder
	ProcessBuilder pb1 = new ProcessBuilder(command);
	pb1.redirectOutput(Redirect.INHERIT);
	pb1.redirectError(Redirect.INHERIT);
	pb1.redirectErrorStream();
	Process pro = pb1.start();
	pro.waitFor();
	
}
catch (Exception e) 
{

}
try{
	ProcessBuilder pb2 = new ProcessBuilder(command2);
	pb2.redirectOutput(Redirect.INHERIT);
	pb2.redirectError(Redirect.INHERIT);
	pb2.redirectErrorStream();
	Process pro = pb2.start();
	pro.waitFor();
}
catch (Exception e) 
{

}
try{
	ProcessBuilder pb3 = new ProcessBuilder(command3);
	pb3.redirectOutput(Redirect.INHERIT);
	pb3.redirectError(Redirect.INHERIT);
	pb3.redirectErrorStream();
	Process pro = pb3.start();
	pro.waitFor();
}

catch (Exception e) 
{
}
iptables.textArea.setText("Load Balancing Rule Applied");
}
}