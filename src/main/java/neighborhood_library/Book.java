package neighborhood_library;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private  String checkedOutTo;

    public Book(int id, String checkedOutTo, boolean isCheckedOut, String title, String isbn) {
        this.id = id;
        this.checkedOutTo = checkedOutTo;
        this.isCheckedOut = isCheckedOut;
        this.title = title;
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void checkOut(String name){
        this.isCheckedOut = true;
        this.checkedOutTo = name;
    }

    public void checkIn(){
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    public String toString(){
        return id + "|" + isbn + "|" + title;
    }
    public String toCheckedOutString(){
        return id + "|" + isbn + "|" + title + "| Checked out to:" + checkedOutTo;
    }
}
