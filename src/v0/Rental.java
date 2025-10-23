package v0;

public class Rental
{
	private Movie	_movie;
	private int		_daysRented;

	public Rental(Movie movie, int daysRented)
	{
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented()
	{
		return _daysRented;
	}

	public Movie getMovie()
	{
		return _movie;
	}

    public double getAmount() {
        double result = 0.0;
        switch (getMovie().getPriceCode()) {
            case REGULAR:
                result += 2;
                if (getDaysRented() > 2)
                    result += (getDaysRented() - 2) * 1.5;
                break;
            case NEW_RELEASE:
                result += getDaysRented() * 3;
                break;
            case CHILDRENS:
                result += 1.5;
                if (getDaysRented() > 3)
                    result += (getDaysRented() - 3) * 1.5;
                break;
            case BEST_PRICE: // 👈 só mantém se existir no teu enum
                result += 1.0;
                break;
        }
        return result;
    }
}
