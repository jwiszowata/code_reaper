public static String getLogFileContents() {
    return Utils.getUTF8Contents(new File(getLogFilePath()));
}