package cat.institutmarianao.sailing.ws.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import cat.institutmarianao.sailing.ws.exception.ForbiddenException;
import cat.institutmarianao.sailing.ws.exception.NotFoundException;
import cat.institutmarianao.sailing.ws.model.Action;
import cat.institutmarianao.sailing.ws.model.Trip;
import cat.institutmarianao.sailing.ws.model.Trip.Status;
import cat.institutmarianao.sailing.ws.model.TripType.Category;
import cat.institutmarianao.sailing.ws.repository.TripRepository;
import cat.institutmarianao.sailing.ws.security.JwtUtils;
import cat.institutmarianao.sailing.ws.service.TripService;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import jakarta.validation.constraints.NotNull;

@Validated
@Service
public class TripServiceImpl implements TripService {

	@Autowired
	private TripRepository tripRepository;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private JwtUtils jwtUtils;

	@Override
	public List<Trip> findAll(Category category, Status status, String clientUsername, Date from, Date to) {
		if (!jwtUtils.isAdmin()) {
			throw new ForbiddenException(
					messageSource.getMessage("error.Forbidden.trips.find", null, LocaleContextHolder.getLocale()));
		}

		return tripRepository.findAllByFilters(category, status, clientUsername, from, to);
	}

	@Override
	public List<Trip> findAllByClientUsername(@NotNull String username, Category category, Status status, Date from,
			Date to) {
		if (!(jwtUtils.isAdmin() || jwtUtils.isAuthUser(username))) {
			throw new ForbiddenException(
					messageSource.getMessage("error.Forbidden.trips.find", null, LocaleContextHolder.getLocale()));
		}

		return tripRepository.findAllByFilters(category, status, username, from, to);
	}

	@Override
	public Trip findById(@NotNull Long id) {
		if (!jwtUtils.isAdmin()) {
			throw new ForbiddenException(
					messageSource.getMessage("error.Forbidden.trips.get", null, LocaleContextHolder.getLocale()));
		}

		return tripRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(messageSource.getMessage("error.NotFound.resource.by.id",
						new String[] { "Trip", id.toString() }, LocaleContextHolder.getLocale())));
	}

	@Override
	public Trip save(@NotNull @Valid Trip trip) {
		if (!jwtUtils.isAdmin()) {
			throw new ForbiddenException(
					messageSource.getMessage("error.Forbidden.trips.create", null, LocaleContextHolder.getLocale()));
		}

		if (tripRepository.existsById(trip.getId())) {
			throw new ValidationException(messageSource.getMessage("error.TripService.id.exists",
					new String[] { trip.getId().toString() }, LocaleContextHolder.getLocale()));
		}

		return tripRepository.saveAndFlush(trip);
	}

	@Override
	public Action saveAction(Action action) {
		if (!(jwtUtils.isAdmin() || jwtUtils.isAuthUser(action.getTrip().getClient().getUsername()))) {
			throw new ForbiddenException(
					messageSource.getMessage("error.Forbidden.actions.create", null, LocaleContextHolder.getLocale()));
		}

		if (!tripRepository.existsById(action.getTrip().getId())) {
			throw new NotFoundException(messageSource.getMessage("error.NotFound.resource.by.id",
					new String[] { "Trip", action.getTrip().getId().toString() }, LocaleContextHolder.getLocale()));
		}
		return null;
		// return tripRepository.saveAction(action);
	}
}
