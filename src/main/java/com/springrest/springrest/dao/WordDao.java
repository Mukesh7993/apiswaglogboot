package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entities.Word;


public interface WordDao extends JpaRepository<Word, Long>  {

}
