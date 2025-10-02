public class TestCard {
    public static void main(String[] args) { //push 2
        boolean hasFailures = false;
        
        Card testCard = new Card("Encapsulation", "Bundling data and code into a restricted container");
        
        if (!testCard.toString().equals("Bundling data and code into a restricted container")) {
            System.err.println("FAIL: toString() doesn't match definition");
            hasFailures = true;
        }
        
        if (!testCard.attempt("Encapsulation")) {
            System.err.println("FAIL: attempt() should return true for correct term");
            hasFailures = true;
        }
        
        if (testCard.attempt("Abstraction")) {
            System.err.println("FAIL: attempt() should return false for incorrect term");
            hasFailures = true;
        }
        
        if (!testCard.getTerm().equals("Encapsulation")) {
            System.err.println("FAIL: getTerm() doesn't return correct term");
            hasFailures = true;
        }
        
        if (!testCard.attempt("eNcApSuLaTiOn")) {
            System.err.println("FAIL: attempt() should be case-insensitive");
            hasFailures = true;
        }
        
        try {
            new Card("", "Some definition");
            System.err.println("FAIL: Empty term should throw IllegalArgumentException");
            hasFailures = true;
        } catch (IllegalArgumentException e) {
        }
        
        try {
            new Card("SomeTerm", null);
            System.err.println("FAIL: Null definition should throw IllegalArgumentException");
            hasFailures = true;
        } catch (IllegalArgumentException e) {
        }
        
        if (hasFailures) {
            System.exit(1);
        }
    }
}