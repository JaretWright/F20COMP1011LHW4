public class Main {
    public static void main(String[] args) {
        String validPhone = "(555)433-1234";
        String invalidPhone = "1231231234";
        String phonePattern = "\\(?[2-9]\\d{2}\\)?[-\\s]?[2-9]\\d{2}[-\\s]?\\d{4}";

        System.out.printf("%s is a valid phone number: %b%n",validPhone,
                            validPhone.matches(phonePattern));
        System.out.printf("%s is a valid phone number: %b%n",invalidPhone,
                invalidPhone.matches(phonePattern));
    }
}
