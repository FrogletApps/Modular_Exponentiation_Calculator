class asgl {
    public static void main (String[] args) {
        Long a = Long.parseLong(args[0]);  //Base
        Long j = Long.parseLong(args[1]);  //Exponent
        Long n = Long.parseLong(args[2]);

        System.out.println(a);
        System.out.println(j);
        System.out.println(n);

        System.out.print(a.toString() + " mod " + n.toString() + " = ");

        System.out.println(calculateMod(a, n));

        //for (Long i = 0; i < 5; i++) {
        //    System.out.println(i);
        // }
          
    }

    private static Long calculateMod(Long firstNum, Long secondNum){
        Long result = firstNum%secondNum + (firstNum >= 0 ? 0 : secondNum);
        return result;
    }
}