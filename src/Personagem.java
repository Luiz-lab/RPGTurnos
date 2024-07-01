import java.util.ArrayList;
import java.util.List;

public class Personagem {
    private String nome;
    private String classe ;
    private int pontosVida;
    private int forca;
    private int defesa;
    private final List<Habilidades> habilidadesList = new ArrayList<>();
    private final List<Itens> itensList = new ArrayList<>();
    private int receberExperiencia;
    private final int taxaAcertoCritico = 0;
    private boolean isDefendendo;
    private final List<Efeitos> efeitosList = new ArrayList<>();


    public Personagem(String nome, int pontosVida, int forca, int defesa) {
        this.nome = nome;
        this.pontosVida = pontosVida;
        this.forca = forca;
        this.defesa = defesa;
        this.receberExperiencia = 1;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getReceberExperiencia() {
        return receberExperiencia;
    }

    public void setReceberExperiencia(int receberExperiencia) {
        this.receberExperiencia = receberExperiencia;
    }

    public List<Habilidades> getHabilidadesList() {
        return habilidadesList;
    }


    public List<Itens> getItensList() {
        return itensList;
    }

    public boolean isHabilidades(){
        return !habilidadesList.isEmpty();
    }

    public boolean isItem(){
        return !itensList.isEmpty();
    }

    public List<Efeitos> getEfeitosList(){
        return efeitosList;
    }
    public void setEfeitosList(Efeitos efeito){
        this.efeitosList.add(efeito);
    }

    public void addItens(Itens item){
        if (item == null){
            throw new IllegalArgumentException("Nenhuma item adicionado");
        }
        item.definirRaridade();
        this.itensList.add(item);
        if (item.isDanoItem()){
            this.forca += item.getDanoBase();
        } else if (item.isDefesaItem()) {
            this.defesa += item.getDefesaBase();
        }
        System.out.println("Item adicionado");
    }

    public void addHabilidades(Habilidades habilidades){
        if (habilidades == null){
            throw new IllegalArgumentException("Nenhuma habilidade adicionada");
        }
        this.habilidadesList.add(habilidades);
        if (habilidades.isHabilidadeDano()) {
            this.forca += habilidades.getDanoBaseVantagem();
        } else if (habilidades.isHabilidadeDefesa()) {
            this.defesa += habilidades.getDefesaBaseVantagem();
        }
        System.out.println("Habilidade adicionada");
    }

    public boolean isGolpeCritico(){
        System.out.println("Ataque Critico");
        int valorAleatorio = (int) (Math.random() * 100);
        return valorAleatorio <= taxaAcertoCritico;
    }

    public int calcularDano(){
        int danoFinal = this.getForca();
        if (isGolpeCritico()){
            danoFinal *= 2;
        }
        if (isHabilidades()){
            for (Habilidades habilidades: habilidadesList){
                danoFinal += habilidades.getDanoBaseVantagem();
            }
        }
        if (isItem()){
            for (Itens item: itensList){
                danoFinal+= item.getDanoBase();
            }
        }
        return  danoFinal;
    }

    public int calcularDefesa(){
        int defesaFinal = this.getDefesa();
        if (isHabilidades()){
            for(Habilidades habilidades: habilidadesList){
                defesaFinal += habilidades.getDefesaBaseVantagem();
            }
        }
        if (isItem()){
            for (Itens itens: itensList){
                defesaFinal += itens.getDefesaBase();
            }
        }

        return defesaFinal;
    }

    public void calcularDefesaTemporaria(){
        if (!isDefendendo){
            this.defesa = calcularDefesa() * 2;
            this.isDefendendo = true;
        }
    }

    public void resetarDefesa(){
        if(isDefendendo){
            this.defesa = calcularDefesa();
            this.isDefendendo = false;
        }
    }

    public void receberDano(int dano){
        if (isDefendendo){
            dano /= 2;
        }
        this.pontosVida -= dano;
        resetarDefesa();
    }

    public int calcularPontosDeVida(){
        int pontosDeVidaFinal = this.pontosVida;
        pontosDeVidaFinal -= calcularDano();
        return pontosDeVidaFinal;
    }

    public int lancarDados(int quantidadeDados){
        int somatorioValores = 0;
        for (int i = 1 ; i<= quantidadeDados; i++){
            somatorioValores += (int) (Math.random()*6)+1;
        }
        return somatorioValores;
    }

    public void aplicarEfeitos(){
        List<Efeitos> efeitosRemover = new ArrayList<>();
        for (Efeitos efeito: efeitosList){
            switch (efeito.getTipoEfeito()){
                case "Envenenado":
                case "Queimado":
                    this.pontosVida -= efeito.getDanoCausado();
                    System.out.println(this.nome + " tomou " + efeito.getDanoCausado() + " de dano devido a " + efeito.getTipoEfeito());
                    break;
                case "Atordoado":
                case "Dormindo" :
                    if (efeito.getQtdRodadas()>0){
                        System.out.println(this.nome + " está " + efeito.getTipoEfeito() + " e não pode atacar.");
                        efeitosRemover.add(efeito);
                    }
                    break;
            }
            efeito.contagemReducaoEfeito();
            if (efeito.getQtdRodadas()<=0){
                efeitosRemover.add(efeito);
            }
        }
        efeitosList.removeAll(efeitosRemover);
    }

    public boolean verificarAtaque(){
        for (Efeitos efeito: efeitosList){
            if (efeito.getTipoEfeito().equalsIgnoreCase("Dormindo") && efeito.getQtdRodadas() > 0){
                return false;
            }
            if (efeito.getTipoEfeito().equalsIgnoreCase("Atordoado") && efeito.getQtdRodadas()>0){
                return false;
            }
        }
        return true;
    }


    @Override
    public String toString() {
        return "Personagem{" +
                "nome='" + nome + '\'' +
                ", classe='" + classe + '\'' +
                ", pontosVida=" + pontosVida +
                ", forca=" + forca +
                ", defesa=" + defesa +
                ", habilidadesList=" + habilidadesList +
                ", itensList=" + itensList +
                ", receberExperiencia=" + receberExperiencia +
                ", taxaAcertoCritico=" + taxaAcertoCritico +
                ", isDefendendo=" + isDefendendo +
                ", efeitosList=" + efeitosList +
                '}';
    }
}
