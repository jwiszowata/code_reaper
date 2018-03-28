public File getResponse() {
    File value = (File) getValue();
    return (value == cancelFile) ? null : value;
}