package com.wo.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class SimpleValueType {
    private int age;
    private Integer age2;
    private boolean flag;
    private Boolean flag2;
    private char aChar;
    private Character aChar2;
    private SeasonEnum seasonEnum;
    private String username;
    private Class aClass;
    private Date date;
}
