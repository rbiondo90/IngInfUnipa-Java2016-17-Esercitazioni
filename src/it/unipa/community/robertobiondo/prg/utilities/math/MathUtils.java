package it.unipa.community.robertobiondo.prg.utilities.math;
//Classe importata da una mia esercitazione personale

import java.util.Arrays;

public class MathUtils{
	public static long GCD(long a, long b){
		if (a==0 || b == 0) return 1;
		long min = minimum(Math.abs(a),Math.abs(b));
		long max = maximum(Math.abs(a),Math.abs(b));
		long remainder = max % min;
		if (remainder==0) return min;
		else return GCD (min, remainder);
	}
        
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

	public static long lcm(long a, long b){
		return Math.abs((a * b)/GCD(a,b));
	}
	
	public static long maximum(long a, long b){
		if (a<b) return b;
		else return a;
	}
	
	public static long minimum (long a, long b){
		if (a<b) return a;
		else return b;
	}
        
        public static boolean contains(int[] array, int val){
            for(int i=0;i<array.length;i++){
                if(array[i]==val){
                    return true;
                }
            }
            return false;
        }
        
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
        
        public static boolean isInteger(double a){
            return a==Math.floor(a);
        }
        
}