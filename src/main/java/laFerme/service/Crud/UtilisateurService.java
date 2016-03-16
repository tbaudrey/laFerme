/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service.Crud;

import laFerme.entity.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public interface UtilisateurService extends CrudRepository<Utilisateur, Long>{
    
    public Utilisateur findByLogin (String login);
}
