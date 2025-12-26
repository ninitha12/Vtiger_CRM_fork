package genericUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class JavaUtils {

	/**
	 * This method is used to get random number
	 * @author arthi
	 * @return
	 */
	public int getRandomNum() {
		Random ran = new Random();
		int random = ran.nextInt(1000);
		return random;
	}

	/**
	 * This method is used to get current system date in customized format
	 * @author arthi
	 * @return
	 */
	public String systemDate() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-dd-MM");
		String sysdate = d.format(date);
		return sysdate;
	}
	
	/**
	 * This method is used to get current system date in customized format with time
	 * @author arthi
	 * @return
	 */
	public String sysDate() {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyy_HH-mm-ss");
		String systemDateInFormat = sim.format(date);
		return systemDateInFormat;
	}

	/**
	 * This method is used to get system date with future month
	 * @author arthi
	 * @param futureMon
	 * @return
	 */
	public String futureDateIntermsOfMonths(long futureMon) {
		LocalDate date = LocalDate.now();
		LocalDate future = date.plusMonths(futureMon);

		DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String futureMonth = d.format(future);
		return futureMonth;
	}
	
	/**
	 * This method is used to get system date with future date
	 * @author arthi
	 * @param futureD
	 * @return
	 */
	public String futureDateIntermsOfDays(long futureD) {
		LocalDate date = LocalDate.now();
		LocalDate future = date.plusDays(futureD);

		DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String futureDate = d.format(future);
		return futureDate;
	}
}
