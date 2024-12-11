import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Consumer<Etudiant> afficherEtudiant = etudiant -> {
            System.out.println("Étudiant : " + etudiant);
        };

        Function<Etudiant, String> extraireNom = etudiant -> {
            return "Nom : " + etudiant.getNom();
        };

        Supplier<Etudiant> creerEtudiant = () -> {
            return new Etudiant(0, "Inconnu", 18);
        };

        Comparator<Etudiant> comparerParId = (etudiant1, etudiant2) -> {
            return Integer.compare(etudiant1.getId(), etudiant2.getId());
        };

        Etudiant etu1 = new Etudiant(1, "Eya", 22);
        Etudiant etu2 = new Etudiant(2, "Salah", 20);

        System.out.println("Affichage des étudiants :");
        afficherEtudiant.accept(etu1);
        afficherEtudiant.accept(etu2);

        System.out.println("Extraction des noms :");
        System.out.println(extraireNom.apply(etu1));
        System.out.println(extraireNom.apply(etu2));

        System.out.println("Création d'un étudiant par défaut :");
        Etudiant etuParDefaut = creerEtudiant.get();
        System.out.println(etuParDefaut);

        System.out.println("Comparaison par ID :");
        int comparaison = comparerParId.compare(etu1, etu2);
        if (comparaison < 0) {
            System.out.println(etu1.getNom() + " a un ID inférieur à " + etu2.getNom());
        } else if (comparaison > 0) {
            System.out.println(etu1.getNom() + " a un ID supérieur à " + etu2.getNom());
        } else {
            System.out.println(etu1.getNom() + " a le même ID que " + etu2.getNom());
        }
    }
}
