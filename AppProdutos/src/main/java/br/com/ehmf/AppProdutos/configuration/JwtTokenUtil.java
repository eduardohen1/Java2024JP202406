package br.com.ehmf.AppProdutos.configuration;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil {

	private String segredo = "umSegredoMuitoLongoQueTemMaisDe256BitsParaSerSeguroComHMACSHA";
	private long validadeM = 3600000; //milissegundos 1h
	
	//criar o token
	public String createToken(String username) {
		Date agora = new Date();
		Date validade = new Date(agora.getTime() + validadeM);
		
		byte[] apiKeySecretByte = Base64.getEncoder().encode(segredo.getBytes());
		Key segredoKey = Keys.hmacShaKeyFor(apiKeySecretByte);
		
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(agora)
				.setExpiration(validade)
				.signWith(segredoKey)
				.compact();
	}
	
	//validar o token
	public boolean validateToken(String token) {
		try {
			byte[] apiKeySecretyByte = Base64.getEncoder().encode(segredo.getBytes());
			Key segredoKey = Keys.hmacShaKeyFor(apiKeySecretyByte);
			
			Jws<Claims> claims = Jwts.parser().setSigningKey(apiKeySecretyByte)
				.parseClaimsJws(token);
			
			return !claims.getBody().getExpiration().before(new Date());
			
		}catch (Exception e) {
			return false;
		}
	}
	
	//pegar o username do token
	public String getUsernameFromToken(String token) {
		try {
			byte[] apiKeySecretyByte = Base64.getEncoder().encode(segredo.getBytes());
			Key segredoKey = Keys.hmacShaKeyFor(apiKeySecretyByte);
			
			Jws<Claims> claims = Jwts.parser().setSigningKey(apiKeySecretyByte)
				.parseClaimsJws(token);
			
			return claims.getBody().getSubject();
			
		}catch (Exception e) {
			return "";
		}
	}
}
