/*
 *
 *  * AzureIiotApplication.java Copyright (C) 2025 NTT Global Data Centers. All rights reserved.
 *
 *
 */

package com.ntt.gdc.azureiiot;

import com.ntt.gdc.azureiiot.configuration.CustomerConfig;
import com.ntt.gdc.azureiiot.configuration.KeyVaultPropertyProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfig.class)
@Slf4j
public class AzureIiotApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AzureIiotApplication.class);
		// Run processor *after* Key Vault secrets are available
		app.addListeners((ApplicationListener<ApplicationReadyEvent>) event -> {
			log.info("🔹 Running KeyVaultPropertyProcessor (post-KeyVault)...");
			new KeyVaultPropertyProcessor().postProcessEnvironment(
					event.getApplicationContext().getEnvironment(),
					event.getSpringApplication()
			);
		});
		app.run(args);
	}
}
