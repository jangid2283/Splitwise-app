package com.splitwise.splitapp.Models;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long userId;

    @Column(name = "userName")
    String userName;

    @Column(name = "phone")
    String phoneNumber;

	@Column(name = "password")
    String password;

	@Column(name="expenses")
	@ElementCollection(targetClass=Expense.class)
	List<Expense> expenses;

	@Column(name="groups")
	@ElementCollection(targetClass=Group.class)
	Set<Group> groups;

}
