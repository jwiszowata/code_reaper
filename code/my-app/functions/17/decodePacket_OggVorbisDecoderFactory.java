private int decodePacket(int samples) {
    int range = (samples < convBuf.length) ? samples : convBuf.length;
    for (int i = 0; i < orbisInfo.channels; i++) {
        int sampleIndex = i * 2;
        for (int j = 0; j < range; j++) {
            int value = (int) (pcmData[0][i][pcmi[i] + j] * 32767.0f);
            if (value > 32767)
                value = 32767;
            else if (value < -32768)
                value = -32768;
            convBuf[sampleIndex] = (byte) (value);
            convBuf[sampleIndex + 1] = (byte) (value >>> 8);
            sampleIndex += 2 * (orbisInfo.channels);
        }
    }
    return range;
}