public class Arr_Sorts {
    private int[] Array;
    private int Size = 0;
    public Arr_Sorts(int l) {
        Array = new int[l];
    }

    public void display(){
        for (int i=0; i<Size; i++)
            System.out.print(Array[i]+" ");
        System.out.println("");
    }

    public void insert(int value){
        Array[Size++] = value;
    }

    public void quicksort(){
        Inquick(0, Size-1);
    }

    public void insert_sort(){
        int tmp;
        for (int i = 1; i < Size; i++){
            tmp = Array[i];
            int j = i-1;
            while (j>=0 && Array[j]>tmp ){
                Array[j+1] = Array[j--];
            }
            Array[j+1] = tmp;

        }
    }



   private void Inquick(int left, int right){
        if (right-left <= 0)
            return;
        int partition = partition(left, right, Array[right]);
        Inquick(left, partition-1);
        Inquick(partition+1, right);
    }

    private int partition(int left, int right, int pivot){
        int leftptr = left;
        int rightptr = right-1;
        while(true) {
            while (Array[++leftptr] < pivot) ;
            while (Array[--rightptr] > pivot) ;
            if (rightptr <= leftptr)
                break;
            else {
                swap(leftptr,rightptr);
            }
        }
        swap(leftptr, right-1);
        return leftptr;
    }

    private int median(int left, int right){
        int med = (left + right)/2;
        if (Array[left] > Array[med])
            swap(left, med);
        if (Array[left] > Array[right])
            swap(left, right);
        if (Array[med] > Array[right])
            swap(med, right);
        swap(med, right-1);
        return right-1;
    }       


    public void Shell_sort(){
        InShell();
    }


    private void InShell(){
        int inner;
        int outer;
        int tmp;
        int h=1;      //Шаг сортировки Шелла (для приращения)
        while (h <= Size/3) {
            h = 3*h + 1;
        }
        while (h>0){
            for (outer = h; outer<Size; outer++){
                tmp = Array[outer];
                inner = outer;
                while (inner-h >= 0 && Array[inner-h] >= tmp){
                    Array[inner] = Array[inner-h];
                    inner -= h;
                }
                Array[inner] = tmp;
            }
            h = (h-1)/3;
        }
    }

    private void swap(int x, int y){
        int tmp = Array[x];
        Array[x] = Array[y];
        Array[y] = tmp;
    }
}
