package com.nt.dao;

import java.util.List;

import com.nt.bo.BookDetailsBO;

public interface BookDAO {
    public List<BookDetailsBO>  getBooksByCategory(String category)throws Exception;
}
