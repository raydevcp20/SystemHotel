import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		try {
		System.out.println("Digite o numero do quarto: ");
		int num = sc.nextInt();
		System.out.println("entre com a data de CheckIn(DD/MM/YYYY): ");
		Date ci = sdf.parse(sc.next());
		System.out.println("entre com a data de CheckOut(DD/MM/YYYY): ");
		Date co = sdf.parse(sc.next());
		
		Reserva rs = new Reserva(num, ci, co);
		System.out.println("Reserva: "+ rs);
		
		System.out.println("Entre com os novos dados:");
		System.out.println("entre com a data de CheckIn(DD/MM/YYYY): ");
		ci = sdf.parse(sc.next());
		System.out.println("entre com a data de CheckOut(DD/MM/YYYY): ");
		co = sdf.parse(sc.next());
		
		rs.atualizarDias(ci, co);
		System.out.println("Reserva: "+ rs);
		
		}catch(ParseException e) {
			System.out.println("Formato de data invalido");
		}catch(Excessoes e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}

}
