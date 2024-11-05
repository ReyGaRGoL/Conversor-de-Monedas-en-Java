package conversor.de.monedas;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.LocalDateTime;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Funciones {
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	


	/**
	 * Esta funcion se encarga de realizar la conversion de monedas
	 * 
	 * @param cantidad 
	 * @param base este parametro es el codigo de la moneda base.
	 * @param target este parametro es el codigo de la moneda objetivo.
	 * @return 
	 * Este mentodo retorna un objeto de tipo Conversion que contiene los datos.
	 */
	public Conversion convertir(double cantidad, String base, String target) {
		Conversion conversion = null;
		String cadena="https://v6.exchangerate-api.com/v6/4206d39998aa462c73402a41/pair/"+base+"/"+target+"/"+ cantidad;
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(cadena)).build();

		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			conversion = gson.fromJson(response.body(), Conversion.class);
			System.out.println("***********************************************");
			System.out.println("\nEl valor "+conversion.conversion_rate()+" ["+conversion.base_code()+"]"+" corresponde a al valor final de =>> "+
					conversion.conversion_result()+" ["+conversion.target_code()+"]\n");
			

		} catch (IOException | InterruptedException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return conversion;
	}
	


	/**
	 * <H1>Este metodo se encarga escribir en un archivo .json todos las Conversiones registradas en la lista</H1>
	 * 
	 * 
	 * @param conversiones
	 */
	public void escribirHistorial(List<Conversion> conversiones) {


		try {
			FileWriter escritura = new FileWriter("Historial.json");
			escritura.write(gson.toJson(conversiones));
			escritura.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
