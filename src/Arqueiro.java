public class Arqueiro extends Personagem{
    private boolean atributoDestreza;
    private int upgradeDestreza;
    private String classe = "Arqueiro";
    private int level = 1;
    private int acumulaXp = 0;
    private int taxaAcertoCritico = 20;


    public Arqueiro(String nome, int pontosVida, int forca, int defesa, boolean atributoDestreza, int upgradeDestreza ) {
        super(nome, pontosVida, forca, defesa);
        this.atributoDestreza = atributoDestreza;
        this.upgradeDestreza = upgradeDestreza;
        super.setClasse(classe);
    }

    public boolean isAtributoDestreza() {
        return atributoDestreza;
    }

    public void setAtributoDestreza(boolean atributoDestreza) {
        this.atributoDestreza = atributoDestreza;
    }

    public int getUpgradeDestreza() {
        return upgradeDestreza;
    }

    public void setUpgradeDestreza(int upgradeDestreza) {
        this.upgradeDestreza = upgradeDestreza;
    }

    public void setAcumulaXp(int recompensaXp){
        this.acumulaXp += recompensaXp;
        this.level = verificaLevel();
    }

    @Override
    public boolean isGolpeCritico(){
        int valorAleatorio = (int) (Math.random() * 100);
        return valorAleatorio <= this.taxaAcertoCritico;
    }



    public int verificaLevel(){
        int qtdLevelUp = 0;
        if (this.acumulaXp >= 10){
            qtdLevelUp = this.acumulaXp/10;
            this.acumulaXp = this.acumulaXp%10;
        }
        return this.level + qtdLevelUp;
    }



}
