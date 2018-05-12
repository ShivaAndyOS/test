package com.invia.serveasy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "manufactures")
public class Manufacture{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manufacture_id;

    @NotNull
    @Lob
    private String manufacture_name;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "ref_id")
    private List<Media> urls = new ArrayList<Media>();

	public Long getId() {
		return manufacture_id;
	}

	public void setId(Long id) {
		this.manufacture_id = id;
	}

	public String getManufacture_name() {
		return manufacture_name;
	}

	public void setManufacture_name(String manufacture_name) {
		this.manufacture_name = manufacture_name;
	}

	public List<Media> getUrls() {
		return urls;
	}

	public void setUrls(List<Media> urls) {
		this.urls = urls;
	}    
}