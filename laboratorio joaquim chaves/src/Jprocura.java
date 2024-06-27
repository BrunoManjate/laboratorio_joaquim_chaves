import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

public class Jprocura extends JFrame
{
  private JTable tab;
  private JPanel p;
  private JLabel lab1;
  private JTextField campo1;
  private JButton voltar;
  private Visualizacoes vz;
  public static String[]AllTab= {"Codigo da Analise","Numero de BI","Nome do paciente","Numero de telefone",
		  "Idade","Genero","Data da analise","Valor da Analise","Forma de pagamento","Quant.Glicose","Quant.Colesterol","Valor cardiaca","Valor renal",
		  "Quant.G_Vermelho","Quant.G_Branco","Quant.Plaquetas","Transporte","Tipo Urina","Tipo fezes"};
  public Jprocura(Vector vec,Jmenu m)
  {
	  super("Pesquisa da analise");
	  vz = new Visualizacoes();
	  tab = new JTable(vz.procurarAnal(vec, Analise.contA, AllTab.length),AllTab);
	  JScrollPane pane = new  JScrollPane(tab);
	  this.setLayout(new BorderLayout());
	  lab1=new JLabel("Codigo da Analise:");
	  p = new JPanel();
	  p.setLayout(new GridLayout(1,2));
	  p.add(lab1);
	  campo1 = new JTextField(5);
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
		  		  actualizar(vz.proAnalise(vec, campo1.getText()));	
		  		}
		  		public void keyPressed(KeyEvent ev) {}
			  }
			  );
	  p.add(campo1);
	  voltar=new JButton("voltar");
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
	  this.add(p,BorderLayout.NORTH);
	  this.add(pane,BorderLayout.CENTER);
	  this.add(voltar,BorderLayout.SOUTH);
	 
	  addWindowListener(
 				new WindowAdapter() {
 					public void windowClosing(WindowEvent a) {
 						dispose();
 					    m.setVisible(true);
 					}
 				});
	  
	  setSize(1800,600);
	  setResizable(false);
	  setVisible(true);
	  setLocationRelativeTo(null);
  }
  public void actualizar(String[][]d)
  {
	  DefaultTableModel t =new DefaultTableModel(d,AllTab);
	  tab.setModel(t);
	  if(tab.getRowSelectionAllowed())
		  tab.setRowSelectionInterval(0,0);
  }
}
