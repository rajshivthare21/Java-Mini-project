package com.itvedant.test;

import java.util.Collection;
import java.util.Scanner;

import com.itvedant.models.Book;
import com.itvedant.services.BookService;

public class BookTest {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BookService service = new BookService();
		int i;
		String n,b;
		double p;
		
		while(true) {
			System.out.println("//////Enter your choice:///////");
			System.out.println("1. Add new book\n2.List of all books\n3.View Book by id\n4. Delete book by id\n5.Update book by id\n6.Exit");
			int choice = sc.nextInt();
			switch(choice) {
			case 1: // add
				System.out.println("Enter the book id, name, author and price");
				i=sc.nextInt();
				n=sc.next();
				b=sc.next();
				p=sc.nextDouble();
				Book bk= new Book(i,n,b,p);
				service.addBook(bk);
				System.out.println("Book added successfully !!1");
				break;
			case 2: //List
				Collection<Book> allBooks = service.getAllBooks();
				allBooks.forEach(bok -> System.out.println(bok));
				break;
			case 3: //get by id
				System.out.println("enter the book id to view details");
				i = sc.nextInt();
				try {
					Book book = service.getBookById(i);
					System.out.println(book);
				} 
				catch (Exception e) {
					System.err.println("Please enter the valid book id");
				}						
				break;
			case 4: // delete
				System.out.println("enter the book id to delete details");
				i = sc.nextInt();
				try {
					service.deleteBookById(i);
					System.out.println("Book deleted successfully!!");
				} 
				catch (Exception e) {
					System.err.println("Please enter the valid book id");
				}
				break;
			case 5: // update
				System.out.println("enter the book id to update details");
				i = sc.nextInt();
				try {
					Book book = service.getBookById(i);
					System.out.println("The existing details are:");
					System.out.println(book);
					System.out.println("enter new name, author and price");
					n=sc.next();
					b=sc.next();
					p=sc.nextInt();
					book.setName(n);
					book.setAuthor(b);
					book.setPrice(p);
					Book updated = service.updateBookById(book);
					System.out.println("Updated book details are:");
					System.out.println(updated);
				} 
				catch (Exception e) {
					System.err.println("Please enter the valid book id");
				}
				break;
			case 6: // exit
				System.out.println("Thank you for using the LIBRARY MANAGEMENT App!!");
				System.out.println("Application will be closed.");
				System.exit(0);				
				break;
			default:
				System.err.println("Kindly enter the valid choice");		
			}
		}
		
	}
}

