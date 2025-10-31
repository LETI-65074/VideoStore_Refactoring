package v0;

import java.util.Vector;

public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String _name) {
        this._name = _name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "Rental Record for " + getName() + "\n";

        for (Rental each : _rentals) {
            double thisAmount = each.getAmount();
            // pontos
            frequentRenterPoints += frequentRenterPointsFor(each);
            // linha do recibo
            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount = getTotalAmount(totalAmount, thisAmount);
        }

        // footer
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }

    private static double getTotalAmount(double totalAmount, double thisAmount) {
        totalAmount += thisAmount;
        return totalAmount;
    }

    // (opcional mas recomendado) extrair pontos
    private int frequentRenterPointsFor(Rental each) {
        int points = 1;
        if (each.getMovie().getPriceCode() == Movie.Code.NEW_RELEASE && each.getDaysRented() > 1)
            points++;
        return points;
    }
}
