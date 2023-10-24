public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        Food[] breakfast = new Food[20];
        int itemsSoFar = 0;
        for (String arg : args) {
            String[] parts = arg.split("/");
            if (parts[0].equals("Cheese")) {
                breakfast[itemsSoFar] = new Cheese();
            } else if (parts[0].equals("Apple")) {
                breakfast[itemsSoFar] = new Apple(parts[1]);
            } else if (parts[0].equals("Pie")) {
                breakfast[itemsSoFar] = new Pie(parts[1]);
            }
            itemsSoFar++;
        }
        countFood(breakfast, breakfast[1]);
        for (Food item : breakfast) {
            if (item != null) {
                item.consume();
            } else {
                break;
            }
        }
        System.out.println("Всего хорошего!");
    }

    public static void countFood(Food[] foods, Food food) {
        int count = 0;
        for (Food f : foods) {
            if (f != null && f.equals(food)) {
                count++;
            }
        }
        System.out.println("There are " + count + " products of type " + food.getClass().getSimpleName() + " in the breakfast");
    }
}