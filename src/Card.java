public class Card{
    private final int value;
    private final String symbol;
    private final String name;
    public void getCardInfo() {
        System.out.printf("\n%s of %s" , name, symbol);
    }
    private static int[] valuesArr = {2,3,4,5,6,7,8,9,10,11,12,13,14};
    private static String[] namesArr = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    private static String[] symbolsArr = {"\u2660", "\u2665", "\u2663", "\u2666"};
    public Card(String name, int value, String symbol) {
        this.name = name;
        this.value = value;
        this.symbol = symbol;
    }
    public int getValue() {
        return value;
    }

    public void getName() {
        System.out.println(name);
    }
    public String getSymbol() {
        return symbol;
    }
    public static int[] getValuesArr() {
        return valuesArr;
    }
    public static String[] getNamesArr() {
        return namesArr;
    }
    public static String[] getSymbolsArr() {
        return symbolsArr;
    }


}
