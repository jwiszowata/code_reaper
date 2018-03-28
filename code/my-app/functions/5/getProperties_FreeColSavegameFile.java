public Properties getProperties() throws IOException {
    Properties properties = new Properties();
    properties.load(getInputStream(SAVEGAME_PROPERTIES));
    return properties;
}