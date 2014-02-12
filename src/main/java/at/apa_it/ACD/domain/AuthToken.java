package at.apa_it.ACD.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="authentification_tokens")
public class AuthToken extends BasePersistable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4872563746467975263L;
	
	@NotNull
	@Column(name="uqid", nullable=false, length=255)
	private String uqid;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	public AuthToken() {
		// TODO Auto-generated constructor stub
	}
	
	public AuthToken(String uqid, User user) {
		super();
		this.uqid = uqid;
		this.user = user;
	}

	public AuthToken(String uqid) {
		this.uqid = uqid;
	}

	public String getUqid() {
		return uqid;
	}

	public void setUqid(String uqid) {
		this.uqid = uqid;
	}
	
}
