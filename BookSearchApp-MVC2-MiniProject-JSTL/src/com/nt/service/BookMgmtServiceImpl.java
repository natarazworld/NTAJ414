package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.bo.BookDetailsBO;
import com.nt.dao.BookDAO;
import com.nt.dao.BookDAOImpl;
import com.nt.dto.BookDetailsDTO;

public class BookMgmtServiceImpl implements BookMgmtService {
	private BookDAO dao;
	
	public  BookMgmtServiceImpl() {
		dao=new BookDAOImpl();
	}

	@Override
	public List<BookDetailsDTO> searchBooksByCategory(String category) throws Exception {
		//use DAO
		List<BookDetailsBO> listBO=dao.getBooksByCategory(category);
		//convert listBO to listDTO
		List<BookDetailsDTO> listDTO=new ArrayList();
		listBO.forEach(bo->{
			BookDetailsDTO dto=new BookDetailsDTO();
			dto.setBookId(bo.getBookId());
			dto.setBookName(bo.getBookName());
			dto.setCategory(bo.getCategory());
			dto.setAuthor(bo.getAuthor());
			dto.setPrice(bo.getPrice());
			dto.setStatus(bo.getStatus());
		     dto.setSerialNo(listDTO.size()+1);
		     listDTO.add(dto);
		});
		return listDTO;
	}//method

}//class
