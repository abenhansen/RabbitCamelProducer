package travelagency.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import travelagency.entities.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {
}
