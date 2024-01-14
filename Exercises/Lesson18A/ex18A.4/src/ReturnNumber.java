/*
Copyright Ann Barcomb and Emily Marasco, 2021
Licensed under GPL v3
See LICENSE.txt for more information.
*/

// Debug this code using the code provided in MainTest.
public class ReturnNumber {
    private int largest;
    private int smallest;
    private int middle;

    // Getter
    public int getMiddle() {
        return this.middle;
    }

    // Getter
    public int getLargest() {
        return this.largest;
    }

    // Getter
    public int getSmallest() {
        return this.smallest;
    }

    // Setter: replace the smallest number with a new number, reorder numbers
    public void setSmallest(int newNumber) {
        this.smallest = newNumber;
        if (this.smallest > this.middle) {
            int temp = this.middle;
            this.middle = this.smallest;
            this.smallest = temp;
        }
        if (this.middle > this.largest) {
            int temp = this.largest;
            this.largest = this.middle;
            this.middle = temp;
        }
        return;
    }

    // Setter: replace the middle number with a new number, reorder numbers
    public void setMiddle(int newNumber) {
        this.middle = newNumber;
        if (this.middle < this.smallest) {
            int temp = this.smallest;
            this.smallest = this.middle;
            this.middle = temp;
        }
        if (this.middle > this.largest) {
            int temp = this.largest;
            this.largest = this.middle;
            this.middle = temp;
        }
        return;
    }

    // Setter: replace the largest number with a new number, reorder numbers
    public void setLargest(int newNumber) {
        this.largest = newNumber;
        if (this.largest < this.middle) {
            int temp = this.middle;
            this.middle = this.largest;
            this.largest = temp;
        }
        if (this.middle < this.smallest) {
            int temp = this.smallest;
            this.smallest = this.middle;
            this.middle = temp;
        }
        return;
    }

    // Take three integers, order from largest to smallest and store.
    public void setAll(int one, int two, int three) {
        //1,2,3
        if (one >= two && two >= three) {
            this.largest = one;
            this.middle = two;
            this.smallest = three;
            return;
        }
        //2,1,3
        if (two >= one && one >= three) {
            this.largest = two;
            this.middle = one;
            this.smallest = three;
            return;
        }
        //3,2,1
        if (three >= two && two >= one) {
            this.largest = three;
            this.middle = two;
            this.smallest = one;
            return;
        }
        //2,3,1
        if (two >= three && three >= one){
            this.largest = two;
            this.middle = three;
            this.smallest = one;
            return;
        }
        //1,3,2
        if (one >= three && three >= two){
            this.largest = one;
            this.middle = three;
            this.smallest = two;
            return;
        }
        //3,1,2
        if (three >= one && one >= two){
            this.largest = three;
            this.middle = one;
            this.smallest = two;
            return;
        }
        this.largest = one;
        this.middle = two;
        this.smallest = three;
        return;
    }

    // Constructor
    public ReturnNumber(int one, int two, int three) {
        setAll(one, two, three);
    }
}