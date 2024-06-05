public class ModInverse {

    /**
     * @implNote (a * x mod m) = 1
     * @param a
     * @param m
     * @return
     */
    public int modInverse(int a, int m)
    {
      //Your code here
      int i = 1;
      long a_mod_m = (long) a % (long) m;
      while (i <= m) {
        long b_mod_m = (long) i % (long) m;
        long multipleMod = (long) (a_mod_m * b_mod_m) %  (long) m;
        if(multipleMod == 1) {
            return i;
        }
        i++;
      }
      return -1;
    }

    public static void main(String[] args) {
        new ModInverse().modInverse(10, 17);
    }
}
