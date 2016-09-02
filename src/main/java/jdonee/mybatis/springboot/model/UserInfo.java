package jdonee.mybatis.springboot.model;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户信息
 * 
 * @author Frank.Zeng
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserInfo extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String usertype;
	private Integer enabled;
	private String qq;
	private String email;
	private String tel;
}
