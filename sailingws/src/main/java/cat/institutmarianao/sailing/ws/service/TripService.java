package cat.institutmarianao.sailing.ws.service;

import java.util.Date;
import java.util.List;

import cat.institutmarianao.sailing.ws.model.Action;
import cat.institutmarianao.sailing.ws.model.Trip;
import cat.institutmarianao.sailing.ws.model.Trip.Status;
import cat.institutmarianao.sailing.ws.model.TripType.Category;
import jakarta.validation.constraints.NotNull;

public interface TripService {

	List<Trip> findAll(Category category, Status status, String clientUsername, Date from, Date to);

	List<Trip> findAllByClientUsername(@NotNull String username, Category category, Status status, Date from, Date to);

	Trip findById(@NotNull Long id);

	Trip save(@NotNull Trip trip);

	Action saveAction(Action action);
}
