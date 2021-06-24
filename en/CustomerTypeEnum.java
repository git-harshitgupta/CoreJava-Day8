package en;
public enum CustomerTypeEnum {
    SILVER,
    GOLD,
    PLATINUM;

    @Override
    public String toString() {
        return  name();
    }
}
