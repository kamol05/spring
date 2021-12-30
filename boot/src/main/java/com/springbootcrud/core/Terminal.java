package com.springbootcrud.core;


import com.springbootcrud.core.coreim.*;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Terminal implements TerminalIMPL {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Step step;
    @Embedded
    private TypeIMPL type;
    private Date data;
}
