import java.util.Date;

final class Hematologia extends Analise implements AnaliseInterface
{
  private byte quantG_VER;
  private int quantG_BRA;
  private float quantPLA;
  private String transport;
  private final int EXTRA=500;
  public static int contH;
  public Hematologia(int codigo,String numBI,String nomePac,long numTel,byte idade,char genero,Date datAnalise,
		  float valorAnalise,String formPag,byte quantG_VER,int quantG_BRA,float quantPLA,String transport)
  {
	  super(codigo,numBI,nomePac,numTel,idade,genero,datAnalise,valorAnalise,formPag);
	  this.quantG_VER = quantG_VER;
	  this.quantG_BRA = quantG_BRA;
	  this.quantPLA = quantPLA;
	  this.transport = transport;
	  contH++;
  }
  public Hematologia() {this(0,"","",0,(byte)0,' ',new Date(),0.0f,"",(byte)0,0,0.0f,"");}
  public byte getQuantG_VER() {return quantG_VER;}
  public String getTransport() {return transport;}
  public int getQuantG_BRA() {return quantG_BRA;}
  public float getQuantPLA() {return quantPLA;}
  public void setTransport(String transport) {this.transport = transport;}
  public void setQuantG_VER(byte quantG_VER) {
	  if(quantG_VER>=1||quantG_VER<=16)
		  this.quantG_VER = quantG_VER;
  }
  public float iva()
  {
	  return valorAnalise-valorAnalise*IVA;
  }
  public float desconto()
  {
	 
	if(transport.equalsIgnoreCase("sim")&&idade>50)
	   return valorAnalise*DESC;
	else
		return valorAnalise;
  }
  public float valorPagar()
  {
	  return iva()-desconto()+EXTRA;
  }
  public void setQuantG_BRA(int quantG_BRA) {
	this.quantG_BRA = quantG_BRA;
  }
  public void setQuantPLA(float quantPLA) {
	this.quantPLA = quantPLA;
  }
}
