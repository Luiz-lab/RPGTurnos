import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Itens {
    private String nome;
    private String tipoVantagem;
    private int raridadeItens = 0;
    private boolean isDanoItem;
    private int danoBase;
    private boolean isDefesaItem;
    private int defesaBase;

    private static final Map<String, String> vantagens = new Habilidades().setTipoVantagem();


    public Itens(String nome, String tipoVantagem, int raridadeItens) {
        this.nome = nome;
        this.tipoVantagem = tipoVantagem;
        this.raridadeItens = raridadeItens;
    }

    public Itens() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoVantagem() {
        return tipoVantagem;
    }

    public void setTipoVantagem(String tipoVantagem) {
        this.tipoVantagem = tipoVantagem;
    }

    public int getRaridadeItens() {
        return raridadeItens;
    }

    public void setRaridadeItens(int raridadeItens) {
        this.raridadeItens = raridadeItens;
    }

    public int getDanoBase() {
        return danoBase;
    }

    public int getDefesaBase() {
        return defesaBase;
    }

    public void setDanoBase(int danoBase) {
        this.isDanoItem = true;
        this.isDefesaItem = false;
        this.danoBase = danoBase;
    }

    public void setDefesaBase(int defesaBase) {
        this.isDanoItem = false;
        this.isDefesaItem = true;
        this.defesaBase = defesaBase;
    }

    public boolean isDanoItem() {
        return isDanoItem;
    }

    public boolean isDefesaItem() {
        return isDefesaItem;
    }

    public int definirRaridade (){
        int randomValue = (int) (Math.random()*100);
        if (randomValue<=10){
            return this.raridadeItens =4;
        }
        if (randomValue>10 && randomValue<=30){
            return this.raridadeItens = 3;
        }
        return this.raridadeItens = 2;
    }

    private String getTipoAleatorio() {
        List<String> keys = new ArrayList<>(vantagens.keySet());
        Random random = new Random();
        return keys.get(random.nextInt(keys.size()));
    }

    public List<Itens> gerarRecompensa(String nomeBase){
        List<Itens> recompensa = new ArrayList<>();
        int danoBase = (int) (Math.random()*80) + 1;
        int defesaBase = (int) (Math.random()*80)+1;
        System.out.println("Você encontrou um baú!");
        int quantidadeItens = (int) (Math.random()* 3)+ 1;
        for (int i = 0; i< quantidadeItens; i++){
            int raridadeItem = definirRaridade();

            String tipoAleatorio = getTipoAleatorio();

            if (danoBase>defesaBase){
                setDanoBase(danoBase);
                if (raridadeItem == 3){
                    this.danoBase += danoBase+40;
                }
                else if(raridadeItem == 4){
                    this.danoBase += 60;
                }
            }
            else {
                setDefesaBase(defesaBase);
                if (raridadeItem == 3){
                    this.defesaBase += 40;
                }
                else if(raridadeItem == 4){
                    this.defesaBase += 60;
                }
            }
            Itens item = new Itens(nomeBase,tipoAleatorio,raridadeItens);
            item.setDanoBase(this.danoBase);
            item.setDefesaBase(this.defesaBase);
            recompensa.add(item);
            System.out.println("Você recebeu: " + item.getNome() + " com " + (item.isDanoItem() ? "dano" : "defesa") + " base de " +
                    (item.isDanoItem() ? item.getDanoBase() : item.getDefesaBase()));
        }
        return recompensa;
    }

}
