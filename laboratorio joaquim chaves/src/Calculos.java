import java.io.*;
import java.util.*;
public class Calculos 
{
	public Calculos() {	
	}
	public float ValorTotalComIva(Vector vec)
	{
		float vt=0;
		Hematologia he;Analise al;Bioquimica bi;Microbiologia mi;
		for(int i=0;i<vec.size();i++)
		{
			al=(Analise)vec.elementAt(i);
			if(al instanceof Hematologia)
			{
				he=(Hematologia)al;
				vt+=he.valorPagar();
			}
			else
			{
				if(al instanceof Bioquimica)
				{
					bi=(Bioquimica)al;
					vt+=bi.valorPagar();
				}
				else {
					if(al instanceof Microbiologia)
					{
						mi=(Microbiologia)al;
						vt+=mi.valorPagar();
					}
				}
			}
		}
		return vt;
	}
	public float ValorTotalSeguros(Vector vec)
	{
		float vt=0;
		Analise al;Bioquimica bi;Microbiologia mi;Hematologia he;
		for(int i=0;i<vec.size();i++)
		{
			al=(Analise)vec.elementAt(i);
			if(al.getFormPag().equalsIgnoreCase("seguro"))
			{
				if(al instanceof Bioquimica)
				{
					bi=(Bioquimica)al;
					vt+=bi.valorPagar();
				}
				else
				{
					if(al instanceof Hematologia)
					{
						he=(Hematologia)al;
						vt+=he.valorPagar();
					}
					else
					{
						if(al instanceof Microbiologia)
						{
							mi=(Microbiologia)al;
							vt+=mi.valorPagar();
						}
					}
				}
			}
		}
		return vt;
	}
	public int objecto(Vector vec)
	{
		Analise al;int ob=0;
		for(int i=0;i<vec.size();i++)
		{
			al=(Analise)vec.elementAt(i);
			if(al.getNumBI().equals(Visualizacoes.codi))
			{
				ob=i;
			}
		}
		return ob;
	}
	public int tamanho()
	{int cont=0;
	String linha="";
		try {
			BufferedReader b= new BufferedReader(new FileReader("User.txt"));
			linha=b.readLine();
			while(linha!=null)
			{
				cont++;
				linha=b.readLine();
			}
			b.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}	
		return cont;
	}
}
