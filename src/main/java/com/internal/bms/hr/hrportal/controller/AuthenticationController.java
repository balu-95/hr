package com.internal.bms.hr.hrportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internal.bms.hr.hrportal.entity.AuthenticationRequest;
import com.internal.bms.hr.hrportal.entity.AuthenticationResponse;
import com.internal.bms.hr.hrportal.entity.SignUpRequest;
import com.internal.bms.hr.hrportal.service.CustomUserDetailsService;
import com.internal.bms.hr.hrportal.service.UserService;
import com.internal.bms.hr.hrportal.util.JwtUtil;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired(required = true)
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) 
            throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return new AuthenticationResponse(jwt);
    }

    @PostMapping("/signup")
    public AuthenticationResponse registerNewUser(@RequestBody SignUpRequest signupRequest) {
        userService.registerNewUser(signupRequest.getUsername(), signupRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(signupRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        return new AuthenticationResponse(jwt);
    }
}
