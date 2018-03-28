public Object getTransferData(DataFlavor flavor) {
    return (flavor == STOP_FLAVOR) ? stops : null;
}