package com.shalini.rest.webservice.restfulwebservices.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("field3") //class level annotation for
//doing static filtering of fields [comma separated array of field name]
//@JsonIgnoreProperties({"field3","field2"})
@JsonFilter("somebeanfilter")
public class SomeBean {
 private String field1;
 @JsonIgnore // static filtering field Level ANNOTATION FOR FILTERING OUT FIELDS
 private String field2;
 private String field3;
 private String field4;
 private String field5;
public SomeBean(String field1, String field2, String field3) {
	super();
	this.field1 = field1;
	this.field2 = field2;
	this.field3 = field3;
}


public SomeBean(String field1, String field2, String field3, String field4, String field5) {
	super();
	this.field1 = field1;
	this.field2 = field2;
	this.field3 = field3;
	this.field4 = field4;
	this.field5 = field5;
}


/**
 * @return the field4
 */
public String getField4() {
	return field4;
}


/**
 * @param field4 the field4 to set
 */
public void setField4(String field4) {
	this.field4 = field4;
}


/**
 * @return the field5
 */
public String getField5() {
	return field5;
}


/**
 * @param field5 the field5 to set
 */
public void setField5(String field5) {
	this.field5 = field5;
}


/**
 * @return the field1
 */
public String getField1() {
	return field1;
}
/**
 * @param field1 the field1 to set
 */
public void setField1(String field1) {
	this.field1 = field1;
}
/**
 * @return the field2
 */
public String getField2() {
	return field2;
}
/**
 * @param field2 the field2 to set
 */
public void setField2(String field2) {
	this.field2 = field2;
}
/**
 * @return the field3
 */
public String getField3() {
	return field3;
}
/**
 * @param field3 the field3 to set
 */
public void setField3(String field3) {
	this.field3 = field3;
}
 
}
