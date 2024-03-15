class Book {
    private String isbn;
    private int publicationYear;
    private int pages;

    public Book (){
    }

    public Book (String isbn, int pages){
        this.setIsbn(isbn);
        this.setPages(pages);
    }

    public String getIsbn(){
        return this.isbn;
    }

    public void setIsbn(String isbn){
        this.isbn =  isbn;
    }

    public int getPublicationYear(){
        return this.publicationYear;
    }

    public void setPublicationYear(int year){
        this.publicationYear = year;
    }

    public int getPages(){
        return this.pages;
    }

    public void setPages(int pages){
        this.pages = pages;
    }
}

//to be continued, too much effort


