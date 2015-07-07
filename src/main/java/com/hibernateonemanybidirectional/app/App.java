package com.hibernateonemanybidirectional.app;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.hibernateonemanybidirectional.pojo.RegOffice;
import com.hibernateonemanybidirectional.pojo.Vehicle;
import com.hibernateonemanybidirectional.util.HibernateUtil;
import com.hibernateonemanybidirectional.util.RandomUtils;

public class App {

	public static void main(String[] args) {

		System.out
				.println(" ****** Hibernate One-Many Unidirectional - Foreignkey (Annotation) *** START **** ");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		RegOffice regOffice = new RegOffice(RandomUtils.generateRandomInteger(Integer.MAX_VALUE), RandomUtils.generateRandomString(20));
		Vehicle vehicle1 = new Vehicle(RandomUtils.generateRandomInteger(Integer.MAX_VALUE));
		Vehicle vehicle2 = new Vehicle(RandomUtils.generateRandomInteger(Integer.MAX_VALUE));
		Set<Vehicle> vehicles = new HashSet<Vehicle>();
		vehicles.add(vehicle1);
		vehicles.add(vehicle2);
		regOffice.getVehicles().addAll(vehicles);
		session.save(regOffice);
		session.getTransaction().commit();
		session.close();
		System.out
				.println(" ****** Hibernate One-Many Unidirectional - Foreignkey (Annotation) *** END **** ");

	}

}
