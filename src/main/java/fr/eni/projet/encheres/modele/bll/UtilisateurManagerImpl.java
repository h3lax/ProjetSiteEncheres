package fr.eni.projet.encheres.modele.bll;

import fr.eni.projet.encheres.modele.bo.Utilisateur;
import fr.eni.projet.encheres.modele.dal.DAOFactory;
import fr.eni.projet.encheres.modele.dal.UtilisateurDAO;

public class UtilisateurManagerImpl implements UtilisateurManager {

	private static UtilisateurManager utilisateurManager = null;
	private static UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();

	public static UtilisateurManager getInstance() {
		if (utilisateurManager == null) {
			utilisateurManager = new UtilisateurManagerImpl();
		}
		return utilisateurManager;
	}

	private UtilisateurManagerImpl() {
	}

	public boolean verifConfirmation(String motDePasse, String confirmation) {
		if (motDePasse.equals(confirmation))
			return true;
		else
			return false;
	}

	public boolean verifChampsVides(String pseudo, String nom, String prenom, String email, String rue,
			String codePostal, String ville, String motDePasse) {
		String[] champs = { pseudo, nom, email, rue, codePostal, ville, motDePasse };
		boolean validation = true;
		for (String s : champs) {
			if (s == null || s.isBlank() || s.isEmpty())
				validation = false;
		}
		return validation;
	}

	public int verifNouvelUtilisateur(String pseudo, String email) {
		int resultat = 3;
		Utilisateur utilisateur = utilisateurDAO.selectByIdentifiant(pseudo, email);
		if (utilisateur == null) {
			// pas de match trouvé
			resultat = 0;
		} else if (utilisateur.getEmail().equals(email)) {
			// email existant
			resultat = 1;
		} else {
			// Pseudo déjà utilisé
			resultat = 2;
		}
		return resultat;
	}

	public Utilisateur creerUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse) {
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
				motDePasse);
		return utilisateurDAO.creerUtilisateur(utilisateur);
	}

	public Utilisateur connection(String identifiant, String motDePasse) {
		// On fait appel à la DAL pour récupérer l'info dans la BD, il n'y a pas
		// d'acction particulière requise par la BLL
		return utilisateurDAO.connection(identifiant, motDePasse);
	}

	@Override
	public void deleteByEmail(String email, String motDePasse) {
	    // Vérifier si les paramètres ne sont pas vides ou null
	    if (email != null && !email.isEmpty() && motDePasse != null && !motDePasse.isEmpty()) {
	        // Appeler la méthode de suppression dans la DAL
	        utilisateurDAO.deleteByEmail(email, motDePasse);
	    } else {
	        // Gérer le cas où les paramètres sont vides ou null
	        // Vous pouvez choisir de générer une exception, de retourner un code d'erreur, ou de faire autre chose en conséquence.
	        // Exemple : throw new IllegalArgumentException("Email et mot de passe doivent être fournis.");
	    }
	}

}
