package farmacia.farmacia.remedios;

import org.springframework.data.jpa.repository.JpaRepository;

//estamos extendendo um objeto RemedioEntity e o tipo do identificador, nesse caso o Id, que é long
public interface RemedioRepository extends JpaRepository<RemedioEntity, Long> {
}
