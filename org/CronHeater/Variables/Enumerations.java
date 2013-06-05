package org.CronHeater.Variables;

/**
 * Created with IntelliJ IDEA.
 * User: arno
 * Date: 5-6-13
 * Time: 15:44
 * To change this template use File | Settings | File Templates.
 */
public enum Enumerations {
    BRONZE(1,new int[] {436,438}),
    IRON(2,new int[] {440}),
    STEEL(3,new int[] {440,453}),
    GOLD(4,new int[] {444}),
    MITHRIL(5,new int[] {447,453}),
    ADAMANT(6,new int[] {449,453}),
    RUNE(7,new int[] {451,453});

    private Enumerations(int id, int[] oreIds) {
       this.id = id;
       this.oreIds = oreIds;
    }

    private int[] oreIds;
    private int id;

    public int[] getOre() {
        return oreIds;
    }

    public int getId() {
        return id;
    }

    public Enumerations forOre(int ore) {
        for (Enumerations bars: Enumerations.values()) {
            if (bars.getId() == ore) {
                return bars;
            }
        }
        return null;
    }

}
