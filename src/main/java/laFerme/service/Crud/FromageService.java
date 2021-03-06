/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service.Crud;

import java.util.List;
import laFerme.entity.Fermier;
import laFerme.entity.Fromage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public interface FromageService extends CrudRepository<Fromage, Long>{
    
    public List<Fromage> findByFermier (Fermier fermier);
    long countByFermierId(long id);
}
