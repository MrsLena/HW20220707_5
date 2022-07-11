package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {



        /*Дан map<Author, List<Book>> (например, сформированный в задаче №3). Но в него вкрались ошибки,
        в список книг некоторых авторов попали книги, которые они не писали.
                Необходимо:
        a)      написать метод, который проверит, есть ли в map такие ошибки.
        b)      написать метод, который исправит ошибки в исходном map.*/

        Author a1 = new Author("Avtor","11");
        Author a2 = new Author("Avtor","22");
        Author a3 = new Author("Avtor","33");
        Author a4 = new Author("Avtor","44");
        Author a5 = new Author("Avtor","55");

        ArrayList<Author> AllAuthors = new ArrayList<>();
        AllAuthors.add(a1);
        AllAuthors.add(a2);
        AllAuthors.add(a3);
        AllAuthors.add(a4);
        AllAuthors.add(a5);

        ArrayList<Author> GroupAuthor2 = new ArrayList<>();
        GroupAuthor2.add(a1);
        GroupAuthor2.add(a2);

        ArrayList<Author> GroupAuthor3 = new ArrayList<>();
        GroupAuthor3.add(a1);
        GroupAuthor3.add(a3);

        ArrayList<Author> GroupAuthor4 = new ArrayList<>();
        GroupAuthor4.add(a1);
        GroupAuthor4.add(a4);

        ArrayList<Author> GroupAuthor5 = new ArrayList<>();
        GroupAuthor5.add(a1);
        GroupAuthor5.add(a5);

        ArrayList<Author> GroupAuthor6 = new ArrayList<>();
        GroupAuthor6.add(a5);


        ArrayList<Book> SpBook = new ArrayList<>();
        SpBook.add(new Book("Произведение1",AllAuthors,"10001"));
        SpBook.add(new Book("Произведение2",GroupAuthor2,"10002"));
        SpBook.add(new Book("Произведение3",GroupAuthor3,"10003"));
        SpBook.add(new Book("Произведение4",GroupAuthor4,"10004"));
        SpBook.add(new Book("Произведение5",GroupAuthor5,"10005"));
        SpBook.add(new Book("Произведение6",GroupAuthor6,"10006"));
        SpBook.add(new Book("Произведение7",GroupAuthor6,"10007"));


        Map<Author, ArrayList<Book>> map = new HashMap<>();

        //put elements to MAP
        //for each
        for (Author a: AllAuthors) {
            ArrayList<Book> BooksOfAuthor = new ArrayList<>();
            for (Book b: SpBook) {
                BooksOfAuthor.add(b);
            }
            map.put(a, BooksOfAuthor);
        }


        //method of mistakes
        Set<Map.Entry<Author, ArrayList<Book>>> element = map.entrySet();
        for(Map.Entry<Author, ArrayList<Book>> pair: element) {
            //only check
            CheckAuthor(pair.getKey(),pair.getValue(),false);
            //find mistakes  and delete
            CheckAuthor(pair.getKey(),pair.getValue(),true);
            //print
            PrintInfo(pair.getKey(),pair.getValue());
        }

    }

    public static void CheckAuthor(Author TekAuthor, ArrayList<Book> SpBook,Boolean NeedDelete) {
        //надо проверить для каждой книги, которые псть у автора: есть ли у книги в группе авторов такой автор
        Iterator<Book> bookIterator = SpBook.iterator();
        //проверим список авторов на совпадение - и удалим
        while(bookIterator.hasNext()) {

            Book nextBook = bookIterator.next();//получаем следующий элемент

            int indAuthor = nextBook.authors.indexOf(TekAuthor);
            //if dont find - delete book from spbook
            if (indAuthor==-1) {
                if (NeedDelete==true) {
                    bookIterator.remove();
                }
                else {
                  System.out.println("Author " + TekAuthor.fName + " " + TekAuthor.lName + " don't write a book " + nextBook);
                }
            }

        }



    }

    public static void PrintInfo(Author a, ArrayList<Book> sp){
        System.out.println("------" + a.toString() + " write a books: ");

        for (Book tt : sp) {
            System.out.println(tt.toString());
        }

        System.out.println("------");
    }
}
