import java.util.*;

import javax.swing.JOptionPane;
public class OrdenarPorData 
{
  public OrdenarPorData() {}
	
  public void ordenarAnalise(Vector vec,boolean criterio)
  {
	 Analise aux1, aux2, aux;
	 int i_maior, numInd = vec.size();
	 for(int i =0; i<numInd-1; i++)
	 {
	   i_maior = localizarMaior(vec,i,criterio);
	   aux1 = (Analise) vec.elementAt(i);
       aux2 = (Analise) vec.elementAt(i_maior);
       vec.setElementAt(aux2, i);
	   vec.setElementAt(aux1,i_maior);
	 }
	 if(criterio==true)   
	        JOptionPane.showMessageDialog(null,"Ordenacao em ordem decrescente \nEfectuada com Sucesso");	
	       else
	        JOptionPane.showMessageDialog(null,"Ordenacao  em Ordem crescente \nEfectuada com Sucesso");
	} 
   public int localizarMaior(Vector vec, int inicio,boolean criterio)
   {
		int i_max = inicio;
		Analise ind1, ind2;
		for(int k = inicio + 1; k<vec.size(); k++)
		{
			ind1 = (Analise) vec.elementAt(k);
			ind2 = (Analise)vec.elementAt(i_max);
			if(ind1.getDatAnalise().compareTo(ind2.getDatAnalise())>0&& criterio==true)
				i_max = k;
			if(ind1.getDatAnalise().compareTo(ind2.getDatAnalise())<0&& criterio==false)
				i_max = k;
		}
		return i_max;
	}
}
