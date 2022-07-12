import java.util.Scanner;

public abstract class CardGame {
    private final String name;
    public final Scanner scanner;
    protected CardGame(String name) {
        this.name = name;
        this.scanner = new Scanner(System.in);
    }
    public abstract void run();
    public void getStringInput() {
        boolean isStringActive = true;
        while(isStringActive) {
            String userInput = scanner.nextLine();
            if(userInput.isEmpty()) {
                isStringActive = false;
            }
        }
    }
    public void printMessage(String message) {
        System.out.println(message);
    }
    public void printGreetings(String CardGameName){
        System.out.println("Welcome to " + CardGameName + "\nHit Enter to Start and then also for\nDealing new cards");
    }
}
