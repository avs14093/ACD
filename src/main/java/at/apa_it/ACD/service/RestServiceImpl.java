package at.apa_it.ACD.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.UriBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import at.apa_it.ACD.domain.AuthToken;
import at.apa_it.ACD.domain.User;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class RestServiceImpl implements RestService
{
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public ClientResponse rest(String input, String relativeUrl)
	{
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource webResource = client.resource(getBaseURI()
				+ "/v2.0/" + relativeUrl);
		return webResource.type("application/json")
				.post(ClientResponse.class, input);
	}
	
	// API Password: jCALT05hX7eWyHWX
	// http://docs.openstack.org/developer/keystone/api_curl_examples.html
	// https://github.com/javaswift/joss/issues/30
	/*
	 * Authentification token is normally valid for 24 hours.
	 */
	/**
	 * @param user The name of the registered user on the platform
	 * @param password The password of the registered user on the platform
	 * @return The user object, if authentification was successful, null if not.
	 */
	public User authUser(String user, String password)
	{
		logger.log(Level.INFO, "Requesting Token with following credentials: " + user + ":" + password);
		try
		{	
			ClientResponse response = rest("{\"auth\":{\"passwordCredentials\":{\"username\": \"" + user + "\", \"password\":\"" + password + "\"}, \"tenantId\":\"" + user + "\"}}", "tokens");
			System.out.println(response);
			if (response.getStatus() != 200)
			{
				logger.log(Level.SEVERE, "Failed : HTTP error code : " + response.getStatus(), new RuntimeException());
			}

			String responseString = response.getEntity(String.class);
			String tokenId = new JSONObject(responseString).getJSONObject("access").getJSONObject("token").getString("id");
			String username = new JSONObject(responseString).getJSONObject("access").getJSONObject("user").getString("username");
			logger.log(Level.INFO, "Token fethed: " + tokenId);
			return new User(username);
		}
		catch(Exception e)
		{
			logger.log(Level.WARNING, "Authentification failed due to Application error!");
			return null;
		}
	}
	
	public URI getBaseURI()
	{
		return UriBuilder.fromUri("http://x86.trystack.org:5000").build();
	}
	
	public List<String> getList(JSONArray ja)
	{
		List<String> list = new ArrayList<String>();
		for (int i=0; i<ja.length(); i++) {
		    try
			{
				list.add( ja.getString(i) );
			}
			catch(JSONException e)
			{
				e.printStackTrace();
			}
		}
		return list;
	}
}