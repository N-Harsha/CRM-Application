package com.ennea.valuemanage.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Comment extends BaseEntity{
    String name;
    String text;
    Date date;


    Comment(Long id, String name, String text, Date date){
        super(id);
        this.name=name;
        this.text=text;
        this.date=date;
    }

}
