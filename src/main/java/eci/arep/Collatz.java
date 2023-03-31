package eci.arep;



public class Collatz {


    public static String sequence(int k){
        String seq = "" + k;
        while (k != 1){
            if (k % 2 == 0){
                // System.out.println("par");
                k = k / 2;
                seq = seq + " -> " + k;
            } else if (k % 2 != 0) {
                // System.out.println("impar");
                k = 3 * k +1 ;
                seq = seq + " -> " + k;
            }
        }
        System.out.println(seq);
        return seq;
    }

}
