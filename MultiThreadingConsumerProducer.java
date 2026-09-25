class PetrolStation
{
 int fuel = 0;
 synchronized void produce()
 {
 while(fuel!=0)
 {
 try
 {
 wait();
 }
 catch(InterruptedException e)
 {
 System.out.println("Producer Interrupted");
 }
 }
 for(int i=0;i<2;i++)
 {
 fuel++;
 System.out.println("Producer: Added 1 unit of fuel.");
 System.out.println("Fuel level: "+fuel);
 }
 notify();
 }
 synchronized void consume()
 {
 while(fuel==0)
 {
 try
 {
 wait();
 }
 catch(InterruptedException e)
 {
 System.out.println("Consumer Interrupted");
 }
 }
 fuel--;
 System.out.println("Consumer: Consumed 1 unit of fuel.");
 System.out.println("Fuel level: "+fuel);
 notify();
 }
}
class Producer implements Runnable
{
 PetrolStation p;
 Producer(PetrolStation p)
 {
 this.p = p;
 new Thread(this, "Producer").start();
 }
 public void run()
 {
 while(true)
 {
 p.produce();
 }
 }
}
class Consumer implements Runnable
{
 PetrolStation p;
 Consumer(PetrolStation p)
 {
 this.p = p;
 new Thread(this, "Consumer").start();
 }
 public void run()
 {
 while(true)
 {
 p.consume();
 }
 }
}
public class prog4_2025503525
{
 public static void main(String[] args)
 {
 PetrolStation p = new PetrolStation();
 new Producer(p);
 new Consumer(p);
 System.out.println("Press Control-C to stop");
 }
}