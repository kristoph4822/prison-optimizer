package input;
//pakiet do zmiany

//klasa przechowuje to co istotne z ustawień, jest atrybutem w Prison
public class Configurations {

    private static final int BED_HEIGHT = 20;
    private static final int BED_WIDTH = 10;
    private static int bedQuality;
    private static int bedPrice = 2;

    private static final int WINDOW_HEIGHT = 2;
    private static final int WINDOW_WIDTH = 8;
    private static int windowQuality;
    private static int windowPrice = 2;

    private static final int DOOR_HEIGHT = 2;
    private static int DOOR_WIDTH = 4;
    private static int doorQuality;
    private static int doorPrice = 2;

    private static final int CAMERA_SIZE = 2;
    private static int cameraRange = 15;
    private static int cameraQuality;
    private static int cameraPrice = 2;

    private static final int LAMP_SIZE = 2;
    private static int lampRange = 15;
    private static int lampQuality;
    private static int lampPrice = 2;

    private static final int SANITY_HEIGHT = 4;
    private static int SANITY_WIDTH = 4;
    private static int sanityQuality;
    private static int sanityPrice = 2;

    private static int numberOfInmates = 10;
    private static int inmatesPerCell = 2;
    private static int numberOfCells = numberOfInmates % inmatesPerCell == 0 ? numberOfInmates / inmatesPerCell : numberOfInmates / inmatesPerCell + 1;

    private static int GUARDS_ROOM_SIZE = 10;
    private static int inmatesPerGuardsRoom = 2;
    private static int guardsRoomQuality;
    private static int guardsRoomPrice = 2;

    private static int cellWidth;

    public int getBedQuality() {
        return bedQuality;
    }

    public static int getBedPrice() {
        return bedPrice;
    }

    public int getWindowQuality() {
        return windowQuality;
    }

    public static int getWindowPrice() {
        return windowPrice;
    }

    public int getDoorQuality() {
        return doorQuality;
    }

    public static int getDoorPrice() {
        return doorPrice;
    }

    public static int getCameraRange() {
        return cameraRange;
    }

    public int getCameraQuality() {
        return cameraQuality;
    }

    public static int getCameraPrice() {
        return cameraPrice;
    }

    public static int getLampRange() {
        return lampRange;
    }

    public int getLampQuality() {
        return lampQuality;
    }

    public static int getLampPrice() {
        return lampPrice;
    }

    public int getSanityQuality() {
        return sanityQuality;
    }

    public static int getSanityPrice() {
        return sanityPrice;
    }

    public static int getNumberOfInmates() {
        return numberOfInmates;
    }

    public static int getInmatesPerCell() {
        return inmatesPerCell;
    }

    public void setBedQuality(int bedQuality) {
        this.bedQuality = bedQuality;
    }

    public void setBedPrice(int bedPrice) {
        this.bedPrice = bedPrice;
    }

    public void setWindowQuality(int windowQuality) {
        this.windowQuality = windowQuality;
    }

    public void setWindowPrice(int windowPrice) {
        this.windowPrice = windowPrice;
    }

    public void setDoorQuality(int doorQuality) {
        this.doorQuality = doorQuality;
    }

    public void setDoorPrice(int doorPrice) {
        this.doorPrice = doorPrice;
    }

    public void setCameraRange(int cameraRange) {
        this.cameraRange = cameraRange;
    }

    public void setCameraQuality(int cameraQuality) {
        this.cameraQuality = cameraQuality;
    }

    public void setCameraPrice(int cameraPrice) {
        this.cameraPrice = cameraPrice;
    }

    public void setLampRange(int lampRange) {
        this.lampRange = lampRange;
    }

    public void setLampQuality(int lampQuality) {
        this.lampQuality = lampQuality;
    }

    public void setLampPrice(int lampPrice) {
        this.lampPrice = lampPrice;
    }

    public void setSanityQuality(int sanityQuality) {
        this.sanityQuality = sanityQuality;
    }

    public void setSanityPrice(int sanityPrice) {
        this.sanityPrice = sanityPrice;
    }

    public void setNumberOfInmates(int numberOfInmates) {
        this.numberOfInmates = numberOfInmates;
    }

    public void setInmatesPerCell(int inmatesPerCell) {
        this.inmatesPerCell = inmatesPerCell;
    }

    public static int getInmatesPerGuardsRoom() {
        return inmatesPerGuardsRoom;
    }

    public static void setInmatesPerGuardsRoom(int inmatesPerGuardsRoom) {
        Configurations.inmatesPerGuardsRoom = inmatesPerGuardsRoom;
    }

    public static int getGuardsRoomQuality() {
        return guardsRoomQuality;
    }

    public static void setGuardsRoomQuality(int guardsRoomQuality) {
        Configurations.guardsRoomQuality = guardsRoomQuality;
    }

    public static int getGuardsRoomPrice() {
        return guardsRoomPrice;
    }

    public static void setGuardsRoomPrice(int guardsRoomPrice) {
        Configurations.guardsRoomPrice = guardsRoomPrice;
    }

    public static int getBedHeight() {
        return BED_HEIGHT;
    }

    public static int getBedWidth() {
        return BED_WIDTH;
    }

    public static int getWindowHeight() {
        return WINDOW_HEIGHT;
    }

    public static int getWindowWidth() {
        return WINDOW_WIDTH;
    }

    public static int getDoorHeight() {
        return DOOR_HEIGHT;
    }

    public static int getDoorWidth() {
        return DOOR_WIDTH;
    }

    public static int getCameraSize() {
        return CAMERA_SIZE;
    }

    public static int getLampSize() {
        return LAMP_SIZE;
    }

    public static int getSanityHeight() {
        return SANITY_HEIGHT;
    }

    public static int getSanityWidth() {
        return SANITY_WIDTH;
    }

    public static int getGuardsRoomSize() {
        return GUARDS_ROOM_SIZE;
    }

    public static int getNumberOfCells() {
        return numberOfCells;
    }

    public static int getCellWidth() {
        return cellWidth;
    }

    public static void setCellWidth(int cellWidth) {
        Configurations.cellWidth = cellWidth;
    }

}
