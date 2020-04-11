package ch6;

public class Book {
    private String title;
    private String isbn;
    private String price;
    private String authorName;
    private String authorMail;

    public Book(String title, String isbn, String price, String authorName, String authorMail) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.authorName = authorName;
        this.authorMail = authorMail;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPrice() {
        return price;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorMail() {
        return authorMail;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorMail(String authorMail) {
        this.authorMail = authorMail;
    }

    public String toXml() {
        String author =
                tag("author", tag("name", authorName) + tag("mail", authorMail));
        String book =
                tag("book", tag("title", title) + tag("isbn", isbn) + tag("price", price) + author);
        return book;
    }
    private String tag(String element, String content) {
        return "<" + element + ">" + content + "</" + element + ">";
    }
}
