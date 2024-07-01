import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Efeitos {
    private String tipoEfeito;
    private int qtdRodadas = (int) (Math.random()*2)+1;
    private int danoCausado ;

    public Efeitos(String tipoEfeito, int danoCausado) {
        this.tipoEfeito = tipoEfeito;
        this.danoCausado = danoCausado;
    }

    public String getTipoEfeito() {
        return tipoEfeito;
    }

    public void setTipoEfeito(String tipoEfeito) {
        this.tipoEfeito = tipoEfeito;
    }

    public int getQtdRodadas() {
        return qtdRodadas;
    }

    public int getDanoCausado() {
        return danoCausado;
    }

    public void setDanoCausado(int danoCausado) {
        this.danoCausado = danoCausado;
    }

    public void contagemReducaoEfeito(){
        this.qtdRodadas -= 1;
    }


}
