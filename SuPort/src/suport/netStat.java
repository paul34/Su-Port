package suport;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
/**
 * 
 * This class creates a drop down list for an end user to decide which function of Netstat they want to use
 * @param netstatoptions this is the variable which the end user decides the functionality
 * 
 */

public class netStat implements ActionListener
{
	//Create option box on GUI
	@SuppressWarnings("rawtypes")
	static JComboBox netstatOptions= new JComboBox<Object>();
	String [] Options = new String []{"List All Ports","List UDP Ports", "List TCP Ports", "List Sockets", "Show Stats for each Protocol", "Display Routing Information", "Show List of Network Interfaces"};
	
public netStat()
{  
	 netstatOptions = new JComboBox<Object>(Options);
	 iptables.jp.add(netstatOptions); 
//Get Options from end user
netstatOptions.addActionListener(new ActionListener() 
{
    public void actionPerformed(ActionEvent e) 
    {    
        if(netstatOptions.getSelectedItem().equals(Options[0]))
        {
      	  (new Thread(new listAllPorts())).start(); 	
        }
        
        if(netstatOptions.getSelectedItem().equals(Options[1]))
        {
        	  (new Thread(new listUdpPorts())).start();       	
        }
        
        if(netstatOptions.getSelectedItem().equals(Options[2]))
        {
        	  (new Thread(new listTcpPorts())).start();     	
        }
        
        if(netstatOptions.getSelectedItem().equals(Options[3]))
        {
        	  (new Thread(new listSockets())).start();      	
        }
        
        if(netstatOptions.getSelectedItem().equals(Options[4]))
        {
        	  (new Thread(new showProtocols())).start();       	
        }
        
        if(netstatOptions.getSelectedItem().equals(Options[5]))
        {
        	  (new Thread(new routingNetworks())).start();      	
        }
        
        if(netstatOptions.getSelectedItem().equals(Options[6]))
        {
        	  (new Thread(new listInterfaces())).start();      	
        }   
    }
});
}

public void actionPerformed(ActionEvent arg0) 
{	
}

}

