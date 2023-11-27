package com.konex.app.infrastructure.repositories;

import com.konex.app.application.services.CityService;
import com.konex.app.application.services.ClientService;
import com.konex.app.application.services.ConcessionaireService;
import com.konex.app.application.services.LocalityService;
import com.konex.app.domain.model.City;
import com.konex.app.infrastructure.entities.CityEntity;
import com.konex.app.infrastructure.entities.ClientEntity;
import com.konex.app.infrastructure.entities.ConcessionaireEntity;
import com.konex.app.infrastructure.entities.LocalityEntity;
import com.konex.app.domain.model.Concessionaire;
import com.konex.app.domain.model.Locality;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

@Component
public class H2DatabaseInitializer implements ApplicationRunner {

    @Autowired
    private ClientService clientService;

    @Autowired
    private CityService cityService;

    @Autowired
    private LocalityService localityService;

    @Autowired
    private ConcessionaireService concessionaireService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<CityEntity> cities = Arrays.asList(
                CityEntity.builder()
                        .cityName("Bogota")
                        .build(),
                CityEntity.builder()
                        .cityName("Medellin")
                        .build(),
                CityEntity.builder()
                        .cityName("Cali")
                        .build(),
                CityEntity.builder()
                        .cityName("Barranquilla")
                        .build(),
                CityEntity.builder()
                        .cityName("Cartagena")
                        .build()
        );

        cityService.createCities(cities.stream().map(CityEntity::toDomainModel).collect(Collectors.toList()));
        List<City> allCities = cityService.getAllCities();

        List<ConcessionaireEntity> concessionaires = Arrays.asList(
                ConcessionaireEntity.builder()
                        .concessionaireName("Autos Andinos")
                        .city(CityEntity.fromDomainModel(allCities.get(0)))
                        .build(),
                ConcessionaireEntity.builder()
                        .concessionaireName("Bogotá Motors")
                        .city(CityEntity.fromDomainModel(allCities.get(0)))
                        .build(),
                ConcessionaireEntity.builder()
                        .concessionaireName("Capital Autos")
                        .city(CityEntity.fromDomainModel(allCities.get(0)))
                        .build(),
                ConcessionaireEntity.builder()
                        .concessionaireName("Paisa Motors")
                        .city(CityEntity.fromDomainModel(allCities.get(1)))
                        .build(),
                ConcessionaireEntity.builder()
                        .concessionaireName("Valle Motor")
                        .city(CityEntity.fromDomainModel(allCities.get(1)))
                        .build(),
                ConcessionaireEntity.builder()
                        .concessionaireName("Antioquia Autos")
                        .city(CityEntity.fromDomainModel(allCities.get(1)))
                        .build(),
                ConcessionaireEntity.builder()
                        .concessionaireName("Valle del Cauca Autos")
                        .city(CityEntity.fromDomainModel(allCities.get(2)))
                        .build(),
                ConcessionaireEntity.builder()
                        .concessionaireName("Cali Motors")
                        .city(CityEntity.fromDomainModel(allCities.get(2)))
                        .build(),
                ConcessionaireEntity.builder()
                        .concessionaireName("Autopacífico")
                        .city(CityEntity.fromDomainModel(allCities.get(2)))
                        .build(),
                ConcessionaireEntity.builder()
                        .concessionaireName("Caribe Motors")
                        .city(CityEntity.fromDomainModel(allCities.get(3)))
                        .build(),
                ConcessionaireEntity.builder()
                        .concessionaireName("Barranquilla Motors")
                        .city(CityEntity.fromDomainModel(allCities.get(3)))
                        .build(),
                ConcessionaireEntity.builder()
                        .concessionaireName("Atlántico Motors")
                        .city(CityEntity.fromDomainModel(allCities.get(3)))
                        .build(),
                ConcessionaireEntity.builder()
                        .concessionaireName("Cartagena Motors")
                        .city(CityEntity.fromDomainModel(allCities.get(4)))
                        .build(),
                ConcessionaireEntity.builder()
                        .concessionaireName("Mar Caribe Autos")
                        .city(CityEntity.fromDomainModel(allCities.get(4)))
                        .build(),
                ConcessionaireEntity.builder()
                        .concessionaireName("Cartagena Motors")
                        .city(CityEntity.fromDomainModel(allCities.get(4)))
                        .build()
        );

        concessionaireService.createConcessionaires(concessionaires.stream().map(ConcessionaireEntity::toDomainModel).collect(Collectors.toList()));
        List <Concessionaire> allConcessionaires = concessionaireService.getAllConcessionaires();

        List<LocalityEntity> localities = Arrays.asList(
                LocalityEntity.builder()
                        .localityName("Chapinero")
                        .concessionaire(ConcessionaireEntity.fromDomainModel(allConcessionaires.get(0)))
                        .build(),
                LocalityEntity.builder()
                        .localityName("Usaquén")
                        .concessionaire(ConcessionaireEntity.fromDomainModel(allConcessionaires.get(1)))
                        .build(),
                LocalityEntity.builder()
                        .localityName("Suba")
                        .concessionaire(ConcessionaireEntity.fromDomainModel(allConcessionaires.get(2)))
                        .build(),
                LocalityEntity.builder()
                        .localityName("El Poblado")
                        .concessionaire(ConcessionaireEntity.fromDomainModel(allConcessionaires.get(3)))
                        .build(),
                LocalityEntity.builder()
                        .localityName("Laureles")
                        .concessionaire(ConcessionaireEntity.fromDomainModel(allConcessionaires.get(4)))
                        .build(),
                LocalityEntity.builder()
                        .localityName("Envigado")
                        .concessionaire(ConcessionaireEntity.fromDomainModel(allConcessionaires.get(5)))
                        .build(),
                LocalityEntity.builder()
                        .localityName("Granada")
                        .concessionaire(ConcessionaireEntity.fromDomainModel(allConcessionaires.get(6)))
                        .build(),
                LocalityEntity.builder()
                        .localityName("San Fernando")
                        .concessionaire(ConcessionaireEntity.fromDomainModel(allConcessionaires.get(7)))
                        .build(),
                LocalityEntity.builder()
                        .localityName("El Peñón")
                        .concessionaire(ConcessionaireEntity.fromDomainModel(allConcessionaires.get(8)))
                        .build(),
                LocalityEntity.builder()
                        .localityName("Riomar")
                        .concessionaire(ConcessionaireEntity.fromDomainModel(allConcessionaires.get(9)))
                        .build(),
                LocalityEntity.builder()
                        .localityName("Alto Prado")
                        .concessionaire(ConcessionaireEntity.fromDomainModel(allConcessionaires.get(10)))
                        .build(),
                LocalityEntity.builder()
                        .localityName("Villa Santos")
                        .concessionaire(ConcessionaireEntity.fromDomainModel(allConcessionaires.get(11)))
                        .build(),
                LocalityEntity.builder()
                        .localityName("Bocagrande")
                        .concessionaire(ConcessionaireEntity.fromDomainModel(allConcessionaires.get(12)))
                        .build(),
                LocalityEntity.builder()
                        .localityName("Getsemaní")
                        .concessionaire(ConcessionaireEntity.fromDomainModel(allConcessionaires.get(13)))
                        .build(),
                LocalityEntity.builder()
                        .localityName("Manga")
                        .concessionaire(ConcessionaireEntity.fromDomainModel(allConcessionaires.get(14)))
                        .build()
        );

        localityService.createLocalities(localities.stream().map(LocalityEntity::toDomainModel).collect(Collectors.toList()));
        List<Locality> allLocalities = localityService.getAllLocalities();

        List<ClientEntity> additionalClients = Arrays.asList(
                // Bogotá - Chapinero
                ClientEntity.builder()
                        .fullName("Laura Garcia Chapinero")
                        .idNumber("100666")
                        .address("Calle 63 #15-22")
                        .phoneNumber("3151122334")
                        .email("laura.chapinero@example.com")
                        .locality(LocalityEntity.fromDomainModel(allLocalities.get(0)))
                        .build(),

                // Bogotá - Usaquén
                ClientEntity.builder()
                        .fullName("Andres Ramirez Usaquén")
                        .idNumber("100777")
                        .address("Carrera 7 #120-35")
                        .phoneNumber("3145566778")
                        .email("andres.usaquen@example.com")
                        .locality(LocalityEntity.fromDomainModel(allLocalities.get(1)))
                        .build(),

                // Bogotá - Suba
                ClientEntity.builder()
                        .fullName("Isabella Hernandez Suba")
                        .idNumber("100888")
                        .address("Avenida Suba #85-10")
                        .phoneNumber("3134455667")
                        .email("isabella.suba@example.com")
                        .locality(LocalityEntity.fromDomainModel(allLocalities.get(2)))
                        .build(),

                // Medellín - El Poblado
                ClientEntity.builder()
                        .fullName("Alejandro Martinez El Poblado")
                        .idNumber("100999")
                        .address("Carrera 43A #7-50")
                        .phoneNumber("3167788990")
                        .email("alejandro.poblado@example.com")
                        .locality(LocalityEntity.fromDomainModel(allLocalities.get(3)))
                        .build(),

                // Medellín - Laureles
                ClientEntity.builder()
                        .fullName("Sofia Lopez Laureles")
                        .idNumber("101000")
                        .address("Calle 70 #35-18")
                        .phoneNumber("3190011223")
                        .email("sofia.laureles@example.com")
                        .locality(LocalityEntity.fromDomainModel(allLocalities.get(4)))
                        .build(),

                // Medellín - Envigado
                ClientEntity.builder()
                        .fullName("Javier Torres Envigado")
                        .idNumber("101111")
                        .address("Avenida Las Vegas #22-45")
                        .phoneNumber("3171122334")
                        .email("javier.envigado@example.com")
                        .locality(LocalityEntity.fromDomainModel(allLocalities.get(5)))
                        .build(),

                // Cali - Granada
                ClientEntity.builder()
                        .fullName("Valentina Ramirez Granada")
                        .idNumber("101222")
                        .address("Carrera 23 #15-29")
                        .phoneNumber("3142233445")
                        .email("valentina.granada@example.com")
                        .locality(LocalityEntity.fromDomainModel(allLocalities.get(6)))
                        .build(),

                // Cali - San Fernando
                ClientEntity.builder()
                        .fullName("Martin Silva San Fernando")
                        .idNumber("101333")
                        .address("Calle 9 #30-40")
                        .phoneNumber("3123344556")
                        .email("martin.sanfernando@example.com")
                        .locality(LocalityEntity.fromDomainModel(allLocalities.get(7)))
                        .build(),

                // Cali - El Peñón
                ClientEntity.builder()
                        .fullName("Catalina Vargas El Peñón")
                        .idNumber("101444")
                        .address("Carrera 2 #10-15")
                        .phoneNumber("3114455667")
                        .email("catalina.penon@example.com")
                        .locality(LocalityEntity.fromDomainModel(allLocalities.get(8)))
                        .build(),

                // Barranquilla - Riomar
                ClientEntity.builder()
                        .fullName("Ricardo Rodriguez Riomar")
                        .idNumber("101555")
                        .address("Calle 80 #45-60")
                        .phoneNumber("3195566778")
                        .email("ricardo.riomar@example.com")
                        .locality(LocalityEntity.fromDomainModel(allLocalities.get(9)))
                        .build(),

                // Barranquilla - Alto Prado
                ClientEntity.builder()
                        .fullName("Camila Torres Alto Prado")
                        .idNumber("101666")
                        .address("Carrera 45 #85-22")
                        .phoneNumber("3176677889")
                        .email("camila.altoprado@example.com")
                        .locality(LocalityEntity.fromDomainModel(allLocalities.get(10)))
                        .build(),

                // Barranquilla - Villa Santos
                ClientEntity.builder()
                        .fullName("Diego Hernandez Villa Santos")
                        .idNumber("101777")
                        .address("Avenida Circunvalar #12-30")
                        .phoneNumber("3137788990")
                        .email("diego.villasantos@example.com")
                        .locality(LocalityEntity.fromDomainModel(allLocalities.get(11)))
                        .build(),

                // Cartagena - Bocagrande
                ClientEntity.builder()
                        .fullName("Natalia Martinez Bocagrande")
                        .idNumber("101888")
                        .address("Calle 5 #8-40")
                        .phoneNumber("3118899001")
                        .email("natalia.bocagrande@example.com")
                        .locality(LocalityEntity.fromDomainModel(allLocalities.get(12)))
                        .build(),

                // Cartagena - Getsemaní
                ClientEntity.builder()
                        .fullName("Fernando Diaz Getsemaní")
                        .idNumber("101999")
                        .address("Carrera 10 #25-15")
                        .phoneNumber("3149900112")
                        .email("fernando.getsemani@example.com")
                        .locality(LocalityEntity.fromDomainModel(allLocalities.get(13)))
                        .build(),

                // Cartagena - Manga
                ClientEntity.builder()
                        .fullName("Carolina Lopez Manga")
                        .idNumber("102000")
                        .address("Avenida del Arsenal #30-18")
                        .phoneNumber("3180011223")
                        .email("carolina.manga@example.com")
                        .locality(LocalityEntity.fromDomainModel(allLocalities.get(14)))
                        .build()
        );

        clientService.createClients(additionalClients.stream().map(ClientEntity::toDomainModel).collect(Collectors.toList()));
    }
}