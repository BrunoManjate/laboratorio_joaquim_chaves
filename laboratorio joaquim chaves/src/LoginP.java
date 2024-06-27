import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginP extends JFrame
{
	private JPasswordField passwordField;
	private String nomeUse[];
	private JComboBox comboBox;
	private JButton button,button_1,button_2;
	private Jmenu menu;	
	public  LoginP (Jmenu m)
	{
		aparencia();
		
		JPanel heading;
		heading = new JPanel();
		heading.setBackground(new Color(0,0,0,80));
		heading.setBounds(0,0,900,100);
		heading.setLayout(null);
		
		//login Panel
		JPanel login = new JPanel();
		login.setSize(400,350);
		login.setBackground(new Color(0,0,0,60));
		login.setBounds(250,175,450,380);
	   
	    ImageIcon backGroundImage = new ImageIcon("LoginL.jpg");
	     
	    Image img =  backGroundImage.getImage();
	    Image temp_img = img.getScaledInstance(900, 600,Image.SCALE_SMOOTH);
	    JLabel backGround = new JLabel("",backGroundImage, JLabel.CENTER);
	    
	    backGround.add(login);
	    login.setLayout(null);
	    
	    JPanel panel = new JPanel();
	    panel.setBorder(BorderFactory.createTitledBorder(""));
	    panel.setLayout(null);
	    panel.setBackground(new Color(0,0,0,60));
	    panel.setBounds(29, 268, 388, 109);
	    login.add(panel);
	    
	    JPanel panel_3 = new JPanel();
	    panel_3.setBackground(Color.GRAY);
	    panel_3.setBounds(12, 13, 364, 44);
	    panel.add(panel_3);
	    panel_3.setLayout(null);
	    
	    button = new JButton("Entrar");
	    button.setBounds(0, 0, 169, 44);
	    panel_3.add(button);
	    
	    button_1 = new JButton("Novo Usuario");
	    button_1.setBounds(181, 0, 183, 44);
	    button_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent a)
			{
				dispose();
				new Cadastro(m,gerir());
			}
		});
	    panel_3.add(button_1);
	    
	    JPanel panel_4 = new JPanel();
	    panel_4.setBackground(Color.GRAY);
	    panel_4.setBounds(48, 60, 293, 36);
	    panel.add(panel_4);
	    panel_4.setLayout(null);
	    
	    button_2 = new JButton("Sair");
	    button_2.setBounds(0, 0, 292, 32);
	    panel_4.add(button_2);
	    
	    JPanel panel_2 = new JPanel();
	    panel_2.setBackground(new Color(0, 0, 0, 50));
	    panel_2.setBounds(12, 183, 426, 81);
	    login.add(panel_2);
	    panel_2.setLayout(null);
	    
	    JLabel lblName = new JLabel("Nome");
	    lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
	    lblName.setBounds(12, 13, 74, 16);
	    panel_2.add(lblName);
	    
	    JLabel lblPassword = new JLabel("Senha");
	    lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
	    lblPassword.setBounds(12, 49, 74, 16);
	    panel_2.add(lblPassword);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBackground(Color.GRAY);
	    //panel_1.setBackground(new Color(128, 128, 128));
	    panel_1.setBounds(107, 0, 319, 79);
	    
	    panel_2.add(panel_1);
	    panel_1.setLayout(null);
	    
	    nomeUse = nomesUsuarios();
	    comboBox = new JComboBox(nomeUse);
	    comboBox.setBackground(new Color(255, 215, 0));
	    comboBox.setBounds(0, 0, 318, 41);
	    panel_1.add(comboBox);
	    
	    passwordField = new JPasswordField();    
	    passwordField.addKeyListener(new KeyListener() {
			  public void keyTyped(KeyEvent e)
	  		  {
		  		char c = e.getKeyChar();
		  		if(!((c>='0')&&(c<='9')||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)||(c == KeyEvent.VK_ENTER)))
		  		{
		  			getToolkit().beep();
		  			e.consume();
		  			JOptionPane.showMessageDialog(null, "Introduza somente numeros");
		  		}
	  		  }
			  public void keyPressed(KeyEvent arg0) {}
		      public void keyReleased(KeyEvent arg0) {}
	  } );
	    passwordField.setFont(new Font("Tahoma", Font.BOLD, 13));
	    passwordField.setBounds(0, 44, 174, 35);
	    panel_1.add(passwordField);
	    
	    JCheckBox chckbxNewCheckBox = new JCheckBox("Exibir Senha");
	    chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 13));
	    chckbxNewCheckBox.setBounds(182, 44, 136, 35);
	    chckbxNewCheckBox.addItemListener(new ItemListener()
	    {
	    	public void itemStateChanged(ItemEvent e) 
	    	{
	    		if (chckbxNewCheckBox.isSelected()) 
	    			passwordField.setEchoChar((char)0);
	            else 
	            	passwordField.setEchoChar('*');
	    	}
	    });
	    panel_1.add(chckbxNewCheckBox);
	  
	    Tratar tr = new Tratar(m);
	    button.addActionListener(tr);
	    button_2.addActionListener(tr);
	    
	    backGround.add(login);
	    backGround.add(heading);
	    backGround.setBounds(0,0,900,600);
	    
	    //frame
	    setSize(900,570);
	    getContentPane().setLayout(null);
	    getContentPane().add(backGround);
	    setResizable(true);
	    setLocationRelativeTo(null);
	    setUndecorated(true);
	    setVisible(true);
	}
	
	public LoginP gerir()
	{
		return this;
	}
	
	private String[] nomesUsuarios() 
	  {  String[] x= new String [20];
	     StringTokenizer str;
	     String linha;
	     int  i=0;
	     try {
	         	BufferedReader k = new BufferedReader(new FileReader("User.txt"));
	          	linha=k.readLine();
	          	while(linha!=null)
	          	{ 
	          		str= new StringTokenizer(linha,";");
	          		x[i]=str.nextToken();
	          		i++;
	          		linha=k.readLine();
	          	}
	          k.close();
	       } catch (FileNotFoundException ex) {  JOptionPane.showMessageDialog(this, "Ficheiro nao Encontrado");} 
	         catch (IOException ex) {JOptionPane.showMessageDialog(this, ex.getMessage());}
	      
	    return x;
	  }
	   
	  public class Tratar implements ActionListener
	  {
		  public Tratar(Jmenu m) {menu=m;}
		  public void actionPerformed(ActionEvent ev)
		  {
			  if(ev.getSource().equals(button))
			  {
				  if(verificarSenha()==true)
				  {
					  dispose();
					  menu.setVisible(true);
				  }
				  else
					  JOptionPane.showMessageDialog(null, "Senha Incorreta");
			  }
			  else
			  {
				  passwordField.setText("");
				  comboBox.setSelectedIndex(0);
			  }
			  if(ev.getSource().equals(button_2))
			  {
				  System.exit(0);
			  }
		  }
		  
	  }
	
	  private boolean verificarSenha() {
	      StringTokenizer str;
	      String linha, n,s;
	      long c;
	      int  i=0;
	      try {
	         FileReader fr = new FileReader("User.txt");
	         BufferedReader br = new BufferedReader(fr);
	         linha=br.readLine();
	         while(linha!=null)
	         { str= new StringTokenizer(linha,";");
	           n=str.nextToken();
	           s=str.nextToken();
	           c=Long.parseLong(str.nextToken());
	           
	           if(nomeUse[comboBox.getSelectedIndex()].equalsIgnoreCase(n) && passwordField.getText().equalsIgnoreCase(s))
	               return true;
	           
	           linha=br.readLine();
	         }
	         br.close();
	      } catch (FileNotFoundException ex) {  JOptionPane.showMessageDialog(null, "Ficheiro nao Encontrado");} 
	        catch (IOException ex) {JOptionPane.showMessageDialog(null, ex.getMessage());}
	         return false;
	  }

	
	public void aparencia()
   {
			try 
			{
				for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
				{
					if ("Nimbus".equals(info.getName())) 
					{
						UIManager.setLookAndFeel(info.getClassName());
						break;
					}
				}
			}catch (Exception e) 
			{
				e.printStackTrace();
			}
	  }
}
