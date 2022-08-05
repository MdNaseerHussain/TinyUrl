package com.naseer.tinyurl.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UrlPairModel {
    
    @Id
    @GeneratedValue
    private BigInteger id;
    private String longUrl, tinyUrl;
    
    public BigInteger getId() {
        return id;
    }
    public void setId(BigInteger id) {
        this.id = id;
    }
    public String getLongUrl() {
        return longUrl;
    }
    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
    public String getTinyUrl() {
        return tinyUrl;
    }
    public void setTinyUrl(String tinyUrl) {
        this.tinyUrl = tinyUrl;
    }
    
    public UrlPairModel(BigInteger id, String longUrl, String tinyUrl) {
        this.id = id;
        this.longUrl = longUrl;
        this.tinyUrl = tinyUrl;
    }
   
    public UrlPairModel() {
        super();
    }
    
}
