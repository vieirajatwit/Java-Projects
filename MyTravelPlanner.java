import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MyTravelPlanner {

	private boolean isWeekend(LocalDate date) 
	{
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		return (dayOfWeek == DayOfWeek.SATURDAY) || (dayOfWeek == DayOfWeek.SUNDAY);
		// DayOfWeek.SATURDAY .... enumerations
	}
	
	private String getPlanBadWeather (
			LocalDate dateOfPlan,
			LocalTime startOfFirstAppointment,
			LocalTime endOfLastAppointment
			) 
	{
		if (isWeekend(dateOfPlan)) 
		{
			LocalTime time11am = LocalTime.of(11, 0);
			LocalTime time10pm = LocalTime.of(22, 0);
			if (
					(startOfFirstAppointment.compareTo(time11am) < 0) ||
					(endOfLastAppointment.compareTo(time10pm) > 0)
					
				) { // before 11 am or after 10 pm
				String plan = "Please cancel or reschedule your appointments on ";
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
				String textDate = dateOfPlan.format(formatter);
				return plan + textDate + ".";
			}
			
		} 
		else 
		{ // weekday
			LocalTime time11am = LocalTime.of( 7, 0); // 7 AM
			LocalTime time10pm = LocalTime.of(23, 0); // 11 PM
			if (
					(startOfFirstAppointment.compareTo(time11am) < 0) ||
					(endOfLastAppointment.compareTo(time10pm) > 0)
					
				) 
			{ // before 7 am or after 11 pm
				String plan = "Please cancel or reschedule your appointments on ";
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
				String textDate = dateOfPlan.format(formatter);
				return plan + textDate + ".";
			}
		}
		return null;
	}
	
	
	public String getPlan(
				LocalDate dateOfPlan,
				String weatherPrediction,
				LocalTime startOfFirstAppointment,
				LocalTime endOfLastAppointment
			) {
		if (
			weatherPrediction == "Rainy" || 
			weatherPrediction == "Snowy"
			) {
			return getPlanBadWeather (
					dateOfPlan, 
					startOfFirstAppointment,
					endOfLastAppointment
					);
		}
		
			
		return "";
	}
	
}
