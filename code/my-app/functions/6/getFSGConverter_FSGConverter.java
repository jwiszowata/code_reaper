public static FSGConverter getFSGConverter() {
    if (singleton == null) {
        singleton = new FSGConverter();
    }
    return singleton;
}