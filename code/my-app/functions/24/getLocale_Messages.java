public static Locale getLocale(String languageID) {
    String language, country = "", variant = "";
    StringTokenizer st = new StringTokenizer(languageID, "_", true);
    language = st.nextToken();
    if (st.hasMoreTokens()) {
        st.nextToken();
    }
    if (st.hasMoreTokens()) {
        String token = st.nextToken();
        if (!"_".equals(token)) {
            country = token;
        }
        if (st.hasMoreTokens()) {
            token = st.nextToken();
            if ("_".equals(token) && st.hasMoreTokens()) {
                token = st.nextToken();
            }
            if (!"_".equals(token)) {
                variant = token;
            }
        }
    }
    return new Locale(language, country, variant);
}