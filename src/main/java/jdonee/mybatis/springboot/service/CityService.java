package jdonee.mybatis.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import jdonee.mybatis.springboot.model.City;

/**
 * 城市服务
 * 
 * @author Frank.Zeng
 *
 */
@Service
@Transactional
public class CityService extends BaseService<City, Integer> {

	@Transactional(readOnly = true)
	public List<City> getAll(City city) {
		if (city.getPage() != null && city.getRows() != null) {
			PageHelper.startPage(city.getPage(), city.getRows(), "id");
		}
		return mapper.selectAll();
	}

}
