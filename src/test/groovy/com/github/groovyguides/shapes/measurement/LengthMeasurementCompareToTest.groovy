package com.github.groovyguides.shapes.measurement

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

/**
 *
 *
 * @author Duncan Dickinson
 */
@Unroll
@Subject(LengthMeasurement)
class LengthMeasurementCompareToTest extends Specification {
    def "The compareTo method for two Measurements with values (#left, #right) will return the correct answer (#answer)"() {
        given: "two measurements"
        LengthMeasurement lhs = new LengthMeasurement(left, UnitOfLength.MILLIMETRE)
        LengthMeasurement rhs = new LengthMeasurement(right, UnitOfLength.MILLIMETRE)

        when: "the two measurements are compared"
        def result = lhs <=> rhs

        then: "compareTo will result in the correct answer"
        answer == result

        where:
        left | right || answer
        1    | 1     || 0
        10   | 1     || 1
        1    | 10    || -1
    }

    def "The compareTo method for two Measurements will fail when they have different UoM (#left, #right)"() {
        given: "two measurements"
        LengthMeasurement lhs = new LengthMeasurement(10, left)
        LengthMeasurement rhs = new LengthMeasurement(10, right)

        when: "the two measurements are compared"
        Exception e = null
        try {
            lhs <=> rhs
        } catch (any) {
            e = any
        }

        then: "compareTo will throw an IllegalArgumentException"
        e instanceof IllegalArgumentException

        where:
        left                    | right
        UnitOfLength.MILLIMETRE | UnitOfLength.INCH
        UnitOfLength.INCH       | UnitOfLength.MILLIMETRE
    }
}
