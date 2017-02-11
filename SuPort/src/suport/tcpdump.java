package suport;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * 
 * This class creates a drop down list for an end user to decide which function of tcpdump they want to use
 * @param tcpstatOptions this is the variable which the end user decides the functionality
 * 
 */

public class tcpdump implements ActionListener 
{
	
	@SuppressWarnings("rawtypes")
	static JComboBox tcpstatOptions= new JComboBox<Object>();
	String [] Options = new String []{"Capture Packets","Display Interfaces", "Display Packet in Hex", "Capture and save Packets", "Capture IP Address Packets", "Capture just TCP", "Capture from Port", "Capture from Source IP", "Capture from Destination IP"};
	static JTextField tcpDumpEth;
	static JTextField tcpDumpPort;
	static JTextField tcpDumpIp;
	static JTextField scanSeconds;
	static JTextField tcpDumpEth2;
	static JTextField scanSeconds2;

//Constructor
public tcpdump()
{
	  
	 tcpstatOptions = new JComboBox<Object>(Options);
	 iptables.jp.add(tcpstatOptions); 

	 tcpstatOptions.addActionListener(new ActionListener() 
	 {
    public void actionPerformed(ActionEvent e) 
    {
        //All options create Gui for input and call thread to execute
        if(tcpstatOptions.getSelectedItem().equals(Options[0]))
       {      	  
        iptables.jp.removeAll(); 
        iptables.jp.updateUI();
      	JLabel tcpDump = new JLabel("Enter Eth Number");  
        tcpDumpEth = new JTextField(10);
        JLabel tcpDump2 = new JLabel("length of scan in Seconds");  
        scanSeconds = new JTextField(10);

        JButton tcp1 = new JButton("Execute");
    	iptables.jp.add(tcpDump);
    	iptables.jp.add(tcpDumpEth);
    	iptables.jp.add(tcpDump2);
    	iptables.jp.add(scanSeconds);
    	
    	iptables.jp.add(tcp1);
         tcp1.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
            	(new Thread(new captureThePacket())).start();

            }
         });        	
        }
        
        if(tcpstatOptions.getSelectedItem().equals(Options[1]))
        {
        	iptables.jp.removeAll(); 
        	iptables.jp.updateUI();
    		(new Thread(new displayInterfaces())).start();
                  	
        }
        
        if(tcpstatOptions.getSelectedItem().equals(Options[2]))
        {
        	iptables.jp.removeAll(); 
        	iptables.jp.updateUI();
      	JLabel tcpDump = new JLabel("Enter Eth Number");  
        tcpDumpEth2 = new JTextField(10);
        JLabel tcpDump2 = new JLabel("length of scan in Seconds");  
        scanSeconds2 = new JTextField(10);

        JButton tcp2 = new JButton("Execute");
    	iptables.jp.add(tcpDump);
    	iptables.jp.add(tcpDumpEth2);
    	iptables.jp.add(tcpDump2);
    	iptables.jp.add(scanSeconds2);
    	
    	iptables.jp.add(tcp2);
         tcp2.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
    		(new Thread(new displayPacketsInHex())).start();

            }
         });
         iptables.jp.setVisible(true);        	
        }
        
        if(tcpstatOptions.getSelectedItem().equals(Options[3]))
        {
        	iptables.jp.removeAll(); 
        	iptables.jp.updateUI();
      	JLabel tcpDump = new JLabel("Enter Eth Number");  
        tcpDumpEth = new JTextField(10);
        JLabel tcpDump2 = new JLabel("To File");  
        tcpDumpPort = new JTextField(10);
       
        JButton tcp3 = new JButton("Execute");
    	iptables.jp.add(tcpDump);
    	iptables.jp.add(tcpDumpEth);
    	iptables.jp.add(tcpDump2);
    	
    	iptables. jp.add(tcpDumpPort);
    	iptables.jp.add(tcp3);
         tcp3.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {

    		(new Thread(new saveToFile())).start();
            }
         });
         iptables.jp.setVisible(true);        	
        }
        
        if(tcpstatOptions.getSelectedItem().equals(Options[4]))
        {
        	iptables.jp.removeAll(); 
        	iptables.jp.updateUI();
      	JLabel tcpDump = new JLabel("Enter Eth Number");  
        tcpDumpEth = new JTextField(10);
        JLabel tcpDump2 = new JLabel("length of scan in Seconds");  
        scanSeconds = new JTextField(10);

        JButton tcp4 = new JButton("Execute");
    	iptables.jp.add(tcpDump);
    	iptables.jp.add(tcpDumpEth);
    	iptables.jp.add(tcpDump2);
    	iptables.jp.add(scanSeconds);
    	
    	iptables.jp.add(tcp4);
         tcp4.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
    		(new Thread(new captureIpAddressPackets())).start();
            }
         });
         iptables.jp.setVisible(true);        	
        }
        
        if(tcpstatOptions.getSelectedItem().equals(Options[5]))
        {
        	iptables.jp.removeAll(); 
        	iptables.jp.updateUI();
      	JLabel tcpDump = new JLabel("Enter Eth Number");  
        tcpDumpEth = new JTextField(10);
        JLabel tcpDump2 = new JLabel("length of scan in Seconds");  
        scanSeconds = new JTextField(10);

        JButton tcp5 = new JButton("Execute");
    	iptables.jp.add(tcpDump);
    	iptables.jp.add(tcpDumpEth);
    	iptables.jp.add(tcpDump2);
    	iptables.jp.add(scanSeconds);
    	
    	iptables.jp.add(tcp5);
         tcp5.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
    		(new Thread(new captureTcpPackets())).start();

            }
         });
         iptables.jp.setVisible(true);        	
        }
        
        if(tcpstatOptions.getSelectedItem().equals(Options[6]))
        {
        	iptables.jp.removeAll(); 
        	iptables.jp.updateUI();
      	JLabel tcpDump = new JLabel("Enter Eth Number");  
        tcpDumpEth = new JTextField(10);
        JLabel tcpDump2 = new JLabel("Enter Port Number");  
        tcpDumpPort = new JTextField(10);
        JLabel tcpDump3 = new JLabel("length of scan in Seconds");  
        scanSeconds = new JTextField(10);

        JButton tcp6 = new JButton("Execute");
    	iptables.jp.add(tcpDump);
    	iptables.jp.add(tcpDumpEth);
    	iptables.jp.add(tcpDump2);
    	iptables.jp.add(tcpDumpPort);
    	iptables.jp.add(tcpDump3);
    	iptables.jp.add(scanSeconds);
    	
    	iptables.jp.add(tcp6);
         tcp6.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {

    		(new Thread(new captureFromPort())).start();
            }
         });
         iptables.jp.setVisible(true);        	
        }
        
        if(tcpstatOptions.getSelectedItem().equals(Options[7]))
        {
        	iptables.jp.removeAll(); 
        	iptables.jp.updateUI();
      	JLabel tcpDump = new JLabel("Enter Eth Number");  
        tcpDumpEth = new JTextField(10); 
        JLabel tcpDump3 = new JLabel("Enter IP Number");  
        tcpDumpIp = new JTextField(10);
        JLabel tcpDump2 = new JLabel("length of scan in Seconds");  
        scanSeconds = new JTextField(10);

        JButton tcp7 = new JButton("Execute");
    	iptables.jp.add(tcpDump);
    	iptables.jp.add(tcpDumpEth);	
    	iptables.jp.add(tcpDump3);
    	iptables. jp.add(tcpDumpIp);
    	iptables.jp.add(tcpDump2);
    	iptables.jp.add(scanSeconds);
    	iptables.jp.add(tcp7);
         tcp7.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
    		(new Thread(new captureFromSourceIp())).start();
            }
         });
         iptables.jp.setVisible(true);        	
        }
        
        if(tcpstatOptions.getSelectedItem().equals(Options[8]))
        {
        	iptables.jp.removeAll(); 
        	iptables.jp.updateUI();
        	JLabel tcpDump = new JLabel("Enter Eth Number");  
            tcpDumpEth = new JTextField(10); 
            JLabel tcpDump3 = new JLabel("Enter IP Number");  
            tcpDumpIp = new JTextField(10);
            JLabel tcpDump2 = new JLabel("length of scan in Seconds");  
            scanSeconds = new JTextField(10);

            JButton tcp8 = new JButton("Execute");
        	iptables.jp.add(tcpDump);
        	iptables.jp.add(tcpDumpEth);	
        	iptables.jp.add(tcpDump3);
        	iptables. jp.add(tcpDumpIp);
        	iptables.jp.add(tcpDump2);
        	iptables.jp.add(scanSeconds);
        	iptables.jp.add(tcp8);
         tcp8.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent e)
            {
    		(new Thread(new captureFromDestinationIp())).start();
            }
         });
         iptables.jp.setVisible(true);        	
        }            
    }
});
}
public void actionPerformed(ActionEvent arg0)
{	
}
}

