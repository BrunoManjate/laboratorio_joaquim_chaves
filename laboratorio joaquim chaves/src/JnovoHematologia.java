import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
public class JnovoHematologia extends JFrame
{
	private JTextField tquqntidadeP,tquqntidadeB,tquqntidadeV,tvalorA,tnumero,tnumeroBi,tcodigo,tidade;
	private JComboBox box;
	private String pagamento[] ={"numer�rio", "cart�o", "seguro"};
	private ButtonGroup bg,bg1;
	private JRadioButton rF, rM;
	private JRadioButton sim3, nao3;
	private SimpleDateFormat dat;
	private JTextField tdataA;
	private JTextField tNome;
	
	public  JnovoHematologia (Vector vec,Jmenu m)
	{
		super("New Hematologia");
		aparencia();
		dat = new SimpleDateFormat("dd/MM/yyyy");
		
		JPanel login = new JPanel();
		login.setSize(400,400);
		login.setBackground(new Color(0,0,0,60));
		login.setBounds(290,5,1000,680);
	   
	    ImageIcon backGroundImage = new ImageIcon("yes.jpg");
	     
	    Image img =  backGroundImage.getImage();
	    Image temp_img = img.getScaledInstance(900, 900,Image.SCALE_SMOOTH);
	    JLabel backGround = new JLabel("",backGroundImage, JLabel.CENTER);
	    
	    backGround.add(login);
	    
	    backGround.add(login);
	    login.setLayout(null);
	    
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    panel.setBackground(new Color(0, 0,0, 60));
	    panel.setBounds(497, 13, 491, 593);
	    login.add(panel);
	    
	    JButton button = new JButton("Adicionar");
	    button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) 
	    	{
	    		if(!tcodigo.getText().isEmpty() && !tnumeroBi.getText().isEmpty() && !tNome.getText().isEmpty() && !tnumero.getText().isEmpty() &&
						!tidade.getText().isEmpty() && !tdataA.getText().isEmpty() && !tvalorA.getText().isEmpty() && !tquqntidadeV.getText().isEmpty() && !tquqntidadeB.getText().isEmpty() && !tquqntidadeP.getText().isEmpty())
				{
					Date dataux = new Date();
					int  cod = Integer.parseInt(tcodigo.getText());
		    		long numero = Long.parseLong(tnumero.getText());
		    		byte anos = Byte.parseByte(tidade.getText());
		    	    
		    		try
		    	    {
		    	    	dataux = dat.parse(tdataA.getText());
		    	    }catch(ParseException zz)
		   	     	{
		    	    	 JOptionPane.showMessageDialog(null,zz+"\nO Formato da data deve ser (dd/MM/yyyy)","Erro Data",JOptionPane.ERROR_MESSAGE);
		   	     	}
		    		float valor = Float.parseFloat(tvalorA.getText());
		    		int qB = Integer.parseInt(tquqntidadeB.getText());
		    		Byte qV = Byte.parseByte(tquqntidadeV.getText());
		    		float qP = Float.parseFloat(tquqntidadeP.getText());
		    	    
					Hematologia hema = new Hematologia();
					
					// sim tudo
					if(rF.isSelected() && box.getSelectedIndex()==0 && sim3.isSelected())
					{
						hema.setCodigo(cod);
						hema.setNumBI(tnumeroBi.getText());
						hema.setNomePac(tNome.getText());
						hema.setNumTel(numero);
						hema.setIdade(anos);
						hema.setGenero('f');
						hema.setDatAnalise(dataux);
						hema.setValorAnalise(valor);
						hema.setFormPag("numerario");
						hema.setQuantG_VER(qV);
						hema.setQuantG_BRA(qB);
						hema.setQuantPLA(qP);
						hema.setTransport("sim");
					}
					
					if(rF.isSelected() && box.getSelectedIndex()==1 && sim3.isSelected())
					{
						hema.setCodigo(cod);
						hema.setNumBI(tnumeroBi.getText());
						hema.setNomePac(tNome.getText());
						hema.setNumTel(numero);
						hema.setIdade(anos);
						hema.setGenero('f');
						hema.setDatAnalise(dataux);
						hema.setValorAnalise(valor);
						hema.setFormPag("cartao");
						hema.setQuantG_VER(qV);
						hema.setQuantG_BRA(qB);
						hema.setQuantPLA(qP);
						hema.setTransport("sim");
					}
					
					if(rF.isSelected() && box.getSelectedIndex()==2  && sim3.isSelected())
					{
						hema.setCodigo(cod);
						hema.setNumBI(tnumeroBi.getText());
						hema.setNomePac(tNome.getText());
						hema.setNumTel(numero);
						hema.setIdade(anos);
						hema.setGenero('f');
						hema.setDatAnalise(dataux);
						hema.setValorAnalise(valor);
						hema.setFormPag("seguro");
						hema.setQuantG_VER(qV);
						hema.setQuantG_BRA(qB);
						hema.setQuantPLA(qP);
						hema.setTransport("sim");
					}
					
					//nao 
					if(rF.isSelected() && box.getSelectedIndex()==0  && nao3.isSelected())
					{
						hema.setCodigo(cod);
						hema.setNumBI(tnumeroBi.getText());
						hema.setNomePac(tNome.getText());
						hema.setNumTel(numero);
						hema.setIdade(anos);
						hema.setGenero('f');
						hema.setDatAnalise(dataux);
						hema.setValorAnalise(valor);
						hema.setFormPag("numerario");
						hema.setQuantG_VER(qV);
						hema.setQuantG_BRA(qB);
						hema.setQuantPLA(qP);
						hema.setTransport("nao");
					}
					
					if(rF.isSelected() && box.getSelectedIndex()==1  && nao3.isSelected())
					{
						hema.setCodigo(cod);
						hema.setNumBI(tnumeroBi.getText());
						hema.setNomePac(tNome.getText());
						hema.setNumTel(numero);
						hema.setIdade(anos);
						hema.setGenero('f');
						hema.setDatAnalise(dataux);
						hema.setValorAnalise(valor);
						hema.setFormPag("cartao");
						hema.setQuantG_VER(qV);
						hema.setQuantG_BRA(qB);
						hema.setQuantPLA(qP);
						hema.setTransport("nao");
					}
					
					if(rF.isSelected() && box.getSelectedIndex()==2 && nao3.isSelected())
					{
						hema.setCodigo(cod);
						hema.setNumBI(tnumeroBi.getText());
						hema.setNomePac(tNome.getText());
						hema.setNumTel(numero);
						hema.setIdade(anos);
						hema.setGenero('f');
						hema.setDatAnalise(dataux);
						hema.setValorAnalise(valor);
						hema.setFormPag("seguro");
						hema.setQuantG_VER(qV);
						hema.setQuantG_BRA(qB);
						hema.setQuantPLA(qP);
						hema.setTransport("nao");
					}
					
					// sim
					if(rM.isSelected() && box.getSelectedIndex()==0 && sim3.isSelected())
					{
						hema.setCodigo(cod);
						hema.setNumBI(tnumeroBi.getText());
						hema.setNomePac(tNome.getText());
						hema.setNumTel(numero);
						hema.setIdade(anos);
						hema.setGenero('m');
						hema.setDatAnalise(dataux);
						hema.setValorAnalise(valor);
						hema.setFormPag("numerario");
						hema.setQuantG_VER(qV);
						hema.setQuantG_BRA(qB);
						hema.setQuantPLA(qP);
						hema.setTransport("sim");
					}
					
					if(rM.isSelected() && box.getSelectedIndex()==1 && sim3.isSelected())
					{
						hema.setCodigo(cod);
						hema.setNumBI(tnumeroBi.getText());
						hema.setNomePac(tNome.getText());
						hema.setNumTel(numero);
						hema.setIdade(anos);
						hema.setGenero('m');
						hema.setDatAnalise(dataux);
						hema.setValorAnalise(valor);
						hema.setFormPag("cartao");
						hema.setQuantG_VER(qV);
						hema.setQuantG_BRA(qB);
						hema.setQuantPLA(qP);
						hema.setTransport("sim");
					}
					
					if(rM.isSelected() && box.getSelectedIndex()==2  && sim3.isSelected())
					{
						hema.setCodigo(cod);
						hema.setNumBI(tnumeroBi.getText());
						hema.setNomePac(tNome.getText());
						hema.setNumTel(numero);
						hema.setIdade(anos);
						hema.setGenero('m');
						hema.setDatAnalise(dataux);
						hema.setValorAnalise(valor);
						hema.setFormPag("seguro");
						hema.setQuantG_VER(qV);
						hema.setQuantG_BRA(qB);
						hema.setQuantPLA(qP);
						hema.setTransport("sim");
					}
					
					//nao 
					if(rF.isSelected() && box.getSelectedIndex()==0  && nao3.isSelected())
					{
						hema.setCodigo(cod);
						hema.setNumBI(tnumeroBi.getText());
						hema.setNomePac(tNome.getText());
						hema.setNumTel(numero);
						hema.setIdade(anos);
						hema.setGenero('m');
						hema.setDatAnalise(dataux);
						hema.setValorAnalise(valor);
						hema.setFormPag("numerario");
						hema.setQuantG_VER(qV);
						hema.setQuantG_BRA(qB);
						hema.setQuantPLA(qP);
						hema.setTransport("nao");
					}
					
					if(rM.isSelected() && box.getSelectedIndex()==1  && nao3.isSelected())
					{
						hema.setCodigo(cod);
						hema.setNumBI(tnumeroBi.getText());
						hema.setNomePac(tNome.getText());
						hema.setNumTel(numero);
						hema.setIdade(anos);
						hema.setGenero('m');
						hema.setDatAnalise(dataux);
						hema.setValorAnalise(valor);
						hema.setFormPag("cartao");
						hema.setQuantG_VER(qV);
						hema.setQuantG_BRA(qB);
						hema.setQuantPLA(qP);
						hema.setTransport("nao");
					}
					
					if(rM.isSelected() && box.getSelectedIndex()==2 && nao3.isSelected())
					{
						hema.setCodigo(cod);
						hema.setNumBI(tnumeroBi.getText());
						hema.setNomePac(tNome.getText());
						hema.setNumTel(numero);
						hema.setIdade(anos);
						hema.setGenero('m');
						hema.setDatAnalise(dataux);
						hema.setValorAnalise(valor);
						hema.setFormPag("seguro");
						hema.setQuantG_VER(qV);
						hema.setQuantG_BRA(qB);
						hema.setQuantPLA(qP);
						hema.setTransport("nao");
					}
					
					vec.addElement(hema);
	                vec.trimToSize();	
	                JOptionPane.showMessageDialog(null, "Dados Gravados Com Sucesso");
	               
	                dispose();
	                m.setVisible(true);
				}else
				{
					JOptionPane.showMessageDialog(null,"Preencha Todos Campos!","Erro",JOptionPane.ERROR_MESSAGE);
				}
	    	}
	    });
	    button.setForeground(Color.BLACK);
	    button.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    button.setBounds(12, 540, 459, 40);
	    panel.add(button);

	    
	    JPanel panel_2 = new JPanel(new GridLayout(13,1));
	    panel_2.setBackground(Color.LIGHT_GRAY);
	    panel_2.setBounds(238, 13, 225, 522);
	    panel.add(panel_2);
	    
	    tcodigo = new JTextField();
	    tcodigo.addKeyListener(new KeyListener()
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
	    panel_2.add(tcodigo);
	    tcodigo.setColumns(10);
	    
	    tnumeroBi = new JTextField();
	    panel_2.add(tnumeroBi);
	    tnumeroBi.setColumns(10);
	    
	    tNome = new JTextField();
	    panel_2.add(tNome);
	    tNome.setColumns(10);
	    
	    tnumero = new JTextField();
	    panel_2.add(tnumero);
	    tnumero.setColumns(10);
	    
	    JPanel panel_5 = new JPanel(new GridLayout(1,2));
	    panel_5.setForeground(Color.LIGHT_GRAY);
	    panel_2.add(panel_5);
	    
	    rM = new JRadioButton("Masculino",true);
	    rM.setForeground(Color.BLACK);
	    rM.setFont(new Font("Tahoma", Font.BOLD, 13));
	    panel_5.add(rM);
	    
	    rF = new JRadioButton("Feminino",false);
	    rF.setForeground(Color.BLACK);
	    rF.setFont(new Font("Tahoma", Font.BOLD, 13));
	    panel_5.add(rF);
	    
	    bg = new ButtonGroup();
	    bg.add(rF);
	    bg.add(rM);
	    
	    tidade = new JTextField();
	    tidade.addKeyListener(new KeyListener()
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
	    panel_2.add(tidade);
	    tidade.setColumns(10);
	    
	    
	    tvalorA = new JTextField();
	    tvalorA.addKeyListener(new KeyListener()
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
	    
	    tdataA = new JTextField();
	    tdataA.setText("__/__/___");
	    tdataA.setColumns(10);
	    panel_2.add(tdataA);
	    panel_2.add(tvalorA);
	    tvalorA.setColumns(10);
	   
	    
	    box = new JComboBox(pagamento);
	    box.setBackground(Color.ORANGE);
	    panel_2.add(box);
	    
	    tquqntidadeB = new JTextField();
	    tquqntidadeB.addKeyListener(new KeyListener()
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
	    panel_2.add(tquqntidadeB);
	    tquqntidadeB.setColumns(10);
	    
	    tquqntidadeV = new JTextField();
	    tquqntidadeV.addKeyListener(new KeyListener()
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
	    panel_2.add(tquqntidadeV);
	    tquqntidadeV.setColumns(10);
	    
	    tquqntidadeP = new JTextField();
	    tquqntidadeP.addKeyListener(new KeyListener()
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
	    panel_2.add(tquqntidadeP);
	    tquqntidadeP.setColumns(10);
	    
	    JPanel panel_4 = new JPanel(new GridLayout(1,2));
	    panel_4.setBackground(Color.LIGHT_GRAY);
	    panel_2.add(panel_4);
	    
	    sim3 = new JRadioButton("Sim",true);
	    sim3.setFont(new Font("Tahoma", Font.BOLD, 13));
	    panel_4.add(sim3);
	    
	    nao3 = new JRadioButton("Nao",false);
	    nao3.setFont(new Font("Tahoma", Font.BOLD, 13));
	    panel_4.add(nao3);
	    
	    bg1 = new ButtonGroup();
	    bg1.add(sim3);
	    bg1.add(nao3);
	    
	    JPanel panel_3 = new JPanel(new GridLayout(13,1));
	    panel_3.setBackground(new Color(0, 0, 0,60));
	    panel_3.setBounds(12, 13, 222, 522);
	    panel.add(panel_3);
	    
	    JLabel lblCodigo_1 = new JLabel("Codigo");
	    lblCodigo_1.setFont(new Font("Tahoma", Font.BOLD, 13));
	    lblCodigo_1.setForeground(Color.WHITE);
	    panel_3.add(lblCodigo_1);
	    
	    JLabel lblCodigo = new JLabel("Numero de Bi");
	    lblCodigo.setForeground(Color.WHITE);
	    lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 13));
	    panel_3.add(lblCodigo);
	    
	    JLabel lblNome_1 = new JLabel("Nome");
	    lblNome_1.setForeground(Color.WHITE);
	    lblNome_1.setFont(new Font("Tahoma", Font.BOLD, 13));
	    panel_3.add(lblNome_1);
	    
	    JLabel lblContacto = new JLabel("Contacto");
	    lblContacto.setForeground(Color.WHITE);
	    lblContacto.setFont(new Font("Tahoma", Font.BOLD, 13));
	    panel_3.add(lblContacto);
	    
	    JLabel lblGenero = new JLabel("Genero");
	    lblGenero.setForeground(Color.WHITE);
	    lblGenero.setFont(new Font("Tahoma", Font.BOLD, 13));
	    panel_3.add(lblGenero);
	    
	    JLabel lblIdade = new JLabel("Idade");
	    lblIdade.setForeground(Color.WHITE);
	    lblIdade.setFont(new Font("Tahoma", Font.BOLD, 13));
	    panel_3.add(lblIdade);
	    
	    JLabel lblDataAnalise = new JLabel("Data Analise");
	    lblDataAnalise.setFont(new Font("Tahoma", Font.BOLD, 13));
	    lblDataAnalise.setForeground(Color.WHITE);
	    panel_3.add(lblDataAnalise);
	    
	    JLabel lblValor = new JLabel("Valor");
	    lblValor.setFont(new Font("Tahoma", Font.BOLD, 13));
	    lblValor.setForeground(Color.WHITE);
	    panel_3.add(lblValor);
	    
	    JLabel lblFormaDePagamento = new JLabel("Forma de Pagamento");
	    lblFormaDePagamento.setForeground(Color.WHITE);
	    lblFormaDePagamento.setFont(new Font("Tahoma", Font.BOLD, 13));
	    panel_3.add(lblFormaDePagamento);
	    
	    JLabel qgv = new JLabel("Quantidade de Globos Barancos");
	    qgv.setFont(new Font("Tahoma", Font.BOLD, 13));
	    qgv.setForeground(Color.WHITE);
	    panel_3.add(qgv);
	    
	    JLabel qgb = new JLabel("Quantidade de globos Vermelhos");
	    qgb.setForeground(Color.WHITE);
	    qgb.setFont(new Font("Tahoma", Font.BOLD, 13));
	    panel_3.add(qgb);
	    
	    JLabel lblNewLabel = new JLabel("Quantidade de Plaquetas");
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
	    lblNewLabel.setForeground(Color.WHITE);
	    panel_3.add(lblNewLabel);
	    
	    JLabel lblNome = new JLabel("Transporte da Amostra");
	    lblNome.setForeground(Color.WHITE);
	    lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
	    panel_3.add(lblNome);
	    
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBackground(new Color(128, 128, 128));
	    panel_1.setBounds(12, 609, 976, 71);
	    login.add(panel_1);
	    panel_1.setLayout(null);
	    
	    JButton button_1 = new JButton("Voltar");
	    button_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) 
	    	{
	    		dispose();
				m.setVisible(true);
	    	}
	    });
	    button_1.setBounds(12, 13, 952, 46);
	    panel_1.add(button_1);
	    backGround.setBounds(0,0,1700,825);
	    
	    addWindowListener(
   				new WindowAdapter() {
   					public void windowClosing(WindowEvent a) {
   						dispose();
   		                m.setVisible(true);				
   					}
   				});
	    
	    //frame
	    setSize(1300,725);
	    getContentPane().setLayout(null);
	    getContentPane().add(backGround);
	    setResizable(false);
	    setLocationRelativeTo(null);
	    setVisible(true);
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
