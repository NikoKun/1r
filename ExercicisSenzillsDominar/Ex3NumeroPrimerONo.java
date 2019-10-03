
class Ex3NumeroPrimerONo{
    public static void main(String[] args) {
    int num = 0;
    int con = 2;
    boolean primo = true;

    num = Integer.parseInt(System.console().readLine("Introdueix un número del 1 al 20: "));


    while (primo && con != num){
        if ((num % con) == 0)
            primo = false;
            con++;
    }
    
    if (primo==true){
    System.out.println("És un número primer");
    }
    else {
        System.out.println("No és un número primer");
    }
}
}