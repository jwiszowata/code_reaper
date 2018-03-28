public void initialize(String name) {
    name = getAbbreviatedName(name);
    points = faFile.getPoints(name);
    counter = 0;
    setSize(faFile.getDimension(name));
}