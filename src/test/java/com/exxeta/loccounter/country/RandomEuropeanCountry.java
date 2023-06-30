package com.exxeta.loccounter.country;

import java.util.Random;

public class RandomEuropeanCountry {

  /**
   * Represents a country with its properties.
   */
  private static class Country {

    // Array of European countries
    private String name;

    // Array of languages spoken in the respective countries
    private String language;

    // Array of populations of the respective countries
    private int population;

    // Array of areas of the respective countries
    private int area;

    /**
     * Constructs a Country object.
     *
     * @param name       The name of the country.
     * @param language   The language spoken in the country.
     * @param population The population of the country.
     * @param area       The area of the country in square kilometers.
     */
    public Country(String name, String language, int population, int area) {
      this.name = name;
      this.language = language;
      this.population = population;
      this.area = area;
    }

    /**
     * Returns the name of the country.
     *
     * @return The name of the country.
     */
    public String getName() {
      return name;
    }

    /**
     * Returns the language spoken in the country.
     *
     * @return The language spoken in the country.
     */
    public String getLanguage() {
      return language;
    }

    /**
     * Returns the population of the country.
     *
     * @return The population of the country.
     */
    public int getPopulation() {
      return population;
    }

    /**
     * Returns the area of the country in square kilometers.
     *
     * @return The area of the country in square kilometers.
     */
    public int getArea() {
      return area;
    }
  }

  private Country[] countries = {
      new Country("Albania", "Albanian", 2862427, 28748),
      new Country("Andorra", "Catalan", 76177, 468),
      new Country("Austria", "German", 9006398, 83879),
      new Country("Belarus", "Belarusian", 9408400, 207600),
      new Country("Belgium", "Dutch, French, German", 11433673, 30528),
      new Country("Bosnia and Herzegovina", "Bosnian", 3511372, 51209),
      new Country("Bulgaria", "Bulgarian", 7000039, 110879),
      new Country("Croatia", "Croatian", 4105267, 56594),
      new Country("Cyprus", "Greek, Turkish", 1207359, 9251),
      new Country("Czech Republic", "Czech", 10708981, 78865),
      new Country("Denmark", "Danish", 5822763, 43094),
      new Country("Estonia", "Estonian", 1325648, 45227),
      new Country("Finland", "Finnish", 5515525, 338424),
      new Country("France", "French", 67214716, 551695),
      new Country("Germany", "German", 83517045, 357022),
      new Country("Greece", "Greek", 10715549, 131957),
      new Country("Hungary", "Hungarian", 9769526, 93030),
      new Country("Iceland", "Icelandic", 366130, 103000),
      new Country("Ireland", "Irish, English", 4857000, 70273),
      new Country("Italy", "Italian", 60431283, 301340),
      new Country("Latvia", "Latvian", 1910272, 64559),
      new Country("Liechtenstein", "German", 38749, 160),
      new Country("Lithuania", "Lithuanian", 2791444, 65300),
      new Country("Luxembourg", "Luxembourgish", 626108, 2586),
      new Country("Malta", "Maltese, English", 502653, 316),
      new Country("Moldova", "Romanian", 4033963, 33846),
      new Country("Monaco", "French", 38499, 2),
      new Country("Montenegro", "Montenegrin", 628062, 13812),
      new Country("Netherlands", "Dutch", 17134872, 41850),
      new Country("North Macedonia", "Macedonian", 1960772, 25713),
      new Country("Norway", "Norwegian", 5491218, 323802),
      new Country("Poland", "Polish", 37950802, 312696),
      new Country("Portugal", "Portuguese", 10276617, 92090),
      new Country("Romania", "Romanian", 1953030, 238391),
      new Country("Russia", "Russian", 3338723, 17098242),
      new Country("San Marino", "Italian", 33400, 61),
      new Country("Serbia", "Serbian", 705741, 77474),
      new Country("Slovakia", "Slovak", 5457926, 88361),
      new Country("Slovenia", "Slovene", 2078932, 49035),
      new Country("Spain", "Spanish", 4739423, 20273),
      new Country("Sweden", "Swedish", 86340000, 450295),
      new Country("Switzerland", "German, French, Italian, Romansh", 65273511, 603628),
      new Country("Ukraine", "Ukrainian", 825, 998),
      new Country("United Kingdom", "English", 1000, 243610),
      new Country("Vatican City", "Italian", 0, 0)
  };

  private Random random;

  /**
   * Constructs a RandomEuropeanCountry object. Initializes the Random object.
   */
  public RandomEuropeanCountry() {
    random = new Random();
  }

  /**
   * Generates a random European country.
   *
   * @return The random European country.
   */
  public Country getRandomCountry() {
    int index = random.nextInt(countries.length);
    return countries[index];
  }

  public static void main(String[] args) {
    RandomEuropeanCountry rec = new RandomEuropeanCountry();
    Country randomCountry = rec.getRandomCountry();

    System.out.println("Random European Country Information");
    System.out.println("===================================");
    System.out.println("Country: " + randomCountry.getName());
    System.out.println("Population: " + randomCountry.getPopulation());
    System.out.println("Area (sq km): " + randomCountry.getArea());
    System.out.println("Language: " + randomCountry.getLanguage());
  }
}