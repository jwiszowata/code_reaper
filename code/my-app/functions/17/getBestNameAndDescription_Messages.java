public static String[] getBestNameAndDescription(String id) {
    if (id != null && id.endsWith(NAME_SUFFIX)) {
        id = id.substring(0, id.length() - NAME_SUFFIX.length());
    }
    String name = (containsKey(nameKey(id))) ? getName(id) : null;
    String desc = null;
    if (name == null) {
        name = (containsKey(id)) ? message(id) : null;
        if (name == null)
            name = id;
    } else {
        desc = getBestDescription(id);
        if (id.equals(desc))
            desc = null;
    }
    return new String[] { name, desc };
}