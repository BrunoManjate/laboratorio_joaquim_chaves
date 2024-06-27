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

public class JVisualizacoes extends JFrame
{
  private JTabbedPane tabela_all;
  private JTable tabelaBio,tabelaHema,tabelaMicro,tabelaAnal;
  private JPanel painelBio,painelHema,painelMicro,painelAnal;
  private JScrollPane scrollBio,scrollHema,scrollMicro,scrollAnal;
  public static String []cabecalhoBio = {"codigo","numero BI","nome do paciente","Telefone","Idade","Genero",
		  "Data da analise","Valor da analise","Foma de pagamento","Quant.glicose","Quant.colesterol","valor card","valor renal"};
  public static String[]cabecalhoHema = {"codigo","numero BI","nome do paciente","Telefone","Idade","Genero",
		  "Data da analise","Valor da analise","Foma de pagamento","Quant.globo vermelhos","Quant.globo brancos","Quant.Plaquetas","Transporte"};
  public static String[]cabecalhoMicro= {"codigo","numero BI","nome do paciente","Telefone","Idade","Genero",
		  "Data da analise","Valor da analise","Foma de pagamento","Tipo de urina","Tipo de fezes"};
  public static String[]cabecalhoAnalise= {"codigo","nome do paciente","Telefone","Idade","Genero",
		  "Data da analise","Tipo de analise","Foma de pagamento","valor da analise"};
  public static String[]cab= {"Codigo da Analise","Numero de BI","Nome do paciente","Numero de telefone",
		  "Idade","Genero","Data da analise","Forma de pagamento"};
  public static String[]AllTab= {"Codigo da Analise","Numero de BI","Nome do paciente","Numero de telefone",
		  "Idade","Genero","Data da analise","Valor da Analise","Forma de pagamento","Quant.Glicose","Quant.Colesterol","Valor cardiaca","Valor renal",
		  "Quant.G_Vermelho","Quant.G_Branco","Quant.Plaquetas","Transporte","Tipo Urina","Tipo fezes"};
  public static String[] nomes= {"Nome","Codigo","Idade","Quant.de colestrol"};
  public static String[] nomes1= {"Nome","Codigo","Idade","Contacto"};
  private Tratar tr;
  private Jmenu m1;
  private JButton voltar;
  public JVisualizacoes(String [][]anal1,String[][]anal2,String[][]anal3,Jmenu m)
  {
	  super("Visualizacoes");
	  aparencia();
	  m1=m;
	  tr = new Tratar();
	  tabela_all = new JTabbedPane();
	  //painelA(all);
	  painelA1(anal1);
	  painelA2(anal2);
	  painelA3(anal3);
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
  public void painelA1(String[][]anal1)
  {
	  painelBio = new JPanel();
	  painelBio.setLayout(new BorderLayout());
	  tabelaBio = new JTable(anal1,cabecalhoBio);
	  scrollBio= new JScrollPane(tabelaBio);
	  painelBio.add(scrollBio,BorderLayout.CENTER);
	  voltar =new JButton("Voltar");
	  voltar.addActionListener(tr);
	  painelBio.add(voltar,BorderLayout.SOUTH);
	  tabela_all.add("Bioquimica",painelBio);
  }
  public void painelA2(String[][]anal2)
  {
	  painelHema = new JPanel();
	  painelHema.setLayout(new BorderLayout());
	  tabelaHema = new JTable(anal2,cabecalhoHema);
	  scrollHema= new JScrollPane(tabelaHema);
	  painelHema.add(scrollHema,BorderLayout.CENTER);
	  voltar =new JButton("Voltar");
	  voltar.addActionListener(tr);
	  painelHema.add(voltar,BorderLayout.SOUTH);
	  tabela_all.add("Hematologia",painelHema);
  }
  public void painelA3(String[][]anal3)
  {
	  painelMicro = new JPanel();
	  painelMicro.setLayout(new BorderLayout());
	  tabelaMicro = new JTable(anal3,cabecalhoMicro);
	  scrollMicro= new JScrollPane(tabelaMicro);
	  painelMicro.add(scrollMicro,BorderLayout.CENTER);
	  voltar =new JButton("Voltar");
	  voltar.addActionListener(tr);
	  painelMicro.add(voltar,BorderLayout.SOUTH);
	  tabela_all.add("Microbiologia",painelMicro);
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
