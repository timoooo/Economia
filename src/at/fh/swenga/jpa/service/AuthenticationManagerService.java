package at.fh.swenga.jpa.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.jpa.dao.PlayerRepository;
import at.fh.swenga.jpa.model.PlayerModel;
import at.fh.swenga.jpa.model.PlayerRole;

@Service
@Transactional
public class AuthenticationManagerService implements UserDetailsService {

	@Autowired
	PlayerRepository playerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		PlayerModel player = null;
		player = playerRepository.findByUsername(username);

		List<GrantedAuthority> authorities = buildUserAuthority(player.getPlayerRole());

		return buildUserForAuthentication(player, authorities);
	}

	private org.springframework.security.core.userdetails.User buildUserForAuthentication(PlayerModel player,
			List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(player.getUsername(), player.getPassword(), true,
				true, // account not expired
				true, // credentials not expired
				true, // account not locked
				authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<PlayerRole> playerRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		for (PlayerRole playerRole : playerRoles) {
			setAuths.add(new SimpleGrantedAuthority(playerRole.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

}
