/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service.Crud;

import laFerme.entity.Fermier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public interface FermierService extends CrudRepository<Fermier, Long>{
    public Fermier findByName (String Name);
    public Fermier findOneById (long id);
}
