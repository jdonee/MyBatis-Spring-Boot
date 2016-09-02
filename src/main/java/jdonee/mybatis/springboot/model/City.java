
package jdonee.mybatis.springboot.model;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 城市信息
 * 
 * @author Frank.Zeng
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class City extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String state;

}
