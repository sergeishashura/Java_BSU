public class Pie extends Food{
    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    private String filling;
    public Pie(String filling) {
        super("Пирог");
        this.filling = filling;
    }
    @Override
    public boolean equals(Object arg0) {
        if (super.equals(arg0)) { // Шаг 1
            if (!(arg0 instanceof Pie)) return false; // Шаг 2
            return filling.equals(((Pie)arg0).filling); // Шаг 3
        } else
            return false;
    }

    @Override
    public void consume() {
        System.out.println(  this.toString()+  " съеден");
    }
    @Override
    public String toString(){
        return "пирог с начинкой " + filling;
    }
}

