package org.CronHeater.Data;

/**
 * @author arno
 * @date 6-6-13
 * @time 20:55
 */
public enum OreData {
    BRONZE(0,new int[] {436,438},new int[] {14,14}, "Bronze"),
    IRON(1, new int[] {440}, new int[] {28}, "Iron"),
    STEEL(2,new int[] {440,453},new int[] {9,19}, "Steel"),
    GOLD(3,new int[] {444}, new int[] {28}, "Gold"),
    MITHRIL(4,new int[] {447,453}, new int[] {5,23}, "Mithril"),
    ADAMANT(5,new int[] {449,453}, new int[] {4,24}, "Adamantite"),
    RUNE(6, new int[] {451,453}, new int[] {3,24}, "Runite");

    private OreData(int id, int[] reqOre, int[] qOre, String name) {
        this.id = id;
        this.reqOre = reqOre;
        this.qOre = qOre;
        this.name = name;
    }

    private int id;
    private int[] reqOre, qOre;
    private String name;

    public int getId() {
        return id;
    }

    public int[] getRequiredOre() {
        return reqOre;
    }

    public int[] getAmount() {
        return qOre;
    }

    public String getName() {
        return name;
    }

    public OreData forId(int id) {
        for (OreData ore : OreData.values()) {
            if (ore.getId() == id) {
                return ore;
            }              // eeeehrm, :L.
        }
        return null;
    }
}
