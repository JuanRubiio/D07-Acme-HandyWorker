
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Actor;
import domain.SocialProfile;

@Repository
public interface SocialProfileRepository extends JpaRepository<SocialProfile, Integer> {

	@Query("select s from SocialProfile s where s.actor = ?1")
	SocialProfile getSocialProfileForActor(Actor a1);

}
