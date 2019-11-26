package com.generation.libraryjpa.view;
import java.util.List;

import com.generation.libraryjpa.model.entities.Author;
import com.generation.libraryjpa.model.entities.Book;

public interface AuthorView {

	String render(Author author);

	String render(Book book);

	String render(List<Author> list);

}