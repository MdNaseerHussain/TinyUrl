package com.naseer.tinyurl.repository;

import java.math.BigInteger;

import com.naseer.tinyurl.model.UrlPairModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlPairRepository extends JpaRepository<UrlPairModel, BigInteger> {
    
    public UrlPairModel findByTinyUrl(String tinyUrl);
    public UrlPairModel findByLongUrl(String longUrl);

    public boolean existsByTinyUrl(String tinyUrl);
    public boolean existsByLongUrl(String longUrl);

}
