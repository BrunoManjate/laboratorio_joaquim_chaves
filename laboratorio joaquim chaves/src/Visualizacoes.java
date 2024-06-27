import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
public class Visualizacoes
{
  private DecimalFormat peso,mt,med;
  public static String codi;
  private SimpleDateFormat dt;

  public Visualizacoes()
  {
	  mt = new DecimalFormat("###,###,###.00 Mt");
	  peso = new DecimalFormat("###,###.## mg/dl");
	  med = new DecimalFormat("###,###.## cels/microl");
	  dt = new SimpleDateFormat("dd/MM/yyyy");
  }
  public String [][]vIdadeMaisVelho(Vector vec,boolean criterio)
  {
	  String [][]ar=new String[1][3];
	  byte idade=0;
	  if(criterio==true)
		  idade=115;
	  Analise al,ai=null;
	  for(int j=0;j<vec.size();j++)
	  {
		  al=(Analise)vec.elementAt(j);
		  if(al.getIdade()<=idade&&criterio==true)
		  {
			idade=al.getIdade();
			ai=al;
		  }
		  if(al.getIdade()>=idade&&criterio==false)
		  {
			idade=al.getIdade();
			ai=al;
		  }
	  }
	  ar[0][0]=ai.getNomePac();
	  ar[0][1]=ai.getCodigo()+"";
	  ar[0][2]=ai.getIdade()+"";
	  return ar;
  }
  public String [][]removerAnal(Vector vec,int linhas,int colunas)
  {
		  String[][]array = new String[linhas][colunas];
		  Analise al;Bioquimica bi;Hematologia he;Microbiologia mi;
		  int cont=0;String sexo;
		  for(int i=0;i<vec.size();i++)
		  {
			  al=(Analise)vec.elementAt(i);
				  if(al.getGenero()=='f')
					  sexo="Femenino";
				  else
					  sexo="Masculino";
				  al=(Analise)vec.elementAt(i);
				  array[cont][0]=al.getCodigo()+"";
				  array[cont][1]=al.getNomePac();
				  array[cont][2]=al.getNumBI();
				  array[cont][3]=al.getNumTel()+"";
				  array[cont][4]=al.getIdade()+"";
				  array[cont][5]=sexo;
				  array[cont][6]=dt.format(al.getDatAnalise());
				  array[cont][7]= mt.format(al.getValorAnalise());
				  array[cont][8]=al.getFormPag();
				 
				  if(al  instanceof Bioquimica)
				 {
					  bi = (Bioquimica) al;
					  array[cont][9]=peso.format(bi.getQuantGLI());
					  array[cont][10]=peso.format(bi.getValCARD());
					  array[cont][11]= mt.format(bi.getValCARD());
					  array[cont][12]=mt.format(bi.getValRENAL());
					  array[cont][13]="N/A";
					  array[cont][14]="N/A";
					  array[cont][15]="N/A";
					  array[cont][16]="N/A";
					  array[cont][17]="N/A";
					  array[cont][18]="N/A";
				 }else
				 {
					 if(al  instanceof Hematologia)
					 {
						 he = (Hematologia) al;
						 array[cont][9] ="N/A";
						 array[cont][10]="N/A";
						 array[cont][11]="N/A";
						 array[cont][12]="N/A";
						 array[cont][13]=he.getQuantG_VER()+"";
						 array[cont][14]=he.getQuantG_BRA()+"";
						 array[cont][15]=he.getQuantPLA()+"";
						 array[cont][16]=he.getTransport();
						 array[cont][17]="N/A";
						 array[cont][18]="N/A";  
					 }else
					 {
						 if(al  instanceof Microbiologia)
						 {
							 mi = (Microbiologia ) al;
							 array[cont][9]="N/A";
							 array[cont][10]="N/A";
							 array[cont][11]="N/A";
							 array[cont][12]="N/A";  
							 array[cont][13]="N/A";
							 array[cont][14]="N/A";
							 array[cont][15]="N/A";
							 array[cont][16]="N/A";  
							 array[cont][17] = mi.getTipUrina();
							 array[cont][18] = mi.getTipFezes();
						 }
					 }
				 }
				  cont++;
		  }
		  return array;
  }  
  public String[][]reomoverAnalise(Vector vec,String cod)
  {
		  String[][] array=new String[pAnalise(vec,cod)][JTableAll.AllTab.length];
		  int cont=0;String codigo,sexo;
		  Analise al; Hematologia he; Microbiologia mi; Bioquimica bi;
		  for(int i=0;i<vec.size();i++)
		  {
			  al=(Analise)vec.elementAt(i);
			 codigo = al.getCodigo()+"";
			  if(codigo.startsWith(cod))
			  {
				  if(al.getGenero()=='f')
					  sexo="Femenino";
				  else
					  sexo="Masculino";
				  al=(Analise)vec.elementAt(i);
				  array[cont][0]=al.getCodigo()+"";
				  array[cont][1]=al.getNomePac();
				  array[cont][2]=al.getNumBI();
				  array[cont][3]=al.getNumTel()+"";
				  array[cont][4]=al.getIdade()+"";
				  array[cont][5]=sexo;
				  array[cont][6]=dt.format(al.getDatAnalise());
				  array[cont][7]= mt.format(al.getValorAnalise());
				  array[cont][8]=al.getFormPag();
				 
				  if(al  instanceof Bioquimica)
				 {
					  bi = (Bioquimica) al;
					  array[cont][9]=peso.format(bi.getQuantGLI());
					  array[cont][10]=peso.format(bi.getValCARD());
					  array[cont][11]= mt.format(bi.getValCARD());
					  array[cont][12]=mt.format(bi.getValRENAL());
					  array[cont][13]="N/A";
					  array[cont][14]="N/A";
					  array[cont][15]="N/A";
					  array[cont][16]="N/A";
					  array[cont][17]="N/A";
					  array[cont][18]="N/A";
				 }else
				 {
					 if(al  instanceof Hematologia)
					 {
						 he = (Hematologia) al;
						 array[cont][9]="N/A";
						 array[cont][10]="N/A";
						 array[cont][11]="N/A";
						 array[cont][12]="N/A";
						 array[cont][13]=he.getQuantG_VER()+"";
						 array[cont][14]=he.getQuantG_BRA()+"";  
						 array[cont][15]=he.getQuantPLA()+"";
						 array[cont][16]=he.getTransport();
						 array[cont][17]="N/A";
						 array[cont][18]="N/A";  
					 }else
					 {
						 if(al  instanceof Microbiologia)
						 {
							 mi = (Microbiologia ) al;
							 array[cont][9]="N/A";
							 array[cont][10]="N/A";
							 array[cont][11]="N/A";
							 array[cont][12]="N/A";  
							 array[cont][13]="N/A";
							 array[cont][14]="N/A";
							 array[cont][15]="N/A";
							 array[cont][16]="N/A";  
							 array[cont][17] = mi.getTipUrina();
							 array[cont][18] = mi.getTipFezes();
						 }
					 }
				 }
				  cont++;
			  }
		  }
		  return array;
	  }  
  public String[][]visualizarInfeccao(Vector vec)
  {
	String[][]inf=new String[Microbiologia.contM][JVisualizacoes.nomes1.length];
	Analise al;Microbiologia mi;int cont=0;
	for(int i=0;i<vec.size();i++)
	{
		al=(Analise)vec.elementAt(i);
		if(al instanceof Microbiologia)
		{
			mi=(Microbiologia)al;
			if(mi.getTipFezes().equalsIgnoreCase("sim")||mi.getTipUrina().equalsIgnoreCase("sim"))
			{
				inf[cont][0]=mi.getNomePac();
				inf[cont][1]=mi.getCodigo()+"";
				inf[cont][2]=mi.getIdade()+"";
				inf[cont][3]=mi.getNumTel()+"";
				cont++;
			}
		}
	}
	return inf;
  }
  public String[][]visualizarColestrol(Vector vec)
  {
	  String[][]col=new String[Bioquimica.contB][JVisualizacoes.nomes.length];int cont=0;
	  Analise al;Bioquimica bi;int quantCol=15;
	  for(int i=0;i<vec.size();i++)
	  {
		  al=(Analise)vec.elementAt(i);
		  if(al instanceof Bioquimica)
		  {
			  bi=(Bioquimica)al;
			  if(bi.getQuantCOL()>quantCol)
			  {
				  //quantCol=bi.getQuantCOL();
				  col[cont][0]=bi.getNomePac();
				  col[cont][1]=bi.getCodigo()+"";
				  col[cont][2]=bi.getIdade()+"";
				  col[cont][3]=peso.format(bi.getQuantCOL());
				  cont++;
			  }
		  }
	  }
	  return col;
  }
  public String[][] visualizarGloVermelho(Vector vec)
  {
	 String[][] ver =new String[1][4];int cont=0;
	 Analise al;Hematologia h; byte quantVer=14;
	 for(int i=0;i<vec.size();i++)
	 {
		 al=(Analise)vec.elementAt(i);
		 if(al instanceof Hematologia)
		 {
			 h=(Hematologia)al;
			 if(h.getQuantG_VER()<quantVer)
			 {
				quantVer=h.getQuantG_VER();
				ver[0][0]=h.getNomePac();
				ver[0][1]=h.getCodigo()+"";
				ver[0][2]=h.getIdade()+"";
				ver[0][3]=h.getQuantG_VER()+"";
				cont++;
			 }
		 }
	 }
	 return ver;
  }
  public String[][]todos(int linha,int coluna,Vector vec)
  {
	  String z[][]=new String[linha][coluna];
	  Analise al;Bioquimica bi;Hematologia he;Microbiologia mi;
	  String sexo="";
	  for(int i=0;i<vec.size();i++)
	  {
		  al=(Analise)vec.elementAt(i);
		  if(al.getGenero()=='f')
			  sexo="Femenino";
		  else
			  sexo="Masculino";
		  z[i][0]=al.getCodigo()+"";
		  z[i][1]=al.getNumBI();
		  z[i][2]=al.getNomePac();
		  z[i][3]=al.getNumTel()+"";
		  z[i][4]=al.getIdade()+"";
		  z[i][5]=sexo;
		  z[i][6]=dt.format(al.getDatAnalise());
		  z[i][7]=mt.format(al.getValorAnalise());
		  z[i][8]=al.getFormPag();
		  if(al instanceof Bioquimica)
		  {
			  bi=(Bioquimica)al;
			  z[i][9]=peso.format(bi.getQuantGLI());
			  z[i][10]=peso.format(bi.getQuantCOL());
			  z[i][11]=mt.format(bi.getValCARD());
			  z[i][12]=mt.format(bi.getValRENAL());
			  z[i][13]="N/A";
			  z[i][14]="N/A";
			  z[i][15]="N/A";
			  z[i][16]="N/A";
			  z[i][17]="N/A";
			  z[i][18]="N/A";
		  }
		  else 
		  {
			  if(al instanceof Hematologia)
			  {
				  he=(Hematologia)al;
				  z[i][9]="N/A";
				  z[i][10]="N/A";
				  z[i][11]="N/A";
				  z[i][12]="N/A";
				  z[i][13]=he.getQuantG_VER()+"";
				  z[i][14]=he.getQuantG_BRA()+"";
				  z[i][15]=med.format(he.getQuantPLA());
				  z[i][16]=he.getTransport();
				  z[i][17]="N/A";
				  z[i][18]="N/A";
			  }
			  else
			  {
				  if(al instanceof Microbiologia)
				  {
					  mi=(Microbiologia)al;
					  z[i][9]="N/A";
					  z[i][10]="N/A";
					  z[i][11]="N/A";
					  z[i][12]="N/A";
					  z[i][13]="N/A";
					  z[i][14]="N/A";
					  z[i][15]="N/A";
					  z[i][16]="N/A";
					  z[i][17]=mi.getTipUrina();
					  z[i][18]=mi.getTipFezes();
				  }
			  }
		  }
	  }
	  return z;
  }
  public String[][]proAnalise(Vector vec,String cod)
  {
	  String[][] a=new String[pAnalise(vec,cod)][JVisualizacoes.AllTab.length];
	  int cont=0;String codigo,sexo;
	  Analise al;Bioquimica bi;Hematologia he;Microbiologia mi;
	  for(int i=0;i<vec.size();i++)
	  {
		  al=(Analise)vec.elementAt(i);
		  codigo = al.getCodigo()+"";
		  if(codigo.startsWith(cod))
		  {
			  if(al.getGenero()=='f')
				  sexo="Femenino";
			  else
				  sexo="Masculino";  
			a[cont][0]=al.getCodigo()+"";
			a[cont][1]=al.getNumBI();
			a[cont][2]=al.getNomePac();
			a[cont][3]=al.getNumTel()+"";
			a[cont][4]=al.getIdade()+"";
			a[cont][5]=sexo;
			a[cont][6]=dt.format(al.getDatAnalise());
			a[cont][7]=mt.format(al.getValorAnalise());
			a[cont][8]=al.getFormPag();
			if(al instanceof Bioquimica)
			{
				  bi=(Bioquimica)al;
				  a[cont][9]=peso.format(bi.getQuantGLI());
				  a[cont][10]=peso.format(bi.getQuantCOL());
				  a[cont][11]=mt.format(bi.getValCARD());
				  a[cont][12]=mt.format(bi.getValRENAL());
				  a[cont][13]="N/A";
				  a[cont][14]="N/A";
				  a[cont][15]="N/A";
				  a[cont][16]="N/A";
				  a[cont][17]="N/A";
				  a[cont][18]="N/A";
			 }
			 else 
			 {
				  if(al instanceof Hematologia)
				  {
					  he=(Hematologia)al;
					  a[cont][9]="N/A";
					  a[cont][10]="N/A";
					  a[cont][11]="N/A";
					  a[cont][12]="N/A";
					  a[cont][13]=he.getQuantG_VER()+"";
					  a[cont][14]=he.getQuantG_BRA()+"";
					  a[cont][15]=med.format(he.getQuantPLA());
					  a[cont][16]=he.getTransport();
					  a[cont][17]="N/A";
					  a[cont][18]="N/A";
				  }
				  else
				  {
					  if(al instanceof Microbiologia)
					  {
						  mi=(Microbiologia)al;
						  a[cont][9]="N/A";
						  a[cont][10]="N/A";
						  a[cont][11]="N/A";
						  a[cont][12]="N/A";
						  a[cont][13]="N/A";
						  a[cont][14]="N/A";
						  a[cont][15]="N/A";
						  a[cont][16]="N/A";
						  a[cont][17]=mi.getTipUrina();
						  a[cont][18]=mi.getTipFezes();
					  }
				  }
			  }
			cont++;
		  }
	  }
	  return a;
  }
  public String[][]VIZAnalise(Vector vec,String cod)
  {
	  String[][] a=new String[pBi(vec,cod)][JVisualizacoes.AllTab.length];
	  int cont=0;String codigo,sexo="";
	  Analise al;Bioquimica bi;Hematologia he;Microbiologia mi;
	  for(int i=0;i<vec.size();i++)
	  {
		  al=(Analise)vec.elementAt(i);
		  codigo = al.getNumBI();
		  if(codigo.startsWith(cod))
		  {
			  if(al.getGenero()=='f')
				  sexo="Femenino";
			  else
				  sexo="Masculino";  
			a[cont][0]=al.getCodigo()+"";
			a[cont][1]=al.getNumBI()+"";
			a[cont][2]=al.getNomePac();
			a[cont][3]=al.getNumTel()+"";
			a[cont][4]=al.getIdade()+"";
			a[cont][5]=sexo;
			a[cont][6]=dt.format(al.getDatAnalise());
			a[cont][7]=mt.format(al.getValorAnalise());
			a[cont][8]=al.getFormPag();
			if(al instanceof Bioquimica)
			{
				  bi=(Bioquimica)al;
				  a[cont][9]=peso.format(bi.getQuantGLI());
				  a[cont][10]=peso.format(bi.getQuantCOL());
				  a[cont][11]=mt.format(bi.getValCARD());
				  a[cont][12]=mt.format(bi.getValRENAL());
				  a[cont][13]="N/A";
				  a[cont][14]="N/A";
				  a[cont][15]="N/A";
				  a[cont][16]="N/A";
				  a[cont][17]="N/A";
				  a[cont][18]="N/A";
			 }
			 else 
			 {
				  if(al instanceof Hematologia)
				  {
					  he=(Hematologia)al;
					  a[cont][9]="N/A";
					  a[cont][10]="N/A";
					  a[cont][11]="N/A";
					  a[cont][12]="N/A";
					  a[cont][13]=he.getQuantG_VER()+"";
					  a[cont][14]=he.getQuantG_BRA()+"";
					  a[cont][15]=med.format(he.getQuantPLA());
					  a[cont][16]=he.getTransport();
					  a[cont][17]="N/A";
					  a[cont][18]="N/A";
				  }
				  else
				  {
					  if(al instanceof Microbiologia)
					  {
						  mi=(Microbiologia)al;
						  a[cont][9]="N/A";
						  a[cont][10]="N/A";
						  a[cont][11]="N/A";
						  a[cont][12]="N/A";
						  a[cont][13]="N/A";
						  a[cont][14]="N/A";
						  a[cont][15]="N/A";
						  a[cont][16]="N/A";
						  a[cont][17]=mi.getTipUrina();
						  a[cont][18]=mi.getTipFezes();
					  }
				  }
			  }
			cont++;
		  }
	  }
	  if(a[0][1]!=null)
		  codi=(a[0][1]);
	  return a;
  }
  public String [][]procurarAnal(Vector vec,int linhas,int colunas)
  {
	  String[][]anal = new String[linhas][colunas];
	  int cont=0;
	  Analise anali;Bioquimica bi;Hematologia he;Microbiologia mi;
	  String sexo="";
	  for(int i=0;i<vec.size();i++)
	  {
		  anali=(Analise)vec.elementAt(i);
		  if(anali.getGenero()=='f')
			  sexo="Femenino";
		  else
			  sexo="Masculino";
		  anal[cont][0]=anali.getCodigo()+"";
		  anal[cont][1]=anali.getNumBI();
		  anal[cont][2]=anali.getNomePac();
		  anal[cont][3]=anali.getNumTel()+"";
		  anal[cont][4]=anali.getIdade()+"";
		  anal[cont][5]=sexo;
		  anal[cont][6]=dt.format(anali.getDatAnalise());
		  anal[cont][7]=mt.format(anali.getValorAnalise());
		  anal[cont][8]=anali.getFormPag();
		  if(anali instanceof Bioquimica)
		  {
			bi=(Bioquimica)anali;
			anal[cont][9]=peso.format(bi.getQuantGLI());
			anal[cont][10]=peso.format(bi.getQuantCOL());
			anal[cont][11]=mt.format(bi.getValCARD());
			anal[cont][12]=mt.format(bi.getValRENAL());
			anal[cont][13]="N/A";
			anal[cont][14]="N/A";
			anal[cont][15]="N/A";
			anal[cont][16]="N/A";
			anal[cont][17]="N/A";
			anal[cont][18]="N/A";
			}
			else 
			{
				  if(anali instanceof Hematologia)
				  {
					  he=(Hematologia)anali;
					  anal[cont][9]="N/A";
					  anal[cont][10]="N/A";
					  anal[cont][11]="N/A";
					  anal[cont][12]="N/A";
					  anal[cont][13]=he.getQuantG_VER()+"";
					  anal[cont][14]=he.getQuantG_BRA()+"";
					  anal[cont][15]=med.format(he.getQuantPLA());
					  anal[cont][16]=he.getTransport();
					  anal[cont][17]="N/A";
					  anal[cont][18]="N/A";
				  }
				  else
				  {
					  if(anali instanceof Microbiologia)
					  {
						  mi=(Microbiologia)anali;
						  anal[cont][9]="N/A";
						  anal[cont][10]="N/A";
						  anal[cont][11]="N/A";
						  anal[cont][12]="N/A";
						  anal[cont][13]="N/A";
						  anal[cont][14]="N/A";
						  anal[cont][15]="N/A";
						  anal[cont][16]="N/A";
						  anal[cont][17]=mi.getTipUrina();
						  anal[cont][18]=mi.getTipFezes();
					  }
				  }
			  }
		  cont++;
		  
	  }
	  return anal;
  }
  public String [][]vizualizarAnalise(Vector vec,int linha,int coluna)
  {
	  Analise al;int cont=0;String sexo="";Bioquimica bi;Hematologia he;Microbiologia mi;
	  String [][]a=new String[linha][coluna];
	  for(int k=0;k<vec.size();k++)
	  {
		  al=(Analise)vec.elementAt(k);
			  if(al.getGenero()=='f')
				  sexo="Femenino";
			  else
				  sexo="Masculino";
			    a[cont][0]=al.getCodigo()+"";
				a[cont][1]=al.getNumBI()+"";
				a[cont][2]=al.getNomePac();
				a[cont][3]=al.getNumTel()+"";
				a[cont][4]=al.getIdade()+"";
				a[cont][5]=sexo;
				a[cont][6]=dt.format(al.getDatAnalise());
				a[cont][7]=mt.format(al.getValorAnalise());
				a[cont][8]=al.getFormPag();
				if(al instanceof Bioquimica)
				{
					  bi=(Bioquimica)al;
					  a[cont][9]=peso.format(bi.getQuantGLI());
					  a[cont][10]=peso.format(bi.getQuantCOL());
					  a[cont][11]=mt.format(bi.getValCARD());
					  a[cont][12]=mt.format(bi.getValRENAL());
					  a[cont][13]="N/A";
					  a[cont][14]="N/A";
					  a[cont][15]="N/A";
					  a[cont][16]="N/A";
					  a[cont][17]="N/A";
					  a[cont][18]="N/A";
				 }
				 else 
				 {
					  if(al instanceof Hematologia)
					  {
						  he=(Hematologia)al;
						  a[cont][9]="N/A";
						  a[cont][10]="N/A";
						  a[cont][11]="N/A";
						  a[cont][12]="N/A";
						  a[cont][13]=he.getQuantG_VER()+"";
						  a[cont][14]=he.getQuantG_BRA()+"";
						  a[cont][15]=med.format(he.getQuantPLA());
						  a[cont][16]=he.getTransport();
						  a[cont][17]="N/A";
						  a[cont][18]="N/A";
					  }
					  else
					  {
						  if(al instanceof Microbiologia)
						  {
							  mi=(Microbiologia)al;
							  a[cont][9]="N/A";
							  a[cont][10]="N/A";
							  a[cont][11]="N/A";
							  a[cont][12]="N/A";
							  a[cont][13]="N/A";
							  a[cont][14]="N/A";
							  a[cont][15]="N/A";
							  a[cont][16]="N/A";
							  a[cont][17]=mi.getTipUrina();
							  a[cont][18]=mi.getTipFezes();
						  }
					  }
				  }
			  cont++;
	  }
	  return a;
  }		  
  public String [][]vizualizarMicrobiologia(Vector vec,int linha,int coluna)
  {
	  Analise al;Microbiologia mi;int cont=0;String sexo="";
	  String [][]array=new String[linha][coluna];
	  for(int k=0;k<vec.size();k++)
	  {
		  al=(Analise)vec.elementAt(k);
		  if(al instanceof Microbiologia)
		  {
			  mi=(Microbiologia)al;
			  if(mi.getGenero()=='f')
				  sexo="Femenino";
			  else
				  sexo="Masculino";
			  
			  array[cont][0]=mi.getCodigo()+"";
			  array[cont][1]=mi.getNumBI();
			  array[cont][2]=mi.getNomePac();
			  array[cont][3]=mi.getNumTel()+"";
			  array[cont][4]=mi.getIdade()+"";
			  array[cont][5]=sexo;
			  array[cont][6]=dt.format(mi.getDatAnalise());
			  array[cont][7]=mt.format(mi.getValorAnalise());
			  array[cont][8]=mi.getFormPag();
			  array[cont][9]=mi.getTipUrina();
			  array[cont][10]=mi.getTipFezes();
			  cont++;
		  }
	  }
	  return array;
  }
  public String[][] vizualizarHematologia(Vector vec,int linha,int coluna)
  {
	  Analise al;Hematologia he;int cont=0;String sexo="";
	  String [][]array=new String[linha][coluna];
	  for(int i=0;i<vec.size();i++)
	  {
		  al=(Analise)vec.elementAt(i);
		  if(al instanceof Hematologia)
		  {
			  he=(Hematologia)al;
			  if(he.getGenero()=='f')
				  sexo="Femenino";
			  else
				  sexo="Masculino";
			  array[cont][0]=he.getCodigo()+"";
			  array[cont][1]=he.getNumBI();
			  array[cont][2]=he.getNomePac();
			  array[cont][3]=he.getNumTel()+"";
			  array[cont][4]=he.getIdade()+"";
			  array[cont][5]=sexo;
			  array[cont][6]=dt.format(he.getDatAnalise());
			  array[cont][7]=mt.format(he.getValorAnalise());
			  array[cont][8]=he.getFormPag();
			  array[cont][9]=he.getQuantG_VER()+"";
			  array[cont][10]=he.getQuantG_BRA()+"";
			  array[cont][11]=med.format(he.getQuantPLA());
			  array[cont][12]=he.getTransport();
			  cont++;
		  }
	  }
	  return array;
  }
  public String[][]vizualizarBioquimica(Vector vec,int linha,int coluna)
  {
	  Analise al;Bioquimica bi;int cont=0;String sexo="";
	  String [][]array=new String[linha][coluna];
	  for(int j=0;j<vec.size();j++)
	  {
		  al=(Analise)vec.elementAt(j);
		  if(al instanceof Bioquimica)
		  {
			  bi=(Bioquimica)al;
			  if(bi.getGenero()=='f')
				  sexo="Femenino";
			  else
				  sexo="Masculino";
			  
			  array[cont][0]=bi.getCodigo()+"";
			  array[cont][1]=bi.getNumBI();
			  array[cont][2]=bi.getNomePac();
			  array[cont][3]=bi.getNumTel()+"";
			  array[cont][4]=bi.getIdade()+"";
			  array[cont][5]=sexo;
			  array[cont][6]=dt.format(bi.getDatAnalise());
			  array[cont][7]=mt.format(bi.getValorAnalise());
			  array[cont][8]=bi.getFormPag();
			  array[cont][9]=peso.format(bi.getQuantGLI());
			  array[cont][10]=peso.format(bi.getQuantCOL());
			  array[cont][11]=mt.format(bi.getValCARD());
			  array[cont][12]=mt.format(bi.getValRENAL());
			  cont++;
		  }
	  }
	return array;  
  }
  public int pBi(Vector vec,String cod1)
  {
	  int cont=1;String cod="";
	  Analise al;
	  for(int i=0;i<vec.size();i++)
	  {
		  al=(Analise)vec.elementAt(i);
		  cod=al.getNumBI();
		  if(cod.startsWith(cod1))
			  cont++;
	  }
	  return cont;
  }
    
  public int pAnalise(Vector vec,String cod1)
  {
	  int cont=1;String cod="";
	  Analise al;
	  for(int i=0;i<vec.size();i++)
	  {
		  al=(Analise)vec.elementAt(i);
		  cod=al.getCodigo()+"";
		  if(cod.startsWith(cod1))
			  cont++;
	  }
	  return cont;
  }
 
}
