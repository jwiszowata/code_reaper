public static void main(String[] args) {
    if (args.length >= 2 && args[0].endsWith("output:xml")) {
        File in = new File(args[1]);
        if (!in.exists()) {
            printUsage();
            System.exit(1);
        }
        File out;
        if (args.length >= 3) {
            out = new File(args[2]);
        } else {
            String filename = in.getName().replaceAll("." + FreeCol.FREECOL_SAVE_EXTENSION, ".xml");
            if (filename.equals(in.getName())) {
                filename += ".xml";
            }
            out = new File(filename);
        }
        try {
            FSGConverter fsgc = FSGConverter.getFSGConverter();
            fsgc.convertToXML(in, out);
        } catch (IOException e) {
            System.out.println("An error occured while converting the file.");
            e.printStackTrace();
            System.exit(1);
        }
    } else {
        printUsage();
        System.exit(1);
    }
}