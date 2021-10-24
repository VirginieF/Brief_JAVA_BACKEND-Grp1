package gespost.persistance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gespost.persistance.beanDo.PostDo;

/**
 * Interface Repository héritant de la librairie {@link JpaRepository}
 * 
 * @author Arwa, Mireille, Sabrine, Virginie
 *
 */
@Repository
public interface IPostDao extends JpaRepository<PostDo, String> {
	
    /**
     * Permet de recupérer la liste des posts par titre
     * 
     * @param title
     * @return liste des posts par titre
     */
    List<PostDo> findAllByTitleContaining(String title);
}
