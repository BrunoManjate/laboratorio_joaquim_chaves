import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class JRemover extends JFrame
{ 
  private JTable tab;
  private JPanel p,p1,p2;
  private JLabel lab1,lab2;
  private JTextField campo1;
  private JButton remover,voltar;
  private Visualizacoes vz;  
  private Jmenu m;
  public JRemover(Vector vec,Jmenu m)
  {
	  super("Remover Analise");
	  vz = new Visualizacoes();
	  tab = new JTable(vz.removerAnal(vec, Analise.contA,JVisualizacoes.AllTab.length),JVisualizacoes.AllTab);
	  JScrollPane pane = new  JScrollPane(tab);
	  this.setLayout(new BorderLayout());
	  lab2 = new JLabel("Introduz o codigo da Analise que Pretende Remover Dados Dados : ");
	  p1=new JPanel();
	  p1 = new JPanel(new GridLayout(1,2));
	  p1.add(lab2);	   
	  campo1 = new JTextField(5);
	  campo1.setFont(new Font("Times new roman",Font.BOLD,15));
	  campo1.addKeyListener(new KeyListener()
			  {
		  		public void keyTyped(KeyEvent ev) {
		  			char c = ev.getKeyChar();
			  		if(!((c>='0')&&(c<='9')||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)||(c == KeyEvent.VK_ENTER)))
			  		{
			  			getToolkit().beep();
			  			ev.consume();
			  			JOptionPane.showMessageDialog(null, "Introduza somente numeros");
			  		}	
		  		}
		  		public void keyReleased(KeyEvent ev)
		  		{
		  		  actualizar(vz.reomoverAnalise(vec, campo1.getText()));	
		  		}
		  		public void keyPressed(KeyEvent ev) {}
			  }
			 );
	  p1.add(campo1);
	  p2 = new JPanel(new GridLayout(1,2));
	  remover = new JButton("Remover Dados");
	  remover.addActionListener(new ActionListener()
	  {
		  public void actionPerformed(ActionEvent ev)
		  {
			  Analise an;
			  for(int x =0; x<vec.size(); x++)
			  {
				  an = (Analise) vec.elementAt(x);
				  int cod=Integer.parseInt(campo1.getText());
				  if(an.getCodigo()==cod)
				  {
					  vec.removeElementAt(x);
					  vec.trimToSize();
					  JOptionPane.showMessageDialog(null, "Dados Do Senhor(a) "+campo1.getText()+ "Removidos Com Sucesso!");
				  }
			  }
		  }
	  } );
	  p2.add(remover);
	  
	  voltar=new JButton("voltar");
	  p2.add(voltar);
	  voltar.addActionListener(
			  new ActionListener()
			  {
				public void actionPerformed(ActionEvent ev)
				{
					dispose();
				    m.setVisible(true);	
				}
			  }
			  );
	  this.add(p1,BorderLayout.NORTH);
	  this.add(pane,BorderLayout.CENTER);
	  this.add(p2,BorderLayout.SOUTH);
	  
	  addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent a) {
						dispose();
					    m.setVisible(true);
					}
				});
	  
	  setSize(1800,600);
	  setResizable(false);
	  setLocationRelativeTo(null);
	  setVisible(true);	  
  }
  public void actualizar(String[][]d)
  {
	  DefaultTableModel t =new DefaultTableModel(d,JVisualizacoes.AllTab);
	  tab.setModel(t);
	  if(tab.getRowSelectionAllowed())
		  tab.setRowSelectionInterval(0,0);
  }
}
