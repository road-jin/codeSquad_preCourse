package org.codesquad.population;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountryPopulationManagement {

    private final Scanner scanner;
    private final Map<String, Integer> countryPopulation;

    public CountryPopulationManagement() {
        this.countryPopulation = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("나라 이름과 인구를 입력하세요.(예: Korea 5000)");
        addController();
        findController();
        scanner.close();
    }

    private void addController() {
        String country = "";

        while (isExit(country)) {
            System.out.print("나라 이름, 인구 >> ");
            country = scanner.next();
            put(country);
        }
    }

    private boolean isExit(String country) {
        return !country.equals("그만");
    }

    private void put(String country) {
        if (country.equals("그만")) {
            return;
        }

        int population = scanner.nextInt();
        countryPopulation.put(country, population);
    }

    private void findController() {
        String country = "";

        while (isExit(country)) {
            System.out.print("\n인구 검색 >> ");
            country = scanner.next();
            printCountryAndPopulation(country);
        }
    }

    private void printCountryAndPopulation(String country) {
        if (country.equals("그만")) {
            return;
        }

        if (countryPopulation.containsKey(country)) {
            System.out.printf("%s의 인구는 %d\n", country, countryPopulation.get(country));
            return;
        }

        System.out.printf("%s 나라는 없습니다.\n", country);
    }
}
