import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Personagem> personagens = new ArrayList<>();
    private List<Personagem> inimigos = new ArrayList<>();
    private Batalha batalha = new Batalha();
    private Scanner keyboard = new Scanner(System.in);

    public void criarPersonagens() {
        boolean adicionarPersonagem;
        do {
            System.out.println("Escolha primeiro uma classe: ");
            System.out.println("1 - Arqueiro \n2 - Guerreiro \n3 - Mago");
            int classe = keyboard.nextInt();
            keyboard.nextLine();
            System.out.println("Digite seu nome: ");
            String nome = keyboard.nextLine();
            System.out.println("Digite seus pontos de vida: ");
            int pontosVida = keyboard.nextInt();
            System.out.println("Digite seus pontos de força: ");
            int forca = keyboard.nextInt();
            System.out.println("Digite seus pontos de defesa: ");
            int defesa = keyboard.nextInt();
            keyboard.nextLine();

            Personagem personagem = null;

            switch (classe) {
                case 1:
                    System.out.println("Digite seu atributo de Destreza: ");
                    int atributoArqueiro = keyboard.nextInt();
                    personagem = new Arqueiro(nome, pontosVida, forca, defesa, true, atributoArqueiro);
                    break;
                case 2:
                    System.out.println("Digite seu atributo de Força: ");
                    int atributoGuerreiro = keyboard.nextInt();
                    personagem = new Guerreiro(nome, pontosVida, forca, defesa, true, atributoGuerreiro);
                    break;
                case 3:
                    System.out.println("Digite seu atributo de Magia: ");
                    int atributoMago = keyboard.nextInt();
                    personagem = new Mago(nome, pontosVida, forca, defesa, true, atributoMago);
                    break;
                default:
                    throw new IllegalArgumentException("É necessário passar algum parâmetro de classe");
            }
            keyboard.nextLine();

            System.out.println("O personagem possui alguma habilidade especial? 1 - Sim \n2 - Não ");
            int hasHabilidade = keyboard.nextInt();
            keyboard.nextLine();
            if (hasHabilidade == 1) {
                System.out.println("Digite o nome da Habilidade: ");
                String nomeHabilidade = keyboard.nextLine();
                System.out.println("Digite o tipo da Habilidade: ");
                String tipoHabilidade = keyboard.nextLine();
                System.out.println("Informe se a habilidade é de Dano ou de Defesa: ");
                String contextoHabilidade = keyboard.nextLine();
                System.out.println("Informe o valor do(a) " + contextoHabilidade);
                int danoOuDefesaBase = keyboard.nextInt();
                Habilidades habilidade = new Habilidades(nomeHabilidade, tipoHabilidade);
                if (contextoHabilidade.equalsIgnoreCase("Dano")) {
                    habilidade.setDanoBaseVantagem(danoOuDefesaBase);
                }
                if (contextoHabilidade.equalsIgnoreCase("Defesa")) {
                    habilidade.setDefesaBaseVantagem(danoOuDefesaBase);
                }
                personagem.addHabilidades(habilidade);
            }
            System.out.println("O personagem possui algum efeito especial? 1 - Sim \n2 - Não ");
            int hasEfeito = keyboard.nextInt();
            keyboard.nextLine();
            if (hasEfeito ==1){
                System.out.println("Digite o nome do Efeito: ");
                String tipo = keyboard.nextLine();
                System.out.println("Digite o dano do Efeito: ");
                int danoCausado = keyboard.nextInt();
                keyboard.nextLine();
                Efeitos efeito = new Efeitos(tipo,danoCausado);
                personagem.setEfeitosList(efeito);
            }
            personagens.add(personagem);

            System.out.println("Parabéns seu personagem foi criado");
            System.out.println("Deseja Criar outro personagem: 1 - Sim \n2 - Não ");
            int resposta = keyboard.nextInt();
            adicionarPersonagem = resposta ==1;
            keyboard.nextLine();
        }
        while (adicionarPersonagem);

    }

    public void criarInimigos() {
        boolean adicionarInimigos;

        do {
            System.out.println("Digite o nome do seu inimigo: ");
            String nomeInimigo = keyboard.nextLine();
            System.out.println("Digite seus pontos de vida: ");
            int pontosVidaInimigo = keyboard.nextInt();
            System.out.println("Digite seus pontos de força: ");
            int forcaInimigo = keyboard.nextInt();
            System.out.println("Digite seus pontos de defesa: ");
            int defesaInimigo = keyboard.nextInt();
            keyboard.nextLine();
            Inimigos inimigo = new Inimigos(nomeInimigo, pontosVidaInimigo, forcaInimigo, defesaInimigo);
            inimigo.setTipo("Monstro");
            inimigo.setRecompensaXp(5);
            System.out.println("O inimigo possui alguma habilidade especial? 1 - Sim \n2 - Não ");
            int hasHabilidade = keyboard.nextInt();
            keyboard.nextLine();
            if (hasHabilidade == 1) {
                System.out.println("Digite o nome da Habilidade: ");
                String nome = keyboard.nextLine();
                System.out.println("Digite o tipo da Habilidade: ");
                String tipo = keyboard.nextLine();
                System.out.println("Informe se a habilidade é de Dano ou de Defesa: ");
                String contextoHabilidade = keyboard.nextLine();
                System.out.println("Informe o valor do(a) " + contextoHabilidade + ": ");
                int danoOuDefesaBase = keyboard.nextInt();
                Habilidades habilidade = new Habilidades(nome, tipo);
                if (contextoHabilidade.equalsIgnoreCase("Dano")) {
                    habilidade.setDanoBaseVantagem(danoOuDefesaBase);
                }
                if (contextoHabilidade.equalsIgnoreCase("Defesa")) {
                    habilidade.setDefesaBaseVantagem(danoOuDefesaBase);
                }
            }
            System.out.println("O inimigo possui algum efeito especial? 1 - Sim \n2 - Não ");
            int hasEfeito = keyboard.nextInt();
            keyboard.nextLine();
            if (hasEfeito ==1){
                System.out.println("Digite o nome do Efeito: ");
                String tipo = keyboard.nextLine();
                System.out.println("Digite o dano do Efeito: ");
                int danoCausado = keyboard.nextInt();
                keyboard.nextLine();
                Efeitos efeito = new Efeitos(tipo,danoCausado);
                inimigo.setEfeitosList(efeito);
            }

            inimigos.add(inimigo);
            System.out.println("Tudo certo, o inimigo foi criado!");
            System.out.println("Deseja Criar outro inimigo: 1 - Sim \n2 - Não ");
            int resposta = keyboard.nextInt();
            adicionarInimigos = resposta ==1;
            keyboard.nextLine();
        } while (adicionarInimigos);

    }

    private void realizarAcaoPersonagem(Personagem personagem) {
        if (inimigos.isEmpty()) return;

        System.out.println("Escolha um Inimigo: ");
        for (int i = 0; i < inimigos.size(); i++) {
            System.out.println((i + 1) + ". " + inimigos.get(i).getNome());
        }
        int escolhaInimigo = keyboard.nextInt() - 1;
        Inimigos inimigoEscolhido = (Inimigos) inimigos.get(escolhaInimigo);

        System.out.println(personagem.getNome() + " escolha uma ação: ");
        System.out.println("1 - Atacar \n2 - Fugir \n3 - Usar Habilidade \n4 - Defender \n5 - Aplicar Efeitos");
        int acao = keyboard.nextInt();
        keyboard.nextLine();

        switch (acao) {
            case 1:
                batalha.Atacar(personagem, inimigoEscolhido);
                System.out.println(inimigoEscolhido.getNome() + " possui " + inimigoEscolhido.getPontosVida() + " pontos de vida");
                break;
            case 2:
                batalha.Fugir(personagem);
                if (personagem.getPontosVida() > 0) {
                    return;
                }
                break;
            case 3:
                batalha.usarHabilidade(personagem, inimigoEscolhido);
                break;
            case 4:
                batalha.Defender(personagem);
                System.out.println(personagem.getNome() + " possui " + personagem.getPontosVida() + " pontos de vida");
                break;
            case 5:
                if (!personagem.getEfeitosList().isEmpty()) {
                    inimigoEscolhido.aplicarEfeitos();
                    System.out.println("Uso de Efeito");
                }
                break;
            default:
                System.out.println("Ação inválida.");
        }

        if (inimigoEscolhido.getPontosVida() <= 0) {
            personagem.setReceberExperiencia(inimigoEscolhido.getRecompensaXp());
            System.out.println(inimigoEscolhido.getNome() + " foi derrotado!");
            Itens item = new Itens();
            List<Itens> recompensas = item.gerarRecompensa(" O " + personagem.getNome() + " Ganhou item derrotando  " + inimigoEscolhido.getNome());
            for (Itens recompensa : recompensas) {
                personagem.addItens(recompensa);
            }
            inimigos.remove(inimigoEscolhido);
            System.out.println(personagem.getNome() + " ganhou " + personagem.getReceberExperiencia() + " de experiência.");
        }
    }

    public void gerarAcaoInimigo(Inimigos inimigo, Personagem alvo) {
        int acao = (int) (Math.random() * 3) + 1;
        switch (acao) {
            case 1:
                batalha.Atacar(inimigo, alvo);
                break;
            case 2:
                if (inimigo.isHabilidades()) {
                    batalha.usarHabilidade(inimigo, alvo);
                } else {
                    batalha.Atacar(inimigo, alvo);
                }
                break;
            case 3:
                if (!inimigo.getEfeitosList().isEmpty()) {
                    alvo.aplicarEfeitos();
                }
                break;
            default:
                System.out.println("Ação Invalida");
        }
        if (alvo.getPontosVida() <= 0) {
            System.out.println(alvo.getNome() + " foi derrotado");
            personagens.remove(alvo);
        }
    }

    public void iniciarBatalha() {
        System.out.println("Vamos iniciar decidindo quem começará o turno");
        System.out.println("Digite quantos dados serão jogados:");
        int qtdDados = keyboard.nextInt();
        int contadorDeTurnos = 1;
        keyboard.nextLine();

        while (!personagens.isEmpty() && !inimigos.isEmpty()) {
            System.out.println("Turno: " + contadorDeTurnos);
            for (Personagem personagem : personagens) {
                personagem.aplicarEfeitos();
                if (!personagem.verificarAtaque()) {
                    System.out.println(personagem.getNome() + " não pode atacar neste turno.");
                    continue;
                }
                realizarAcaoPersonagem(personagem);
                if (inimigos.isEmpty()) {
                    System.out.println("Todos os inimigos foram derrotados");
                    return;
                }
            }
            for (Personagem inimigo : inimigos) {
                inimigo.aplicarEfeitos();
                if (!inimigo.verificarAtaque()) {
                    System.out.println(inimigo.getNome() + " não pode atacar neste turno.");
                    continue;
                }
                gerarAcaoInimigo((Inimigos) inimigo, personagens.get(0));
                if (personagens.isEmpty()) {
                    System.out.println("Todos os personagens foram derrotados");
                    return;
                }
            }
            contadorDeTurnos++;
        }
    }


    public void iniciarJogo() {
        criarPersonagens();
        criarInimigos();
        iniciarBatalha();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.iniciarJogo();
    }
}
