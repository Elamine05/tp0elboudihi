
package ma.emsi.elboudihi.tp0elboudihi.service;

import jakarta.enterprise.context.Dependent;

import java.io.Serializable;
import java.util.Locale;

/**
 * Classe de service pour les modificateurs de question.
 * Un modificateur de question prend en entrée une question et retourne
 * la question modifiée.
 */
@Dependent
public class GenerateurReponse implements Serializable {

    private boolean roleSystemeAffiche = false;

    /**
     * Génère une réponse en analysant le texte saisi.
     * Traitement personnel pour le bonus du TP0.
     */
    public String genererReponse(String question, String roleSysteme) {

        String resultat = "||";

        // Conserver le rôle système au début de la première réponse.
        if (!this.roleSystemeAffiche && roleSysteme != null) {
            resultat += roleSysteme.toUpperCase(Locale.FRENCH) + "\n";
            this.roleSystemeAffiche = true;
        }

        // Préparation du texte.
        String texte = question.trim();
        String[] mots = texte.split("\\s+");

        // Rechercher le mot le plus long.
        String motPlusLong = "";

        for (String mot : mots) {
            String motNettoye = mot.replaceAll("[^\\p{L}\\p{N}]", "");

            if (motNettoye.length() > motPlusLong.length()) {
                motPlusLong = motNettoye;
            }
        }

        // Construire la réponse.
        resultat += "ANALYSE DU TEXTE\n";
        resultat += "Nombre de mots : " + mots.length + "\n";
        resultat += "Nombre de caractères : " + texte.length() + "\n";
        resultat += "Mot le plus long : " + motPlusLong + "\n";

        resultat += "||";

        return resultat;
    }
}
