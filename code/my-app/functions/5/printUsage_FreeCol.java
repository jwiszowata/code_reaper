private static void printUsage(Options options, int status) {
    HelpFormatter formatter = new HelpFormatter();
    formatter.printHelp("java -Xmx 256M -jar freecol.jar [OPTIONS]", options);
    System.exit(status);
}