package fr.eni.projet.encheres.modele.bll;

import fr.eni.projet.encheres.modele.bo.Utilisateur;
import fr.eni.projet.encheres.modele.dal.DAOFactory;
import fr.eni.projet.encheres.modele.dal.UtilisateurDAO;

public class UtilisateurManagerImpl implements UtilisateurManager{
	
	private static UtilisateurManager utilisateurManager = null;
	private static UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
	
	public static UtilisateurManager getInstance() {
		if (utilisateurManager == null) {
			utilisateurManager = new UtilisateurManagerImpl();
		}
		return utilisateurManager ;
	}
	
	private UtilisateurManagerImpl() {
	}
	


	public boolean verifEstEgal(String motDePasse, String confirmation) {
		if (motDePasse.equals(confirmation)) return true;
		else return false;
	}
	
	public boolean verifChampsRemplits(String s) {
		if (s == null || s.isBlank() || s.isEmpty()) return false;
		else return true;
	}
	public boolean verifChampsRemplits(String pseudo, String nom, String prenom, String email,
			String rue, String codePostal, String ville, String motDePasse) {
		String[] champs = {pseudo, nom, email, rue, codePostal, ville, motDePasse};
		boolean validation = true;
		for (String s : champs) {
			if (!verifChampsRemplits(s)) validation = false;
		}
		return validation;
	}
	
	public int verifNouvelUtilisateur(String pseudo, String email) {
		int resultat = 3;
		Utilisateur utilisateur = utilisateurDAO.selectByIdentifiant(pseudo, email);
		if (utilisateur == null) {
			//pas de match trouvé
			resultat = 0;
		}else if (utilisateur.getEmail().equals(email)) {
			//email existant
			resultat = 1;
		}else {
			//Pseudo déjà utilisé
			resultat = 2;
		}
		return resultat;
	}
	
	public Utilisateur creerUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse) {
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
		return utilisateurDAO.creerUtilisateur(utilisateur);
	}
	
	public Utilisateur connection(String identifiant, String motDePasse) {
		// On fait appel à la DAL pour récupérer l'info dans la BD, il n'y a pas d'acction particulière requise par la BLL
		return utilisateurDAO.connection(identifiant, motDePasse);
	}

	public Utilisateur selectByIndentifiant(String identifiant) {
		return utilisateurDAO.selectByIdentifiant(identifiant);
	}
	public Utilisateur selectByIndentifiant(int identifiant) {
		return utilisateurDAO.selectByIdentifiant(identifiant);
	}

	public boolean modifierUtilisateur(Utilisateur utilisateur) {
		boolean modificationEffectue = false;
		if (utilisateurDAO.modifierUtilisateur(utilisateur) == 1) modificationEffectue = true;
		else System.out.println("C'est chiant");
		return modificationEffectue;
	}

	public boolean supprimerCompte(int noUtilisateur) {
		boolean modificationEffectue = false;
		if (utilisateurDAO.supprimerUtilisateur(noUtilisateur) == 1) modificationEffectue = true;
		return modificationEffectue;
	}

	public boolean verifPoints(Utilisateur utilisateur, int montantEnchere) {
		if (utilisateur.getCredit() >= montantEnchere) return true;
		else return false;
	}

	public boolean paiement(Utilisateur utilisateur, int montantEnchere) {
		utilisateur.setCredit(utilisateur.getCredit() - montantEnchere);
		if (utilisateurDAO.modifierUtilisateur(utilisateur) == 1) return true;
		return false;
	}

	public boolean credit(Utilisateur utilisateur, int montantEnchere) {
		utilisateur.setCredit(utilisateur.getCredit() + montantEnchere);
		if (utilisateurDAO.modifierUtilisateur(utilisateur) == 1) return true;
		return false;
	}

	public boolean credit(int noUtilisateur, int montantEnchere) {
		Utilisateur utilisateur = utilisateurDAO.selectByIdentifiant(noUtilisateur);
		return credit(utilisateur, montantEnchere);
		
	}

	

	

}
