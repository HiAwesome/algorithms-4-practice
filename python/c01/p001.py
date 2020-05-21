import unittest


def gcd(p: int, q: int):
    if q == 0:
        return p

    return gcd(q, p % q)


class GcdTest(unittest.TestCase):
    def test_gcd(self):
        self.assertEqual(gcd(12, 8), 4)


if __name__ == '__main__':
    unittest.main()
