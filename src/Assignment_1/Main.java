package Assignment_1;

import Assignment_1.models.Cart;
import Assignment_1.models.Product;
import Assignment_1.models.Variant;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Create Products
        Product papaya = new Product("Papaya","image",50,2.5f),
                orange = new Product("Orange", "image", 30, 5f);

        System.out.println("\t\t\t\t\tEcom\n");
        System.out.println("1.Enter \"show\" to See the Current Summary of the Cart");
        System.out.println("2.Enter \"add\" to Add the Products into the Cart");
        System.out.println("3.Enter \"edit\" to Edit the Products from the Cart");
        System.out.println("4.Enter \"remove\" to Remove the Products from the Cart");
        System.out.println("5.Enter \"terminate\" to Terminate this program");
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();

        cart.add(papaya,5f);
        cart.add(orange,2.5f);

        label : while (true) {
            System.out.print("\nEnter your Choice : ");
            String choice = scanner.next().toLowerCase();
            switch (choice) {
                case "show":
                    System.out.println(cart);
                    break;

                case "add":
                    System.out.println("\n\t1.Enter \"WBP\" to add Weight Based Product");
                    System.out.println("\t2.Enter \"VBP\" to add Variant Based Product");
                    System.out.println("\t3.Enter \"Main\" to go to Main Page : ");
                    System.out.println("\t4.Enter \"Terminate\" to Terminate this Program : ");
                    System.out.print("\nEnter any one from all of them : ");
                    String choiceToAdd = scanner.next().toUpperCase();

                    switch (choiceToAdd) {
                        case "WBP":
                            scanner.nextLine();
                            System.out.print("\n\tEnter the name of Product(string) : ");
                            String name = scanner.nextLine();
                            System.out.print("\tEnter the Image Url of Product(string) : ");
                            String imageUrl = scanner.nextLine();
                            System.out.print("\tEnter the Price Per Kg of Product(float value) : ");
                            float pricePerKg = scanner.nextFloat();
                            System.out.print("\tEnter the Minimum Quantity of Product(float value) : ");
                            float minimumQuantity = scanner.nextFloat();
                            System.out.print("\tEnter the Quantity of Product(float value) : ");
                            float quantity = scanner.nextFloat();
                            Product wbpProduct = new Product(name, imageUrl, pricePerKg, minimumQuantity);
                            cart.add(wbpProduct, quantity);
                            break;

                        case "VBP":
                            scanner.nextLine();
                            System.out.print("\n\tEnter the name of Product(string) : ");
                            String nameVBP = scanner.nextLine();
                            System.out.print("\tEnter the Image Url of Product(string) : ");
                            String imageUrlVBP = scanner.nextLine();
                            System.out.print("\tEnter the Price Per Kg of Product(float value) : ");
                            float pricePerKgVBP = scanner.nextFloat();
                            System.out.print("\tEnter the Minimum Quantity of Product(float value) : ");
                            float minimumQuantityVBP = scanner.nextFloat();
                            System.out.print("\tEnter the Variant of the Product(string like -> 5kg etc.) : ");
                            scanner.nextLine();
                            String nameOfVBP = scanner.nextLine();
                            System.out.print("\tEnter the Price of above Variant Product(float value) : ");
                            float priceOfVBP = scanner.nextFloat();
                            Variant variant = new Variant(nameOfVBP, priceOfVBP);
                            Product vbpProduct = new Product(nameVBP, imageUrlVBP, pricePerKgVBP, minimumQuantityVBP);
                            cart.add(vbpProduct, variant);
                            break;

                        case "MAIN":
                            break;

                        case "TERMINATE":
                            break label;

                        default:
                            System.out.println("You entered invalid Choice");
                    }
                    break;

                case "edit":
                    System.out.println("\n\t1.Enter \"WBP\" to add Weight Based Product");
                    System.out.println("\t2.Enter \"VBP\" to add Variant Based Product");
                    System.out.println("\t3.Enter \"Main\" to go to Main Page : ");
                    System.out.println("\t4.Enter \"Terminate\" to Terminate this Program : ");
                    System.out.print("\nEnter any one from all of them : ");
                    String choiceToEdit = scanner.next().toUpperCase();

                    switch (choiceToEdit) {
                        case "WBP":
                            scanner.nextLine();
                            System.out.print("\n\tWrite the name of the Product you want to edit : ");
                            String productName = scanner.nextLine();
                            System.out.print("\tEnter the New Price of Product(float value) : ");
                            float pricePerKg = scanner.nextFloat();
                            System.out.print("\tEnter the New Quantity of Product(float value) : ");
                            float quantity = scanner.nextFloat();
                            cart.edit(productName, pricePerKg, quantity);
                            break;

                        case "VBP":
                            System.out.println("\n\t1.Enter \"increment\" to increase the Quantity of Product");
                            System.out.println("\t2.Enter \"decrement\" to reduce the Quantity of Product");
                            System.out.println("\t3.Enter \"Main\" to go to Main Page : ");
                            System.out.println("\t4.Enter \"Terminate\" to Terminate this Program : ");
                            System.out.print("\nEnter any one from all of them : ");
                            String choiceToEditVBP = scanner.next().toUpperCase();

                            switch (choiceToEditVBP) {
                                case "INCREMENT":
                                    scanner.nextLine();
                                    System.out.print("\n\tEnter the Name of the Product with it's Variant Name and Variant Name should be separated by Space : ");
                                    String nameVBP = scanner.nextLine();
                                    cart.edit(nameVBP);
                                    break;

                                case "DECREMENT":
                                    scanner.nextLine();
                                    System.out.print("\n\tEnter the Name of the Product with it's Variant Name and Variant Name should be separated by Space : ");
                                    String name = scanner.nextLine();
                                    cart.decrement(name);
                                    break;

                                case "MAIN":
                                    break;

                                case "TERMINATE":
                                    break label;

                                default:
                                    System.out.println("You entered invalid Choice");
                            }
                            break;

                        case "MAIN":
                            break;

                        case "TERMINATE":
                            break label;

                        default:
                            System.out.println("You entered invalid Choice");
                    }
                    break;

                case "remove":
                    System.out.println("\n\t1.Enter \"WBP\" to remove Weight Based Products");
                    System.out.println("\t2.Enter \"VBP\" to remove all Variant Based Products of a Particular Variant");
                    System.out.println("\t3.Enter \"Main\" to go to Main Page : ");
                    System.out.println("\t4.Enter \"Terminate\" to Terminate this Program : ");
                    System.out.print("\nEnter any one from all of them : ");
                    String choiceToRemove = scanner.next().toUpperCase();

                    switch (choiceToRemove) {
                        case "WBP":
                            scanner.nextLine();
                            System.out.print("\n\tEnter the name of Product(string) : ");
                            String name = scanner.nextLine();
                            cart.removeWBP(name);
                            break;

                        case "VBP":
                            scanner.nextLine();
                            System.out.print("\n\tEnter the Name of the Product with it's Variant Name and Variant Name should be separated by Space : ");
                            String productNameToVBP = scanner.nextLine();
                            cart.removeVBP(productNameToVBP);
                            break;

                        case "MAIN":
                            break;

                        case "TERMINATE":
                            break label;

                    }
                    break;

                case "terminate":
                    System.out.print("\n");
                    break label;

                default:
                    System.out.println("You entered invalid Choice");

            }
        }

        System.out.println("\t\t\t\t\tUpdated Cart Summary\n" + cart);

    }
}

