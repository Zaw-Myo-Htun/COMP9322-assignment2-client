package au.edu.unsw.soacourse.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import au.edu.unsw.soacourse.model.RegistrationRequestDTO;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class RegisterCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("fdsf");
		try {

			RegistrationRequestDTO st = new RegistrationRequestDTO(1, "YAYYYA",
					"sf");

			ClientConfig clientConfig = new DefaultClientConfig();

			clientConfig.getFeatures().put(
					JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
			Client client = Client.create(clientConfig);

			WebResource webResource = client
					.resource("http://localhost:8080/HelloWorldCxfRest/foundIT/registration");
			ClientResponse r = webResource.accept("application/json")
					.type("application/json").post(ClientResponse.class, st);
			if (response.getStatus() != 200) {

				throw new RuntimeException("Failed : HTTP error code : "

				+ r.getStatus());

			}

			String output = r.getEntity(String.class);

			System.out.println("Server response .... \n");

			System.out.println(output);
		} catch (Exception e) {

			e.printStackTrace();

		}
//	    	request.setAttribute("isUserExist", "true");
//			RequestDispatcher rd = request.getRequestDispatcher("/reg.jsp");
//			rd.forward(request, response);
	    
	}

}
