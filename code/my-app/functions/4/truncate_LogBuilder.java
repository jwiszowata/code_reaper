public void truncate(int size) {
    if (sb != null && sb.length() > size)
        sb.setLength(size);
}