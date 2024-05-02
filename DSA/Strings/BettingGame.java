package DSA.Strings;

public class BettingGame {
    static int betBalance(String result)
    {
        // code here
        int n = result.length();
        int balance = 4;
        int curr_bet = 1;
        for(int i = 0; i < n; i++) {
            if(result.charAt(i) == 'W') {
                balance += curr_bet;
                curr_bet = 1;
            }else {
                balance -= curr_bet;
                curr_bet *= 2;
            }
            if(balance < curr_bet && i < n - 1) return -1;
        }
        return balance;
    }
    public static void main(String[] args) {
        String result = "WLLLW";
        System.out.println(betBalance(result));
    }
}
