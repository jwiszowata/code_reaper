public FreeColXMLReader getSavedGameFreeColXMLReader() throws IOException {
    return new FreeColXMLReader(getInputStream(SAVEGAME_FILE));
}