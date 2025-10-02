package main;

public class BoardConsoleRenderer {

    public void render(Board board) {
        for (int rank = 8; rank >= 1 ; rank--) {
            for (File file : File.values()){
                System.out.print(file + String.valueOf(rank));
            }
            System.out.print("\n");
        }
    }
}
