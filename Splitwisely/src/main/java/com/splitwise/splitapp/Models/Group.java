package com.splitwise.splitapp.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Table(name="groups")
public class Group implements Serializable{
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long groupId;

    @Column(name = "groupname")
    String groupName;

    @Column(name = "description")
    String description;

	@OneToOne
	@JoinColumn(name="admin")
    User admin;

	@Column(name="expense")
	@ElementCollection(targetClass=Expense.class)
	Set<Expense> expenses;

	@Column(name="participants")
	@ElementCollection(targetClass=User.class)
	Set<User> participants;

	@Column(name="date")
	Date date;
}