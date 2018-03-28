public static File getClientOptionsFile() {
    return (clientOptionsFile != null) ? clientOptionsFile : getOptionsFile(CLIENT_OPTIONS_FILE_NAME);
}