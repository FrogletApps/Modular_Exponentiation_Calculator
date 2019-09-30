public class asg1 {
    public static void main (String[] args) {
        //Set variables from arguments
        //These are to calculate a^j mod n
        Long a = Long.parseLong(args[0]);  //Base
        Long j = Long.parseLong(args[1]);  //Exponent
        Long n = Long.parseLong(args[2]);

        

        /*System.out.println(a);
        System.out.println(j);
        System.out.println(n);*/

        /*System.out.print(a.toString() + " mod " + n.toString() + " = ");
        System.out.println(calculateMod(a, n));*/

        Long result = 1L;  //L is needed to tell it the number is Long
        //Loop j times
        for (Long i = 0L; i < j; i++) {
            result = result * calculateMod(a, n);
            /*System.out.println(i);
            System.out.println(result);*/
        }
        System.out.println(calculateMod(result, n));  //Final result
    }

    //A function to calculate firstNum mod secondNum
    private static Long calculateMod(Long firstNum, Long secondNum){
        Long modResult = firstNum%secondNum + (firstNum >= 0 ? 0 : secondNum);
        return modResult;
    }
}