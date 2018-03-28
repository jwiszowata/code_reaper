public static String getIdType(String id) {
    if (id != null) {
        int col = id.lastIndexOf(':');
        return (col >= 0) ? id.substring(0, col) : id;
    }
    return null;
}