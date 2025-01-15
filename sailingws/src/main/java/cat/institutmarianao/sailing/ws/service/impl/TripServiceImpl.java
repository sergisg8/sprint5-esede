package cat.institutmarianao.sailing.ws.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import cat.institutmarianao.sailing.ws.model.Action;
import cat.institutmarianao.sailing.ws.model.Trip;
import cat.institutmarianao.sailing.ws.model.Trip.Status;
import cat.institutmarianao.sailing.ws.model.TripType.Category;
import cat.institutmarianao.sailing.ws.service.TripService;
import jakarta.validation.constraints.NotNull;

@Validated
@Service
public class TripServiceImpl implements TripService {

	@Override
	public List<Trip> findAll(Category category, Status status, String clientUsername, Date from, Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trip> findAllByClientUsername(@NotNull String username, Category category, Status status, Date from,
			Date to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trip findById(@NotNull Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trip save(@NotNull Trip trip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Action saveAction(Action action) {
		// TODO Auto-generated method stub
		return null;
	}

}
