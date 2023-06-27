package com.splitwise.splitapp.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
// import java.util.Set;

// import javax.persistence.CascadeType;
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

// import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Table(name="expenses")
public class Expense implements Serializable{
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long expenseId;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

	@OneToOne
	@JoinColumn(name="createdBy")
    User createdBy;

	@Column(name="participants")
	@ElementCollection(targetClass=Long.class)
	List<Long> participants;

	@Column(name="totalAmount")
	Double totalAmount;

	@Column(name="date")
	Date date;

	@Column(name="amountOwned")
	HashMap<User, Double> amountOwned;

	@Column(name="amountPaid")
	HashMap<User, Double> amountPaid;
}
