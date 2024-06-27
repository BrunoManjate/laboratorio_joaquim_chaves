import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
public class JTableAll extends JFrame
{
	private JTabbedPane tabela_all;
	private JTable tabelaAll;
	private JScrollPane scrollAll;
	private JPanel painelAll;
	public static String[]AllTab= {"Codigo da Analise","Numero de BI","Nome do paciente","Numero de telefone",
			  "Idade","Genero","Data da analise","Valor da Analise","Forma de pagamento","Quant.Glicose","Quant.Colesterol","Valor cardiaca","Valor renal",
			  "Quant.G_Vermelho","Quant.G_Branco","Quant.Plaquetas","Transporte","Tipo Urina","Tipo fezes"};
	private Tratar tr;
	 private Jmenu m1;
	 private JButton voltar;
	 public JTableAll(String[][]all,Jmenu m)
	 {
		 super("Visualizacoes");
		  aparencia();
		  m1=m;
		  tr = new Tratar();
		  tabela_all = new JTabbedPane();
		  painelA(all);
		  this.add(tabela_all);
		  
		  addWindowListener(
	 				new WindowAdapter() {
	 					public void windowClosing(WindowEvent a) {
	 						dispose();
	 					    m.setVisible(true);
	 					}
	 				});
		  
		  setSize(1800,600);
		  setVisible(true);
		  setResizable(false);
		  setLocationRelativeTo(null);

	 }
	 public void painelA(String[][]all)
	  {
		  painelAll=new JPanel();
		  painelAll.setLayout(new BorderLayout());
		  tabelaAll = new JTable(all,AllTab);
		  scrollAll= new JScrollPane(tabelaAll);
		  painelAll.add(scrollAll,BorderLayout.CENTER);
		  voltar =new JButton("Voltar");
		  voltar.addActionListener(tr);
		  painelAll.add(voltar,BorderLayout.SOUTH);
		  tabela_all.add("Todos Dados",painelAll);
	  }
	 public class Tratar implements ActionListener
	  {
		  public void actionPerformed(ActionEvent ev)
		  {
			  dispose();
			  m1.setVisible(true);
		  }
	  }
	  public void aparencia(){
			try {
			    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			        if ("Nimbus".equals(info.getName())) {
			            UIManager.setLookAndFeel(info.getClassName());
			            break;
			        }
			    }
			}catch (Exception e) {e.printStackTrace();}
		}
} 
