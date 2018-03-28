public static void main(String[] args) throws Exception {
    byte[] data;
    try (RandomAccessFile reader = new RandomAccessFile(args[0], "r")) {
        data = new byte[(int) reader.length()];
        reader.read(data);
    }
    new ColonizationSaveGameReader(data).run();
}