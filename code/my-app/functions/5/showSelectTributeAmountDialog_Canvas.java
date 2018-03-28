public int showSelectTributeAmountDialog(StringTemplate question, int maximum) {
    FreeColDialog<Integer> fcd = new SelectTributeAmountDialog(freeColClient, frame, question, maximum);
    Integer result = showFreeColDialog(fcd, null);
    return (result == null) ? -1 : result;
}