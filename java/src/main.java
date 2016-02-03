
public class main{
    static boolean verbose = false;
    public static void main(String [ ] args)
    {
        String alphabet = "";
        alphabet += "abcdefghijklmnopqrstuvwxyz\nABCDEFGHIJKLMNOPQRSTUVWXYZ\n1234567890\n!@#$%^&*()";
        main.test1("hi",alphabet);
        main.test1("frog duck horse potatoe","the quik brown fox jumps over the white fence.");
    }
    public static void test0(String key,String text){
        Cesar cesar = new Cesar();
        String e = cesar.encrypt(key,text);
        if(verbose)
            System.out.println(e);
        String d = cesar.decrypt(key,e);
        System.out.println((text.equals(d)?"PASS::"+d:"FAIL"+":SHOULD BE-"+text+":IS-"+d));
    }
    public static void test1(String key,String text){
        Cesar cesar = new Cesar();
        String cypher = Cypher.generate(text.length());
        String e = cesar.encrypt(cypher,text);
        if(verbose)
            System.out.println(e);
        String d = cesar.decrypt(cypher,e);
        System.out.println((text.equals(d)?"PASS::"+d:"FAIL"+":SHOULD BE-"+text+":IS-"+d));
    }
}
