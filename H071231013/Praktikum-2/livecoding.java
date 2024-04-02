public class livecoding {
    String name;
    int age;
    boolean ismale;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String isIsmale() {
        return this.ismale ? "male": "female";
    }
    public void setIsmale(boolean ismale) {
        this.ismale = ismale;
    }
public static void main(String[] args) {
    livecoding livecoding = new livecoding();
    livecoding.setName("Farhan");
    livecoding.setAge(23);
    livecoding.setIsmale(true);
System.out.println("name : "+ livecoding.getName());
System.out.println("age :" + livecoding.getAge());
System.out.println("Gender :" + livecoding.isIsmale());
}
    

}
