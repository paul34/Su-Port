package suport;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
 /**
   * 
   * This application makes use of the Unix command line tools to monitor and secure a network,
   * taking advantage of free to use software and applying them to an easy to use Gui front end.
   * The software used are Nmap, Iptables, Tcpdump, Netstat and Tcp track making it a good
   * all round tool to view network traffic as well as secure ports and traffic flow to both
   * the single computer and to a network.
   * 
   * @param balancetf These are JTexfields which take the user inputs and apply rules on ports network cards or IP's
   * @param balancePorttf 
   * @param balanceIp1tf
   * @param balanceIp2tf
   * @param balanceIp3tf
   * @param block
   * @param specSSHIpTo
   * @param specSSHEthTo
   * @param specSSHIp
   * @param specSSHEth
   * @param sqlIp
   * @param sqlEthtf
   * @param poptf
   * @param imaptf
   * @param HTTPtf
   * @param HTTPOuttf
   * @param HTTPSOuttf
   * @param HTTPSIntf
   * @param allowSSHtf
   * @param allowSSHOut
   * @param portforwardtf
   * @param port1tf
   * @param port2tf
   * @param portEth
   * @param ipNmapGroup
   * @param ipNmapGroupPorts
   * @param ipNmapGroupPortsAndSevices
   * @param ipNmap
   * @param ipNmapPorts
   * @param ipNmapPortsAndSevices
   * @param blockPort
   * @param limitConPort
   * @param limitConAmount
   * @param limitTimePort
   * @param limitTimeAmount
   * @param accessPort
   * @param portKnock1
   * @param portKnock2
   * @param LimitforLog
   * @param Level
   * @param Limit
   * @param Burst
   * @param port
   * @param tcpTracktf
   * @param tcpTrackEthtf
   * @param tcpTrackPorttf
   * @param blockHTTPtf
   * @param blockHTTPStf
   * @param blockHTTPtf2
   * @param blockHTTPStf2
   * @param allowSubEth1
   * @param allowSubEth2
   * @param allowSubIP1
   * @param allowSubIP2
   * @param allowComEth1
   * @param allowComEth2
   * @param allowComIP1
   * @param allowComIP2
   * @param BlockSubEth1
   * @param BlockSubEth2
   * @param BlockSubIP1
   * @param BlockSubIP2
   * @param BlockComEth1
   * @param BlockComEth2
   * @param BlockComIP1
   * @param BlockComIP2
   * @param allowEth1
   * @param allowEth2
   * @param allowIP1
   * @param allowIP2
   * @param allowPorts1
   * @param allowPorts2
   * @param blockEth1
   * @param blockEth2
   * @param blockIP1
   * @param blockIP2
   * @param blockPorts1
   * @param blockPorts2
   * @param natNum
   * @param filterNum
   * @param securityNum
   * @param rawNum
   * @param mangleNum
   * 
   * 
   * @author Paul Csendes B00073748
   */ 

@SuppressWarnings("serial")
public class iptables extends JFrame implements ActionListener
{
 //Create GUI
   static JPanel jp = new JPanel();
   static JPanel jp2 = new JPanel();
   static JPanel jp3 = new JPanel();

   String line = " ";
   JLabel eth1 = new JLabel("Enter First Eth");
   JLabel eth2 = new JLabel("Enter Second Eth");
   JLabel ip = new JLabel("Enter First IP");
   JLabel ip2 = new JLabel("Enter Second IP");
   JButton clear = new JButton("Clear Text Area");
   
//Create user input areas
   static JTextField balancetf;
   static JTextField balancePorttf;
   static JTextField balanceIp1tf;
   static JTextField balanceIp2tf;
   static JTextField balanceIp3tf;
   static JTextField block;
   static JTextField specSSHIpTo;
   static JTextField specSSHEthTo;
   static JTextField specSSHIp;
   static JTextField specSSHEth;
   static JTextField sqlIp;
   static JTextField sqlEthtf;
   static JTextField poptf;
   static JTextField imaptf;
   static JTextField HTTPtf;
   static JTextField HTTPOuttf;
   static JTextField HTTPSOuttf;
   static JTextField HTTPSIntf;
   static JTextField allowSSHtf;
   static JTextField allowSSHOut;
   static JTextField portforwardtf;
   static JTextField port1tf;
   static JTextField port2tf;
   static JTextField portEth;
   static JTextField ipNmapGroup;
   static JTextField ipNmapGroupPorts;
   static JTextField ipNmapGroupPortsAndSevices;
   static JTextField ipNmap;
   static JTextField ipNmapPorts;
   static JTextField ipNmapPortsAndSevices;
   static JTextField blockPort;
   static JTextField limitConPort;
   static JTextField limitConAmount;
   static JTextField limitTimePort;
   static JTextField limitTimeAmount;
   static JTextField accessPort;
   static JTextField portKnock1;
   static JTextField portKnock2;
   static JTextField LimitforLog;
   static JTextField Level;
   static JTextField Limit;
   static JTextField Burst;
   static JTextField port;
   static JTextField tcpTracktf;
   static JTextField tcpTrackEthtf;
   static JTextField tcpTrackPorttf;
   static JTextField blockHTTPtf;
   static JTextField blockHTTPStf;
   static JTextField blockHTTPtf2;
   static JTextField blockHTTPStf2;
   static JTextField allowSubEth1;
   static JTextField allowSubEth2;
   static JTextField allowSubIP1;
   static JTextField allowSubIP2;
   static JTextField allowComEth1;
   static JTextField allowComEth2;
   static JTextField allowComIP1;
   static JTextField allowComIP2;
   static JTextField BlockSubEth1;
   static JTextField BlockSubEth2;
   static JTextField BlockSubIP1;
   static JTextField BlockSubIP2;
   static JTextField BlockComEth1;
   static JTextField BlockComEth2;
   static JTextField BlockComIP1;
   static JTextField BlockComIP2;
   static JTextField allowEth1;
   static JTextField allowEth2;
   static JTextField allowIP1;
   static JTextField allowIP2;
   static JTextField allowPorts1;
   static JTextField allowPorts2;
   static JTextField blockEth1;
   static JTextField blockEth2;
   static JTextField blockIP1;
   static JTextField blockIP2;
   static JTextField blockPorts1;
   static JTextField blockPorts2;
   static JTextField natNum;
   static JTextField filterNum;
   static JTextField securityNum;
   static JTextField rawNum;
   static JTextField mangleNum;

 //Create textarea to print out information
   static JTextArea textArea = new JTextArea();
   JScrollPane scrollPane = new JScrollPane(textArea); 

 //Constructor
 public iptables()
 {
  setTitle("Su-Port");
  setVisible(true);
  setSize(850, 380);
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  scrollPane.setPreferredSize(new Dimension(825, 215));

  jp2.setBorder((Border)new TitledBorder(new EtchedBorder(),"Display Area"));
  jp.setBorder((Border)new TitledBorder (new EtchedBorder()));
  jp.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(2.0f)));
  JLabel label;
  label = new JLabel("Su-Port");
  label.setFont(new Font("Serif", Font.ITALIC, 65));
  jp.add(label);

 //Create Menu bar
  JMenuBar bar = new JMenuBar();
  JMenu files = new JMenu("Firewall Options");
  JMenuItem delete = new JMenu("Delete Rules");
  JMenuItem deleteNat = new JMenuItem("Delete NAT Table");
  JMenuItem deleteMangle = new JMenuItem("Delete Mangle Table");
  JMenuItem deleteFilter = new JMenuItem("Delete Filter Table");
  JMenuItem deleteSecurity = new JMenuItem("Delete Security Table");
  JMenuItem deleteRaw = new JMenuItem("Delete Raw Table");
  JMenuItem deleteAll = new JMenuItem("Delete All Rules");
  delete.add(deleteNat);
  delete.add(deleteMangle);
  delete.add(deleteFilter);
  delete.add(deleteRaw);
  delete.add(deleteSecurity);
  delete.add(deleteAll);
  JMenuItem deleteOneRule = new JMenuItem("Delete One Rule");
  JMenuItem viewRules = new JMenu("View Rules");
  JMenuItem viewNat = new JMenuItem("View NAT Table");
  JMenuItem viewMangle = new JMenuItem("View Mangle Table");
  JMenuItem viewFilter = new JMenuItem("View Filter Table");
  JMenuItem viewSecurity = new JMenuItem("View Security Table");
  JMenuItem viewAll = new JMenuItem("View Overall Rules");
  JMenuItem viewRaw = new JMenuItem("View Raw Table");
  viewRules.add(viewNat);
  viewRules.add(viewMangle);
  viewRules.add(viewFilter);
  viewRules.add(viewRaw);
  viewRules.add(viewSecurity);
  viewRules.add(viewAll);

  JMenuItem defaultChain = new JMenuItem("Select Default Chain Policies");
  JMenuItem blockIP = new JMenuItem("Block Ip address");
  JMenuItem allowAllssh = new JMenuItem("Allow All incoming SSH");
  JMenuItem allowSSHOut = new JMenuItem("Allow All Outgoing SSH");
  JMenuItem allowSSHFromNetwork = new JMenuItem("Allow SSH From Specific Network");
  JMenuItem allowSSHToNetwork = new JMenuItem("Allow SSH To Specific Network");
  JMenuItem allowHttpIn = new JMenuItem("Allow All HTTP In");
  JMenuItem allowHttpOut = new JMenuItem("Allow All HTTP Out");
  JMenuItem allowHttps = new JMenuItem("Allow All HTTPS In");
  JMenuItem allowHttpsOut = new JMenuItem("Allow All HTTPS Out");
  JMenuItem blockHttp = new JMenuItem("Block All HTTP");
  JMenuItem blockHttps = new JMenuItem("Block All HTTPS");
  JMenuItem loadBalance = new JMenuItem("Load Balancing");
  JMenuItem allowPingIn = new JMenuItem("Allow Pings In");
  JMenuItem allowPingOut = new JMenuItem("Allow Pings Out");
  JMenuItem allowSQL = new JMenuItem("Allows SQL Connection");
  JMenuItem allowImap = new JMenuItem("Allows IMAP Connection");
  JMenuItem allowPop = new JMenuItem("Allows POP Connection");
  JMenuItem denyDos = new JMenuItem("Prevent DOS attack");
  JMenuItem portForwarding = new JMenuItem("Allows Port Forwarding");
  JMenuItem blockPort = new JMenuItem("Close Port");
  JMenuItem limitTime = new JMenuItem("Limit Time on Connections");
  JMenuItem limitConnections = new JMenuItem("Limit Connections");
  JMenuItem portKnocking = new JMenuItem("Port Knocking");
  JMenuItem allowLogging = new JMenu("Logging");
  JMenuItem allowLoggingIn = new JMenuItem("Log New Connections Incoming");
  JMenuItem allowLoggingOut = new JMenuItem("Log New Connections Outgoing");
  JMenuItem allowLoggingDo = new JMenuItem("Show Logging");
  allowLogging.add(allowLoggingIn);
  allowLogging.add(allowLoggingOut);
  allowLogging.add(allowLoggingDo); 
  JMenuItem insideNet = new JMenu("Internal Network Options");
  JMenuItem internetAccSub = new JMenuItem("Allow Subnet To Internet");
  JMenuItem allowSub = new JMenuItem("Allow Subnets To Communicate");
  JMenuItem internetBlockSub = new JMenuItem("Block Subnet To Internet");
  JMenuItem blockSub = new JMenuItem("Block Subnets To Communicate");
  JMenuItem blockPortsSub = new JMenuItem("Block Ports Between Subnets");
  JMenuItem allowPortsSub = new JMenuItem("Allow Ports Between Subnets");
  insideNet.add(internetBlockSub);
  insideNet.add(internetAccSub);
  insideNet.add(blockSub);
  insideNet.add(allowSub);
  insideNet.add(blockPortsSub);    
  insideNet.add(allowPortsSub); 
  JMenuItem save = new JMenuItem("Save");
  JMenuItem restore = new JMenuItem("Restore");
  
  JMenu nfiles = new JMenu("Nmap Options");
  JMenuItem homeComp = new JMenu("Nmap Scan Home computer");
  JMenuItem heasyScan = new JMenuItem("Easy Scan");
  JMenuItem hmedScan = new JMenuItem("Scan All Ports");
  JMenuItem hhardScan = new JMenuItem("Scan All Ports and Services");
  JMenuItem groupComp = new JMenu("Nmap Scan Network computers");
  JMenuItem easyScan = new JMenuItem("Easy Group Scan");
  JMenuItem medScan = new JMenuItem("Scan All Group Ports");
  JMenuItem hardScan = new JMenuItem("Scan All Group Ports and Services");
  homeComp.add(heasyScan);
  homeComp.add(hmedScan);
  homeComp.add(hhardScan);
  groupComp.add(easyScan);
  groupComp.add(medScan);
  groupComp.add(hardScan);
  
  JMenu netfiles = new JMenu("Network Information");
  JMenuItem ifConfig = new JMenuItem("IfConfig");
  JMenuItem tcpTrack = new JMenu("tcptrack");
  JMenuItem tcptrackEth = new JMenuItem("tcptrack by Network Card");
  JMenuItem tcptrackPort = new JMenuItem("tcptrack by Port");
  tcpTrack.add(tcptrackEth);
  tcpTrack.add(tcptrackPort);
  JMenuItem tcpdump = new JMenuItem("tcpdump");
  JMenuItem netstat = new JMenuItem("netstat");
  
  netfiles.add(ifConfig);
  netfiles.add(tcpTrack);
  netfiles.add(tcpdump);
  netfiles.add(netstat);

  JMenu helpMenu = new JMenu("Help");
  JMenuItem itemHelp = new JMenuItem("Help");
  helpMenu.add(itemHelp);

 //Add action Listeners
  itemHelp.addActionListener(this);
  delete.addActionListener(this);
  viewRules.addActionListener(this);
  deleteOneRule.addActionListener(this);
  defaultChain.addActionListener(this);
  blockIP.addActionListener(this);
  allowAllssh.addActionListener(this);
  allowSSHOut.addActionListener(this);
  allowSSHFromNetwork.addActionListener(this);
  allowSSHToNetwork.addActionListener(this);
  allowHttpIn.addActionListener(this);
  allowHttpOut.addActionListener(this);
  allowHttps.addActionListener(this);
  allowHttpsOut.addActionListener(this);
  blockHttps.addActionListener(this);
  blockHttp.addActionListener(this);
  loadBalance.addActionListener(this);
  allowPingIn.addActionListener(this);
  allowPingOut.addActionListener(this);
  allowSQL.addActionListener(this);
  allowImap.addActionListener(this);
  allowPop.addActionListener(this);
  denyDos.addActionListener(this);
  portForwarding.addActionListener(this);
  allowLogging.addActionListener(this);
  allowLoggingIn.addActionListener(this);
  allowLoggingOut.addActionListener(this);
  allowLoggingDo.addActionListener(this);
  heasyScan.addActionListener(this);
  hmedScan.addActionListener(this);
  hhardScan.addActionListener(this);  
  easyScan.addActionListener(this);
  medScan.addActionListener(this);
  hardScan.addActionListener(this);  
  ifConfig.addActionListener(this);
  tcptrackEth.addActionListener(this);
  tcptrackPort.addActionListener(this);
  blockPort.addActionListener(this);
  limitTime.addActionListener(this);
  limitConnections.addActionListener(this);  
  portKnocking.addActionListener(this);
  save.addActionListener(this);  
  restore.addActionListener(this);
  tcpdump.addActionListener(this);  
  netstat.addActionListener(this);
  internetAccSub.addActionListener(this);  
  allowSub.addActionListener(this);
  internetBlockSub.addActionListener(this);  
  blockSub.addActionListener(this);
  blockPortsSub.addActionListener(this);  
  allowPortsSub.addActionListener(this);
  viewNat.addActionListener(this);
  viewMangle.addActionListener(this);
  viewFilter.addActionListener(this);
  viewRaw.addActionListener(this);
  viewSecurity.addActionListener(this);
  viewAll.addActionListener(this);
  deleteNat.addActionListener(this);
  deleteMangle.addActionListener(this);
  deleteFilter.addActionListener(this);
  deleteRaw.addActionListener(this);
  deleteSecurity.addActionListener(this);
  deleteAll.addActionListener(this);
 
 //Menus adding the options
  nfiles.add(homeComp);
  nfiles.add(groupComp);
  
  helpMenu.add(itemHelp);

  files.add(viewRules);
  files.add(defaultChain);
  files.add(blockIP);
  files.add(allowAllssh);
  files.add(allowSSHOut);
  files.add(allowSSHFromNetwork);
  files.add(allowSSHToNetwork);
  files.add(allowHttpIn);
  files.add(allowHttpOut);
  files.add(allowHttps);
  files.add(allowHttpsOut);
  files.add(blockHttp);
  files.add(blockHttps);
  files.add(loadBalance);
  files.add(allowPingIn);
  files.add(allowPingOut);
  files.add(allowSQL);
  files.add(allowImap);
  files.add(allowPop);
  files.add(blockPort);
  files.add(limitTime);
  files.add(limitConnections);
  files.add(portKnocking);
  files.add(denyDos);
  files.add(portForwarding);
  files.add(allowLogging);
  files.add(insideNet);
  
  files.addSeparator();
  files.add(save);
  files.add(restore);

  files.addSeparator();
  files.add(delete);
  files.add(deleteOneRule);
 
  bar.add(netfiles);  
  bar.add(files);  
  bar.add(nfiles);
  bar.add(helpMenu);  

  setJMenuBar(bar);
  
  textArea.setEditable(false);
  scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
  jp2.add(scrollPane);
  clear.setPreferredSize(new Dimension(160, 105));

  clear.addActionListener(new ActionListener()
  {
     public void actionPerformed(ActionEvent e)
     {
    	 textArea.setText(" ");
    	 jp2.updateUI(); 
    	 setVisible(true);
    	 
     }
  });
  jp3.add(clear);
  add(jp, BorderLayout.CENTER);
  add(jp2, BorderLayout.SOUTH);
  add(jp3, BorderLayout.WEST);

  
  addWindowListener(new WindowAdapter() 
  {
@Override
public void windowClosing(WindowEvent e)
{
//On close of application delete used files
	try {
		(new Thread(new cleanUpFiles())).start();
		cleanUpFiles.deleteFiles();
		} 
	catch (IOException e1) 
		{
	  	 e1.printStackTrace();
	  	}  			
	}
});
}

public static void main(String[] args)
{
	//calls instance of class and sets it visible
	new iptables().setVisible(true);
}
//Action Events
public void actionPerformed(ActionEvent e) 
{
	String event = e.getActionCommand();
	
///////////////////////////////////
//Help Options
	if(event.equals("Help"))
	{
		new help();
	}
	
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
//Network Observations 
if(event.equals("IfConfig"))
{
	(new Thread(new ifConfig())).start();
}

if(event.equals("tcptrack by Network Card"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel imap = new JLabel("Enter Eth Number");  
    tcpTracktf = new JTextField(10);
    JButton imapButton = new JButton("Execute");
	 jp.add(imap);
     jp.add(tcpTracktf);
     jp.add(imapButton);
     imapButton.addActionListener(new ActionListener()
     {
       public void actionPerformed(ActionEvent e)
        {
    	 (new Thread(new tcpPrintout())).start();

    	  (new Thread(new tcptrackbyEth())).start();
         }
     });
     setVisible(true); 
}

if(event.equals("tcptrack by Port"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel imap = new JLabel("Enter Eth Number");  
    tcpTrackEthtf = new JTextField(10);
    JLabel imap2 = new JLabel("Enter Port Number");  
    tcpTrackPorttf = new JTextField(10);
    JButton tcpButton = new JButton("Execute");
    JButton tcpButton2 = new JButton("Stop");

	 jp.add(imap);
     jp.add(tcpTrackEthtf);
     jp.add(imap2);
     jp.add(tcpTrackPorttf);
     jp.add(tcpButton);
     jp.add(tcpButton2);
     tcpButton.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
		(new Thread(new tcpPrintout())).start();
		(new Thread(new tcptrackbyPort())).start();
        }
     });
     tcpButton2.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
        	try {
    			Runtime.getRuntime().exec(new String [] {"killall tcptrack"});
    		} 
        	catch (IOException e1) 
    		{
    			e1.printStackTrace();
    		}        
        }
     });
     setVisible(true); 
}

	 if(event.equals("tcpdump"))
	{
		 jp.removeAll(); 
		 jp.updateUI();
		 new tcpdump();
	}
	 
	 if(event.equals("netstat"))
	{
		 jp.removeAll(); 
		 jp.updateUI();
		 new netStat();
	}
		
/////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////
//NMAP Options
if(event.equals("Easy Scan")) 
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel imap = new JLabel("Enter Ip number");  
    ipNmap = new JTextField(10);
    JButton imapButton = new JButton("Execute");
	 jp.add(imap);
     jp.add(ipNmap);
     jp.add(imapButton);
     imapButton.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
		(new Thread(new homeComputerNmap())).start();             	
        }
     });
     setVisible(true);    	
}

if(event.equals("Scan All Ports"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel imap = new JLabel("Enter Ip number");  
    ipNmapPorts = new JTextField(10);
    JButton imapButton = new JButton("Execute");
	 jp.add(imap);
     jp.add(ipNmapPorts);
     jp.add(imapButton);
     imapButton.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
		(new Thread(new homeComputerAllports())).start();             	
        }
     });
     setVisible(true);   
}

if(event.equals("Scan All Ports And Services"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel imap = new JLabel("Enter Ip number");  
    ipNmapPortsAndSevices = new JTextField(10);
    JButton imapButton = new JButton("Execute");
	 jp.add(imap);
     jp.add(ipNmapPortsAndSevices);
     jp.add(imapButton);
     imapButton.addActionListener(new ActionListener()
     {
            public void actionPerformed(ActionEvent e)
            {
    			(new Thread(new homeComputerAllPortsAndServices())).start();             	
            }
     });
     setVisible(true);    		
}

if(event.equals("Easy Group Scan"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel imap = new JLabel("Enter Ip number");  
    ipNmapGroup = new JTextField(10);
    JButton imapButton = new JButton("Execute");
	 jp.add(imap);
     jp.add(ipNmapGroup);
     jp.add(imapButton);
     imapButton.addActionListener(new ActionListener()
     {
            public void actionPerformed(ActionEvent e)
            {
    			(new Thread(new groupNmap())).start();             	
            }
     });
     setVisible(true);    		
}

if(event.equals("Scan All Group Ports"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel imap = new JLabel("Enter Ip number");  
    ipNmapGroupPorts = new JTextField(10);
    JButton imapButton = new JButton("Execute");
	 jp.add(imap);
     jp.add(ipNmapGroupPorts);
     jp.add(imapButton);
     imapButton.addActionListener(new ActionListener()
     {
            public void actionPerformed(ActionEvent e)
            {
    			(new Thread(new groupNmapAllPorts())).start();             	
            }
     });
     setVisible(true); 	
}

if(event.equals("Scan All Group Ports And Services"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel imap = new JLabel("Enter Ip number");  
    ipNmapGroupPortsAndSevices = new JTextField(10);
    JButton imapButton = new JButton("Execute");
	 jp.add(imap);
     jp.add(ipNmapGroupPortsAndSevices);
     jp.add(imapButton);
     imapButton.addActionListener(new ActionListener()
     {
            public void actionPerformed(ActionEvent e)
            {
    			(new Thread(new groupNmapAllPortsAndServices())).start();             	
            }
     });
     setVisible(true);    	
}
///////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////
//Below Are Firewall Options

if(event.equals("View NAT Table"))
{
	(new Thread(new checkNatRules())).start();  		
}

if(event.equals("View Security Table"))
{
	(new Thread(new checkSecurityRules())).start();
}

if(event.equals("View Overall Rules"))
{
	(new Thread(new checkAllRules())).start();
}
if(event.equals("View Mangle Table"))
{
	(new Thread(new checkMangleRules())).start();
}
if(event.equals("View Filter Table"))
{
	(new Thread(new checkFilterRules())).start();   	
}
if(event.equals("View Raw Table"))
{
	(new Thread(new checkRawRules())).start();  	
}

if(event.equals("Delete NAT Table"))
{
	(new Thread(new deleteNatTable())).start();	
}

if(event.equals("Delete Security Table"))
{
	(new Thread(new deleteSecurityTable())).start();
}

if(event.equals("Delete Overall Rules"))
{
	(new Thread(new deleteRules())).start();
}
if(event.equals("Delete Mangle Table"))
{
	(new Thread(new deleteMangleTable())).start();
}
if(event.equals("Delete Filter Table"))
{
	(new Thread(new deleteFilterTable())).start();    	
}
if(event.equals("Delete Raw Table"))
{
	(new Thread(new deleteRawTable())).start();  	
}

 if(event.equals("Allow Subnet To Internet"))
{
	 jp.removeAll(); 
	jp.updateUI();
    JLabel blocke = new JLabel("Enter Eth of Internal Interface");  
    allowSubEth1 = new JTextField(10);
    JLabel blocke2 = new JLabel("Enter Eth of External Interface");  
    allowSubEth2 = new JTextField(10);
    JLabel blocke3 = new JLabel("Enter IP of Internal Interface");  
    allowSubIP1 = new JTextField(10);
    JLabel blocke4 = new JLabel("Enter IP of External Interface Gateway");  
    allowSubIP2 = new JTextField(10);
    JButton blocker = new JButton("Execute");
	 jp.add(blocke);
     jp.add(allowSubEth1);
	 jp.add(blocke2);
     jp.add(allowSubEth2);
     jp.add(blocke3);
     jp.add(allowSubIP1);
	 jp.add(blocke4);
     jp.add(allowSubIP2);
     jp.add(blocker);
      blocker.addActionListener(new ActionListener()
      {
             public void actionPerformed(ActionEvent e)
             {
				(new Thread(new allowSubToInternet())).start();
             }
      });
     setVisible(true);            	 
}
 
 if(event.equals("Allow Subnets To Communicate"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel blocke = new JLabel("Enter Eth of First Subnet");  
    allowComEth1 = new JTextField(10);
	JLabel blocke2 = new JLabel("Enter Eth of Second Subnet");  
    allowComEth2 = new JTextField(10);
    JLabel blocke3 = new JLabel("Enter IP of First Subnet");  
	allowComIP1 = new JTextField(10);
	JLabel blocke4 = new JLabel("Enter IP of Second Subnet");  
	allowComIP2 = new JTextField(10);
	JButton blocker = new JButton("Execute");
	jp.add(blocke);
    jp.add(allowComEth1);
	jp.add(blocke2);
    jp.add(allowComEth2);
    jp.add(blocke3);
    jp.add(allowComIP1);
	jp.add(blocke4);
    jp.add(allowComIP2);
    jp.add(blocker);
    blocker.addActionListener(new ActionListener()
       {
          public void actionPerformed(ActionEvent e)
          {
			(new Thread(new allowSubToCommunicate())).start();
          }
       });
	     setVisible(true);          	 
}

 if(event.equals("Block Subnet To Internet"))
{
 	 jp.removeAll(); 
	jp.updateUI();
    JLabel blocke = new JLabel("Enter Eth of Internal Interface");  
    BlockSubEth1 = new JTextField(10);
    JLabel blocke2 = new JLabel("Enter Eth of External Interface");  
    BlockSubEth2 = new JTextField(10);
    JLabel blocke3 = new JLabel("Enter IP of Internal Interface");  
    BlockSubIP1 = new JTextField(10);
    JLabel blocke4 = new JLabel("Enter IP of External Interface Gateway");  
    BlockSubIP2 = new JTextField(10);
	JButton blocker = new JButton("Execute");
	jp.add(blocke);
    jp.add(BlockSubEth1);
	jp.add(blocke2);
    jp.add(BlockSubEth2);
    jp.add(blocke3);
    jp.add(BlockSubIP1);
	jp.add(blocke4);
    jp.add(BlockSubIP2);
    jp.add(blocker);
    blocker.addActionListener(new ActionListener()
    {
          public void actionPerformed(ActionEvent e)
          {
			(new Thread(new BlockSubToInternet())).start();
          }
       });
	     setVisible(true);           	 
}
  
  if(event.equals("Block Subnets To Communicate"))
{
 	jp.removeAll(); 
	jp.updateUI();
    JLabel blocke = new JLabel("Enter Eth of First Subnet");  
    BlockComEth1 = new JTextField(10);
    JLabel blocke2 = new JLabel("Enter Eth of Second Subnet");  
    BlockComEth2 = new JTextField(10);
    JLabel blocke3 = new JLabel("Enter IP of First Subnet");  
    BlockComIP1 = new JTextField(10);
    JLabel blocke4 = new JLabel("Enter IP of Second Subnet");  
    BlockComIP2 = new JTextField(10);
	JButton blocker = new JButton("Execute");
	jp.add(blocke);
    jp.add(BlockComEth1);
	jp.add(blocke2);
    jp.add(BlockComEth2);
    jp.add(blocke3);
    jp.add(BlockComIP1);
	jp.add(blocke4);
       jp.add(BlockComIP2);
       jp.add(blocker);
       blocker.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
			(new Thread(new BlockSubToCommunicate())).start();
           }
        });
 	     setVisible(true);             	 
}
 
 if(event.equals("Block Ports Between Subnets"))
{
    jp.removeAll(); 
	jp.updateUI();
	JLabel blocke = new JLabel("Enter Port for First Subnet");  
	blockPorts1 = new JTextField(10);
	JLabel blocke2 = new JLabel("Enter Port for Second Subnet");  
	blockPorts2 = new JTextField(10);
	JLabel blocke3 = new JLabel("Enter IP for First Subnet");  
	blockIP1 = new JTextField(10);
	JLabel blocke4 = new JLabel("Enter IP for Second Subnet");  
	blockIP2 = new JTextField(10);
	JLabel blocke5 = new JLabel("Enter Eth of First Subnet");  
	blockEth1 = new JTextField(10);
	JLabel blocke6 = new JLabel("Enter Eth of Second Subnet");  
	blockEth2 = new JTextField(10);
	JButton blocker = new JButton("Execute");
    jp.add(blocke);
    jp.add(blockPorts1);
    jp.add(blocke2);
    jp.add(blockPorts2);
    jp.add(blocke3);
    jp.add(blockIP1);
    jp.add(blocke4);
    jp.add(blockIP2);
    jp.add(blocke5);
    jp.add(blockEth1);
    jp.add(blocke6);
    jp.add(blockEth2);
    jp.add(blocker);
	blocker.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
			(new Thread(new blockPortsfromSub())).start();
        }
     });
     setVisible(true);        	 
}
 
 if(event.equals("Allow Ports Between Subnets"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel blocke = new JLabel("Enter Port for First Subnet");  
    allowPorts1 = new JTextField(10);
    JLabel blocke2 = new JLabel("Enter Port for Second Subnet");  
    allowPorts2 = new JTextField(10);
    JLabel blocke3 = new JLabel("Enter IP for First Subnet");  
    allowIP1 = new JTextField(10);
    JLabel blocke4 = new JLabel("Enter IP for Second Subnet");  
    allowIP2 = new JTextField(10);
    JLabel blocke5 = new JLabel("Enter Eth of First Subnet");  
	allowEth1 = new JTextField(10);
	JLabel blocke6 = new JLabel("Enter Eth of Second Subnet");  
	allowEth2 = new JTextField(10);
	JButton blocker = new JButton("Execute");
	   jp.add(blocke);
       jp.add(allowPorts1);
	   jp.add(blocke2);
       jp.add(allowPorts2);
       jp.add(blocke3);
       jp.add(allowIP1);
	   jp.add(blocke4);
       jp.add(allowIP2);
       jp.add(blocke5);
       jp.add(allowEth1);
	   jp.add(blocke6);
       jp.add(allowEth2);
       jp.add(blocker);
        blocker.addActionListener(new ActionListener()
        {
               public void actionPerformed(ActionEvent e)
               {
				(new Thread(new openPortsfromSub())).start();
               }
        });
 	     setVisible(true);       	 
}
 
if(event.equals("Close Port"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel blocke = new JLabel("Enter Port You Want to Block");  
	blockPort = new JTextField(10);
	JButton blocker = new JButton("Execute");
	 jp.add(blocke);
     jp.add(blockPort);
     jp.add(blocker);
     blocker.addActionListener(new ActionListener()
     {
            public void actionPerformed(ActionEvent e)
            {
				(new Thread(new openPortsfromSub())).start();
            }
     });
     setVisible(true);     
}

if(event.equals("Limit Time on Connections"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel blocke = new JLabel("Enter port");  
	limitTimePort = new JTextField(10);
	JLabel blocke2 = new JLabel("Enter how Many Connections");  
	limitTimeAmount = new JTextField(10);
	JButton blocker = new JButton("Execute");
	 jp.add(blocke);
     jp.add(limitTimePort);
	 jp.add(blocke2);
     jp.add(limitTimeAmount);
     jp.add(blocker);
     blocker.addActionListener(new ActionListener()
     {
            public void actionPerformed(ActionEvent e)
            {
				(new Thread(new limitConnections())).start();
            }
     });
     setVisible(true);           	
}

if(event.equals("Limit Connections"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel blocke = new JLabel("Enter port");  
	limitConPort = new JTextField(10);
	JLabel blocke2 = new JLabel("Enter how Many Connections");  
	limitConAmount = new JTextField(10);
	JButton blocker = new JButton("Execute");
	 jp.add(blocke);
     jp.add(limitConPort);
	 jp.add(blocke2);
     jp.add(limitConAmount);
     jp.add(blocker);
     blocker.addActionListener(new ActionListener()
     {
            public void actionPerformed(ActionEvent e)
            {
				(new Thread(new limitTime())).start();
            }
     });
     setVisible(true);           	
}

if(event.equals("Port Knocking"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel blocke = new JLabel("Enter port You Want to Access");  
	accessPort = new JTextField(10);
	JLabel blocke2 = new JLabel("Enter port 1 to Knock");  
	portKnock1 = new JTextField(10);
	JLabel blocke3 = new JLabel("Enter port 2 to Knock");  
	portKnock2 = new JTextField(10);
	JButton blocker = new JButton("Execute");
	 jp.add(blocke);
     jp.add(accessPort);
	 jp.add(blocke2);
     jp.add(portKnock1);
	 jp.add(blocke3);
     jp.add(portKnock2);
     jp.add(blocker);
     blocker.addActionListener(new ActionListener()
     {
            public void actionPerformed(ActionEvent e)
            {
				(new Thread(new portKnocking())).start();
            }
     });
     setVisible(true);          	
}

if(event.equals("Delete All Rules"))
{
	jp.removeAll(); 
	jp.updateUI();
	String message = "Are you Sure?";
	String title = "Are you Sure?";

	 int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) 
        {
			(new Thread(new deleteRules())).start();
        }
        else {	          
        }			
}

if(event.equals("Delete One Rule"))
{
	jp.removeAll(); 
	jp.updateUI();
	String[] options = new String[] {"Nat", "Filter", "Mangle", "Raw", "Security", "IPRules"};
	int response = JOptionPane.showOptionDialog(null, "Select the chain Policies", "Selection",
    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
    null, options, options[0]);
if(response == 0)
{
	(new Thread(new checkNatRules())).start();

	jp.removeAll(); 
	jp.updateUI();
    JLabel nat = new JLabel("Enter The number of the rule in the List:");  
	natNum = new JTextField(10);
	
	 JButton sqlButton = new JButton("Execute");
	 jp.add(nat);
     jp.add(natNum);
     jp.add(sqlButton);
     sqlButton.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
			(new Thread(new deleteNatRule())).start();
        }
     });
     setVisible(true);       			    	
}

if(response == 1)
{
	(new Thread(new checkFilterRules())).start();
	
	jp.removeAll(); 
	jp.updateUI();
    JLabel nat = new JLabel("Enter The number of the rule in the List:");  
	filterNum = new JTextField(10);
	
	 JButton filterButton = new JButton("Execute");
	 jp.add(nat);
     jp.add(filterNum);
     jp.add(filterButton);
     filterButton.addActionListener(new ActionListener()
     {
            public void actionPerformed(ActionEvent e)
            {
    			(new Thread(new deleteFilterRule())).start();
            }
     });
     setVisible(true);       			
}
if(response == 2)
{

	jp.removeAll(); 
	jp.updateUI();
    JLabel nat = new JLabel("Enter The number of the rule in the List:");  
	mangleNum = new JTextField(10);
	
	 JButton filterButton = new JButton("Execute");
	 jp.add(nat);
     jp.add(mangleNum);
     jp.add(filterButton);
     filterButton.addActionListener(new ActionListener()
     {
            public void actionPerformed(ActionEvent e)
            {
    			(new Thread(new deleteMangleRule())).start();
            }
     });
     setVisible(true);    			    	
}

if(response == 3)
{
	(new Thread(new checkRawRules())).start();
	
	jp.removeAll(); 
	jp.updateUI();
    JLabel nat = new JLabel("Enter The number of the rule in the List:");  
	rawNum = new JTextField(10);
	
	 JButton filterButton = new JButton("Execute");
	 jp.add(nat);
     jp.add(rawNum);
     jp.add(filterButton);
     filterButton.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
			(new Thread(new deleteRawRule())).start();
        }
     });
     setVisible(true);    			    	
}

if(response == 4)
{
	(new Thread(new checkSecurityRules())).start();
	jp.removeAll(); 
	jp.updateUI();
    JLabel nat = new JLabel("Enter The number of the rule in the List:");  
	securityNum = new JTextField(10);
	
	 JButton filterButton = new JButton("Execute");
	 jp.add(nat);
     jp.add(securityNum);
     jp.add(filterButton);
     filterButton.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
			(new Thread(new deleteSecurityRule())).start();
        }
     });
     setVisible(true);    
	    }
	    
if(response == 5)
{
	(new Thread(new checkAllRules())).start();
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e1) {
		e1.printStackTrace();
	}
	new deleteOneRule();	    	
}
else{		    	
}		
}
		
if(event.equals("Select Default Chain Policies"))
{
	jp.removeAll(); 
	jp.updateUI();
    String[] options = new String[] {"Input", "Output", "Forward", "Cancel"};
	int response = JOptionPane.showOptionDialog(null, "Select the chain Policies", "Selection",
    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
    null, options, options[0]);
if(response == 0)
{
	textArea.setText("Input Chain Selected");
	String[] choose1 = new String[] {"Allow", "Drop", "Cancel"};
    int response1 = JOptionPane.showOptionDialog(null, "Select the chain Policies", "Selection",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
        null, choose1, choose1[0]);
    if (response1 ==0)
    {
		(new Thread(new inputAllow())).start();		    	
    }
    if (response1 ==1)
    {
		(new Thread(new inputDrop())).start();		    	

    }
    else{
    	
    }
}
if(response == 1)
{
	textArea.setText("Output Chain Selected");

	String[] choose2 = new String[] {"Allow", "Drop", "Cancel"};
    int response2 = JOptionPane.showOptionDialog(null, "Select the chain Policies", "Seclection",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
        null, choose2, choose2[0]);
    if (response2 ==0)
    {
		(new Thread(new outputAllow())).start();		    	
    }
    if (response2 ==1)
    {
		(new Thread(new outputDrop())).start();		    	
    }
    else{	    	
    }
}
if(response == 2)
{
	textArea.setText("Forward Chain Selected");
	String[] choose3 = new String[] {"Allow", "Drop", "Cancel"};
    int response3 = JOptionPane.showOptionDialog(null, "Select the chain Policies", "Selection",
	JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
    null, choose3, choose3[0]);
    if (response3 ==0)
    {
		(new Thread(new forwardAllow())).start();		    	
    }
    if (response3 ==1)
    {
		(new Thread(new forwardDrop())).start();		    	
    }
    else{		    	
    }
}
    else{		    	
    }		
}

if(event.equals("Block Ip address"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel blocke = new JLabel("Enter IP You want to Block");  
	block = new JTextField(10);
	JButton blocker = new JButton("Execute");
	 jp.add(blocke);
     jp.add(block);
     jp.add(blocker);
     blocker.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
		(new Thread(new blockIp())).start();
        }
     });
     setVisible(true);         
}

if(event.equals("Allow All incoming SSH"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel allowSSH = new JLabel("Enter eth number to Allow SSH");  
    allowSSHtf = new JTextField(10);
 	 JButton allowSSHButton = new JButton("Execute");
	 jp.add(allowSSH);
     jp.add(allowSSHtf);
     jp.add(allowSSHButton);
     allowSSHButton.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
		(new Thread(new allowIncomingSSH())).start();
        }
     });
     setVisible(true);         		
}

if(event.equals("Allow All Outgoing SSH"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel allowSSH = new JLabel("Enter eth for outgoing SSH ");  
    allowSSHOut = new JTextField(10);
    JButton allowSSHButton = new JButton("Execute");
	 jp.add(allowSSH);
     jp.add(allowSSHOut);
     jp.add(allowSSHButton);
     allowSSHButton.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
		(new Thread(new allowOutgoingSSH())).start();
        }
     });
     setVisible(true);         		
}

if(event.equals("Allow SSH From Specific Network"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel specSSH = new JLabel("Enter IP of Specified Address ");  
	specSSHIp = new JTextField(10);
	JLabel specSSHe = new JLabel("Enter eth number ");  
	specSSHEth = new JTextField(10);
	JButton specButton = new JButton("Execute");
	 jp.add(specSSH);
     jp.add(specSSHIp);
     jp.add(specSSHe);
     jp.add(specSSHEth);
     jp.add(specButton);
     specButton.addActionListener(new ActionListener()
     {
            public void actionPerformed(ActionEvent e)
            {
    			(new Thread(new allowSSHFromAddress())).start();
            }
     });
     setVisible(true);         		
}

if(event.equals("Allow SSH To Specific Network"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel specSSHTo = new JLabel("Enter IP of Specified Address ");  
	specSSHIpTo = new JTextField(10);
	JLabel specSSHeTo = new JLabel("Enter eth number ");  
	specSSHEthTo = new JTextField(10);
	JButton specButtonTo = new JButton("Execute");
	jp.add(specSSHTo);
    jp.add(specSSHIpTo);
    jp.add(specSSHeTo);
    jp.add(specSSHEthTo);
    jp.add(specButtonTo);
    specButtonTo.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
		(new Thread(new allowSSHToAddress())).start();
        }
     });
     setVisible(true);         		
}

if(event.equals("Allow All HTTP In"))
{
	jp.removeAll(); 
	jp.updateUI();jp.removeAll(); 
	jp.updateUI();
    JLabel HTTP = new JLabel("Enter Eth Number");  
    HTTPtf = new JTextField(10);
    JButton HTTPButtonIn = new JButton("Execute");
	jp.add(HTTP);
    jp.add(HTTPtf);
    jp.add(HTTPButtonIn);
    HTTPButtonIn.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
		(new Thread(new allowHTTPIn())).start();
        }
     });
     setVisible(true);         		
}

if(event.equals("Allow All HTTP Out"))
{
	jp.removeAll(); 
	jp.updateUI();jp.removeAll(); 
	jp.updateUI();
    JLabel HTTPOut = new JLabel("Enter Eth Number");  
    HTTPOuttf = new JTextField(10);
    JButton HTTPOutButton = new JButton("Execute");
	jp.add(HTTPOut);
    jp.add(HTTPOuttf);
    jp.add(HTTPOutButton);
    HTTPOutButton.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
		(new Thread(new allowHTTPOut())).start();
        }
     });
     setVisible(true);         		
}

if(event.equals("Block All HTTP"))
{
	jp.removeAll(); 
	jp.updateUI();jp.removeAll(); 
	jp.updateUI();
    JLabel HTTP = new JLabel("Enter Eth Number");  
	blockHTTPtf = new JTextField(10);
	JLabel HTTP2 = new JLabel("Enter Eth Number");  
	blockHTTPtf2 = new JTextField(10);
	JButton HTTPButtonIn = new JButton("Execute");
	jp.add(HTTP);
    jp.add(blockHTTPtf);
    jp.add(HTTP2);
    jp.add(blockHTTPtf2);
    jp.add(HTTPButtonIn);
    HTTPButtonIn.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
		(new Thread(new blockHTTP())).start();
        }
     });
     setVisible(true);         		
}

if(event.equals("Allow All HTTPS In"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel HTTPSIns = new JLabel("Enter Eth Number");  
    HTTPSIntf = new JTextField(10);
    JButton HTTPSinButton = new JButton("Execute");
	jp.add(HTTPSIns);
    jp.add(HTTPSIntf);
    jp.add(HTTPSinButton);
    HTTPSinButton.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
		(new Thread(new allowHTTPSIn())).start();
        }
     });
     setVisible(true);         		
}

if(event.equals("Allow All HTTPS Out"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel HTTPSOuts = new JLabel("Enter Eth Number");  
    HTTPSOuttf = new JTextField(10);
    JButton HTTPSInButton = new JButton("Execute");
	jp.add(HTTPSOuts);
    jp.add(HTTPSOuttf);
    jp.add(HTTPSInButton);
    HTTPSInButton.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
		(new Thread(new allowHTTPSOut())).start();
        }
     });
     setVisible(true);         		
}

if(event.equals("Block All HTTPS"))
{
	jp.removeAll(); 
	jp.updateUI();jp.removeAll(); 
	jp.updateUI();
    JLabel HTTPS = new JLabel("Enter Eth Number");  
    blockHTTPStf = new JTextField(10);
    JLabel HTTPS2 = new JLabel("Enter IP Number");  
    blockHTTPStf2 = new JTextField(10);
    JButton HTTPButtonIn = new JButton("Execute");
	jp.add(HTTPS);
    jp.add(blockHTTPStf);
    jp.add(HTTPS2);
    jp.add(blockHTTPStf);
    jp.add(HTTPButtonIn);
    HTTPButtonIn.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
		(new Thread(new blockHTTPS())).start();
        }
     });
     setVisible(true);         		
}
			
if(event.equals("Load Balancing"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel balance = new JLabel("Enter Eth Number for Load Balancing");  
	balancetf = new JTextField(10);
	JLabel balancePort = new JLabel("Enter Port Number ");  
	balancePorttf = new JTextField(10);
	JLabel balanceIp1 = new JLabel("Enter IP of First Machine");  
	balanceIp1tf = new JTextField(10);
	JLabel balanceIp2 = new JLabel("Enter IP of Second Machine");  
	balanceIp2tf = new JTextField(10);
	JLabel balanceIp3 = new JLabel("Enter IP of Third Machine");  
	balanceIp3tf = new JTextField(10);
	JButton balanceButton = new JButton("Execute");
	 jp.add(balance);
     jp.add(balancetf);
     jp.add(balancePort);
     jp.add(balancePorttf);
     jp.add(balanceIp1);
     jp.add(balanceIp1tf);
     jp.add(balanceIp2);
     jp.add(balanceIp2tf);
     jp.add(balanceIp3);
     jp.add(balanceIp3tf);
     jp.add(balanceButton);
     jp.setPreferredSize(new Dimension(600, 105));
     balanceButton.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
		(new Thread(new loadBalancing())).start();
        }
     });
     setVisible(true);         		
}

if(event.equals("Allow Pings In"))
{
	jp.removeAll(); 
	jp.updateUI();
	String[] choice = new String[] {"Yes", "No"};
	int respond = JOptionPane.showOptionDialog(null, "Are you sure you want to Allow Pings IN?", "Selection",
    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
    null, choice, choice[0]);
    if (respond ==0)
    {
		(new Thread(new allowPingsIn())).start();
    }
    else{    	
    }	    		
}

if(event.equals("Allow Pings Out"))
{
	jp.removeAll(); 
	jp.updateUI();
	String[] choice2 = new String[] {"Yes", "No"};
	int respond2 = JOptionPane.showOptionDialog(null, "Are you sure you want to Allow Pings IN?", "Selection",
    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
    null, choice2, choice2[0]);
    if (respond2 ==0)
    {
		(new Thread(new allowPingsOut())).start();
    }
    else{	    	
    }        
}

if(event.equals("Save"))
{
	jp.removeAll(); 
	jp.updateUI();
	String[] choice = new String[] {"Yes", "No"};
	int respond = JOptionPane.showOptionDialog(null, "Are you sure you want to Save Settings?", "Selection",
    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
    null, choice, choice[0]);
    if (respond ==0)
    {
		(new Thread(new save())).start();
    }
    else{    	
    }	    		
}

if(event.equals("Restore"))
{
	jp.removeAll(); 
	jp.updateUI();
	String[] choice = new String[] {"Yes", "No"};
	int respond = JOptionPane.showOptionDialog(null, "Are you sure you want to Restore Settings?", "Selection",
    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
    null, choice, choice[0]);
    if (respond ==0)
    {
		(new Thread(new restore())).start();
    }
    else{    	
    }	    		
}

if(event.equals("Allows SQL Connection"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel sql = new JLabel("Enter IP of MySQL server");  
	sqlIp = new JTextField(10);
	JLabel sqleth = new JLabel("Enter Eth number");  
	sqlEthtf = new JTextField(10);
	JButton sqlButton = new JButton("Execute");
	 jp.add(sql);
     jp.add(sqlIp);
     jp.add(sqleth);
     jp.add(sqlEthtf);
     jp.add(sqlButton);
     sqlButton.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
			(new Thread(new allowSQL())).start();
        }
     });
     setVisible(true);         			
}

if(event.equals("Allows IMAP Connection"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel imap = new JLabel("Enter eth number");  
    imaptf = new JTextField(10);
    JButton imapButton = new JButton("Execute");
	 jp.add(imap);
     jp.add(imaptf);
     jp.add(imapButton);
     imapButton.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
		(new Thread(new allowIMAP())).start();
        }
     });
     setVisible(true);         		
}

if(event.equals("Allows POP Connection"))
{
	jp.removeAll(); 
	jp.updateUI();
    JLabel pop = new JLabel("Enter eth number");  
    poptf = new JTextField(10);
    JButton popButton = new JButton("Execute");
	 jp.add(pop);
     jp.add(poptf);
     jp.add(popButton);
     popButton.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
			(new Thread(new allowPOP())).start();
        }
     });
     setVisible(true);         		
}

if(event.equals("Prevent DOS attack"))
{
	jp.removeAll(); 
	jp.updateUI();
	
	 Limit = new JTextField(5);
     Burst = new JTextField(5);
     port = new JTextField(5);
    JPanel myPanel = new JPanel();	    
    myPanel.add(new JLabel("Limit:"));
	myPanel.add(Limit);
	myPanel.add(Box.createHorizontalStrut(15));
	myPanel.add(new JLabel("Burst:"));
	myPanel.add(Burst);
	myPanel.add(new JLabel("Port:"));
	myPanel.add(port);

	int result = JOptionPane.showConfirmDialog(null, myPanel, 
           "Please Enter Limit and Burst Values", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) 
      {
		(new Thread(new preventDos())).start();             	
      }
      else{		    	  
      }
}

if(event.equals("Allows Port Forwarding"))
{
	jp.removeAll();
	jp.updateUI();

    JLabel portforward = new JLabel("Enter IP");  
	portforwardtf = new JTextField(10);
	JLabel portforwardEth = new JLabel("Enter Eth Number");  
	portEth = new JTextField(10);
	JLabel port1 = new JLabel("Change From Port");  
	port1tf = new JTextField(10);
	JLabel port2 = new JLabel("To Port");  
	port2tf= new JTextField(10);
	JButton portforwardButton = new JButton("Execute");
	 jp.add(portforward);
     jp.add(portforwardtf);
     jp.add(portforwardEth);
     jp.add(portEth);
     jp.add(port1);
     jp.add(port1tf);
     jp.add(port2);
     jp.add(port2tf);
     jp.add(portforwardButton);
     portforwardButton.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
		(new Thread(new allowPortForwarding())).start();             	
        }
     });
     setVisible(true);         
}

if(event.equals("Log New Connections Incoming"))
{
	jp.removeAll(); 
	jp.updateUI();		
	jp.removeAll(); 
	jp.updateUI();
	String[] choice = new String[] {"Yes", "No"};
	int respond = JOptionPane.showOptionDialog(null, "Are you sure you want to Log ALL Incoming Traffic?", "Selection",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
        null, choice, choice[0]);
    if (respond ==0)
    {
		(new Thread(new allowLoggingIn())).start();
    }
    else{    	
    }	    				
}

if(event.equals("Log New Connections Outgoing"))
{
	jp.removeAll(); 
	jp.updateUI();
	
	jp.removeAll(); 
	jp.updateUI();
	String[] choice = new String[] {"Yes", "No"};
	int respond = JOptionPane.showOptionDialog(null, "Are you sure you want to Log ALL Outgoing Traffic?", "Selection",
        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
        null, choice, choice[0]);
    if (respond ==0)
    {
		(new Thread(new allowLoggingOut())).start();
    }
    else{    	
    }	    				
	jp.removeAll(); 
	jp.updateUI();			
}

if(event.equals("Show Logging"))
{
	jp.removeAll(); 
	jp.updateUI();
      
  	BufferedReader br = null;
	Scanner in = null;
	try {
		in = new Scanner(new File("/var/log/kern.log"));
		in.useDelimiter(System.getProperty("line.separator"));
		br = new BufferedReader(new FileReader("/var/log/kern.log"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
}
while (in.hasNext()) 
{
	String line2 = in.next();
	line.toString();

    try {
		line = br.readLine();

	} catch (IOException e1) {
		e1.printStackTrace();
	}
    if (line2 != null) 
    {
    	iptables.textArea.append(line+"\n");
    } 
    else 
    {
	 }		    
	}
	}
  }
}