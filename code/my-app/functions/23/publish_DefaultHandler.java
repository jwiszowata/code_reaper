public void publish(LogRecord record) {
    if (record.getLevel().intValue() < getLevel().intValue() && record.getThrown() == null) {
        return;
    }
    String str = getFormatter().format(record);
    if (consoleLogging && record.getLevel().intValue() >= Level.WARNING.intValue()) {
        System.err.println(str);
    }
    synchronized (this.writerLock) {
        if (this.writer != null) {
            try {
                this.writer.write(str, 0, str.length());
                flush();
            } catch (IOException ioe) {
                System.err.println("Failed to write log record: " + str);
                ioe.printStackTrace(System.err);
            }
        }
    }
    if (record.getThrown() != null) {
        FreeColDebugger.handleCrash();
    }
}