package j1.s.p0020;

public class Main {

    public static void main(String[] args) {
        ValidateInput IntegerNumber = new ValidateInput();

        //khoi tao va Nhap mang
        int n = IntegerNumber.CheckInt("Enter number of array: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = IntegerNumber.CheckInt("Enter a[" + i + "]: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        //in ra mang chua sort
        System.out.print("Unsorted array: [");
        
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[a.length - 1] + "]");

        //ham selection sort
        int temp;
        for(int i = 0; i < a.length; i++)  
       {  
           for(int j = i + 1; j < a.length; j++)  
           {  
               if(a[i] > a[j])  
               {  
                   temp = a[i];  
                   a[i] = a[j];  
                   a[j] = temp;  
               }  
           }  
       }  
       
        System.out.print("Sorted array: [");
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[a.length - 1] + "]");
    }
}
