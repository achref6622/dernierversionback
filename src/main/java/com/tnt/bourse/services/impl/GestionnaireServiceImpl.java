package com.tnt.bourse.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tnt.bourse.entities.Client;
import com.tnt.bourse.entities.Gestionnaire;
import com.tnt.bourse.model.MessageResponse;
import com.tnt.bourse.repositories.GestionnaireRepository;
import com.tnt.bourse.services.GestionnaireService;
@Service
public class GestionnaireServiceImpl implements GestionnaireService {

	@Autowired
 private GestionnaireRepository gestionnairerepository ; 
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Override
	public MessageResponse save(Gestionnaire gestionnaire) {
		// TODO Auto-generated method stub

		Gestionnaire	list = gestionnairerepository.findByEmail(gestionnaire.getEmail());
			if (list != null) {
				return new MessageResponse(false, "Email existant");
			}
		
		String pwd = bCryptPasswordEncoder.encode(gestionnaire.getPassword());
		gestionnaire.setPassword(pwd);

			gestionnairerepository.save(gestionnaire) ; 
			return new MessageResponse(true, "operation effectue avec succe") ; 
	}

	@Override
	public MessageResponse update(Gestionnaire gestionnaire) {
		// TODO Auto-generated method stub
		List<Gestionnaire> list = gestionnairerepository.findByEmailAndId(gestionnaire.getEmail(), gestionnaire.getId()) ; 
		if (list.isEmpty()) {
		Gestionnaire	a = gestionnairerepository.findByEmail(gestionnaire.getEmail());
			if (a !=null ) {
				return new MessageResponse(false, "Email existant");
			}
		}
		
		
	
			gestionnairerepository.save(gestionnaire) ; 
			return new MessageResponse(true, "operation effectue avec succe") ;
	}

	@Override
	public MessageResponse delete(int id) {
Gestionnaire g = gestionnairerepository.findById(id);
if ( g== null ) {
	return new MessageResponse(false, "gestionnairfe n existe pas") ; 
}
if ( g.getClients()!=null) {
	return new MessageResponse( false, "gestionnaire a des client" ) ; 
	

}

gestionnairerepository.deleteById(id);
return new MessageResponse(true, "operation effectue avc succe ") ; 
}

	@Override
	public List<Gestionnaire> findAll() {
		return gestionnairerepository.findAll() ; 
				}

	@Override
	public Gestionnaire addClient(Gestionnaire  g , Client client) {
	List <Client> ges = g.getClients() ; 
	ges.add(client) ; 
		g.setClients(ges);
		return g; 
	
	}

	@Override
	public List<Client> mesclient(int id) {
		
	return  gestionnairerepository.findById(id).getClients() ; 
	}
	
	
	

}
