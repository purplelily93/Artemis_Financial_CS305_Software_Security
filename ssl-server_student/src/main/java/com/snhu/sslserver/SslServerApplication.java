package com.snhu.sslserver;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.HexFormat;
import java.util.Random;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SuppressWarnings("unused")
@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

    /**
     * Simple controller that returns a checksum for a unique data string.
     *
     * Project Two requirement: demonstrate a "file verification" step using a checksum.
     * The /hash route returns:
     *  - Nicole Lumbert
     *  - a unique data string
     *  - the SHA-256 checksum (hex)
     *
     * Note: SHA-256 is a NIST-approved secure hash (not encryption) used for integrity verification.
     */
	
	@RestController
	static class ChecksumController {
		
		private static final SecureRandom RNG = new SecureRandom();
		
		@GetMapping("/hash")
		public String getHash() throws NoSuchAlgorithmException {
			
			String name = "Nicole Lumbert";
			
			String data = LocalDate.now()
					+ " | nonce" + new Random().nextInt(1000000000)
					+" | vvid=" + UUID.randomUUID();
			
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hashBytes = digest.digest(data.getBytes(StandardCharsets.UTF_8));
			
			StringBuilder hexString = new StringBuilder();
			for (byte b: hashBytes) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			
			String hash = hexString.toString();
			
			return "<pre>"
					+"Name: " + name + "\n"
					+ "Unique String: " + data + "\n"
					+"Hash (SHA-256): " + hash
					+"<pre>";
		}
		private static String buildUniqueDataString(String name) {
			//A small random compnent + UUID reduces the change of collisions.
			int nonce = RNG.nextInt(Integer.MAX_VALUE);
			return name 
					+" | " + LocalDate.now()
					+" | nonce=" + nonce
					+" | uuid=" + UUID.randomUUID();
		}
		private static String sha256Hex(String input) {
			try {
				 MessageDigest digest = MessageDigest.getInstance("SHA-256");
	                byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
	                return HexFormat.of().formatHex(hash);
	            } catch (NoSuchAlgorithmException e) {
	                // SHA-256 is required by the Java platform, so this should never happen.
	                throw new IllegalStateException("SHA-256 algorithm not available", e);
			}
		}
	}
	
}
