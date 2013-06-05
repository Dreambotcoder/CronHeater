/**
 * Created with IntelliJ IDEA.
 * User: arno
 * Date: 5-6-13
 * Time: 20:05
 * To change this template use File | Settings | File Templates.
 */
public enum Configs {
    BRONZE(0, new int[] {436,438}, new int[] {14,14},"Bronze"),
    IRON(1, new int[] {440}, new int[] {28},"Iron"),
    STEEL(2, new int[] {440,453}, new int[] {9,19},"Steel"),
    GOLD(3, new int[] {444}, new int[] {28},"Gold"),
    MITHRIL(4, new int[] {447,453}, new int[] {5,23},"Mithril"),
    ADAMANT(5, new int[] {449,453}, new int[] {4,24},"Adamantite"),
    RUNE(6,new int[] {451,453}, new int[] {3,24},"Runite");

    private Configs(int id, int[] reqOres, int[] oreQ, String name) {
        this.id = id;
        this.reqOres = reqOres;
        this.oreQ = oreQ;
        this.name = name;
    }

    private int id;
    private int[] reqOres;
    private int[] oreQ;
    private String name;

    public String getName() {
        return name;
    }

    public int[] getAmount() {
        return oreQ;
    }

    public int getId() {
       return id;
    }

    public int[] getOre() {
        return reqOres;
    }

    public static Configs forId(int id) {
        for (Configs bar: Configs.values()) {
            if (bar.getId() == id) {
                return bar;
            }
        }
        return null;
    }
}
