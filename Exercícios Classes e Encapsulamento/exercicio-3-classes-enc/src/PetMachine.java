public class PetMachine {

    private boolean clean = true;

    private int water = 30;

    private int shampoo = 10;

    private Pet pet;

    public int getWater() {
        return water;
    }

    public int getShampoo() {
        return shampoo;
    }

    public void takeAShower() {
        if (this.pet == null) {
            System.out.println("Coloque o pet na máquina para iniciar o processo de banho");
            return;
        } else {
            System.out.println("O pet " + pet.getName() + " dentro da máquina");
        }
        if (this.water < 10){
            System.out.println("Não há água suficiente. Adicione mais e tente novamente");
            return;
        }
        if (this.shampoo < 2){
            System.out.println("Não há shampoo suficiente. Adicione mais e tente novamente");
            return;
        }

        this.water -= 10;
        this.shampoo -= 2;
        pet.setClean(true);
        System.out.println("O pet " + pet.getName() + " está tomando banho");
        System.out.println("Banho concluído");
        if (this.water < 0) this.water = 0;
        if (this.shampoo < 0) this.shampoo = 0;
    }


    public void addShampoo(){
        if (shampoo == 10){
            System.out.println("A capacidade de shampoo na máquina está no máximo");
            return;
        }
        shampoo = 10;
    }
    public void addWater(){
        if (water == 30){
            System.out.println("A capacidade de água na máquina esta no máximo");
            return;
        }
        water = 30;
    }

    public boolean hasPet(){
        return pet != null;
    }

    public void setPet(Pet pet) {
        if (!this.clean){
            System.out.println("A máquina está suja, para colocar o pet é preciso limpá-la");
            return;
        }
        if (hasPet()){
            System.out.println("Aguarde o pet " + this.pet.getName() + " ser retirado");
            return;
        }
        this.pet = pet;
        System.out.println("O pet " + pet.getName() + " foi colocado na máquina");
    }
    public void removePet(){
        if (this.pet != null) {
            this.clean = this.pet.isClean();
            System.out.println("O pet " + this.pet.getName() + " foi tirado da máquina");
            this.pet = null;
        }else{
            System.out.println("A máquina está vazia! Não existe pet para retirar");
        }
    }

    public void washMachine() {
        if (this.pet != null) {

            System.out.println("Não é possível limpar a máquina com um pet dentro dela. Retire o pet e tente novamente");

        }else if (this.water < 10 || this.shampoo < 2) {
            System.out.println("Insumos insuficientes para lavar a máquina! Adicione mais e tente novamente");
            this.water -= 10;
            this.shampoo -= 2;
            this.clean = true;
            System.out.println("A máquina está limpa agora");
        }
    }
}