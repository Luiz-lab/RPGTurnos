import java.util.HashMap;
import java.util.Map;

public class Habilidades {
    private String nome;
    private String tipoVantagem;
    private int danoBaseVantagem;
    private boolean isHabilidadeDano;
    private int defesaBaseVantagem;
    private boolean isHabilidadeDefesa;
    private static final Map<String, String> vantagens  = new HashMap<>();
    private static final Map<String, String> fraquezas = new HashMap<>();


    /* Classe de Habilidades:
            - Agua->  Vantagem: Fogo
            - Fogo -> Vantagem: Vento
            - Vento -> Vantagem: Terra
            - Terra -> Vantagem: Elétrico
            - Elétrico -> Vantagem: Agua
            - Fantasma -> Vantagem: Psiquico
            - Luminosos -> Vantagem: Fantasma
            - Psiquico -> Vantagem: Limunosos
            */
    static {
        // Vantagens
        vantagens.put("Agua","Fogo");
        vantagens.put("Fogo","Vento");
        vantagens.put("Vento","Terra");
        vantagens.put("Terra","Elétrico");
        vantagens.put("Elétrico","Agua");
        vantagens.put("Fantasma","Psiquico");
        vantagens.put("Luminoso","Fantasma");
        vantagens.put("Psiquico","Luminoso");

        // Desvantagens
        fraquezas.put("Fogo","Agua");
        fraquezas.put("Vento","Fogo");
        fraquezas.put("Terra","Vento");
        fraquezas.put("Elétrico","Terra");
        fraquezas.put("Agua","Elétrico");
        fraquezas.put("Psiquico","Fantasma");
        fraquezas.put("Fantasma","Luminoso");
        fraquezas.put("Luminoso","Psiquico");

    }


    public Habilidades(String nome, String tipoVantagem) {
        this.nome = nome;
        this.tipoVantagem = tipoVantagem;
    }

    public Habilidades() {

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

    public int getDanoBaseVantagem() {
        return danoBaseVantagem;
    }


    public void setDanoBaseVantagem(int danoBaseVantagem) {
        this.isHabilidadeDano = true;
        this.isHabilidadeDefesa = false;
        this.danoBaseVantagem = danoBaseVantagem;
    }


    public boolean hasVantagem(String classeAlvo){
        return vantagens.getOrDefault(this.tipoVantagem,"").equalsIgnoreCase(classeAlvo);
    }

    public boolean hasFraquezas(String classeAlvo){
        return fraquezas.getOrDefault(this.tipoVantagem,"").equalsIgnoreCase(classeAlvo);
    }

    public int getDefesaBaseVantagem() {
        return defesaBaseVantagem;
    }

    public void setDefesaBaseVantagem(int defesaBaseVantagem) {
        this.isHabilidadeDano = false;
        this.isHabilidadeDefesa = true;
        this.defesaBaseVantagem = defesaBaseVantagem;
    }

    public boolean isHabilidadeDano() {
        return isHabilidadeDano;
    }

    public boolean isHabilidadeDefesa() {
        return isHabilidadeDefesa;
    }



    @Override
    public String toString() {
        return "Habilidades{" +
                "nome='" + nome + '\'' +
                ", tipoVantagem='" + tipoVantagem + '\'' +
                ", danoBaseVantagem=" + danoBaseVantagem +
                '}';
    }

    public Map<String, String> setTipoVantagem() {
        return vantagens;
    }
}
