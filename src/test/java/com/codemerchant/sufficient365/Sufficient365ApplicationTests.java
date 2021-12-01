package com.codemerchant.sufficient365;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codemerchant.sufficient365.web.CropController;

@SpringBootTest
class Sufficient365ApplicationTests {

	@Autowired
	private CropController controller;
	
	@Test
	void contextLoads() {
	assertThat(controller).isNotNull();
	
	}

}
