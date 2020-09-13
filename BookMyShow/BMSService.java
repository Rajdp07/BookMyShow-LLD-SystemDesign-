public class BMSService{
	//Base class which contains list of movies and cinema halls
	List<CinemaHall> cinemas;

	public List<Movie> getMovies(Date date, String city);
	public List<CinemaHall> getCinemalHalls(String city);

}
public class CinemaHall {
//Contains the details of Cinema Hall
	int cinemaHallId;
	String cinemaHallName;

	Address address;

	List<Audi>audiList;

	public Map<Date, Movies> getMovies(List<Date> dateList);
	public Map<Date, Show> getShows(List<Date> dateList);

}
public class Address {
//Address of the cinema hall
	int pinCode; //ZipCode
	String street;
	String city;
	String state;
	String country;

}
public class Auditorium {
//Contains details of the auditorium
	int auditoriumId;
	String auditoriumName;
	int totalSeats;
	
	List<Show> shows;

}
public class Show {
//Details of a particular show
	int showId;
	Movie movie;
	Date startTime;
	Date endTime;
	CinemaHall cinemaPlayedAt;
	List<Seat> seats;

}
public class Seat {
//Details of seat
	int seatId;
	SeatType seatType;
	SeatStatus seatStatus;
	Double price;

}


public enum SeatType {
//Type of seat
	DELUX, VIP, ECONOMY, OTHER;

}

public enum SeatStatus {
//Status of seat
	BOOKED, AVAILABLE, RESERVED, NOT_AVAILABLE;

}
public class Movie {
//Dteails of the particular movie that is currently running.
	String movieName;
	int movieId;
	int durationInMins;
	String language;
	Genre genre;//  type of the movie
	Date releaseDate;
	Map<String, List<Show>> cityShowMap;//Which movie is running on which city

}
public enum Genre {

	SCI_FI, DRAMA, ROMANTIC, COMEDY, FANTASY;
}

public class User {
//Any user be it admin or normal user
	int userId;
	Search searchObj;

}
public class SystemMember extends User {
//this would serve as a base class to both of the child user class.. 
	Account account;
	String name;
	String email;
	Address address;

}
public class Member extends SystemMember {

	public Booking makeBooking(Booking booking);//make booking api
	public List<Booking> getBooking();//get booking api

}

public class Admin extends SystemMember {

	public boolean addMovie(Movie movie);
	public boolean addShow(Show show);

}
public class Account {

	String userName;
	String password;

}

public class Search {

	public List<Movie> searchMoviesByNames(String name);
	public List<Movie> searchMoviesByGenre(Genre genre);
	public List<Movie> searchMoviesByLanguage(String language);
	public List<Movie> searchMoviesByDate(Date releaseDate);
}
public class Booking {
//Details of who booked, how many seats booked, which movie,payment...every thing.
	String bookingId;
	Date bookingDate;
	Member member;
	Auditorium auditorium;
	Show show;
	BookingStatus bookingStatus;
	double totalAmount;
	List<Seat> seats;
	Payment paymentObj;

	public boolean makePayment(Payment payment);//api for making payment

}
public class Payment {

	double amount;
	Date paymentDate;
	int transactionId;
	PaymentStatus paymentStatus;

}

public enum BookingStatus {

	REQUESTED, PENDING, CONFIRMED, CANCELLED;
}

public enum PaymentStatus {

	UNPAID, PENDING, COMPLETED, DECLINED, CANCELLED, REFUNDED;

}