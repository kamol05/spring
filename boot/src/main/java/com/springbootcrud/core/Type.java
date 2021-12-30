package com.springbootcrud.core;

import com.springbootcrud.core.coreim.TypeIMPL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Type implements TypeIMPL {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
