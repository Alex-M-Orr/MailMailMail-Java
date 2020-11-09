package com.m3.dao;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface DaoContract<T, I> {
	List<T> findAll();

	T findById(I i);

	T update(T t);

	T save(T t);

	T delete(I i);
}