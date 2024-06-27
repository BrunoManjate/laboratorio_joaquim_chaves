import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
public class JAlterarAnalise extends JFrame
{
  private JTable tab;
  private JPanel p,painel,p1,panel,panel1;
  private JTextField campo,c1,c2;
  private JLabel lab,lab1,lab2,lab3,ldia,lmes,lano,lvazio;
  private Visualizacoes vz;
  private JComboBox box,box1,box2;
  public static int codigo;
  private int b=0, x;
  private Calculos c;
  private JButton voltar,update,limpar;
  public static String[]AllTab= {"Codigo da Analise","Numero de BI","Nome do paciente","Numero de telefone",
		  "Idade","Genero","Data da analise","Valor da Analise","Forma de pagamento","Quant.Glicose","Quant.Colesterol","Valor cardiaca","Valor renal",
		  "Quant.G_Vermelho","Quant.G_Branco","Quant.Plaquetas","Transporte","Tipo Urina","Tipo fezes"},
		  dia={"1","2","3","4","5","6","7","9","10","11","12","13","14","15","16","17","19","20","21","20","23","24","25","26","27","28","29","30","31"},
		  mes = {"1","2","3","4","5","6","7","9","10","11","12"};
         
  SimpleDateFormat data;
  private Container cont;
  public JAlterarAnalise(Jmenu m,Vector vec)
  {
	 super("Alterar Analise");
	 cont = getContentPane();
	 cont.setLayout(new BorderLayout());
	 vz = new Visualizacoes();
	 c = new Calculos();
	 data = new SimpleDateFormat("dd/MM/yyyy");
	 tab = new JTable(vz.vizualizarAnalise(vec, Analise.contA,JVisualizacoes.AllTab.length),AllTab);
	 JScrollPane pane = new JScrollPane(tab);
	 cont.add(pane,BorderLayout.CENTER);
	 campo = new JTextField(15);
	 p1 = new JPanel();
	 p1.setLayout(new BorderLayout());
	 cont.add(p1,BorderLayout.SOUTH);
	 update = new JButton("Actualizar");
	 campo.addKeyListener(new KeyListener()
			 {
		 		public void keyTyped(KeyEvent arg){
		 		}
		 		public void keyReleased(KeyEvent arg) {
		 			actualizar(vz.VIZAnalise(vec, campo.getText()));
		 			b=c.objecto(vec);
		 			Analise al;Bioquimica bi;Hematologia he; 
		 			al=(Analise)vec.elementAt(b);
		 			p1.removeAll();
		 			painel(al.getDatAnalise(),al.getIdade(),al.getFormPag(),m);
		 	   }
		 		public void keyPressed(KeyEvent arg)
		 		{}
			 });
	 		update.addActionListener(new ActionListener(){
	 				public void actionPerformed(ActionEvent arg) {
	 				  String str =""; 
	 				  if(!c1.getText().isEmpty() && !c2.getText().isEmpty())
	 				  {
	 					  Analise al;
	 					  al=(Analise)vec.elementAt(b);
	 					  try 
	 					  {
							al.setDatAnalise(data.parse(c1.getText()));
							al.setIdade(Byte.parseByte(c2.getText()));
							al.setFormPag(controle(str));
	 					  } 
	 					 catch (NumberFormatException e) {JOptionPane.showMessageDialog(null, "Preencha Corretamente");}
	 					 catch (ParseException f) {f.printStackTrace();}
	 					 JOptionPane.showMessageDialog(null, "Dados Actulizados Com Sucesso");
	 					 campo.setText("");
	 					 actualizar(vz.VIZAnalise(vec, campo.getText()));
	 				  }
	 				  else
	 					 JOptionPane.showMessageDialog(null, "Preencha os campos em branco");  
	 				   remove(p1);
	 				}
	 		});
	 	p = new JPanel();
	 	lab = new JLabel("Numero de BI");
	 	p.setLayout(new GridLayout(1,2));
	 	p.add(lab);
	 	p.add(campo);
	 	cont.add(p,BorderLayout.NORTH);
	 	
	 	addWindowListener(
   				new WindowAdapter() {
   					public void windowClosing(WindowEvent a) {
   						dispose();
   		                m.setVisible(true);				
   					}
   				});
	 	
	 	setSize(990,600);
		setVisible(true);
		setLocationRelativeTo(null);	
  }
  
  public String controle(String str) 
  {
	  if(x==1)
	    {
		   if(box.getSelectedIndex()==0)
		       return str = "Seguro";	   
		   if(box.getSelectedIndex()==1)
			   return str = "Cartao";
		   if(box.getSelectedIndex()==2)
			   return str = "Numerico";
	    }
	  
	  if(x==2)
	    {
		   if(box.getSelectedIndex()==0)
		       return str = "cartao";	   
		   if(box.getSelectedIndex()==1)
			   return str = "Seguro";
		   if(box.getSelectedIndex()==2)
			   return str = "Numerico";
	    } 
	  
	  if(x==3)
	    {
		   if(box.getSelectedIndex()==0)
		       return str = "Numerico";	   
		   if(box.getSelectedIndex()==1)
			   return str = "Cartao";
		   if(box.getSelectedIndex()==2)
			   return str = "Seguro";
	    }
	  return "";
  }
  
  public void painel(Date dat,byte idade,String formPag,Jmenu m)
  {
	  painel = new JPanel();
	  painel.removeAll();
	  painel.validate();
	  painel.setLayout(new GridLayout(5,2));
	  
	  lvazio = new JLabel();
	  painel.add(lvazio);
	  
	  panel1 = new JPanel(new GridLayout(1,3));
	  ldia = new JLabel("Dia");
	  ldia.setFont(new Font("Serif",Font.BOLD,15));
	  panel1.add(ldia);
	  
	  lmes = new JLabel("Mes");
	  lmes.setFont(new Font("Serif",Font.BOLD,15));
	  panel1.add(lmes);
	  
	  lano = new JLabel("Ano");
	  lano.setFont(new Font("Serif",Font.BOLD,15));
	  panel1.add(lano);
	  
	  painel.add(panel1);
	  
	  lab1 = new JLabel("Introduza a Data:");
	  painel.add(lab1);
	  
	  panel = new JPanel(new GridLayout(1,3)); 
	  box1 = new JComboBox(dia);
	  panel.add(box1);
	  box2 = new JComboBox(mes);
	  panel.add(box2);
	  c1 = new JTextField();
	  panel.add(c1);
	  
	  painel.add(panel);
	  lab2 = new JLabel("Introduza a idade:");
	  painel.add(lab2);
	  c2 = new JTextField(3);
	  c2.setText(idade+"");
	  painel.add(c2);
	  
	  lab3 = new JLabel("Introduza a forma de pagamento:");
	  painel.add(lab3);
	  
	  if(formPag.equalsIgnoreCase("Seguro"))
	  {
		  String [] names = {"Seguro","Cartao","Numerico"};
		  box = new JComboBox(names);
	      x=1;
	  }
      if(formPag.equalsIgnoreCase("Cartao"))
      {
    	  String [] names = {"Cartao","Seguro","Numerico"};
    	  box = new JComboBox(names);
          x=2;
      }
	  if(formPag.equalsIgnoreCase("Numerico"))
	  {
		  String [] names = {"Numerico","Cartao","Seguro"};
		  box = new JComboBox(names);
	      x=3;
	  }	  
	  painel.add(box);
	  
	  JPanel pa = new JPanel();
	  pa.removeAll();
	  
	  limpar = new JButton("Limpar");
	  Evento e = new Evento();
	  limpar.addActionListener(e);
	  update.addActionListener(e);
	  
	  painel.add(update);
	  painel.add(limpar);
	  pa.setLayout(new BorderLayout());
	  pa.add(painel,BorderLayout.CENTER);
	  painel.setBackground(Color.GRAY);
	  voltar = new JButton("Voltar");
	  voltar.addActionListener(new ActionListener() 
	  {
		  public void actionPerformed(ActionEvent arg)
		  {
			  dispose();
			  m.setVisible(true);
		  }
	  });
	  p1.remove(pa);
	  pa.add(voltar,BorderLayout.SOUTH);
	  p1.add(pa,BorderLayout.CENTER);
	  p1.validate();
	  p1.repaint();
	  pa.validate();
	  setSize(990,600);
	  setLocationRelativeTo(null);
  }
  public void actualizar(String [][]dado)
	{
	
		DefaultTableModel t= new DefaultTableModel(dado, JVisualizacoes.AllTab);
		tab.setModel(t);
		if(tab.getRowSelectionAllowed())
			tab.setRowSelectionInterval(0,0);
	}
	private class Evento implements ActionListener
	{	
		public void actionPerformed(ActionEvent ar) {
			if(ar.getSource()==limpar)
			{
				c1.setText("");
				c2.setText("");
			}
		}
		
	}
}