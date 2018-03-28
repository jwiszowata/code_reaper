public static synchronized Random restoreRandomState(String state) {
    if (state == null || state.isEmpty())
        return null;
    byte[] bytes = new byte[state.length() / 2];
    int pos = 0;
    for (int i = 0; i < bytes.length; i++) {
        bytes[i] = (byte) HEX_DIGITS.indexOf(state.charAt(pos++));
        bytes[i] <<= 4;
        bytes[i] |= (byte) HEX_DIGITS.indexOf(state.charAt(pos++));
    }
    ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
    try {
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Random) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
        logger.log(Level.WARNING, "Unable to restore random state.", e);
    }
    return null;
}