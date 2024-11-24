package com.itvedant.services;

import java.util.Collection;
import java.util.LinkedHashMap;

import com.itvedant.models.Book;
import com.itvedant.repositories.BookRepository;


public class BookService implements BookRepository {
	private LinkedHashMap<Integer, Book> books = new LinkedHashMap<>();
	
	public Book addBook(Book book) {
		books.put(book.getId(), book);
		return books.get(book.getId());
	}
	
	public Collection<Book> getAllBooks() {
		return this.books.values();
	}
	
	public Book getBookById(int id) throws Exception {
		Book bk = books.get(id);
		if (bk != null) 
			return bk;
		else
			throw new Exception("invalid id");
	}
	
	public void deleteBookById(int id) throws Exception  {
		Book bk = getBookById(id);
		books.remove(id);
	}
	
	public Book updateStudentById(Book book)   {
		books.put(book.getId(), book);
		return books.get(book.getId());
	}

	@Override
	public Book addStudnt(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	public Book updateBookById(Book book) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
