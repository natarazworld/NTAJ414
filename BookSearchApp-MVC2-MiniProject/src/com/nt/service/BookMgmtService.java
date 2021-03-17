package com.nt.service;

import java.util.List;

import com.nt.dto.BookDetailsDTO;

public interface BookMgmtService {
    public List<BookDetailsDTO>  searchBooksByCategory(String category)throws Exception;
}
