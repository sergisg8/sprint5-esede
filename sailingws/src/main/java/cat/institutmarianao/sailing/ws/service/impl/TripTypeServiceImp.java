package cat.institutmarianao.sailing.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import cat.institutmarianao.sailing.ws.model.TripType;
import cat.institutmarianao.sailing.ws.model.TripType.Category;
import cat.institutmarianao.sailing.ws.repository.TripTypeRepository;
import cat.institutmarianao.sailing.ws.security.JwtUtils;
import cat.institutmarianao.sailing.ws.service.TripTypeService;
import jakarta.validation.constraints.NotNull;

@Validated
@Service
public class TripTypeServiceImp implements TripTypeService {
	@Autowired
	private TripTypeRepository tripTypeRepository;
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private JwtUtils jwtUtils;

	@Override
	public List<TripType> findAll(Category category, Double priceFrom, Double priceTo, Integer maxPlacesFrom,
			Integer maxPlacesTo, Integer durationFrom, Integer durationTo) {

		return null;
	}

	@Override
	public TripType findById(@NotNull Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
