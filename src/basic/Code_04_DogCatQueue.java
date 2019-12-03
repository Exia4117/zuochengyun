package basic;

import java.util.LinkedList;
import java.util.Queue;

public class Code_04_DogCatQueue {
    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    public static class PetEnterQueue {
        private Pet pet;
        private long count;

        public PetEnterQueue(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public long getCount() {
            return count;
        }

        public String getEnterPetType() {
            return pet.getPetType();
        }
    }

    public static class DogCatQueue {
        private Queue<PetEnterQueue> dogQ;
        private Queue<PetEnterQueue> catQ;
        private long count;

        public DogCatQueue() {
            dogQ = new LinkedList<>();
            catQ = new LinkedList<>();
            count = 0;
        }

        public void add(Pet pet) {
            if (pet.getPetType().equals("dog")) {
                dogQ.add(new PetEnterQueue(pet, this.count++));
            } else if (pet.getPetType().equals("cat")) {
                catQ.add(new PetEnterQueue(pet, this.count++));
            } else {
                throw new RuntimeException("error,not cat or dog");
            }
        }

        public Dog pollDog() {
            if (!isDogQueueEmpty()) {
                return (Dog) dogQ.poll().getPet();
            } else {
                throw new RuntimeException("catqueue is empty");
            }
        }

        public Cat pollCat() {
            if (!isCatQueueEmpty()) {
                return (Cat) catQ.poll().getPet();
            } else {
                throw new RuntimeException("catqueue is empty");
            }
        }

        public Pet pollAll() {
            if (!isDogQueueEmpty() && !isCatQueueEmpty()){
                if(dogQ.peek().getCount() < catQ.peek().getCount()){
                    return dogQ.poll().getPet();
                }else {
                    return catQ.poll().getPet();
                }
            }else if(isDogQueueEmpty()){
                return catQ.poll().getPet();
            }else if(isCatQueueEmpty()){
                return dogQ.poll().getPet();
            }else {
                throw new RuntimeException("error, queue is empty");
            }
        }

        public boolean isEmpty() {
            return dogQ.isEmpty() && catQ.isEmpty();
        }

        public boolean isDogQueueEmpty() {
            return dogQ.isEmpty();
        }

        public boolean isCatQueueEmpty() {
            return catQ.isEmpty();
        }

        public static void main(String[] args) {
            DogCatQueue test = new DogCatQueue();

            Pet dog1 = new Dog();
            Pet cat1 = new Cat();
            Pet dog2 = new Dog();
            Pet cat2 = new Cat();
            Pet dog3 = new Dog();
            Pet cat3 = new Cat();

            test.add(dog1);
            test.add(cat1);
            test.add(dog2);
            test.add(cat2);
            test.add(dog3);
            test.add(cat3);

            test.add(dog1);
            test.add(cat1);
            test.add(dog2);
            test.add(cat2);
            test.add(dog3);
            test.add(cat3);

            while (!test.isDogQueueEmpty()) {
                System.out.println(test.pollDog().getPetType());
            }
            test.add(dog1);
            test.add(cat1);
            test.add(dog2);
            test.add(cat2);
            test.add(dog3);
            test.add(cat3);
            while (!test.isEmpty()) {
                System.out.println(test.pollAll().getPetType());
            }
        }

    }
}
