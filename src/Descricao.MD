Trabalho RPG De Turno
Analise as diretrizes básicas abaixo e crie um jogo (RPG) de turno.
OBS: Nomes de classes, variáveis, conteúdo e valores podem ser alterados.
Combate em um Jogo de RPG de Turno O que é um Turno?
Um turno é uma oportunidade de ação para um personagem ou inimigo durante o combate. Em cada turno, o personagem pode realizar uma ação específica, como atacar, usar uma habilidade, defender ou tentar fugir. Cada personagem envolvido na batalha tem a chance de agir uma vez por turno.
O que é uma Rodada?
Uma rodada é a soma de todos os turnos de todos os personagens e inimigos envolvidos na batalha. Após todos terem realizado suas ações, a rodada é considerada completa, e uma nova rodada começa.
Como Funciona o Combate?
1. Início da Batalha:
   ○ Quandoumabatalhacomeça,todosospersonagenseinimigos
   participantes são listados.
   ○ Aordemdosturnosédeterminadaporumatributocomo
   velocidade ou destreza, ou, a ordem clássica: personagem ->
   inimigo -> personagem -> inimigo. 2. Execução de Turnos:
   ○ Cadapersonagem,emsuavez,podeescolherumaação:atacar, usar uma habilidade, defender ou fugir.
   ○ Aaçãoéexecutada,eseusefeitossãoaplicados(porexemplo, dano ao inimigo, cura de um aliado, etc.).

○ Apósaação,oturnodopersonagemtermina,eopróximo personagem na ordem realiza sua ação.
3. Fim da Rodada:
   ○ Quandotodosospersonagenseinimigostiveremcompletado
   seus turnos, a rodada termina.
   ○ Sehouverpersonagensouinimigosaindadepé,umanova
   rodada começa. 4. Fim do Combate:
   ○ Ocombatecontinuaatéquetodososinimigosoutodosos personagens sejam derrotados.
   ○ Apósabatalha,ospersonagenspodemreceberpontosde experiência, itens, e outros prêmios.

Mãos à obra: 1. Criação de Personagens:
- Crie uma classe base chamada `Personagem` com os seguintes atributos:
- `Nome` (string): o nome do personagem.
- `PontosVida` (int): os pontos de vida do personagem. - `Forca` (int): a força do personagem.
- `Defesa` (int): a defesa do personagem.
- Crie classes derivadas para cada classe específica, como `Guerreiro`, `Mago` e `Arqueiro`, que herdam da classe `Personagem`.
- Adicione atributos específicos para cada classe, como `PontosMagia` para o Mago, `Destreza` para o Arqueiro, etc.
2. Combate:
- Crie uma classe chamada `Batalha` que será responsável por controlar as ações de combate.
- A classe `Batalha` deve ter um método para determinar a ordem dos turnos.
- Cada personagem deve ter um método `Atacar` que calcula o dano do ataque baseado na força do personagem e na defesa do alvo.
- Crie métodos para as outras ações possíveis durante o combate, como `UsarMagia`, `Defender` e `Fugir`.
3. Inimigos:
- Crie uma classe `Inimigo` que também derive da classe `Personagem`.

- Adicione atributos específicos para os inimigos, como `Tipo` (por exemplo, "Monstro", "Chefe", etc.), `RecompensaXP` (experiência ganha ao derrotar o inimigo), etc.
4. Vantagens e Fraquezas:
- Crie uma classe `Habilidade` com os seguintes atributos:
  ❖ `Nome` (string): o nome da habilidade.
  ❖ `Tipo` (string): o tipo da habilidade (por exemplo, "Fogo", "Gelo",
  "Elétrico", etc.).
  ❖ `DanoBase` (int): o dano base causado pela habilidade.
- Adicione um atributo `Habilidades` na classe `Personagem` que será uma lista de habilidades.
- Adicione um método `CalcularDano` na classe `Personagem` que verifique as vantagens e fraquezas do personagem e do alvo com base no tipo da habilidade utilizada.
5. Fim de Batalha:
- Quando a batalha terminar, atualize os atributos dos personagens, como pontos de vida, pontos de experiência, etc.
- Crie uma classe `Jogo` que controla o fluxo do jogo, como a criação dos personagens, a criação dos inimigos, a execução das batalhas, etc.
6. Conteúdo Extras
   As funções abaixo podem ser adicionadas para tornar a experiência do jogo mais dinâmica (avalie o tempo, a necessidade e confiabilidade dos itens citados, e decida se cabe ou não a implementação dessas funções).
   a) Sistema de Nível (cada monstro derrotada dá X pontos de experiência ao personagem, ao atingir Y pontos de experiência o personagem aumenta de nível)

b) Sistema de Defesa (quanto maior a defesa menos dano é causado em ambos os combatentes)
c) Sistema de Golpe Crítico: Todo golpe que é efetuado por um combatente tem X % de chance de ser crítico. Golpes críticos dão 50% a mais de dano.
d) Sistema de ganho de itens: Ao matar X inimigos aparece um baú, neste baú podem vir itens aleatórios.
e) Sistema de Raridade de Itens: Pode existir de 2 - 4 tipos de raridade de itens, com atributos e efeitos diferentes.
f) Sistema de Habilidades de Itens: Pode existir uma classificação de itens chamada “Únicos”, como: “Raio de Zeus”, “Cajado de Merlin”, etc. Estes itens adicionam habilidades extras à lista de habilidades do personagem.

Exemplo de Combate com um Personagem e um Inimigo Personagem:
● Guerreiro:Forçaalta,defesamédia. Inimigo:
● Goblin:Ataquemoderado,defesamoderada. Ordem dos Turnos:
1. Guerreiro 2. Goblin
   Rodada 1:
   ● TurnodoGuerreiro: ○ Ação:Atacar.
   ○ Efeito:GuerreiroatacaoGoblin,causando10dedano.
   ○ PontosdeVidadoGoblin:20-10=10. ● TurnodoGoblin:
   ○ Ação:Atacar.
   ○ Efeito:GoblinatacaoGuerreiro,causando4dedano. ○ PontosdeVidadoGuerreiro:25-4=21.
   Rodada 2:
   ● TurnodoGuerreiro: ○ Ação:Atacar.
   ○ Efeito:GuerreiroatacaoGoblin,causando10dedano.
   ○ PontosdeVidadoGoblin:10-10=0(Goblinéderrotado).
   A batalha termina com a vitória do Guerreiro. Ele pode ganhar pontos de experiência e itens como recompensa.

Descrição Detalhada do Combate Turno do Guerreiro (Rodada 1):
1. O Guerreiro decide atacar o Goblin.
2. O dano causado é baseado na força do Guerreiro.
3. O Goblin recebe 10 pontos de dano.
4. Os pontos de vida do Goblin diminuem de 20 para 10.
   Turno do Goblin (Rodada 1):
1. O Goblin contra-ataca o Guerreiro.
2. O dano causado pelo Goblin é baseado na força dele.
3. O Guerreiro recebe 4 pontos de dano.
4. Os pontos de vida do Guerreiro diminuem de 25 para 21.
   Turno do Guerreiro (Rodada 2):
1. O Guerreiro ataca novamente o Goblin.
2. O dano causado é novamente 10 pontos.
3. Os pontos de vida do Goblin diminuem de 10 para 0. 4. O Goblin é derrotado.



Desafio Extra (Coordenação):
Sistema de Efeitos de Combate:
1.  Envenenado: O combatente que estiver envenenado toma X dando a cada rodada.
2.  Atordoado: O combatente que estiver atordoado fica 1 turno sem atacar
3.  Queimado: O Combatente que estiver queimado toma X dano a cada turno.
4.  Dormindo: O Combatente que estiver dormindo fica X turnos sem atacar até levar um golpe.