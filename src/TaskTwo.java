import java.util.Arrays;

class TaskTwo {

    static boolean def(int num){
        String[] arr1;
        String[] arr2;
        int [] sor1;
        int [] sor2;

        //записываю в массив отделенные числа в формате String
        arr1 = Integer.toString(num*2).split("");
        arr2 = Integer.toString(num*5).split("");

        //код будет выполняться только в случае, если при умножении длина чисел будет одинаковой
        if(arr1.length==arr2.length) {
            //инициализация массива типа int для хранения чисел
            sor1 = new int[arr1.length];
            sor2 = new int[arr2.length];

            //заполнение массива значениями
            for (int i = 0; i<arr1.length; i++){
                sor1[i] = Integer.parseInt(arr1[i]);
                sor2[i] = Integer.parseInt(arr2[i]);
            }

            //Сортировка массива
            Arrays.sort(sor1);
            Arrays.sort(sor2);

            //Проверка на равенство упорядоченных массивов переведенных в строку
            if(Arrays.toString(sor1).equals(Arrays.toString(sor2))){
                //System.out.println(Integer.toString(num*2)+" "+Integer.toString(num*5));
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    //метод для вычисления числа в интервале
    static int calc(int x1, int x2){
        int count = 0;
        for(int x=x1;x<=x2;){
            while (def(x)==false){
                x++;
            }
            count=x;
            break;

        }
        return count;
    }


    public static void main(String[] args){
        //Как максимальное значение берется максимальное значение Integer
        System.out.println(calc(1,Integer.MAX_VALUE));
    }
}
