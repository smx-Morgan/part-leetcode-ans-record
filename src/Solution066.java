public class Solution066 {
    public static void main(String[] args) {
        int[] a = new int[2];
        a[0] = 8;
        a[1] = 9;
        int[] test_sl = plusOne(a);
        for (int i = 0; i < test_sl.length; i++) {
            System.out.println(test_sl[i]);
        }
    }
    public static int[] plusOne(int[] digits) {
        int last = digits[digits.length - 1];
        if(last != 9 ){
            last = last +1;
            digits[digits.length - 1] = last;
            return digits;
        }else{
            int[] arr = new int[digits.length+1];
            for(int i = digits.length-1; i >= 0;i--){
                if (digits[i] < 9) {
                    digits[i] = digits[i] + 1;
                    return digits;
                } else {
                    digits[i] = 0;
                    continue;
                }
            }
            arr[0] = 1;
            return arr;
        }
    }
}
