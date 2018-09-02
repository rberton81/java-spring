package com.springmvc.demo.bo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonView;
import com.springmvc.demo.dto.UserDTO;

public class AjaxResponseBody {

	@JsonView(Views.Public.class)
	String msg;

	@JsonView(Views.Public.class)
	String code;

	@JsonView(Views.Public.class)
	UserDTO result;

	// getters and setters
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public UserDTO getResult() {
		return result;
	}

	public void setResult(UserDTO result) {
		this.result = result;
	}

}
