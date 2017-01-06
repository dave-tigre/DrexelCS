#!/usr/bin/python
from __future__ import print_function
import collections
import random

import sys


class Marker:
    pass


EMPTY = Marker()
DELETED = Marker()


class Dictionary:
    def __init__(self, length):
        self.del_count = 0
        self.total_deletions = 0

        self.insert_count = 0
        self.total_insertions = 0

        self.length = length
        self.elements = [EMPTY] * length

    def __getitem__(self, item):
        return self.elements[item]

    def __setitem__(self, item, vue):
        self.elements[item] = vue

    def hash(self, v):
        return hash(v) % self.length

    def locate(self, v):
        hsh = self.hash(v)

        i = 0
        while i < self.length:
            tv = self[self.hash(hsh + i)]

            if tv == v:
                break

            if tv == EMPTY:
                break

            i += 1

        return self.hash(hsh + i), i + 1

    def locate1(self, v):
        hsh = self.hash(v)

        i = 0
        while i < self.length:
            tv = self[self.hash(hsh + i)]

            if tv == v:
                break

            if tv == DELETED:
                break

            if tv == EMPTY:
                break

            i += 1

        return self.hash(hsh + i), i + 1

    def insert(self, v):
        loc, iter = self.locate(v)

        if self[loc] == v:
            return

        loc, iter = self.locate1(v)

        if not (self[loc] == EMPTY or self[loc] == DELETED):
            raise Exception('Table Full')

        self[loc] = v
        self.total_insertions += 1
        self.insert_count += iter

    def delete(self, v):
        loc, iter = self.locate(v)

        if self[loc] == v:
            self[loc] = DELETED

            self.total_deletions += 1
            self.del_count += iter


if __name__ == '__main__':

    rand_numbers = []

    for i in range(2000):
        rand_numbers.append(random.randint(0, sys.maxint))

    print('Buckets & Insert Count & Deletion Count & Average Insertion & Average Deletion')
    for i in range(2000, 22000, 500):
        dict = Dictionary(i)

        for num in rand_numbers:
            dict.insert(num)

        for num in rand_numbers:
            dict.delete(num)

        avg_insert = float(dict.insert_count) / dict.total_insertions
        avg_del = float(dict.del_count) / dict.total_deletions

        print('{} & {} & {} & {} & {}'.format(i,
                                              dict.insert_count,
                                              dict.del_count,
                                              avg_insert,
                                              avg_del))

