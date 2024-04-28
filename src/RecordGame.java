import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RecordGame implements AutoCloseable {
    private int gameNumber = 0;
    private static PrintWriter writer;

    public RecordGame() {
        try {
            writer = new PrintWriter(new FileWriter("RecordedGame.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //at the start of each game it will mark it in the txt file
    public void startNewGame() {
        gameNumber++;
        writer.println("Game: " + gameNumber);
        writer.flush();
    }

    //used to record moves into the txt file
    public static void recordMove(int x, int y, String player, String move) {
        writer.printf("%s %s at (%d, %d)%n", player, move, x, y);
        writer.flush();
    }

    @Override
    public void close() throws Exception {
        if (writer != null) {
            writer.close();
        }
    }

    private void openWriter() {
        try {
            writer = new PrintWriter(new FileWriter("RecordedGame.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //used to clear the txt file which holds the recorded games
    public void clearRecordedGame() {
        try {
            writer.close();
            writer = new PrintWriter(new FileWriter("RecordedGame.txt")); //open in write mode to clear the file
            writer.flush();  //ethe file is cleared immediately
            writer.close();
            openWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}