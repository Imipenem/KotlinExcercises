package leetcode.guesshl;

/*
    374. Guess Number Higher or Lower: Exercise LeetCode
 */

public class Guess {

    private static int x = 1702766719; // let n be >=42

    private int guessNumber(int n) {
        long guess = n > 1 ? n / 2 : 1;
        long l = 1;
        long r = n;

        while (guess(guess, x) != 0) {
            int res = guess(guess, x);
            if (res == 1) l = guess;
            else r = guess;

            if(r-l == 1){
                return guess(l,x)==0? (int)l : (int)r;
            }
            else guess = (l-r)%2==0?((l + r) / 2): ((l+r)/2)+1;
        }
        return (int)guess;
    }

    private int guess(long num, int x) {
        if (num < x) return 1;
        else if (num == x) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        Guess g = new Guess();
        System.out.println(g.guessNumber(2126753390));
    }
}

