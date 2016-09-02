package jdonee.mybatis.springboot.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tk.mybatis.mapper.common.Mapper;

@Service
@Transactional
public abstract class BaseService<T, PK extends Serializable> {

	@Autowired
	protected Mapper<T> mapper;

	public int save(T entity) {
		return mapper.insert(entity);
	}

	public int delete(PK id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Transactional(readOnly = true)
	public T getById(PK id) {
		return mapper.selectByPrimaryKey(id);
	}

}