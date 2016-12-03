package robertobiondo.utilities.math;
//Classe importata da una mia esercitazione personale

import java.util.Arrays;

/**
 *Class containing some generic Math utilities, like GCD and lcm
 * @author Roberto Biondo
 */
public class MathUtils{

    /**
     *Computes the greatest common divisor of the two long integers given as parameters
     * @param a the first long integer for the GCD
     * @param b the second long integer for the GCD
     * @return the GCD of the two numbers
     */
    public static long GCD(long a, long b){
		if (a==0 || b == 0) return 1;
		long min = minimum(Math.abs(a),Math.abs(b));
		long max = maximum(Math.abs(a),Math.abs(b));
		long remainder = max % min;
		if (remainder==0) return min;
		else return GCD (min, remainder);
	}
        
    /**
     *Computers the greatest common divisor of n long integers given as parameters
     * @param numbers the long integer for wich one wants the GCD
     * @return the GCD of the n numbers
     */
    public static long GCD(long... numbers){
            if (numbers.length==1){
                return numbers[0];
            }
            else if(numbers.length == 2){
                return GCD(numbers[0],numbers[1]);
            }
            else{
                numbers[1]=GCD(numbers[0],numbers[1]);
                return GCD(Arrays.copyOfRange(numbers,1, numbers.length));
            }
            
        }

    /**
     *Computes the least common multiple of the two long integers given as parameters
     * @param a the first long integer for wich one wants the lcm
     * @param b the second long integer for wich one wants the lcm
     * @return the lcm of the two numbers
     */
    public static long lcm(long a, long b){
		return Math.abs((a * b)/GCD(a,b));
	}
	
    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static long maximum(long a, long b){
		if (a<b) return b;
		else return a;
	}
	
    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static long minimum (long a, long b){
		if (a<b) return a;
		else return b;
	}
        
    /**
     *
     * @param array
     * @param val
     * @return
     */
    public static boolean contains(int[] array, int val){
            for(int i=0;i<array.length;i++){
                if(array[i]==val){
                    return true;
                }
            }
            return false;
        }
        
    /**
     *
     * @param array
     * @return
     */
    public static boolean hasDuplicates(int[] array){
            for(int i=0;i<array.length -1;i++){
                for(int j=i+1;j<array.length;j++){
                    if (array[i]==array[j]){
                        return true;
                    }
                }
            }
            return false;
        }
        
    /**
     *
     * @param a
     * @return
     */
    public static boolean isInteger(double a){
            return a==Math.floor(a);
        }

    public static String doubleFormat(double number) {
        if (isInteger(number)) {
            return String.format("%d", (long) number);
        } else {
            return String.format("%s", number);
        }
    }
        
}