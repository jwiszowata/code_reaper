public File getResponse() {
    if (responded()) {
        File value = (File) getValue();
        return (value == cancelFile) ? null : value;
    }
    return null;
}