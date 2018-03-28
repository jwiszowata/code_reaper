private static boolean isHexString(String str) {
    if (str == null || !(str.startsWith("0x") || str.startsWith("0X")) || str.length() <= 2)
        return false;
    for (int i = 2; i < str.length(); i++) {
        if (!"0123456789ABCDEFabcdef".contains(str.substring(i, i + 1))) {
            return false;
        }
    }
    return true;
}