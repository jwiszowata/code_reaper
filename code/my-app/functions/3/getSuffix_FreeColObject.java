public final String getSuffix(String prefix) {
    return (getId().startsWith(prefix)) ? getId().substring(prefix.length()) : getId();
}