public class sim_object {

    private String id;
    private String name;
    private int address;
    private String type;
    private String kind;
    private boolean value;

    private boolean openCircuit;
    private boolean shortCircuit;
    private boolean isForced;
    private boolean forcedValue;

    public sim_object(String id, String name, int address, String type, String kind, boolean value, boolean openCircuit, boolean shortCircuit, boolean isForced, boolean forcedValue) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.type = type;
        this.kind = kind;
        this.value = value;
        this.openCircuit = openCircuit;
        this.shortCircuit = shortCircuit;
        this.isForced = isForced;
        this.forcedValue = forcedValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public boolean isOpenCircuit() {
        return openCircuit;
    }

    public void setOpenCircuit(boolean openCircuit) {
        this.openCircuit = openCircuit;
    }

    public boolean isShortCircuit() {
        return shortCircuit;
    }

    public void setShortCircuit(boolean shortCircuit) {
        this.shortCircuit = shortCircuit;
    }

    public boolean isForced() {
        return isForced;
    }

    public void setForced(boolean forced) {
        isForced = forced;
    }

    public boolean isForcedValue() {
        return forcedValue;
    }

    public void setForcedValue(boolean forcedValue) {
        this.forcedValue = forcedValue;
    }

    @Override
    public String toString() {

        return ("Name: " + getName() +
                " Type: " + getType() +
                " Value: " + isValue() +
                " isForced: " + isForced() +
                " isForcedValue: " + isForcedValue());
    }

}
