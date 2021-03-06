package com.github.groovyguides.shapes.measurement

/**
 * A helper subclass of LengthMeasurement
 *
 * @author Duncan Dickinson
 */
class Inch extends LengthMeasurement {

    Inch(Number value) {
        super(value, UnitOfLength.INCH)
    }
}
