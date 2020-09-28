package fr.dauphine.ja.levyjeancharles.td00;


import java.util.ArrayList;
import java.util.Random;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;

@SpringBootApplication
public class PrimeCollection {
	private int Toto;
	ArrayList<Integer> numbers = new ArrayList<Integer>();


	public PrimeCollection(ArrayList<Integer> num){
		numbers = num;
	}

	public void initRandom(int n, int m){
		int Min = 1;
		int Max = m;
		int cpt = n;
		if(cpt>0){
			while(cpt!=0){
				this.numbers.add(Min + (int)(Math.random() * ((Max - Min) + 1)));
				cpt=cpt-1;
			}
		}
		else{
			System.out.println("Probleme avec le nombre d'entiers a generer");
			return;
		}
	}

	public static boolean isPrime(int p){
		for(int i=2; i<=(int)(Math.sqrt(p)); i++){
			if(p%i==0){
				return false;
			}
		}
		return true;
	}

	public void printPrimes(){
		for(int i=0; i<numbers.size(); i++){
			if(isPrime(numbers.get(i))){
				System.out.println(numbers.get(i));
			}
		}
	}
	
    public static void main(String[] args) {
        SpringApplication.run(PrimeCollection.class, args);
        ArrayList<Integer> test = new ArrayList<Integer>();
		PrimeCollection data = new PrimeCollection(test);
		data.initRandom(100,2000);
		data.printPrimes();
    }

    @Bean
    public RouterFunction<?> routes(WelcomeHandler welcomeHandler, GreetingHandler greetingHandler) {
        return welcomeHandler.routes()
            .and(greetingHandler.routes());
    }
}

