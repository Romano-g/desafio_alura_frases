package com.example.demo;

import com.example.demo.models.Page;
import com.example.demo.models.SerieData;
import com.example.demo.repository.Repository;
import com.example.demo.services.ConsumeAPI;
import com.example.demo.services.DataConversor;

import java.util.Scanner;

public class Main {
    private final String URL = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6498ae93";

    private ConsumeAPI consumeAPI = new ConsumeAPI();
    private DataConversor dataConversor = new DataConversor();

    private int option = -1;
    private Scanner scanner = new Scanner(System.in);

    private Repository repository;

    public Main(Repository repository) {
        this.repository = repository;
    }

    public void showMenu () {
        while (option != 0) {
            System.out.println("\nDigite 1 para adicionar ao banco de dados ou 0 para sair");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addToDatabase();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void addToDatabase() {
        System.out.println("\nDigite um titulo de série");
        var userTitle = scanner.nextLine();

        System.out.println("\nDigite uma frase marcante da série");
        var userPhrase = scanner.nextLine();

        System.out.println("\nDigite o personagem principal da série");
        var userCharacter = scanner.nextLine();

        var json = consumeAPI.obtainData(URL + userTitle.replace(" ", "+") + API_KEY);

        SerieData serieData = dataConversor.obtainData(json, SerieData.class);

        Page page = new Page(serieData.titulo(),  "\"" + userPhrase + "\"", userCharacter, serieData.poster());

        repository.save(page);

    }
}
