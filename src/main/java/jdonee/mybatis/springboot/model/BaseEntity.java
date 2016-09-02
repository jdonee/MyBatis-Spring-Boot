package jdonee.mybatis.springboot.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

/**
 * 基础Entity
 * 
 * @author Frank.Zeng
 *
 */
@Data
public class BaseEntity {
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Transient
	private Integer page = 1;

	@Transient
	private Integer rows = 10;
}
