package com.codemerchant.sufficient365.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Crop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String crop;
	private String type;
	private String description;
	private String sowType;
	private String season;
	private int germinationDaysMin;
	private int germinationDaysMax;
	private int daysToHarvestMin;
	private int daysToHarvestMax;
	private String amountOfSun;
	private String commonPests;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	private User user;

	public Crop(String crop, String type, String description, String sowType, String season, int germinationDaysMin,
			int germinationDaysMax, int daysToHarvestMin, int daysToHarvestMax, String amountOfSun, String commonPests,
			User user) {
		this.crop = crop;
		this.type = type;
		this.description = description;
		this.sowType = sowType;
		this.season = season;
		this.germinationDaysMin = germinationDaysMin;
		this.germinationDaysMax = germinationDaysMax;
		this.daysToHarvestMin = daysToHarvestMin;
		this.daysToHarvestMax = daysToHarvestMax;
		this.amountOfSun = amountOfSun;
		this.commonPests = commonPests;
		this.user = user;
	}

	public Crop(String crop, String type, String description, String sowType, String season, int germinationDaysMin,
			int germinationDaysMax, int daysToHarvestMin, int daysToHarvestMax, String amountOfSun,
			String commonPests) {
		this.crop = crop;
		this.type = type;
		this.description = description;
		this.sowType = sowType;
		this.season = season;
		this.germinationDaysMin = germinationDaysMin;
		this.germinationDaysMax = germinationDaysMax;
		this.daysToHarvestMin = daysToHarvestMin;
		this.daysToHarvestMax = daysToHarvestMax;
		this.amountOfSun = amountOfSun;
		this.commonPests = commonPests;
	}
	
	

	



}
