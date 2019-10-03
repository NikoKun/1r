
class Ex4LletraDNI{
    public static void main(String[] args) {
    int num = 0;
    int lle;
    char lletr[] = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
    char loot = 'A';

    num = Integer.parseInt(System.console().readLine("Introdueix els numeros del teu DNI: "));
    
    lle = (num%23);
    loot = lletr[lle];

    System.out.println("El teu DNI és: "+num+loot);


    }
}