package cat.institutmarianao.sailing.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cat.institutmarianao.sailing.ws.model.TripType;
import cat.institutmarianao.sailing.ws.model.TripType.Category;

public interface TripTypeRepository extends JpaRepository<TripType, Integer> {
	@Query("SELECT t FROM TripType t "
			+ "WHERE (?1 IS NULL OR t.category = ?1) "
			
			+ "AND (?2 IS NULL OR t.price >= ?2) "

			+ "AND (?3 IS NULL OR t.price <= ?3) "

			+ "AND (?4 IS NULL OR t.maxPlaces >= ?4) "

			+ "AND (?5 IS NULL OR t.maxPlaces <= ?5) "

			+ "AND (?6 IS NULL OR t.duration >= ?6) "

			+ "AND (?7 IS NULL OR t.duration <= ?7)")

	List<TripType> findAllByFilters(Category category, Double priceFrom, Double priceTo, Integer maxPlacesFrom,
			Integer maxPlacesTo, Integer durationFrom, Integer durationTo);
}
