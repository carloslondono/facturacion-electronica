package co.edu.cotecnova.facturacionelectronica.infraestructura.controlador;

import co.edu.cotecnova.facturacionelectronica.dominio.dto.AutenticationRequest;
import co.edu.cotecnova.facturacionelectronica.dominio.dto.AuthenticationResponse;
import co.edu.cotecnova.facturacionelectronica.dominio.servicio.FEUserDetailService;
import co.edu.cotecnova.facturacionelectronica.infraestructura.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private FEUserDetailService feUserDetailService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AutenticationRequest autenticationRequest){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(autenticationRequest.getUsername(), autenticationRequest.getPassword()));
            UserDetails userDetails = feUserDetailService.loadUserByUsername(autenticationRequest.getUsername());
            String jwt = jwtUtil.generatToken(userDetails);
            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        }catch (BadCredentialsException e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
