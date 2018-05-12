package com.invia.serveasy.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "media")
public class Media{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long media_id;

    @NotNull
    @Lob
    private String media_name;

    @NotNull
    private int media_type;

    @NotNull
    private String media_url;

    /*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Manufacture manufacture_id;*/
    
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacture_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore*/
    private long ref_id;
    private int ref_type;
	public Long getMedia_id() {
		return media_id;
	}
	public void setMedia_id(Long media_id) {
		this.media_id = media_id;
	}
	public String getMedia_name() {
		return media_name;
	}
	public void setMedia_name(String media_name) {
		this.media_name = media_name;
	}
	public int getMedia_type() {
		return media_type;
	}
	public void setMedia_type(int media_type) {
		this.media_type = media_type;
	}
	public String getMedia_url() {
		return media_url;
	}
	public void setMedia_url(String media_url) {
		this.media_url = media_url;
	}
	public long getRef_id() {
		return ref_id;
	}
	public void setRef_id(long ref_id) {
		this.ref_id = ref_id;
	}
	public int getRef_type() {
		return ref_type;
	}
	public void setRef_type(int ref_type) {
		this.ref_type = ref_type;
	}
    
    
}