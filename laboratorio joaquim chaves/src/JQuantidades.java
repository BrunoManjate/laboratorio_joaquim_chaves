import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class JQuantidades extends JFrame
{
  private JTable tab;
  private JButton volta;
  private String nomes[]= {"Nome","Codigo","Idade","Quant.Globulos vermelhos"};
  private String nomes1[]= {"Nome","Codigo","Idade"};
  private Container c;
  private TodoLabo todo;
  private Jmenu m1;
  private Font fonte = new Font("Impact", Font.PLAIN, 12);
  public JQuantidades(TodoLabo la,Jmenu m,int ind,String tit)
  {
	  super(tit);
	  todo = la;
	  m1=m;
	  c = getContentPane();
	  c.setLayout(new BorderLayout());
	  if(ind==0)
		  quantidade();
	  else
	  {
		  if(ind==1)
			  quantG_Vermelho();
		  else
		  {
			  if(ind==2)
				  quantColestrol();
			  else
			  {
				  if(ind==3)
					paciInfeccao();  
				  else
					  if(ind==4)
						  idadeVelho();
					  else
						  if(ind==5)
							  idadeNovo();
			  } 
		  }  	  
	  }
  }
  public void idadeNovo()
  {
	  Trat t = new Trat();
	  tab = new JTable(todo.adapIdadeMaisNovo(),nomes1);
	  JScrollPane p = new JScrollPane(tab);
	  c.add(p,BorderLayout.CENTER);
	  volta=new JButton("Voltar");
	  volta.addActionListener(t);
	  JLabel lab = new JLabel();
	  lab.setIcon(new ImageIcon("joaquim-chave.jpg"));
	  JPanel p1 = new JPanel();
	  p1.setLayout(new BorderLayout());
	  p1.add(lab,BorderLayout.CENTER);
	  p1.add(volta,BorderLayout.SOUTH);
	  c.add(p1,BorderLayout.SOUTH);
	  addWindowListener(
 				new WindowAdapter() {
 					public void windowClosing(WindowEvent a) {
 						dispose();
 		                m1.setVisible(true);				
 					}
 				});
	  
	  setSize(450,300);
	  setLocationRelativeTo(null);
	  setVisible(true);
  }
  public void idadeVelho()
  {
	  Trat t = new Trat();
	  tab = new JTable(todo.adapIdadeMaisVelha(),nomes1);
	  JScrollPane p = new JScrollPane(tab);
	  c.add(p,BorderLayout.CENTER);
	  volta=new JButton("Voltar");
	  volta.addActionListener(t);
	  JLabel lab = new JLabel();
	  lab.setIcon(new ImageIcon("joaquim-chave.jpg"));
	  JPanel p1 = new JPanel();
	  p1.setLayout(new BorderLayout());
	  p1.add(lab,BorderLayout.CENTER);
	  p1.add(volta,BorderLayout.SOUTH);
	  c.add(p1,BorderLayout.SOUTH);
	  
	  addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent a) {
						dispose();
		                m1.setVisible(true);				
					}
				});
	  
	  setSize(450,300);
	  setLocationRelativeTo(null);
	  setVisible(true);
	  
  }
  public void paciInfeccao()
  {
	  Trat t = new Trat();
	  tab = new JTable(todo.adapVizualizarInfeccao(),JVisualizacoes.nomes1);
	  JScrollPane p = new JScrollPane(tab);
	  c.add(p,BorderLayout.CENTER);
	  volta=new JButton("Voltar");
	  volta.addActionListener(t);
	  JLabel lab = new JLabel();
	  lab.setIcon(new ImageIcon("joaquim-chave.jpg"));
	  JPanel p1 = new JPanel();
	  p1.setLayout(new BorderLayout());
	  p1.add(lab,BorderLayout.CENTER);
	  p1.add(volta,BorderLayout.SOUTH);
	  c.add(p1,BorderLayout.SOUTH);
	  
	  addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent a) {
						dispose();
		                m1.setVisible(true);				
					}
				});
	  
	  setSize(450,300);
	  setLocationRelativeTo(null);
	  setVisible(true);
  }
  private void quantColestrol()
  {
	  Trat t = new Trat();
	  tab = new JTable(todo.adapVizualizarColestrol(),JVisualizacoes.nomes);
	  JScrollPane p = new JScrollPane(tab);
	  c.add(p,BorderLayout.CENTER);
	  volta=new JButton("Voltar");
	  volta.addActionListener(t);
	  JLabel lab = new JLabel();
	  lab.setIcon(new ImageIcon("joaquim-chave.jpg"));
	  JPanel p1 = new JPanel();
	  p1.setLayout(new BorderLayout());
	  p1.add(lab,BorderLayout.CENTER);
	  p1.add(volta,BorderLayout.SOUTH);
	  c.add(p1,BorderLayout.SOUTH);
	  
	  addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent a) {
						dispose();
		                m1.setVisible(true);				
					}
				});
	  
	  setSize(450,300);
	  setLocationRelativeTo(null);
	  setVisible(true);
  }
  private void quantG_Vermelho()
  {
	  Trat t = new Trat();
	  tab = new JTable(todo.adapVizualizarGlo_Vermelhos(),nomes);
	  JScrollPane p = new JScrollPane(tab);
	  c.add(p,BorderLayout.CENTER);
	  volta=new JButton("Voltar");
	  volta.addActionListener(t);
	  JLabel lab = new JLabel();
	  lab.setIcon(new ImageIcon("joaquim-chave.jpg"));
	  JPanel p1 = new JPanel();
	  p1.setLayout(new BorderLayout());
	  p1.add(lab,BorderLayout.CENTER);
	  p1.add(volta,BorderLayout.SOUTH);
	  c.add(p1,BorderLayout.SOUTH);
	  
	  addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent a) {
						dispose();
		                m1.setVisible(true);				
					}
				});
	  
	  setSize(450,300);
	  setLocationRelativeTo(null);
	  setVisible(true);
  }
   private void quantidade()
   {	
	  	JPanel c1=new JPanel();
		JPanel bi= new JPanel();
		bi.setLayout(new GridLayout(2,1));
		bi.setBorder(BorderFactory.createTitledBorder("Bioquimica"));
		JLabel bio=new JLabel("Quantidade Total");
		JLabel bioq=new JLabel(Bioquimica.contB+"");
		bioq.setFont(fonte);
		bi.add(bio);
		bi.add(bioq);
		c1.add(bi);
		
		JPanel he = new JPanel();
		he.setLayout(new GridLayout(2,1));
		he.setBorder(BorderFactory.createTitledBorder("Hematologia"));
		JLabel hem = new JLabel("Quantidade Total");
		JLabel hema = new JLabel(Hematologia.contH+"");
		hema.setFont(fonte);
		he.add(hem);
		he.add(hema);
		c1.add(he);
		
		JPanel mi = new JPanel();
		mi.setLayout(new GridLayout(2,1));
		mi.setBorder(BorderFactory.createTitledBorder("Microbiologia"));
		JLabel mic = new JLabel("Quantidade Total");
		JLabel micro = new JLabel(Microbiologia.contM+"");
		micro.setFont(fonte);
		mi.add(mic);
		mi.add(micro);
		c1.add(mi);
		
		c.add(c1, BorderLayout.CENTER);
		JLabel lab= new JLabel();
		lab.setIcon(new ImageIcon("joaquim-chave.jpg"));
		c.add(lab,BorderLayout.NORTH);
		JPanel embaixo= new JPanel();
		embaixo.setLayout(new GridLayout(2,1));
		
		JLabel tot= new JLabel("Quantidade total de Analises");
		JLabel ntot= new JLabel("= "+Analise.contA+"");
		ntot.setFont(fonte);
		embaixo.setFont(fonte);
		embaixo.setBorder(BorderFactory.createTitledBorder("Analises"));
		embaixo.add(tot);
		embaixo.add(ntot);
		c1.add(embaixo);
		volta= new JButton("Voltar");
		Trat t= new Trat();
		volta.addActionListener(t);
		
		addWindowListener(
 				new WindowAdapter() {
 					public void windowClosing(WindowEvent a) {
 						dispose();
 					    m1.setVisible(true);
 					}
 				});
		
		c.add(volta, BorderLayout.SOUTH);
		setSize(450, 390);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	private class Trat implements ActionListener
	{
		public void actionPerformed(ActionEvent ar) {
			if(ar.getSource()==volta)
			{
				dispose();
				m1.setVisible(true);
			}
			
		}
		
	}
}
