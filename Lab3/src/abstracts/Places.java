package abstracts;

public enum Places {
    HOME("обратно к дому"),
    PIPE("по водосточной трубе"),
    ROOF1("на крышу"),
    ROOF2("с крыши"),
    FENCE("до забора"),
    GROUND("о землю");
    private final String place;
    Places(String place) {
        this.place = place;
    }
    public String getPlace() {
        return place;
    }

}
