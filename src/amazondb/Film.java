package amazondb;

package com.amazonaws.codesamples;

import java.util.Set;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="Films")
public class Film {

    private Integer id;
    private String title;
    private String Director;
    private Set<String> Actors;
    private String releaseDate;

    @DynamoDBHashKey(attributeName="Id")
    public Integer getId() { return id; }
    public void setId(Integer id) {this.id = id; }

    @DynamoDBAttribute(attributeName="Title")
    public String getTitle() {return title; }
    public void setTitle(String title) { this.title = title; }

    @DynamoDBAttribute(attributeName="Director")
    public String getISBN() { return Director; }
    public void setISBN(String Director) { this.Director = Director; }

    @DynamoDBAttribute(attributeName="Actors")
    public Set<String> getBookAuthors() { return Actors; }
    public void setBookAuthors(Set<String> Actors) { this.Actors = Actors; }
    
    @DynamoDBAttribite(attributeName="releaseDate")
    public String getSomeProp() { return releaseDate; }
    public void setSomeProp(String someProp) { this.releasaeDAte = releaseDate; }
}
