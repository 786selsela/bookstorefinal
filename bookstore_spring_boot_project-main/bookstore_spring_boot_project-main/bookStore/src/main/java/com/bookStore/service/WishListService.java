package com.bookStore.service;

import java.util.List;

import com.bookStore.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.WishList;

@Service
public class WishListService {

	@Autowired
	private WishListRepository mybook;

	public void saveMyBooks(WishList book) {
		mybook.save(book);
	}

	public List<WishList> getAllMyBooks(){
		return mybook.findAll();
	}

	public void deleteById(int id) {
		mybook.deleteById(id);
	}
}