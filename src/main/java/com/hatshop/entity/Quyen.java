package com.hatshop.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Quyen")
public class Quyen implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2272899358635613062L;
	
	@Id
	private String maQuyen;
	
	@Column
	private String tenQuyen;

}
