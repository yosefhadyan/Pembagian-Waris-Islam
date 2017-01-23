package id.barkost.waris;

public class MateriAhliAdapter {
    private String name;
    
    public MateriAhliAdapter(){
        super();
    }
    
    public MateriAhliAdapter(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
