import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class TodoLabo
{
  private Vector vec;
  private AddObj add;
  private Calculos c;
  private Escrever e;
  private Visualizacoes vz;
  private OrdenarPorData o;
  private DecimalFormat mt = new DecimalFormat("###,###,###.00 MT");
  public TodoLabo()
  {
	  vec = new Vector();
	  add = new AddObj();
	  c = new Calculos();
	  e = new Escrever();
	  o = new OrdenarPorData();
	  vz = new Visualizacoes();
	  
  }
  public void lerFicheiro(String fich)
  {
    int cod,quantGLI,quantCOL,quantG_BRA;
    long numTel;
    byte idade,quantG_VER;
    char sexo,cr;
    Date datAnalise;
    float valorAnalise,valCARD,valRENAL,quantPLA;
    SimpleDateFormat data;
	data = new SimpleDateFormat("dd/MM/yyyy");
    String numBI,nomePaci,formPag,linha,transporte,tipUrina,tipFezes;
    StringTokenizer cadeia;
    try
    {
      BufferedReader k = new BufferedReader(new FileReader(fich));
      linha = k.readLine();
      while(linha!=null) 
      {
    	  cadeia = new StringTokenizer(linha,";");
    	  cod = Integer.parseInt(cadeia.nextToken());
    	  numBI = cadeia.nextToken();
    	  nomePaci = cadeia.nextToken();
    	  numTel = Long.parseLong(cadeia.nextToken());
    	  idade = Byte.parseByte(cadeia.nextToken());
    	  sexo = cadeia.nextToken().charAt(0);
    	  datAnalise = data.parse(cadeia.nextToken());
    	  valorAnalise = Float.parseFloat(cadeia.nextToken());
    	  formPag = cadeia.nextToken();
    	  cr = cadeia.nextToken().charAt(0);
    	  if(cr=='B'||cr=='b')
    	  {
    		quantGLI = Integer.parseInt(cadeia.nextToken());
    		quantCOL = Integer.parseInt(cadeia.nextToken());
    		valCARD = Float.parseFloat(cadeia.nextToken());
    		valRENAL = Float.parseFloat(cadeia.nextToken());
    		add.addBioquimica(cod, numBI, nomePaci, numTel, idade, sexo, datAnalise, valorAnalise, formPag, quantGLI, quantCOL, valCARD, valRENAL, vec);
    	  }
    	  else
    	  {
    		  if(cr=='H'||cr=='h')
    		  {
    			 quantG_VER = Byte.parseByte(cadeia.nextToken());
    			 quantG_BRA = Integer.parseInt(cadeia.nextToken());
    			 quantPLA = Float.parseFloat(cadeia.nextToken());
    			 transporte = cadeia.nextToken();
    			 add.addHematologia(cod, numBI, nomePaci, numTel, idade, sexo, datAnalise, valorAnalise, formPag, quantG_VER, quantG_BRA, quantPLA, transporte, vec);
    		  }
    		  else
    		  {
    			  if(cr=='M'||cr=='m')
    			  {
    				  tipUrina = cadeia.nextToken();
    				  tipFezes = cadeia.nextToken();
    				  add.addMicrobiologia(cod, numBI, nomePaci, numTel, idade, sexo, datAnalise, valorAnalise, formPag, tipUrina, tipFezes, vec);
    			  }
    		  }
    	  }
    	linha=k.readLine();  
      }
      k.close();
    }
    catch(FileNotFoundException e) {System.out.println(e.getMessage());}
    catch(NumberFormatException n) {System.out.println(n.getMessage());}
    catch(IOException i) {System.out.println(i.getMessage());} 
    catch (ParseException e) {e.printStackTrace();}
  }
  public void adapCarregar(Jmenu m)
  {
	 JCarregar c= new JCarregar(m);
	 c.setVisible(true);
  }
  public void adapSobre(Jmenu m)
  {
	  new Sobre(m,"Sobre.txt");
  }
  public void adapDadosProg(Jmenu m)
  {
	  new DadosProgramdor(m);
  }
  public void adapJogo(Jmenu m)
  {
	  new Jogo_XO(m);
  }
  public void adapVideo() throws IOException
  {
	  new Video();
  }
  public void adapCalculadora(Jmenu m)
  {
	 new Calculadora(m);
  }
  public String[][]adapIdadeMaisVelha()
  {
	  return vz.vIdadeMaisVelho(vec,false);
  }
  public String[][]adapIdadeMaisNovo()
  {
	  return vz.vIdadeMaisVelho(vec,true);
  }
  public void adapRemover(Jmenu m)
  {
	 new JRemover(vec,m);
  }
  public void adapOrdenarCrescente()
  {
	 o.ordenarAnalise(vec,false);
  }
  public void adapOrdenarDecrescente()
  {
	 o.ordenarAnalise(vec,true);
  }
  public void adapgravarSituacao()
  {
	  float valor=c.ValorTotalComIva(vec);
	  e.gravarSituacaoEmpresa(vec, valor);
  }
  public String[][] adapVizualizarInfeccao()
  {
	  String[][]ar2=vz.visualizarInfeccao(vec);
	  return ar2;
  }
  public String[][] adapVizualizarColestrol()
  {
	  String[][]ar1=vz.visualizarColestrol(vec);
	  return ar1;
  }
  public String[][] adapVizualizarGlo_Vermelhos()
  {
	String[][]ar=vz.visualizarGloVermelho(vec); 
	return ar;
  }
  public String adapValorTotalSeguros()
  {
	  float vs=c.ValorTotalSeguros(vec);
	  return mt.format(vs);
  }
  public String adapValorComIva()
  {
	 float vt= c.ValorTotalComIva(vec);
	 return mt.format(vt);
  }
  public void adapAddBioquimica(Jmenu m)
  {
	  JnovoBioQuimica a = new JnovoBioQuimica(vec,m);
	  a.setVisible(true);
  }
  public void adapAddHematologia(Jmenu m)
  {
	  JnovoHematologia a = new JnovoHematologia(vec,m);
	  a.setVisible(true);
  }
  public void adapAddMicrobiologia(Jmenu m)
  {
	  JnovoMicroBiologia  a = new JnovoMicroBiologia(vec,m);
	  a.setVisible(true);
  }
  public void adapQuantidades(TodoLabo l,Jmenu m,int i,String tit)
  {
	  JQuantidades q = new JQuantidades(l,m,i,tit);
  }
  public void adapEditar(Jmenu m)
  {
	  new JAlterarAnalise(m,vec);
  }
  public void adapProcura(Jmenu m)
  {
	  new Jprocura(vec,m);
  }
  public void adapLogin(Jmenu m)
  {
	  LoginP a = new LoginP(m);
	  a.setVisible(true);
  }
  public void adapEsFichObj()
  {
	  e.escFichObj(vec);
  }
  public void adapAllTab(Jmenu m)
  {
	  new JTableAll(vz.todos(vec.size(), JVisualizacoes.AllTab.length, vec),m);
	 
  }
  public void adapVizu(Jmenu m)
  {
    new JVisualizacoes(
    		vz.vizualizarBioquimica(vec, Bioquimica.contB, JVisualizacoes.cabecalhoBio.length),
    		vz.vizualizarHematologia(vec, Hematologia.contH, JVisualizacoes.cabecalhoHema.length),
    		vz.vizualizarMicrobiologia(vec, Microbiologia.contM, JVisualizacoes.cabecalhoMicro.length),m);
  }

  public void lerObj(String fi)
  {
	  try
	  {
		  FileInputStream f = new FileInputStream(fi);
		  ObjectInputStream o = new ObjectInputStream(f);
		  vec = (Vector)o.readObject();
		  o.close();
	  }
	  catch(FileNotFoundException f) {System.out.println("Ficheiro nao encontrado");}
	  catch(IOException i) {i.printStackTrace();}
	  catch(ClassNotFoundException c) {c.printStackTrace();}
	  System.out.println("Ficheiro escrito com sucesso!!!!");
  }
}
