package com.codemerchant.sufficient365.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class MyCrops {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private User user;
	private String cropToPlant;
	private String type;
	private LocalDate minGerminationDate;
	private LocalDate maxGerminationDate;
	private LocalDate minHarvestDate;
	private LocalDate maxHarvestDate;

	public MyCrops(User user, Crop crop) {
		this.user = user;
		this.cropToPlant = crop.getCrop();
		this.type = crop.getType();
		this.minGerminationDate = LocalDate.now().plusDays(crop.getGerminationDaysMin());
		this.maxGerminationDate = LocalDate.now().plusDays(crop.getGerminationDaysMax());
		this.minHarvestDate = LocalDate.now().plusDays(crop.getDaysToHarvestMin());
		this.maxHarvestDate = LocalDate.now().plusDays(crop.getDaysToHarvestMax());

	}

}
