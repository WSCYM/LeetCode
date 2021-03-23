public class Subject implements Cloneable{
    private int soc;

    public int getSoc() {
        return soc;
    }

    public void setSoc(int soc) {
        this.soc = soc;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return  super.clone();
    }
}
