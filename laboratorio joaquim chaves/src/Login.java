
import java.util.Date;

public class Login extends Analise
{
	private String nomeAd,codAd;
	private long contactoAd;
	public Login(String nomeAd,String codAd,long contactoAd)
	{
		this.nomeAd = nomeAd;
		this.codAd = codAd;
		this.contactoAd = contactoAd;
	}
	public Login()
	{this("","",0);}
	public String getNome() {
		return nomeAd;
	}
	public String getCod() {
		return codAd;
	}
	public void setNome(String nomeAd) {
		this.nomeAd = nomeAd;
	}
	public void setCod(String codAd) {
		this.codAd = codAd;
	}
	public long getContactoAd() {
		return contactoAd;
	}
	public void setContactoAd(long contactoAd) {
		this.contactoAd = contactoAd;
	}
}
