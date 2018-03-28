private static String getName(int[] branches) {
    String name = "";
    for (int branche : branches) {
        name += Integer.toString(branche);
    }
    return name;
}