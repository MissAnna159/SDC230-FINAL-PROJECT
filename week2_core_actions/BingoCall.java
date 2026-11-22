// One object of this class is one called ball, such as B12.
// Week 1 built the letter in main and then forgot it. This class keeps both pieces together.
public class BingoCall {

    private int number;
    private String letter;

    // Main only passes the number. The constructor figures out the letter.
    public BingoCall(int number) {
        this.number = number;
        this.letter = letterFor(number);
    }

    // This is the same if/else from your Week 1 draw option.
    // It lives here so every ball gets the right letter, and main does not repeat it.
    private String letterFor(int number) {
        if (number <= 15) {
            return "B";
        } else if (number <= 30) {
            return "I";
        } else if (number <= 45) {
            return "N";
        } else if (number <= 60) {
            return "G";
        } else {
            return "O";
        }
    }

    public int getNumber() {
        return number;
    }

    // If the number changes, the letter has to change with it.
    public void setNumber(int number) {
        this.number = number;
        this.letter = letterFor(number);
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    // So printing the object shows B12 instead of BingoCall@1a2b3c.
    public String toString() {
        return letter + number;
    }
}
