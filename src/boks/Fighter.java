package src.boks;


    public class Fighter{
        String name;
        int damage;
        int health;
        int weight;
        double dodge;
    
        public Fighter(String name, int damage, int health, int weight, double dodge) {
            this.name = name;
            this.damage = damage;
            this.health = health;
            this.weight = weight;
            this.dodge = dodge;
        }
    
        public int hit(Fighter foe) {
            System.out.println("------------");
            
            if (foe.dodge()) {
                System.out.println(foe.name + " gelen hasarı savurdu.");
                return foe.health;
            } else{
            System.out.println(this.name + " => " + foe.name + " " +  this.damage + " hasar vurdu.");

            }
            
            
            if (foe.health - this.damage < 0)
                return 0;
    
            return foe.health - this.damage;
        }
    
        public boolean dodge() {
            double randomValue = Math.random() * 10;  //0.0 to 99.9  
            System.out.print(randomValue);

            return randomValue >= this.dodge;
        }
    }

