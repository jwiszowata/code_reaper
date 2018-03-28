public ChangeSet clientError(String message) {
    logger.warning(message);
    if (FreeColDebugger.isInDebugMode(FreeColDebugger.DebugMode.COMMS)) {
        Thread.dumpStack();
    }
    return ChangeSet.clientError(See.only(this), message);
}