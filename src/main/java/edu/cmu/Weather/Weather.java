package edu.cmu.Weather;

// API Design Fix: Replaced ambiguous boolean parameter with enum for better clarity.
// Using LengthScale enum instead of boolean 'inches' makes the API more self-documenting and less error-prone.
public class Weather {
    public enum LengthScale {
        INCHES, MILLIMETERS
    }
    
    private WeatherService weatherService;
    private LengthScale lengthScale;

    /**
     * Sets the length scale for rainfall measurements.
     *
     * @param lengthScale the desired length scale (INCHES or MILLIMETERS)
     */
    public void setLengthScale(LengthScale lengthScale) {
        this.lengthScale = lengthScale;
    }

    /**
     * Retrieves the rainfall measurement over the last 24 hours from the weather service in the preferred scale.
     * 
     * @return the rainfall amount in the scale set by setLengthScale
     */
    public double getRainfall() {
        double wsRainfall = weatherService.getRainfall();
        if (lengthScale == LengthScale.INCHES) {
            return wsRainfall / 25.4;
        } else {
            return wsRainfall;
        }
    }
}
