package no.hvl.dat250.FeedApp.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name="votes")
public class Vote {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
	 	@Column(name = "value")
	    private boolean value;

	    @ManyToOne
	    private User user;

	    @ManyToOne
	    private Poll poll;
	
	
	
	

}
