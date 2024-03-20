package com.example.api.Auth;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static codeFusion.IntershipAPI.IntershipApplicationAPI.utils.Constants.APP_ROOT;


@RestController
@CrossOrigin(origins="*")
@RequestMapping(APP_ROOT+"/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping(value="/etudiant/registerEtudiant")
    public ResponseEntity<AuthenticationResponse> registerEtudiant(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.registerEtudiant(request));
    }
    @PostMapping(value="/etudiant/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequestEtudiant request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping(value="/entreprise/registerEntreprise")
    public ResponseEntity<AuthenticationResponse> registerEntreprise(@RequestBody RegisterRequestEntreprise request){
        return ResponseEntity.ok(authenticationService.registerEntreprise(request));
    }
    @PostMapping(value="/entreprise/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticateEntreprise(@RequestBody AuthenticationRequestEntreprise request){
        return ResponseEntity.ok(authenticationService.authenticateEntreprise(request));
    }
}