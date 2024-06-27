import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
public class Analise implements Serializable
{
	protected int codigo;
	protected String numBI,nomePaci;
	protected long numTel;
	protected byte idade;
	protected char genero;
	protected Date datAnalise;
	protected float valorAnalise;
	protected String formPag;
	protected SimpleDateFormat dat;
	protected DecimalFormat df;
	public static int contA;
	public Analise(int codigo,String numBI,String nomePaci,long numTel,byte idade,char genero,Date datAnalise,float valorAnalise,String formPag)
	{
		this.codigo = codigo;
		this.numBI = numBI;
		this.nomePaci = nomePaci;
		this.numTel = numTel;
		this.idade = idade;
		this.genero = genero;
		this.datAnalise = datAnalise;
		this.valorAnalise = valorAnalise;
		this.formPag = formPag;
		dat = new SimpleDateFormat("dd/MM/yyyy");
		df = new DecimalFormat("###,###.00Mts");
		contA++;
	}
	public Analise() {this(0,"","",0,(byte)0,' ',new Date(),0.0f,"");}
	public int getCodigo() {return codigo;}
	public String getNumBI() {return numBI;}
	public String getNomePac() {return nomePaci;}
	public long getNumTel() {return numTel;}
	public byte getIdade() {return idade;}
	public char getGenero() {return genero;}
	public Date getDatAnalise() {return datAnalise;}
	public float getValorAnalise() {return valorAnalise;}
	public String getFormPag() {return formPag;}
	public void setCodigo(int codigo) {this.codigo = codigo;}
	public void setNumBI(String numBI) {this.numBI = numBI;}
	public void setNomePac(String nomePac) {this.nomePaci = nomePac;}
	public void setNumTel(long numTel) {this.numTel = numTel;}
	public void setIdade(byte idade) {this.idade = idade;}
	public void setGenero(char genero) {this.genero = genero;}
	public void setDatAnalise(Date datAnalise) {this.datAnalise = datAnalise;}
	public void setValorAnalise(float valorAnalise) {this.valorAnalise = valorAnalise;}
	public void setFormPag(String formPag) {this.formPag = formPag;}
	@Override
	public String toString() {
		return "Analise [codigo=" + codigo + ", numBI=" + numBI + ", nomePac=" + nomePaci + ", numTel=" + numTel
				+ ", idade=" + idade + ", genero=" + genero + ", datAnalise=" + dat.format(datAnalise) + ", valorAnalise="
				+ df.format(valorAnalise)+ ", formPag=" + formPag ;
	}
	
	
}
