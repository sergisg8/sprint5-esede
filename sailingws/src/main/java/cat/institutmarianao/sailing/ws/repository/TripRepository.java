package cat.institutmarianao.sailing.ws.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cat.institutmarianao.sailing.ws.model.Trip;
import cat.institutmarianao.sailing.ws.model.Trip.Status;
import cat.institutmarianao.sailing.ws.model.TripType.Category;

public interface TripRepository extends JpaRepository<Trip, Long> {

	@Query("SELECT t FROM Trip t WHERE " + "(:category IS NULL OR t.departure.tripType.category = :category) AND "
			+ "(:status IS NULL OR t.status = :status) AND "
			+ "(:clientUsername IS NULL OR t.client.username = :clientUsername) AND "
			+ "(:from IS NULL OR t.departure.date >= :from) AND " + "(:to IS NULL OR t.departure.date <= :to) "
			+ "ORDER BY t.departure.date ASC")
	List<Trip> findAllByFilters(Category category, Status status, String clientUsername, Date from, Date to);

	@Query("SELECT t FROM Trip t WHERE t.client.username = :username AND "
			+ "(:category IS NULL OR t.departure.tripType.category = :category) AND "
			+ "(:status IS NULL OR t.status = :status) AND " + "(:from IS NULL OR t.departure.date >= :from) AND "
			+ "(:to IS NULL OR t.departure.date <= :to) " + "ORDER BY t.departure.date ASC")
	List<Trip> findAllByClientUsername(String username, Category category, Status status, Date from, Date to);

}