package com.booking.hotel.util;

import java.util.ArrayList;
import java.util.List;

import com.booking.hotel.persistence.entity.hotel.HotelEntity;

/**
 * 
 * @author juveme88
 *
 */
public class MocksHotelUtil {

	private MocksHotelUtil() {

	}

	public static List<HotelEntity> buildList() {
		List<HotelEntity> lista = new ArrayList<>();
		lista.add(buildEntity());
		return lista;
	}

	public static HotelEntity buildEntity() {
		HotelEntity model = new HotelEntity();
		model.setId(1L);
		model.setAddress("Cualquier cosa");
		model.setNit("1522656-6");
		model.setName("Nombre");
		model.setStars(5);
		model.setDescription("Descripcion");
		return model;
	}

	public static HotelEntity buildExistEntity() {
		HotelEntity model = new HotelEntity();
		model.setId(1L);
		model.setAddress("Cualquier cosa");
		model.setNit("1522656-6");
		model.setName("Nombre");
		model.setStars(5);
		model.setDescription("Descripcion");
		return model;
	}
}
