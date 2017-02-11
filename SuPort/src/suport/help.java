package suport;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * This class gives an end user a help JFrame for the program.Each button pressed gives a different
 * help option, which ever is required by the end user.
 * 
 */
public class help implements ActionListener
{
//Create Jframe for help class
JFrame frame = new JFrame("Help");
JPanel panel = new JPanel();
JLabel label = new JLabel();
JLabel label2 = new JLabel("");
        
JButton button = new JButton();
JButton button2 = new JButton();
JButton button3 = new JButton();
//constructor        
public help()
{
panel.setLayout(new FlowLayout());
button.setText("Firewall Options");
button2.setText("Network Information");
button3.setText("Nmap Options");
button.addActionListener(this);
button2.addActionListener(this);
button3.addActionListener(this);

panel.add(label);
panel.add(button2);
panel.add(button);

panel.add(button3);
panel.add(label2);

frame.add(panel);
frame.setSize(600, 400);
label.setText("<html>This application is a GUI front end for Network "
	+ "analysis, monitoring and security<br> and delivers a clear"
	+ " and easy to use GUI. There are three main options for the end <br>"
	+ "user Network information, firewall options and Nmap options <br>"
	+  "<br> Click on which button you want help on. <br> <br></html>");

    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}


public void actionPerformed(ActionEvent e) {
	if(e.getSource()== button)
	{
		label2.setText("<html>This option is a GUI front end for Iptables "
		+ "which is a firewall that blocks <br> or allows network traffic."
		+ " Rules are put in to tables, these rules can be<br> set on a port or "
		+ " by source/destination addresses as well as on the <br>network card usually "
		+  " called eth0 or eth1 etc. Each function is labelled  <br>correctly" +
		" and the end user just has to enter an eth number or port number <br>or" +
		" source or destination IP and the rule they clicked on will" +
		" be implemented. <br> A word of warning: the order the rules go in" +
		" are vital to how the Iptables <br>are read, so if a rule you enter" +
		" does not work, view the table the rule<br> is in and see if there" +
		" are and rules countering what you want to do.<br> <br> This application" +
		" has conclusive viewing and deleting options so the <br>manipulation" +
		" of rules is quite easy. Default rules and opening and closing of<br>" +
		" ports and traffic flow are now trivial thanks to this GUI</html>");
}
if(e.getSource()== button2)
{
	label2.setText("<html>This option is set up to monitor the network and "
		+ "home computer. Each tool here <br> does a slightly different"
		+ " monitoring job, first option is: <br>Ifconfig to view the network "
		+ " configuration of the home computer. This discovers <br> IP and network "
		+ " card names both of which are required for many of the tools.<br><br>" 
		+ " Tcpdump and Tcptrace are both packet sniffers which capture traffic <br>" +
		"   on the network. Each tool outputs slightly different content all " +
		"  of which can be <br> useful for the network administrator. Each tool is named "+
		"  for their purpose and the<br> end  user just needs to put in port number " +
		"   or the IP or the network card <br> number, usually eth0 or eth1 <br> <br>" +
		"   Netstat will show network statisitcs on any given port/IP/sockets/route" +
		"   all that is <br>required  is user input in the fiels provided.</html>");

}
if(e.getSource()== button3)
{

label2.setText("<html>This option is set up to discover open ports on "
		+ "a network. Nmap monitors the<br> network and discovers"
		+ " possible vulnerabilities for the user to apply <br> remedies to secure "
		+ " the system. There are three main options for the end "
		+ "user; <br> <br> Easy scan; this option scans the most common 1,000 ports for"
		+ " each protocol, this <br> scan takes  less than a minute <br><br> Scan all ports; " +
		"   which scans all ports for each protocol, depending on  processing" +
		"  <br> power  of the computer may take several minutes. <br> <br>" +
		"   Scan all ports and services; which not only scans all ports but also" +
		"   the service on <br> each port  this scan can take a while. <br> <br>" +
		"    All that is required is for the end user to enter the IP of" +
		"    the computer or <br> network to be scanned.</html>");
	}
}
}