import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer number;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer number, Date checkIn, Date checkOut) {
	
		this.number = number;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime(); // o getTime pega o valor em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);//conversão de milisegundos para dias pelo tipo enum TimeUnit
	}
	public String atualizarDias(Date checkIn, Date checkOut) {
		Date agora = new Date();
		
		if(checkOut.before(agora) || checkIn.before(agora)) {
			return "ERROR: a data de check in ou a de check out é antiga";
		}
		if(!checkOut.after(checkIn)) {
			return "Error na data de checkout";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	@Override
	public String toString() {
		return "Reserva \n Numero do quarto= " + number + "\n CheckIn= " + sdf.format(checkIn) +
				"\n CheckOut=" + sdf.format(checkOut)+ "\nDuração: "+duracao()+" dias.";
	}
	
	
}
