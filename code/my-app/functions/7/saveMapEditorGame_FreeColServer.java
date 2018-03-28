public void saveMapEditorGame(File file, BufferedImage image) throws IOException {
    this.setAIMain(null);
    Specification spec = getSpecification();
    getGame().setSpecification(null);
    saveGame(file, MAP_EDITOR_NAME, null, null, image);
    getGame().setSpecification(spec);
}