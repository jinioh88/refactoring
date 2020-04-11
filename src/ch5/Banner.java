package ch5;

public class Banner {
    private final String content;

    public Banner(String content) {
        this.content = content;
    }

    public void print(int times) {
        // 테두리
        System.out.print("+");
        for(int i = 0; i < content.length(); i++) {
            System.out.print("-");
        }
        System.out.println("+");

        // 내용
        for(int i = 0; i < times; i++) {
            System.out.println("|" + content + "|");
        }

        // 테두리
        System.out.print("+");
        for(int i = 0; i < content.length(); i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
