public class Utilities {

    private Utilities() {
    }

    public static void printAllHouses(House[] houses) {
        for (House house : houses) {
            if (house != null) {
                String status = house.getIsHouseClosed() ? "Closed" : "Open";
                System.out.println("House(" + house.getHouseNumber() + ") [" + status + "], Score: " + house.getHouseScore() + ", Cards: " + house.getCardsInHouse());
            }
        }
    }

    public static void printHouse(House house) {
        if (house == null) {
            return;
        }

        String status = house.getIsHouseClosed() ? "Closed" : "Open";
        System.out.println("House(" + house.getHouseNumber() + ") [" + status + "], Score: " + house.getHouseScore() + ", Cards: " + house.getCardsInHouse());
    }
}