import java.io.FileInputStream;
import java.util.Scanner;

public class DataManager {

    static Scanner scn;
    static String text = "";
    static int[][] labirinto;
    static int originLine, originColumn, linhas, colunas, size;

    public DataManager() throws Exception {
        readText("labirinto.dat");
        setValues();
        storeLabirintVector();
        // printLabirint();

    }

    static void storeLabirintVector() {

        int counter = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < colunas; j++) {
                if (text.charAt(counter) == 'b' | text.charAt(counter) == 'x') // buraco ou parede = -1
                    labirinto[i][j] = -1;
                if (text.charAt(counter) == ' ') // passagem livre = 0
                    labirinto[i][j] = 0;
                if (text.charAt(counter) == 'p') // premio = 1
                    labirinto[i][j] = 1;
                if (text.charAt(counter) == 'o') { // origem
                    labirinto[i][j] = 9;
                    originLine = i;
                    originColumn = j;
                }

                counter++;
            }
        }
    }

    public static void readText(String path) throws Exception {

        scn = new Scanner(new FileInputStream(path));
        scn.nextLine();
        linhas = scn.nextInt();
        colunas = scn.nextInt();

        while (scn.hasNextLine()) {
            text += scn.nextLine();
        }
        // System.out.println(text);
        scn.close();
        // enquanto tiver continuação vazia empilha, verifica se substitui por outro
    }

    static void setValues() {
        size = colunas * linhas;
        labirinto = new int[linhas][colunas];
    }

    static void printLabirint() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(labirinto[i][j] + "\t");
            }
            System.out.println("");
        }
    }

}
