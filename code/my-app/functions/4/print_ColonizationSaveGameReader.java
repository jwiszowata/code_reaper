public void print() {
    String tileString = (tile >= 0) ? " [tile " + TILES[tile] + "]" : "";
    System.out.println(OCCUPATION[speciality] + " working as " + OCCUPATION[occupation] + tileString);
}