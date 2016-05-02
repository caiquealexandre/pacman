package jogo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Principal
  extends JFrame
{
  MoverPacman moverpacman = new MoverPacman(this);
  
  public Principal()
  {
    Som.reproduzir("som/intro.wav");
    add(new Desenho());
    setTitle("Packman");
    setSize(580, 555);
    setDefaultCloseOperation(3);
    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);
    Desenho.nivel = 1;
    capturarTecla();
  }
  
  private void capturarTecla()
  {
    addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent evento)
      {
        Principal.this.moverpacman.teclas(evento);
      }
    });
  }
  
  public static void main(String[] args)
  {
    new Principal();
  }
}
