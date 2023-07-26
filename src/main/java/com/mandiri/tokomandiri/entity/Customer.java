package com.mandiri.tokomandiri.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    private  String customer_id;
    @Column(nullable = false)
    private String fullName;
    private String address;
    @Column(nullable = false)
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date birthDate;
    private Integer status;

}
