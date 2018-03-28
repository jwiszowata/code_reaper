public static void main(String[] args) throws Exception {
    System.setProperty("jaxp.debug", "1");
    if (args.length > 0) {
        Arrays.sort(args);
    }
    readResources();
    generateDocumentation(args);
}