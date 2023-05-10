/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.openfoodfact;

import com.mycompany.controllers.CsvFile;
import com.mycompany.dao.JPAUtils;
import jakarta.persistence.EntityManager;
import java.util.Scanner;


/**
 *
 * @author Tommy
 */
public class OpenFoodFact {

    public static void main(String[] args) {
       // Scanner scanner = new Scanner(System.in);
        CsvFile csvFile = new CsvFile();
        csvFile.parse();
//        System.out.println("Bonjour et bienvenue !");
//        System.out.println("Choissisez un chiffre entre ... et ... suivant les informations suivantes :");
//        System.out.println("1 : Voir tout les Elements. !Attention! Il y a plus de 10000 elements.");
//        System.out.println("2 : Voir les marques");
//        System.out.println("3 : Voir les Elements suivant les ingrédients");
//        System.out.println("A suivre ...");
//        System.out.println("------------------------------------------------");
//        String input = scanner.nextLine();
//        
//        switch (input) {
//            case "1":
//                System.out.println("Voici tout les elements :");
//                
//                break;
//            case "2":
//                System.out.println("Voici toutes les marques :");
//                csvFile.parse();
//                break;
//            case "3":
//                System.out.println("Quelles sont les Ingrédients ?");
//                String ingre = scanner.nextLine();
//                // faire la suite pour l'affichage
//                break;
//            default:
//                System.out.println("Veuillez rentrer un chiffre en rapport avec les chiffres suivants");
//       // }
        JPAUtils.getInstance().getEntityManager().close();
    }
}
