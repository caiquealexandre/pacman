package jogo;

import javax.swing.JOptionPane;

public class Resultado
{
  public static int vidas = 3;
  
  public void vitoria()
  {
    boolean entrar = true;
    for (int a = 0; a < 17; a++) {
      for (int b = 0; b < 17; b++) {
        if (Desenho.comida[a][b] != 0)
        {
          entrar = false;
          break;
        }
      }
    }
    if (entrar)
    {
      Desenho.nivel += 1;
      if (Desenho.nivel == 5)
      {
        JOptionPane.showMessageDialog(null, "Parabéns, você ganhou!\nPontos: " + MoverPacman.pontos);
        System.exit(0);
      }
      JOptionPane.showMessageDialog(null, "Nível " + Desenho.nivel);
      repetido();
    }
  }
  
  public void derrota()
  {
    if (((Desenho.xpacman == Desenho.xfantasma) || (Desenho.xpacman == Desenho.xfantasma - 30)) && (
      (Desenho.ypacman == Desenho.yfantasma) || (Desenho.ypacman == Desenho.yfantasma - 30)))
    {
      Desenho.xfantasma = Desenho.xpacman;
      Desenho.yfantasma = Desenho.ypacman;
      repetido2();
    }
    if ((Desenho.nivel > 1) && 
      (Desenho.xpacman == Desenho.xfantasma2) && (Desenho.ypacman == Desenho.yfantasma2))
    {
      Desenho.xfantasma2 = Desenho.xpacman;
      Desenho.yfantasma2 = Desenho.ypacman;
      repetido2();
    }
    if ((Desenho.nivel > 2) && 
      (Desenho.xpacman == Desenho.xfantasma3) && (Desenho.ypacman == Desenho.yfantasma3))
    {
      Desenho.xfantasma3 = Desenho.xpacman;
      Desenho.yfantasma3 = Desenho.ypacman;
      repetido2();
    }
    if ((Desenho.nivel > 3) && 
      (Desenho.xpacman == Desenho.xfantasma4) && (Desenho.ypacman == Desenho.yfantasma4))
    {
      Desenho.xfantasma4 = Desenho.xpacman;
      Desenho.yfantasma4 = Desenho.ypacman;
      repetido2();
    }
  }
  
  private void repetido()
  {
    new Desenho();
    MoverPacman.parar();
    MoverPacman.comeco = true;
    MoverPacman.jframePrincipal.repaint();
  }
  
  private void repetido2()
  {
    Som.reproduzir("som/dead.wav");
    MoverPacman.jframePrincipal.repaint();
    vidas -= 1;
    if (vidas < 0)
    {
      int resposta = JOptionPane.showConfirmDialog(null, "             Game Over\nDeseja jogar novamente?");
      if (resposta != 0)
      {
        JOptionPane.showMessageDialog(null, "Pontos: " + MoverPacman.pontos);
        System.exit(0);
      }
      else
      {
        JOptionPane.showMessageDialog(null, "Pontos: " + MoverPacman.pontos);
        repetido();
        Desenho.nivel = 1;
        MoverPacman.pontos = 0;
        vidas = 3;
      }
    }
    else
    {
      JOptionPane.showMessageDialog(null, "Quantidade de vidas: " + vidas + "\nPontos: " + MoverPacman.pontos);
      repetido();
    }
  }
}
