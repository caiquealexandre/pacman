package jogo;

public class MoverFantasmas {
	private boolean moverx;
	private boolean movery;
	Resultado resultado = new Resultado();
	private boolean ghost = true;
	private boolean mudar = false;
	private int cont = 0;
	private int quant;
	NovosFantasmas nf = new NovosFantasmas();

	public void prepararDirecaoFantasma() {
		if (Desenho.xpacman > Desenho.xfantasma) {
			this.moverx = true;
		} else {
			this.moverx = false;
		}
		if (Desenho.ypacman > Desenho.yfantasma) {
			this.movery = true;
		} else {
			this.movery = false;
		}
		moverFantasma(this.moverx, this.movery);
		this.nf.fantasmas3_4();
	}

	private void moverFantasma(boolean x, boolean y) {
		int sorte = (int) (Math.random() * 4.0D);
		int sorte2 = (int) (Math.random() * 2.0D);
		if (sorte != 1) {
			if (sorte2 == 0) {
				if (x) {
					Desenho.xfantasma += 30;
				} else {
					Desenho.xfantasma -= 30;
				}
			} else if (y) {
				Desenho.yfantasma += 30;
			} else {
				Desenho.yfantasma -= 30;
			}
		} else {
			if (sorte2 == 0) {
				if (x) {
					Desenho.xfantasma -= 30;
				} else {
					Desenho.xfantasma += 30;
				}
			} else if (y) {
				Desenho.yfantasma -= 30;
			} else {
				Desenho.yfantasma += 30;
			}
			if (Desenho.xfantasma < 10) {
				Desenho.xfantasma += 30;
			}
			if (Desenho.xfantasma > 520) {
				Desenho.xfantasma -= 30;
			}
			if (Desenho.yfantasma < 0) {
				Desenho.yfantasma += 30;
			}
			if (Desenho.yfantasma > 480) {
				Desenho.yfantasma -= 30;
			}
		}
		if (Desenho.nivel > 1) {
			if (this.cont < 4) {
				if (this.ghost) {
					Desenho.xfantasma2 += 30;
				} else {
					Desenho.xfantasma2 -= 30;
				}
				if (Desenho.xfantasma2 >= 520) {
					this.ghost = false;
					this.cont += 1;
					if (this.cont == 3) {
						this.quant = ((int) (Math.random() * 10.0D));
					}
				}
				if (Desenho.xfantasma2 < 10) {
					this.ghost = true;
				}
			} else {
				boolean res = rodar();
				if (res == true) {
					if (this.ghost) {
						Desenho.yfantasma2 += 30;
					} else {
						Desenho.yfantasma2 -= 30;
					}
					if (Desenho.yfantasma2 >= 480) {
						this.ghost = false;
						this.cont += 1;
					}
					if (Desenho.yfantasma2 < 0) {
						this.ghost = true;
					}
					if (this.cont == 6) {
						this.cont = 0;
						this.mudar = false;
					}
				}
			}
		}
		this.resultado.derrota();
		this.resultado.vitoria();
	}

	private boolean rodar() {
		this.quant -= 1;
		if (this.quant <= 0) {
			this.mudar = true;
		} else {
			if (this.ghost) {
				Desenho.xfantasma2 += 30;
			} else {
				Desenho.xfantasma2 -= 30;
			}
			if (Desenho.xfantasma2 >= 520) {
				this.ghost = false;
			}
			if (Desenho.xfantasma2 <= 10) {
				this.ghost = true;
			}
		}
		return this.mudar;
	}
}
