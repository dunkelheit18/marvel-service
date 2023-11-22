package com.mx.application.marvel.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.mx.application.marvel.service.MarvelClientService;

/**
 * @author jahernandezg
 */
@Service
public class MarvelClientServiceImpl implements MarvelClientService {

	private URL uri;
	
	@Override
	public String getServiceConnect(String url) {
		
		String responseService = "";
		try {
			uri = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
			connection.setRequestMethod("GET");
			
			int responseCode = connection.getResponseCode();
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
			
				String inputLine;
				StringBuilder response = new StringBuilder();
				try(BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));){
			
					while ((inputLine = buffer.readLine()) != null) {
						response.append(inputLine);	
					}
				}
				responseService = response.toString();
			}	
			
		} catch (MalformedURLException e) {
			System.out.println("Error en la URL >> ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error en la conexion >> ");
			e.printStackTrace();
		}
		
		return responseService;
	}

}
