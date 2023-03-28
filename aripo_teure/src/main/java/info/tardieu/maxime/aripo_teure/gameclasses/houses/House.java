package info.tardieu.maxime.aripo_teure.gameclasses.houses;

import info.tardieu.maxime.aripo_teure.gameclasses.abstracts.enums.HouseList;

public class House {
    private HouseList houseIn;


    public HouseList getHouseIn() {
        return houseIn;
    }

    public void setHouseIn(HouseList houseIn) {
        this.houseIn = houseIn;
    }

    public House() {
        this.houseIn = HouseList.randomHouse();
    }
}
