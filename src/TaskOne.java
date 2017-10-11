import java.util.Arrays;

class TaskOne {

    //метод определения замечательного числа
    static boolean def(int num) {
        String[] arr1;
        int sum = 0;
        int m=0;

        //записываю в массив отделенные числа в формате String
        arr1 = Integer.toString(num).split("");

        int[] arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            int dev = Integer.parseInt(arr1[i]);
            //System.out.println(Integer.valueOf(arr1[i])+" "+num);
            //нули не нужны
            if (dev > 0) {
                arr2[m]=dev;
                sum += dev;
                m++;
            }
        }
        //Длина массива без нулей
        int leng = arr2.length;

        //Если меньше 10, то неверно, число замечательное
        if(sum<10){
            return false;
        //если равно 10, то верно, условие выполняется, число замечательное
        } else if(sum==10){
            return true;
        } else {
            /**
             * Сравним сразу первые 2 числа и последниее 2, так как
             * если они больше 10, то заведомо число не замечательное
             * т.к. крайние числа ограничены в соседях, к тому же это сократит время
            */
            if(((arr2[0]+arr2[1])>10)||(arr2[arr2.length-1]+arr2[arr2.length-2]>10)) {
                return false;
            }

            /**
             * создаем двумерный массив и заполням диагональ значениями
             * из массива arr2
             */
            int[][] arr3 = new int[leng][leng];
            for(int i=0; i<leng;i++){
                 arr3[i][i] = arr2[i];
            }


            int[] arr4 = new int[leng];
            //перебор последовательности
            for (int i=0; i<leng-1;i++){
                for(int j=i; j<leng-1;j++){
                    //сумма следующей последовательности
                    arr3[i][j+1]=arr3[i][j]+arr3[j+1][j+1];

                    if (arr3[i][j+1]==10){
                        for (int k=i;k<=j+1;k++){
                            arr4[k]=arr3[k][k];
                        }
                        break;
                    }

                    else if(arr3[i][j+1]>10){
                        break;
                    }
                }
            }

            //Проверка
            if (Arrays.toString(arr4).equals(Arrays.toString(arr3))){
                return true;
            }

        }
        return false;
    }
    //метод подсчета замечальных чисел в интервале
    static int calc(int x1, int x2){
        int count = 0;
        for (int x = x1; x<=x2;x++){
            if(def(x)) {
                //System.out.println(x);
                count++;
            }
        }
        return count;
    }

    //Получается где-то 7078
    public static void main(String[] args){
        System.out.println(calc(1,4000000));
    }

}
