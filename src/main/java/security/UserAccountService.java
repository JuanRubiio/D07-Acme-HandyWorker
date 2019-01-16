
package security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Actor;

@Service
@Transactional
public class UserAccountService {

	// Managed repository -----------------------------------------------------

	@Autowired
	private UserAccountRepository	userAccountRepository;


	// Supporting services ----------------------------------------------------

	// Constructors -----------------------------------------------------------

	public UserAccountService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public UserAccount createForCustomer() {
		UserAccount res;
		res = new UserAccount();
		final Authority authority = new Authority();
		final List<Authority> authorities = new ArrayList<Authority>();
		authority.setAuthority(Authority.CUSTOMER);
		authorities.add(authority);
		res.setAuthorities(authorities);

		return res;
	}

	public UserAccount createForHandyworker() {
		UserAccount res;
		res = new UserAccount();
		final Authority authority = new Authority();
		final List<Authority> authorities = new ArrayList<Authority>();
		authority.setAuthority(Authority.HANDYWORKER);
		authorities.add(authority);
		res.setAuthorities(authorities);

		return res;
	}

	public UserAccount createForSponsor() {
		UserAccount res;
		res = new UserAccount();
		final Authority authority = new Authority();
		final List<Authority> authorities = new ArrayList<Authority>();
		authority.setAuthority(Authority.SPONSOR);
		authorities.add(authority);
		res.setAuthorities(authorities);

		return res;
	}

	public UserAccount createForReferee() {
		UserAccount res;
		res = new UserAccount();
		final Authority authority = new Authority();
		final List<Authority> authorities = new ArrayList<Authority>();
		authority.setAuthority(Authority.REFEREE);
		authorities.add(authority);
		res.setAuthorities(authorities);

		return res;
	}

	public UserAccount createForAdmin() {
		UserAccount res;
		res = new UserAccount();
		final Authority authority = new Authority();
		final List<Authority> authorities = new ArrayList<Authority>();
		authority.setAuthority(Authority.ADMIN);
		authorities.add(authority);
		res.setAuthorities(authorities);

		return res;
	}

	public UserAccount findByActor(final Actor actor) {
		Assert.notNull(actor);

		UserAccount result;

		result = this.userAccountRepository.findByActorId(actor.getId());

		return result;
	}
	public Collection<UserAccount> findAll() {
		return this.userAccountRepository.findAll();
	}
	public UserAccount findOne(final int userAccountId) {
		return this.userAccountRepository.findOne(userAccountId);
	}

	public UserAccount save(final UserAccount userAccount) {

		return this.userAccountRepository.save(userAccount);

	}
	public void delete(final UserAccount userAccount) {
		this.userAccountRepository.delete(userAccount);
	}

	public UserAccount findByUsername(final String username) {
		return this.userAccountRepository.findByUsername(username);
	}
}
