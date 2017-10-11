import java.util.ArrayList;
import java.util.Collections;

public class TaskFour {

    static int cycle(){
        //Инициализируем два ArrayList для хранения последовательностей
        ArrayList<Integer> unsortArr = new ArrayList<Integer>();
        ArrayList<Integer> sortArr = new ArrayList<Integer>();

        /**
        *Код для проверки по условию для 1<a<6 & 1<b<6
        *должна равнятся 15, значения совпали
        for(int i = 2; i < 6; i++){
            for (int j=2; j<6; j++){
                unsortArr.add((int)Math.pow(i,j));
            }
        }
        */

        /**создаем массив для хранения последовательности a^b с повторениями
         * начинаем перебирать с 3 т.к. 2 не входит в условие
         */
        for(int i = 3; i < 142; i++){
            for (int j=3; j < 106; j++){
                unsortArr.add((int)Math.pow(i,j));
            }
        }

        //сортируем наш массив
        Collections.sort(unsortArr);

        /**начальный элемент будет в любом случае будет отобран
         * поэтому поместим его в массив исключающий повторения
         */
        sortArr.add(unsortArr.get(0));

        /**перебор "сырого" массива сравниваем его с предыдущим
         * элементом, загруженным в исключающий повторения массив,
         * если он не был записан ранее, то записываем
         */
        for (int i = 1; i<unsortArr.size();i++){
            if(unsortArr.get(i)!=sortArr.get(sortArr.size()-1)){
                sortArr.add(unsortArr.get(i));
            }
        }
        /**возвращаем колличество элементов в отобранном массиве
         * это и есть показатель уникальных чисел
         */
        return sortArr.size();

    }

    public static void main(String[] args){
        //Напишем результат
        //result = 14317
        System.out.println("result = "+cycle());
    }
}
