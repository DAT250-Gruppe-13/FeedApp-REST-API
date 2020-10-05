package no.hvl.dat250.FeedApp.Models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "polls")
public class Poll {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;

	@Column(name = "description")
	private String description;
	@Column(name = "timeLimit")
	private Date timeLimit;
	@Column(name = "code")
	private String code;
	@Column(name = "privat")
	private boolean privat;

	@ManyToOne
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private User user;

	@JsonIgnore
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "poll", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Vote> votes;

}
