package jdonee.mybatis.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import jdonee.mybatis.springboot.mapper.CountryMapper;
import jdonee.mybatis.springboot.model.Country;

/**
 * 
 * @author Frank.Zeng
 *
 */
@Component
@Transactional
public class CountryServiceimpl implements CountryService {

	@Autowired
	private CountryMapper countryMapper;

	@Transactional(readOnly = true)
	public List<Country> getAll(Country country) {
		if (country.getPage() != null && country.getRows() != null) {
			PageHelper.startPage(country.getPage(), country.getRows(), "id");
		}
		return countryMapper.selectAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Country getById(Integer id) {
		return countryMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteById(Integer id) {
		countryMapper.deleteByPrimaryKey(id);
	}

	public void save(Country country) {
		if (country.getId() != null) {
			countryMapper.updateByPrimaryKey(country);
		} else {
			countryMapper.insert(country);
		}
	}
}
