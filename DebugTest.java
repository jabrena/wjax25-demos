public class DebugTest {
    public static void main(String[] args) {
        long cardNumber = 4012888888881881L;
        System.out.println("Card number: " + cardNumber);
        
        // Convert to digits
        java.util.List<Integer> digits = new java.util.ArrayList<>();
        long n = cardNumber;
        while (n > 0) {
            digits.add(0, (int)(n % 10));
            n = n / 10;
        }
        System.out.println("Digits: " + digits);
        
        // Double every other from right
        java.util.List<Integer> doubled = new java.util.ArrayList<>();
        for (int i = 0; i < digits.size(); i++) {
            int digit = digits.get(i);
            if ((digits.size() - 1 - i) % 2 == 1) {
                doubled.add(digit * 2);
            } else {
                doubled.add(digit);
            }
        }
        System.out.println("Doubled: " + doubled);
        
        // Sum all digits
        int sum = 0;
        for (int num : doubled) {
            int temp = Math.abs(num);
            while (temp > 0) {
                sum += temp % 10;
                temp = temp / 10;
            }
        }
        System.out.println("Sum: " + sum);
        System.out.println("Valid: " + (sum % 10 == 0));
    }
}