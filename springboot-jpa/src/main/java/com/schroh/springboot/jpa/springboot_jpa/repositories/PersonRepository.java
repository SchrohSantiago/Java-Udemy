package com.schroh.springboot.jpa.springboot_jpa.repositories;

import com.schroh.springboot.jpa.springboot_jpa.dto.PersonDto;
import com.schroh.springboot.jpa.springboot_jpa.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface PersonRepository extends CrudRepository<Person, Long> { // Podemos utilizar tambien JPA Repository en el caso de querer mas metodos Sort, para ordenamiento y paginacion

    @Query("select p from Person p where p.id in (1,2,3)")
    List<Person> getPersonByIds();

    @Query("select p.name, length(p.name) from Person p where length(p.name)=(select min(length(p.name)) from Person p)") // Sub consulta
    public List<Object[]> getShortedName();

    @Query("select min(p.id), max(p.id), sum(p.id), avg(length(p.name)), count(p.id) from Person p")
    public Object getResumeAggregationFunction();

    @Query("select p.name, length(p.name) from Person p")
    List<Object[]> getPersonNameLength();

    @Query("select count(p) from Person p")
    Long getTotalPerson();

    @Query("select min(p.id) from Person p")
    Long getMinId();

    @Query("select max(p.id) from Person p")
    Long getMaxId();

    List<Person> findByIdBetween(Long id1, Long id2);

    List<Person> findByNameBetween(String name1, String name2);

    @Query("select p from Person p where p.name between ?1 and ?2 order by p.name")
    List<Person> findAllBetweenName(String c1, String c2);

    @Query("select p from Person p where p.id between ?1 and ?2 order by p.name")
    List<Person> findAllBetweenId(Long id1, Long id2);

    @Query("select upper(p.name || ' ' ||  p.lastName) fullname from Person p")
    List<String> findAllFullNameConcatUpper();

    @Query("select CONCAT(lower(p.name), ' ', upper(p.lastName)) fullname from Person p")
    List<String> findAllFullNameConcatLowerAndUpper();

//    @Query("select CONCAT(p.name, ' ', p.lastName) fullname from Person p")
    @Query("select p.name || ' ' ||  p.lastName fullname from Person p")
    List<String> findAllFullNameConcat();

    @Query("select COUNT(DISTINCT(p.programmingLanguage)) from Person p")
    Long findAllProgrammingLanguageDistinctCount();

    @Query("select DISTINCT(p.programmingLanguage) from Person p")
    List<String> findAllProgrammingLanguageDistinct();

    @Query("select p.name from Person p")
    List<String> findAllNames();

    @Query("select DISTINCT(p.name) from Person p")
    List<String> findAllNamesDistinct();

    @Query("select new com.schroh.springboot.jpa.springboot_jpa.dto. PersonDto(p.name,p.lastName) from Person p")
    List<PersonDto> findAllPersonDto();

    @Query("select new Person(p.name,p.lastName) from Person p")
    List<Person> findAllObjectPersonPersonalized();

    @Query("select p, p.programmingLanguage from Person p")
    List<Object[]> findAllMixPerson();

    @Query("select p.name from Person p where p.id=?1")
    String getNameByid(Long id);

    @Query("select p from Person p where p.id =?1")
    Optional<Person> findOne(Long id);

    @Query("select p from Person p where p.name =?1")
    Optional<Person> findOneName(String name);

    @Query("select p from Person p where p.name like %?1%") // busca por coincidencia
    Optional<Person> findOneLikeName(String name);

    Optional<Person> findByNameContaining(String name); // es como el Like, es decir busqueda de coincidencias pero por parte de JPA

    @Query("select p from Person p where p.programmingLanguage=?1 and p.name=?2") // No es una consulta nativa SQL, sino JPA
    List<Person> buscarByProgrammingLanguage(String programmingLanguage, String name);

    List<Person> findByProgrammingLanguageAndName(String programmingLanguage, String name);

    @Query("select p.name, p.programmingLanguage from Person p where p.programmingLanguage=?1 and p.name=?2") // Usamos Query cuando queremos realizar una consulta determinada
    List<Object[]> obtenerPersonData(String programmingLanguage, String name);

    @Query("select p.name, p.programmingLanguage from Person p where p.name=?1") // Usamos Query cuando queremos realizar una consulta determinada
    List<Object[]> obtenerPersonData(String name);

    @Query("select p.name, p.programmingLanguage from Person p where p.programmingLanguage=?1") // Usamos Query cuando queremos realizar una consulta determinada
    List<Object[]> obtenerPersonDataByProgrammingLanguage(String programmingLanguage);

    @Query("select p.name, p.programmingLanguage from Person p") // Utilizamos sobrecarga de metodos
    List<Object[]> obtenerPersonData();
}
