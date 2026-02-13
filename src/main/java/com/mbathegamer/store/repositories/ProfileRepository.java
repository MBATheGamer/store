package com.mbathegamer.store.repositories;

// import org.springframework.data.jpa.repository.EntityGraph;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// import com.mbathegamer.store.dtos.UserSummary;
import com.mbathegamer.store.entities.Profile;
// import java.util.List;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {
  // @EntityGraph(attributePaths = "user")
  // @Query("select p.id as id, p.user.email as email from Profile p where p.loyaltyPoints >
  // :loyaltyPoints order by p.user.email")
  // List<UserSummary> findLoyaltyPoints(@Param("loyaltyPoints") Integer loyaltyPoints);
  // List<Profile> findByLoyaltyPointsGreaterThanOrderByUserEmail(Integer loyaltyPoints);
}
