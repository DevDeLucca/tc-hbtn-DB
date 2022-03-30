import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class PrintJDBCDrivers {

	public static void main(String[] args) {
		System.out.println("Lista de drivers JDBC");
		for (Enumeration<Driver> e = DriverManager.getDrivers(); e.hasMoreElements(); ) {
			Driver driver = e.nextElement();
			printDriver(driver);
		}
				
	}

	public static void printDriver(Driver driver) {
		String nomeClasse = driver.getClass().getName();
		int maiorVersao = driver.getMajorVersion();
		int menorVersao = driver.getMinorVersion();
		
		System.out.println(" =============================== ");
		System.out.println("Nome Driver: "+nomeClasse);
		System.out.println("Driver Maior Versão: "+ maiorVersao);
		System.out.println("Driver Menor Versão: "+ menorVersao);
		System.out.println(" =============================== ");
		
	}
}

