package utils;

public class Validaciones {
	public static final String NOMBRE = "[a-zA-ZáéíóúñÁÉÍÓÚÑ\\s]{3,15}";
	public static final String APELLIDO = "[a-zA-ZáéíóúñÁÉÍÓÚÑ\\s]{3,25}";
	public static final String USER = "U[0-9]{3}";
	public static final String PASSWORD = "P[0-9]{3}";
	public static final String TEXTO = "[a-zA-Z\\s]{3,15}";
	public static final String DNI = "\\d{8}";
	public static final String CORREO = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"; 
	public static final String RUC = "\\d{11}";
	public static final String CELULAR = "\\d{9}";
	
}
