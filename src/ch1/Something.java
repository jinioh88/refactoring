package ch1;

public class Something {
    public static final int MAX_INPUT_LENGTH = 100;

    private void test(String input) {
//        if(100 < input.length())  // 냄새나는 코드
        if(MAX_INPUT_LENGTH < input.length()) {

        }
    }
}
