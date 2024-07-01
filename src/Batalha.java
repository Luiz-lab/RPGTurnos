
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Batalha{


    public void Atacar(Personagem atacante, Personagem alvo) {
        int dano = atacante.calcularDano();
        if (atacante.verificarAtaque()){
            alvo.setPontosVida(alvo.getPontosVida() - dano);
            System.out.println(atacante.getNome() + " atacou " + alvo.getNome() + " causando " + dano + " de dano");
        }
        else {
            System.out.println(atacante.getNome()+ " está sobre efeito e não pode executar a ação.");
        }

    }

    public void Defender(Personagem defensor) {
        defensor.calcularDefesaTemporaria();
        if (defensor.verificarAtaque()){
            System.out.println(defensor.getNome()+" está se defendendo.");
        }
        else {
            System.out.println(defensor.getNome()+ " está sobre efeito e não pode executar a ação.");

        }

    }

    public void Fugir(Personagem personagem) {
        int chanceDeFuga = (int) (Math.random()*100);
        if (personagem.verificarAtaque()){
            if (personagem.getClasse().equalsIgnoreCase("Arqueiro")){
                chanceDeFuga += 20;
            }
            if (chanceDeFuga <60){
                System.out.println(personagem.getNome() + " conseguiu fugir.");
                personagem.setPontosVida(0);
            }else {
                System.out.println(personagem.getNome() +" não conseguiu fugir.");
            }
        }
        else {
            System.out.println(personagem.getNome()+ " está sobre efeito e não pode executar a ação.");
        }

    }

    public boolean UsarMagia(Personagem personagem) {
        return personagem.getClasse().equalsIgnoreCase("Mago");
    }

    public void usarHabilidade(Personagem atacante, Personagem alvo){
        if (atacante.verificarAtaque()){
            if (atacante.isHabilidades()){
                Habilidades habilidades = selecionarHabilidades(atacante);
                int dano = habilidades.getDanoBaseVantagem();
                alvo.setPontosVida(alvo.getPontosVida() - dano);
                System.out.println(atacante.getNome() + " usou " + habilidades.getNome() + " em " + alvo.getNome() + " causando " + dano + " de dano.");
            }
            else {
                System.out.println(atacante.getNome() + " não possui habilidades.");
            }
        }
        else {
            System.out.println(atacante.getNome()+ " está sobre efeito e não pode executar a ação.");
        }

    }

    public Habilidades selecionarHabilidades(Personagem personagem){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma habilidade");
        for (int i = 0; i < personagem.getHabilidadesList().size(); i++){
            System.out.println((i+1) + ". " + personagem.getHabilidadesList().get(i).getNome());
        }
        int habilidadeIndex = scanner.nextInt() - 1;
        return personagem.getHabilidadesList().get(habilidadeIndex);
    }

    public List<Personagem> determinarOrdemTurno(Personagem personagem, Inimigos inimigos, int qtdDados){
        List<Personagem> listaTurno = new ArrayList<>();

        int lancamentoPersonagem = personagem.lancarDados(qtdDados);
        int lancamentoInimigo = inimigos.lancarDados(qtdDados);
        if (lancamentoPersonagem>lancamentoInimigo){
            listaTurno.add(personagem);
            listaTurno.add(inimigos);
        }
        else {
            listaTurno.add(inimigos);
            listaTurno.add(personagem);
        }
        return listaTurno;
    }
}
