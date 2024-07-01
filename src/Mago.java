public class Mago extends Personagem{
    private boolean atributosMagia;
    private int upgradeMagia;
    private final String classe = "Mago";
    private int level = 0;
    private int acumulaXp = 0;
    private final int taxaAcertoCritico = 25;

    public Mago(String nome, int pontosVida, int forca, int defesa, boolean atributosMagia, int upgradeMagia ) {
        super(nome, pontosVida, forca, defesa);
        this.atributosMagia = atributosMagia;
        this.upgradeMagia = upgradeMagia;
        super.setClasse(classe);
    }

    public boolean isAtributosMagia() {
        return atributosMagia;
    }

    public void setAtributosMagia(boolean atributosMagia) {
        this.atributosMagia = atributosMagia;
    }

    public int getUpgradeMagia() {
        return upgradeMagia;
    }

    public void setUpgradeMagia(int upgradeMagia) {
        this.upgradeMagia = upgradeMagia;
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
        int valorAleatorio = (int) (Math.random()*100);
        return valorAleatorio <= this.taxaAcertoCritico;
    }

}
