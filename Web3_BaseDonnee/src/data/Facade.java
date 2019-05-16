package data;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.Collection;

@Singleton
public class Facade {

	@PersistenceContext
	private EntityManager em;
	

	public Facade() {}

	public void ajoutPersonne(String nom, String prenom) {
		em.persist(new Personne(nom,prenom));
	}

	public void ajoutAdresse(String rue, String ville) {
		em.persist(new Adresse(rue,ville));
	}

	public Collection<Personne> listePersonnes() {
		TypedQuery<Personne> req = em.createQuery("select p from Personne as p",Personne.class);
		return req.getResultList();
	}

	public Collection<Adresse> listeAdresses() {
		TypedQuery<Adresse> req = em.createQuery("select a from Adresse as a",Adresse.class);
		return req.getResultList();
	}

	public void associer(int idPersonne, int idAdresse) {
		Personne personne = em.find(Personne.class, idPersonne);
		Adresse adresse = em.find(Adresse.class, idAdresse);
		personne.getAdresses().add(adresse);
	}

}
