import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
public class DadosProgramdor extends JFrame 
{
	private JTable tabela;
    private JScrollPane scrl;
    private String titulos[] ={"Dados Programador","Informacao"};
    private String [][]tabelaDados;
    private JButton bVoltar;
    private Container cont;
	public DadosProgramdor(Jmenu m) 
	{
		super("Dados do Programador");
		cont = getContentPane();
		
		tabelaDados = criarTabela(12, 2);  
		tabela = new JTable(tabelaDados,titulos);
		tabela.setEnabled(false);
		
		scrl = new JScrollPane(tabela);
		cont.add(scrl, BorderLayout.CENTER); 
		bVoltar = new JButton("Voltar");
		bVoltar.addActionListener(new ActionListener()
 	    {
  	       public void actionPerformed(ActionEvent ev)
  	       {
  	    	  dispose();
  	    	  m.setVisible(true);
  	       }	
  	    });
       cont.add(bVoltar,BorderLayout.SOUTH);
       
       addWindowListener(
  				new WindowAdapter() {
  					public void windowClosing(WindowEvent a) {
  						dispose();
  		                m.setVisible(true);				
  					}
  				});
       
       setSize(500,283);
       setResizable(false);
       setLocationRelativeTo(null);
       setVisible(true);
	}
	 public String [][] criarTabela(int linhas,int colunas)
     {
     	String [][] x = new String[linhas][titulos.length];
     	
     	x[0][0] = "Nome : ";
     	x[0][1] = "Bruno F.Manjate";
     	x[1][0] = "Codigo : ";
     	x[1][1] = "";
     	x[2][0] = "numero : ";
     	x[2][1] = "";	
     	x[3][0] = "Email : ";
     	x[3][1] = "brunomanjate2@gmail.com";
     	x[4][0] = "";
     	x[4][1] ="";
     	x[5][0] ="Nome : ";
     	x[5][1] ="Kelvin Langa";
     	x[6][0]	="Codigo : ";
     	x[6][1] ="";
     	x[7][0] ="Numero : ";
     	x[7][1] ="";
     	x[8][0] ="Email :";
     	x[8][1]="kelvinLanga20@gmail.com";
     	x[9][0]="";
     	x[9][1]="";
     	x[10][0] ="";
     	x[10][1] ="";
     	x[11][0] ="Engenharia";
     	x[11][1] ="Informatica";
     	return x;
     }
}
