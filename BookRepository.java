package com.itvedant.repositories;

import java.util.Collection;
import com.itvedant.models.Book;

public interface BookRepository {
	public Book addStudnt(Book book);
	public Collection<Book> getAllBooks();
	public Book getBookById(int id) throws Exception;
	public void deleteBookById(int id) throws Exception;
	public Book updateStudentById(Book book) throws Exception;
}
