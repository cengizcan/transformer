package org.cengizcan.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.opencsv.bean.CsvBindByName;

@JsonRootName(value = "user")
public class CsvToJsonModel {
    @JsonProperty("first_name")
    @CsvBindByName(column = "first_name")
    private String firstName;

    @JsonProperty("last_name")
    @CsvBindByName(column = "surname")
    private String surName;

    @JsonProperty("age")
    @CsvBindByName(column = "age")
    private int age;

    @JsonProperty("favourite_colour")
    @CsvBindByName(column = "favourite_colour")
    private String favouriteColour;
}
