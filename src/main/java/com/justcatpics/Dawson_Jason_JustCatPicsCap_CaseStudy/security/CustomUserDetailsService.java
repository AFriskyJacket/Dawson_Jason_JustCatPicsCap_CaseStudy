package com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.security;

    import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.model.User;
    import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.repository.UserRepository;
    import org.springframework.security.core.authority.SimpleGrantedAuthority;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.core.userdetails.UsernameNotFoundException;
        import org.springframework.stereotype.Service;

    import java.util.Collections;
    import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        User user = userRepository.findByEmailIgnoreCase(usernameOrEmail);
        if(user != null) {
            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getName())));
                    //user.getRole().stream()
                    //        .map((role) -> new SimpleGrantedAuthority(role.getName()))
                    //        .collect(Collectors.toList()));
        }else {
            throw new UsernameNotFoundException("Invalid email or password");
        }
    }
}
