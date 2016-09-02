package jdonee.mybatis.springboot.service;

import java.util.List;

import jdonee.mybatis.springboot.model.UserInfo;

/**
 * 
 * @author Frank.Zeng
 *
 */
public interface UserInfoService {

	public List<UserInfo> getAll(UserInfo UserInfo);

	public UserInfo getById(Integer id);

	public void deleteById(Integer id);

	public void save(UserInfo country);
}
