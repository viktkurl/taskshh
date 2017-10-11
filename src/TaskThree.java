import java.lang.reflect.Array;
import java.util.ArrayList;

class TaskThree {
    /**
    *Проверка
    *S(2) = P(1,1) + P(2,1) + P(1,2) + P(2,2) = 1,
    *S(10) = 20,
    *S(1000) = 248838
     */

    //Метод проверки "на простоту"
    static boolean prime_or_not(int x, ArrayList<Integer> primes) {
        //Получаем длину ряда
        int leng = primes.size();
        //Если число не простое, то делится без остатка хотя бы на одно простое число
        for(int i = 0; i<leng; i++){
            if(x%primes.get(i)==0) return false;
        } return true;
    }

    //Метод вычисления
    static int calc(int n){
        int count = 2; //Потому что 2 я уже загрузил
        ArrayList<Integer> primes = new ArrayList<>();
        //Взято из имеющихся данных, поэтому рассматриваются числа >=4
        primes.add(2);
        primes.add(3);
        for(int i = 4; i<=n; i++){
            //Проверяем четность
            if(i%2==0){
                //k=i/2-i
                count+=i/2-1;
            } else {
                //Если число не является четным, тогда оно нечетное
                count+=(i-1)/2-1;
                //Случай, когда нельзя представить в виде двух простых чисел
                if(i!=(primes.get(primes.size()-1)+2)){
                    count--;
                }
                //Случай, когда число простое
                if(prime_or_not(i,primes)){
                    count++;
                    primes.add(i);
                }
            }
        }
        return count;
    }


    //Ответ 76557778
    public static void main(String[] args){
        System.out.println(calc(17502));
    }
}
