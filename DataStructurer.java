public class DataStructurer {
    private final String[] fileContentPerLine;
    private final int totalMitglieder;
    private int[][] wishList;
    private final Mitglied[] mitgliederRegister;

    public DataStructurer(String filePath){
        TxtFileReader fileReader = new TxtFileReader();
        String fileContent = fileReader.readFileContent(filePath);
        this.fileContentPerLine = fileContent.split("\\R");
        this.totalMitglieder = Integer.parseInt(fileContentPerLine[0]);
        this.mitgliederRegister = new Mitglied[totalMitglieder];
        this.wishList = createTotalWishList();
        setMitgliederRegister();
    }

    public Mitglied[] getMitgliederRegister() {
        return mitgliederRegister;
    }

    private int[][] createTotalWishList() {
        wishList =  new int[totalMitglieder][2];

        for (int i = 0; i < totalMitglieder; i++) {
            String[] minMaxValues = fileContentPerLine[i+1].split(" ");
            wishList[i][0] = Integer.parseInt(minMaxValues[0]);
            wishList[i][1] = Integer.parseInt(minMaxValues[1]);
        }

        return wishList;
    }

    private void setMitgliederRegister() {
        for (int i = 0; i < mitgliederRegister.length; i++){
            for (int j = 0; j < wishList[i].length; j++) {
                mitgliederRegister[i] = new Mitglied(wishList[i][0], wishList[i][1]);
            }
        }
    }
}
