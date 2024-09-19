package com.schroh.springboot.jpa.springboot_jpa_relationship;

import com.schroh.springboot.jpa.springboot_jpa_relationship.entities.*;
import com.schroh.springboot.jpa.springboot_jpa_relationship.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class SpringbootJpaRelationshipApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private ClientDetailsRepository clientDetailsRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRelationshipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		manyToManyBidireccionalFind();
	}

	@Transactional
	public void manyToManyBidireccionalFind(){

		Optional<Student> studentOptional1 = studentRepository.findOneWithCourses(1L);
		Optional<Student> studentOptional2 = studentRepository.findOneWithCourses(2l);

		Student student1 = studentOptional1.get();
		Student student2 = studentOptional2.get();

		Course course = courseRepository.findOneWithStudents(1L).get();
		Course course2 = courseRepository.findOneWithStudents(2L).get();

		student1.addCourse(course);
		student2.addCourse(course).addCourse(course2);

		studentRepository.saveAll(Set.of(student1,student2));

		System.out.println(student1);
		System.out.println(student2);
	}


	@Transactional
	public void manyToManyBidireccionalRemove(){

		Student student1 = new Student("Jano","Martinez");
		Student student2 = new Student("Hamiko","Too");

		Course course = new Course("Curso de Java master", "Andres");
		Course course2 = new Course("Curso de Spring Boot", "Andres");

//		student1.setCourses(Set.of(course, course2));
//		student2.setCourses(Set.of(course2));

		student1.addCourse(course);
		student2.addCourse(course).addCourse(course2);

		studentRepository.saveAll(Set.of(student1,student2));

		System.out.println(student1);
		System.out.println(student2);

		Optional<Student> studentOptionalDb = studentRepository.findOneWithCourses(3L);
		if (studentOptionalDb.isPresent()) {

			Student studentDb = studentOptionalDb.orElseThrow();
			Optional<Course> courseOptionalDb = courseRepository.findOneWithStudents(3L);

			if (courseOptionalDb.isPresent()){
				Course courseDb = courseOptionalDb.orElseThrow();
				studentDb.removeCourse(courseDb);

				studentRepository.save(studentDb);
				System.out.println(studentDb);
			}
		}
	}

	@Transactional
	public void manyToManyBidireccional(){

		Student student1 = new Student("Jano","Martinez");
		Student student2 = new Student("Hamiko","Too");

		Course course = new Course("Curso de Java master", "Andres");
		Course course2 = new Course("Curso de Spring Boot", "Andres");

//		student1.setCourses(Set.of(course, course2));
//		student2.setCourses(Set.of(course2));

		student1.addCourse(course);
		student2.addCourse(course).addCourse(course2);

		studentRepository.saveAll(Set.of(student1,student2));

		System.out.println(student1);
		System.out.println(student2);

		Optional<Student> studentOptionalDb = studentRepository.findOneWithCourses(3L);
		if (studentOptionalDb.isPresent()) {

			Student studentDb = studentOptionalDb.orElseThrow();
			Optional<Course> courseOptionalDb = courseRepository.findById(3L);

			if (courseOptionalDb.isPresent()){
				Course courseDb = courseOptionalDb.orElseThrow();
				studentDb.getCourses().remove(courseDb);

				studentRepository.save(studentDb);
				System.out.println(studentDb);
			}
		}
	}

	@Transactional
	public void manyToManyRemove(){

		Student student1 = new Student("Jano","Martinez");
		Student student2 = new Student("Hamiko","Too");

		Course course = new Course("Curso de Java master", "Andres");
		Course course2 = new Course("Curso de Spring Boot", "Andres");

		student1.setCourses(Set.of(course, course2));
		student2.setCourses(Set.of(course2));

		studentRepository.saveAll(Set.of(student1,student2));

		System.out.println(student1);
		System.out.println(student2);

		Optional<Student> studentOptionalDb = studentRepository.findOneWithCourses(3L);
		if (studentOptionalDb.isPresent()) {

			Student studentDb = studentOptionalDb.orElseThrow();
			Optional<Course> courseOptionalDb = courseRepository.findById(3L);

			if (courseOptionalDb.isPresent()){
				Course courseDb = courseOptionalDb.orElseThrow();
				studentDb.getCourses().remove(courseDb);

				studentRepository.save(studentDb);
				System.out.println(studentDb);
			}
		}
	}

	@Transactional
	public void manyToManyRemoveFind(){

		Optional<Student> studentOptional1 = studentRepository.findById(1L);
		Optional<Student> studentOptional2 = studentRepository.findById(2l);

		Student student1 = studentOptional1.get();
		Student student2 = studentOptional2.get();

		Course course = courseRepository.findById(1L).get();
		Course course2 = courseRepository.findById(2L).get();

		student1.setCourses(Set.of(course, course2));
		student2.setCourses(Set.of(course2));

		studentRepository.saveAll(Set.of(student1,student2));

		System.out.println(student1);
		System.out.println(student2);

		Optional<Student> studentOptionalDb = studentRepository.findOneWithCourses(1L);
		if (studentOptionalDb.isPresent()) {

			Student studentDb = studentOptionalDb.orElseThrow();
			Optional<Course> courseOptionalDb = courseRepository.findById(2L);

			if (courseOptionalDb.isPresent()){
				Course courseDb = courseOptionalDb.orElseThrow();
				studentDb.getCourses().remove(courseDb);

				studentRepository.save(studentDb);
				System.out.println(studentDb);
			}
		}
	}

	@Transactional
	public void manyToManyFind(){

		Optional<Student> studentOptional1 = studentRepository.findById(1L);
		Optional<Student> studentOptional2 = studentRepository.findById(2l);

		Student student1 = studentOptional1.get();
		Student student2 = studentOptional2.get();

		Course course = courseRepository.findById(1L).get();
		Course course2 = courseRepository.findById(2L).get();

		student1.setCourses(Set.of(course, course2));
		student2.setCourses(Set.of(course2));

		studentRepository.saveAll(Set.of(student1,student2));

		System.out.println(student1);
		System.out.println(student2);
	}

	@Transactional
	public void manyToMany(){

		Student student1 = new Student("Jano","Martinez");
		Student student2 = new Student("Hamiko","Too");

		Course course = new Course("Curso de Java master", "Andres");
		Course course2 = new Course("Curso de Spring Boot", "Andres");

		student1.setCourses(Set.of(course, course2));
		student2.setCourses(Set.of(course2));

		studentRepository.saveAll(Set.of(student1,student2));

		System.out.println(student1);
		System.out.println(student2);
	}

	@Transactional
	public void oneToOneBidireccionalFindById() {

		Optional<Client> optionalClient = clientRepository.findOne(2L);

		ClientDetails clientDetails = new ClientDetails(5000,true);
//		clientDetailsRepository.save(clientDetails); ya no se precisa porque establecimos el parametro CascadeType.ALL

		optionalClient.ifPresentOrElse(client -> {
			client.setClientDetails(clientDetails);
			clientRepository.save(client);
			System.out.println(client);
		}, () -> System.out.println("Cliente no encontrado"));
	}

	@Transactional
	public void oneToOneBidireccional() {

		Client client = new Client("Zinattra", "Frank");

		ClientDetails clientDetails = new ClientDetails(5000,true);
//		clientDetailsRepository.save(clientDetails); ya no se precisa porque establecimos el parametro CascadeType.ALL

		client.setClientDetails(clientDetails);
		// guardamos de manera bidireccional

		clientRepository.save(client);

		System.out.println(client);
	}

	@Transactional
	public void oneToOneFindById() {

		ClientDetails clientDetails = new ClientDetails(5000,true);
		clientDetailsRepository.save(clientDetails);

		Optional<Client> optionalClient = clientRepository.findOne(2L);// new Client("Zinattra", "Frank");

		optionalClient.ifPresentOrElse(c -> {
			c.setClientDetails(clientDetails);
			clientRepository.save(c);
			System.out.println(c);
		}, () -> System.out.println("Cliente no encontrado"));

	}

	@Transactional
	public void oneToOne() {

		ClientDetails clientDetails = new ClientDetails(5000,true);
		clientDetailsRepository.save(clientDetails);

		Client client = new Client("Zinattra", "Frank");
		client.setClientDetails(clientDetails);
		clientRepository.save(client);

		System.out.println(client);
	}

	@Transactional
	public void removeInvoiceBidireccional() {
		Optional<Client> optionalClient = Optional.of(new Client("Zinattra","Frank")); // Convertimos al cliente en un Optional

		optionalClient.ifPresent(client -> {

			Invoice invoice1 = new Invoice("Compras para el quincho",5320L);
			Invoice invoice2 = new Invoice("Compras para la oficina",7209L);

			client.addInvoice(invoice1).addInvoice(invoice2);

			clientRepository.save(client); // no guardamos las facturas gracias al CASCADE.ALL

			System.out.println(client);
		});

		Optional<Client> optionalClientDb = clientRepository.findOne(3L);

		optionalClientDb.ifPresentOrElse(clientDb -> {
			Optional<Invoice> invoiceOptional = invoiceRepository.findById(2L);
			invoiceOptional.ifPresentOrElse(invoice -> {
				clientDb.removeInvoice(invoice); // Eliminar la factura del cliente
				clientRepository.save(clientDb); // Guardar el cliente para propagar los cambios
			}, () -> {
				System.out.println("Factura no encontrada");
			});
		}, () -> {
			System.out.println("Cliente no encontrado");
		});
	}

	@Transactional
	public void removeInvoiceBidireccionalFindById() {
		Optional<Client> optionalClient = clientRepository.findOne(1L); // Busca el cliente para asignar factura

		optionalClient.ifPresent(client -> {

			Invoice invoice1 = new Invoice("Compras para el quincho",5320L);
			Invoice invoice2 = new Invoice("Compras para la oficina",7209L);

			client.addInvoice(invoice1).addInvoice(invoice2);

			clientRepository.save(client); // no guardamos las facturas gracias al CASCADE.ALL

			System.out.println(client);
		});

		Optional<Client> optionalClientBd = clientRepository.findOne(1L);

		optionalClientBd.ifPresent(client -> {
			Optional<Invoice> invoiceOptional = invoiceRepository.findById(2L);
			invoiceOptional.ifPresent(invoice -> {
				client.removeInvoice(invoice); // Cuando la relacion es bidireccional y queremos eliminar las facturas de un cliente, debemos asegurarnos tambien de eliminar a ese cliente para que no ocupe espacio en memoria
				clientRepository.save(client); // Como nuestras tablas trabajan en cascada guardamos unicamente al cliente, no hace falta guardar la factura
				System.out.println(client);
			});
		});
	}

	@Transactional
	public void oneToManyInvoiceBidireccionalFindById() {
		Optional<Client> optionalClient = clientRepository.findOneInvoices(1L);

		optionalClient.ifPresent(client -> {

			Invoice invoice1 = new Invoice("Compras para el quincho",5320L);
			Invoice invoice2 = new Invoice("Compras para la oficina",7209L);

			client.addInvoice(invoice1).addInvoice(invoice2);

			clientRepository.save(client); // no guardamos las facturas gracias al CASCADE.ALL

			System.out.println(client);
		});
	}

	@Transactional
	public void oneToManyInvoiceBidireccional() {
		Client client = new Client("Zinatra", "Frank");

		Invoice invoice1 = new Invoice("Compras para el quincho",5320L);
		Invoice invoice2 = new Invoice("Compras para la oficina",7209L);

		client.addInvoice(invoice1).addInvoice(invoice2);

		clientRepository.save(client); // no guardamos las facturas gracias al CASCADE.ALL

		System.out.println(client);
	}

	@Transactional
	public void removeAddressFindById(){
		Optional<Client> optionalClient = clientRepository.findById(2L);
		optionalClient.ifPresent(client -> {
			Address address1 = new Address(1345,"Brickman");
			Address address2 = new Address(2160,"Pedro Pico");

			client.setAddresses(new HashSet<>(Arrays.asList(address1,address2)));
			clientRepository.save(client);

			System.out.println(client);

			Optional<Client> optionalClient2 = clientRepository.findOne(2L); // cuando llamamos al cliente de la base de datos no viene con su direccion
			// en una app Web funcionaria pero para una aplicacion de escritorio no, si queremos obtener las direcciones del cliente vamos a properties
			optionalClient2.ifPresent(c -> {
				c.getAddresses().remove(address2);
				clientRepository.save(c);
				System.out.println(c);
			});
		});
	}

	@Transactional
	public void removeAddress(){
		Client client = new Client("Zinatra","Frank");

		Address address1 = new Address(1345,"Brickman");
		Address address2 = new Address(2160,"Pedro Pico");

		client.getAddresses().add(address1);
		client.getAddresses().add(address2);

		clientRepository.save(client);

		System.out.println(client);

		Optional<Client> optionalClient = clientRepository.findById(3L); // cuando llamamos al cliente de la base de datos no viene con su direccion
		// en una app Web funcionaria pero para una aplicacion de escritorio no, si queremos obtener las direcciones del cliente vamos a properties
		optionalClient.ifPresent(c -> {
			c.getAddresses().remove(address1);
			clientRepository.save(c);
			System.out.println(c);
		});
	}

	@Transactional
	public void oneToManyFindById(){
		Optional<Client> optionalClient = clientRepository.findById(2L);
		optionalClient.ifPresent(client -> {
			Address address1 = new Address(1345,"Brickman");
			Address address2 = new Address(2160,"Pedro Pico");

			client.setAddresses(new HashSet<>(Arrays.asList(address1,address2)));
			clientRepository.save(client);

			System.out.println(client);
		});
	}

	@Transactional
	public void oneToMany(){
		Client client = new Client("Zinatra","Frank");

		Address address1 = new Address(1345,"Brickman");
		Address address2 = new Address(2160,"Pedro Pico");

		client.getAddresses().add(address1);
		client.getAddresses().add(address2);

		clientRepository.save(client);

		System.out.println(client);
	}

	@Transactional
	public void manyToOne() {
		Client client = new Client("Schroh","Santi");
		clientRepository.save(client);

		Invoice invoice = new Invoice("compras de oficina", 2320L);
		invoice.setClient(client);
		Invoice invoiceDB = invoiceRepository.save(invoice);
		System.out.println(invoiceDB);
	}

	@Transactional
	public void manyToOneFindByIdClient() {
		Optional<Client> optionalClient = clientRepository.findById(1L);

		if (optionalClient.isPresent()) {
			Client client = optionalClient.orElseThrow();
			Invoice invoice = new Invoice("compras de oficina", 2320L);
			invoice.setClient(client);
			Invoice invoiceDB = invoiceRepository.save(invoice);
			System.out.println(invoiceDB);
		}
	}
}
