public static Document readDocument(InputSource inputSource) throws SAXException, IOException {
    Document tempDocument = null;
    boolean dumpMsgOnError = true;
    if (dumpMsgOnError) {
        inputSource.setByteStream(new BufferedInputStream(inputSource.getByteStream()));
        inputSource.getByteStream().mark(1000000);
    }
    try {
        synchronized (parser) {
            tempDocument = parser.parse(inputSource);
        }
    } catch (IOException ex) {
        throw ex;
    } catch (Exception ex) {
        if (dumpMsgOnError) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            inputSource.getByteStream().reset();
            while (true) {
                int i = inputSource.getByteStream().read();
                if (-1 == i) {
                    break;
                }
                baos.write(i);
            }
            logger.log(Level.SEVERE, baos.toString("UTF-8"), ex);
        } else {
            logger.log(Level.WARNING, "Parse error", ex);
        }
        throw ex;
    }
    return tempDocument;
}