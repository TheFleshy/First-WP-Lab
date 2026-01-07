package mk.ukim.finki.wp.june2025g1.repository;

import mk.ukim.finki.wp.june2025g1.model.Founder;
import org.springframework.stereotype.Repository;

@Repository
public interface FounderRepository  extends JpaSpecificationRepository<Founder, Long> {
}
