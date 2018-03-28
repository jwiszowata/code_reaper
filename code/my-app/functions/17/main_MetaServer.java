public static void main(String[] args) {
    int port = -1;
    try {
        port = Integer.parseInt(args[0]);
    } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
        System.out.println("Usage: java net.sf.freecol.metaserver.MetaServer PORT_NUMBER");
        System.exit(-1);
    }
    MetaServer metaServer = null;
    try {
        metaServer = new MetaServer(port);
    } catch (IOException e) {
        logger.log(Level.WARNING, "Could not create MetaServer!", e);
        System.exit(-1);
    }
    metaServer.start();
}