#!/usr/bin/python
from __future__ import print_function
import collections
import random

import sys


class Node(collections.Iterable):

    class NodeIterator:
        def __init__(self, start):
            self.current = start

    def __init__(self, element=None, next_node=None):
        self.element = element
        self.next_node = next_node

    def __eq__(self, other):
        return self.element == other

    def __iter__(self):
        current = self
        while current is not None:
            yield current
            current = current.next_node


class Dictionary:
    def __init__(self, length):
        self.del_count = 0
        self.total_deletions = 0

        self.insert_count = 0
        self.total_insertions = 0

        self.length = length
        self.elements = [None] * length

    def __getitem__(self, item):
        return self.elements[item]

    def __setitem__(self, item, vue):
        self.elements[item] = vue

    def __contains__(self, item):
        return self.member(item)

    def hash(self, v):
        return hash(v) % self.length

    def insert(self, v):
        if v not in self:
            hsh = self.hash(v)

            current_head = self[hsh]
            node = Node(element=v, next_node=current_head)
            self[hsh] = node

    def delete(self, v):
        iter_count = 1

        hsh = self.hash(v)

        if self[hsh] != v:
            node = self[hsh]

            for nxt in node:
                if nxt == v:
                    if nxt.next_node is not None:
                        nxt.next_node = nxt.next_node.next_node
                    break

                iter_count += 1

        self.del_count += iter_count
        self.total_deletions += 1

    def member(self, v):
        iter_count = 1

        hsh = self.hash(v)

        node = self[hsh]

        if node is None:
            self.insert_count += 1
            self.total_insertions += 1
            return False

        for nxt in node:
            if nxt == v:
                self.insert_count += iter_count
                self.total_insertions += 1
                return True

            iter_count += 1

        self.insert_count += iter_count
        self.total_insertions += 1

        return False


if __name__ == '__main__':

    rand_numbers = []

    for i in range(10000):
        rand_numbers.append(random.randint(0, sys.maxint))

    print('Buckets & Insert Count & Deletion Count & Average Insertion & Average Deletion')
    for i in range(500, 20000, 500):
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

