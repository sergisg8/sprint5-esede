package cat.institutmarianao.sailing.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cat.institutmarianao.sailing.ws.model.Trip;

public interface TripRepository extends JpaRepository<Trip, Long> {
	
	@Query("SELECT t FROM Trip t WHERE "
			+ ""
}
