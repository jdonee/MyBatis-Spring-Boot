package jdonee.mybatis.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import jdonee.mybatis.springboot.mapper.UserInfoMapper;
import jdonee.mybatis.springboot.model.UserInfo;

/**
 * 
 * @author Frank.Zeng
 *
 */
@Component
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper mapper;

	public List<UserInfo> getAll(UserInfo UserInfo) {
		if (UserInfo.getPage() != null && UserInfo.getRows() != null) {
			PageHelper.startPage(UserInfo.getPage(), UserInfo.getRows(), "id");
		}
		return mapper.selectAll();
	}

	@Override
	public UserInfo getById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteById(Integer id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void save(UserInfo country) {
		if (country.getId() != null) {
			mapper.updateByPrimaryKey(country);
		} else {
			mapper.insert(country);
		}
	}
}
