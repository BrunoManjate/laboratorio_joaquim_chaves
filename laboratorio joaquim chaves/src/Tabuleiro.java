import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Tabuleiro extends JFrame 
{
	private Container cont; 
	private GridLayout g1;
	private JButton butoes[];
	private boolean toque[] = new boolean [9], op=true;
	private String jog1, jog2,resp;
	private Jmenu menu;
    private Jogo_XO xo;
	public Tabuleiro(String a, String b,String respo,Jmenu m, Jogo_XO xo)
    {	
        super("TUBULEIRO");
        this.jog1=a;
    	this.jog2=b;
        this.resp = respo;
    	menu = m;
        this.xo = xo;
    	
        cont = getContentPane();
        cont.setLayout(new GridLayout(3,3,10,10));
  	    cont.setBackground(Color.black);
  	    
  	    butoes = new JButton[9];
  	    for(byte c =0; c<9;c++)
  	    {
  		    butoes[c] = new JButton();
  		    toque[c] = false;
  		    cont.add(butoes[c]);
  	    }
  	   
  	     butoes[0].addActionListener(new ActionListener()
  	     {
  		    public void actionPerformed(ActionEvent ev)
  		    {
  			     if(toque[0]==false)
  			     {
  				    toque[0] =true;
  				    trocar(butoes[0]);
  			     }     
  		      }
  	        });
    
        	butoes[1].addActionListener(new ActionListener()
	       {
		       public void actionPerformed(ActionEvent ev)
		      {
			     if(toque[1]==false)
			     {
				     toque[1] =true;
				     trocar(butoes[1]);
			     }    
		      }
	        });
	
	        butoes[2].addActionListener(new ActionListener()
           {
		      public void actionPerformed(ActionEvent ev)
		      {
			     if(toque[2]==false)
			     {
				     toque[2] =true;
				     trocar(butoes[2]);
			      }    
		      }
	       });
	 
	      butoes[3].addActionListener(new ActionListener()
	      {
		     public void actionPerformed(ActionEvent ev)
		     {
			     if(toque[3]==false)
			     {
				     toque[3] =true;
				     trocar(butoes[3]);
			     }    
		     }
       	  });
 
	     butoes[4].addActionListener(new ActionListener()
	     {
	    	 public void actionPerformed(ActionEvent ev)
	    	 {
	    		 if(toque[4]==false)
	    		 {
	    			 toque[4] =true;
	    			 trocar(butoes[4]);
	    		 }    
	    	 }
	     });
    
	     butoes[5].addActionListener(new ActionListener()
	     {
	    	 public void actionPerformed(ActionEvent ev)
	    	 {
	    		 if(toque[5]==false)
	    		 {
	    			 toque[5] =true;
	    			 trocar(butoes[5]);
	    		 }    
	    	 }
	     });
		 
	     butoes[6].addActionListener(new ActionListener()
		 {
	    	 public void actionPerformed(ActionEvent ev)
	    	 {
	    		 if(toque[6]==false)
	    		 {
	    			 toque[6] =true;
	    			 trocar(butoes[6]);
	    		 }    
	    	 }
		 });
	 
	     butoes[7].addActionListener(new ActionListener()
		 {
	    	 public void actionPerformed(ActionEvent ev)
	    	 {
	    		 if(toque[7]==false)
	    		 {
	    			 toque[7] =true;
	    			 trocar(butoes[7]);
	    		 }    
	    	 }
		 });
       
		 butoes[8].addActionListener(new ActionListener()
	     {
			 public void actionPerformed(ActionEvent ev)
			 {
				 if(toque[8]==false)
				 {
					 toque[8] =true;
					 trocar(butoes[8]);
				 }    
			 }
	     });
		
		 addWindowListener(
					new WindowAdapter() {
						public void windowClosing(WindowEvent a) {
							dispose();
							xo.setVisible(true);
						}
					});
	
		  setSize(1000,1000);
  	      setLocationRelativeTo(null);
	      setResizable(false);
	      //setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	      setVisible(true);
    }
    
    	public void trocar(JButton butao)
    	{     
    		String b="";
    		if(resp.equals("X"))
	    		 b="O";
	    	 else
	    		 b="X";     
    		if(op)
    		     {
    		    	 butao.setText(resp);
    		    	 butao.setFont(new Font("Times new roman",Font.BOLD,200));
    		    	 op = false;
    		    	 cont.setBackground(Color.blue);
    		     }else
    		     {
    		    	 butao.setText(b);
    		    	 butao.setFont(new Font("Times new roman",Font.BOLD,200));
    		    	 op = true;
    		    	 cont.setBackground(Color.green);
    		     }
    			 ganhou();
		 }
    	
    	public void limpar()
    	{
    		for(byte c =0; c<9;c++)
    		{
    			butoes[c].setText("");
    			toque[c]=false;
    		}
    	}
    	
    	public void ganhou()
    	{
    		int q = 0;
    		for(byte c =0; c<9;c++)
    		{
    			if(toque[c]==true)
    				q++;
    		}
    		
    		if(butoes[0].getText().equals("X") && butoes[1].getText().equals("X") && butoes[2].getText().equals("X")
    				|| butoes[3].getText().equals("X")  && butoes[4].getText().equals("X") && butoes[5].getText().equals("X") 
    				|| butoes[6].getText().equals("X") && butoes[7].getText().equals("X") && butoes[8].getText().equals("X") 
    				|| butoes[0].getText().equals("X") && butoes[3].getText().equals("X") && butoes[6].getText().equals("X") 
    				|| butoes[1].getText().equals("X") && butoes[4].getText().equals("X") && butoes[7].getText().equals("X") 
    				|| butoes[2].getText().equals("X") && butoes[5].getText().equals("X") && butoes[8].getText().equals("X")
    				|| butoes[0].getText().equals("X") && butoes[4].getText().equals("X") && butoes[8].getText().equals("X") 
    				|| butoes[6].getText().equals("X") && butoes[4].getText().equals("X") && butoes[2].getText().equals("X"))
    		{
    			    int resposta = JOptionPane.showConfirmDialog(null,jog1+" Ganhou\nDeseja Continuar ?", "Resultado", JOptionPane.YES_NO_OPTION);
    		        if(resposta==0)
 				   {
 				      limpar();
 				   }else
 				   {
 					   dispose();
 					   new Jogo_XO(menu);
 				   }
    		}else
    		{
    			if(butoes[0].getText().equals("O") && butoes[1].getText().equals("O") && butoes[2].getText().equals("O")
        				|| butoes[3].getText().equals("O")  && butoes[4].getText().equals("O") && butoes[5].getText().equals("O") 
        				|| butoes[6].getText().equals("O") && butoes[7].getText().equals("O") && butoes[8].getText().equals("O") 
        				|| butoes[0].getText().equals("O") && butoes[3].getText().equals("O") && butoes[6].getText().equals("O") 
        				|| butoes[1].getText().equals("O") && butoes[4].getText().equals("O") && butoes[7].getText().equals("O") 
        				|| butoes[2].getText().equals("O") && butoes[5].getText().equals("O") && butoes[8].getText().equals("O")
        				|| butoes[0].getText().equals("O") && butoes[4].getText().equals("O") && butoes[8].getText().equals("O") 
        				|| butoes[6].getText().equals("O") && butoes[4].getText().equals("O") && butoes[2].getText().equals("O"))
    			{
    				   int resposta = JOptionPane.showConfirmDialog(null,jog2+" \nGanhou Deseja Continuar ?", "Resultado", JOptionPane.YES_NO_OPTION);
    				   if(resposta==0)
    				   {
    				      limpar();
    				   }else
    				   {
    					   dispose();
    					   new Jogo_XO(menu);
    				   }   
    			}else
    			{
    				if(q==9)
    	    		{
    					int resposta = JOptionPane.showConfirmDialog(null,"Empate \nDeseja Continuar ?", "Resultado", JOptionPane.YES_NO_OPTION);
    	    			if(resposta==0)
     				   {	
     				      limpar();
     				     cont.setBackground(Color.black);
     				   }else
     				   {
     					   dispose();
     					   new Jogo_XO(menu);
     				   }
    	    		}
    			} 
    		}
	  	}
}
