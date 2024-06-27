import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Jmenu extends JFrame
{
  private JMenuBar b;
  private JMenuItem ler,gravar,quantidade;
  private JMenu file,client,adicionar,calculos,lucros,visual,sobrePaci,idadePaci,ordenar,extra,programador;
  private JFileChooser fich;
  private File f;
  private String nameCalculos[]= {"Quantidade de Analises"};
  private String nameLucro[]= {"Valor Total com iva","Valor total de seguros"};
  private String nameFiles[]= {"Ler do ficheiro","Gravar no Ficheiro","Situacao da Empresa","Sair"};
  private String nameCliente[]= {"Procurar Analise","Alterar Dados","Remover Analise"};
  private String namevisual[]= {"Todos Dados","Separadamente"};
  private String namesobrepaci[]= {"Paciente com anemia","Pacientes com colesterol alta","Pacientes com infecção bacteriana"};
  private String nameAdicionar[]= {"Bioquimica","Hematologia","Microbiologia"};
  private String nameIdade[]= {"Paciente Mais velho","Paciente Mais novo"};
  private String nameOrdenar[]= {"Crescente","Decrescente"};
  private String nameExtra[]= {"Calculadora","Game","Video"};
  private String nameProg[]= {"Expecificao do Programa","Dados do Programador"};
  
  private JMenuItem opfile[]= {new JMenuItem(),new JMenuItem(),new JMenuItem(),new JMenuItem()};
  //private JMenuItem opanal[]= {new JMenuItem(),new JMenuItem(),new JMenuItem(),new JMenuItem(),new JMenuItem()};
  private JMenuItem opvisual[]= {new JMenuItem(),new JMenuItem()};
  private JMenuItem opclient[]= {new JMenuItem(),new JMenuItem(),new JMenuItem()};
  private JMenuItem opAdicionar[]= {new JMenuItem(),new JMenuItem(),new JMenuItem()};
  private JMenuItem opLucros[]= {new JMenuItem(),new JMenuItem()};
  private JMenuItem opCalculo[]= {new JMenuItem()};
  private JMenuItem opsobrepaci[]= {new JMenuItem(),new JMenuItem(),new JMenuItem()};
  private JMenuItem opIdadePaci[]= {new JMenuItem(),new JMenuItem()};
  private JMenuItem opOrdenar[]= {new JMenuItem(),new JMenuItem()};
  private JMenuItem opExtra[]= {new JMenuItem(),new JMenuItem(),new JMenuItem()};
  private JMenuItem opProg[]= {new JMenuItem(),new JMenuItem()};
  
  private String nomesiconsfiles[]= {"leiturA.png","guard.png","invoice.png","exit.png"};
  private String nomesiconsvisual[] = {"ver.png","ver.png"};
  private String nomesiconsclient[]= {"pes.png","portfolio.png","trash.png"};
  private String nomeiconAdicionar[]= {"molecule.png","molecule.png","molecule.png",};
  private String nomeiconLucros[]= {"money.png","money.png"};
  private String nomeiconCalculos[]= {"list.png"};
  private String nomeiconSobrePaci[]= {"patient.png","patient.png","patient.png"};
  private String nomeiconIdade[]= {"career.png","career.png"};
  private String nomeiconOrdenar[]= {"arrows.png","down-arrow.png"};
  private String nomeiconExtra[]= {"cal.png","jogo.png","sound.png"};
  private String nomeiconProg[]= {"book.png","usu.png"};
  private TodoLabo todo;
  private boolean ok=false;
  public Jmenu(TodoLabo labo)
  {
	  aparencia();
	  b=new JMenuBar();
	  setJMenuBar(b);
	  fich = new JFileChooser();
	  todo=labo;
	  Image icon = Toolkit.getDefaultToolkit().getImage("holidays.png");
      setIconImage(icon);
	  file = new JMenu("File");
	  file.setIcon(new ImageIcon("folder (1).png"));
	  Tratar t = new Tratar();
	  for(int i=0;i<nameFiles.length;i++)
	  {
		  opfile[i] = new JMenuItem(nameFiles[i]);
		  opfile[i].addActionListener(t);
		  ImageIcon ico=new ImageIcon(nomesiconsfiles[i]);
		  opfile[i].setIcon(ico);
		  file.add(opfile[i]);
		  if(i==1)
			  file.addSeparator();
	  }
	  b.add(file);
	  visual = new JMenu("Visualizacoes");
	  visual.setIcon(new ImageIcon("vision.png"));
	  for(int i=0;i<namevisual.length;i++)
	  {
		  opvisual[i] = new JMenuItem(namevisual[i]);
		  opvisual[i].addActionListener(t);
		  ImageIcon ico = new ImageIcon(nomesiconsvisual[i]);
		  opvisual[i].setIcon(ico);
		  visual.add(opvisual[i]);
	  }
	  client = new JMenu("Analise");
	  client.setIcon(new ImageIcon("healthcare-and-medical.png"));
	  for(int i=0;i<nameCliente.length;i++)
	  {
		  opclient[i]=new JMenuItem(nameCliente[i]);
		  opclient[i].addActionListener(t);
		  ImageIcon ico = new ImageIcon(nomesiconsclient[i]);
		  opclient[i].setIcon(ico);
		  client.add(opclient[i]);
		  if(i==3)
			  client.addSeparator();
	  }
	  b.add(client);
	  adicionar=new JMenu("Adicionar");
	  adicionar.setIcon(new ImageIcon("addfun.jpg"));
	  for(int i=0;i<nameAdicionar.length;i++)
	  {
		  opAdicionar[i]=new JMenuItem(nameAdicionar[i]);
		  opAdicionar[i].addActionListener(t);
		  ImageIcon ico = new ImageIcon(nomeiconAdicionar[i]);
		  opAdicionar[i].setIcon(ico);
		  adicionar.add(opAdicionar[i]);
	  }
	  client.add(adicionar);
	  calculos = new JMenu("Contabilidade");
	  calculos.setIcon(new ImageIcon("stats.png"));
	  for(int x=0;x<nameCalculos.length;x++)
	  {
		  opCalculo[x]=new JMenuItem(nameCalculos[x]);
		  opCalculo[x].addActionListener(t);
		  ImageIcon ico = new ImageIcon(nomeiconCalculos[x]);
		  opCalculo[x].setIcon(ico);
		  calculos.add(opCalculo[x]);
	  }
	  lucros = new JMenu("Lucros");
	  lucros.setIcon(new ImageIcon("lucro.png"));
	  for(int i=0;i<nameLucro.length;i++) 
	  {
		  opLucros[i] = new JMenuItem(nameLucro[i]);
		  opLucros[i].addActionListener(t);
		  ImageIcon ico = new ImageIcon(nomeiconLucros[i]);
		  opLucros[i].setIcon(ico);
		  lucros.add(opLucros[i]);
	  }
	  calculos.add(lucros);
	  b.add(calculos);
	  sobrePaci= new JMenu("situacao do paciente");
	  sobrePaci.setIcon(new ImageIcon("ver.png"));
	  for(int i=0;i<namesobrepaci.length;i++)
	  {
		  opsobrepaci[i]= new JMenuItem(namesobrepaci[i]);
		  opsobrepaci[i].addActionListener(t);
		  ImageIcon ico = new ImageIcon(nomeiconSobrePaci[i]);
		  opsobrepaci[i].setIcon(ico);
		  sobrePaci.add(opsobrepaci[i]);
		  if(i==1)
			  visual.addSeparator();
	  }
	  idadePaci = new JMenu("Estatistica");
	  idadePaci.setIcon(new ImageIcon("report.png"));
	  for(int i=0;i<nameIdade.length;i++)
	  {
		  opIdadePaci[i] = new JMenuItem(nameIdade[i]);
		  opIdadePaci[i].addActionListener(t);
		  ImageIcon ico = new ImageIcon(nomeiconIdade[i]);
		  opIdadePaci[i].setIcon(ico);
		  idadePaci.add(opIdadePaci[i]);
	  }
	  b.add(idadePaci);
	  ordenar = new JMenu("Ordenar");
	  ordenar.setIcon(new ImageIcon("order.png"));
	  for(int i=0;i<nameOrdenar.length;i++)
	  {
		  opOrdenar[i] = new JMenuItem(nameOrdenar[i]);
		  opOrdenar[i].addActionListener(t);
		  ImageIcon ico = new ImageIcon(nomeiconOrdenar[i]);
		  opOrdenar[i].setIcon(ico);
		  ordenar.add(opOrdenar[i]);
		  if(i==0)
			  ordenar.addSeparator();
	  }
	  idadePaci.add(ordenar);
	  visual.add(sobrePaci);
	  extra = new JMenu("Extra");
	  extra.setIcon(new ImageIcon("cogwheel.png"));
	  for(int i=0;i<nameExtra.length;i++)
	  {
		 opExtra[i] = new JMenuItem(nameExtra[i]);
		 opExtra[i].addActionListener(t);
		 ImageIcon ico=new ImageIcon(nomeiconExtra[i]);
		 opExtra[i].setIcon(ico);
		 extra.add(opExtra[i]);
	  }
	  b.add(visual);
	  b.add(extra);
	  programador = new JMenu("Sobre");
	  programador.setIcon(new ImageIcon("man.png"));
	  for(int i=0;i<nameProg.length;i++)
	  {
		  opProg[i] = new JMenuItem(nameProg[i]);
		  opProg[i].addActionListener(t);
		  ImageIcon ico = new ImageIcon(nomeiconProg[i]);
		  opProg[i].setIcon(ico);
		  programador.add(opProg[i]);
	  }
	  b.add(programador);
	  File directorio = new File(System.getProperty("user.dir"));
	  fich.setCurrentDirectory(directorio);
	  fich.setFileFilter(new FileNameExtensionFilter("Ficheiros","txt","dat"));
	  setContentPane(new JLabel(new ImageIcon("yes.jpg")));
	 
	  programador.setEnabled(false);
	  extra.setEnabled(false);
	  
	  addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent a) {
						dispose();
					    todo.adapLogin(gerir());
					}
				});
	  
	  setSize(1600,820);
      setLocationRelativeTo(null);
      setVisible(false);
	  
  }
  public Jmenu gerir()
  {
		return this;
  }
  public class Tratar implements ActionListener
  {
	  int val;
	  public void actionPerformed(ActionEvent ev)
	  {	
		  if(ev.getSource()==opfile[0])
		  {
			  val = fich.showOpenDialog(null);
			  if(val==JFileChooser.APPROVE_OPTION)
			  {f = fich.getSelectedFile();
				 if(fich.getSelectedFile().getPath().contains(".txt"))
					 todo.lerFicheiro(f.getPath());
				 else
					 if(fich.getSelectedFile().getPath().contains(".dat"))
						 todo.lerObj(f.getPath());
				 ok=true;
				 JOptionPane.showMessageDialog(null,"Ficheiro lido com sucesso!","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
			  }
			  
			  programador.setEnabled(true);
			  extra.setEnabled(true);
		  }
		  else
			  if(ev.getSource()==opfile[1]&&ok)
			  {
				  Component modalToComponenta=null;
				  val = fich.showSaveDialog(modalToComponenta);
				  if(val==JFileChooser.APPROVE_OPTION) {
					  f = fich.getSelectedFile();
				  		todo.adapEsFichObj();
				  }
			  }
			  else
				  if(ev.getSource()==opfile[2]&&ok)
				  {
					 todo.adapgravarSituacao();
					 setVisible(false);
				  }
			  else 
				  if(ev.getSource()==opfile[3]&&ok)
				  {
					  int res=0;
					  res = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?");
					  if(res==0)
					  {
						  JOptionPane.showMessageDialog(null,"Adeus!!!!\nVolte sempre");
						  System.exit(0);
					  }
				  }
				  else
		  if(ev.getSource()==opclient[0]&&ok)
		  {
			  todo.adapProcura(gerir());
			  setVisible(false);
		  }
		  else
			  if(ev.getSource()==opclient[1]&&ok)
			  {
				  todo.adapEditar(gerir());
				  setVisible(false);
			  }
			  else
				  if(ev.getSource()==opclient[2]&&ok)
				  {
					  todo.adapRemover(gerir());
					  setVisible(false);
				  }
				   else
				    if(ev.getSource()==opAdicionar[0]&&ok)
				    {
				    		todo.adapAddBioquimica(gerir());
				    		setVisible(false);
				     }
				      else
				    	 if(ev.getSource()==opAdicionar[1]&&ok)
				    	 {
				    			todo.adapAddHematologia(gerir());
				    			setVisible(false);
				    	  }
				    	  else
				    		 if(ev.getSource()==opAdicionar[2]&&ok)
				    			{
				    				todo.adapAddMicrobiologia(gerir());
				    				setVisible(false);
				    			}
				    			else
				    				if(ev.getSource()==opCalculo[0]&&ok)
				    				{
				    					todo.adapQuantidades(todo, gerir(),0, "Quantidades");
				    					setVisible(false);
				    				}
				    				else
				    					if(ev.getSource()==opLucros[0]&&ok)
				    						JOptionPane.showMessageDialog(null, "O valor total recebido pelo laboratorio com iva:"+todo.adapValorComIva());
				    					else
				    						if(ev.getSource()==opLucros[1]&&ok)
				    							JOptionPane.showMessageDialog(null, "O valor total recebido pelos seguros:"+todo.adapValorTotalSeguros());
				    						else
				    							if(ev.getSource()==opIdadePaci[0]&&ok)
				    							{
				    								todo.adapQuantidades(todo, gerir(),4, "");
							    					setVisible(false);		
				    							}
				    							else
				    								if(ev.getSource()==opIdadePaci[1]&&ok)
				    								{
				    									todo.adapQuantidades(todo, gerir(),5, "");
								    					setVisible(false);	
				    								}
				    								else
				    									if(ev.getSource()==opOrdenar[0]&&ok)
				    									{
				    									  todo.adapOrdenarCrescente();
				    									  todo.adapAllTab(gerir());
				    									  setVisible(false);
				    									}
				    									else
				    										if(ev.getSource()==opOrdenar[1]&&ok)
				    										{
				    											todo.adapOrdenarDecrescente();
						    									todo.adapAllTab(gerir());
						    									setVisible(false);
				    										}
				    										else
				    											if(ev.getSource()==opvisual[0]&&ok)
				    											{
				    												todo.adapAllTab(gerir());
				    												setVisible(false);
				    											}
				    											else
				    												if(ev.getSource()==opvisual[1]&&ok)
				    												{
				    													todo.adapVizu(gerir());
				    													setVisible(false);
				    												}
				    												else
				    													if(ev.getSource()==opsobrepaci[0]&&ok)
				    													{
				    														todo.adapQuantidades(todo, gerir(),1, "Paciente com mais anemia");
				    														setVisible(false); 
				    													}
				    													else
				    														if(ev.getSource()==opsobrepaci[1]&&ok)
				    														{
				    															todo.adapQuantidades(todo, gerir(), 2, "Pacientes com colestrol alta");
				    															setVisible(false);
				    														}
				    														else
				    															if(ev.getSource()==opsobrepaci[2]&&ok)
				    															{
				    																todo.adapQuantidades(todo, gerir(), 3, "Pacientes com alguma Infeccao");
				    																setVisible(false);
				    															}
				    															else
				    																if(ev.getSource()==opExtra[0]&&ok)
				    																{
				    																	todo.adapCalculadora(gerir());
				    																	setVisible(false);
				    																}
				    																else
				    																	if(ev.getSource()==opExtra[1]&&ok)
				    																	{
				    																	  todo.adapJogo(gerir());
				    																	  setVisible(false);
				    																	}
				    																	else
				    																		if(ev.getSource()==opExtra[2]&&ok)
				    																		{
				    																			try {
				    																				todo.adapVideo();
																									} 
				    																			catch (IOException e) {e.printStackTrace();}
				    																			setVisible(true);
				    																		}
				    																		else
				    																			if(ev.getSource()==opProg[0]&&ok)
				    																			{
				    																			  todo.adapSobre(gerir());	
				    																			}
				    																			else
				    																				if(ev.getSource()==opProg[1]&&ok)
				    																				{
				    																				  todo.adapDadosProg(gerir());
				    																				  setVisible(false);
				    																				}
				    																				else
				    							    											      JOptionPane.showMessageDialog(null, "Leia Primeiro do Ficheiro");
				    							  
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
