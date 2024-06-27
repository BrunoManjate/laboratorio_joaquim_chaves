import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Jogo_XO extends JFrame 
{
  private JLabel jog1,jog2,jog,imagem;
  private JTextField tjog1,tjog2;
  private JRadioButton rx,rb;
  private ButtonGroup bG;
  private JPanel pa,pe,pi;
  private JButton bSair,bJogar;
  private Container cont;
  private Jmenu menu;
  public  Jogo_XO(Jmenu m)
  {
	  super("JOGO XO");
	  cont = getContentPane();
	  menu = m;
	  aparencia();
	  Font c = new Font("Serif",Font.BOLD,20);	  
	  pa = new JPanel(new GridLayout(4,2));
	  pa.setBorder(BorderFactory.createTitledBorder("Jogo XO"));
	  
	  jog1 = new JLabel("Nome Jogador 1 : ");
	  jog1.setFont(c);
	  pa.add(jog1);
	  tjog1 = new JTextField(15);
	  tjog1.setForeground(Color.blue);
	  tjog1.setFont(c);
	  pa.add(tjog1);
	  
	  jog2 = new JLabel("Nome Jogador 2 : ");
	  jog2.setFont(c);
	  pa.add(jog2);
	  tjog2 = new JTextField(15);
	  tjog2.setFont(c);
	  tjog2.setForeground(Color.green);
	  pa.add(tjog2);
	  
	  jog = new JLabel("Escolhe Jogador 1 : ");
	  jog.setFont(c);
	  pa.add(jog);
	  
	  pe = new JPanel();
	  rx = new JRadioButton("X",true);
	  rx.setFont(c);
	  pe.add(rx);
	  rb = new JRadioButton("O",false);		  
	  rb.setFont(c);
	  pe.add(rb);
	  
	  bG = new ButtonGroup();
	  bG.add(rx);
	  bG.add(rb);
	  pa.add(pe);
	  
	  Tratar trat = new Tratar();
	  bJogar = new JButton("Jogar");
	  bJogar.addActionListener(trat);
	  pa.add(bJogar);
	  
	  bSair = new JButton("Voltar");
	  bSair.addActionListener(trat);
	  pa.add(bSair);
	  
	  imagem = new JLabel();
	  imagem.setIcon(new ImageIcon("XO.jpg"));
	  
	  pi = new JPanel(new BorderLayout());
	  pi.add(imagem, BorderLayout.NORTH);
	  pi.add(pa, BorderLayout.SOUTH);
	  cont.add(pi);

	  setSize(552,679);
	  setLocationRelativeTo(null);
	  setResizable(false);
	  setUndecorated(true);
	  setVisible(true);
  }
  private class Tratar implements ActionListener
  {
	  public void actionPerformed(ActionEvent ev)
	  {
		  if(ev.getSource()==bJogar)
		  {
			 String resposta = "";
			 if(!tjog1.getText().isEmpty() && !tjog2.getText().isEmpty())
			 {
				 if(rx.isSelected())
					 resposta ="X";
				 if(rb.isSelected())
					 resposta ="O";
				dispose();
				 new Tabuleiro(tjog1.getText(),tjog2.getText(),resposta,menu,gerir());
				 tjog1.setText(""); 
				 tjog2.setText("");
			 }else
			 {
				 JOptionPane.showMessageDialog(null, "Preencha Os Campos","Erro Campos",JOptionPane.ERROR_MESSAGE);
			 }
			  
		  }else
			  if(ev.getSource()==bSair)
			  {
				  dispose();
				  menu.setVisible(true);
			  }
	  }
  }
  
  public Jogo_XO gerir()
  {
	  return this;
  }
  
  public void aparencia()
 {
		try 
		{
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
			{
				if ("Nimbus".equals(info.getName())) 
				{
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
  }
}