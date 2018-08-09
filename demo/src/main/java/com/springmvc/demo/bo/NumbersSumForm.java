package com.springmvc.demo.bo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class NumbersSumForm {
	
	@NotNull
	@Min(0)
	@Max(10)
    private Integer number1;

	@NotNull
	@Min(100)
	@Max(999)
    private Integer number2;

	@NotNull
    private Integer sum;	

    private String message;	

	public NumbersSumForm() {
		// nothing
	}

	public Integer getNumber1() {
		return number1;
	}

	public void setNumber1(Integer number1) {
		this.number1 = number1;
	}

	public Integer getNumber2() {
		return number2;
	}

	public void setNumber2(Integer number2) {
		this.number2 = number2;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}