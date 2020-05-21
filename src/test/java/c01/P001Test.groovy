package c01

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author moqi* On 5/21/20 21:20
 */
@Unroll
class P001Test extends Specification {
    def "input #p and #q, output #result"() {
        expect:
        P001.gcd(p, q) == result

        where:
        p  | q | result
        10 | 7 | 1
        12 | 8 | 4
    }
}
