import unittest


def rank(key, a):
    return rank_helper(key, a, 0, len(a) - 1)


def rank_helper(key, a, lo, hi):
    if lo > hi:
        return -1

    mid = (lo + hi) // 2

    if key < a[mid]:
        return rank_helper(key, a, lo, mid - 1)
    elif key > a[mid]:
        return rank_helper(key, a, mid + 1, hi)
    else:
        return mid


class RankTest(unittest.TestCase):
    @staticmethod
    def test_rank1():
        assert rank(1, [1, 10, 100]) == 0

    @staticmethod
    def test_rank2():
        assert rank(10, [1, 10, 100]) == 1

    @staticmethod
    def test_rank3():
        assert rank(100, [1, 10, 100]) == 2

    @staticmethod
    def test_rank4():
        assert rank(1000, [1, 10, 100]) == -1


if __name__ == '__main__':
    unittest.main()
