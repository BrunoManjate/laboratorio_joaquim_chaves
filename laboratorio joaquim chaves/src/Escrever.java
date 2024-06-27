import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.JOptionPane;
public class Escrever
{
 	
  public Escrever() {
	  
  }
  public void escFichObj(Vector vec)
  {
	  try
	  {
		  FileOutputStream f = new FileOutputStream("FichObj.dat");
		  ObjectOutputStream b = new ObjectOutputStream(f);
		  b.writeObject(vec);
	  }
	  catch(FileNotFoundException f) {f.printStackTrace();}
	  catch(IOException i) {i.printStackTrace();}
	  System.out.println("Ficheiro escrito com sucesso!!!");
  }
  public void gravarSituacaoEmpresa(Vector vec,float valor)
  {
	  try 
	  {
		FileWriter r = new FileWriter("DadosEmpresa.txt");
		BufferedWriter fr = new BufferedWriter(r);
		if(valor>100000)
			fr.write("O Laboratorio tem um Lucro de: "+valor+"Mt");
		else
			if(valor<100000)
				fr.write("O Laboratorio tem um prejuizo de: "+valor+"Mt");
		
		fr.newLine();
		fr.close();
      } catch (Exception e) {e.printStackTrace();}
  }
  public void gravarUser(String nome,String senha,long tele)
  {
	  try 
	  {
		  FileWriter fw = new FileWriter("User.txt",true);
		  BufferedWriter bw = new BufferedWriter(fw);
		  bw.newLine();
		  bw.write(nome+";"+senha+";"+tele);
		  bw.close();
		  //JOptionPane.showMessageDialog(null,"Utilizador adicionado ao ficheiro de texto com sucesso");
	  }
	  catch(IOException i){JOptionPane.showMessageDialog(null,"Erro! na gravacao de ficheiro do Users.txt");}
  }
}
