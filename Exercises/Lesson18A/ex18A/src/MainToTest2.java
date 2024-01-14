public class MainToTest2 {
    //Take 2 integers. Subtract the product from the sum
    //Return this number if it is positive
    //If it is below -8, return 0.
    //Otherwise, subtract the sum from the product and return that value
    public static int subtractProductSum(int first, int second){
        int product = first * second;
        int sum = first + second;
        int result = sum - product;

        if (result > 0)
            return result;
        else if (result < -8)
            return 0;
        else
            return product - sum;
    }

    public static void main(String[] args){

        //what if one or both of the values are zero
        System.out.print("0, 3 should give 3. Gave: ");
        System.out.println(subtractProductSum(0, 3));

        // One positive and one negative integer
        System.out.print("-5, 3 should give 13. Gave: ");
        System.out.println(subtractProductSum(-5, 3));

        // Result is exactly -8
        System.out.print("-8, 0 should give 8. Gave: ");
        System.out.println(subtractProductSum(-8, 0));

        // Identical positive integers
        System.out.print("10, 10 should give 0. Gave: ");
        System.out.println(subtractProductSum(10, 10));

        // Identical negative integers
        System.out.print("-10, -10 should give 0. Gave: ");
        System.out.println(subtractProductSum(-10, -10));
    }
}
