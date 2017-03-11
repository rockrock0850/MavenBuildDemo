package com.promeritage.maven.common.vo;

import org.hibernate.validator.constraints.NotBlank;

public class RequestVO {
	/**
	 * 
	 */
	@NotBlank
    private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
