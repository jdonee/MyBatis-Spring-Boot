/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package jdonee.mybatis.springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * mybatis 3.3.1新功能测试使用
 * 
 * @author Frank.Zeng
 *
 */
@Data
@NoArgsConstructor(force = true)
public class City2 {

	private Integer id;

	private String cityName;

	private String cityState;

	public City2(String cityName, String cityState) {
		this.cityName = cityName;
		this.cityState = cityState;
	}

	@Override
	public String toString() {
		return "City2{" + "id=" + id + ", cityName='" + cityName + '\'' + ", cityState='" + cityState + '\'' + '}';
	}
}
