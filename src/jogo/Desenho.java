package jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Desenho extends JPanel
{
	  public static int[][] comida = new int[17][17];
	  private int prox_comida;
	  private int under_comida;
	  private Image imgPacman;
	  private Image imgPacman2;
	  private Image imgPacman3;
	  private Image imgPacman4;
	  private Image imgPacman5;
	  private Image imgFantasma;
	  private Image imgFantasma2;
	  private Image imgFantasma3;
	  private Image imgFantasma4;
	  public static int xpacman;
	  public static int ypacman;
	  public static int xfantasma;
	  public static int yfantasma;
	  public static int xfantasma2;
	  public static int yfantasma2;
	  public static int xfantasma3;
	  public static int yfantasma3;
	  public static int xfantasma4;
	  public static int yfantasma4;
	  public static int nivel;
	  private boolean trocarImagem = true;
	  
	  public Desenho()
	  {
	    pintarTela();
	    lugarInicial();
	    ImageIcon pacman = new ImageIcon(getClass().getResource("/imagens/come.png"));
	    this.imgPacman = pacman.getImage();
	    ImageIcon pacman2 = new ImageIcon(getClass().getResource("/imagens/come2.png"));
	    this.imgPacman2 = pacman2.getImage();
	    ImageIcon pacman3 = new ImageIcon(getClass().getResource("/imagens/come3.png"));
	    this.imgPacman3 = pacman3.getImage();
	    ImageIcon pacman4 = new ImageIcon(getClass().getResource("/imagens/come4.png"));
	    this.imgPacman4 = pacman4.getImage();
	    ImageIcon pacman5 = new ImageIcon(getClass().getResource("/imagens/come5.png"));
	    this.imgPacman5 = pacman5.getImage();
	    ImageIcon fantasma = new ImageIcon(getClass().getResource("/imagens/fantasma.png"));
	    this.imgFantasma = fantasma.getImage();
	    ImageIcon fantasma2 = new ImageIcon(getClass().getResource("/imagens/fantasma2.png"));
	    this.imgFantasma2 = fantasma2.getImage();
	    ImageIcon fantasma3 = new ImageIcon(getClass().getResource("/imagens/fantasma3.png"));
	    this.imgFantasma3 = fantasma3.getImage();
	    ImageIcon fantasma4 = new ImageIcon(getClass().getResource("/imagens/fantasma4.png"));
	    this.imgFantasma4 = fantasma4.getImage();
	  }
	  
	  private void lugarInicial()
	  {
	    xpacman = 10;
	    ypacman = 0;
	    xfantasma = 10;
	    yfantasma = 270;
	    xfantasma2 = 10;
	    yfantasma2 = 360;
	    xfantasma3 = 10;
	    yfantasma3 = 120;
	    xfantasma4 = 10;
	    yfantasma4 = 180;
	  }
	  
	  public final void pintarTela()
	  {
	    for (int a = 0; a < 17; a++) {
	      for (int b = 0; b < 17; b++) {
	        comida[a][b] = 1;
	      }
	    }
	  }
	  
	  public void paint(Graphics g)
	  {
	    super.paint(g);
	    Graphics2D d = (Graphics2D)g;
	    d.setColor(Color.WHITE);
	    d.setFont(new Font("Arial", 1, 16));
	    d.drawString("Nível " + nivel, 260, 230);
	    d.drawString("Programador: Yoshiharu", 180, 245);
	    d.setColor(Color.BLACK);
	    this.under_comida = 20;
	    for (int a = 0; a < 17; a++)
	    {
	      this.prox_comida = 60;
	      for (int b = 0; b < 17; b++)
	      {
	        if (comida[a][b] == 1) {
	          d.fillOval(this.prox_comida, this.under_comida, 8, 8);
	        }
	        this.prox_comida += 30;
	      }
	      this.under_comida += 30;
	    }
	    if (MoverPacman.comeco)
	    {
	      d.drawImage(this.imgPacman2, xpacman, ypacman, this);
	      MoverPacman.comeco = false;
	    }
	    else if (MoverPacman.pcima)
	    {
	      if (this.trocarImagem)
	      {
	        d.drawImage(this.imgPacman5, xpacman, ypacman, this);
	        this.trocarImagem = false;
	      }
	      else
	      {
	        d.drawImage(this.imgPacman, xpacman, ypacman, this);
	        this.trocarImagem = true;
	      }
	    }
	    else if (MoverPacman.pbaixo)
	    {
	      if (this.trocarImagem)
	      {
	        d.drawImage(this.imgPacman3, xpacman, ypacman, this);
	        this.trocarImagem = false;
	      }
	      else
	      {
	        d.drawImage(this.imgPacman, xpacman, ypacman, this);
	        this.trocarImagem = true;
	      }
	    }
	    else if (MoverPacman.pdireita)
	    {
	      if (this.trocarImagem)
	      {
	        d.drawImage(this.imgPacman2, xpacman, ypacman, this);
	        this.trocarImagem = false;
	      }
	      else
	      {
	        d.drawImage(this.imgPacman, xpacman, ypacman, this);
	        this.trocarImagem = true;
	      }
	    }
	    else if (MoverPacman.pesquerda)
	    {
	      if (this.trocarImagem)
	      {
	        d.drawImage(this.imgPacman4, xpacman, ypacman, this);
	        this.trocarImagem = false;
	      }
	      else
	      {
	        d.drawImage(this.imgPacman, xpacman, ypacman, this);
	        this.trocarImagem = true;
	      }
	    }
	    d.drawImage(this.imgFantasma, xfantasma, yfantasma, this);
	    if (nivel > 1) {
	      d.drawImage(this.imgFantasma2, xfantasma2, yfantasma2, this);
	    }
	    if (nivel > 2) {
	      d.drawImage(this.imgFantasma3, xfantasma3, yfantasma3, this);
	    }
	    if (nivel > 3) {
	      d.drawImage(this.imgFantasma4, xfantasma4, yfantasma4, this);
	    }
	  }
	}