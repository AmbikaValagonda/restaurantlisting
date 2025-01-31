package com.ambikakh.restaurantlisting.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ambikakh.restaurantlisting.dto.RestaurantDTO;
import com.ambikakh.restaurantlisting.entity.Restaurant;
import com.ambikakh.restaurantlisting.mapper.RestaurantMapper;
import com.ambikakh.restaurantlisting.repo.RestaurantRepo;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepo restaurantRepo;
	
	public List<RestaurantDTO> findAllRestaurants(){
		
		 List<Restaurant> restaurents = restaurantRepo.findAll();
		 // Map list of restaurents to DTOs
		 
		 List<RestaurantDTO> restaurentsDTOList = restaurents.stream().map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant)).collect(Collectors.toList());
		 return restaurentsDTOList;
	}
	
	public RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO) {
		
		Restaurant savedRestaurant=restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));
		return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(savedRestaurant);
		
	}
	
	public ResponseEntity<RestaurantDTO> fetchRestaurntById(Integer id) {
		Optional<Restaurant> restaurant = restaurantRepo.findById(id);
		if(restaurant.isPresent()) {
			return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get()), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
		
	
	
}
