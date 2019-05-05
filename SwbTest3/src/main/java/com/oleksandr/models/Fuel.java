package com.oleksandr.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

//import com.oleksandr.models.Book;

/**
 * @author oleksandr
 *
 */
@Entity
public class Fuel implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	@TableGenerator(name = "ATH_GEN", allocationSize = 1)
	@Id
	@GeneratedValue(generator = "ATH_GEN")
	private int id;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "book_id")
//	private Book book;
//	private String book;
	private String type ;
	private BigDecimal price;
    private BigDecimal volume;
    private Date date;
    private int driverid;
    
    
    
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getVolume() {
		return volume;
	}
	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}
	public int getDriverid() {
		return driverid;
	}
	public void setDriverid(int driverid) {
		this.driverid = driverid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}