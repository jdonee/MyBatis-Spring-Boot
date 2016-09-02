package jdonee.mybatis.springboot.service;

import java.util.List;

import jdonee.mybatis.springboot.model.Country;

/**
 * @author liuzh
 * @since 2015-12-19 11:09
 */
public interface CountryService {

	public List<Country> getAll(Country country);

	public Country getById(Integer id);

	public void deleteById(Integer id);

	public void save(Country country);
}
