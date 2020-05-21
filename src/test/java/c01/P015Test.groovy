package c01

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author moqi* On 5/21/20 22:34
 */
@Unroll
class P015Test extends Specification {

    def "input #key and #a, output #result"() {
        expect:
        P015.rank(key, a) == result

        where:
        key  | a                     | result
        1    | [1, 10, 100] as int[] | 0
        10   | [1, 10, 100] as int[] | 1
        100  | [1, 10, 100] as int[] | 2
        1000 | [1, 10, 100] as int[] | -1
    }

}
