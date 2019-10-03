
class Ex1NumeroParellOSenar{
    public static void main(String[] args) {
    int num;

    num = Integer.parseInt(System.console().readLine("Introdueix un número:"));

    if((num%2)==1){
        System.out.println("És sanar");
    }

    else{
        System.out.println("És parell");
    }

    }
}