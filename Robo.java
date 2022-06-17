import java.util.Scanner;

public class Robo {
    static Scanner scn;
    static String text = "";
    static int[][] labirinto;
    static int originLine, originColumn, linhas, colunas, size, rewards;
    static Pilha<Celula> pilha;
    static DataManager dm;

    public Robo(DataManager dm) throws Exception {
        Robo.labirinto = DataManager.labirinto;
        Robo.originLine = DataManager.originLine;
        Robo.originColumn = DataManager.originColumn;
        Robo.size = DataManager.size;
        Robo.colunas = DataManager.colunas;
        Robo.linhas = DataManager.linhas;
        Robo.dm = dm;
        // pilha = new Pilha<Celula>(size);
        DataManager.printLabirint();
        countRewards(originLine, originColumn);
        // DataManager.printLabirint();
        // //System.out.println(originLine + " " + originColumn);
        // System.out.println("Rewards: " + rewards);
    }

    private static void countRewards(int i, int j) throws Exception {

        try {
            pilha.empilha(new Celula(i, j));
            labirinto[i][j] = -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // //System.out.println("i: " + i + " j: " + j);
        do {
            int directionCode = verifyEmpty(pilha.getTopo().row, pilha.getTopo().col);
            i = pilha.getTopo().row;
            j = pilha.getTopo().col;
            // //System.out.println("Código da direção " + directionCode);
            switch (directionCode) {
                case 1:
                    if (labirinto[i - 1][j] == 1) {
                        rewards++;
                    }
                    labirinto[i - 1][j] = 9;
                    pilha.empilha(new Celula(i - 1, j));
                    i--;
                    // //System.out.println("i: " + i + " j: " + j);
                    break;
                case 2:
                    if (labirinto[i][j - 1] == 1) {
                        rewards++;
                    }
                    labirinto[i][j - 1] = 9;
                    pilha.empilha(new Celula(i, j - 1));
                    j--;
                    // //System.out.println("i: " + i + " j: " + j);

                    break;
                case 3:
                    if (labirinto[i + 1][j] == 1) {
                        rewards++;
                    }
                    labirinto[i + 1][j] = 9;
                    pilha.empilha(new Celula(i + 1, j));
                    i++;
                    // //System.out.println("i: " + i + " j: " + j);
                    break;
                case 4:
                    if (labirinto[i][j + 1] == 1) {
                        rewards++;
                    }
                    labirinto[i][j + 1] = 9;
                    pilha.empilha(new Celula(i, j + 1));
                    j++;
                    // //System.out.println("i: " + i + " j: " + j);
                    break;
                default:
                    // System.out.println("desempilha");
                    pilha.desempilha();
                    // //System.out.println("vou desempilhar");
            }
            // //System.out.println("pilha Topo row: " + pilha.getTopo().row + " pilha Topo
            // Col: " + pilha.getTopo().col);
            // //System.out.println((pilha.getTopo().row != originLine &&
            // pilha.getTopo().col != originColumn));
            // //System.out.println(originLine);
            // dm.printLabirint();
            System.out
                    .println((pilha.getTopo().row + " " + originLine + " " + pilha.getTopo().col + " " + originColumn));
        } while ((pilha.getTopo().row != originLine || pilha.getTopo().col != originColumn)
                || (verifyEmpty(originLine, originColumn) != 0));

        // enquanto o topo não for a origem e enquanto a origem não tiver lateral vazia

    }

    private static int verifyEmpty(int i, int j) {
        if (i > 0 && labirinto[i - 1][j] == 0
                || i > 0 && labirinto[i - 1][j] == 1) {
            // System.out.println("Acima");
            return 1;
        } else if (j > 0 && labirinto[i][j - 1] == 0
                || j > 0 && labirinto[i][j - 1] == 1) {
            // System.out.println("Esquerda");
            return 2;
        } else if (i < linhas - 2 && labirinto[i + 1][j] == 0
                || i < linhas - 2 && labirinto[i + 1][j] == 1) {
            // System.out.println("Abaixo");
            return 3;
        } else if (j < colunas - 2 && labirinto[i][j + 1] == 0
                || j < colunas - 2 && labirinto[i][j + 1] == 1) {
            // System.out.println("Direita i: "+i+" j: "+j);
            return 4;
        } else {
            // System.out.println("Não há nada");

            return 0;
        }
    }

    private static class Celula {
        int col, row;

        public Celula(int row, int col) {
            this.row = row;
            this.col = col;
            // calcularVazias();
        }

    }
}
