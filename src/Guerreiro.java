public class Guerreiro extends Personagem{
    private boolean atributosForca;
    private int upgradeForca;
    private final String classe = "Guerreiro";
    private int level = 1;
    private int acumulaXp;
    private final int taxaAcertoCritico= 30;

    public Guerreiro(String nome, int pontosVida, int forca, int defesa, boolean atributosForca, int upgradeForca ) {
        super(nome, pontosVida, forca, defesa);
        this.atributosForca = atributosForca;
        this.upgradeForca = upgradeForca;
        super.setClasse(classe);
    }

    public int getUpgradeForca() {
        return upgradeForca;
    }

    public void setUpgradeForca(int upgradeForca) {
        this.upgradeForca = upgradeForca;
    }

    public boolean getAtributosForca() {
        return atributosForca;
    }

    public void setAtributosForca(boolean atributosForca) {
        this.atributosForca = atributosForca;
    }

    @Override
    public int getForca(){
        return this.getForca() + this.upgradeForca;
    }

    public void setAcumulaXp(int recompensaXp){
        this.acumulaXp += recompensaXp;
        this.level = verificaLevel();

    }
    public int verificaLevel(){
        int qtdLevelUp = 0;
        if (this.acumulaXp >= 10){
            qtdLevelUp = this.acumulaXp/10;
            this.acumulaXp = this.acumulaXp%10;
        }
        return this.level + qtdLevelUp;
    }

    @Override
    public boolean isGolpeCritico(){
        int valorAleatorio = (int) (Math.random() * 100);
        return valorAleatorio <= this.taxaAcertoCritico;
    }

}
