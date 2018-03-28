public static synchronized String getRandomState(Random random) {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    try {
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(random);
        oos.flush();
    } catch (IOException e) {
        throw new IllegalStateException("IO exception in memory!?", e);
    }
    byte[] bytes = bos.toByteArray();
    StringBuilder sb = new StringBuilder(bytes.length * 2);
    for (byte b : bytes) {
        sb.append(HEX_DIGITS.charAt((b >> 4) & 0x0F));
        sb.append(HEX_DIGITS.charAt(b & 0x0F));
    }
    return sb.toString();
}