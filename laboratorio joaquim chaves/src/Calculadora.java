import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
public class Calculadora extends JFrame
{
	private JPanel p1,p2,p7,painel4,pButoes;
	private JButton  b1,b2,b3,b4,b5,b6,b7,b8,b9,bx,bMenos,bDiv,bMais,b0,b00,bP, bIgual,bApagar;
	private JMenuBar bar;
	private JMenu mFiles,mHelp;
	private String opNames[] = {"Voltar"};
	private String opNamesH[] = {"View Help","About Calculator"};
	private String iconesNamesH[]={"logout.png"};
	private String iconesNamesF[]={"th5.jpg","programadores.png"};
	private JMenuItem opHelp[] = {new JMenuItem(),new JMenuItem()};
	private JMenuItem opFile[] = {new JMenuItem()};
	
	private boolean [] operacao = new boolean[4];
	private JTextArea t1;
	private JLabel vazio;
	private double tepF=0.0;
	private double tepS=0.0;
	private Jmenu menu;
	private Container cont;
	public  Calculadora(Jmenu m)
	{
		super("TubVision Calculator");
		cont = getContentPane();
		Image icon =Toolkit.getDefaultToolkit().getImage("Calc.png");
		setIconImage(icon);
		aparencia();
		menu=m;
		bar = new JMenuBar();
		setJMenuBar(bar);
    	Tratar trat = new Tratar();
    	mFiles = new JMenu("User");
    	mFiles.setIcon(new ImageIcon("user1.png"));
    	for(int x =0; x<opNames.length;x++)
        {
        	opFile[x] = new JMenuItem(opNames[x]);
        	opFile[x].addActionListener(trat);
        	ImageIcon ico = new ImageIcon(iconesNamesH[x]);
        	opFile[x].setIcon(ico);
        	mFiles.add(opFile[x]);
        }
    	bar.add(mFiles);
    	
    	mHelp = new JMenu("Help");
    	mHelp.setIcon(new ImageIcon("func.jpg"));
    	for(int x =0; x<opNamesH.length;x++)
        {
        	opHelp[x] = new JMenuItem(opNamesH[x]);
        	opHelp[x].addActionListener(trat);
        	ImageIcon ico = new ImageIcon(iconesNamesF[x]);
        	opHelp[x].setIcon(ico);
        	mHelp.add(opHelp[x]);
        }
    	bar.add(mHelp);
    	
		p1 = new JPanel(new GridLayout(2,1));
		
		//Icon pes = new ImageIcon("pe.png");
		vazio = new JLabel("Programadores Moz (TubVision)");
		vazio.setIcon(new ImageIcon("pes.jpg"));
		vazio.setFont(new Font("Arial", Font.PLAIN, 15));
		p1.add(vazio);
		
		t1 = new JTextArea("0");
		t1.setFont(new  Font("Arial", Font.PLAIN, 30 ));
		t1.setEditable(false);
		p1.add(t1);
		
		p2 = new JPanel(new GridLayout(2,1));
		
	    painel4 = new JPanel(new GridLayout(4,4));
		b7 =  new JButton("7");
		
		b7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent  ev)
			{
				if(t1.getText().length()>15)
					return;
				if(t1.getText().equalsIgnoreCase("0"))
				{
					t1.setText("7");
					return;
				}
				t1.append("7");
			}
		});
		painel4.add(b7);
		
		b8 =  new JButton("8");
		b8.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent  ev)
			{
				if(t1.getText().length()>15)
					return;
				if(t1.getText().equalsIgnoreCase("0"))
				{
					t1.setText("8");
					return;
				}
				t1.append("8");
			}
		});
		painel4.add(b8);
		
	    b9 =  new JButton("9");
		b9.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent  ev)
			{
				if(t1.getText().length()>15)
					return;
				if(t1.getText().equalsIgnoreCase("0"))
				{
					t1.setText("9");
					return;
				}
				t1.append("9");
			}
		});
		painel4.add(b9);
		
		bx = new JButton("*");
		bx.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				setTepF(Double.parseDouble(t1.getText()));
				t1.setText("0");
				operacao[1]=true; 
			}
		});
		painel4.add(bx);
		
		b4 =  new JButton("4");
		b4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent  ev)
			{
				if(t1.getText().length()>15)
					return;
				if(t1.getText().equalsIgnoreCase("0"))
				{
					t1.setText("4");
					return;
				}
				t1.append("4");
			}
		});
		painel4.add(b4);
		
		b5 = new JButton("5");
		b5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent  ev)
			{
				if(t1.getText().length()>15)
					return;
				if(t1.getText().equalsIgnoreCase("0"))
				{
					t1.setText("5");
					return;
				}
				t1.append("5");
			}
		});
		painel4.add(b5);
		
		b6 =  new JButton("6");
		b6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent  ev)
			{
				if(t1.getText().length()>15)
					return;
				if(t1.getText().equalsIgnoreCase("0"))
				{
					t1.setText("6");
					return;
				}
				t1.append("6");
			}
		});
		painel4.add(b6);
		
		bMenos = new JButton("-");
		bMenos.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent ev)
				{
					setTepF(Double.parseDouble(t1.getText()));
    				t1.setText("0");
    				operacao[2]=true; 
				}
		});
		painel4.add(bMenos);
		
		b1 =  new JButton("1");
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent  ev)
			{
				if(t1.getText().length()>15)
					return;
				if(t1.getText().equalsIgnoreCase("0"))
				{
					t1.setText("1");
					return;
				}
				t1.append("1");
			}
		});
		painel4.add(b1);
		
		b2 =  new JButton("2");
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent  ev)
			{
				if(t1.getText().length()>15)
					return;
				if(t1.getText().equalsIgnoreCase("0"))
				{
					t1.setText("2");
					return;
				}
				t1.append("2");
			}
		});
		painel4.add(b2);
		
		b3 =  new JButton("3");
		b3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent  ev)
			{
				if(t1.getText().length()>15)
					return;
				if(t1.getText().equalsIgnoreCase("0"))
				{
					t1.setText("3");
					return;
				}
				t1.append("3");
			}
		});
		painel4.add(b3);
		
		bDiv = new JButton("/");
		bDiv.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent ev)
				{
					setTepF(Double.parseDouble(t1.getText()));
    				t1.setText("0");
    				operacao[0]=true;
				}
		});
		painel4.add(bDiv);
		
		b0 =  new JButton("0");
		b0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent  ev)
			{
				if(t1.getText().length()>15)
					return;
				if(t1.getText().equalsIgnoreCase("0"))
				{
					t1.setText("0");
					//return;
				}
				t1.append("0");
			}
		});
		painel4.add(b0);
		
		b00 =  new JButton("00");
		b00.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent  ev)
			{
				if(t1.getText().length()>15)
					return;
				if(t1.getText().equalsIgnoreCase("0"))
				{
					t1.setText("00");
					return;
				}
				t1.append("00");
			}
		});
		painel4.add(b00);
		
		bP = new JButton(".");
		bP.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				if(t1.getText().contains("."))
					return;
				t1.append(".");
			}
		});
		painel4.add(bP);
		
		bMais =  new JButton("+");
		bMais.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent ev)
				{
					setTepF(Double.parseDouble(t1.getText()));
    				t1.setText("0");
    				operacao[3]=true; 
				}
		});
		painel4.add(bMais);
		p2.add(painel4);
		
		pButoes = new JPanel( new GridLayout(1,2));
		bIgual = new JButton("=");
		bIgual.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				if(operacao[0])
				{
					t1.setText(Double.toString(getTepF() / Double.parseDouble(t1.getText())));
				}
				else
				{
					if(operacao[1])
					{
						t1.setText(Double.toString(getTepF() * Double.parseDouble(t1.getText())));
					}
					else
					{
						if(operacao[2])
						{
							t1.setText(Double.toString(getTepF() - Double.parseDouble(t1.getText())));
						}
						else 
						{
							if(operacao[3])
							{
								t1.setText(Double.toString(getTepF() + Double.parseDouble(t1.getText())));
							}
						}
					}
				}
				if(t1.getText().endsWith(".0"))
					t1.setText(t1.getText().replace(".0","")); 
				     setTepF(0.0);
				     for(int i=0;i<3;i++)        
					   operacao[1]=false;
			}
		});		
		pButoes.add(bIgual);
		
		bApagar = new JButton("Apagar");
	    bApagar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				t1.setText("0");
				setTepF(0.0);
				for(int i=0;i<=3;i++)
				{
					operacao[i]=false;
				}
			}
		});
	    pButoes.add(bApagar);
	    p2.add(pButoes);
		
		p7 = new JPanel(new BorderLayout());
		p7.add(p2,BorderLayout.SOUTH);
		p7.add(p1,BorderLayout.NORTH);
		cont.add(p7);
		
		addWindowListener(
 				new WindowAdapter() {
 					public void windowClosing(WindowEvent a) {
 						dispose();
 					    m.setVisible(true);
 					}
 				});
		
		setSize(400, 440);
	    setResizable(false);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    setVisible(true);
	}
	
	public double getTepF() {
		return tepF;
	}

	public void setTepF(double tepF) {
		this.tepF = tepF;
	}

	public double getTepS() {
		return tepS;
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

	public void setTepS(double tepS) {
		this.tepS = tepS;
	}

	private class Tratar implements ActionListener
	{
		public void actionPerformed(ActionEvent ev)
		{
			if(ev.getSource()==opFile[0])
			{
			  dispose();	
			  menu.setVisible(true);	
			}
			else
			  if(ev.getSource()==opHelp[0])
				JOptionPane.showMessageDialog(null, "Calculadora Do Laboratorio JoaquimChaves!");
				else
					if(ev.getSource()==opHelp[1])
						JOptionPane.showMessageDialog(null, "Calculadora Feita por Programadores : \nBruno F.Manjate\nKelvin Langa");
		}
	}
}
