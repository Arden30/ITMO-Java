package abstracts;

public enum Places {
    WORKSHOP("мастерской"),
    GAZEBO("беседки"),
    BACKHOME("обратно к дому"),
    NEARHOME("неподалеку от дома"),
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
