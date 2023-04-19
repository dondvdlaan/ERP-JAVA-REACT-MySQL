package dev.manyroads.Shipping;

import dev.manyroads.Shipping.constants.OrderStatus;
import dev.manyroads.Shipping.domain.Address;
import dev.manyroads.Shipping.domain.Orders;
import dev.manyroads.Shipping.domain.Shipment;
import dev.manyroads.Shipping.rest.repository.AddressRepository;
import dev.manyroads.Shipping.rest.repository.OrderRepository;
import dev.manyroads.Shipping.rest.repository.ShippingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.context.annotation.Bean;

import java.net.SocketOption;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class ShippingApplication {

	public static void main(java.lang.String[] args) {
		SpringApplication.run(ShippingApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ShippingRepository shippingRepository,
								  OrderRepository orderRepository,
								  AddressRepository addressRepository) {
		return (args) -> {

			// Fill up DB with test shipments
			for (int i = 0; i < 0; i++) {

				LocalDate ld = LocalDate.now().plusDays(i);
				String n = "name" + Integer.toString(i);

				//System.out.println("name" + n);

				Address a = new Address("name","house","street","city","zip");

				Orders o = new Orders("user",100L,"Visa",a,ld,OrderStatus.SUCCESS,"Bye now");
				Shipment s = new Shipment(ld,a);

				System.out.println(s.toString());

				//orderRepository.save(o);
				shippingRepository.save(s);
			}
			;
		};
	}

}
