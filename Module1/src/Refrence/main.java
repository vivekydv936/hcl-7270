package Refrence;
class parent{
    public void common(){
        System.out.println("parent --> common()");
    }
    public void parent_fun(){
        System.out.println("parent-->fun");
    }

}
class child extends parent{
    @Override 
    public void common(){
        System.out.println("child --> common()");
    }

    public void child_fun(){
        System.out.println("child--->fun");
    }

    public void to_call_parent_common(){
        super.common();
    }
}

public class main{
    public static void main(String[] args) {
        
        // parent p = new parent();
        // p.common();
        // p.parent_fun();

        // parent pc = new child();
        // pc.common();
        // pc.parent_fun();

        // pc.child_fun();    // can acces clild fun

        child c= new child();
        // c.common();
        // c.child_fun();
        // c.parent_fun();
        c.to_call_parent_common();


    }
}
