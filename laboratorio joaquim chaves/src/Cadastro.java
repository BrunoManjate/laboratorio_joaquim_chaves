import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Cadastro extends JFrame
{
	private Container cont;
	private JLabel lblNewLabel;
	private JTextField tnome,tnumero,textField_2; 
	private JPasswordField pass,pass2;
	private JCheckBox mostrar, mostrar1;
	private JButton bvoltar, bOk;
	private JPanel panel_1, panel_2, panel_3, panel_4, panel_5,panel_6;
	public Cadastro	(Jmenu m,LoginP lo)
	{
	    super("Cadastro");
	    cont = getContentPane();
	    Image ico = Toolkit.getDefaultToolkit().getImage("cadastro.png");
	    setIconImage(ico);
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
	   
	    ImageIcon backGroundImage = new ImageIcon("yes.jpg");
	     
	    Image img =  backGroundImage.getImage();
	    Image temp_img = img.getScaledInstance(900, 600,Image.SCALE_SMOOTH);
	    JLabel backGround = new JLabel("",backGroundImage, JLabel.CENTER);
	    
	    backGround.add(login);
	   
	    
	    backGround.add(login);
	    login.setLayout(null);
	    
	    panel_1 = new JPanel(new GridLayout(4,1));
	    panel_1.setBounds(12, 191, 155, 135);
	    panel_1.setBackground(new Color(0,0,0,60));
	    login.add(panel_1);
	    
	    JLabel lblNewLabel_3 = new JLabel(" Nome");
	    lblNewLabel_3.setForeground(Color.WHITE);
	    lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
	    panel_1.add(lblNewLabel_3);
	    
	    JLabel lblNewLabel_2 = new JLabel(" Telefone :");
	    lblNewLabel_2.setForeground(Color.WHITE);
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
	    panel_1.add(lblNewLabel_2);
	    
	    JLabel lblNewLabel_1 = new JLabel(" Senha");
	    lblNewLabel_1.setForeground(Color.WHITE);
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
	    panel_1.add(lblNewLabel_1);
	    
	    lblNewLabel = new JLabel(" Confirmar");
	    lblNewLabel.setForeground(Color.WHITE);
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
	    panel_1.add(lblNewLabel);
	    
	    panel_2 = new JPanel(new GridLayout(4,1));
	    panel_2.setBackground(Color.GRAY);	 
 	    panel_2.setBounds(167, 191, 271, 135);
	    login.add(panel_2);
	    
	    tnome = new JTextField(15);
	    tnome.setColumns(10);
	    panel_2.add(tnome);
	    
	    
	    panel_5 = new JPanel();
	    panel_5.setBackground(Color.GRAY);	 
	    panel_5.setLayout(null);
	    panel_2.add(panel_5);
	    
	    textField_2 = new JTextField();
	    textField_2.setText("+258");
	    textField_2.setFont(new Font("Tahoma", Font.BOLD, 13));
	    textField_2.setEditable(false);
	    textField_2.setColumns(10);
	    textField_2.setBounds(0, 0, 50, 33);
	    panel_5.add(textField_2);
	    
	    tnumero = new JTextField(9);
	    tnumero.setBounds(50, 0, 221, 33);
	    tnumero.addKeyListener(new KeyListener()
		{
		    public void keyTyped(KeyEvent ev)
		    {
		        char control = ev.getKeyChar();
		        if(!((control >= '0') && (control <= '9') || (control == KeyEvent.VK_BACK_SPACE) || (control == KeyEvent.VK_DELETE) || (control == KeyEvent.VK_ENTER)))
		        {
		        	getToolkit().beep();
		        	ev.consume();
		        	JOptionPane.showMessageDialog(null, "Introduz Somente Numeros");	
		        }
		    }
		     public void keyPressed(KeyEvent arg0) {}
		     public void keyReleased(KeyEvent arg0) {}
		});
	    tnumero.setColumns(10);
	    panel_5.add(tnumero);
	    
	    panel_4 = new JPanel(new GridLayout(1,2));
	    panel_4.setBackground(Color.GRAY);
	    panel_2.add(panel_4);
	    
	    pass = new JPasswordField();
	    pass.addKeyListener(new KeyListener()
		{
		    public void keyTyped(KeyEvent ev)
		    {
		        char control = ev.getKeyChar();
		        if(!((control >= '0') && (control <= '9') || (control == KeyEvent.VK_BACK_SPACE) || (control == KeyEvent.VK_DELETE) || (control == KeyEvent.VK_ENTER)))
		        {
		        	getToolkit().beep();
		        	ev.consume();
		        	JOptionPane.showMessageDialog(null, "Introduz Somente Numeros");	
		        }
		    }
		     public void keyPressed(KeyEvent arg0) {}
		     public void keyReleased(KeyEvent arg0) {}
		});
	    
	    panel_4.add(pass);
	    
	    mostrar = new JCheckBox("Exibir Senha");
	    mostrar.setBackground(Color.WHITE);
	    mostrar.addItemListener(new ItemListener()
	    {
	    	public void itemStateChanged(ItemEvent e) 
	    	{
	    		if (mostrar.isSelected()) 
	    			pass.setEchoChar((char)0);
	            else 
	            	pass.setEchoChar('*');
	    	}
	    });
	    panel_4.add(mostrar);
	    
	    panel_3 = new JPanel(new GridLayout(1,2));
	    panel_3.setBackground(Color.GRAY);
	    panel_2.add(panel_3);
	    
	    pass2 = new JPasswordField();
	    pass2.addKeyListener(new KeyListener()
		{
		    public void keyTyped(KeyEvent ev)
		    {
		        char control = ev.getKeyChar();
		        if(!((control >= '0') && (control <= '9') || (control == KeyEvent.VK_BACK_SPACE) || (control == KeyEvent.VK_DELETE) || (control == KeyEvent.VK_ENTER)))
		        {
		        	getToolkit().beep();
		        	ev.consume();
		        	JOptionPane.showMessageDialog(null, "Introduz Somente Numeros");	
		        }
		    }
		     public void keyPressed(KeyEvent arg0) {}
		     public void keyReleased(KeyEvent arg0) {}
		});
	    
	    panel_3.add(pass2);
	    
	    mostrar1 = new JCheckBox("Exibir Senha");
	    mostrar1.setBackground(Color.WHITE);
	    mostrar1.addItemListener(new ItemListener()
	    {
	    	public void itemStateChanged(ItemEvent e) 
	    	{
	    		if (mostrar1.isSelected()) 
	    			pass2.setEchoChar((char)0);
	            else 
	            	pass2.setEchoChar('*');
	    	}
	    });
	    panel_3.add(mostrar1);
	    
	    panel_6 = new JPanel();
	    panel_6.setBounds(61, 330, 334, 37);
	    login.add(panel_6);
	    panel_6.setLayout(null);
	    
	    bOk = new JButton("Entrar");
	    bOk.setBounds(12, 0, 153, 37);
	    bOk.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent ev)
	    	{
	    		if(!tnome.getText().isEmpty() && !tnumero.getText().isEmpty() && !pass.getText().isEmpty() && !pass2.getText().isEmpty())
	    		{
	    			long num = Long.parseLong(tnumero.getText());
	    			long senha = Long.parseLong(pass.getText());
	    			long senha2 = Long.parseLong(pass2.getText());
	    			if(num<820000000 || num>879999999)
	    			{
	    				message("O Contacto deve ter (820000000 - 899999999)","Erro Numero");
	    			}else
	    			{
	                    if(senha<20000000 || senha>99999999 || senha2<20000000 || senha2>99999999)
	                    {
	                    	message("A senha deve ter (20000000 - 99999999)","Erro Codigo");
	                    }else
	                    {
	    				   if(senha!=senha2)
	    				   {
	    					   message("A Senha (1) e Senha (2) nao sao Iguais\nTente Novamente!","Erro Senha");
	    				   }else
	    				   {
	    					    Escrever es = new Escrever();
			  					es.gravarUser(tnome.getText(), pass.getText(), Long.parseLong(tnumero.getText()));
			  					JOptionPane.showMessageDialog(null, "Dados do(a) sr(a) "+tnome.getName()+"Resgitrado Com Sucesso!\nBem vindo ao Laboratorio Chaves");
			  					dispose();
			  					m.setVisible(true); 
	    				   }
	                    } 
	    			}	
	    		}else
	    		{
	    			message("Preencha Os Campos","Erro Campos");
	    		}
	    	}
	    });
	    panel_6.add(bOk);
	    
	    bvoltar = new JButton("Voltar");
	    bvoltar.setBounds(169, 0, 153, 37);
	    bvoltar.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent ev)
	    	{
	    		dispose();
	    		lo.setVisible(true);
	    	}
	    });
	    panel_6.add(bvoltar);
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
	
	public void aparencia() {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    } 
	
	public void message(String re, String str)
	{
		JOptionPane.showMessageDialog(null,re,str,JOptionPane.ERROR_MESSAGE);
	}
}