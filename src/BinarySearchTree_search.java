public class BinarySearchTree_search {

    //sorted array
    static  int[] numArray = new int[]{9, 10, 14, 19, 26, 27, 31, 33, 35, 42, 44, 67, 72};
    static int lowerBound = 0;//Arrays in java start with index 0
    static int upperBound = numArray.length-1;
    static int mid = 0;


    public static void main(String[] args){
        System.out.println(findValueLocation(67));

    }

    /**
     * search using binary search tree
     * @param value whose index you want to find
     * @return the index of a given value
     */
    public  static int findValueLocation(int value){
        while(value != numArray[mid]){
            mid = lowerBound +(upperBound-lowerBound)/2;
            if (numArray[mid] == value){
                return mid; //return the index of the value
            }else{
                if(numArray[mid]<value){ //check on the  right side of the array
                    lowerBound = mid + 1;
                }else{ //check on the left side of the array
                    upperBound = mid - 1;
                }
            }

        }
        return mid;

    }
}
