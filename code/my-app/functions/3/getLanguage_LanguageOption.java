private Language getLanguage(String key) {
    return find(languages, l -> key.equals(l.getKey()));
}