private FreeColServer failToMain(Exception ex, String key) {
    return failToMain(ex, StringTemplate.template(key));
}