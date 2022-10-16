package com.ennea.valuemanage.security;

import com.ennea.valuemanage.Model.security.Authority;
import com.ennea.valuemanage.Model.security.User;
import com.ennea.valuemanage.Repositories.security.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("-----------------------------------------------------------------------------------");
        User user=userRepository.findUserByUserName(username).orElseThrow(()->{
            return new UsernameNotFoundException("Username : "+username+" is not found");
        });
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(), covertToSprigAuthorities(user.getAuthorities()));
    }

    private Collection<? extends GrantedAuthority> covertToSprigAuthorities(Set<Authority> authorities) {
        if(authorities!=null&&authorities.size()>0){
            return authorities.stream()
                    .map(Authority::getRole)
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toSet());
        }
        return new HashSet<>();
    }


}
