public class asg1 {
    public static void main (String[] args) {
        //Set variables from arguments
        //These are to calculate a^j mod n
        Long a = Long.parseLong(args[0]);  //Base
        Long j = Long.parseLong(args[1]);  //Exponent
        Long n = Long.parseLong(args[2]);

        //Test inputs
        /*System.out.println(a);
        System.out.println(j);
        System.out.println(n);*/

        //Test calculateMod
        /*System.out.print(a.toString() + " mod " + n.toString() + " = ");
        System.out.println(calculateMod(a, n));*/

        //Test isPrime
        /*System.out.println(a + "" + isPrime(a));
        System.out.println(j + "" + isPrime(j));
        System.out.println(n + "" + isPrime(n));
        System.out.println("---");*/

        //Test isEven
        /*System.out.println(a + "" + isEven(a));
        System.out.println(j + "" + isEven(j));
        System.out.println(n + "" + isEven(n));
        System.out.println("---");*/

        System.out.println(simpleSolve(a, j, n));
        //System.out.println(advancedSolve(a, j, n));
    }

    private static Long simpleSolve(Long a, Long j, Long n){
        Long temp = 1L;  //L is needed to tell it the number is Long
        //Loop j times
        for (Long i = 0L; i < j; i++) {
            temp = temp * calculateMod(a, n);
            //System.out.println(i);
            //System.out.println(temp);
        }
        return calculateMod(temp, n);  //Final result
    }

    // private static Long advancedSolve(Long a, Long j, Long n){
    //     //TEST CODE - REMOVE BEFORE FINAL VERSION
    //     if (isEven(j) != true){
    //         System.out.println("WARNING - THIS MIGHT BREAK");
    //     }

    //     for (int i = 0; i < 50; i++) {
    //         j = j/2;
    //         System.out.println("i = " + i + " - j = " + j);
    //     }

    //     Long temp = 1L;
    //     //long splitResult = simpleSolve(a, j, n);
    //     System.out.println("splitResult = " + splitResult);
    //     for (int i = 0; i < 50; i++) {
    //         temp = temp * splitResult;
    //         System.out.println("i2 = " + i + " - temp = " + temp);
    //     }
    //     return calculateMod(temp, n);  //Final result
    // }

    //A function to calculate firstNum mod secondNum
    private static Long calculateMod(Long firstNum, Long secondNum){
        Long modResult = firstNum%secondNum + (firstNum >= 0 ? 0 : secondNum);
        return modResult;
    }

    //A function to calculate if a number is even
    private static Boolean isEven(Long input){
        Boolean result = false;
        if (calculateMod(input, 2L) == 0){
            result = true;
        }
        return result;
    }

    //A function to tell whether a number is prime (it will make an approximation for large numbers for speed)
    private static Boolean isPrime(Long isPrime){
        Boolean result = true;

        Long lastDigit = calculateMod(isPrime, 10L);
        //System.out.println(isPrime + "'s last digit is " + lastDigit);

        //List of last digits that would definitely not be prime
        Long[] primeLastDigits = {0L, 2L, 4L, 5L, 6L, 8L};

        //Quick check for prime numbers, check to see if even or divisble by 5
        for (int i = 0; i < 6; i++){
            if (primeLastDigits[i] == lastDigit){
                //System.out.println("Last digit means this isn't prime");
                result = false;
                break;
            }
        }

        //If it still could be prime, then do a more thorough (but still quick) check
        if (result == true){
            Long primeCheckLimit;
            //Limit the checking to 1000 numbers so this is quick
            if (isPrime > 1000L){
                primeCheckLimit = 1000L;
            }
            else{
                primeCheckLimit = isPrime;
            }
            for (Long i = 2L; i < primeCheckLimit; i++) {
                //if isPrime MOD i = 0 then it is not prime
                //System.out.println(i);
                if (calculateMod(isPrime, i) == 0){
                    result = false;
                    break;
                }
            }
            //1 is not a prime number
            if (isPrime == 1){
                result = false;
            }

        }
        return result;
    }
}