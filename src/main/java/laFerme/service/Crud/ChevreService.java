/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service.Crud;

import java.util.Date;
import java.util.List;
import laFerme.entity.Chevre;
import laFerme.entity.Fermier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public interface ChevreService extends CrudRepository<Chevre, Long>{
    
    public List<Chevre> findByFermierOrderByDateCreation (Fermier fermier);
    public List<Chevre> findByDateDerniereNutritionOrderByDateCreation (Date dateDerniereNutrition);
}
