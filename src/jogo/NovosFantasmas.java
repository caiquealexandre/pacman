package jogo;

public class NovosFantasmas
{
  private boolean mudar = false;
  private boolean ghost = true;
  private int cont2 = 0;
  private int cont = 0;
  private int quant;
  
  public void fantasmas3_4()
  {
    if (Desenho.nivel > 2) {
      if (this.cont < 4)
      {
        if (this.ghost) {
          Desenho.xfantasma3 += 30;
        } else {
          Desenho.xfantasma3 -= 30;
        }
        if (Desenho.xfantasma3 >= 520)
        {
          this.ghost = false;
          this.cont += 1;
          if (this.cont == 3) {
            this.quant = ((int)(Math.random() * 10.0D));
          }
        }
        if (Desenho.xfantasma3 < 10) {
          this.ghost = true;
        }
      }
      else
      {
        boolean res = rodar();
        if (res == true)
        {
          if (this.ghost) {
            Desenho.yfantasma3 += 30;
          } else {
            Desenho.yfantasma3 -= 30;
          }
          if (Desenho.yfantasma3 >= 480)
          {
            this.ghost = false;
            this.cont += 1;
          }
          if (Desenho.yfantasma3 < 0) {
            this.ghost = true;
          }
          if (this.cont == 6)
          {
            this.cont = 0;
            this.mudar = false;
          }
        }
      }
    }
    if (Desenho.nivel > 3)
    {
      this.cont2 += 1;
      if (this.cont2 == 5)
      {
        this.cont2 = 0;
        int sorte = (int)(Math.random() * 15.0D);
        int sorte2 = (int)(Math.random() * 15.0D);
        int resultado = sorte * 30 + 10;
        int resultado2 = sorte2 * 30;
        Desenho.xfantasma4 = resultado;
        Desenho.yfantasma4 = resultado2;
      }
    }
  }
  
  private boolean rodar()
  {
    this.quant -= 1;
    if (this.quant <= 0)
    {
      this.mudar = true;
    }
    else
    {
      if (this.ghost) {
        Desenho.xfantasma3 += 30;
      } else {
        Desenho.xfantasma3 -= 30;
      }
      if (Desenho.xfantasma3 >= 520) {
        this.ghost = false;
      }
      if (Desenho.xfantasma3 <= 10) {
        this.ghost = true;
      }
    }
    return this.mudar;
  }
}
