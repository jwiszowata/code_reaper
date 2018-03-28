public void shrink(String delim) {
    if (sb != null && delim != null) {
        sb.setLength(sb.length() - delim.length());
    }
}