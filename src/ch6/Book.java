package ch6;

public class Book {
    private String title;
    private String isbn;
    private String price;

    private Author author;

    public Book(String title, String isbn, String price, String authorName, String authorMail) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        author = new Author(authorName, authorMail);
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
        return author.getName();
    }

    public String getAuthorMail() {
        return author.getMail();
    }

    public void setAuthorName(String authorName) {
        author.setName(authorName);
    }

    public void setAuthorMail(String authorMail) {
        author.setMail(authorMail);
    }

    public String toXml() {
        String author =
                tag("author", tag("name", getAuthorName()) + tag("mail", getAuthorMail()));
        String book =
                tag("book", tag("title", title) + tag("isbn", isbn) + tag("price", price) + author);
        return book;
    }
    private String tag(String element, String content) {
        return "<" + element + ">" + content + "</" + element + ">";
    }
}
