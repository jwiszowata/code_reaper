private static StringBuilder shortenName(String localFile) {
    StringBuilder out = new StringBuilder(5);
    String temp = localFile.substring(16, localFile.indexOf('.'));
    if (temp.length() < 5)
        out.append("   ");
    out.append(temp);
    return out;
}