import java.util.Date;
final class Microbiologia extends Analise implements AnaliseInterface
{
	private String tipUrina,tipFezes;
	public static int contM;
	public Microbiologia(int codigo,String numBI,String nomePac,long numTel,byte idade,char genero
			,Date datAnalise,float valorAnalise,String formPag,String tipUrina,String tipFezes)
	{
		super(codigo,numBI,nomePac,numTel,idade,genero,datAnalise,valorAnalise,formPag);
		this.tipUrina = tipUrina;
		this.tipFezes = tipFezes;
		contM++;
	}
	public Microbiologia() {this(0,"","",0,(byte)0,' ',new Date(),0.0f,"","","");}
	public String getTipUrina() {return tipUrina;}
	public String getTipFezes() {return tipFezes;}
	public void setTipUrina(String tipUrina) {
		this.tipUrina = tipUrina;
	}
	public void setTipFezes(String tipFezes) {
		this.tipFezes = tipFezes;
	}
	public float iva()
	{
		return valorAnalise+valorAnalise*IVA;
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
