import java.util.*;

class Customer
{
    String name, mobile, dob, memberId = "";
    boolean isMember = false;
    Scanner sc = new Scanner(System.in);

    Customer()
    {
        System.out.print("Enter your full name as per ID: ");
        this.name = sc.nextLine();

        System.out.print("Enter your country code: ");
        String countryCode = sc.next();

        System.out.print("Enter your mobile number (10 digits): ");
        this.mobile = sc.next();
        validateMobileNumber();

        System.out.print("Enter your Date of Birth:\nDay: ");
        int day = sc.nextInt();
        System.out.print("Month: ");
        int month = sc.nextInt();
        System.out.print("Year: ");
        int year = sc.nextInt();
        validateDOB(day, month, year);

        System.out.println("Do you want to become a member? (Yes/No)");
        System.out.println("Benefits: ");
        System.out.println("1. 15% discount on all bookings ");
        System.out.println("2. No tax additions on bookings ");
        System.out.println("3. 15000 miles welcome bonus");

        String choice = sc.next().toLowerCase();
        if (choice.equals("yes"))
        {
            assignMembership();
        }
    }

    void validateMobileNumber()
    {
        while (mobile.length() != 10)
        {
            System.out.print("Invalid number. Enter a valid 10-digit mobile number: ");
            this.mobile = sc.next();
        }
    }

    void validateDOB(int day, int month, int year)
    {
        while (!isValidDate(day, month, year))
        {
            System.out.println("Invalid date of birth. Please enter a correct date.");
            System.out.print("Enter Day: ");
            day = sc.nextInt();
            System.out.print("Enter Month: ");
            month = sc.nextInt();
            System.out.print("Enter Year: ");
            year = sc.nextInt();
        }
        this.dob = day + "/" + month + "/" + year;
    }

    boolean isValidDate(int day, int month, int year)
    {
        if (month < 1 || month > 12)
        {
            return false;
        }

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month == 2 && year % 4 == 0)
        {
            daysInMonth[1] = 29; // Leap year check
        }
        return day > 0 && day <= daysInMonth[month - 1];
    }

    void assignMembership()
    {
        isMember = true;
        System.out.print("Enter ID Number: ");
        memberId = sc.next();
        System.out.println("Membership Successful! Your ID: " + memberId + ", 15000 miles credited.");
    }
}

class FlightBooking
{
    String from, to, travelClass, departureTime;
    int passengers;
    double totalPrice;
    Scanner sc = new Scanner(System.in);

    void bookFlight(Customer customer)
    {
        System.out.println("Press 1 for New York");
        System.out.println("Press 2 for London");
        System.out.println("Press 3 for Italy");
        System.out.println("Press 4 for Dubai");
        System.out.println("Press 5 for Mumbai");
        System.out.println("Press 6 for Singapore");
        System.out.println("Press 7 for Tokyo");
        System.out.println("Press 8 for Beijing");
        System.out.println("Press 9 for Sydney");
        System.out.println("Press 10 for Auckland");
        System.out.println("Select Departure Airport:");
        int fromChoice = sc.nextInt();

        switch (fromChoice)
        {
            case 1:
                from = "New York";
                break;
            case 2:
                from = "London";
                break;
            case 3:
                from = "Italy";
                break;
            case 4:
                from = "Dubai";
                break;
            case 5:
                from = "Mumbai";
                break;
            case 6:
                from = "Singapore";
                break;
            case 7:
                from = "Tokyo";
                break;
            case 8:
                from = "Beijing";
                break;
            case 9:
                from = "Sydney";
                break;
            case 10:
                from = "Auckland";
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }

        System.out.println("Select Arrival Airport:");
        int toChoice = sc.nextInt();
        switch (toChoice)
        {
            case 1:
                to = "New York";
                break;
            case 2:
                to = "London";
                break;
            case 3:
                to = "Italy";
                break;
            case 4:
                to = "Dubai";
                break;
            case 5:
                to = "Mumbai";
                break;
            case 6:
                to = "Singapore";
                break;
            case 7:
                to = "Tokyo";
                break;
            case 8:
                to = "Beijing";
                break;
            case 9:
                to = "Sydney";
                break;
            case 10:
                to = "Auckland";
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }

        System.out.println("Choose Class Preference: ");
        System.out.println("Press 1 for Economy ");
        System.out.println("Press 2 for Premium Economy");
        System.out.println("Press 3 for Business");
        System.out.println("Press 4 for First/Suites");

        int classChoice = sc.nextInt();
        double basePrice = 75000;

        switch (classChoice)
        {
            case 1:
                travelClass = "Economy";
                totalPrice = basePrice + (basePrice * 0.1);
                break;
            case 2:
                travelClass = "Premium Economy";
                totalPrice = basePrice + (basePrice * 0.2);
                break;
            case 3:
                travelClass = "Business";
                totalPrice = basePrice + (basePrice * 0.4);
                break;
            case 4:
                travelClass = "First/Suites";
                totalPrice = basePrice + (basePrice * 0.7);
                break;
            default:
                travelClass = "Economy";
                totalPrice = basePrice + (basePrice * 0.1);
                break;
        }

        System.out.println("Choose Time of Departure: ");
        System.out.println("Press 1 for Morning");
        System.out.println("Press 2 for Afternoon");
        System.out.println("Press 3 for Evening");
        System.out.println("Press 4 for Night");

        int timeChoice = sc.nextInt();

        switch (timeChoice)
        {
            case 1:
                departureTime = "Morning";
                break;
            case 2:
                departureTime = "Afternoon";
                break;
            case 3:
                departureTime = "Evening";
                break;
            case 4:
                departureTime = "Night";
                break;
            default:
                departureTime = "Morning";
                break;
        }

        System.out.print("Enter Number of Passengers: ");
        this.passengers = sc.nextInt();
        totalPrice *= passengers;

        for (int i = 0; i < passengers; i++)
        {
            System.out.print("Enter Passenger Name: ");
            sc.nextLine();
            String passengerName = sc.nextLine();

            System.out.print("Enter Passenger Age: ");
            int passengerAge = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Passport Number: ");
            String passportNumber = sc.nextLine();

            if (passengerAge <= 14 && passengers == 1)
            {
                System.out.println("Child traveling alone. Assistance added.");
                totalPrice += (totalPrice / 2);
            }

            System.out.println("Does the passenger need special assistance? (Yes/No)");
            if (sc.next().equalsIgnoreCase("yes"))
            {
                System.out.println("Special assistance added.");
                totalPrice += (totalPrice / 2);
            }

            System.out.println("Is the passenger a Student or Military Personnel? (Yes/No)");
            if (sc.next().equalsIgnoreCase("yes"))
            {
                System.out.println("Applying 20% discount.");
                totalPrice -= (totalPrice * 0.20);
            }
        }
    }

    void confirmBooking()
    {
        System.out.println("Total Price: " + totalPrice);
        System.out.println("Press 1 to Confirm");
        int confirm = sc.nextInt();

        if (confirm == 1)
        {
            paymentMenu();
        }
        else
        {
            System.out.println("Booking Cancelled.");
        }
    }

    void paymentMenu()
    {
        System.out.println("Processing payment for: " + totalPrice);
        System.out.println("Press 1 for Credit Card");
        System.out.println("Press 2 for UPI");
        System.out.println("Press 3 for Miles + Card");

        System.out.print("Choose Payment Method: ");
        int choice = sc.nextInt();
        switch (choice)
        {
            case 1:
                System.out.println("Enter bank name");
                String bankname=sc.next();
                System.out.println("Enter 3 digit Card CVV ");
                int cvv=sc.nextInt();
                System.out.println("Payment Successful");
                break;
            case 2:
                System.out.println("Enter bank name");
                bankname=sc.next();
                System.out.println("Enter 4 digit UPI pin ");
                int upin=sc.nextInt();
                System.out.println("Payment Successful");
                break;
            case 3:
                totalPrice=totalPrice-15000;
                System.out.println("Total = "+totalPrice);
                System.out.println("Enter 3 digit Card CVV for remaining amount");
                cvv=sc.nextInt();
                System.out.println("Payment Successful");
                break;
            default:
                System.out.println("Invalid Choice.");
                break;
        }
        System.out.println("Booking Confirmed!");
    }
}

class ExtraServices
{
    Scanner sc = new Scanner(System.in);
    int seatChoice, mealChoice;
    boolean extraBaggage = false;

    void seatSelection()
    {
        System.out.println("Choose Seat Type:");
        System.out.println("Press 1 for Aisle");
        System.out.println("Press 2 for Middle");
        System.out.println("Press 3 for Window");
        seatChoice = sc.nextInt();
        System.out.println("Seat selection confirmed!");
    }

    void mealSelection()
    {
        System.out.println("Choose Meal Preference:");
        System.out.println("Press 1 for Veg");
        System.out.println("Press 2 for Non-Veg");
        System.out.println("Press 3 for Vegan");
        mealChoice = sc.nextInt();
        System.out.println("Meal selection confirmed!");
    }

    void extraBaggageOption(FlightBooking booking)
    {
        System.out.println("Do you want extra baggage?");
        System.out.println("Press 1 for Yes");
        System.out.println("Press 2 for No");
        int choice = sc.nextInt();
        if (choice == 1)
        {
            extraBaggage = true;
            booking.totalPrice += (booking.totalPrice * 0.15);
            System.out.println("Extra baggage added. New total price: " + booking.totalPrice);
        }
    }

    void displayBookingDetails(Customer customer, FlightBooking booking)
    {
        System.out.println("--------------------------------------------------");
        System.out.println("               Booking Details                    ");
        System.out.println("--------------------------------------------------");
        System.out.println("Passenger Name: " + customer.name);
        System.out.println("Date of Birth: " + customer.dob);
        System.out.println("Mobile Number: " + customer.mobile);
        System.out.println("Membership ID: " + (customer.isMember ? customer.memberId : "Not a Member"));
        System.out.println("From: " + booking.from + " To: " + booking.to);
        System.out.println("Class Preference: " + booking.travelClass);
        System.out.println("Departure Time: " + booking.departureTime);
        System.out.println("Total Passengers: " + booking.passengers);
        System.out.println("Total Price: " + booking.totalPrice);
        System.out.println("Seat Number: " + seatChoice);
        System.out.println("Meal Preference: " + mealChoice);
        System.out.println("Extra Baggage: " + (extraBaggage ? "Yes" : "No"));
        System.out.println("--------------------------------------------------");
    }
}

class Main
{
    public static void main(String args[])
    {
        System.out.println("==================================================================");
        System.out.println("    Welcome to the Airline Reservation & Management System  ");
        System.out.println("==================================================================");
        Scanner sc = new Scanner(System.in);
        Customer customer = new Customer();
        FlightBooking flightBooking = new FlightBooking();
        ExtraServices extraServices = new ExtraServices();
        boolean fbooking = false;
        boolean a=true;

        while(a)
        {
            System.out.println("Main Menu:");
            System.out.println("Press 1 to Book Flight");
            System.out.println("Press 2 to Select Seat");
            System.out.println("Press 3 to Select Meal");
            System.out.println("Press 4 for Extra Baggage");
            System.out.println("Press 5 to Display Booking Details");
            System.out.println("Press 6 to Confirm Booking");
            System.out.println("Press 7 to Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    flightBooking.bookFlight(customer);
                    fbooking=true;
                    break;
                case 2:
                    if(fbooking==true)
                    {
                        extraServices.seatSelection();
                        break;
                    }
                    else
                    {
                        System.out.println("No Booking Found");
                        break;
                    }
                case 3:
                    if(fbooking==true)
                    {
                        extraServices.mealSelection();
                        break;
                    }
                    else
                    {
                        System.out.println("No Booking Found");
                        break;
                    }
                case 4:
                    if(fbooking==true)
                    {
                        extraServices.extraBaggageOption(flightBooking);
                        break;
                    }
                    else
                    {
                        System.out.println("No Booking Found");
                        break;
                    }
                case 5:
                    if(fbooking==true)
                    {
                        extraServices.displayBookingDetails(customer, flightBooking);
                        break;
                    }
                    else
                    {
                        System.out.println("No Booking Found");
                        break;
                    }
                case 6:
                    if(fbooking==true)
                    {
                        flightBooking.confirmBooking();
                        break;
                    }
                    else
                    {
                        System.out.println("No Booking Found");
                        break;
                    }
                case 7:
                    System.out.println("Thank you for using our airline reservation system.");
                    a=false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}