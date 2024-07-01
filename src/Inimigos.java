public class Inimigos extends Personagem{
    private String tipo;
    private int RecompensaXp;
    private boolean vunerabilidade;
    private String vulnerabilidadeTipo;
    private int vulnerabilidadeDano;


    public Inimigos(String nome,
                    int pontosVida,
                    int forca,
                    int defesa) {
        super(nome, pontosVida, forca, defesa);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getRecompensaXp() {
        return RecompensaXp;
    }

    public void setRecompensaXp(int recompensaXp) {
        RecompensaXp = recompensaXp;
    }

    public boolean isVunerabilidade() {
        return vunerabilidade;
    }

    public void setVunerabilidade(boolean vunerabilidade) {
        this.vunerabilidade = vunerabilidade;
    }

    public String getVulnerabilidadeTipo() {
        return vulnerabilidadeTipo;
    }

    public void setVulnerabilidadeTipo(String vulnerabilidadeTipo) {
        this.vulnerabilidadeTipo = vulnerabilidadeTipo;
    }

    public int getVulnerabilidadeDano() {
        return vulnerabilidadeDano;
    }

    public void setVulnerabilidadeDano(int vulnerabilidadeDano) {
        this.vulnerabilidadeDano = vulnerabilidadeDano;
    }


    @Override
    public String toString() {
        return "Inimigos{" +
                "tipo='" + tipo + '\'' +
                ", RecompensaXp=" + RecompensaXp +
                ", vunerabilidade=" + vunerabilidade +
                ", vulnerabilidadeTipo='" + vulnerabilidadeTipo + '\'' +
                ", vulnerabilidadeDano=" + vulnerabilidadeDano +
                '}';
    }
}
