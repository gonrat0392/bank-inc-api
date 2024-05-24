package com.boot.banco;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
@AutoConfigureMockMvc
@SpringBootTest
class BancoApplicationTests {

	@Autowired
	MockMvc mock;
	@Test
	@Order(0)
	void eliminarClientes()throws Exception {
		mock.perform(delete("/clientes"));
	}

	@Test
	@Order(1)
	void testClientes() throws Exception{
		mock.perform(get("/clientes")).andDo(print());
	}

	@Test
	@Order(2)
	void testAlta() throws Exception{
		mock.perform(post("/clientes")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n" +
						"    \"idCliente\": 1023987663,\n" +
						"    \"nombre\": \"Juanito53\",\n" +
						"    \"apellidoPaterno\": \"Pinto2\",\n" +
						"    \"apellidoMaterno\": \"Paez2\",\n" +
						"    \"fechaNacimiento\": \"10/10/1992\",\n" +
						"    \"sexo\": \"Masculino\",\n" +
						"    \"correo\": \"micorreo104@gmail.com\",\n" +
						"    \"telefono\": \"3127654322\"\n" +
						"}")
		).andDo(print());
	}
	@Test
	@Order(3)
	void testActualizacion() throws Exception{
		mock.perform(put("/clientes")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n" +
						"    \"idCliente\": 1023987663,\n" +
						"    \"nombre\": \"Juanito25\",\n" +
						"    \"apellidoPaterno\": \"Pinto25\",\n" +
						"    \"apellidoMaterno\": \"Paez25\",\n" +
						"    \"fechaNacimiento\": \"10/10/1992\",\n" +
						"    \"sexo\": \"Masculino\",\n" +
						"    \"correo\": \"micorreo235@gmail.com\",\n" +
						"    \"telefono\": \"3127654333\"\n" +
						"}")
		).andDo(print());
	}

}
