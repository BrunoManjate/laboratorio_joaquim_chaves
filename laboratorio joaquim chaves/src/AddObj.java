import java.util.*;
public class AddObj 
{
  public AddObj()
  {}
  public void addBioquimica(int codigo,String numBI,String nomePac,long numTel,byte idade,char genero,Date datAnalise,
		  float valorAnalise,String formPag,int quantGLI,int quantCOL,float valCARD,float valRENAL,Vector vec)
  {
	 Bioquimica bio = new Bioquimica();
	 bio.setCodigo(codigo);
	 bio.setNumBI(numBI);
	 bio.setNomePac(nomePac);
	 bio.setNumTel(numTel);
	 bio.setIdade(idade);
	 bio.setGenero(genero);
	 bio.setDatAnalise(datAnalise);
	 bio.setValorAnalise(valorAnalise);
	 bio.setFormPag(formPag);
	 bio.setQuantGLI(quantGLI);
	 bio.setQuantCOL(quantCOL);
	 bio.setValCARD(valCARD);
	 bio.setValRENAL(valRENAL);
	 vec.addElement(bio);
	 vec.trimToSize();
  }
  public void addHematologia(int codigo,String numBI,String nomePac,long numTel,byte idade,char genero,Date datAnalise,
		  float valorAnalise,String formPag,byte quantG_VER,int quantG_BRA,float quantPLA,String transport,Vector vec)
  {
	  Hematologia he = new Hematologia();
	  he.setCodigo(codigo);
	  he.setNumBI(numBI);
      he.setNomePac(nomePac);
	  he.setNumTel(numTel);
	  he.setIdade(idade);
	  he.setGenero(genero);
	  he.setDatAnalise(datAnalise);
	  he.setValorAnalise(valorAnalise);
	  he.setFormPag(formPag);
	  he.setQuantG_VER(quantG_VER);
	  he.setQuantG_BRA(quantG_BRA);
	  he.setQuantPLA(quantPLA);
	  he.setTransport(transport);
	  vec.addElement(he);
	  vec.trimToSize();
  }
  public void addMicrobiologia(int codigo,String numBI,String nomePac,long numTel,byte idade,char genero
			,Date datAnalise,float valorAnalise,String formPag,String tipUrina,String tipFezes,Vector vec)
  {
	  Microbiologia mi = new Microbiologia();
	  mi.setCodigo(codigo);
	  mi.setNumBI(numBI);
      mi.setNomePac(nomePac);
	  mi.setNumTel(numTel);
	  mi.setIdade(idade);
	  mi.setGenero(genero);
	  mi.setDatAnalise(datAnalise);
	  mi.setValorAnalise(valorAnalise);
	  mi.setFormPag(formPag);
	  mi.setTipUrina(tipUrina);
	  mi.setTipFezes(tipFezes);
	  vec.addElement(mi);
	  vec.trimToSize();
  }
}
