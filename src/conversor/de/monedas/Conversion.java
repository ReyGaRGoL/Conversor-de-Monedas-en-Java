package conversor.de.monedas;

import java.time.LocalDateTime;

public record Conversion(String base_code, String target_code, String conversion_rate, String conversion_result) {

	public static final LocalDateTime FECHA_REGISTRO= LocalDateTime.now();


	
	@Override
	public String toString() {
		return "\n(base_code=" + base_code + ", target_code=" + target_code + ", conversion_rate="
				+ conversion_rate + ", conversion_result=" + conversion_result + ", fecha_Registro=" + FECHA_REGISTRO
				+ ")";
	}

	public String base_code() {
		return base_code;
	}

	public String target_code() {
		return target_code;
	}

	public String conversion_rate() {
		return conversion_rate;
	}

	public String conversion_result() {
		return conversion_result;
	}

	public LocalDateTime FECHA_REGISTRO() {
		return FECHA_REGISTRO;
	}


}
