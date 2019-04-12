package handson;

public class subsets {
	public static void main(String []args){
        int array[]={3,8,1};
        //findsubsets(arr);
        int numOfSubsets = 1 << array.length;
        System.out.println(numOfSubsets);
        System.out.println(array.length<<1);
        for (int i = 0; i < numOfSubsets; i++) {
            int pos = 0;
            int bitmask = i;

            System.out.print("{");
            while (bitmask > 0) {
                if ((bitmask & 1) == 1)
                    System.out.print(array[pos] + ",");
                    //System.out.print("/"+bitmask+"/");
                 bitmask >>= 1;
                pos++;
        }
        System.out.println("}");
    }
        //System.out.println("Hello World");
     //}
}

}
