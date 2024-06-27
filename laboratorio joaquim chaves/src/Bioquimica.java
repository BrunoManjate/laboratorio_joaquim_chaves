import java.util.Date;
final class Bioquimica extends Analise implements AnaliseInterface
{
  private int quantGLI,quantCOL;
  private float valCARD,valRENAL;
  public static int contB;
  public Bioquimica(int codigo,String numBI,String nomePac,long numTel,byte idade,char genero,Date datAnalise,
		  float valorAnalise,String formPag,int quantGLI,int quantCOL,float valCARD,float valRENAL)
  {
	  super(codigo,numBI,nomePac,numTel,idade,genero,datAnalise,valorAnalise,formPag);
	  this.quantGLI = quantGLI;
	  this.quantCOL = quantCOL;
	  contB++;
	  this.valCARD = valCARD;
	  this.valRENAL = valRENAL;
  }
  public Bioquimica() {this(0,"","",(long)0,(byte)0,' ',new Date(),0.0f,"",0,0,0.0f,0.0f);}
  public int getQuantGLI() {return quantGLI;}
  public int getQuantCOL() {return quantCOL;}
  public float getValCARD() {return valCARD;}
  public float getValRENAL() {return valRENAL;}
  public void setQuantGLI(int quantGLI) {this.quantGLI = quantGLI;}
  public void setQuantCOL(int quantCOL) {this.quantCOL = quantCOL;}
  public void setValCARD(float valCARD) {this.valCARD = valCARD;}
  public void setValRENAL(float valRENAL) {this.valRENAL = valRENAL;}
  public float iva()
  {
	  return valorAnalise+valCARD+valRENAL*IVA;
  }
  public float desconto()
  {
	  return 0;
  }
  public float valorPagar()
  {
	  return iva()-desconto();
  }
}
