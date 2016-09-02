package jdonee.mybatis.springboot.model;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 国家
 * 
 * @author Frank.Zeng
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Country extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	// 名称
	private String countryname;
	// 代码
	private String countrycode;

}