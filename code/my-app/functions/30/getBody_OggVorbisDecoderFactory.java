public int getBody(InputStream is) {
    String err;
    int packet = 3;
    pcmi = new int[orbisInfo.channels];
    pcmData = new float[1][][];
    for (; ; ) {
        switch(oggStreamState.packetout(oggPacket)) {
            case 1:
                if (orbisBlock.synthesis(oggPacket) == 0) {
                    orbisDspState.synthesis_blockin(orbisBlock);
                }
                for (; ; ) {
                    int n = orbisDspState.synthesis_pcmout(pcmData, pcmi);
                    if (n <= 0)
                        break;
                    orbisDspState.synthesis_read(n);
                    return 2 * orbisInfo.channels * decodePacket(n);
                }
                packet++;
                break;
            case 0:
                if ((err = getPage()) != null) {
                    return (EOS.equals(err)) ? 0 : -1;
                }
                break;
            default:
                return -1;
        }
    }
}