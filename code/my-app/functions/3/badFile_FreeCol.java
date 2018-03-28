public static StringTemplate badFile(String messageId, File file) {
    return StringTemplate.template(messageId).addName("%name%", (file == null) ? "-" : file.getPath());
}