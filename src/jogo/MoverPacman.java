package jogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

public class MoverPacman
{
  public static Timer moverDireita;
  public static Timer moverEsquerda;
  public static Timer moverCima;
  public static Timer moverBaixo;
  public static JFrame jframePrincipal;
  public static boolean pcima;
  public static boolean pbaixo;
  public static boolean pesquerda;
  public static boolean pdireita;
  public static boolean comeco = true;
  public static int pontos = 0;
  MoverFantasmas mf = new MoverFantasmas();
  
  public MoverPacman(JFrame jframe)
  {
    jframePrincipal = jframe;
  }
  
  private void comer()
  {
    int fruit = 40;int fruit2 = 0;
    boolean entrar = true;
    for (int a = 0; a < 17; a++)
    {
      for (int b = 0; b < 17; b++)
      {
        if ((Desenho.xpacman == fruit) && (Desenho.ypacman == fruit2) && (entrar) && (Desenho.comida[a][b] == 1))
        {
          Desenho.comida[a][b] = 0;
          Som.reproduzir("som/fruit.wav");
          pontos += 1;
          entrar = false;
          break;
        }
        fruit += 30;
      }
      fruit = 40;
      fruit2 += 30;
    }
  }
  
  public void teclas(KeyEvent evento)
  {
    int codigo = evento.getKeyCode();
    parar();
    if (codigo == 39) {
      direita();
    }
    if (codigo == 37) {
      esquerda();
    }
    if (codigo == 38) {
      cima();
    }
    if (codigo == 40) {
      baixo();
    }
  }
  
  private void direita()
  {
    pdireita = true;
    moverDireita = new Timer(100, new ActionListener()
    {
      public void actionPerformed(ActionEvent ae)
      {
        Desenho.xpacman += 30;
        MoverPacman.this.comer();
        MoverPacman.this.paredes();
        MoverPacman.this.mf.prepararDirecaoFantasma();
        MoverPacman.jframePrincipal.repaint();
      }
    });
    moverDireita.start();
  }
  
  private void esquerda()
  {
    pesquerda = true;
    moverEsquerda = new Timer(100, new ActionListener()
    {
      public void actionPerformed(ActionEvent ae)
      {
        Desenho.xpacman -= 30;
        MoverPacman.this.comer();
        MoverPacman.this.paredes();
        MoverPacman.this.mf.prepararDirecaoFantasma();
        MoverPacman.jframePrincipal.repaint();
      }
    });
    moverEsquerda.start();
  }
  
  private void cima()
  {
    pcima = true;
    moverCima = new Timer(100, new ActionListener()
    {
      public void actionPerformed(ActionEvent ae)
      {
        Desenho.ypacman -= 30;
        MoverPacman.this.comer();
        MoverPacman.this.paredes();
        MoverPacman.this.mf.prepararDirecaoFantasma();
        MoverPacman.jframePrincipal.repaint();
      }
    });
    moverCima.start();
  }
  
  private void baixo()
  {
    pbaixo = true;
    moverBaixo = new Timer(100, new ActionListener()
    {
      public void actionPerformed(ActionEvent ae)
      {
        Desenho.ypacman += 30;
        MoverPacman.this.comer();
        MoverPacman.this.paredes();
        MoverPacman.this.mf.prepararDirecaoFantasma();
        MoverPacman.jframePrincipal.repaint();
      }
    });
    moverBaixo.start();
  }
  
  private void paredes()
  {
    if (Desenho.xpacman < 10)
    {
      moverEsquerda.stop();
      Desenho.xpacman = 10;
    }
    else if (Desenho.ypacman < 0)
    {
      moverCima.stop();
      Desenho.ypacman = 0;
    }
    else if (Desenho.ypacman > 480)
    {
      moverBaixo.stop();
      Desenho.ypacman = 480;
    }
    else if (Desenho.xpacman > 520)
    {
      moverDireita.stop();
      Desenho.xpacman = 520;
    }
  }
  
  public static void parar()
  {
    if (pcima)
    {
      pcima = false;
      moverCima.stop();
    }
    else if (pbaixo)
    {
      pbaixo = false;
      moverBaixo.stop();
    }
    else if (pdireita)
    {
      pdireita = false;
      moverDireita.stop();
    }
    else if (pesquerda)
    {
      pesquerda = false;
      moverEsquerda.stop();
    }
  }
}