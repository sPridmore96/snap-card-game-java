import java.util.Scanner;
public class User {
    public Scanner scanner;
    private int Score;
    private String Name;
    private boolean hasPlayed;
    public User(String name) {
        Score = 0;
        Name = name;
        this.hasPlayed = false;
        this.scanner = new Scanner(System.in);
    }
    public int getScore() {
        return Score;
    }
    public void setScore(int score) {
        Score = score;
    }
    public String getName() {
        return Name;
    }
    public boolean getHasPlayed() {
        return hasPlayed;
    }
    public void setHasPlayed(boolean hasPlayed) {
        this.hasPlayed = hasPlayed;
    }
}
