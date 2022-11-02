public class BaekJoon2920 {

    public String getPlayStyle(String pitchNameArr) {
        if (pitchNameArr.equals("12345678")) {
            return "ascending";
        }

        if (pitchNameArr.equals("87654321")) {
            return "descending";
        }

        return "mixed";
    }
}
