package visitor.decorator;

interface Modem {
    void dial(String pno);
    void setSpeakerVolume(int volume);
    String getPhoneNumber();
    int getSpeakerVolume();
}
class HayesModem implements Modem{

    private String pno;
    private int volume;
    @Override
    public void dial(String pno) {
        this.pno = pno;
    }

    @Override
    public void setSpeakerVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String getPhoneNumber() {
        return pno;
    }

    @Override
    public int getSpeakerVolume() {
        return volume;
    }
}
class LoudDialModem implements Modem{

    private Modem itsModem;

    public LoudDialModem(Modem itsModem) {
        this.itsModem = itsModem;
    }

    @Override
    public void dial(String pno) {
        itsModem.setSpeakerVolume(10);
        itsModem.dial(pno);
    }

    @Override
    public void setSpeakerVolume(int volume) {
        itsModem.setSpeakerVolume(volume);
    }

    @Override
    public String getPhoneNumber() {
        return itsModem.getPhoneNumber();
    }

    @Override
    public int getSpeakerVolume() {
        return itsModem.getSpeakerVolume();
    }
}