# ♟️ Chess Game (Java Console)

Jogo de xadrez completo, jogado via terminal, desenvolvido em Java com programação orientada a objetos, com o objetivo de praticar conceitos avançados de OOP como herança, polimorfismo, encapsulamento e tratamento de exceções personalizadas.

## 📋 Sobre o projeto

O projeto foi dividido em duas camadas principais:

- **`BoardGame`**: camada genérica de tabuleiro, reutilizável para qualquer jogo baseado em matriz (posição, peça, exceções do tabuleiro).
- **`Chess`**: camada específica das regras do xadrez, que estende as classes genéricas do `BoardGame` e implementa as regras de cada peça, o turno dos jogadores, captura, xeque, xeque-mate, jogada especial (roque, en passant) e promoção de peão.

A interface é toda em modo texto (console), exibindo o tabuleiro, as peças capturadas e destacando os movimentos possíveis da peça selecionada.

## 🚀 Funcionalidades

- Movimentação de todas as peças (Peão, Torre, Cavalo, Bispo, Dama, Rei) seguindo as regras oficiais do xadrez
- Destaque visual dos movimentos possíveis no tabuleiro
- Alternância automática de turno entre os jogadores
- Detecção de **xeque** e **xeque-mate**
- Jogadas especiais: **roque** (pequeno e grande), **en passant** e **promoção de peão**
- Lista de peças capturadas por cor, exibida durante a partida
- Tratamento de exceções customizadas (`BoardException`, `ChessException`) para jogadas inválidas

## 🛠️ Tecnologias utilizadas

- **Java** (JDK 17+)
- Programação Orientada a Objetos (herança, polimorfismo, encapsulamento, exceções customizadas)

## 📁 Estrutura do projeto

```
src/
├── Application/
│   ├── Program.java        # Classe principal (main), controla o loop da partida
│   └── UI.java              # Responsável por toda a exibição no console
│
├── BoardGame/
│   ├── Board.java           # Tabuleiro genérico
│   ├── BoardException.java  # Exceção genérica do tabuleiro
│   ├── Piece.java           # Peça genérica (abstrata)
│   └── Position.java        # Posição em matriz (linha/coluna)
│
├── Chess/
│   ├── ChessMatch.java      # Regras da partida (turno, xeque, xeque-mate, jogadas especiais)
│   ├── ChessPiece.java      # Peça de xadrez (abstrata, estende Piece)
│   ├── ChessPosition.java   # Posição em notação de xadrez (ex: a1, e4)
│   ├── ChessException.java  # Exceção específica de regras do xadrez
│   ├── Color.java           # Enum de cores (WHITE / BLACK)
│   └── Pieces/
│       ├── King.java
│       ├── Queen.java
│       ├── Rook.java
│       ├── Bishop.java
│       ├── Knight.java
│       └── Pawn.java
```

## ▶️ Como executar

### Passos

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/nome-do-repositorio.git

# Entre na pasta do projeto
cd nome-do-repositorio

# Compile os arquivos
javac -d bin src/Application/*.java src/BoardGame/*.java src/Chess/*.java src/Chess/Pieces/*.java

# Execute
java -cp bin Application.Program
```

Ou simplesmente abra o projeto em uma IDE (IntelliJ, Eclipse, VS Code) e rode a classe `Program.java`.

## 🎮 Como jogar

1. Ao iniciar, o tabuleiro é exibido no console com as peças em suas posições iniciais.
2. Digite a posição de origem da peça que deseja mover (ex: `e2`).
3. O jogo destaca os movimentos possíveis daquela peça.
4. Digite a posição de destino (ex: `e4`).
5. Se a jogada resultar em promoção de peão, escolha a peça desejada (`B`, `N`, `R` ou `Q`).
6. O jogo alterna automaticamente entre os jogadores até ocorrer o xeque-mate.

## 👤 Autor

**Dias**
Estudante de Desenvolvimento de Software Multiplataforma (FATEC Osasco)
