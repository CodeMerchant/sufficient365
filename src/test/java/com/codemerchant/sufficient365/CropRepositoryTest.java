package com.codemerchant.sufficient365;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.codemerchant.sufficient365.domain.Crop;
import com.codemerchant.sufficient365.domain.CropRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CropRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private CropRepository cropRepository;

	@Test
	public void saveCrop() {
		Crop crop = new Crop("Chilli", "African Bird Eye", "An all season chilli with a strong heat index", "trays",
				"Spring", 14, 28, 90, 120, "full", "slugs, aphids, birds");

		entityManager.persistAndFlush(crop);
		assertThat(crop.getId()).isNotNull();
	}

	@Test
	public void deleteCrops() {
		entityManager
				.persistAndFlush(new Crop("Chilli", "African Bird Eye", "An all season chilli with a strong heat index",
						"trays", "Spring", 14, 28, 90, 120, "full", "slugs, aphids, birds"));
		cropRepository.deleteAll();

		assertThat(cropRepository.findAll());
	}
}
