package com.schroh.springboot.jpa.springboot_jpa;

import com.schroh.springboot.jpa.springboot_jpa.dto.PersonDto;
import com.schroh.springboot.jpa.springboot_jpa.entities.Person;
import com.schroh.springboot.jpa.springboot_jpa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception { // En el metodo RUN trabajamos con nuestra persistencia
		create();
	}

	@Transactional(readOnly = true)
	public void whereIn(){
		System.out.println("consulta sobre id");
		List<Person> persons = repository.getPersonByIds();
		persons.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void subQueries(){
		System.out.println("consulta subquery por el nombre mas corto y su largo");
		List<Object[]> registers = repository.getShortedName();
		registers.forEach(reg -> {
			String name = (String) reg[0];
			Integer length = (Integer) reg[1];
			System.out.println("name=" + name + ", length=" + length);
		});
	}

	@Transactional(readOnly = true)
	public void queriesFuncitonAggregation(){

		System.out.println("Total de registros de tabla persona");
		Long count = repository.getTotalPerson();
		System.out.println(count);

		System.out.println("Minimo id");
		Long min = repository.getMinId();
		System.out.println(min);

		System.out.println("Maximo id");
		Long max = repository.getMaxId();
		System.out.println(max);

		System.out.println("consulta con el nombre y su largo");
		List<Object[]> regs = repository.getPersonNameLength();
		regs.forEach(reg -> {
			String name = (String) reg[0];
			Integer length = (Integer) reg[1];
			System.out.println("name=" + name + ", length=" + length);
		});

		System.out.println("consultas resumen de funciones de agregacion, min, max, sum, avg, count");
		Object[] resumeAvg = (Object[]) repository.getResumeAggregationFunction();
		System.out.println("min=" + resumeAvg[0] + ", max=" + resumeAvg[1]
				+ ", sum=" + resumeAvg[2] + ", avg=" + resumeAvg[3]
				+ ", countId=" + resumeAvg[4]);
	}

	@Transactional(readOnly = true)
	public void personalizedQueriesBetween() {
		System.out.println("consulta por rangos");
		List<Person> persons = repository.findAllBetweenId(1L,9L);
		persons.forEach(System.out::println);

		System.out.println("consulta por rangos de letra en nombres");
		List<Person> names = repository.findAllBetweenName("R","Z");
		names.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void personalizedQueriesConcatUpperAndLowerCase(){
		System.out.println("consulta noombres y apellidos de personas");
		List<String> names = repository.findAllFullNameConcat();
		names.forEach(System.out::println);

		System.out.println("consulta nombres y apellidos en mayuscula");
		List<String> namesMayus = repository.findAllFullNameConcatUpper();
		namesMayus.forEach(System.out::println);

		System.out.println("consulta nombres en minuscula y apellidos en mayuscula");
		List<String> namesMinusc = repository.findAllFullNameConcatLowerAndUpper();
		namesMinusc.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void personalizedQueriesDistinct() { // Poder listar valores unicos de la tabla que no se repitan
		System.out.println("consultas con nombres de personas");
		List<String> names = repository.findAllNames();
		names.forEach(System.out::println);

		System.out.println("consulta sin repeticiones de nombres");
		List<String> namesNotRepeat = repository.findAllNamesDistinct();
		namesNotRepeat.forEach(System.out::println);

		System.out.println("consulta sin repeticiones de lenguajes");
		List<String> languages = repository.findAllProgrammingLanguageDistinct();
		languages.forEach(System.out::println);

		System.out.println("consulta de cantidad de lenguajes unicos");
		Long total = repository.findAllProgrammingLanguageDistinctCount();
		System.out.println(total);
	}

	@Transactional(readOnly = true)
	public void personalizedQueries2() {
		System.out.println("========= Consulta por objeto persona y lenguaje de progamacion =========");
		List<Object[]> personsRegs = repository.findAllMixPerson();

		personsRegs.forEach(reg -> {
			System.out.println("programmingLanguage=" + reg[1] + ", person=" + reg[0]);
		});

		System.out.println("Consulta que puebla y devuelve objeto entity de una instancia personalizada");
		List<Person> persons = repository.findAllObjectPersonPersonalized();
		persons.forEach(System.out::println);

		System.out.println("Consulta que puebla y devuelve objeto dto de una clase personalizada");
		List<PersonDto> personsDto = repository.findAllPersonDto();
		personsDto.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void personalizedQueries() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Por favor introduzca el id: ");
		Long id = scanner.nextLong();
		scanner.close();

		String name = repository.getNameByid(id);
		System.out.println(name);
	}

	@Transactional
	public void delete2(){
		repository.findAll().forEach(System.out::println);

		Scanner scanner = new Scanner(System.in);
		System.out.println("============= Consulta nombre por id ============");
		System.out.println("Ingrese el id a eliminar");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = repository.findById(id);

		optionalPerson.ifPresentOrElse(person -> repository.delete(person),
				() -> System.out.println("No existe la peronsa con ese id!"));

		repository.deleteById(id);

		repository.findAll().forEach(System.out::println);

		scanner.close();
	}

	@Transactional
	public void delete(){
		repository.findAll().forEach(System.out::println);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id a eliminar");
		Long id = scanner.nextLong();
		repository.deleteById(id);

		repository.findAll().forEach(System.out::println);

		scanner.close();
	}

	@Transactional
	public void update() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id de la persona: ");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = repository.findById(id);

		optionalPerson.ifPresent(person -> {
			System.out.println(person);
			System.out.println("Ingrese el lenguaje de programacion: ");
			String programmingLanguage = scanner.next();
			person.setProgrammingLanguage(programmingLanguage);
			Person persondb = repository.save(person);
			System.out.println(persondb);
		});
		scanner.close();
	}

	@Transactional // Utiliza AOP, realiza un begin, e integra commit y rolleback
	public void create(){
		// Si el id existe lo actualiza, sino lo crea
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		String lastName = scanner.next();
		String  programmingLanguage = scanner.next();

		Person person = new Person(null, lastName, name, programmingLanguage);

		Person personNew = repository.save(person); // save es un metodo de crud repository
		System.out.println(personNew);

		repository.findById(personNew.getId()).ifPresent(System.out::println);

		scanner.close();
	}

	@Transactional(readOnly = true) // Los que no modifican tabla establecer en readOnly
	public void findOne(){
//		Person person = null;
//		Optional<Person> optionalPerson = repository.findById(8L);
//		if(optionalPerson.isPresent()){
//			person = optionalPerson.get();
//		};
//		System.out.println(person);

		// Esta implementacion de ifPresent es crucial para trabajar con Optionals
		repository.findByNameContaining("ago").ifPresent(System.out::println); // Si no esta presente no arroja NullPointerException
	}

	@Transactional(readOnly = true)
	public void list() {

		//		List<Person> persons = (List<Person>) repository.findAll();
		List<Person> persons = repository.findByProgrammingLanguageAndName("Java", "Santiago");

		persons.forEach(System.out::println);

		List<Object[]> personsValues = repository.obtenerPersonData("milagros");

		personsValues.stream().forEach(p -> {
			System.out.println(p[0] + " es experto en " + p[1]);
		});
	}
}
